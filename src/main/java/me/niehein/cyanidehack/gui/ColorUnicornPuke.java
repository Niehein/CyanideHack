/*
 * This file is part of CyanideHack.
 *
 * CyanideHack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CyanideHack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Baritone.  If not, see <https://www.gnu.org/licenses/>.
 */

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
