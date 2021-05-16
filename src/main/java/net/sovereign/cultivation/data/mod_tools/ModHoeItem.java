package net.sovereign.cultivation.data.mod_tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ModHoeItem extends HoeItem {
    public ModHoeItem(IItemTier itemTier, int attackDamage, float attackSpeed) {
        super(itemTier, attackDamage, attackSpeed, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
