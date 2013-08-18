package net.blazecoding.magicpowders.client.gui.inventory;

import net.blazecoding.magicpowders.inventory.ContainerAlloyHeater;
import net.blazecoding.magicpowders.lib.Strings;
import net.blazecoding.magicpowders.lib.Textures;
import net.blazecoding.magicpowders.tileentity.TileEntityAlloyHeater;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

/**
 * 
 * Magic Powders
 * 
 * GuiAlloyHeater
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class GuiAlloyHeater extends GuiContainer {

	private TileEntityAlloyHeater heaterInventory;

	public GuiAlloyHeater(InventoryPlayer inventoryPlayer, TileEntityAlloyHeater tileEntityAlloyHeater) {
		super(new ContainerAlloyHeater(inventoryPlayer, tileEntityAlloyHeater));
		heaterInventory = tileEntityAlloyHeater;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {

		this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_ALLOYHEATER), 60, 6, 4210752);
		this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, this.ySize - 96 + 2, 4210752);

	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		// this.mc.getTextureManager().bindTexture(...)
		mc.renderEngine.func_110577_a(Textures.GUI_ALLOYHEATER_STORAGE);

		int var5 = (this.width - this.xSize) / 2;
		int var6 = (this.height - this.ySize) / 2;

		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);

		int var7;

		if (heaterInventory.isBurning()) {

			var7 = heaterInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);

		}

		var7 = heaterInventory.getCookProgressScaled(24);

		this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);

	}

}
