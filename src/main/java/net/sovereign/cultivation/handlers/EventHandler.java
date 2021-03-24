package net.sovereign.cultivation.handlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.sovereign.cultivation.capabilities.CultivationFactory;
import net.sovereign.cultivation.capabilities.CultivationStorage;
import net.sovereign.cultivation.cultivation.CultivationUtils;
import net.sovereign.cultivation.cultivation.ICultivation;

public class EventHandler {

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(ICultivation.class, new CultivationStorage(), new CultivationFactory());
    }

    @SubscribeEvent
    public void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        ICultivation cultivation = CultivationUtils.getCultivationFromEntity(player);
    }
}
