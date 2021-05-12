package net.sovereign.cultivation.data.mod_tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;

public class ModHoeItem extends HoeItem {
    public ModHoeItem(IItemTier itemTier, int attackDamage, float attackSpeed, Properties properties) {
        super(itemTier, attackDamage, attackSpeed, properties);
    }
}
