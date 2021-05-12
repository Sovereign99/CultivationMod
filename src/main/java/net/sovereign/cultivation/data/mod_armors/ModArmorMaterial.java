package net.sovereign.cultivation.data.mod_armors;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.setup.ModTags;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    CELESTIAL_SILVER(CultivationMod.MOD_ID + ":" + "celestial_silver_armor",
            40,
            new int[]{4, 7, 9, 4},
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            4.0F,
            0.1F,
            () -> {
                return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
            }),

    LAVA_CELESTIAL_SILVER(CultivationMod.MOD_ID + ":" + "lava_celestial_silver_armor",
            43,
            new int[]{5, 8, 10, 5},
            22,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            4.0F,
            0.1F,
            () -> {
                return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
            }),

    WATER_CELESTIAL_SILVER(CultivationMod.MOD_ID + ":" + "water_celestial_silver_armor",
            43,
            new int[]{5, 8, 10, 5},
            22,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            4.0F,
            0.1F,
            () -> {
                return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
            }),

    EARTH_CELESTIAL_SILVER(CultivationMod.MOD_ID + ":" + "earth_celestial_silver_armor",
            43,
            new int[]{6, 9, 11, 6},
            22,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            4.5F,
            0.1F,
            () -> {
                return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
            }),

    AIR_CELESTIAL_SILVER(CultivationMod.MOD_ID + ":" + "air_celestial_silver_armor",
            43,
            new int[]{4, 7, 9, 4},
            22,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            3.5F,
            0.1F,
            () -> {
                return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
            }),

    EMPYREAN_STEEL(CultivationMod.MOD_ID + ":" + "empyrean_steel_armor",
            45,
            new int[]{7, 10, 12, 7},
            25,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            5.0F,
            0.2F,
            () -> {
                return Ingredient.fromTag(ModTags.Items.INGOTS_SILVER);
            });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    private ModArmorMaterial(String name,
                             int maxDamageFactor,
                             int[] damageReductionAmountArray,
                             int enchantability,
                             SoundEvent soundEvent,
                             float toughness,
                             float knockbackResistance,
                             Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
