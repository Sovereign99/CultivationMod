package net.sovereign.cultivation.techniques;

public class Technique {
    private final int index;
    private final String name;
    private final int affinity;
    private final TechModifiers modifiers;

    Technique(int index, String name, int affinity, TechModifiers modifiers) {
        this.index = index;
        this.name = name;
        this.affinity = affinity;
        this.modifiers = modifiers;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getAffinity() {
        return affinity;
    }

    public TechModifiers getModifiers() {
        return modifiers;
    }
}
