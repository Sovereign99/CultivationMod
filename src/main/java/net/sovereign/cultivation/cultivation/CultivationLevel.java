package net.sovereign.cultivation.cultivation;

import java.util.HashMap;
import java.util.LinkedList;

public class CultivationLevel {
    public static final LinkedList<CultivationLevel> DEFAULTS = new LinkedList<>();
    static {
        DEFAULTS.add(new CultivationLevel("mortal_body", "Mortal", 1, 0, 10, 1.00F, 1.00F, false, false));
        DEFAULTS.add(new CultivationLevel("body_cleansing", "Body Cleansing", 2, 10, 80, 1.20F, 3.00F, false, false));
        DEFAULTS.add(new CultivationLevel("body_refinement", "Body Refinement", 3, 80, 640, 1.46F, 6.00F, false, false));
        DEFAULTS.add(new CultivationLevel("body_transformation", "Body Transformation", 4, 640, 3840, 1.82F, 18.00F, false, true));
        DEFAULTS.add(new CultivationLevel("core_formation", "Golden Core", 5, 3840, 15360, 2.36F, 54.00F, false, false));
        DEFAULTS.add(new CultivationLevel("earthly_body", "Earthly Body", 6, 15360, 46080, 3.07F, 108.00F, false, false));
        DEFAULTS.add(new CultivationLevel("nascent_soul", "Nascent Soul", 7, 46080, 92160, 4.05F, 216.00F, true,true ));
        DEFAULTS.add(new CultivationLevel("heavenly_body", "Heavenly Body", 8, 92160, 184320, 5.43F, 648.00F, true, false));
        DEFAULTS.add(new CultivationLevel("divine_body", "Divine Body", 9, 184320, 368640, 7.60F, 1296, true, true));
        DEFAULTS.add(new CultivationLevel("godly_body", "Godly Body", 10, 368640, Double.MAX_VALUE, 10.64, 3888, true, false));
    }

    public final String levelName;
    public final String displayName;
    public final int level;
    public final double baseProgress;
    public final double maxProgress;
    public final double baseSpeedModifier;
    public final double baseStrengthModifier;
    public final boolean canFly;
    public final boolean callsTribulation;

    public CultivationLevel(String levelName, String displayName, int level, double baseProgress, double maxProgress, double baseSpeedModifier, double baseStrengthModifier, boolean canFly, boolean callsTribulation) {
        this.levelName = levelName;
        this.displayName = displayName;
        this.level = level;
        this.baseProgress = baseProgress;
        this.maxProgress = maxProgress;
        this.baseSpeedModifier = baseSpeedModifier;
        this.baseStrengthModifier = baseStrengthModifier;
        this.canFly = canFly;
        this.callsTribulation = callsTribulation;
    }

    /**
     * Gets the full display name
     * @return the name to display
     */
    public String getLevelName() {
        return displayName;
    }

    /**
     * Gets the amount needed to  progress through this level.
     * @return the amount needed to  progress through this level.
     */
    public double getProgress() {
        return maxProgress - baseProgress;
    }

    /**
     * Gets how much the speed is modified by for the level
     * @return the modified speed
     */
    public double getSpeedModifier() {
        return baseSpeedModifier * (1F + 0.05F * level);
    }

    /**
     * Gets how much the strength is modified by for the level
     * @return the modified strength
     */
    public double getStrengthModifier() {
        return baseStrengthModifier * (1F + 0.05F * level);
    }

    /**
     * Gets the next cultivation level
     * @return The next cultivation level. If no next level, returns the current one
     */
    public CultivationLevel getNextLevel() {
        if(level < 10) {
            return DEFAULTS.get(level);
        }

        return DEFAULTS.get(level - 1);
    }

    public boolean checkTribulation() {
        return callsTribulation;
    }

    public static CultivationLevel getLevelInListByName(LinkedList<CultivationLevel> search, String levelName) {
        for(CultivationLevel level : search) {
            if(level.levelName.equals(levelName))
                return level;
        }

        return search.get(0);
    }
}
