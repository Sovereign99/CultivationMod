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
import net.sovereign.cultivation.setup.network.PacketHandler;
import net.sovereign.cultivation.setup.network.TechPacket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Tech implements ITech, ICapabilitySerializable<CompoundNBT> {
    @CapabilityInject(ITech.class)
    public static Capability<ITech> TECH_CAP = null;
    public static ResourceLocation NAME = new ResourceLocation(CultivationMod.MOD_ID, "tech");
    public static final String NBT_TECH = "Technique";
    public static final String NBT_PRO = "Proficiency";
    private final LazyOptional<ITech> holder = LazyOptional.of(() -> this);

    private int tech;
    private int proficiency;

    public Tech() {
        tech = 0;
        proficiency = 0;
    }

    @Override
    public int getTech() {
        return tech;
    }

    @Override
    public int getProficiency() {
        return proficiency;
    }

    @Override
    public void setTech(int tech) {
        this.tech = tech;
    }

    @Override
    public void increaseProficiency(int addPro) {
        proficiency += addPro;
    }

    @Override
    public void decreaseProficiency(int decPro) {
        proficiency -= decPro;
    }

    @Override
    public void setProficiency(int pro) {
        proficiency = pro;
    }

    @Override
    public void removeTech() {
        tech = 0;
    }

    @Override
    public void copy(ITech tech) {
        this.tech = tech.getTech();
        this.proficiency = tech.getProficiency();
    }

    public void sync(ServerPlayerEntity player) {
        if (player != null) {
            PacketHandler.sendTo(new TechPacket(serializeNBT()), player);
        }
    }

    public static boolean attach(ICapabilityProvider entity) {
        if(!(entity instanceof PlayerEntity)) {
            return false;
        }

        try {
            if(entity.getCapability(TECH_CAP).isPresent()) {
                return false;
            }
        } catch (NullPointerException exception){
            CultivationMod.LOGGER.error("Failed to get capabilities");
            return false;
        }

        return true;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return TECH_CAP.orEmpty(cap, holder);
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt(NBT_TECH, tech);
        nbt.putInt(NBT_PRO, proficiency);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        tech = nbt.getInt(NBT_TECH);
        proficiency = nbt.getInt(NBT_PRO);
    }

    public static void register() {
        CapabilityManager.INSTANCE.register(ITech.class, new Tech.Storage(), Tech::new);
    }

    private static class Storage implements Capability.IStorage<ITech> {
        @Nullable
        @Override
        public INBT writeNBT(Capability<ITech> capability, ITech instance, Direction side) {
            if (instance instanceof Tech) {
                return instance.serializeNBT();
            }

            return new CompoundNBT();
        }

        @Override
        public void readNBT(Capability<ITech> capability, ITech instance, Direction side, INBT nbt) {
            if (instance instanceof Tech) {
                instance.deserializeNBT((CompoundNBT) nbt);
            }
        }
    }
}
