package net.sovereign.cultivation.data.pills;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;
import net.sovereign.cultivation.capabilities.Affinity;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.sovereign.cultivation.capabilities.IAffinity;
import net.sovereign.cultivation.capabilities.ICultivation;

import java.util.Objects;

public class Pill extends Item {
    private final int heal;
    private final double cultivation;
    private final boolean deOrb;

    public Pill(int heal, double cultivation, boolean deOrb) {
        super(new Item.Properties().group(ItemGroup.FOOD));

        this.heal = heal;
        this.cultivation = cultivation;
        this.deOrb = deOrb;
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();
        if(!world.isRemote) {
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
            usePill(playerEntity);
            stack.damageItem(1, playerEntity, player -> player.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
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

        if(this.heal > 0) {
            playerEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, this.heal * 2));
        }
    }


}
