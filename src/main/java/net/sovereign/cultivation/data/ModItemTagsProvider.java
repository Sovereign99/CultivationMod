package net.sovereign.cultivation.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.setup.ModItems;
import net.sovereign.cultivation.setup.ModTags;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, CultivationMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.CELESTIAL_SILVER_INGOT.get());
        getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);
        getOrCreateBuilder(ModTags.Items.SWORDS_SILVER).add(ModItems.CELESTIAL_SILVER_SWORD.get());
        getOrCreateBuilder(ModTags.Items.PICKAXE_SILVER).add(ModItems.CELESTIAL_SILVER_PICKAXE.get());
        getOrCreateBuilder(ModTags.Items.AXE_SILVER).add(ModItems.CELESTIAL_SILVER_AXE.get());
        getOrCreateBuilder(ModTags.Items.SHOVEL_SILVER).add(ModItems.CELESTIAL_SILVER_SHOVEL.get());
    }
}
