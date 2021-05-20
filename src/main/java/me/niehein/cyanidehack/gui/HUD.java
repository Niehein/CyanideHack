package me.niehein.cyanidehack.gui;

import me.niehein.cyanidehack.gui.hud.HUDList;
import me.niehein.cyanidehack.gui.hud.HUDListWiggleBoi;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

import java.util.Arrays;

public class HUD extends Gui {
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
            "NieheinsCumDupe",
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
            "I feel something warm... It's Fit! I was so happy.",
            "He whispers in my ear \"Clown Down.\"",
            "He grabs me with his muscular hands, and puts me on my hands and knees.",
            "I'm ready. I spread my ass cheeks for Fit. He penetrates my butthole with a 32k.",
            "It hurts so much, but I do it for Fit. I can feel my butt tearing and eyes watering.",
            "I want to please Fit. He yells a mighty yell as he fills my butt with 2b2t lore about Popbob.",
            "The 2b2t players see this. Fit looks them straight in the eye and says:",
            " \"The oldest anarchy server in Minecraft\". He logs off. Fit is love. Fit is life.",
    };

    public HUDList hudListLeft = new HUDList(0, 0, offset, EnumSide.LEFT, dead, 3, 1, list0);
    public HUDList hudListRight = new HUDList(0, 0, offset, EnumSide.RIGHT, dead, 3, 1, list0);
    public HUDListWiggleBoi hudListWiggleWiggleWiggleWiggleWiggle = new HUDListWiggleBoi(0, 0, offset, EnumSide.LEFT, dead, 3, 1, list0);
    public HUDList hudFitFagRidle = new HUDList(0, 0, offset, EnumSide.RIGHT, new int[]{}, 0.5F, 0, list1);

    public void draw() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;
        hudListLeft.render();
        hudListRight.setX(sr.getScaledWidth());
        hudListRight.render();
        hudListWiggleWiggleWiggleWiggleWiggle.render();
        hudFitFagRidle.setX(sr.getScaledWidth() - Arrays.stream(hudFitFagRidle.list).map(String::length).max(Integer::compareTo).get());
        hudFitFagRidle.setY(sr.getScaledHeight() - hudFitFagRidle.list.length * (fr.FONT_HEIGHT+ hudFitFagRidle.offset));
        hudFitFagRidle.render();
    }
}
