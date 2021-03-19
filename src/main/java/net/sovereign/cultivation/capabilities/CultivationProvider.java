package net.sovereign.cultivation.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.sovereign.cultivation.cultivation.ICultivation;

import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CultivationProvider implements ICapabilitySerializable<INBT> {

    private Supplier<ICultivation> cultivationSupplier;

    @CapabilityInject(ICultivation.class)
    public static Capability<ICultivation> CULTIVATION_CAP = null;

    public CultivationProvider() {
        this(() -> CULTIVATION_CAP.getDefaultInstance());
    }

    CultivationProvider(Supplier<ICultivation> sup) {
        this.cultivationSupplier = sup;
    }

    private LazyOptional<ICultivation> instance = LazyOptional.of(() -> cultivationSupplier.get());

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == CULTIVATION_CAP ? instance.cast() : LazyOptional.empty();
    }


    @Override
    public INBT serializeNBT() {
        return CULTIVATION_CAP.getStorage().writeNBT(CULTIVATION_CAP, instance.cast(), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {

    }
}
