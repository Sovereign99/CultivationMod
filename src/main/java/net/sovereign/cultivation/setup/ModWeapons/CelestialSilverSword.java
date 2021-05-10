package net.sovereign.cultivation.setup.ModWeapons;

import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.sovereign.cultivation.setup.ModTags;

public class CelestialSilverSword extends SwordItem {

    public CelestialSilverSword() {
        super(new CelestialSilverSword.ItemTier(), 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT));
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
            return 5.0F;
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
