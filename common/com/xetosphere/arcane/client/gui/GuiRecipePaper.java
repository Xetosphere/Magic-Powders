package com.xetosphere.arcane.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.xetosphere.arcane.item.ItemRecipeScrolls;
import com.xetosphere.arcane.lib.Strings;
import com.xetosphere.arcane.lib.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiRecipePaper extends GuiScreen {

	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 256;

	public GuiRecipePaper(EntityPlayer player) {

	}

	public void drawScreen(int x, int y, float f) {

		drawDefaultBackground();

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_PAPER);

		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;

		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

		if (ItemRecipeScrolls.getGuiText() == 0) {
			int i = this.fontRenderer.getStringWidth(Strings.GUI_RECIPE_ALCTAB) + 5;
			this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.GUI_RECIPE_ALCTAB), posX + i, posY + 15, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("The alchemist table is a device used to"), posX + 30, posY + 35, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("create magical objects from the most"), posX + 30, posY + 45, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("normal of items. It contains unknown"), posX + 30, posY + 55, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("powers that soon will be unleashed."), posX + 30, posY + 65, 16777215);

			this.fontRenderer.drawString(StatCollector.translateToLocal("Crafting Table"), posX + 35, posY + 105, 16777215);

			this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_ALCHEMISTTABLE);
			drawTexturedModalRect(posX + 30, posY + 120, 0, 0, 191, 96);
		}

		if (ItemRecipeScrolls.getGuiText() == 1) {
			int i = this.fontRenderer.getStringWidth(Strings.GUI_RECIPE_GEM) + 30;
			this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.GUI_RECIPE_GEM), posX + i, posY + 15, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("The Arcane Gem is a gem that take"), posX + 30, posY + 35, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("advantage of how soronite acts when"), posX + 30, posY + 45, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("combined with carbon and juvels. This"), posX + 30, posY + 55, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("makes for a almost perfect but unstable"), posX + 30, posY + 65, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("gem that reacts with everything that"), posX + 30, posY + 75, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("comes near it."), posX + 30, posY + 85, 16777215);

			this.fontRenderer.drawString(StatCollector.translateToLocal("Crafting Table"), posX + 35, posY + 105, 16777215);

			this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_ARCANEGEM);
			drawTexturedModalRect(posX + 30, posY + 120, 0, 0, 191, 96);
		}

		if (ItemRecipeScrolls.getGuiText() == 2) {
			int i = this.fontRenderer.getStringWidth(Strings.GUI_RECIPE_DUP) + 40;
			this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.GUI_RECIPE_DUP), posX + i, posY + 15, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("The duplicator compresses the arcane"), posX + 30, posY + 35, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("gem in a perfect space so that the"), posX + 30, posY + 45, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("duplicating process can keep on for"), posX + 30, posY + 55, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("years! With a bit of delay though."), posX + 30, posY + 65, 16777215);

			this.fontRenderer.drawString(StatCollector.translateToLocal("Alchemist Table"), posX + 35, posY + 105, 16777215);

			this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_DUPLICATOR);
			drawTexturedModalRect(posX + 30, posY + 120, 0, 0, 191, 96);
		}

		if (ItemRecipeScrolls.getGuiText() == 3) {
			int i = this.fontRenderer.getStringWidth(Strings.GUI_RECIPE_ARCFUS) + 15;
			this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.GUI_RECIPE_ARCFUS), posX + i, posY + 15, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("The arcane fuser uses the koronin"), posX + 30, posY + 35, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("ingots strong structure and ability"), posX + 30, posY + 45, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("to keep its solid form, to fuse dusts"), posX + 30, posY + 55, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("with ingots in an incredibly hot space."), posX + 30, posY + 65, 16777215);

			this.fontRenderer.drawString(StatCollector.translateToLocal("Alchemist Table"), posX + 35, posY + 105, 16777215);

			this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_ARCANEFUSER);
			drawTexturedModalRect(posX + 30, posY + 120, 0, 0, 191, 96);
		}

		if (ItemRecipeScrolls.getGuiText() == 4) {
			int i = this.fontRenderer.getStringWidth(Strings.GUI_RECIPE_AURCRU) + 15;
			this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.GUI_RECIPE_AURCRU), posX + i, posY + 15, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("The aura crusher, crushes what ever"), posX + 30, posY + 35, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("comes underneath its koronin pistons"), posX + 30, posY + 45, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("to the state where it can't get any"), posX + 30, posY + 55, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("smaller."), posX + 30, posY + 65, 16777215);

			this.fontRenderer.drawString(StatCollector.translateToLocal("Alchemist Table"), posX + 35, posY + 105, 16777215);

			this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_AURACRUSHER);
			drawTexturedModalRect(posX + 30, posY + 120, 0, 0, 191, 96);
		}

		if (ItemRecipeScrolls.getGuiText() == 5) {
			int i = this.fontRenderer.getStringWidth(Strings.GUI_RUNES) + 15;
			this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.GUI_RUNES), posX + i, posY + 15, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("The aura crusher, crushes what ever"), posX + 30, posY + 35, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("comes underneath its koronin pistons"), posX + 30, posY + 45, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("to the state where it can't get any"), posX + 30, posY + 55, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("smaller."), posX + 30, posY + 65, 16777215);

			this.fontRenderer.drawString(StatCollector.translateToLocal("Alchemist Table"), posX + 35, posY + 105, 16777215);

			this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_RUNES);
			drawTexturedModalRect(posX + 30, posY + 120, 0, 0, 191, 96);
		}

		if (ItemRecipeScrolls.getGuiText() == 6) {
			int i = this.fontRenderer.getStringWidth(Strings.GUI_RUNES) + 15;
			this.fontRenderer.drawString(StatCollector.translateToLocal(Strings.GUI_RUNES), posX + i, posY + 15, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("The aura crusher, crushes what ever"), posX + 30, posY + 35, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("comes underneath its koronin pistons"), posX + 30, posY + 45, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("to the state where it can't get any"), posX + 30, posY + 55, 16777215);
			this.fontRenderer.drawString(StatCollector.translateToLocal("smaller."), posX + 30, posY + 65, 16777215);

			this.fontRenderer.drawString(StatCollector.translateToLocal("Alchemist Table"), posX + 35, posY + 105, 16777215);

			this.mc.renderEngine.bindTexture(Textures.GUI_RECIPE_RUNES);
			drawTexturedModalRect(posX + 30, posY + 120, 0, 0, 191, 96);
		}

		super.drawScreen(x, y, f);
	}

}
