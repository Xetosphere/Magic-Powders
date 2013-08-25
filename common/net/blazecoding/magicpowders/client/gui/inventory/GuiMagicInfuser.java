package net.blazecoding.magicpowders.client.gui.inventory;

import net.blazecoding.magicpowders.inventory.ContainerMagicInfuser;
import net.blazecoding.magicpowders.lib.Textures;
import net.blazecoding.magicpowders.tileentity.TileEntityMagicInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiMagicInfuser extends GuiContainer {

	private TileEntityMagicInfuser magicInfuserInventory;

	public GuiMagicInfuser(InventoryPlayer inventoryplayer, TileEntityMagicInfuser tileEntityMagicInfuser) {
		super(new ContainerMagicInfuser(inventoryplayer, tileEntityMagicInfuser));
		magicInfuserInventory = tileEntityMagicInfuser;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		fontRenderer.drawString(StatCollector.translateToLocal("Magic Infuser"), 40, 6, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("Inventory"), 8, (ySize - 96) + 2, 0x404040);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.func_110577_a(Textures.GUI_MAGICINFUSER);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);

		if (magicInfuserInventory.isBurning()) {

			int j1 = magicInfuserInventory.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(l + 56, (i1 + 36 + 12) - j1, 176, 12 - j1, 14, j1 + 2);

		}

		int k1 = magicInfuserInventory.getCookProgressScaled(24);
		drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);

	}

}
