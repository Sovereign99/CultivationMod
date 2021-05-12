package net.sovereign.cultivation.crafting.recipe;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.setup.ModBlocks;
import net.sovereign.cultivation.setup.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(@NotNull Consumer<IFinishedRecipe> consumer) {
        //Storage block to ingot
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CELESTIAL_SILVER_INGOT.get(), 9)
                .addIngredient(ModBlocks.CELESTIAL_SILVER_BLOCK.get()).addCriterion("has_item",
                hasItem(ModItems.CELESTIAL_SILVER_INGOT.get())).build(consumer);

        //Ore to ingot, for furnace and blast furnace
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.CELESTIAL_SILVER_ORE.get()), ModItems.CELESTIAL_SILVER_INGOT.get(), 10.0f, 300)
                .addCriterion("has_item", hasItem(ModBlocks.CELESTIAL_SILVER_ORE.get()))
                .build(consumer, modId("silver_ingot_smelting"));
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ModBlocks.CELESTIAL_SILVER_ORE.get()), ModItems.CELESTIAL_SILVER_INGOT.get(), 10.0f, 150)
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

        //Hoe recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_HOE.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine("## ")
                .patternLine(" / ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Celestial Silver Helmet Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_HELMET.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Celestial Silver Chestplate Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_CHESTPLATE.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Celestial Silver Leggings Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_LEGGINGS.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("# #")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Celestial Silver Boots Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.CELESTIAL_SILVER_BOOTS.get())
                .key('#', ModItems.CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Lava Infused Celestial Silver
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.LAVA_CELESTIAL_SILVER_INGOT.get(), 1)
                .addIngredient(ModItems.CELESTIAL_SILVER_INGOT.get())
                .addIngredient(ModItems.INFERIOR_LAVA_CRYSTAL.get())
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_LAVA_CRYSTAL.get())).build(consumer);

        //Inferior Lava Crystal
        ShapedRecipeBuilder.shapedRecipe(ModItems.INFERIOR_LAVA_CRYSTAL.get())
                .key('#', Items.LAVA_BUCKET)
                .patternLine(" # ")
                .patternLine("# #")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(Items.LAVA_BUCKET))
                .build(consumer);

        //Basic Lava Crystal
        ShapedRecipeBuilder.shapedRecipe(ModItems.BASIC_LAVA_CRYSTAL.get())
                .key('#', ModItems.INFERIOR_LAVA_CRYSTAL.get())
                .key('/', ModItems.LAVA_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" # ")
                .patternLine("/#/")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_LAVA_CRYSTAL.get()))
                .build(consumer);

        //Enhanced Lava Crystal
        ShapedRecipeBuilder.shapedRecipe(ModItems.ENHANCED_LAVA_CRYSTAL.get())
                .key('#', ModItems.BASIC_LAVA_CRYSTAL.get())
                .key('/', ModItems.LAVA_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" / ")
                .patternLine("###")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.BASIC_LAVA_CRYSTAL.get()))
                .build(consumer);

        //Superior Lava Crystal
        ShapedRecipeBuilder.shapedRecipe(ModItems.SUPERIOR_LAVA_CRYSTAL.get())
                .key('#', ModItems.ENHANCED_LAVA_CRYSTAL.get())
                .key('/', ModItems.LAVA_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" # ")
                .patternLine("#/#")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(ModItems.ENHANCED_LAVA_CRYSTAL.get()))
                .build(consumer);

        //Inferior Hell Bead
        ShapedRecipeBuilder.shapedRecipe(ModItems.INFERIOR_HELL_BEAD.get())
                .key('#', ModItems.SUPERIOR_LAVA_CRYSTAL.get())
                .key('*', Items.BLAZE_POWDER)
                .patternLine("*#*")
                .patternLine("#*#")
                .patternLine("*#*")
                .addCriterion("has_item", hasItem(ModItems.SUPERIOR_LAVA_CRYSTAL.get()))
                .build(consumer);

        //Lava Celestial Silver Helmet Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.LAVA_CELESTIAL_SILVER_HELMET.get())
                .key('#', ModItems.LAVA_CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.LAVA_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Lava Celestial Silver Chestplate Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.LAVA_CELESTIAL_SILVER_CHESTPLATE.get())
                .key('#', ModItems.LAVA_CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.LAVA_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Lava Celestial Silver Leggings Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.LAVA_CELESTIAL_SILVER_LEGGINGS.get())
                .key('#', ModItems.LAVA_CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("# #")
                .addCriterion("has_item", hasItem(ModItems.LAVA_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Lava Celestial Silver Boots Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.LAVA_CELESTIAL_SILVER_BOOTS.get())
                .key('#', ModItems.LAVA_CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.LAVA_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Lava Celestial Silver Sword Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.LAVA_CELESTIAL_SILVER_SWORD.get())
                .key('#', ModItems.LAVA_CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine(" # ")
                .patternLine(" # ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.LAVA_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Water Infused Celestial Silver
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.WATER_CELESTIAL_SILVER_INGOT.get(), 1)
                .addIngredient(ModItems.CELESTIAL_SILVER_INGOT.get())
                .addIngredient(ModItems.INFERIOR_WATER_BEAD.get())
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_WATER_BEAD.get())).build(consumer);

        //Inferior Water Bead
        ShapedRecipeBuilder.shapedRecipe(ModItems.INFERIOR_WATER_BEAD.get())
                .key('#', Items.WATER_BUCKET)
                .patternLine(" # ")
                .patternLine("# #")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(Items.WATER_BUCKET))
                .build(consumer);

        //Basic Water Bead
        ShapedRecipeBuilder.shapedRecipe(ModItems.BASIC_WATER_BEAD.get())
                .key('#', ModItems.INFERIOR_WATER_BEAD.get())
                .key('/', ModItems.WATER_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" # ")
                .patternLine("/#/")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_WATER_BEAD.get()))
                .build(consumer);

        //Enhanced Water Bead
        ShapedRecipeBuilder.shapedRecipe(ModItems.ENHANCED_WATER_BEAD.get())
                .key('#', ModItems.BASIC_WATER_BEAD.get())
                .key('/', ModItems.WATER_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" / ")
                .patternLine("###")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.BASIC_WATER_BEAD.get()))
                .build(consumer);

        //Superior Water Bead
        ShapedRecipeBuilder.shapedRecipe(ModItems.SUPERIOR_WATER_BEAD.get())
                .key('#', ModItems.ENHANCED_WATER_BEAD.get())
                .key('/', ModItems.WATER_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" # ")
                .patternLine("#/#")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(ModItems.ENHANCED_WATER_BEAD.get()))
                .build(consumer);

        //Water Celestial Silver Helmet Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.WATER_CELESTIAL_SILVER_HELMET.get())
                .key('#', ModItems.WATER_CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.WATER_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Water Celestial Silver Chestplate Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.WATER_CELESTIAL_SILVER_CHESTPLATE.get())
                .key('#', ModItems.WATER_CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.WATER_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Water Celestial Silver Leggings Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.WATER_CELESTIAL_SILVER_LEGGINGS.get())
                .key('#', ModItems.WATER_CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("# #")
                .addCriterion("has_item", hasItem(ModItems.WATER_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Water Celestial Silver Boots Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.WATER_CELESTIAL_SILVER_BOOTS.get())
                .key('#', ModItems.WATER_CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.WATER_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Water Celestial Silver Sword Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.WATER_CELESTIAL_SILVER_SWORD.get())
                .key('#', ModItems.WATER_CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine(" # ")
                .patternLine(" # ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.WATER_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Air Infused Celestial Silver
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.AIR_CELESTIAL_SILVER_INGOT.get(), 1)
                .addIngredient(ModItems.CELESTIAL_SILVER_INGOT.get())
                .addIngredient(ModItems.INFERIOR_WIND_ESSENCE.get())
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_WIND_ESSENCE.get())).build(consumer);

        //Inferior Wind Essence
        ShapedRecipeBuilder.shapedRecipe(ModItems.INFERIOR_WIND_ESSENCE.get())
                .key('#', Items.FEATHER)
                .patternLine(" # ")
                .patternLine("# #")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(Items.FEATHER))
                .build(consumer);

        //Basic Wind Essence
        ShapedRecipeBuilder.shapedRecipe(ModItems.BASIC_WIND_ESSENCE.get())
                .key('#', ModItems.INFERIOR_WIND_ESSENCE.get())
                .key('/', ModItems.AIR_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" # ")
                .patternLine("/#/")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_WIND_ESSENCE.get()))
                .build(consumer);

        //Enhanced Wind Essence
        ShapedRecipeBuilder.shapedRecipe(ModItems.ENHANCED_WIND_ESSENCE.get())
                .key('#', ModItems.BASIC_WIND_ESSENCE.get())
                .key('/', ModItems.AIR_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" / ")
                .patternLine("###")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.BASIC_WIND_ESSENCE.get()))
                .build(consumer);

        //Superior Wind Essence
        ShapedRecipeBuilder.shapedRecipe(ModItems.SUPERIOR_WIND_ESSENCE.get())
                .key('#', ModItems.ENHANCED_WIND_ESSENCE.get())
                .key('/', ModItems.AIR_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" # ")
                .patternLine("#/#")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(ModItems.ENHANCED_WIND_ESSENCE.get()))
                .build(consumer);

        //Air Celestial Silver Helmet Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.AIR_CELESTIAL_SILVER_HELMET.get())
                .key('#', ModItems.AIR_CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.AIR_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Air Celestial Silver Chestplate Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.AIR_CELESTIAL_SILVER_CHESTPLATE.get())
                .key('#', ModItems.AIR_CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.AIR_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Air Celestial Silver Leggings Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.AIR_CELESTIAL_SILVER_LEGGINGS.get())
                .key('#', ModItems.AIR_CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("# #")
                .addCriterion("has_item", hasItem(ModItems.AIR_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Air Celestial Silver Boots Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.AIR_CELESTIAL_SILVER_BOOTS.get())
                .key('#', ModItems.AIR_CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.AIR_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Air Celestial Silver Sword Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.AIR_CELESTIAL_SILVER_SWORD.get())
                .key('#', ModItems.AIR_CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine(" # ")
                .patternLine(" # ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.AIR_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Earth Infused Celestial Silver
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EARTH_CELESTIAL_SILVER_INGOT.get(), 1)
                .addIngredient(ModItems.CELESTIAL_SILVER_INGOT.get())
                .addIngredient(ModItems.INFERIOR_ROCK.get())
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_ROCK.get())).build(consumer);

        //Inferior Rock
        ShapedRecipeBuilder.shapedRecipe(ModItems.INFERIOR_ROCK.get())
                .key('#', Items.STONE)
                .patternLine(" # ")
                .patternLine("# #")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(Items.STONE))
                .build(consumer);

        //Basic Rock
        ShapedRecipeBuilder.shapedRecipe(ModItems.BASIC_ROCK.get())
                .key('#', ModItems.INFERIOR_ROCK.get())
                .key('/', ModItems.EARTH_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" # ")
                .patternLine("/#/")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(ModItems.INFERIOR_ROCK.get()))
                .build(consumer);

        //Enhanced Rock
        ShapedRecipeBuilder.shapedRecipe(ModItems.ENHANCED_ROCK.get())
                .key('#', ModItems.BASIC_ROCK.get())
                .key('/', ModItems.EARTH_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" / ")
                .patternLine("###")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.BASIC_ROCK.get()))
                .build(consumer);

        //Superior Rock
        ShapedRecipeBuilder.shapedRecipe(ModItems.SUPERIOR_ROCK.get())
                .key('#', ModItems.ENHANCED_ROCK.get())
                .key('/', ModItems.EARTH_CELESTIAL_SILVER_INGOT.get())
                .patternLine(" # ")
                .patternLine("#/#")
                .patternLine(" # ")
                .addCriterion("has_item", hasItem(ModItems.ENHANCED_ROCK.get()))
                .build(consumer);

        //Earth Celestial Silver Helmet Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EARTH_CELESTIAL_SILVER_HELMET.get())
                .key('#', ModItems.EARTH_CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.EARTH_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Earth Celestial Silver Chestplate Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EARTH_CELESTIAL_SILVER_CHESTPLATE.get())
                .key('#', ModItems.EARTH_CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.EARTH_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Earth Celestial Silver Leggings Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EARTH_CELESTIAL_SILVER_LEGGINGS.get())
                .key('#', ModItems.EARTH_CELESTIAL_SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("# #")
                .addCriterion("has_item", hasItem(ModItems.EARTH_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Earth Celestial Silver Boots Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EARTH_CELESTIAL_SILVER_BOOTS.get())
                .key('#', ModItems.EARTH_CELESTIAL_SILVER_INGOT.get())
                .patternLine("# #")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.EARTH_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        //Earth Celestial Silver Sword Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EARTH_CELESTIAL_SILVER_SWORD.get())
                .key('#', ModItems.EARTH_CELESTIAL_SILVER_INGOT.get())
                .key('/', Items.STICK)
                .patternLine(" # ")
                .patternLine(" # ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.EARTH_CELESTIAL_SILVER_INGOT.get()))
                .build(consumer);

        /*
        EMPYREAN STEEL
         */
        //Storage block to ingot
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.EMPYREAN_STEEL_INGOT.get(), 9)
                .addIngredient(ModBlocks.EMPYREAN_STEEL_BLOCK.get()).addCriterion("has_item",
                hasItem(ModItems.EMPYREAN_STEEL_INGOT.get())).build(consumer);

        //Ingot to storage block
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.EMPYREAN_STEEL_BLOCK.get())
                .key('#', ModItems.EMPYREAN_STEEL_INGOT.get())
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.EMPYREAN_STEEL_INGOT.get()))
                .build(consumer);

        //Empyrean Steel Helmet Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EMPYREAN_STEEL_HELMET.get())
                .key('#', ModItems.EMPYREAN_STEEL_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.EMPYREAN_STEEL_INGOT.get()))
                .build(consumer);

        //Empyrean Steel Chestplate Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EMPYREAN_STEEL_CHESTPLATE.get())
                .key('#', ModItems.EMPYREAN_STEEL_INGOT.get())
                .patternLine("# #")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.EMPYREAN_STEEL_INGOT.get()))
                .build(consumer);

        //Empyrean Steel Leggings Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EMPYREAN_STEEL_LEGGINGS.get())
                .key('#', ModItems.EMPYREAN_STEEL_INGOT.get())
                .patternLine("###")
                .patternLine("# #")
                .patternLine("# #")
                .addCriterion("has_item", hasItem(ModItems.EMPYREAN_STEEL_INGOT.get()))
                .build(consumer);

        //Empyrean Steel Boots Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EMPYREAN_STEEL_BOOTS.get())
                .key('#', ModItems.EMPYREAN_STEEL_INGOT.get())
                .patternLine("# #")
                .patternLine("# #")
                .patternLine("   ")
                .addCriterion("has_item", hasItem(ModItems.EMPYREAN_STEEL_INGOT.get()))
                .build(consumer);

        //Empyrean Steel Sword Recipe
        ShapedRecipeBuilder.shapedRecipe(ModItems.EMPYREAN_STEEL_SWORD.get())
                .key('#', ModItems.EMPYREAN_STEEL_INGOT.get())
                .key('/', Items.STICK)
                .patternLine(" # ")
                .patternLine(" # ")
                .patternLine(" / ")
                .addCriterion("has_item", hasItem(ModItems.EMPYREAN_STEEL_INGOT.get()))
                .build(consumer);

    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(CultivationMod.MOD_ID, path);
    }
}
