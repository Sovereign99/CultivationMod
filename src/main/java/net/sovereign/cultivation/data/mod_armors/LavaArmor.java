package net.sovereign.cultivation.data.mod_armors;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class LavaArmor extends ModArmor {
    public LavaArmor(ModArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 1, 2, false, false));
        player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 1, 2, false, false));
        player.addPotionEffect(new EffectInstance(Effects.GLOWING, 1, 2, false, false));
    }


}
