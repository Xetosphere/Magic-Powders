package net.blazecoding.magicpowders.core.util;

import net.blazecoding.magicpowders.lib.References;
import net.minecraft.util.ResourceLocation;


/**
 * 
 * Magic Powders
 * 
 * ResourceLocationHelper
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ResourceLocationHelper {

	public static ResourceLocation getResourceLocation(String path) {
		return new ResourceLocation(References.MOD_ID.toLowerCase(), path);
	}

}
