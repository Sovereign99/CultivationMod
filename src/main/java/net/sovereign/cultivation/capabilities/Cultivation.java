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
}
