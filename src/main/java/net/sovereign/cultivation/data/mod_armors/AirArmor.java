package net.sovereign.cultivation.data.mod_armors;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class AirArmor extends ModArmor{
    public AirArmor(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.SPEED, 1, 1, false, false));
        player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 1, 2, false, false));
        player.addPotionEffect(new EffectInstance(Effects.HASTE, 1, 2, false, false));
        player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 1, 1, false, false));
    }
}
