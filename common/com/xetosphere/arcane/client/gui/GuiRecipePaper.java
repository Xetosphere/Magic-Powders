package com.xetosphere.arcane.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.xetosphere.arcane.lib.Strings;
import com.xetosphere.arcane.lib.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiRecipePaper extends GuiScreen {

	public final int xSizeOfTexture = 180;
	public final int ySizeOfTexture = 200;

	public GuiRecipePaper(EntityPlayer player) {

	}

	public void drawScreen(int x, int y, float f) {

		drawDefaultBackground();

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_PAPER);

		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;

		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

		int i = this.fontRenderer.getStringWidth(Strings.GUI_RECIPE_ALCTAB) / 2 + 10;
		this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.GUI_RECIPE_ALCTAB), posX + i, posY + 15, 16777215);

		super.drawScreen(x, y, f);
	}

}
