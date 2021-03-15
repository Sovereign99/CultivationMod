package net.sovereign.cultivation.setup.ModWeapons;

import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.sovereign.cultivation.setup.ModTags;

public class CelestialSilverSword extends SwordItem {

    private final IItemTier tier;
    private final int attackDamage;


    public CelestialSilverSword() {
        super(new CelestialSilverSword.ItemTier(), 3, -1.2F, new Item.Properties().group(ItemGroup.COMBAT));

        tier = getTier();
        attackDamage = (int) (3.0F + tier.getAttackDamage());
    }

    public static class ItemTier implements IItemTier {

        @Override
        public int getMaxUses() {
            return 1700;
        }

        @Override
        public float getEfficiency() {
            return 12.0F;
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
