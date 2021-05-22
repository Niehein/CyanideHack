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
