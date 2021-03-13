package net.sovereign.cultivation.setup;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class CelestialSilverSword extends SwordItem {

    public CelestialSilverSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    public static class ItemTier implements IItemTier {

        @Override
        public int getMaxUses() {
            return 300;
        }

        @Override
        public float getEfficiency() {
            return 12.0F;
        }

        @Override
        public float getAttackDamage() {
            return 1.0F;
        }

        @Override
        public int getHarvestLevel() {
            return 3;
        }

        @Override
        public int getEnchantability() {
            return 15;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(ModItems.CELESTIAL_SILVER_INGOT);
        }
    }
}
