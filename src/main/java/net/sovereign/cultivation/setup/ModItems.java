package net.sovereign.cultivation.setup;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.sovereign.cultivation.setup.ModTools.CelestialSilverAxe;
import net.sovereign.cultivation.setup.ModTools.CelestialSilverPickaxe;
import net.sovereign.cultivation.setup.ModTools.CelestialSilverShovel;
import net.sovereign.cultivation.setup.ModWeapons.CelestialSilverSword;

public class ModItems {
    public static final RegistryObject<Item> CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("celestial_silver_ingot", () ->
            new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<SwordItem> CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("celestial_silver_sword", CelestialSilverSword::new);
    public static final RegistryObject<PickaxeItem> CELESTIAL_SILVER_PICKAXE = Registration.ITEMS.register("celestial_silver_pickaxe", CelestialSilverPickaxe::new);
    public static final RegistryObject<AxeItem> CELESTIAL_SILVER_AXE = Registration.ITEMS.register("celestial_silver_axe", CelestialSilverAxe::new);
    public static final RegistryObject<ShovelItem> CELESTIAL_SILVER_SHOVEL = Registration.ITEMS.register("celestial_silver_shovel", CelestialSilverShovel::new);

    static void register() {}
}
