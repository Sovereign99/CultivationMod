package net.sovereign.cultivation.setup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.sovereign.cultivation.setup.ModArmors.ModArmor;
import net.sovereign.cultivation.setup.ModArmors.CelestialSilverMaterial;
import net.sovereign.cultivation.setup.ModTools.CelestialSilverAxe;
import net.sovereign.cultivation.setup.ModTools.CelestialSilverPickaxe;
import net.sovereign.cultivation.setup.ModTools.CelestialSilverShovel;
import net.sovereign.cultivation.setup.ModWeapons.CelestialSilverSword;

public class ModItems {
    // Lava Crystals (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_LAVA_CRYSTAL = Registration.ITEMS.register("inferior_lava_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BASIC_LAVA_CRYSTAL = Registration.ITEMS.register("basic_lava_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENHANCED_LAVA_CRYSTAL = Registration.ITEMS.register("enhanced_lava_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SUPERIOR_LAVA_CRYSTAL = Registration.ITEMS.register("superior_lava_crystal",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    // Hell Bead (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_HELL_BEAD = Registration.ITEMS.register("inferior_hell_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BASIC_HELL_BEAD = Registration.ITEMS.register("basic_hell_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENHANCED_HELL_BEAD = Registration.ITEMS.register("enhanced_hell_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SUPERIOR_HELL_BEAD = Registration.ITEMS.register("superior_hell_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    // Water Bead (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_WATER_BEAD = Registration.ITEMS.register("inferior_water_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BASIC_WATER_BEAD = Registration.ITEMS.register("basic_water_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENHANCED_WATER_BEAD = Registration.ITEMS.register("enhanced_water_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SUPERIOR_WATER_BEAD = Registration.ITEMS.register("superior_water_bead",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    // Celestial Ice (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_CELESTIAL_ICE = Registration.ITEMS.register("inferior_celestial_ice",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BASIC_CELESTIAL_ICE = Registration.ITEMS.register("basic_celestial_ice",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENHANCED_CELESTIAL_ICE = Registration.ITEMS.register("enhanced_celestial_ice",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SUPERIOR_CELESTIAL_ICE = Registration.ITEMS.register("superior_celestial_ice",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    // Wind Essence (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_WIND_ESSENCE = Registration.ITEMS.register("inferior_wind_essence",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BASIC_WIND_ESSENCE = Registration.ITEMS.register("basic_wind_essence",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENHANCED_WIND_ESSENCE = Registration.ITEMS.register("enhanced_wind_essence",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SUPERIOR_WIND_ESSENCE = Registration.ITEMS.register("superior_wind_essence",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    // Ethereal Gale (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_ETHEREAL_GALE = Registration.ITEMS.register("inferior_ethereal_gale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BASIC_ETHEREAL_GALE = Registration.ITEMS.register("basic_ethereal_gale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENHANCED_ETHEREAL_GALE = Registration.ITEMS.register("enhanced_ethereal_gale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SUPERIOR_ETHEREAL_GALE = Registration.ITEMS.register("superior_ethereal_gale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    // Rock (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_ROCK = Registration.ITEMS.register("inferior_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BASIC_ROCK = Registration.ITEMS.register("basic_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENHANCED_ROCK = Registration.ITEMS.register("enhanced_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SUPERIOR_ROCK = Registration.ITEMS.register("superior_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    // Immortal Rock (Inferior, Basic, Enhanced, Superior)
    public static final RegistryObject<Item> INFERIOR_IMMORTAL_ROCK = Registration.ITEMS.register("inferior_immortal_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> BASIC_IMMORTAL_ROCK = Registration.ITEMS.register("basic_immortal_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENHANCED_IMMORTAL_ROCK = Registration.ITEMS.register("enhanced_immortal_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> SUPERIOR_IMMORTAL_ROCK = Registration.ITEMS.register("superior_immortal_rock",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    // Celestial Silver
    public static final RegistryObject<Item> CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("celestial_silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<SwordItem> CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("celestial_silver_sword",
            CelestialSilverSword::new);
    public static final RegistryObject<PickaxeItem> CELESTIAL_SILVER_PICKAXE = Registration.ITEMS.register("celestial_silver_pickaxe",
            CelestialSilverPickaxe::new);
    public static final RegistryObject<AxeItem> CELESTIAL_SILVER_AXE = Registration.ITEMS.register("celestial_silver_axe",
            CelestialSilverAxe::new);
    public static final RegistryObject<ShovelItem> CELESTIAL_SILVER_SHOVEL = Registration.ITEMS.register("celestial_silver_shovel",
            CelestialSilverShovel::new);
    public static final IArmorMaterial CELESTIAL_SILVER_ARMOR_MATERIAL = new CelestialSilverMaterial();
    public static final RegistryObject<ArmorItem> CELESTIAL_SILVER_HELMET = Registration.ITEMS.register("celestial_silver_helmet",
            () -> new ModArmor(CELESTIAL_SILVER_ARMOR_MATERIAL, EquipmentSlotType.HEAD));
    public static final RegistryObject<ArmorItem> CELESTIAL_SILVER_CHESTPLATE = Registration.ITEMS.register("celestial_silver_chestplate",
            () -> new ModArmor(CELESTIAL_SILVER_ARMOR_MATERIAL, EquipmentSlotType.CHEST));
    public static final RegistryObject<ArmorItem> CELESTIAL_SILVER_LEGGINGS = Registration.ITEMS.register("celestial_silver_leggings",
            () -> new ModArmor(CELESTIAL_SILVER_ARMOR_MATERIAL, EquipmentSlotType.LEGS));
    public static final RegistryObject<ArmorItem> CELESTIAL_SILVER_BOOTS = Registration.ITEMS.register("celestial_silver_boots",
            () -> new ModArmor(CELESTIAL_SILVER_ARMOR_MATERIAL, EquipmentSlotType.FEET));
    // Empyrean Steel

    // Ghost Diamond

    static void register() {}
}
