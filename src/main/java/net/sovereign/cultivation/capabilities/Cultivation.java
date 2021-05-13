package net.sovereign.cultivation.capabilities;


public class Cultivation implements ICultivation {

    private float cultivationAmount = 0.0F;

    @Override
    public void decreaseCultivationAmount(float amount) {
        this.cultivationAmount -= amount;

        if(cultivationAmount < 0.0F) this.cultivationAmount = 0.0F;
    }

    @Override
    public void increaseCultivationAmount(float amount) {
        this.cultivationAmount += amount;
    }

    @Override
    public void setCultivationAmount(float amount) {
        this.cultivationAmount = amount;
    }

    @Override
    public float getCultivationAmount() {
        return this.cultivationAmount;
    }

    @Override
    public int getStrength() {
        int strMod = (int) (cultivationAmount / 1000) + (int) ((cultivationAmount / 1000) % 2) + 1;
        if(strMod >= 1) {
            return strMod;
        }

        return 1;
    }

    @Override
    public int getAgility() {
        return 0;
    }

    @Override
    public int getArmor() {
        return 0;
    }
}
