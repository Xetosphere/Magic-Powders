package com.xetosphere.arcane.client.renderer.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.xetosphere.arcane.client.model.ModelAlchemistTable;
import com.xetosphere.arcane.lib.Textures;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemAlchemistTableRenderer implements IItemRenderer {

	private ModelAlchemistTable modelAlcTab;

	public ItemAlchemistTableRenderer() {
		modelAlcTab = new ModelAlchemistTable();
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		switch (type) {
		case ENTITY: {
			renderAlcTab(-0.5F, -0.38F, 0.5F, 1.0F);
			return;
		}

		case EQUIPPED: {
			renderAlcTab(0.15F, 0.05F, 1.10F, 1.0F);
			return;
		}

		case EQUIPPED_FIRST_PERSON: {
			renderAlcTab(1.0F, -0.10F, 1.0F, 1.0F);
			return;
		}

		case INVENTORY: {
			renderAlcTab(1.0F, 0.75F, 2.0F, 1.0F);
			return;
		}

		default:
			return;
		}
	}

	private void renderAlcTab(float x, float y, float z, float scale) {

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);

		// Scale, Translate, Rotate
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(0, 1F, 0, 0);

		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.MODEL_ALCHEMISTTABLE);

		// Render
		modelAlcTab.render();

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

	}

}
