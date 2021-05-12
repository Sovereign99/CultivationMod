package net.sovereign.cultivation.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.CultivationProvider;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CultivationMod.MOD_ID, bus = Bus.FORGE)
public class CapabilityHandler {

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity) {
            ResourceLocation CULTIVATION_CAP = new ResourceLocation(CultivationMod.MOD_ID, "cultivation");
            event.addCapability(CULTIVATION_CAP, new CultivationProvider());
            CultivationMod.LOGGER.info("Attached");
        }
    }
}
