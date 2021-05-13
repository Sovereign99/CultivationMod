package net.sovereign.cultivation.capabilities;

public interface ICultivation {
    public void decreaseCultivationAmount(double amount);
    public void increaseCultivationAmount(double amount);
    public void setCultivationAmount(double amount);

    public double getCultivationAmount();

    public double getStrength();
    public double getAgility();
    public double getArmor();

    public void copy(ICultivation cultivation);

    public void advTimer();
    public int getTimer();
    public void resetTimer();
}
