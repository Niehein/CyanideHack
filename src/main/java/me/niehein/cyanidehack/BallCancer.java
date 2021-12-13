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

import me.niehein.cyanidehack.music.BBQ;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.client.gui.GuiMainMenu;

import java.lang.reflect.Field;

import static me.niehein.cyanidehack.CyanideHack.mc;

public class BallCancer extends Thread{
    public boolean ooo = true;
    @Override
    public void run() {
        while (true) {
            if (mc.currentScreen instanceof GuiMainMenu) {
                if (ooo) {
                    try {
                        Field ae = SoundHandler.class.
                                getDeclaredField("soundRegistry");
                        ae.setAccessible(true);
                        SoundRegistry ae2 = (SoundRegistry) ae.get(mc.getSoundHandler());
//                        System.out.println(ae2);
                        mc.getSoundHandler().playSound(BBQ.sound);
                        ooo = false;
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                ooo = true;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
