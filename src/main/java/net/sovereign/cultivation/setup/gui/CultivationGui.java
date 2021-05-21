package net.sovereign.cultivation.setup.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.sovereign.cultivation.CultivationMod;
import net.sovereign.cultivation.capabilities.*;
import net.sovereign.cultivation.techniques.Techniques;

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
                ITech tech = mc.player.getCapability(Tech.TECH_CAP).orElse(new Tech());
                int affinityColor = getAffinityColor(affinity.getAffinity());
                cultivation.checkSubLevel();
                Cultivation.CultivationSubLevel level = cultivation.getSubLevel();
                int currentWidth = (int) (100 * (level.getProgress() / level.getDiff()));
                // Draws progress bar
                drawTexturedModalRect(event.getMatrixStack(), 4, 15, 0, 0, WIDTH, HEIGHT, 0);
                drawTexturedModalRect(event.getMatrixStack(), 5, 15, 1, HEIGHT, currentWidth, HEIGHT, 0);
                // Draws current cultivation sub level above progress bar
                font.drawStringWithShadow(event.getMatrixStack(),
                        "" + level.getRank() + level.getLevelName(),
                        4,
                        4,
                        11184810);
                // Draws elemental affinity under progress bar
                font.drawStringWithShadow(event.getMatrixStack(),
                        "" + affinity.getAffinityName(),
                        4,
                        25,
                        affinityColor);
                // Draws Technique name under affinity
                font.drawStringWithShadow(event.getMatrixStack(),
                        "Technique: ",
                        4,
                        36,
                        11184810);
                //Draws Technique name in proper color
                int techColor = getAffinityColor(Techniques.getTechByIndex(tech.getTech()).getAffinity());
                font.drawStringWithShadow(event.getMatrixStack(),
                        "" + Techniques.getTechByIndex(tech.getTech()).getName(),
                        60,
                        36,
                        techColor);
            }
        }
    }

    private static int getAffinityColor(int affinity) {
        switch (affinity) {
            case 1:
                return 9764864;
            case 2:
                return 2193611;
            case 3:
                return 5514261;
            case 4:
                return 12178935;
            case 5:
                return 16768768;
            case 6:
                return 2621480;
        }
        return 11184810;
    }


}
