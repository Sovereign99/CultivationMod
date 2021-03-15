package net.sovereign.cultivation.setup.ModTools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;
import net.sovereign.cultivation.setup.ModTags;

public class CelestialSilverPickaxe extends PickaxeItem {

    public CelestialSilverPickaxe() {
        super(new CelestialSilverPickaxe.ItemTier(), 2, -1.2f, new Item.Properties().group(ItemGroup.TOOLS));
    }

    public static class ItemTier implements IItemTier {

        @Override
        public int getMaxUses() {
            return 1700;
        }

        @Override
        public float getEfficiency() {
            return 15.0F;
        }

        @Override
        public float getAttackDamage() {
            return 8.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 3;
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
