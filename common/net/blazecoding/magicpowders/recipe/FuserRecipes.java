package net.blazecoding.magicpowders.recipe;

import net.blazecoding.magicpowders.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * 
 * Magic Powders
 * 
 * FuserRecipes
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FuserRecipes {

	private static final FuserRecipes fusingBase = new FuserRecipes();

	public static final FuserRecipes fusing() {
		return fusingBase;
	}

	private FuserRecipes() {

	}

	public ItemStack getFusingResult(int itemID, int itemMeta, int dustID, int dustMeta) {
		return getOutput(itemID, itemMeta, dustID, dustMeta);
	}

	private static ItemStack getOutput(int itemID, int itemMeta, int dustID, int dustMeta) {

		if (itemID == Item.ingotIron.itemID && dustID == ModItems.magicDust.itemID && dustMeta == 0) {
			return new ItemStack(ModItems.magicIngot, 1, 0);
		}

		if (itemID == Item.ingotIron.itemID && dustID == ModItems.magicDust.itemID && dustMeta == 1) {
			return new ItemStack(ModItems.magicIngot, 1, 1);
		}

		if (itemID == Item.ingotIron.itemID && dustID == ModItems.magicDust.itemID && dustMeta == 2) {
			return new ItemStack(ModItems.magicIngot, 1, 2);
		}

		return null;
	}

}
