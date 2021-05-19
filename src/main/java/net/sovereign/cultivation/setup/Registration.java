package net.sovereign.cultivation.setup;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.Affinity;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.sovereign.cultivation.handlers.CapabilityHandler;
import net.sovereign.cultivation.handlers.EventHandler;
import net.sovereign.cultivation.setup.network.PacketHandler;
import net.sovereign.cultivation.setup.tile_entities.ModContainerTypes;
import net.sovereign.cultivation.setup.tile_entities.ModRecipes;
import net.sovereign.cultivation.setup.tile_entities.ModTileEntityTypes;
import net.sovereign.cultivation.world.OreGeneration;


public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CultivationMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CultivationMod.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, CultivationMod.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CultivationMod.MOD_ID);
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CultivationMod.MOD_ID);

    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        CONTAINERS.register(modEventBus);
        ITEMS.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
        TILE_ENTITIES.register(modEventBus);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        ModItems.register();
        ModBlocks.register();
        ModContainerTypes.register();
        ModTileEntityTypes.register();
        ModRecipes.register();
    }
}
