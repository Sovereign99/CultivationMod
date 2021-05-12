package net.sovereign.cultivation.capabilities;

import java.util.concurrent.Callable;

public class CultivationFactory implements Callable<ICultivation> {
    @Override
    public ICultivation call() throws Exception {
        return new Cultivation();
    }
}
