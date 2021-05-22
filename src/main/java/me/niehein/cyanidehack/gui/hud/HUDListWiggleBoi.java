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

import me.niehein.cyanidehack.CyanideHack;
import me.niehein.cyanidehack.gui.ColorUnicornPuke;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class HUDListWiggleBoi extends HUDElementBase{
    public int offset;
    public String[] list;
    public HUDListWiggleBoi(int x, int y, float scale, Object color, int offset, String[] list) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.color = color;
        this.offset = offset;
        this.list = list;
    }

    public void render() {
        super.render();
        int count = 0;

        GlStateManager.scale(scale, scale, scale);
        for (String str : list) {
            int countForLambdaCuzLambdaPooPoo = count;
            fr.drawStringWithShadow(str, x / scale + offset + CyanideHack.getRainbowWaveHUD(0.2F, count, (int) (sr.getScaledWidth() / scale - fr.getStringWidth(str) - offset * 2)), y / scale + offset + (fr.FONT_HEIGHT + offset) * count, CyanideHack.isRainbow(color) ? ((ColorUnicornPuke) color).updateRainbowAndReturn(count) : ((Color)color).getRGB());
            count++;
        }
        GlStateManager.scale(1/scale, 1/scale, 1/scale);
        GlStateManager.color(1.0F, 1.0F, 1.0F);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

