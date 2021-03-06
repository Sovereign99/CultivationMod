package net.sovereign.cultivation.setup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.sovereign.cultivation.data.affinity_items.AffinityItems;
import net.sovereign.cultivation.data.item_tier.ModItemTier;
import net.sovereign.cultivation.data.mod_armors.*;
import net.sovereign.cultivation.data.mod_tools.ModAxeItem;
import net.sovereign.cultivation.data.mod_tools.ModShovelItem;
import net.sovereign.cultivation.data.mod_tools.ModPickaxeItem;
import net.sovereign.cultivation.data.mod_tools.ModHoeItem;
import net.sovereign.cultivation.data.mod_weapons.*;
import net.sovereign.cultivation.data.pills.Pills;

public class ModItems {
    // Lava Crystals (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_LAVA_CRYSTAL = Registration.ITEMS.register("inferior_lava_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> BASIC_LAVA_CRYSTAL = Registration.ITEMS.register("basic_lava_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> ENHANCED_LAVA_CRYSTAL = Registration.ITEMS.register("enhanced_lava_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> SUPERIOR_LAVA_CRYSTAL = Registration.ITEMS.register("superior_lava_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    // Hell Bead (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_HELL_BEAD = Registration.ITEMS.register("inferior_hell_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> BASIC_HELL_BEAD = Registration.ITEMS.register("basic_hell_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> ENHANCED_HELL_BEAD = Registration.ITEMS.register("enhanced_hell_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> SUPERIOR_HELL_BEAD = Registration.ITEMS.register("superior_hell_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    // Water Bead (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_WATER_BEAD = Registration.ITEMS.register("inferior_water_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> BASIC_WATER_BEAD = Registration.ITEMS.register("basic_water_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> ENHANCED_WATER_BEAD = Registration.ITEMS.register("enhanced_water_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> SUPERIOR_WATER_BEAD = Registration.ITEMS.register("superior_water_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    // Celestial Ice (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_CELESTIAL_ICE = Registration.ITEMS.register("inferior_celestial_ice",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> BASIC_CELESTIAL_ICE = Registration.ITEMS.register("basic_celestial_ice",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> ENHANCED_CELESTIAL_ICE = Registration.ITEMS.register("enhanced_celestial_ice",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> SUPERIOR_CELESTIAL_ICE = Registration.ITEMS.register("superior_celestial_ice",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    // Wind Essence (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_WIND_ESSENCE = Registration.ITEMS.register("inferior_wind_essence",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> BASIC_WIND_ESSENCE = Registration.ITEMS.register("basic_wind_essence",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> ENHANCED_WIND_ESSENCE = Registration.ITEMS.register("enhanced_wind_essence",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> SUPERIOR_WIND_ESSENCE = Registration.ITEMS.register("superior_wind_essence",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    // Ethereal Gale (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_ETHEREAL_GALE = Registration.ITEMS.register("inferior_ethereal_gale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> BASIC_ETHEREAL_GALE = Registration.ITEMS.register("basic_ethereal_gale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> ENHANCED_ETHEREAL_GALE = Registration.ITEMS.register("enhanced_ethereal_gale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> SUPERIOR_ETHEREAL_GALE = Registration.ITEMS.register("superior_ethereal_gale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    // Rock (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_ROCK = Registration.ITEMS.register("inferior_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> BASIC_ROCK = Registration.ITEMS.register("basic_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> ENHANCED_ROCK = Registration.ITEMS.register("enhanced_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> SUPERIOR_ROCK = Registration.ITEMS.register("superior_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    // Immortal Rock (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_IMMORTAL_ROCK = Registration.ITEMS.register("inferior_immortal_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> BASIC_IMMORTAL_ROCK = Registration.ITEMS.register("basic_immortal_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> ENHANCED_IMMORTAL_ROCK = Registration.ITEMS.register("enhanced_immortal_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> SUPERIOR_IMMORTAL_ROCK = Registration.ITEMS.register("superior_immortal_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    // Affinity items
    public static final RegistryObject<Item> AFFINITY_ORB = Registration.ITEMS.register("affinity_orb",
            () -> AffinityItems.AFFINITY_ORB);
    public static final RegistryObject<Item> EMPTY_CORE = Registration.ITEMS.register("empty_core",
            () -> AffinityItems.EMPTY_CORE);
    public static final RegistryObject<Item> MAGMATIC_EMBRYO = Registration.ITEMS.register("magmatic_embryo",
            () -> AffinityItems.MAGMATIC_EMBRYO);
    public static final RegistryObject<Item> HEART_OF_THE_DEPTHS = Registration.ITEMS.register("heart_of_the_depths",
            () -> AffinityItems.HEART_OF_THE_DEPTHS);
    public static final RegistryObject<Item> TEAR_OF_STONE = Registration.ITEMS.register("tear_of_stone",
            () -> AffinityItems.TEAR_OF_STONE);
    public static final RegistryObject<Item> EYE_OF_STORMS = Registration.ITEMS.register("eye_of_storms",
            () -> AffinityItems.EYE_OF_STORMS);
    public static final RegistryObject<Item> HEAVENLY_LIGHT = Registration.ITEMS.register("heavenly_light",
            () -> AffinityItems.HEAVENLY_LIGHT);
    public static final RegistryObject<Item> VOID_CORE = Registration.ITEMS.register("void_core",
            () -> AffinityItems.VOID_CORE);

