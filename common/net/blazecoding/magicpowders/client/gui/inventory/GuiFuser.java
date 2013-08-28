package net.blazecoding.magicpowders.client.gui.inventory;

import net.blazecoding.magicpowders.inventory.ContainerFuser;
import net.blazecoding.magicpowders.lib.Strings;
import net.blazecoding.magicpowders.lib.Textures;
import net.blazecoding.magicpowders.tileentity.TileFuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

/**
 * 
 * Magic Powders
 * 
 * GuiFuser
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class GuiFuser extends GuiContainer {

	private TileFuser tileFuser;

	public GuiFuser(InventoryPlayer player, TileFuser tileFuser) {
		super(new ContainerFuser(player, tileFuser));
		this.tileFuser = tileFuser;
	}

	protected void drawGuiContainerForegroundLayer(int x, int y) {

		String containerName = tileFuser.isInvNameLocalized() ? tileFuser.getInvName() : StatCollector.translateToLocal(tileFuser.getInvName());
		fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 96 + 2, 4210752);

	}

	protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		// this.mc.getTextureManager().bindTexture(...)
		this.mc.func_110434_K().func_110577_a(Textures.GUI_FUSER);

		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;

		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

		int i1;

		if (this.tileFuser.isFusing()) {
			i1 = this.tileFuser.getTimeRemainingScaled(12);
			this.drawTexturedModalRect(xStart + 56, yStart + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}

		i1 = this.tileFuser.getProgressTimeScaled(24);
		this.drawTexturedModalRect(xStart + 79, yStart + 34, 176, 14, i1 + 1, 16);

	}

}
