package me.niehein.cyanidehack.gui;

import me.niehein.cyanidehack.CyanideHack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class HUD extends Gui {
    private Minecraft mc = Minecraft.getMinecraft();

    int offset = 2;
    String[] list0 = {
            "a",
            "b",
            "c",
            "d",
            "e"
    };

    public void draw() {
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;
        int count = 0;

        GlStateManager.scale(2, 2, 1);
        for (String str : list0) {
            fr.drawStringWithShadow(str, offset, offset + (fr.FONT_HEIGHT+offset) * count, CyanideHack.getRainbow(1, count*10).getRGB());
            count++;
        }
        GlStateManager.scale(0.5, 0.5, 1);
        GlStateManager.color(1.0F, 1.0F, 1.0F);
    }
}
