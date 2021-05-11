package net.sovereign.cultivation.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sovereign.cultivation.CultivationMod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CultivationMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("celestial_silver_block", modLoc("block/celestial_silver_block"));
        withExistingParent("celestial_silver_ore", modLoc("block/celestial_silver_ore"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "celestial_silver_ingot");
        builder(itemGenerated, "celestial_silver_sword");
        builder(itemGenerated, "celestial_silver_pickaxe");
        builder(itemGenerated, "celestial_silver_axe");
        builder(itemGenerated, "celestial_silver_shovel");
        builder(itemGenerated, "celestial_silver_helmet");
        builder(itemGenerated, "celestial_silver_chestplate");
        builder(itemGenerated, "celestial_silver_leggings");
        builder(itemGenerated, "celestial_silver_boots");

        builder(itemGenerated, "inferior_lava_crystal");
        builder(itemGenerated, "basic_lava_crystal");
        builder(itemGenerated, "enhanced_lava_crystal");
        builder(itemGenerated, "superior_lava_crystal");
        builder(itemGenerated, "inferior_hell_bead");
        builder(itemGenerated, "basic_hell_bead");
        builder(itemGenerated, "enhanced_hell_bead");
        builder(itemGenerated, "superior_hell_bead");
        builder(itemGenerated, "lava_celestial_silver_ingot");
        builder(itemGenerated, "lava_celestial_silver_helmet");
        builder(itemGenerated, "lava_celestial_silver_chestplate");
        builder(itemGenerated, "lava_celestial_silver_leggings");
        builder(itemGenerated, "lava_celestial_silver_boots");

        builder(itemGenerated, "inferior_water_bead");
        builder(itemGenerated, "basic_water_bead");
        builder(itemGenerated, "enhanced_water_bead");
        builder(itemGenerated, "superior_water_bead");
        builder(itemGenerated, "inferior_celestial_ice");
        builder(itemGenerated, "basic_celestial_ice");
        builder(itemGenerated, "enhanced_celestial_ice");
        builder(itemGenerated, "superior_celestial_ice");
        builder(itemGenerated, "water_celestial_silver_ingot");
        builder(itemGenerated, "water_celestial_silver_helmet");
        builder(itemGenerated, "water_celestial_silver_chestplate");
        builder(itemGenerated, "water_celestial_silver_leggings");
        builder(itemGenerated, "water_celestial_silver_boots");

        builder(itemGenerated, "inferior_rock");
        builder(itemGenerated, "basic_rock");
        builder(itemGenerated, "enhanced_rock");
        builder(itemGenerated, "superior_rock");
        builder(itemGenerated, "inferior_immortal_rock");
        builder(itemGenerated, "basic_immortal_rock");
        builder(itemGenerated, "enhanced_immortal_rock");
        builder(itemGenerated, "superior_immortal_rock");
        builder(itemGenerated, "earth_celestial_silver_ingot");
        builder(itemGenerated, "earth_celestial_silver_helmet");
        builder(itemGenerated, "earth_celestial_silver_chestplate");
        builder(itemGenerated, "earth_celestial_silver_leggings");
        builder(itemGenerated, "earth_celestial_silver_boots");

        builder(itemGenerated, "inferior_wind_essence");
        builder(itemGenerated, "basic_wind_essence");
        builder(itemGenerated, "enhanced_wind_essence");
        builder(itemGenerated, "superior_wind_essence");
        builder(itemGenerated, "inferior_ethereal_gale");
        builder(itemGenerated, "basic_ethereal_gale");
        builder(itemGenerated, "enhanced_ethereal_gale");
        builder(itemGenerated, "superior_ethereal_gale");
        builder(itemGenerated, "air_celestial_silver_ingot");
        builder(itemGenerated, "air_celestial_silver_helmet");
        builder(itemGenerated, "air_celestial_silver_chestplate");
        builder(itemGenerated, "air_celestial_silver_leggings");
        builder(itemGenerated, "air_celestial_silver_boots");

        builder(itemGenerated, "empyrean_steel_ingot");
    }

    private void builder(ModelFile itemGenerated, String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
