package net.sovereign.cultivation.setup.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.sovereign.cultivation.capabilities.ICultivation;

public class CultivationGui extends GuiUtils {

    private static final ResourceLocation BAR = new ResourceLocation(CultivationMod.MOD_ID, "textures/gui/cultivation_overlay.png");
    private static final int WIDTH = 102, HEIGHT = 8, BAR_WIDTH = 100;

    public static void cultivationOverlay(RenderGameOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if(mc.player != null) {
            if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                mc.textureManager.bindTexture(BAR);
                FontRenderer font = mc.fontRenderer;

                ICultivation cultivation = mc.player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
                cultivation.checkSubLevel();
                Cultivation.CultivationSubLevel level = cultivation.getSubLevel();
                float oneUnit = (float) (BAR_WIDTH / level.round(level.getDiff()));
                int currentWidth = (int) (oneUnit * level.round(level.getProgress()));
                drawTexturedModalRect(event.getMatrixStack(), 4, 15, 0, 0, WIDTH, HEIGHT, 0);
                drawTexturedModalRect(event.getMatrixStack(), 5, 15, 1, HEIGHT, currentWidth, HEIGHT, 1);
                font.drawStringWithShadow(event.getMatrixStack(),
                        "" + level.getRank() + level.getLevelName(),
                        4,
                        4,
                        11184810);
            }
        }
    }
}
