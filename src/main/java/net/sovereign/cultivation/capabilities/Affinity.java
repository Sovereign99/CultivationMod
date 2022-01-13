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
import net.sovereign.cultivation.setup.network.AffinityPacket;
import net.sovereign.cultivation.setup.network.PacketHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Affinity implements IAffinity, ICapabilitySerializable<CompoundNBT> {
    @CapabilityInject(IAffinity.class)
    public static Capability<IAffinity> AFFINITY_CAP = null;
    public static ResourceLocation NAME = new ResourceLocation(CultivationMod.MOD_ID, "affinity");
    public static String NBT_AFFINITY = "Affinity";
    public static String NBT_ORBED = "Orb";
    private final LazyOptional<IAffinity> holder = LazyOptional.of(() -> this);

    private int affinity;
    //Whether player has used the Affinity Orb
    private boolean orbed;

    // There are 6 possible elemental affinities, as well as no affinity (0)
    // Affinities are, in order, fire, water, earth, air, light, dark
    public Affinity() {
        affinity = 0;
        orbed = false;
    }


    @Override
    public int getAffinity() {
        return this.affinity;
    }

    // Sets affinity to no affinity
    @Override
    public void removeAffinity() {
        this.affinity = 0;
    }

    @Override
    public void setAffinity(int affinity) {
        this.affinity = affinity;
    }

    public boolean getOrbed() {
        return orbed;
    }

    public void setOrbed(boolean orbed) {
        this.orbed = orbed;
    }

    public String getAffinityName() {
        switch (affinity) {
            case 1:
                return "FIRE";
            case 2:
                return "WATER";
            case 3:
                return "EARTH";
            case 4:
                return "AIR";
            case 5:
                return "LIGHT";
            case 6:
                return "DARK";
        }
        return "NONE";
    }

    public void sync(ServerPlayerEntity player) {
        if (player != null) {
            PacketHandler.sendTo(new AffinityPacket(serializeNBT()), player);
        }
    }

    public static boolean attach(ICapabilityProvider entity) {
        if(!(entity instanceof PlayerEntity)) {
            return false;
        }

        try {
            if(entity.getCapability(AFFINITY_CAP).isPresent()) {
                return false;
            }
        } catch (NullPointerException exception){
            CultivationMod.LOGGER.error("Failed to get capabilities");
            return false;
        }

        return true;
    }

    // Provider methods
    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return AFFINITY_CAP.orEmpty(cap, holder);
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt(NBT_AFFINITY, affinity);
        nbt.putBoolean(NBT_ORBED, orbed);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        affinity = nbt.getInt(NBT_AFFINITY);
        orbed = nbt.getBoolean(NBT_ORBED);
    }

    public static void register() {
        CapabilityManager.INSTANCE.register(IAffinity.class, new Storage(), Affinity::new);
    }

    private static class Storage implements Capability.IStorage<IAffinity> {
        @Nullable
        @Override
        public INBT writeNBT(Capability<IAffinity> capability, IAffinity instance, Direction side) {
            if (instance instanceof Affinity) {
                return instance.serializeNBT();
            }

            return new CompoundNBT();
        }

        @Override
        public void readNBT(Capability<IAffinity> capability, IAffinity instance, Direction side, INBT nbt) {
            if (instance instanceof Affinity) {
                instance.deserializeNBT((CompoundNBT) nbt);
            }
        }
    }
}
