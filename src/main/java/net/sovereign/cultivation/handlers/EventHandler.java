package net.sovereign.cultivation.handlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.sovereign.cultivation.capabilities.CultivationUtils;
import net.sovereign.cultivation.cultivation.ICultivation;

public class EventHandler {
    @SubscribeEvent
    public void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        ICultivation cultivation = CultivationUtils.getCultivationFromEntity(player);
    }
}
