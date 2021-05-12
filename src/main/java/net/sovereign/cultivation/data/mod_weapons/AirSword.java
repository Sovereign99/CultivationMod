package net.sovereign.cultivation.data.mod_weapons;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.MathHelper;
import net.sovereign.cultivation.data.item_tier.ModItemTier;

public class AirSword extends SwordItem {
    public AirSword(ModItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Item.Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addPotionEffect(new EffectInstance(Effects.LEVITATION, 20, 3, false, false));
        target.applyKnockback(0.6F, (double) MathHelper.sin(attacker.rotationYaw * ((float)Math.PI / 180F)), (double)(-MathHelper.cos(attacker.rotationYaw * ((float)Math.PI / 180F))));
        return true;
    }
}
