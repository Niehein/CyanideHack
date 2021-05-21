package me.niehein.cyanidehack.gui;

import me.niehein.cyanidehack.CyanideHack;

import java.awt.*;
import java.util.Arrays;

public class ColorUnicornPuke extends Color {
    public float speed;
    public float speedDead;
    public int[] dead;
    public int colorRgb;
    private float[] frgbvalue = null;

    public ColorUnicornPuke(float speed, float speedDead, int[] dead) {
        super(0, 0, 0);
        this.speed = speed;
        this.speedDead = speedDead;
        this.dead = dead;
    }

    public int updateRainbowAndReturn(int count) {
        int a = Arrays.stream(dead).anyMatch(i -> i == count) ? CyanideHack.getRainbow(speedDead, count + 7).getRGB() : CyanideHack.getRainbow(speed, count).getRGB();
        colorRgb = a;
        return a;
    }

    public void updateRainbow(int count) {
        colorRgb = updateRainbowAndReturn(count);
    }
}
