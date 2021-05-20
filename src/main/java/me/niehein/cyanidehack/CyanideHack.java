package me.niehein.cyanidehack;

import javafx.util.Pair;
import me.niehein.cyanidehack.gui.HUD;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import scala.Int;

import java.awt.*;
import java.util.HashMap;

@Mod(
        modid = CyanideHack.MOD_ID,
        name = CyanideHack.MOD_NAME,
        version = CyanideHack.VERSION
)
public class CyanideHack {

    public static final String MOD_ID = "cyanidehack";
    public static final String MOD_NAME = "CyanideHack";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static HUD hud = new HUD();
    public static Minecraft mc = Minecraft.getMinecraft();
    public static HashMap<Float, Color> cache = new HashMap<>();
    public static long timeForCurrentFrame;

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
        public static void renderGUI(RenderGameOverlayEvent event) {
            if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
                timeForCurrentFrame = System.currentTimeMillis();
                hud.draw();
            }
            cache.clear();
        }
    }

    public static Color getRainbow(float speed, int offset) {
        float x = getRainbowX(speed, offset);
        Color cacheCheck = cache.get(x);
//        System.out.println(cacheCheck+" "+x);
        if (cacheCheck == null) {
            float red = 0.5F + 0.5F * MathHelper.sin(x * (float)Math.PI);
            float green = 0.5F + 0.5F * MathHelper.sin((x + 4F / 3F) * (float)Math.PI);
            float blue = 0.5F + 0.5F * MathHelper.sin((x + 8F / 3F) * (float)Math.PI);
            Color col =  new Color(red, green, blue);
            cache.put(x, col);
            return col;
        } else {
            return cacheCheck;
        }
    }

    public static int getRainbowWave(float speed, int offset, int size) {
        return (int)((float)(getRainbow(speed, offset).getRed())/255*size);
    }

    public static float getRainbowX(float speed, int offset) {
        return (float)(((double)(timeForCurrentFrame+offset* 100L)*speed) % 2000 / 1000F);
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