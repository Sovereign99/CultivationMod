package net.sovereign.cultivation.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Util;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.sovereign.cultivation.capabilities.ICultivation;

@Mod.EventBusSubscriber(modid = CultivationMod.MOD_ID)
public class EventHandler {
    @SubscribeEvent
    public void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
        StringTextComponent text = new StringTextComponent("Welcome. Your cultivation is: " + (int) cultivation.getCultivationAmount());
        text.getStyle().setColor(Color.fromTextFormatting(TextFormatting.GOLD));
        player.sendMessage(text, Util.DUMMY_UUID);
    }

    // Gain cultivation progress on kills
    // TODO: Messages are temporary. Will change notification system later
    @SubscribeEvent
    public void onPlayerKillEntity(LivingDeathEvent event) {
        if(event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            if(!player.world.isRemote) {
                ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
                Entity target = event.getEntity();
                EntityClassification classification = target.getType().getClassification();
                if (classification.getPeacefulCreature()) {
                    double increase = 15.0;
                    cultivation.increaseCultivationAmount(increase);
                    player.sendMessage(new StringTextComponent("Your cultivation has increased by: " + increase), Util.DUMMY_UUID);
                } else if (classification.getName().equals("monster") || target.getType() == EntityType.IRON_GOLEM) {
                    double increase = 100.0;
                    cultivation.increaseCultivationAmount(increase);
                    player.sendMessage(new StringTextComponent("Your cultivation has increased by: " + increase), Util.DUMMY_UUID);
                } else if (target.getType() == EntityType.ENDER_DRAGON || target.getType() == EntityType.WITHER) {
                    double increase = 10000.0;
                    cultivation.increaseCultivationAmount(increase);
                    player.sendMessage(new StringTextComponent("Your cultivation has increased by: " + increase), Util.DUMMY_UUID);
                }
            }
        }
    }

    // Lose a bit of cultivation on death
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerClone(PlayerEvent.Clone event) {
        PlayerEntity clone = event.getPlayer();
        PlayerEntity original = event.getOriginal();

        copyCapability(Cultivation.CULTIVATION_CAP, original, clone);

        // No need to change if returning from End
        if (!event.isWasDeath()) return;

        clone.getCapability(Cultivation.CULTIVATION_CAP).ifPresent(data -> {
            data.setCultivationAmount(data.getCultivationAmount() * 0.8);
        });

        ICultivation cultivation = clone.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
        clone.sendMessage(new StringTextComponent("Welcome. Your cultivation is: " + (int) cultivation.getCultivationAmount()), Util.DUMMY_UUID);
    }

    // Applies modifiers every 20 ticks, resets timer
    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        if(event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
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
            ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
            if(player.world.isRemote || event.getDistance() < 3) return;
            if(cultivation.getCultivationAmount() > 100000) {
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
            ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
            double jump = 0.05 * ((cultivation.getAgility()  * 0.06) + (cultivation.getStrength() * 0.08));
            player.addVelocity(0.0, jump, 0.0);
            player.velocityChanged=true;
        }
    }

    // Applies attribute modifiers based on cultivation
    public void applyModifiers (PlayerEntity player) {
        if(player != null) {
            ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
            double speed = cultivation.getAgility() * 0.02;
            double atkSpeed = cultivation.getAgility() * 0.01;
            double str = cultivation.getStrength() * 0.03;
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

    private static <T> void copyCapability(Capability<T> capability, ICapabilityProvider original, ICapabilityProvider clone) {
        original.getCapability(capability).ifPresent(dataOriginal ->
                clone.getCapability(capability).ifPresent(dataClone -> {
                    INBT nbt = capability.getStorage().writeNBT(capability, dataOriginal, null);
                    capability.getStorage().readNBT(capability, dataClone, null, nbt);
                }));
    }
}
