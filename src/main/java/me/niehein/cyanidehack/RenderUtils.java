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

package me.niehein.cyanidehack;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
//    public static void drawTracer(double x, double y, double z, float lineWidth, float red, float green, float blue, float alpha) {
//
//        boolean userViewbobbing = Minecraft.getMinecraft().gameSettings.viewBobbing;
//        Minecraft.getMinecraft().gameSettings.viewBobbing = false;
//
//        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
//        glEnable(GL_BLEND);
//        glEnable(GL_LINE_SMOOTH);
//        glLineWidth(lineWidth);
//        glDisable(GL_TEXTURE_2D);
//        glDisable(GL_DEPTH_TEST);
//        glDepthMask(false);
//        glColor4f(red, green, blue, alpha);
//        Vec3d eyes = new Vec3d(0, 0, 1).rotatePitch(-(float) Math.toRadians(Minecraft.getMinecraft().player.rotationPitch)).rotateYaw(-(float) Math.toRadians(Minecraft.getMinecraft().player.rotationYaw));
//        glBegin(GL_LINES);
//        glVertex3d(eyes.x, Minecraft.getMinecraft().player.getEyeHeight() + eyes.y, eyes.z);
//        glVertex3d(x, y, z);
//        glEnd();
//        glEnable(GL_TEXTURE_2D);
//        glEnable(GL_DEPTH_TEST);
//        glDepthMask(true);
////        glDisable(GL_BLEND);
////        glColor4f(1F, 1F, 1F, 1F);
//        Minecraft.getMinecraft().gameSettings.viewBobbing = userViewbobbing;
//    }
    public static void drawTracer(double x, double y, double z, float red, float green, float blue, float alpha) {
        GL11.glColor4f(red, green, blue, alpha);
        Vec3d eyes = new Vec3d(0, 0, 1).rotatePitch(-(float) Math.toRadians(Minecraft.getMinecraft().player.rotationPitch)).rotateYaw(-(float) Math.toRadians(Minecraft.getMinecraft().player.rotationYaw));
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(eyes.x, Minecraft.getMinecraft().player.getEyeHeight() + eyes.y, eyes.z);
        GL11.glVertex3d(x, y, z);
        GL11.glEnd();
    }
}
