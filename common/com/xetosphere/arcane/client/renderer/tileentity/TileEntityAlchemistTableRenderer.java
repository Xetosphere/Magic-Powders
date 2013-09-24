package com.xetosphere.arcane.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.xetosphere.arcane.client.model.ModelAlchemistTable;
import com.xetosphere.arcane.lib.Textures;
import com.xetosphere.arcane.tileentity.TileAlchemistTable;

import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityAlchemistTableRenderer extends TileEntitySpecialRenderer {

	private ModelAlchemistTable modelAclTab = new ModelAlchemistTable();

	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {

		if (tileEntity instanceof TileAlchemistTable) {

			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			// Scale, Translate, Rotate
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);

			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.MODEL_ALCHEMISTTABLE);

			// Render
			modelAclTab.render();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();

		}
	}

}
