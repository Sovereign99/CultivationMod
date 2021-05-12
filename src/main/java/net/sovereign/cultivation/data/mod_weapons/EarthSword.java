package net.sovereign.cultivation.data.mod_weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.MathHelper;
import net.sovereign.cultivation.data.item_tier.ModItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;

public class EarthSword extends SwordItem {
    public EarthSword(ModItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Item.Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 160, 2));
        target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 40, 10));
        target.applyKnockback(1.0F, (double) MathHelper.sin(attacker.rotationYaw * ((float)Math.PI / 180F)), (double)(-MathHelper.cos(attacker.rotationYaw * ((float)Math.PI / 180F))));
        return true;
    }
}
