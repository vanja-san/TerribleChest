/*
 * MIT License
 *
 * Copyright (c) 2019 EideeHi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.eidee.minecraft.terrible_chest.registry;

import net.eidee.minecraft.terrible_chest.config.Config;
import net.eidee.minecraft.terrible_chest.gui.MultiPageScreen;
import net.eidee.minecraft.terrible_chest.gui.TerribleChestScreen;
import net.eidee.minecraft.terrible_chest.gui.SinglePageScreen;
import net.eidee.minecraft.terrible_chest.inventory.container.ContainerTypes;
import net.eidee.minecraft.terrible_chest.inventory.container.TerribleChestContainer;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn( Dist.CLIENT )
public class ScreenRegistry
{
    public static void register()
    {
        ScreenManager.IScreenFactory< TerribleChestContainer, TerribleChestScreen > factory;
        factory = ( container, playerInventory, title ) -> {
            return Config.COMMON.useSinglePageMode.get() ? new SinglePageScreen( container, playerInventory, title )
                                                         : new MultiPageScreen( container, playerInventory, title );
        };

        ScreenManager.registerFactory( ContainerTypes.TERRIBLE_CHEST, factory );
    }
}
