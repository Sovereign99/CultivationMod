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
        withExistingParent("empyrean_steel_block", modLoc("block/empyrean_steel_block"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

        builder(itemGenerated, "affinity_orb");

        builder(itemGenerated, "celestial_silver_ingot");
        builder(itemHandheld, "celestial_silver_sword");
        builder(itemHandheld, "celestial_silver_pickaxe");
        builder(itemHandheld, "celestial_silver_axe");
        builder(itemHandheld, "celestial_silver_shovel");
        builder(itemHandheld, "celestial_silver_hoe");
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
        builder(itemGenerated, "lava_empyrean_steel_ingot");
        builder(itemGenerated, "lava_celestial_silver_helmet");
        builder(itemGenerated, "lava_celestial_silver_chestplate");
        builder(itemGenerated, "lava_celestial_silver_leggings");
        builder(itemGenerated, "lava_celestial_silver_boots");
        builder(itemHandheld, "lava_celestial_silver_sword");

        builder(itemGenerated, "inferior_water_bead");
        builder(itemGenerated, "basic_water_bead");
        builder(itemGenerated, "enhanced_water_bead");
        builder(itemGenerated, "superior_water_bead");
        builder(itemGenerated, "inferior_celestial_ice");
        builder(itemGenerated, "basic_celestial_ice");
        builder(itemGenerated, "enhanced_celestial_ice");
        builder(itemGenerated, "superior_celestial_ice");
        builder(itemGenerated, "water_celestial_silver_ingot");
        builder(itemGenerated, "water_empyrean_steel_ingot");
        builder(itemGenerated, "water_celestial_silver_helmet");
        builder(itemGenerated, "water_celestial_silver_chestplate");
        builder(itemGenerated, "water_celestial_silver_leggings");
        builder(itemGenerated, "water_celestial_silver_boots");
        builder(itemHandheld, "water_celestial_silver_sword");

        builder(itemGenerated, "inferior_rock");
        builder(itemGenerated, "basic_rock");
        builder(itemGenerated, "enhanced_rock");
        builder(itemGenerated, "superior_rock");
        builder(itemGenerated, "inferior_immortal_rock");
        builder(itemGenerated, "basic_immortal_rock");
        builder(itemGenerated, "enhanced_immortal_rock");
        builder(itemGenerated, "superior_immortal_rock");
        builder(itemGenerated, "earth_celestial_silver_ingot");
        builder(itemGenerated, "earth_empyrean_steel_ingot");
        builder(itemGenerated, "earth_celestial_silver_helmet");
        builder(itemGenerated, "earth_celestial_silver_chestplate");
        builder(itemGenerated, "earth_celestial_silver_leggings");
        builder(itemGenerated, "earth_celestial_silver_boots");
        builder(itemHandheld, "earth_celestial_silver_sword");

        builder(itemGenerated, "inferior_wind_essence");
        builder(itemGenerated, "basic_wind_essence");
        builder(itemGenerated, "enhanced_wind_essence");
        builder(itemGenerated, "superior_wind_essence");
        builder(itemGenerated, "inferior_ethereal_gale");
        builder(itemGenerated, "basic_ethereal_gale");
        builder(itemGenerated, "enhanced_ethereal_gale");
        builder(itemGenerated, "superior_ethereal_gale");
        builder(itemGenerated, "air_celestial_silver_ingot");
        builder(itemGenerated, "air_empyrean_steel_ingot");
        builder(itemGenerated, "air_celestial_silver_helmet");
        builder(itemGenerated, "air_celestial_silver_chestplate");
        builder(itemGenerated, "air_celestial_silver_leggings");
        builder(itemGenerated, "air_celestial_silver_boots");
        builder(itemHandheld, "air_celestial_silver_sword");

        builder(itemGenerated, "empyrean_steel_ingot");
        builder(itemGenerated, "empyrean_steel_helmet");
        builder(itemGenerated, "empyrean_steel_chestplate");
        builder(itemGenerated, "empyrean_steel_leggings");
        builder(itemGenerated, "empyrean_steel_boots");
        builder(itemHandheld, "empyrean_steel_sword");
    }

    private void builder(ModelFile itemGenerated, String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
