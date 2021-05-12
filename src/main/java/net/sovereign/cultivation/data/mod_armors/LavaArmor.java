package net.sovereign.cultivation.data.mod_armors;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class LavaArmor extends ArmorItem {
    public LavaArmor(ModArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Item.Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 1, 5, false, false));
    }
}
