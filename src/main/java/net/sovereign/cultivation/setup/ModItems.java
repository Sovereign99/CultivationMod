package net.sovereign.cultivation.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> CELESTIAL_SILVER_INGOT = Registration.ITEMS.register("celestial_silver_ingot", () ->
            new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    static void register() {}
}
