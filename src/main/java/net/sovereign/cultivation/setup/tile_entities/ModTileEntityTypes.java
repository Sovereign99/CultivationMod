package net.sovereign.cultivation.setup.tile_entities;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.sovereign.cultivation.data.block.mystic_forge.MysticForgeTileEntity;
import net.sovereign.cultivation.setup.ModBlocks;
import net.sovereign.cultivation.setup.Registration;

import java.util.Arrays;
import java.util.function.Supplier;

public class ModTileEntityTypes {
    public static final RegistryObject<TileEntityType<MysticForgeTileEntity>> MYSTIC_FORGE = register(
            "mystic_forge",
            MysticForgeTileEntity::new,
            ModBlocks.MYSTIC_FORGE
    );

    public static void register() {}

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factory, RegistryObject<? extends Block> block) {
        return Registration.TILE_ENTITIES.register(name, () -> {
            //noinspection ConstantConditions - null in build
            return TileEntityType.Builder.create(factory, block.get()).build(null);
        });
    }
}
