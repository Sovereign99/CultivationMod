package net.sovereign.cultivation.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.sovereign.cultivation.capabilities.CultivationProvider;
import net.sovereign.cultivation.capabilities.ICultivation;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());

        player.sendMessage(new StringTextComponent("Welcome. Your cultivation is: " + (int) cultivation.getCultivationAmount()), player.getUniqueID());
    }

    @SubscribeEvent
    public void onPlayerKillEntity(LivingDeathEvent event) {
        if(event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            if(!player.world.isRemote) {
                ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
                Entity target = event.getEntity();
                EntityClassification classification = target.getType().getClassification();
                if (classification.getPeacefulCreature()) {
                    cultivation.increaseCultivationAmount(15.0F);
                    player.sendMessage(new StringTextComponent("Your cultivation is now: " + (int) cultivation.getCultivationAmount()), player.getUniqueID());
                } else if (classification.getName().equals("monster") || target.getType() == EntityType.IRON_GOLEM) {
                    cultivation.increaseCultivationAmount(100.0F);
                    player.sendMessage(new StringTextComponent("Your cultivation is now: " + (int) cultivation.getCultivationAmount()), player.getUniqueID());
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        PlayerEntity player = event.getPlayer();
        PlayerEntity original = event.getOriginal();
        ICultivation oldCultivation = original.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
        ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
        if(event.isWasDeath()) {
            oldCultivation.decreaseCultivationAmount(oldCultivation.getCultivationAmount() * 0.05F);
            cultivation = oldCultivation;
            player.sendMessage(new StringTextComponent("Your cultivation is now: " + (int) cultivation.getCultivationAmount()), player.getUniqueID());
        } else {
            cultivation = oldCultivation;
        }
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.getPlayer().world.isRemote) {
            PlayerEntity player = event.getPlayer();
            ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
        }
    }



    public void applyModifiers (PlayerEntity player) {
        if(player != null) {

        }
    }
}
