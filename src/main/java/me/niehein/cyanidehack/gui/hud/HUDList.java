package me.niehein.cyanidehack.gui.hud;

import me.niehein.cyanidehack.CyanideHack;
import me.niehein.cyanidehack.gui.ColorUnicornPuke;
import me.niehein.cyanidehack.gui.EnumSide;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;
import java.util.Arrays;

public class HUDList extends HUDElementBase{
    public int offset;
    public EnumSide side;
    public String[] list;
    public HUDList(int x, int y, Object color, int offset, EnumSide side, String[] list) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.offset = offset;
        this.side = side;
        this.list = list;
    }

    public void render() {
        super.render();
        int count = 0;

//        GlStateManager.scale(scale, scale, scale);
        for (String str : list) {
            int countForLambdaCuzLambdaPooPoo = count;
            if (side == EnumSide.LEFT) {
                fr.drawStringWithShadow(str, x + offset, y + offset + (fr.FONT_HEIGHT + offset) * count, CyanideHack.isRainbow(color) ? ((ColorUnicornPuke) color).updateRainbowAndReturn(count) : ((Color)color).getRGB());
            } else if (side == EnumSide.RIGHT) {
//                System.out.println(str+"  "+str.length());
                fr.drawStringWithShadow(str, x-offset-fr.getStringWidth(str), y+offset + (fr.FONT_HEIGHT+offset) * count, CyanideHack.isRainbow(color) ? ((ColorUnicornPuke) color).updateRainbowAndReturn(count) : ((Color)color).getRGB());
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

