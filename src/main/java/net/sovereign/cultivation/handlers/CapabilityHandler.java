package net.sovereign.cultivation.handlers;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.*;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

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
        }

        if(Tech.attach(entity)) {
            event.addCapability(Tech.NAME, new Tech());
        }
    }
}
