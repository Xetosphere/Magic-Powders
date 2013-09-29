package com.xetosphere.arcane.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.xetosphere.arcane.inventory.ContainerArcaneInfuser;
import com.xetosphere.arcane.lib.Strings;
import com.xetosphere.arcane.lib.Textures;
import com.xetosphere.arcane.tileentity.TileArcaneInfuser;

public class GuiArcaneInfuser extends GuiContainer {

	private TileArcaneInfuser tileArcaneInfuser;

	public GuiArcaneInfuser(InventoryPlayer player, TileArcaneInfuser tileArcaneInfuser) {

		super(new ContainerArcaneInfuser(player, tileArcaneInfuser));
		this.tileArcaneInfuser = tileArcaneInfuser;
	}

	protected void drawGuiContainerForegroundLayer(int x, int y) {

		String containerName = tileArcaneInfuser.isInvNameLocalized() ? tileArcaneInfuser.getInvName() : StatCollector.translateToLocal(tileArcaneInfuser.getInvName());
		fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
		fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.getTextureManager().bindTexture(Textures.GUI_ARCANE_INFUSER);

		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;

		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

		int i1;

		if (this.tileArcaneInfuser.isBurning()) {
			i1 = this.tileArcaneInfuser.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(xStart + 56, yStart + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}

		i1 = this.tileArcaneInfuser.getCookProgressTimeScaled(24);
		this.drawTexturedModalRect(xStart + 79, yStart + 34, 176, 14, i1 + 1, 16);
	}

}