    // Pills
    public static final RegistryObject<Item> GREATER_HEAL_PILL = Registration.ITEMS.register("greater_heal_pill",
            () -> Pills.GREATER_HEAL);
    public static final RegistryObject<Item> HIGHGOD_PILL = Registration.ITEMS.register("highgod_pill",
            () -> Pills.HIGHGOD);

    // Celestial Silver
    public static final RegistryObject<Item> CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("celestial_silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<ModSwordItem> CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("celestial_silver_sword", () ->
            new ModSwordItem(ModItemTier.CELESTIAL_SILVER, 3, -2.4F));
    public static final RegistryObject<PickaxeItem> CELESTIAL_SILVER_PICKAXE = Registration.ITEMS.register("celestial_silver_pickaxe", () ->
            new ModPickaxeItem(ModItemTier.CELESTIAL_SILVER, 2, -2.8F));
    public static final RegistryObject<AxeItem> CELESTIAL_SILVER_AXE = Registration.ITEMS.register("celestial_silver_axe", () ->
            new ModAxeItem(ModItemTier.CELESTIAL_SILVER, 5.2F, -2.5F));
    public static final RegistryObject<ShovelItem> CELESTIAL_SILVER_SHOVEL = Registration.ITEMS.register("celestial_silver_shovel", () ->
            new ModShovelItem(ModItemTier.CELESTIAL_SILVER, 1.5F, -2.8F));
    public static final RegistryObject<ModHoeItem> CELESTIAL_SILVER_HOE = Registration.ITEMS.register("celestial_silver_hoe", () ->
            new ModHoeItem(ModItemTier.CELESTIAL_SILVER, -4, -2.8F));

    public static final RegistryObject<ArmorItem> CELESTIAL_SILVER_HELMET = Registration.ITEMS.register("celestial_silver_helmet",
            () -> new ModArmor(ModArmorMaterial.CELESTIAL_SILVER, EquipmentSlotType.HEAD));
    public static final RegistryObject<ArmorItem> CELESTIAL_SILVER_CHESTPLATE = Registration.ITEMS.register("celestial_silver_chestplate",
            () -> new ModArmor(ModArmorMaterial.CELESTIAL_SILVER, EquipmentSlotType.CHEST));
    public static final RegistryObject<ArmorItem> CELESTIAL_SILVER_LEGGINGS = Registration.ITEMS.register("celestial_silver_leggings",
            () -> new ModArmor(ModArmorMaterial.CELESTIAL_SILVER, EquipmentSlotType.LEGS));
    public static final RegistryObject<ArmorItem> CELESTIAL_SILVER_BOOTS = Registration.ITEMS.register("celestial_silver_boots",
            () -> new ModArmor(ModArmorMaterial.CELESTIAL_SILVER, EquipmentSlotType.FEET));

