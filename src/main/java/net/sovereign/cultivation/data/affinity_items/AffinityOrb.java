package net.sovereign.cultivation.data.affinity_items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.sovereign.cultivation.capabilities.Affinity;
import net.sovereign.cultivation.capabilities.IAffinity;
import org.jetbrains.annotations.NotNull;

public class AffinityOrb extends Item {
    public AffinityOrb() {
        super(new Item.Properties().group(ItemGroup.MISC));
    }

    @Override
    public @NotNull ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, PlayerEntity playerIn, @NotNull Hand handIn) {
        playerIn.getCapability(Affinity.AFFINITY_CAP).ifPresent(IAffinity::assignAffinity);
        playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
