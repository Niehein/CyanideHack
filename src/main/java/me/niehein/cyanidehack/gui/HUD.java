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


    public int offset = 3;
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

    public HUDList hudDinges0= new HUDList(0, 0, offset, scale, 0, direction.LEFT, dead, list0);
    public HUDList hudDinges1= new HUDList(0, 0, offset, scale, 0, direction.RIGHT, dead, list0);
    public HUDList hudDinges2= new HUDList(0, 0, offset, scale, 1, direction.LEFT, dead, list0);

    public void draw() {
        ScaledResolution sr = new ScaledResolution(mc);
        hudDinges0.render();
        hudDinges1.setX(sr.getScaledWidth());
        hudDinges1.render();
        hudDinges2.render();
    }
}
