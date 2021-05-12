package net.sovereign.cultivation.data.mod_weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.sovereign.cultivation.data.item_tier.ModItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;

public class LavaSword extends SwordItem {
    public LavaSword(ModItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Item.Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setFire(7);
        return true;
    }
}