    public static final RegistryObject<ArmorItem> LAVA_CELESTIAL_SILVER_HELMET = Registration.ITEMS.register("lava_celestial_silver_helmet",
            () -> new LavaArmor(ModArmorMaterial.LAVA_CELESTIAL_SILVER, EquipmentSlotType.HEAD));
    public static final RegistryObject<ArmorItem> LAVA_CELESTIAL_SILVER_CHESTPLATE = Registration.ITEMS.register("lava_celestial_silver_chestplate",
            () -> new LavaArmor(ModArmorMaterial.LAVA_CELESTIAL_SILVER, EquipmentSlotType.CHEST));
    public static final RegistryObject<ArmorItem> LAVA_CELESTIAL_SILVER_LEGGINGS = Registration.ITEMS.register("lava_celestial_silver_leggings",
            () -> new LavaArmor(ModArmorMaterial.LAVA_CELESTIAL_SILVER, EquipmentSlotType.LEGS));
    public static final RegistryObject<ArmorItem> LAVA_CELESTIAL_SILVER_BOOTS = Registration.ITEMS.register("lava_celestial_silver_boots",
            () -> new LavaArmor(ModArmorMaterial.LAVA_CELESTIAL_SILVER, EquipmentSlotType.FEET));
    public static final RegistryObject<LavaSword> LAVA_CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("lava_celestial_silver_sword",
            () -> new LavaSword(ModItemTier.CELESTIAL_SILVER, 3, -2.4F));

    public static final RegistryObject<ArmorItem> WATER_CELESTIAL_SILVER_HELMET = Registration.ITEMS.register("water_celestial_silver_helmet",
            () -> new WaterArmor(ModArmorMaterial.WATER_CELESTIAL_SILVER, EquipmentSlotType.HEAD));
    public static final RegistryObject<ArmorItem> WATER_CELESTIAL_SILVER_CHESTPLATE = Registration.ITEMS.register("water_celestial_silver_chestplate",
            () -> new WaterArmor(ModArmorMaterial.WATER_CELESTIAL_SILVER, EquipmentSlotType.CHEST));
    public static final RegistryObject<ArmorItem> WATER_CELESTIAL_SILVER_LEGGINGS = Registration.ITEMS.register("water_celestial_silver_leggings",
            () -> new WaterArmor(ModArmorMaterial.WATER_CELESTIAL_SILVER, EquipmentSlotType.LEGS));
    public static final RegistryObject<ArmorItem> WATER_CELESTIAL_SILVER_BOOTS = Registration.ITEMS.register("water_celestial_silver_boots",
            () -> new WaterArmor(ModArmorMaterial.WATER_CELESTIAL_SILVER, EquipmentSlotType.FEET));
    public static final RegistryObject<WaterSword> WATER_CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("water_celestial_silver_sword",
            () -> new WaterSword(ModItemTier.CELESTIAL_SILVER, 3, -2.4F));

    public static final RegistryObject<ArmorItem> EARTH_CELESTIAL_SILVER_HELMET = Registration.ITEMS.register("earth_celestial_silver_helmet",
            () -> new EarthArmor(ModArmorMaterial.EARTH_CELESTIAL_SILVER, EquipmentSlotType.HEAD));
    public static final RegistryObject<ArmorItem> EARTH_CELESTIAL_SILVER_CHESTPLATE = Registration.ITEMS.register("earth_celestial_silver_chestplate",
            () -> new EarthArmor(ModArmorMaterial.EARTH_CELESTIAL_SILVER, EquipmentSlotType.CHEST));
    public static final RegistryObject<ArmorItem> EARTH_CELESTIAL_SILVER_LEGGINGS = Registration.ITEMS.register("earth_celestial_silver_leggings",
            () -> new EarthArmor(ModArmorMaterial.EARTH_CELESTIAL_SILVER, EquipmentSlotType.LEGS));
    public static final RegistryObject<ArmorItem> EARTH_CELESTIAL_SILVER_BOOTS = Registration.ITEMS.register("earth_celestial_silver_boots",
            () -> new EarthArmor(ModArmorMaterial.EARTH_CELESTIAL_SILVER, EquipmentSlotType.FEET));
    public static final RegistryObject<EarthSword> EARTH_CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("earth_celestial_silver_sword",
            () -> new EarthSword(ModItemTier.CELESTIAL_SILVER, 3, -2.4F));

