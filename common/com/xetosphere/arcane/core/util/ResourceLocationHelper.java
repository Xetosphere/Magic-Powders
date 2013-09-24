package com.xetosphere.arcane.core.util;

import net.minecraft.util.ResourceLocation;

import com.xetosphere.arcane.lib.Reference;

public class ResourceLocationHelper {

	public static ResourceLocation getResourceLocation(String path) {
		return new ResourceLocation(Reference.MOD_ID.toLowerCase(), path);
	}

}
