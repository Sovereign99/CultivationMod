package net.sovereign.cultivation.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
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
import net.sovereign.cultivation.capabilities.*;
import net.sovereign.cultivation.setup.ModItems;
import net.sovereign.cultivation.setup.gui.CultivationGui;
import net.sovereign.cultivation.techniques.TechModifiers;
import net.sovereign.cultivation.techniques.Technique;
import net.sovereign.cultivation.techniques.Techniques;

@Mod.EventBusSubscriber(modid = CultivationMod.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
        if(!player.world.isRemote) {
            player.getCapability(Cultivation.CULTIVATION_CAP).ifPresent(cap -> cap.sync(player));
            player.getCapability(Affinity.AFFINITY_CAP).ifPresent(cap -> cap.sync(player));
            player.getCapability(Tech.TECH_CAP).ifPresent(cap -> cap.sync(player));
        }
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        CultivationGui.cultivationOverlay(event);
    }

    // Gain cultivation progress on kills
    @SubscribeEvent
    public void onPlayerKillEntity(LivingDeathEvent event) {
        if(event.getSource().getTrueSource() instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) event.getSource().getTrueSource();
            if(!player.world.isRemote) {
                ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
                ITech tech = player.getCapability(Tech.TECH_CAP).orElse(new Tech());
                tech.setTech(1);
                Entity target = event.getEntity();
                EntityClassification classification = target.getType().getClassification();
                if (target.getType() == EntityType.ENDER_DRAGON || target.getType() == EntityType.WITHER) {
                    cultivation.increaseCultivationAmount(10000.0);
                } else if (classification.getName().equals("monster") || target.getType() == EntityType.IRON_GOLEM) {
                    cultivation.increaseCultivationAmount(100.0);
                } else if (classification.getPeacefulCreature()) {
                    cultivation.increaseCultivationAmount(15.0);
                }
                cultivation.checkSubLevel();
                player.getCapability(Cultivation.CULTIVATION_CAP).ifPresent(cap -> cap.sync(player));
            }
        }
    }

    // Lose a bit of cultivation on death
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerClone(PlayerEvent.Clone event) {
        PlayerEntity clone = event.getPlayer();
        PlayerEntity original = event.getOriginal();
        copyCapability(Cultivation.CULTIVATION_CAP, original, clone);
        copyCapability(Affinity.AFFINITY_CAP, original, clone);
        copyCapability(Tech.TECH_CAP, original, clone);

        // No need to change if returning from End
        if (event.isWasDeath()) {
            clone.getCapability(Cultivation.CULTIVATION_CAP).ifPresent(cap -> cap.setCultivationAmount(cap.getCultivationAmount() * 0.8));

            ICultivation cultivation = clone.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
            ICultivation oldCultivation = original.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
            clone.sendMessage(new StringTextComponent("Your cultivation has fallen by: " + (int)(oldCultivation.getCultivationAmount() - cultivation.getCultivationAmount())), Util.DUMMY_UUID);
            cultivation.checkSubLevel();
        }

        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
        if(!player.world.isRemote) {
            player.getCapability(Cultivation.CULTIVATION_CAP).ifPresent(cap -> cap.sync(player));
            player.getCapability(Affinity.AFFINITY_CAP).ifPresent(cap -> cap.sync(player));
            player.getCapability(Tech.TECH_CAP).ifPresent(cap -> cap.sync(player));
        }
    }

    // Restores cultivation upn respawning
    @SubscribeEvent
    public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
        if(!player.world.isRemote) {
            player.getCapability(Cultivation.CULTIVATION_CAP).ifPresent(cap -> cap.sync(player));
            player.getCapability(Affinity.AFFINITY_CAP).ifPresent(cap -> cap.sync(player));
            player.getCapability(Tech.TECH_CAP).ifPresent(cap -> cap.sync(player));
        }
    }

    // Applies modifiers every 20 ticks, resets timer
    // Also makes sure sub level is matched with total cultivation
    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        if(event.getEntity() instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) event.getEntity();
            ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
            IAffinity affinity = player.getCapability(Affinity.AFFINITY_CAP).orElse(new Affinity());
            cultivation.advTimer();
            cultivation.checkSubLevel();
            if (cultivation.getTimer() % 20 == 0) {
                if (!player.world.isRemote) {
                    player.getCapability(Cultivation.CULTIVATION_CAP).ifPresent(cap -> cap.sync(player));
                    player.getCapability(Affinity.AFFINITY_CAP).ifPresent(cap -> cap.sync(player));
                    player.getCapability(Tech.TECH_CAP).ifPresent(cap -> cap.sync(player));
                    applyModifiers(player);
                    if (cultivation.getSubLevel().getLevelName().equals("Knight") && !affinity.getOrbed()) {
                        player.inventory.addItemStackToInventory(new ItemStack(ModItems.AFFINITY_ORB.get()));
                        affinity.setOrbed(true);
                    }
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
            Cultivation.CultivationSubLevel subLevel = cultivation.getSubLevel();
            if(player.world.isRemote || event.getDistance() < 3) return;

            // Take no fall damage if in divine levels
            if(subLevel.getIndex() >= 6) {
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
            double jump = 0.03 * ((cultivation.getAgility()  * 0.06) + (cultivation.getStrength() * 0.08));
            player.addVelocity(0.0, jump, 0.0);
            player.velocityChanged=true;
        }
    }

    // Applies attribute modifiers based on cultivation
    public void applyModifiers (PlayerEntity player) {
        if(player != null) {
            ICultivation cultivation = player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
            ITech tech = player.getCapability(Tech.TECH_CAP).orElse(new Tech());
            Technique technique = Techniques.getTechByIndex(tech.getTech());
            IAffinity affinity = player.getCapability(Affinity.AFFINITY_CAP).orElse(new Affinity());
            int affinityType = affinity.getAffinity();
            int techniqueAffinity = technique.getAffinity();
            TechModifiers modifiers = technique.getModifiers();
            if (techniqueAffinity != affinityType) {
                modifiers.multiply(0.5);
            }

            double speed = (cultivation.getAgility() * 0.008) * modifiers.agility;
            double atkSpeed = (cultivation.getAgility() * 0.01) * modifiers.agility;
            double str = (cultivation.getStrength()) * modifiers.strength;
            double armor = (cultivation.getArmor() * 0.02) + modifiers.armor;
            double res = ((cultivation.getArmor() + cultivation.getStrength()) * 0.008);
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

    // Used in PlayerClone event. Copies capability from one entity to another
    private static <T> void copyCapability(Capability<T> capability, ICapabilityProvider original, ICapabilityProvider clone) {
        original.getCapability(capability).ifPresent(dataOriginal ->
                clone.getCapability(capability).ifPresent(dataClone -> {
                    INBT nbt = capability.getStorage().writeNBT(capability, dataOriginal, null);
                    capability.getStorage().readNBT(capability, dataClone, null, nbt);
                }));
    }
}
