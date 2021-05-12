package net.sovereign.cultivation.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.setup.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CultivationMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.CELESTIAL_SILVER_BLOCK.get());
        simpleBlock(ModBlocks.CELESTIAL_SILVER_ORE.get());
        simpleBlock(ModBlocks.EMPYREAN_STEEL_BLOCK.get());
    }
}
