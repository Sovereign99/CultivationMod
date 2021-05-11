package net.sovereign.cultivation.crafting.recipe;

import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.sovereign.cultivation.setup.tile_entities.ModRecipes;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ForgingRecipe extends SingleItemRecipe {
    public ForgingRecipe(ResourceLocation recipeId,
                             Ingredient ingredient,
                             ItemStack result) {
        super(ModRecipes.Types.FORGING, ModRecipes.Serializers.FORGING.get(), recipeId, "", ingredient, result);
    }

    @Override
    public boolean matches(IInventory inv, @NotNull World worldIn) {
        return this.ingredient.test(inv.getStackInSlot(0));
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ForgingRecipe> {

        @Override
        public @NotNull ForgingRecipe read(@NotNull ResourceLocation recipeId, JsonObject json) {
            Ingredient ingredient = Ingredient.deserialize(json.get("ingredient"));
            ResourceLocation itemId = new ResourceLocation(JSONUtils.getString(json, "result"));
            int count = JSONUtils.getInt(json, "count", 1);

            ItemStack result = new ItemStack(ForgeRegistries.ITEMS.getValue(itemId), count);
            return new ForgingRecipe(recipeId, ingredient, result);
        }

        @Nullable
        @Override
        public ForgingRecipe read(@NotNull ResourceLocation recipeId, @NotNull PacketBuffer buffer) {
            Ingredient ingredient = Ingredient.read(buffer);
            ItemStack result = buffer.readItemStack();
            return new ForgingRecipe(recipeId, ingredient, result);
        }

        @Override
        public void write(@NotNull PacketBuffer buffer, ForgingRecipe recipe) {
            recipe.ingredient.write(buffer);
            buffer.writeItemStack(recipe.result);
        }
    }
}
