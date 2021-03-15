package net.sovereign.cultivation.capabilities;

import com.google.common.base.Optional;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullLazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.sovereign.cultivation.cultivation.ICultivation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CultivationProvider implements ICapabilitySerializable<INBT> {
    @CapabilityInject(ICultivation.class)
    public static final Capability<ICultivation> CULTIVATION_CAP = null;

    @SuppressWarnings({"ConstantConditions", "FieldMayBeFinal"})
    private ICultivation instance = CULTIVATION_CAP.getDefaultInstance();

    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable Direction side) {
        return capability == CULTIVATION_CAP;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CULTIVATION_CAP ? LazyOptional.of((NonNullSupplier<T>) Optional.fromNullable(this.instance)) : null;
    }

    @Override
    public INBT serializeNBT() {
        return CULTIVATION_CAP.getStorage().writeNBT(CULTIVATION_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        CULTIVATION_CAP.getStorage().readNBT(CULTIVATION_CAP, this.instance, null, nbt);
    }
}
