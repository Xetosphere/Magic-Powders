package com.xetosphere.arcane.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.xetosphere.arcane.inventory.ContainerAlchemistTable;
import com.xetosphere.arcane.lib.Strings;
import com.xetosphere.arcane.lib.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiAlchemistTable extends GuiContainer {

	public GuiAlchemistTable(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {

		super(new ContainerAlchemistTable(par1InventoryPlayer, par2World, par3, par4, par5));
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {

		this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_ALCHEMISTTABLE_NAME), 28, 6, 4210752);
		this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(Textures.GUI_ALCHEMISTTABLE);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

}
