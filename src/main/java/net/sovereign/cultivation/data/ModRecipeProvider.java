package net.sovereign.cultivation.data;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.sovereign.cultivation.setup.ModBlocks;
import net.sovereign.cultivation.setup.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        //Storage block to ingot
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CELESTIAL_SILVER_INGOT.get(), 9)
                .addIngredient(ModBlocks.CELESTIAL_SILVER_BLOCK.get()).addCriterion("has_item",
                hasItem(ModItems.CELESTIAL_SILVER_INGOT.get())).build(consumer);
        //Ore to ingot, for furnace and blast furnace
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.CELESTIAL_SILVER_ORE.get()), ModItems.CELESTIAL_SILVER_INGOT.get(), 50.0f, 800);
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ModBlocks.CELESTIAL_SILVER_ORE.get()), ModItems.CELESTIAL_SILVER_INGOT.get(), 50.0f, 400);

        //Ingot to storage block
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CELESTIAL_SILVER_BLOCK.get()).key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("###")
                .patternLine("###").addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Sword recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_SWORD.get()).key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK.getItem())
                .patternLine(" # ")
                .patternLine(" # ")
                .patternLine(" / ")
                .build(consumer);
    }
}
