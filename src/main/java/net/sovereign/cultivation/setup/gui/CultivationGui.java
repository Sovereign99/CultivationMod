package net.sovereign.cultivation.setup.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.Affinity;
import net.sovereign.cultivation.capabilities.Cultivation;
import net.sovereign.cultivation.capabilities.IAffinity;
import net.sovereign.cultivation.capabilities.ICultivation;

public class CultivationGui extends GuiUtils {

    private static final ResourceLocation BAR = new ResourceLocation(CultivationMod.MOD_ID, "textures/gui/cultivation_overlay.png");
    private static final int WIDTH = 102, HEIGHT = 8;

    public static void cultivationOverlay(RenderGameOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if(mc.player != null) {
            if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                mc.textureManager.bindTexture(BAR);
                FontRenderer font = mc.fontRenderer;
                ICultivation cultivation = mc.player.getCapability(Cultivation.CULTIVATION_CAP).orElse(new Cultivation());
                IAffinity affinity = mc.player.getCapability(Affinity.AFFINITY_CAP).orElse(new Affinity());
                int affinityColor = getAffinityColor(affinity);
                cultivation.checkSubLevel();
                Cultivation.CultivationSubLevel level = cultivation.getSubLevel();
                int currentWidth = (int) (100 * (level.getProgress() / level.getDiff()));
                // Draws progress bar
                drawTexturedModalRect(event.getMatrixStack(), 4, 15, 0, 0, WIDTH, HEIGHT, 0);
                drawTexturedModalRect(event.getMatrixStack(), 5, 15, 1, HEIGHT, currentWidth, HEIGHT, 0);
                // Draws current cultivation sub level over progress bar
                font.drawStringWithShadow(event.getMatrixStack(),
                        "" + level.getRank() + level.getLevelName(),
                        4,
                        4,
                        11184810);
                // Draws progress over progress bar
                font.drawString(event.getMatrixStack(),
                        "" + (int) level.getProgress() + " / " + (int) level.getDiff(),
                        4,
                        15,
                        6579300);
                // Draws elemental affinity under progress bar
                font.drawStringWithShadow(event.getMatrixStack(),
                        "" + affinity.getAffinityName(),
                        4,
                        25,
                        affinityColor);

            }
        }
    }

    private static int getAffinityColor(IAffinity affinity) {
        switch (affinity.getAffinityName()) {
            case "FIRE":
                return 9764864;
            case "WATER":
                return 2193611;
            case "EARTH":
                return 5514261;
            case "AIR":
                return 12178935;
            case "LIGHT":
                return 16768768;
            case "DARK":
                return 2621480;
        }
        return 11184810;
    }
}
