package net.sovereign.cultivation.setup;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }
    }

    public static final class Items {
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");

        public static final ITag.INamedTag<Item> ENHANCEMENT_LAVA = forge("enhancement/lava");
        public static final ITag.INamedTag<Item> ENHANCEMENT_WATER = forge("enhancement/water");
        public static final ITag.INamedTag<Item> ENHANCEMENT_AIR = forge("enhancement/air");
        public static final ITag.INamedTag<Item> ENHANCEMENT_EARTH = forge("enhancement/earth");
        public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("ingots/silver");
        public static final ITag.INamedTag<Item> INGOTS_STEEL = forge("ingots/steel");
        public static final ITag.INamedTag<Item> SWORDS_SILVER = forge("swords/silver");
        public static final ITag.INamedTag<Item> PICKAXE_SILVER = forge("pickaxe/silver");
        public static final ITag.INamedTag<Item> AXE_SILVER = forge("axe/silver");
        public static final ITag.INamedTag<Item> SHOVEL_SILVER = forge("shovel/silver");
        public static final ITag.INamedTag<Item> HOE_SILVER = forge("hoe/silver");
        public static final ITag.INamedTag<Item> HELMET_SILVER = forge("armor/silver/helmet");
        public static final ITag.INamedTag<Item> CHESTPLATE_SILVER = forge("armor/silver/chestplate");
        public static final ITag.INamedTag<Item> LEGGINGS_SILVER = forge("armor/silver/leggings");
        public static final ITag.INamedTag<Item> BOOTS_SILVER = forge("armor/silver/boots");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }
    }
}
