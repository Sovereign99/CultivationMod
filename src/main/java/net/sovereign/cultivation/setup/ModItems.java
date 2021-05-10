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

    // Hell Bead (Inferior, Basic, Enhanced, Superior)

    // Water Bead (Inferior, Basic, Enhanced, Superior)

    // Celestial Ice (Inferior, Basic, Enhanced, Superior)

    // Essence of Wind (Inferior, Basic, Enhanced, Superior)

    // Ethereal Gale (Inferior, Basic, Enhanced, Superior)

    // Rock (Inferior, Basic, Enhanced, Superior)

    // Immortal Rock (Inferior, Basic, Enhanced, Superior)

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
