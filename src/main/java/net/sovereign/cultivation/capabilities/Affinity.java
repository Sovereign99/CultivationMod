package net.sovereign.cultivation.capabilities;

import java.util.Random;

public class Affinity implements IAffinity{
    private int affinity;


    @Override
    public int getAffinity() {
        return this.affinity;
    }

    // There are 6 possible elemental affinities, as well as no affinity (0)
    @Override
    public void assignAffinity() {
        this.affinity = new Random().nextInt(7);
    }

    // Sets affinity to no affinity
    @Override
    public void removeAffinity() {
        this.affinity = 0;
    }
}
