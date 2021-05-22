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

import me.niehein.cyanidehack.gui.ColorUnicornPuke;
import me.niehein.cyanidehack.gui.HUD;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.HashMap;

import static org.lwjgl.opengl.GL11.glLineWidth;

@Mod(
        modid = CyanideHack.MOD_ID,
        name = CyanideHack.MOD_NAME,
        version = CyanideHack.VERSION
)
public class CyanideHack {

    public static final String MOD_ID = "cyanidehack";
    public static final String MOD_NAME = "CyanideHack";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static int tick = 0;
    public static HUD hud = new HUD();
    public static Minecraft mc = Minecraft.getMinecraft();
    public static HashMap<Float, Color> cacheHUD = new HashMap<>();
    public static HashMap<Float, Color> cacheRender = new HashMap<>();
    public static long timeForCurrentFrameHUD;
    public static long timeForCurrentFrameRender;

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static CyanideHack INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        @SubscribeEvent
        public static void tick(TickEvent.WorldTickEvent event) {
            if (event.phase == TickEvent.Phase.START) {
                if (tick % 5 == 0) {
                    hud.list4[0] = String.valueOf(((int)Math.floor(Math.random()*(6-1+1)+1)));
                    hud.list4[1] = String.valueOf(((int)Math.floor(Math.random()*(300-100+1)+100)));
                }
                if (tick % 20 == 0) {
                    hud.list4[2] = String.valueOf(((int)Math.floor(Math.random()*(11-7+1)+7)));
                }
                tick++;
            }
        }

        @SubscribeEvent
        public static void renderGUI(RenderGameOverlayEvent event) {
            if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
                timeForCurrentFrameHUD = System.currentTimeMillis();
                hud.draw();
            }
            cacheHUD.clear();
        }

        @SubscribeEvent
        public static void renderWorld(RenderWorldLastEvent event) {
            float ticks = event.getPartialTicks();
            timeForCurrentFrameRender = System.currentTimeMillis();
            int count = 0;

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            glLineWidth(2);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glPushMatrix();

            for (Entity e : mc.world.loadedEntityList) {
                if (!e.getName().equals(mc.player.getName())) {
                    double renderPosX = mc.getRenderManager().viewerPosX;
                    double renderPosY = mc.getRenderManager().viewerPosY;
                    double renderPosZ = mc.getRenderManager().viewerPosZ;
                    double xPos = (e.lastTickPosX + (e.posX - e.lastTickPosX) * ticks) - renderPosX;
                    double yPos = (e.lastTickPosY + (e.posY - e.lastTickPosY) * ticks) - renderPosY;
                    double zPos = (e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * ticks) - renderPosZ;
                    Color rainbow = getRainbowRender(1, count);
                    float r = (1/255F)*rainbow.getRed();
                    float g = (1/255F)*rainbow.getGreen();
                    float b = (1/255F)*rainbow.getBlue();
//                    System.out.println(r+" "+g+" "+b);
                    RenderUtils.drawTracer(xPos, yPos, zPos, r, g, b, 0.6F);
                }
                count++;
            }

            GL11.glPopMatrix();
            GL11.glColor4f(1, 1, 1, 1);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_LINE_SMOOTH);

            cacheRender.clear();
        }
    }

    public static Color getRainbowHUD(float speed, int offset) {
        float x = getRainbowXHUD(speed, offset);
        Color cacheCheck = cacheHUD.get(x);
//        System.out.println(cacheCheck+" "+x);
        if (cacheCheck == null) {
            float red = 0.5F + 0.5F * MathHelper.sin(x * (float)Math.PI);
            float green = 0.5F + 0.5F * MathHelper.sin((x + 4F / 3F) * (float)Math.PI);
            float blue = 0.5F + 0.5F * MathHelper.sin((x + 8F / 3F) * (float)Math.PI);
            Color col =  new Color(red, green, blue);
            cacheHUD.put(x, col);
            return col;
        } else {
            return cacheCheck;
        }
    }

    public static int getRainbowWaveHUD(float speed, int offset, int size) {
        return (int)((float)(getRainbowHUD(speed, offset).getRed())/255*size);
    }

    public static float getRainbowXHUD(float speed, int offset) {
        return (float)(((double)(timeForCurrentFrameHUD +offset* 100L)*speed) % 2000 / 1000F);
    }

    public static Color getRainbowRender(float speed, int offset) {
        float x = getRainbowXRender(speed, offset);
        Color cacheCheck = cacheRender.get(x);
//        System.out.println(cacheCheck+" "+x);
        if (cacheCheck == null) {
            float red = 0.5F + 0.5F * MathHelper.sin(x * (float)Math.PI);
            float green = 0.5F + 0.5F * MathHelper.sin((x + 4F / 3F) * (float)Math.PI);
            float blue = 0.5F + 0.5F * MathHelper.sin((x + 8F / 3F) * (float)Math.PI);
            Color col =  new Color(red, green, blue);
            cacheRender.put(x, col);
            return col;
        } else {
            return cacheCheck;
        }
    }

    public static int getRainbowWaveRender(float speed, int offset, int size) {
        return (int)((float)(getRainbowRender(speed, offset).getRed())/255*size);
    }

    public static float getRainbowXRender(float speed, int offset) {
        return (float)(((double)(timeForCurrentFrameRender +offset* 100L)*speed) % 2000 / 1000F);
    }

    public static boolean isRainbow(Object color) {
        return color instanceof ColorUnicornPuke;
    }
}

/**
 * Fuck you {@link HashMap}!
 */
class cacheKey {
    public float speed;
    public int offset;

    public cacheKey(float speed, int offset) {
        this.speed = speed;
        this.offset = offset;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(speed * 1000 + offset); //TODO this is dumb :(, offsets above 100 will brake
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        cacheKey other = (cacheKey) obj;
        if (speed != other.speed || offset != other.offset)
            return false;
        return true;
    }
}
