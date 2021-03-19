package net.sovereign.cultivation.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.sovereign.cultivation.cultivation.CultivationLevel;
import net.sovereign.cultivation.cultivation.ICultivation;

import javax.annotation.Nullable;

public class CultivationStorage implements Capability.IStorage<ICultivation> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<ICultivation> capability, ICultivation instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("levelBody", instance.getCultivationLevel().levelName);
        tag.putDouble("bodyProgress", instance.getBaseProgress());
        return tag;
    }

    @Override
    public void readNBT(Capability<ICultivation> capability, ICultivation instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setLevel(CultivationLevel.getLevelInListByName(CultivationLevel.DEFAULTS, tag.getString("levelBody")));
        instance.setBaseProgress(tag.getDouble("bodyProgress"));
    }
}