    public static final RegistryObject<ArmorItem> AIR_CELESTIAL_SILVER_HELMET = Registration.ITEMS.register("air_celestial_silver_helmet",
            () -> new AirArmor(ModArmorMaterial.AIR_CELESTIAL_SILVER, EquipmentSlotType.HEAD));
    public static final RegistryObject<ArmorItem> AIR_CELESTIAL_SILVER_CHESTPLATE = Registration.ITEMS.register("air_celestial_silver_chestplate",
            () -> new AirArmor(ModArmorMaterial.AIR_CELESTIAL_SILVER, EquipmentSlotType.CHEST));
    public static final RegistryObject<ArmorItem> AIR_CELESTIAL_SILVER_LEGGINGS = Registration.ITEMS.register("air_celestial_silver_leggings",
            () -> new AirArmor(ModArmorMaterial.AIR_CELESTIAL_SILVER, EquipmentSlotType.LEGS));
    public static final RegistryObject<ArmorItem> AIR_CELESTIAL_SILVER_BOOTS = Registration.ITEMS.register("air_celestial_silver_boots",
            () -> new AirArmor(ModArmorMaterial.AIR_CELESTIAL_SILVER, EquipmentSlotType.FEET));
    public static final RegistryObject<AirSword> AIR_CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("air_celestial_silver_sword",
            () -> new AirSword(ModItemTier.CELESTIAL_SILVER, 3, -2.4F));
    // Empyrean Steel
    public static final RegistryObject<Item> EMPYREAN_STEEL_INGOT = Registration.ITEMS.register("empyrean_steel_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<ArmorItem> EMPYREAN_STEEL_HELMET = Registration.ITEMS.register("empyrean_steel_helmet",
            () -> new ModArmor(ModArmorMaterial.EMPYREAN_STEEL, EquipmentSlotType.HEAD));
    public static final RegistryObject<ArmorItem> EMPYREAN_STEEL_CHESTPLATE = Registration.ITEMS.register("empyrean_steel_chestplate",
            () -> new ModArmor(ModArmorMaterial.EMPYREAN_STEEL, EquipmentSlotType.CHEST));
    public static final RegistryObject<ArmorItem> EMPYREAN_STEEL_LEGGINGS = Registration.ITEMS.register("empyrean_steel_leggings",
            () -> new ModArmor(ModArmorMaterial.EMPYREAN_STEEL, EquipmentSlotType.LEGS));
    public static final RegistryObject<ArmorItem> EMPYREAN_STEEL_BOOTS = Registration.ITEMS.register("empyrean_steel_boots",
            () -> new ModArmor(ModArmorMaterial.EMPYREAN_STEEL, EquipmentSlotType.FEET));
    public static final RegistryObject<ModSwordItem> EMPYREAN_STEEL_SWORD = Registration.ITEMS.register("empyrean_steel_sword",
            () -> new ModSwordItem(ModItemTier.EMPYREAN_STEEL, 4, -2.4F));
    // Ghost Diamond

    // Infused Metals
    public static final RegistryObject<Item> LAVA_CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("lava_celestial_silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> WATER_CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("water_celestial_silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> AIR_CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("air_celestial_silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> EARTH_CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("earth_celestial_silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));

    public static final RegistryObject<Item> LAVA_EMPYREAN_STEEL_INGOT = Registration.ITEMS.register("lava_empyrean_steel_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> WATER_EMPYREAN_STEEL_INGOT = Registration.ITEMS.register("water_empyrean_steel_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> AIR_EMPYREAN_STEEL_INGOT = Registration.ITEMS.register("air_empyrean_steel_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));
    public static final RegistryObject<Item> EARTH_EMPYREAN_STEEL_INGOT = Registration.ITEMS.register("earth_empyrean_steel_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).isImmuneToFire()));


    static void register() {}
}
