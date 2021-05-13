package net.sovereign.cultivation.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import org.jetbrains.annotations.Nullable;

public class CultivationStorage implements Capability.IStorage<ICultivation> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<ICultivation> capability, ICultivation instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putDouble("cultivation", instance.getCultivationAmount());
        return tag;
    }

    @Override
    public void readNBT(Capability<ICultivation> capability, ICultivation instance, Direction side, INBT nbt) {
        CompoundNBT tag = new CompoundNBT();
        instance.setCultivationAmount(tag.getFloat("cultivation"));
    }
}
