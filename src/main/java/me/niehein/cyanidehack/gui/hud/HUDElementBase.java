package me.niehein.cyanidehack.gui.hud;

import net.minecraft.client.Minecraft;

public class HUDElementBase {
    private Minecraft mc = Minecraft.getMinecraft();
    public int x;
    public int y;

    public void draw() {

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
