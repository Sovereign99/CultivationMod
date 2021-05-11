package net.sovereign.cultivation.setup.tile_entities;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.crafting.recipe.ForgingRecipe;
import net.sovereign.cultivation.setup.Registration;

import java.util.function.Supplier;

public class ModRecipes {
    public static class Types {
        public static final IRecipeType<ForgingRecipe> FORGING = IRecipeType.register(
                CultivationMod.MOD_ID + "forging");

        private Types() {}
    }

    public static final class Serializers {
        public static final RegistryObject<IRecipeSerializer<?>> FORGING = Registration.RECIPE_SERIALIZERS.register(
                "forging", ForgingRecipe.Serializer::new);

        private Serializers() {}
    }

    private ModRecipes () {}

    public static void register() {}
}
