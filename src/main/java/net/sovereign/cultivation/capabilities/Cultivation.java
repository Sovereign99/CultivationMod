package net.sovereign.cultivation.capabilities;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.setup.network.CultivationPacket;
import net.sovereign.cultivation.setup.network.PacketHandler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;


public class Cultivation implements ICultivation, ICapabilitySerializable<CompoundNBT> {
    @CapabilityInject(ICultivation.class)
    public static Capability<ICultivation> CULTIVATION_CAP = null;
    public static ResourceLocation NAME = new ResourceLocation(CultivationMod.MOD_ID, "cultivation");

    public static final String NBT_CULTIVATION = "CultivationAmount";

    private final LazyOptional<ICultivation> holder = LazyOptional.of(() -> this);

    private final ArrayList<CultivationSubLevel> subLevels = new ArrayList<>();
    private double cultivationAmount;
    private CultivationSubLevel currentSubLevel;
    private int timer;

    public Cultivation() {
        this.cultivationAmount = 0.0;
        this.timer = 0;

        /* I know these seem like unreasonably big numbers, considering the current bosses
        are only worth 10,000, but I do plan on adding custom entities worth more */
            // Mortal levels
        subLevels.add(new CultivationSubLevel(0, "Soldier", 0, 3440));
        subLevels.add(new CultivationSubLevel(1, "Knight", 3440, 6289));
        subLevels.add(new CultivationSubLevel(2, "Count", 6289, 10867));
            // Immortal levels
        subLevels.add(new CultivationSubLevel(3, "Duke", 10867, 18780));
        subLevels.add(new CultivationSubLevel(4, "King", 18780, 32454));
        subLevels.add(new CultivationSubLevel(5, "Emperor", 32454, 56081));
            // Divine levels
        subLevels.add(new CultivationSubLevel(6, "Demigod", 56081, 96907));
        subLevels.add(new CultivationSubLevel(7, "God", 96907, 167458));
        subLevels.add(new CultivationSubLevel(8, "Highgod", 167458, 289367));
    }

    // Subtract the given amount from the total cultivation. Will not go below 0
    @Override
    public void decreaseCultivationAmount(double amount) {
        this.cultivationAmount = Math.max(cultivationAmount - amount, 0);
    }

    // Increase total cultivation by the given amount
    @Override
    public void increaseCultivationAmount(double amount) {
        this.cultivationAmount += amount;
    }

    // Sets the total cultivation to the given amount
    // Syncs sub level with new cultivation
    @Override
    public void setCultivationAmount(double amount) {
        this.cultivationAmount = amount;
        checkSubLevel();
    }

    // Returns the total cultivation amount
    @Override
    public double getCultivationAmount() {
        return this.cultivationAmount;
    }

    // Uses the total cultivation amount to determine which sub level
    // the player fits into
    // Called every time cultivation changes
    public void checkSubLevel() {
        for(int i = subLevels.size() - 1; i >= 0; i--) {
            if(cultivationAmount > subLevels.get(i).getLevelStart()) {
                this.currentSubLevel = subLevels.get(i);
                currentSubLevel.checkRank();
                return;
            }
        }
    }

    // Returns the sub level
    public CultivationSubLevel getSubLevel() {
        return this.currentSubLevel;
    }

    // Modifier gets. I can't seem to get these numbers right, lots of fiddling
    @Override
    public double getStrength() {
        return (cultivationAmount / 100) * 0.5;
    }

    @Override
    public double getAgility() {
        return (cultivationAmount / 100) * 0.06;
    }

    @Override
    public double getArmor() {
        return (cultivationAmount / 100) * 0.04;
    }

    // Advances timer. Used to keep track of when to apply modifiers and sync sub level
    // Prevents them from being called every tick, usually no more than once per second
    @Override
    public void advTimer() {
        this.timer++;
    }

    // Returns the current timer
    @Override
    public int getTimer() {
        return this.timer;
    }

    // Sets timer back to zero
    @Override
    public void resetTimer() {
        this.timer = 0;
    }

    // Called to sync cultivation between server and client
    @Override
    public void sync(ServerPlayerEntity player) {
        if (player != null) {
            PacketHandler.sendTo(new CultivationPacket(getCultivationAmount()), player);
        }
    }

    // Checks if a new capability needs to be attached (just first-time login at the moment)
    public static boolean attach(ICapabilityProvider entity) {
        if(!(entity instanceof PlayerEntity)) {
            return false;
        }

        try {
            if(entity.getCapability(CULTIVATION_CAP).isPresent()) {
                return false;
            }
        } catch (NullPointerException exception){
            CultivationMod.LOGGER.error("Failed to get capabilities");
            return false;
        }

        return true;
    }

    // Provider methods
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return CULTIVATION_CAP.orEmpty(cap, holder);
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putDouble(NBT_CULTIVATION, cultivationAmount);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        cultivationAmount = nbt.getDouble(NBT_CULTIVATION);
    }

    // Register capability
    public static void register() {
        CapabilityManager.INSTANCE.register(ICultivation.class, new Storage(), Cultivation::new);
    }

    private static class Storage implements Capability.IStorage<ICultivation> {

        @Nullable
        @Override
        public INBT writeNBT(Capability<ICultivation> capability, ICultivation instance, Direction side) {
            if (instance instanceof Cultivation) {
                return ((Cultivation) instance).serializeNBT();
            }

            return new CompoundNBT();
        }

        @Override
        public void readNBT(Capability<ICultivation> capability, ICultivation instance, Direction side, INBT nbt) {
            if (instance instanceof Cultivation) {
                ((Cultivation) instance).deserializeNBT((CompoundNBT) nbt);
            }
        }
    }

    public class CultivationSubLevel {
        private final int index;
        private final String levelName;
        private final int levelStart;
        private final int levelEnd;

        public CultivationSubLevel(int index, String levelName, int levelStart, int levelEnd) {
            this.index = index;
            this.levelName = levelName;
            this.levelStart = levelStart;
            this.levelEnd = levelEnd;
        }

        public int getIndex() {
            return this.index;
        }

        public String getLevelName() {
            return this.levelName;
        }

        public int getLevelStart() {
            return this.levelStart;
        }

        public int getLevelEnd() {
            return this.levelEnd;
        }

        // Bases current rank (0, 1, 2 - representing low, mid, high) off of
        // progress through the current sub level
        public int checkRank() {
            double diff = getDiff();
            double progress = getProgress();
            if ((progress / diff) < 0.34) {
                return 0;
            } else if ((progress / diff) < 0.67) {
                return 1;
            }

            return 2;
        }

        // Calculates the difference between the sub level's start and end values
        // Essentially the total cultivation to progress through the sub level
        public double getDiff() {
            return getLevelEnd() - getLevelStart();
        }

        // Calculates the progress -through the current sub level-
        public double getProgress() {
            return getCultivationAmount() - getLevelStart();
        }

        // Used for the GUI overlay to make the numbers small and easy to work with
        // Just cuts numbers off the back until it's below 100
        public int round(double num) {
            while(num > 100) {
                num = num / 10;
            }

            return (int) num;
        }

        // Returns the progress-specific title for the sub level
        public String getRank() {
            int checkRank = checkRank();
            if (checkRank == 0) {
                return "Low-Rank ";
            } else if (checkRank == 1) {
                return "Mid-Rank ";
            }

            return "High-Rank ";
        }
    }
}
