package net.sovereign.cultivation.capabilities;

public interface ICultivation {
    public void decreaseCultivationAmount(float amount);
    public void increaseCultivationAmount(float amount);
    public void setCultivationAmount(float amount);

    public float getCultivationAmount();
}
