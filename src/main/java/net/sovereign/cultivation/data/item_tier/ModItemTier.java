package net.sovereign.cultivation.data.item_tier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.sovereign.cultivation.setup.ModTags;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    CELESTIAL_SILVER(2500, 10.0F, 5.0F, 4, 20, () -> {
        return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
    }),

    EMPYREAN_STEEL(2800, 12.0F, 5.0F, 5, 25, () -> {
        return Ingredient.fromTag(ModTags.Items.INGOTS_STEEL);
    });

    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int harvestLevel;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private ModItemTier(int maxUses, float efficiency, float attackDamage, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
