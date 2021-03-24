package net.sovereign.cultivation.cultivation;

public interface ICultivation {


    void addBaseProgress(double amount);


    void setBaseProgress(double amount);


    double getBaseProgress();


    public void setLevel(CultivationLevel level);


    CultivationLevel getCultivationLevel();


    float getMaxSpeed();


    void setMaxSpeed(float amount);


    float getJumpLimit();


    void setJumpLimit(float amount);

    float getStepAssistLimit();

    void setStepAssistLimit(float stepAssistLimit);


    int getUpdateTimer();

    void resetTimer();

    void advTimer();
}
