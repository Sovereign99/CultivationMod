package net.sovereign.cultivation.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.setup.ModItems;
import net.sovereign.cultivation.setup.ModTags;


public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, CultivationMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
        copy(ModTags.Blocks.STORAGE_BLOCKS_STEEL, ModTags.Items.STORAGE_BLOCKS_STEEL);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.INFERIOR_LAVA_CRYSTAL.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.BASIC_LAVA_CRYSTAL.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.ENHANCED_LAVA_CRYSTAL.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.SUPERIOR_LAVA_CRYSTAL.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.INFERIOR_HELL_BEAD.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.BASIC_HELL_BEAD.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.ENHANCED_HELL_BEAD.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.SUPERIOR_HELL_BEAD.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.INFERIOR_WATER_BEAD.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.BASIC_WATER_BEAD.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.ENHANCED_WATER_BEAD.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.SUPERIOR_WATER_BEAD.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.INFERIOR_CELESTIAL_ICE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.BASIC_CELESTIAL_ICE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.ENHANCED_CELESTIAL_ICE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.SUPERIOR_CELESTIAL_ICE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.INFERIOR_WIND_ESSENCE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.BASIC_WIND_ESSENCE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.ENHANCED_WIND_ESSENCE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.SUPERIOR_WIND_ESSENCE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.INFERIOR_ETHEREAL_GALE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.BASIC_ETHEREAL_GALE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.ENHANCED_ETHEREAL_GALE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.SUPERIOR_ETHEREAL_GALE.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.INFERIOR_ROCK.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.BASIC_ROCK.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.ENHANCED_ROCK.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.SUPERIOR_ROCK.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.INFERIOR_IMMORTAL_ROCK.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.BASIC_IMMORTAL_ROCK.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.ENHANCED_IMMORTAL_ROCK.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.SUPERIOR_IMMORTAL_ROCK.get());

        getOrCreateBuilder(ModTags.Items.AFFINITY).add(ModItems.AFFINITY_ORB.get());
        getOrCreateBuilder(ModTags.Items.AFFINITY).add(ModItems.EMPTY_CORE.get());
        getOrCreateBuilder(ModTags.Items.AFFINITY).add(ModItems.MAGMATIC_EMBRYO.get());
        getOrCreateBuilder(ModTags.Items.AFFINITY).add(ModItems.HEART_OF_THE_DEPTHS.get());
        getOrCreateBuilder(ModTags.Items.AFFINITY).add(ModItems.TEAR_OF_STONE.get());
        getOrCreateBuilder(ModTags.Items.AFFINITY).add(ModItems.EYE_OF_STORMS.get());
        getOrCreateBuilder(ModTags.Items.AFFINITY).add(ModItems.HEAVENLY_LIGHT.get());
        getOrCreateBuilder(ModTags.Items.AFFINITY).add(ModItems.VOID_CORE.get());

        getOrCreateBuilder(ModTags.Items.PILL).add(ModItems.GREATER_HEAL_PILL.get());
        getOrCreateBuilder(ModTags.Items.PILL).add(ModItems.HIGHGOD_PILL.get());

        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.CELESTIAL_SILVER_INGOT.get());
        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.LAVA_CELESTIAL_SILVER_INGOT.get());
        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.WATER_CELESTIAL_SILVER_INGOT.get());
        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.AIR_CELESTIAL_SILVER_INGOT.get());
        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.EARTH_CELESTIAL_SILVER_INGOT.get());

        getOrCreateBuilder(ModTags.Items.SWORDS_SILVER).add(ModItems.CELESTIAL_SILVER_SWORD.get());
        getOrCreateBuilder(ModTags.Items.PICKAXE_SILVER).add(ModItems.CELESTIAL_SILVER_PICKAXE.get());
        getOrCreateBuilder(ModTags.Items.AXE_SILVER).add(ModItems.CELESTIAL_SILVER_AXE.get());
        getOrCreateBuilder(ModTags.Items.SHOVEL_SILVER).add(ModItems.CELESTIAL_SILVER_SHOVEL.get());
        getOrCreateBuilder(ModTags.Items.HOE_SILVER).add(ModItems.CELESTIAL_SILVER_HOE.get());
        getOrCreateBuilder(ModTags.Items.HELMET_SILVER).add(ModItems.CELESTIAL_SILVER_HELMET.get());
        getOrCreateBuilder(ModTags.Items.CHESTPLATE_SILVER).add(ModItems.CELESTIAL_SILVER_CHESTPLATE.get());
        getOrCreateBuilder(ModTags.Items.LEGGINGS_SILVER).add(ModItems.CELESTIAL_SILVER_LEGGINGS.get());
        getOrCreateBuilder(ModTags.Items.BOOTS_SILVER).add(ModItems.CELESTIAL_SILVER_BOOTS.get());

        getOrCreateBuilder(ModTags.Items.HELMET_SILVER).add(ModItems.LAVA_CELESTIAL_SILVER_HELMET.get());
        getOrCreateBuilder(ModTags.Items.CHESTPLATE_SILVER).add(ModItems.LAVA_CELESTIAL_SILVER_CHESTPLATE.get());
        getOrCreateBuilder(ModTags.Items.LEGGINGS_SILVER).add(ModItems.LAVA_CELESTIAL_SILVER_LEGGINGS.get());
        getOrCreateBuilder(ModTags.Items.BOOTS_SILVER).add(ModItems.LAVA_CELESTIAL_SILVER_BOOTS.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_LAVA).add(ModItems.LAVA_CELESTIAL_SILVER_SWORD.get());

        getOrCreateBuilder(ModTags.Items.HELMET_SILVER).add(ModItems.WATER_CELESTIAL_SILVER_HELMET.get());
        getOrCreateBuilder(ModTags.Items.CHESTPLATE_SILVER).add(ModItems.WATER_CELESTIAL_SILVER_CHESTPLATE.get());
        getOrCreateBuilder(ModTags.Items.LEGGINGS_SILVER).add(ModItems.WATER_CELESTIAL_SILVER_LEGGINGS.get());
        getOrCreateBuilder(ModTags.Items.BOOTS_SILVER).add(ModItems.WATER_CELESTIAL_SILVER_BOOTS.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_WATER).add(ModItems.WATER_CELESTIAL_SILVER_SWORD.get());

        getOrCreateBuilder(ModTags.Items.HELMET_SILVER).add(ModItems.EARTH_CELESTIAL_SILVER_HELMET.get());
        getOrCreateBuilder(ModTags.Items.CHESTPLATE_SILVER).add(ModItems.EARTH_CELESTIAL_SILVER_CHESTPLATE.get());
        getOrCreateBuilder(ModTags.Items.LEGGINGS_SILVER).add(ModItems.EARTH_CELESTIAL_SILVER_LEGGINGS.get());
        getOrCreateBuilder(ModTags.Items.BOOTS_SILVER).add(ModItems.EARTH_CELESTIAL_SILVER_BOOTS.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_EARTH).add(ModItems.EARTH_CELESTIAL_SILVER_SWORD.get());

        getOrCreateBuilder(ModTags.Items.HELMET_SILVER).add(ModItems.AIR_CELESTIAL_SILVER_HELMET.get());
        getOrCreateBuilder(ModTags.Items.CHESTPLATE_SILVER).add(ModItems.AIR_CELESTIAL_SILVER_CHESTPLATE.get());
        getOrCreateBuilder(ModTags.Items.LEGGINGS_SILVER).add(ModItems.AIR_CELESTIAL_SILVER_LEGGINGS.get());
        getOrCreateBuilder(ModTags.Items.BOOTS_SILVER).add(ModItems.AIR_CELESTIAL_SILVER_BOOTS.get());
        getOrCreateBuilder(ModTags.Items.ENHANCEMENT_AIR).add(ModItems.AIR_CELESTIAL_SILVER_SWORD.get());

        getOrCreateBuilder(ModTags.Items.INGOTS_STEEL).add(ModItems.EMPYREAN_STEEL_INGOT.get());
        getOrCreateBuilder(ModTags.Items.HELMET_STEEL).add(ModItems.EMPYREAN_STEEL_HELMET.get());
        getOrCreateBuilder(ModTags.Items.CHESTPLATE_STEEL).add(ModItems.EMPYREAN_STEEL_CHESTPLATE.get());
        getOrCreateBuilder(ModTags.Items.LEGGINGS_STEEL).add(ModItems.EMPYREAN_STEEL_LEGGINGS.get());
        getOrCreateBuilder(ModTags.Items.BOOTS_STEEL).add(ModItems.EMPYREAN_STEEL_BOOTS.get());
        getOrCreateBuilder(ModTags.Items.SWORDS_STEEL).add(ModItems.EMPYREAN_STEEL_SWORD.get());

        getOrCreateBuilder(ModTags.Items.INGOTS_STEEL).add(ModItems.LAVA_EMPYREAN_STEEL_INGOT.get());
        getOrCreateBuilder(ModTags.Items.INGOTS_STEEL).add(ModItems.WATER_EMPYREAN_STEEL_INGOT.get());
        getOrCreateBuilder(ModTags.Items.INGOTS_STEEL).add(ModItems.AIR_EMPYREAN_STEEL_INGOT.get());
        getOrCreateBuilder(ModTags.Items.INGOTS_STEEL).add(ModItems.EARTH_EMPYREAN_STEEL_INGOT.get());
    }
}
