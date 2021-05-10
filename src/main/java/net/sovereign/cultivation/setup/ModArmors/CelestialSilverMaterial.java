package net.sovereign.cultivation.setup.ModArmors;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.setup.ModTags;

public class CelestialSilverMaterial implements IArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4};

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return BASE_DURABILITY[slotIn.getIndex()] * 40;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return PROTECTION_VALUES[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
    }

    @Override
    public String getName() {
        return CultivationMod.MOD_ID + ":" + "celestial_silver_armor";
    }

    @Override
    public float getToughness() {
        return 4.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }
}
