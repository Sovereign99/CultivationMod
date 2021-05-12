package net.sovereign.cultivation.data.mod_tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class ModShovelItem extends ShovelItem {
    public ModShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
