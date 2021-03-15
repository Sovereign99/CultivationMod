package net.sovereign.cultivation.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.sovereign.cultivation.setup.ModTools.CelestialSilverPickaxe;
import net.sovereign.cultivation.setup.ModWeapons.CelestialSilverSword;

public class ModItems {
    public static final RegistryObject<Item> CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("celestial_silver_ingot", () ->
            new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<SwordItem> CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("celestial_silver_sword", () ->
            new CelestialSilverSword());
    public static final RegistryObject<PickaxeItem> CELESTIAL_SILVER_PICKAXE = Registration.ITEMS.register("celestial_silver_pickaxe", () ->
            new CelestialSilverPickaxe());

    static void register() {}
}
