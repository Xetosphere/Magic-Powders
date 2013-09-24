package com.xetosphere.arcane.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.xetosphere.arcane.lib.Models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAlchemistTable extends ModelBase {

	private IModelCustom modelAlcTab;

	public ModelAlchemistTable() {
		modelAlcTab = AdvancedModelLoader.loadModel(Models.ALCHEMISTTABLE);
	}

	public void render() {
		modelAlcTab.renderAll();
	}

	public void renderPart(String partName) {
		modelAlcTab.renderPart(partName);
	}

}
