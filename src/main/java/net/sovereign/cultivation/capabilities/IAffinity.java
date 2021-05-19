package net.sovereign.cultivation.capabilities;

import net.minecraft.entity.player.ServerPlayerEntity;

public interface IAffinity {
    public int getAffinity();
    public void assignAffinity();
    public void removeAffinity();
    public void setAffinity(int affinity);

    public String getAffinityName();

    public void sync(ServerPlayerEntity player);
}
