package net.sovereign.cultivation.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
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
        StringTextComponent text = new StringTextComponent("Welcome. Your cultivation is: " + (int) cultivation.getCultivationAmount());
        text.getStyle().setColor(Color.fromTextFormatting(TextFormatting.GOLD));
        player.sendMessage(text, player.getUniqueID());
    }

    // Gain cultivation progress on kills
    @SubscribeEvent
    public void onPlayerKillEntity(LivingDeathEvent event) {
        if(event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            if(!player.world.isRemote) {
                ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
                Entity target = event.getEntity();
                EntityClassification classification = target.getType().getClassification();
                if (classification.getPeacefulCreature()) {
                    cultivation.increaseCultivationAmount(15.0);
                    player.sendMessage(new StringTextComponent("Your cultivation is now: " + (int) cultivation.getCultivationAmount()), player.getUniqueID());
                } else if (classification.getName().equals("monster") || target.getType() == EntityType.IRON_GOLEM) {
                    cultivation.increaseCultivationAmount(100.0);
                    player.sendMessage(new StringTextComponent("Your cultivation is now: " + (int) cultivation.getCultivationAmount()), player.getUniqueID());
                }
            }
        }
    }

    // Lose a bit of cultivation on death
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        PlayerEntity player = event.getPlayer();
        PlayerEntity original = event.getOriginal();
        ICultivation oldCultivation = original.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
        ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
        if(event.isWasDeath()) {
            oldCultivation.decreaseCultivationAmount(oldCultivation.getCultivationAmount() * 0.1);
            cultivation = oldCultivation;
            player.sendMessage(new StringTextComponent("Your cultivation is now: " + (int) cultivation.getCultivationAmount()), player.getUniqueID());
        } else {
            cultivation = oldCultivation;
        }
    }

    // Restore cultivation on respawn
    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.getPlayer().world.isRemote) {
            PlayerEntity player = event.getPlayer();
            ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
        }
    }

    // Applies modifiers every 20 ticks, resets timer
    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        if(event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
            cultivation.advTimer();
            if (cultivation.getTimer() % 20 == 0) {
                if (!player.world.isRemote) {
                    applyModifiers(player);
                }

                cultivation.resetTimer();
            }
        }
    }

    // Negate a portion or all fall damage depending on cultivation
    @SubscribeEvent
    public void onPlayerFall(LivingFallEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event .getEntity();
            ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
            if(player.world.isRemote || event.getDistance() < 3) return;
            if(cultivation.getCultivationAmount() > 50000) {
                event.setDistance(0);
            } else {
                double agilityMod = cultivation.getAgility();
                double armorMod = cultivation.getArmor();
                event.setDistance(event.getDistance() - 0.9f * (float) (agilityMod + armorMod));
            }

        }
    }

    // Player jumps higher based on cultivation
    @SubscribeEvent
    public void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
            double base = player.getMotion().getY();
            double newJump = 0.008 * (cultivation.getAgility() + cultivation.getStrength()) * base;
            player.setMotion(player.getMotion().x, newJump, player.getMotion().z);
        }
    }

    // Applies attribute modifiers based on cultivation
    public void applyModifiers (PlayerEntity player) {
        if(player != null) {
            ICultivation cultivation = player.getCapability(CultivationProvider.CULTIVATION_CAP).orElse(new Cultivation());
            double speed = cultivation.getAgility() * 0.02;
            double atkSpeed = cultivation.getAgility() * 0.01;
            double str = cultivation.getStrength();
            double armor = cultivation.getArmor() * 0.02;
            double res = (cultivation.getArmor() + cultivation.getStrength()) * 0.02;
            AttributeModifier speedMod = new AttributeModifier("cultivation.speed_mod", speed, AttributeModifier.Operation.ADDITION);
            AttributeModifier atkSpeedMod = new AttributeModifier("cultivation.atk_speed_mod", atkSpeed, AttributeModifier.Operation.ADDITION);
            AttributeModifier strMod = new AttributeModifier("cultivation.str_mod", str, AttributeModifier.Operation.ADDITION);
            AttributeModifier armorMod = new AttributeModifier("cultivation.armor_mod", armor, AttributeModifier.Operation.ADDITION);
            AttributeModifier resMod = new AttributeModifier("cultivation.res_mod", res, AttributeModifier.Operation.ADDITION);

            // Remove existing modifiers
            for (AttributeModifier mod : player.getAttribute(Attributes.MOVEMENT_SPEED).getModifierListCopy()) {
                if (mod.getName().equals("cultivation.speed_mod")) {
                    player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(mod);
                }
            }

            for (AttributeModifier mod : player.getAttribute(Attributes.ATTACK_SPEED).getModifierListCopy()) {
                if (mod.getName().equals("cultivation.atk_speed_mod")) {
                    player.getAttribute(Attributes.ATTACK_SPEED).removeModifier(mod);
                }
            }

            for (AttributeModifier mod : player.getAttribute(Attributes.ATTACK_DAMAGE).getModifierListCopy()) {
                if (mod.getName().equals("cultivation.str_mod")) {
                    player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(mod);
                }
            }

            for (AttributeModifier mod : player.getAttribute(Attributes.ARMOR).getModifierListCopy()) {
                if (mod.getName().equals("cultivation.armor_mod")) {
                    player.getAttribute(Attributes.ARMOR).removeModifier(mod);
                }
            }

            for (AttributeModifier mod : player.getAttribute(Attributes.ARMOR_TOUGHNESS).getModifierListCopy()) {
                if (mod.getName().equals("cultivation.res_mod")) {
                    player.getAttribute(Attributes.ARMOR_TOUGHNESS).removeModifier(mod);
                }
            }

            // Apply new modifiers
            player.getAttribute(Attributes.MOVEMENT_SPEED).applyPersistentModifier(speedMod);
            player.getAttribute(Attributes.ATTACK_SPEED).applyPersistentModifier(atkSpeedMod);
            player.getAttribute(Attributes.ATTACK_DAMAGE).applyPersistentModifier(strMod);
            player.getAttribute(Attributes.ARMOR).applyPersistentModifier(armorMod);
            player.getAttribute(Attributes.ARMOR_TOUGHNESS).applyPersistentModifier(resMod);
        }
    }
}
