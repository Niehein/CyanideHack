package me.niehein.cyanidehack.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class HUDElementBase {
    public Minecraft mc = Minecraft.getMinecraft();
    public ScaledResolution sr = new ScaledResolution(mc);
    public FontRenderer fr = mc.fontRenderer;
    public int x;
    public int y;
    public Object color;
    public float scale;

    public void render() {
        mc = Minecraft.getMinecraft();
        sr = new ScaledResolution(mc);
        fr = mc.fontRenderer;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Object color) {
        this.color = color;
    }
}
