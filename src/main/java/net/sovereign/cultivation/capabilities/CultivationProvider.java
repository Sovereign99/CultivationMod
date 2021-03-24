package net.sovereign.cultivation.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.sovereign.cultivation.cultivation.ICultivation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CultivationProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(ICultivation.class)
    public static Capability<ICultivation> CULTIVATION_CAP = null;

    private LazyOptional<ICultivation> instance = LazyOptional.of(CULTIVATION_CAP::getDefaultInstance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CULTIVATION_CAP ? instance.cast() : LazyOptional.empty();
    }


    @Override
    public INBT serializeNBT() {
        return CULTIVATION_CAP.getStorage().writeNBT(CULTIVATION_CAP, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        CULTIVATION_CAP.getStorage().readNBT(CULTIVATION_CAP, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null, nbt);
    }
}
