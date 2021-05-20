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
    public String[] list1 = {
            "I loved Fit so much, I watched all his videos and live streams.",
            "I pray to Fit every night, thanking him for the server he has taught me about.",
            "\"Fit is love...\" I say, \"Fit is life...\" ",
            "The other 2b2t players hear me and call me a Fitfag.",
            "I know they were just jealous because of my infinite 2b2t knowledge.",
            "I called them newfags. They nuke my base.",
            "I'm crying now and I'm back in queue. I lay in bed, really cold.",
            "I feel something warm... It's Fit! I was so happy." ,
            "He whispers in my ear \"Clown Down.\"",
            "He grabs me with his muscular hands, and puts me on my hands and knees.",
            "I'm ready. I spread my ass cheeks for Fit. He penetrates my butthole with a 32k.",
            "It hurts so much, but I do it for Fit. I can feel my butt tearing and eyes watering.",
            "I want to please Fit. He yells a mighty yell as he fills my butt with 2b2t lore about Popbob.",
            "The 2b2t players see this. Fit looks them straight in the eye and says:",
            " \"The oldest anarchy server in Minecraft\". He logs off. Fit is love. Fit is life.",

    };
    public HUDList hudDinges0= new HUDList(0, 0, offset, scale, 0, direction.LEFT, dead, list0);
    public HUDList hudDinges1= new HUDList(0, 0, offset, scale, 0, direction.RIGHT, dead, list0);
    public HUDList hudDinges2= new HUDList(0, 0, offset, scale, 1, direction.LEFT, dead, list0);
    public HUDList hudDinges3= new HUDList(0, 0, offset, scale, 0, direction.LEFT, dead, list1);

    public void draw() {
        ScaledResolution sr = new ScaledResolution(mc);
        hudDinges0.render();
        hudDinges1.setX(sr.getScaledWidth());
        hudDinges1.render();
        hudDinges2.render();
        hudDinges3.setX(sr.getScaledWidth()/4*3);
        hudDinges3.setY(sr.getScaledHeight()/4*3);
        hudDinges3.render();


    }
}
