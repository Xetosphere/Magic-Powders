package com.xetosphere.arcane.lib;

import com.xetosphere.arcane.core.util.ResourceLocationHelper;

import net.minecraft.util.ResourceLocation;

public class Textures {

	// Base file paths
	public static final String ARMOR_SHEET_LOCATION = "textures/armour/";
	public static final String GUI_SHEET_LOCATION = "textures/gui/";

	// GUI textures
	public static final ResourceLocation GUI_ARCANE_FUSER = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "arcaneFuser.png");
	public static final ResourceLocation GUI_DUPLICATOR = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "duplicator.png");
	public static final ResourceLocation GUI_ALCHEMISTTABLE = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "alchemistTable.png");

}
