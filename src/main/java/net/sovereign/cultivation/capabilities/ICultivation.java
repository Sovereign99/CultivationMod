package net.sovereign.cultivation.capabilities;

import net.minecraft.entity.player.ServerPlayerEntity;

public interface ICultivation {
    public void decreaseCultivationAmount(double amount);
    public void increaseCultivationAmount(double amount);
    public void setCultivationAmount(double amount);

    public double getCultivationAmount();

    public void checkSubLevel();
    public Cultivation.CultivationSubLevel getSubLevel();

    public double getStrength();
    public double getAgility();
    public double getArmor();

    public void advTimer();
    public int getTimer();
    public void resetTimer();

    public void sync(ServerPlayerEntity player);
}
