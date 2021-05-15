package net.sovereign.cultivation.setup.gui;


import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.sovereign.cultivation.capabilities.ICultivation;

public class CultivationGui extends GuiUtils {

    private static final ResourceLocation BAR = new ResourceLocation(CultivationMod.MOD_ID, "textures/gui/cultivation_overlay.png");
    private static final int WIDTH = 102, HEIGHT = 8, BAR_WIDTH = 100, BAR_HEIGHT = 6;

    public static void cultivationOverlay(RenderGameOverlayEvent.Post event) {
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft mc = Minecraft.getInstance();
            mc.textureManager.bindTexture(BAR);
            
            ICultivation cultivation = mc.player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
            float oneUnit = (float) (1000 / BAR_WIDTH);
            int currentWidth = (int) (oneUnit * (cultivation.getCultivationAmount() % 1000));
            drawTexturedModalRect(event.getMatrixStack(), 0, 0, 0, 0, WIDTH, HEIGHT, 0);
            drawTexturedModalRect(event.getMatrixStack(), 1, 0, 1, HEIGHT, currentWidth, HEIGHT, 1);
        }
    }

}
