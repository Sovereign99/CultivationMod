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


public class Cultivation implements ICultivation, ICapabilitySerializable<CompoundNBT> {
    @CapabilityInject(ICultivation.class)
    public static Capability<ICultivation> CULTIVATION_CAP = null;
    public static ResourceLocation NAME = new ResourceLocation(CultivationMod.MOD_ID, "cultivation");

    public static final String NBT_CULTIVATION = "CultivationAmount";

    private final LazyOptional<ICultivation> holder = LazyOptional.of(() -> this);

    private double cultivationAmount;
    private int timer;

    public Cultivation() {
        this.cultivationAmount = 0.0;
        this.timer = 0;
    }

    @Override
    public void decreaseCultivationAmount(double amount) {
        this.cultivationAmount -= amount;

        if(cultivationAmount < 0.0F) this.cultivationAmount = 0.0F;
    }

    @Override
    public void increaseCultivationAmount(double amount) {
        this.cultivationAmount += amount;
    }

    @Override
    public void setCultivationAmount(double amount) {
        this.cultivationAmount = amount;
    }

    @Override
    public double getCultivationAmount() {
        return this.cultivationAmount;
    }

    @Override
    public double getStrength() {
        return (cultivationAmount / 100);
    }

    @Override
    public double getAgility() {
        return (cultivationAmount / 100) * 0.06;
    }

    @Override
    public double getArmor() {
        return (cultivationAmount / 100) * 0.04;
    }

    @Override
    public void advTimer() {
        this.timer++;
    }

    @Override
    public int getTimer() {
        return this.timer;
    }

    @Override
    public void resetTimer() {
        this.timer = 0;
    }

    @Override
    public void sync(ServerPlayerEntity player) {
        if (player instanceof ServerPlayerEntity) {
            PacketHandler.sendTo(new CultivationPacket(getCultivationAmount()), player);
        }
    }

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

    public static void register() {
        CapabilityManager.INSTANCE.register(ICultivation.class, new Storage(), Cultivation::new);
    }

    public static class Storage implements Capability.IStorage<ICultivation> {

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
}
