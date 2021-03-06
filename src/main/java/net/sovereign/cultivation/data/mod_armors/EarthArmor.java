package net.sovereign.cultivation.data.mod_armors;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class EarthArmor extends ModArmor{
    public EarthArmor(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 1, 2, false, false));
        player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 1, 1, false, false));
        player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 1, 1, false, false));
    }
}
