package me.niehein.cyanidehack.gui.hud;

import me.niehein.cyanidehack.CyanideHack;
import me.niehein.cyanidehack.gui.EnumSide;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.util.Arrays;

public class HUDListWiggleBoi extends HUDElementBase{
    public int offset;
    public EnumSide side;
    public int[] dead;
    public String[] list;
    public HUDListWiggleBoi(int x, int y, int offset, EnumSide side, int[] dead, String[] list) {
        this.x = x;
        this.y = y;
        this.offset = offset;
        this.side = side;
        this.dead = dead;
        this.list = list;
    }

    public void render() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;
        int count = 0;

//        GlStateManager.scale(scale, scale, scale);
        for (String str : list) {
            int countForLambdaCuzLambdaPooPoo = count;
            if (side == EnumSide.LEFT) {
                fr.drawStringWithShadow(str, x + offset + CyanideHack.getRainbowWave(0.2F, count, sr.getScaledWidth() - fr.getStringWidth(str) - offset * 2), y + offset + (fr.FONT_HEIGHT + offset) * count, Arrays.stream(dead).anyMatch(i -> i == countForLambdaCuzLambdaPooPoo) ? CyanideHack.getRainbow(1, count + 7).getRGB() : CyanideHack.getRainbow(3, count).getRGB());
            } else if (side == EnumSide.RIGHT) {
//                System.out.println(str+"  "+str.length());
                fr.drawStringWithShadow(str, x-offset-fr.getStringWidth(str), y+offset + (fr.FONT_HEIGHT+offset) * count, Arrays.stream(dead).anyMatch(i -> i == countForLambdaCuzLambdaPooPoo) ? CyanideHack.getRainbow(1, count+7).getRGB() : CyanideHack.getRainbow(3, count).getRGB());
            }
            count++;
        }
//        GlStateManager.scale(1/scale, 1/scale, 1/scale);
        GlStateManager.color(1.0F, 1.0F, 1.0F);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

