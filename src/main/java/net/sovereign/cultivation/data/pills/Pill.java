package net.sovereign.cultivation.data.pills;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.sovereign.cultivation.capabilities.Affinity;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.sovereign.cultivation.capabilities.IAffinity;
import net.sovereign.cultivation.capabilities.ICultivation;
import org.jetbrains.annotations.NotNull;

public class Pill extends Item {
    private final int heal;
    private final double cultivation;
    private final boolean deOrb;

    public Pill(int heal, double cultivation, boolean deOrb) {
        super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1));

        this.heal = heal;
        this.cultivation = cultivation;
        this.deOrb = deOrb;
    }

    @Override
    public @NotNull ActionResult<ItemStack> onItemRightClick(World worldIn, @NotNull PlayerEntity playerIn, @NotNull Hand handIn) {
        if(!worldIn.isRemote) {
            usePill(playerIn);
            playerIn.inventory.deleteStack(playerIn.getHeldItem(handIn));
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    private void usePill(PlayerEntity playerEntity) {
        IAffinity affinity = playerEntity.getCapability(Affinity.AFFINITY_CAP).orElse(new Affinity());
        ICultivation cultivation = playerEntity.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());

        if(this.deOrb) {
            affinity.setOrbed(false);
        }

        if(this.cultivation > 0) {
            cultivation.increaseCultivationAmount(this.cultivation);
        }

        if((this.heal > 0) && (this.heal < 50)) {
            playerEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, this.heal * 2, 1));
        } else if ((this.heal >= 50) && (this.heal < 100)) {
            playerEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, this.heal * 2, 2));
        } else if (this.heal >= 100) {
            playerEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, this.heal * 2, 3));
        }
    }


}
