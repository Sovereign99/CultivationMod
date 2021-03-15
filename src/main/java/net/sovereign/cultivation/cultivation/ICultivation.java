package net.sovereign.cultivation.cultivation;

public interface ICultivation {


    void addBaseProgress(double amount);


    void setBaseProgress(double amount);


    double getBaseProgress();


    public void setLevel(CultivationLevel level);


    CultivationLevel getCultivationLevel();


    double getSpeedModifier();


    void setSpeedModifier(double amount);


    double getStrengthModifier();


    void setStrengthModifier(double amount);


    double getJumpLimit();


    void setJumpLimit(double amount);


    int getUpdateTimer();
}
