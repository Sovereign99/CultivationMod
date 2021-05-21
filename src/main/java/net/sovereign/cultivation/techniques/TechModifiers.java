package net.sovereign.cultivation.techniques;

public class TechModifiers {
    public final double strength;
    public final double agility;
    public final double armor;

    public TechModifiers(double strength, double agility, double armor) {
        this.strength = strength;
        this.agility = agility;
        this.armor = armor;
    }

    public TechModifiers add(TechModifiers modifiers) {
        return new TechModifiers(modifiers.strength + strength, modifiers.agility + agility, modifiers.armor + armor);
    }

    public TechModifiers multiply(double amount) {
        return new TechModifiers(strength * amount, agility * amount, armor * amount);
    }
}
