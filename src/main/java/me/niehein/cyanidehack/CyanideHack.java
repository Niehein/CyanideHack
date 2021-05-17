package me.niehein.cyanidehack;

import me.niehein.cyanidehack.gui.HUD;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.awt.*;

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
            hud.draw();
        }
    }

    public static Color getRainbow(float speed, int offset) {
        float x = (System.currentTimeMillis()+offset) % 2000 / 1000F * speed;
        float red = 0.5F + 0.5F * MathHelper.sin(x * (float)Math.PI);
        float green = 0.5F + 0.5F * MathHelper.sin((x + 4F / 3F) * (float)Math.PI);
        float blue = 0.5F + 0.5F * MathHelper.sin((x + 8F / 3F) * (float)Math.PI);
        return new Color(red, green, blue);
    }
}
