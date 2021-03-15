package net.sovereign.cultivation.cultivation;

public class Cultivation implements ICultivation {
    private CultivationLevel currentLevel;
    private int cultivationProgress;
    private int timer;
    private float maxSpeed;
    private float jumpLimit;


    public Cultivation() {
        this.currentLevel = CultivationLevel.DEFAULTS.get(0);
        this.cultivationProgress = 0;
        this.timer = 0;
        this.maxSpeed = 5.0f;
        this.jumpLimit = 10.0f;
    }

    @Override
    public void addBaseProgress(double amount) {

    }

    @Override
    public void setBaseProgress(double amount) {

    }

    @Override
    public void setLevel(CultivationLevel level) {
        this.currentLevel = level;
    }

    @Override
    public CultivationLevel getCultivationLevel() {
        return null;
    }

    @Override
    public double getBaseProgress() {
        return 0;
    }

    @Override
    public double getSpeedModifier() {
        return 0;
    }

    @Override
    public void setSpeedModifier(double amount) {

    }

    @Override
    public double getStrengthModifier() {
        return 0;
    }

    @Override
    public void setStrengthModifier(double amount) {

    }

    @Override
    public double getJumpLimit() {
        return 0;
    }

    @Override
    public void setJumpLimit(double amount) {

    }

    @Override
    public int getUpdateTimer() {
        return 0;
    }
}
