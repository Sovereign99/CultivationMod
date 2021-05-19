package net.sovereign.cultivation.handlers;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.Affinity;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.sovereign.cultivation.capabilities.IAffinity;

@Mod.EventBusSubscriber(modid = CultivationMod.MOD_ID, bus = Bus.FORGE)
public class CapabilityHandler {

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if(Cultivation.attach(entity)) {
            event.addCapability(Cultivation.NAME, new Cultivation());
        }

        if(Affinity.attach(entity)) {
            event.addCapability(Affinity.NAME, new Affinity());
            IAffinity affinity = entity.getCapability(Affinity.AFFINITY_CAP).orElse(new Affinity());
            affinity.assignAffinity();
        }
    }
}
