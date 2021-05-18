package me.niehein.cyanidehack.gui;

import me.niehein.cyanidehack.CyanideHack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

import java.util.Arrays;

public class HUD extends Gui {
    private Minecraft mc = Minecraft.getMinecraft();


    public int offset = 2;
    public float scale = 1.15F;
    public int[] dead = {
            1,
            5
    };
    public String[] list0 = {
            "KillAura",
            "AntiKnockback",
            "NoSlowDown",
            "Criticals",
            "Flight",
            "Step",
            "Shulkerpreview",
            "B-hop",
            "Reach",
            "Speed",
            "Aimbot",
            "Annoy",
            "NieheinCumDupe",
            "CrystalESP",
            "AntiBlind",
            "AutoTool",
            "FastFall",
            "Elytra+",
            "Freecam",
            "StorageESP",
            "FreeMove",
            "Headless",
            "AntiCactus",
            "Offhand",
            "Breadcrumbs",
            "ImpossibleInventory",
            "GodMode",
            "Skeleton",

    };

    public void draw() {
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;
        int count = 0;

        GlStateManager.scale(scale, scale, 1);
        for (String str : list0) {
            int countForLambdaCuzLambdaPooPoo = count;
            fr.drawStringWithShadow(str, offset, offset + (fr.FONT_HEIGHT+offset) * count, Arrays.stream(dead).anyMatch(i -> i == countForLambdaCuzLambdaPooPoo) ? CyanideHack.getRainbow(1, count+5).getRGB() : CyanideHack.getRainbow(1, count).getRGB());
            count++;
        }
        GlStateManager.scale(1/scale, 1/scale, 1);
        GlStateManager.color(1.0F, 1.0F, 1.0F);
    }
}
