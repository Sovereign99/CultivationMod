package net.sovereign.cultivation.capabilities;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;

public interface IAffinity {
    public int getAffinity();
    public void assignAffinity();
    public void removeAffinity();
    public void setAffinity(int affinity);

    public boolean getOrbed();
    public void setOrbed(boolean orbed);

    public String getAffinityName();

    public void sync(ServerPlayerEntity player);

    public CompoundNBT serializeNBT();

    public void deserializeNBT(CompoundNBT nbt);
}
