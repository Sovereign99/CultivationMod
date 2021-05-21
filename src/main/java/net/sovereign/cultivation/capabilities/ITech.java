package net.sovereign.cultivation.capabilities;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;

public interface ITech {
    public int getTech();
    public int getProficiency();

    public void setTech(int tech);
    public void increaseProficiency(int addPro);
    public void decreaseProficiency(int decPro);
    public void setProficiency(int pro);

    public void removeTech();

    public void copy(ITech tech);

    public void sync(ServerPlayerEntity player);

    public CompoundNBT serializeNBT();

    public void deserializeNBT(CompoundNBT nbt);
}
