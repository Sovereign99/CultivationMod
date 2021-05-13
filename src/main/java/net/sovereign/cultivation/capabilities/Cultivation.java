package net.sovereign.cultivation.capabilities;


public class Cultivation implements ICultivation {

    private double cultivationAmount;
    private int timer;

    public Cultivation() {
        this.cultivationAmount = 0.0;
        this.timer = 0;
    }

    @Override
    public void decreaseCultivationAmount(double amount) {
        this.cultivationAmount -= amount;

        if(cultivationAmount < 0.0F) this.cultivationAmount = 0.0F;
    }

    @Override
    public void increaseCultivationAmount(double amount) {
        this.cultivationAmount += amount;
    }

    @Override
    public void setCultivationAmount(double amount) {
        this.cultivationAmount = amount;
    }

    @Override
    public double getCultivationAmount() {
        return this.cultivationAmount;
    }

    @Override
    public double getStrength() {
        double strMod = cultivationAmount * 0.1;
        return Math.max(strMod, 1);
    }

    @Override
    public double getAgility() {
        double agiMod = cultivationAmount * 0.08;
        return Math.max(agiMod, 1);
    }

    @Override
    public double getArmor() {
        double resMod = cultivationAmount * 0.03;
        return Math.max(resMod, 1);
    }

    @Override
    public void copy(ICultivation cultivation) {
        this.setCultivationAmount(cultivation.getCultivationAmount());
    }

    @Override
    public void advTimer() {
        this.timer++;
    }

    @Override
    public int getTimer() {
        return this.timer;
    }

    @Override
    public void resetTimer() {
        this.timer = 0;
    }
}
