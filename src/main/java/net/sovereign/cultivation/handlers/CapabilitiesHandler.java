package net.sovereign.cultivation.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.CultivationProvider;

public class CapabilitiesHandler {
    private final ResourceLocation CULTIVATION_CAP = new ResourceLocation(CultivationMod.MOD_ID, "cultivation");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof PlayerEntity)) return;

        event.addCapability(CULTIVATION_CAP, new CultivationProvider());
    }
}
