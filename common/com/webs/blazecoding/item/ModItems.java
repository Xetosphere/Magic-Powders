package com.webs.blazecoding.item;

import net.minecraft.item.Item;

import com.webs.blazecoding.lib.ItemIDs;

/**
 * 
 * Magic Powders
 * 
 * ModItems
 * 
 * @author BlazeCoding
 * @license Lesser Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */

public class ModItems {

	public static Item magicDust;
	
	/**
	 * Adds the items that the mod contains. As well as item recipes.
	 */
	public static void init() {
		
		magicDust = new ItemMagicDust(ItemIDs.magicDustID);
		
		registerRecipes();
		
	}
	
	/**
	 * Adds the recipes for the craftable items.
	 */
	public static void registerRecipes() {
		
	}
	
}
