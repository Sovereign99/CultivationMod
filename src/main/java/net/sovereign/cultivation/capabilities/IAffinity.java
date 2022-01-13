package net.sovereign.cultivation.capabilities;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;

public interface IAffinity {
    int getAffinity();
    void removeAffinity();
    void setAffinity(int affinity);

    boolean getOrbed();
    void setOrbed(boolean orbed);

    String getAffinityName();

    void sync(ServerPlayerEntity player);

    CompoundNBT serializeNBT();

    void deserializeNBT(CompoundNBT nbt);
}
