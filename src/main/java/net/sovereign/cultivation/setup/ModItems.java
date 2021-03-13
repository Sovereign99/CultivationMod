package net.sovereign.cultivation.setup;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("celestial_silver_ingot", () ->
            new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<SwordItem> CELESTIAL_SILVER_SWORD = Registration.ITEMS.register("celestial_silver_sword", () ->
            new SwordItem(4, 10, 4, ));
    static void register() {}
}
