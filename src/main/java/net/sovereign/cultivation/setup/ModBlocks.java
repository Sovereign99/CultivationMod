package net.sovereign.cultivation.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.sovereign.cultivation.data.block.mystic_forge.MysticForgeBlock;

import javax.tools.Tool;
import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> CELESTIAL_SILVER_ORE = register("celestial_silver_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK)
                .hardnessAndResistance(25.0F, 1200.0F)
                .sound(SoundType.STONE)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> CELESTIAL_SILVER_BLOCK = register("celestial_silver_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(15.0F, 600.0F)
                .sound(SoundType.METAL)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> EMPYREAN_STEEL_BLOCK = register("empyrean_steel_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(20.0F, 600.0F)
                    .sound(SoundType.METAL)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<MysticForgeBlock> MYSTIC_FORGE = register("mystic_forge", () ->
            new MysticForgeBlock(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(4, 20)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)));

    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
        return ret;
    }
}
