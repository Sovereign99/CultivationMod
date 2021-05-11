package net.sovereign.cultivation.data;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.sovereign.cultivation.CultivationMod;
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
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.CELESTIAL_SILVER_ORE.get()), ModItems.CELESTIAL_SILVER_INGOT.get(), 50.0f, 800)
                .addCriterion("has_item", hasItem(ModBlocks.CELESTIAL_SILVER_ORE.get()))
                .build(consumer, modId("silver_ingot_smelting"));
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ModBlocks.CELESTIAL_SILVER_ORE.get()), ModItems.CELESTIAL_SILVER_INGOT.get(), 50.0f, 400)
                .addCriterion("has_item", hasItem(ModBlocks.CELESTIAL_SILVER_ORE.get()))
                .build(consumer, modId("silver_ingot_blasting"));

        //Ingot to storage block
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.CELESTIAL_SILVER_BLOCK.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Sword recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_SWORD.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine(" # ")
                .patternLine(" # ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Pickaxe recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_PICKAXE.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine("###")
                .patternLine(" / ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Axe recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_AXE.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine("## ")
                .patternLine("#/ ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Shovel recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_SHOVEL.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine(" # ")
                .patternLine(" / ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Helmet Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_HELMET.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Chestplate Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_CHESTPLATE.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Leggings Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_LEGGINGS.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("# #")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Boots Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_BOOTS.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Inferior Lava Crystal
        ShapedRecipeBuilder.shapedRecipe(ModItems.INFERIOR_LAVA_CRYSTAL.get())
                .key('#', Items.LAVA_BUCKET)
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(Items.LAVA_BUCKET))
                .build(consumer);

        //Lava Infused Celestial Silver
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.LAVA_CELESTIAL_SILVER_INGOT.get(), 1)
                .addIngredient(ModItems.CELESTIAL_SILVER_INGOT.get())
                .addIngredient(ModItems.INFERIOR_LAVA_CRYSTAL.get())
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_LAVA_CRYSTAL.get())).build(consumer);
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(CultivationMod.MOD_ID, path);
    }
}
