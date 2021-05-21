package net.sovereign.cultivation.techniques;

import java.util.ArrayList;

public class Techniques {
    public static final ArrayList<Technique> TECHNIQUES = new ArrayList<>();

    public static void init() {
        TECHNIQUES.add(NONE);
        TECHNIQUES.add(HELLFIRE_TEMPERING_TECHNIQUE);
        TECHNIQUES.add(ETERNAL_FROST);
        TECHNIQUES.add(COLOSSAL_MOUNTAIN_SUTRA);
        TECHNIQUES.add(ETHEREAL_BODY);
        TECHNIQUES.add(BUDDHAS_PATH);
        TECHNIQUES.add(SOVEREIGN_OF_SHADOWS);
    }

    public static Technique getTechByIndex(int index) {
        for (Technique t : TECHNIQUES) {
            if (t.getIndex() == index) {
                return t;
            }
        }

        return null;
    }

    public static final Technique NONE = new Technique(0, "None", 0,
            new TechModifiers(1, 1, 1));
    public static final Technique HELLFIRE_TEMPERING_TECHNIQUE = new Technique(1, "Hellfire Tempering Technique", 1,
            new TechModifiers(1.9, 2.0, 3.0));
    public static final Technique ETERNAL_FROST = new Technique(2, "Eternal Frost", 2,
            new TechModifiers(1.5, 2.0, 3.4));
    public static final Technique COLOSSAL_MOUNTAIN_SUTRA = new Technique(3, "Colossal Mountain Sutra", 3,
            new TechModifiers(2.5, 0.9, 3.6));
    public static final Technique ETHEREAL_BODY = new Technique(4, "Ethereal Body", 4,
            new TechModifiers(0.9, 4.0, 1.3));
    public static final Technique BUDDHAS_PATH = new Technique(5, "Buddha's Path", 5,
            new TechModifiers(2.3, 1.2, 3.5));
    public static final Technique SOVEREIGN_OF_SHADOWS = new Technique(6, "Sovereign of Shadows", 6,
            new TechModifiers(1.6, 2.0, 2.3));
}
