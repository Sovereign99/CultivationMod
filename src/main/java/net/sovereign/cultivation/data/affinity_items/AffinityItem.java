package net.sovereign.cultivation.data.affinity_items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.sovereign.cultivation.capabilities.Affinity;
import net.sovereign.cultivation.capabilities.IAffinity;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class AffinityItem extends Item {
    private final int affinity;
    private final boolean orb;

    private AffinityItem(AffinityItem.Builder builder) {
        super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).isImmuneToFire().rarity(Rarity.EPIC));
        this.affinity = builder.affinity;
        this.orb = builder.orb;
    }

    public int getAffinity() {
        return this.affinity;
    }

    public boolean getOrb() {
        return this.orb;
    }

    @Override
    public @NotNull ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, @NotNull PlayerEntity playerIn, @NotNull Hand handIn) {
        if(!worldIn.isRemote) {
            IAffinity affinity = playerIn.getCapability(Affinity.AFFINITY_CAP).orElse(new Affinity());
            if (!affinity.getOrbed()) {
                affinity.setAffinity(this.getAffinity());
                affinity.setOrbed(this.getOrb());
                playerIn.inventory.deleteStack(playerIn.getHeldItemMainhand());
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public static class Builder {
        private int affinity;
        private boolean orb;

        public AffinityItem.Builder affinity(int affinity) {
            if(affinity < 0) {
                Random rand = new Random();
                int a = rand.nextInt(100);
                if (a < 17) {
                    affinity = 1;
                } else if (a < 33) {
                    affinity = 2;
                } else if (a < 51) {
                    affinity = 3;
                } else if (a < 69) {
                    affinity = 4;
                } else if (a < 79) {
                    affinity = 5;
                } else if (a < 89) {
                    affinity = 6;
                } else {
                    affinity = 0;
                }
            }
            this.affinity = affinity;
            return this;
        }

        public AffinityItem.Builder orb(boolean orb) {
            this.orb = orb;
            return this;
        }

        public AffinityItem build() {
            return new AffinityItem(this);
        }
    }
}
