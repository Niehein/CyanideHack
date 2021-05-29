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

package me.niehein.cyanidehack.gui;

import me.niehein.cyanidehack.gui.hud.HUDList;
import me.niehein.cyanidehack.gui.hud.HUDListWiggleBoi;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.util.Arrays;

public class HUD extends Gui {
    public int offset = 3;
    public float scale = 1.15F;
    public float scaleFitFagRiddle = 1F;
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
            "NieheinCumDupe", //ITS THE NIEHEINCUMDUPE DON'T YOU DARE CHANGING IT AGAIN!!!!!!11!!!
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

    public String[] list2 = {
            "FreeMove",
            "FastFall",
            "Follow",
            "Freecam",
            "FastEat",
            "Fullbright",
            "FastLadder",
            "AutoCondom",
            "FightBot",
            "GhostHand",
            "HackSign",
            "HealthTags",
            "HighJump",
            "ImpossibleInventory",
            "ItemESP",
            "GodMode",
            "Insult",
            "Jesus",
            "Little baby Jesus",
            "Jetpack",
            "Liquids",
            "MenuWalk",
            "Trajectories",
            "A little bit of troling",
            "V-Clip",
            "WorldDownloader",
            "X-Ray"
    };
    public String[] list3 = {
            "FPS: ",
            "Ping: ",
            "TPS: ",
    };
    public String[] list4 = {
            "3",
            "420",
            "9",
    };
    public String[] list5 = {
            "FuckedDetection",
            "AnimalESP",
            "PenisESP",
            "Regen",
            "Auto-Respawn",
            "Derp",
            "SafeWalk",
            "Sneak",
            "SleepWalk",
            "SpeedMine",
            "Spider",
            "TP-Aura",
            "ChildESP",
            "Triggerbot",
            "AutoSexdupe[Rage]",
            "Antifog",
            "Tracers",
            "Throw",
            "FakePlayer",
            "Trajectories",
            "A little bit of troling",
            "V-Clip",
            "Tpscync",
            "SmallShieds",
            "OffhandCrystal",
            "HausemasterFinder",
            "SpawnerEsp",
            "WaifuESP",
            "Tracers",
            "Extrachathistory",
    };
    public String[] list6 = {
            "CancerClient V6.9",
    };
    public String[] list7 = {
            "CyanideHack V?",
    };
    public String[] list8 = {
            "BrickHack V3.0",
    };

    public HUDList hudListLeft = new HUDList(0, 0, scale, new ColorUnicornPuke(3, 1, dead), offset, EnumSide.LEFT, list0);
    public HUDList hudListRight = new HUDList(0, 0, scale, new ColorUnicornPuke(3, 1, dead), offset, EnumSide.RIGHT, list0);
    public HUDListWiggleBoi hudListWiggleWiggleWiggleWiggleWiggle = new HUDListWiggleBoi(0, 0, scale, new ColorUnicornPuke(3, 1, dead), offset, list0);
    public HUDList hudFitFagRiddle = new HUDList(0, 0, scaleFitFagRiddle, Color.GREEN, offset, EnumSide.RIGHT, list1);
    public HUDList Hudlist2 = new HUDList(35, 60, scale, Color.BLUE, offset, EnumSide.LEFT, list2);
    public HUDList Info = new HUDList(300, 40, scale, Color.WHITE, offset, EnumSide.LEFT, list3);
    public HUDList Verrybadnumbers = new HUDList(328, 40, scale, Color.RED, offset, EnumSide.LEFT, list4);
    public HUDList Hudlist3 = new HUDList(600, 55, 1F, Color.RED, offset, EnumSide.LEFT, list5);
    public HUDList Watermark1 = new HUDList(-3, 523, scale, Color.white, offset, EnumSide.LEFT, list6);
    public HUDList Watermark2 = new HUDList(10, -3, scale, Color.cyan, offset, EnumSide.LEFT, list7);
    public HUDList Watermark3 = new HUDList(875, 450, scale, Color.yellow, offset, EnumSide.LEFT, list8);

    public void draw() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;
        hudListLeft.render();
        hudListRight.setX(sr.getScaledWidth());
        hudListRight.render();
        hudListWiggleWiggleWiggleWiggleWiggle.render();
        hudFitFagRiddle.setX(sr.getScaledWidth() - Arrays.stream(hudFitFagRiddle.list).map(String::length).max(Integer::compareTo).get());
        hudFitFagRiddle.setY(sr.getScaledHeight() - hudFitFagRiddle.list.length * (fr.FONT_HEIGHT+ hudFitFagRiddle.offset));
        hudFitFagRiddle.render();
        Hudlist2.render();
        Info.render();
        Verrybadnumbers.render();
        Hudlist3.render();
        Watermark1.render();
        Watermark2.render();
        Watermark3.render();
    }
}
