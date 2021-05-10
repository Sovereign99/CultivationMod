package net.sovereign.cultivation.setup.ModTools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.crafting.Ingredient;
import net.sovereign.cultivation.setup.ModTags;

public class CelestialSilverShovel extends ShovelItem {
    public CelestialSilverShovel() {
        super(new CelestialSilverShovel.ItemTier(), 1.5F, -2.8F, new Item.Properties().group(ItemGroup.TOOLS));
    }

    public static class ItemTier implements IItemTier {

        @Override
        public int getMaxUses() {
            return 2500;
        }

        @Override
        public float getEfficiency() {
            return 10.0F;
        }

        @Override
        public float getAttackDamage() {
            return 4.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 20;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
        }
    }
}
