package com.xetosphere.arcane.lib;

import net.minecraft.util.ResourceLocation;

import com.xetosphere.arcane.core.util.ResourceLocationHelper;

public class Textures {

	// Base file paths
	public static final String MODEL_SHEET_LOCATION = "textures/models/";
	public static final String ARMOR_SHEET_LOCATION = "textures/armour/";
	public static final String GUI_SHEET_LOCATION = "textures/gui/";

	// GUI textures
	public static final ResourceLocation GUI_ARCANE_FUSER = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "arcaneFuser.png");
	public static final ResourceLocation GUI_DUPLICATOR = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "duplicator.png");
	public static final ResourceLocation GUI_ALCHEMISTTABLE = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "alchemistTable.png");
	public static final ResourceLocation GUI_AURA_CRUSHER = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "auraCrusher.png");
	public static final ResourceLocation GUI_RECIPE_PAPER = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "recipePaper.png");

	// Model textures
	public static final ResourceLocation MODEL_ALCHEMISTTABLE = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "alchemistTable.png");
}
