package net.sovereign.cultivation.setup.mod_armors;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

public class ModArmor extends ArmorItem {
    public ModArmor(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Item.Properties().group(ItemGroup.COMBAT));
    }
}
