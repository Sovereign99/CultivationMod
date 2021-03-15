package net.sovereign.cultivation.capabilities;

import net.sovereign.cultivation.cultivation.Cultivation;

import java.util.concurrent.Callable;

public class CultivationFactory implements Callable<Cultivation> {
    @Override
    public Cultivation call() throws Exception {
        return new Cultivation();
    }
}
