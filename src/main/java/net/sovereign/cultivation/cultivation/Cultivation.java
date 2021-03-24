package net.sovereign.cultivation.cultivation;

import org.lwjgl.system.MathUtil;

public class Cultivation implements ICultivation {
    private CultivationLevel currentLevel;
    private double cultivationProgress;
    private int timer;
    private float maxSpeed;
    private float jumpLimit;
    public float stepAssistLimit;


    public Cultivation() {
        this.currentLevel = CultivationLevel.DEFAULTS.get(0);
        this.cultivationProgress = 0.0;
        this.timer = 0;
        this.maxSpeed = 5.0f;
        this.jumpLimit = 10.0f;
        this.stepAssistLimit = 3.0f;
    }

    @Override
    public void addBaseProgress(double amount) {
        this.setBaseProgress(this.getBaseProgress() + amount);
    }

    @Override
    public void setBaseProgress(double amount) {
        amount = Math.max(0.0, amount);
        amount = Math.min(amount, currentLevel.getNextLevel().maxProgress);

        this.cultivationProgress = amount;
    }

    @Override
    public double getBaseProgress() {
        return cultivationProgress;
    }

    @Override
    public void setLevel(CultivationLevel level) {
        this.currentLevel = level;
    }

    @Override
    public CultivationLevel getCultivationLevel() {
        return currentLevel;
    }

    @Override
    public float getMaxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public float getJumpLimit() {
        return this.jumpLimit;
    }

    @Override
    public void setJumpLimit(float jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    @Override
    public float getStepAssistLimit() {
        return stepAssistLimit;
    }

    @Override
    public void setStepAssistLimit(float stepAssistLimit) {
        this.stepAssistLimit = stepAssistLimit;
    }

    @Override
    public int getUpdateTimer() {
        return this.timer;
    }

    @Override
    public void resetTimer() {
        this.timer = 0;
    }

    @Override
    public void advTimer() {
        this.timer++;
    }
}
