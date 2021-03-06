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

import net.eidee.minecraft.terrible_chest.TerribleChest;
import net.eidee.minecraft.terrible_chest.constants.Names;
import net.eidee.minecraft.terrible_chest.item.TerribleBangleItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber( modid = TerribleChest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD )
public class ItemRegistry
{
    @SubscribeEvent
    public static void register( RegistryEvent.Register< Item > event )
    {
        IForgeRegistry< Item > registry = event.getRegistry();

        Item item;
        Item.Properties prop;
        {
            prop = new Item.Properties().group( ItemGroup.MISC );

            item = new Item( prop ).setRegistryName( Names.DIAMOND_SPHERE );
            registry.register( item );
        }
        {
            prop = new Item.Properties().group( ItemGroup.MISC );

            item = new TerribleBangleItem( prop ).setRegistryName( Names.TERRIBLE_BANGLE );
            registry.register( item );
        }
    }
}
