package net.sovereign.cultivation.cultivation;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.sovereign.cultivation.capabilities.CultivationProvider;
import net.sovereign.cultivation.cultivation.Cultivation;
import net.sovereign.cultivation.cultivation.ICultivation;

public class CultivationUtils {
    public static ICultivation getCultivationFromEntity(LivingEntity entityIn) {
        ICultivation cultivation = null;
        if (entityIn instanceof PlayerEntity) {
            cultivation = (ICultivation) entityIn.getCapability(CultivationProvider.CULTIVATION_CAP, null);
        }
        if (cultivation == null) {
            cultivation = new Cultivation();
        }
        return cultivation;
    }
}
