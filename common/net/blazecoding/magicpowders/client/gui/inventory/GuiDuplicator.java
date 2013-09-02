package net.blazecoding.magicpowders.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import net.blazecoding.magicpowders.inventory.ContainerDuplicator;
import net.blazecoding.magicpowders.lib.Strings;
import net.blazecoding.magicpowders.lib.Textures;
import net.blazecoding.magicpowders.tileentity.TileDuplicator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

public class GuiDuplicator extends GuiContainer {

	private TileDuplicator tileDuplicator;

	public GuiDuplicator(InventoryPlayer player, TileDuplicator tileDuplicator) {
		super(new ContainerDuplicator(player, tileDuplicator));
		this.tileDuplicator = tileDuplicator;
	}
	
	protected void drawGuiContainerForegroundLayer(int x, int y) {

		String containerName = tileDuplicator.isInvNameLocalized() ? tileDuplicator.getInvName() : StatCollector.translateToLocal(tileDuplicator.getInvName());
		fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 96 + 2, 4210752);

	}
	
	protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		// this.mc.getTextureManager().bindTexture(...)
		this.mc.func_110434_K().func_110577_a(Textures.GUI_DUPLICATOR);

		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;

		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

		int i1;

		if (this.tileDuplicator.isBurning()) {
			i1 = this.tileDuplicator.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(xStart + 56, yStart + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}

		i1 = this.tileDuplicator.getCookProgressTimeScaled(24);
		this.drawTexturedModalRect(xStart + 79, yStart + 34, 176, 14, i1 + 1, 16);

	}
	
}
