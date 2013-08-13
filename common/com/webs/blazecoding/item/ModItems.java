package com.webs.blazecoding.item;

import com.webs.blazecoding.lib.ItemIDs;
import com.webs.blazecoding.lib.Strings;

import net.minecraft.item.Item;

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

	public static Item soroniteDust;
	public static Item tarditeDust;
	public static Item koroninDust;
	
	/**
	 * Adds the items that the mod contains. As well as item recipes.
	 */
	public static void init() {
		
		soroniteDust = new ItemMagicDust(ItemIDs.soroniteID).setUnlocalizedName(Strings.SORONITE_NAME);
		tarditeDust = new ItemMagicDust(ItemIDs.tarditeID).setUnlocalizedName(Strings.TARDITE_NAME);
		koroninDust = new ItemMagicDust(ItemIDs.koroninID).setUnlocalizedName(Strings.KORONIN_NAME);
		
		registerRecipes();
		
	}
	
	/**
	 * Adds the recipes for the craftable items.
	 */
	public static void registerRecipes() {
		
	}
	
}
