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
    }

    private void builder(ModelFile itemGenerated, String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
