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

package net.eidee.minecraft.terrible_chest.gui;

import static net.eidee.minecraft.terrible_chest.TerribleChest.MOD_ID;

import com.mojang.blaze3d.systems.RenderSystem;
import net.eidee.minecraft.terrible_chest.inventory.container.TerribleChestContainer;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SinglePageScreen
    extends TerribleChestScreen
{
    private static final ResourceLocation GUI_TEXTURE;

    static
    {
        GUI_TEXTURE = new ResourceLocation( MOD_ID, "textures/gui/container/terrible_chest_single_page.png" );
    }

    public SinglePageScreen( TerribleChestContainer container, PlayerInventory playerInventory, ITextComponent title )
    {
        super( container, playerInventory, title );
        xSize = 356;
        ySize = 238;
    }

    @Override
    protected void drawGuiContainerForegroundLayer( int p_146979_1_, int p_146979_2_ )
    {
        font.drawString( getTitle().getFormattedText(), 8.0F, 6.0F, 4210752 );
        font.drawString( playerInventory.getDisplayName().getFormattedText(), 99.0F, ySize - 93F, 4210752 );
    }

    @Override
    protected void drawGuiContainerBackgroundLayer( float partialTicks, int mouseX, int mouseY )
    {
        RenderSystem.color4f( 1.0F, 1.0F, 1.0F, 1.0F );
        getMinecraft().getTextureManager().bindTexture( GUI_TEXTURE );
        blit( guiLeft, guiTop, getBlitOffset(), 0, 0, xSize, ySize, 256, 512 );

        int swapTarget = container.getSwapIndex1();
        if ( swapTarget != -1 )
        {
            if ( swapTarget >= 0 && swapTarget < 133 )
            {
                Slot slot = container.getSlot( swapTarget );
                RenderSystem.disableLighting();
                RenderSystem.disableDepthTest();
                int x = guiLeft + slot.xPos;
                int y = guiTop + slot.yPos;
                RenderSystem.colorMask( true, true, true, false );
                fillGradient( x, y, x + 16, y + 16, 0x80FF0000, 0x80FF0000 );
                RenderSystem.colorMask( true, true, true, true );
                RenderSystem.enableLighting();
                RenderSystem.enableDepthTest();
            }
        }
    }
}
