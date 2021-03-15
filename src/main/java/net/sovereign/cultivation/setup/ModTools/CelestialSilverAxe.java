package net.sovereign.cultivation.setup.ModTools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.Ingredient;
import net.sovereign.cultivation.setup.ModTags;

public class CelestialSilverAxe extends AxeItem {
    public CelestialSilverAxe() {
        super(new CelestialSilverAxe.ItemTier(), 3, -2.0F, new Item.Properties().group(ItemGroup.TOOLS));
    }

    public static class ItemTier implements IItemTier {

        @Override
        public int getMaxUses() {
            return 2000;
        }

        @Override
        public float getEfficiency() {
            return 20.0F;
        }

        @Override
        public float getAttackDamage() {
            return 12.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 25;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
        }
    }
}
