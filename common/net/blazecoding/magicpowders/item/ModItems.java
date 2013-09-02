package net.blazecoding.magicpowders.item;

import net.blazecoding.magicpowders.lib.ItemIDs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Magic Powders
 * 
 * ModItems
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ModItems {

	public static Item magicDust;
	public static Item magicIngot;
	public static Item duplicatorGem;

	/**
	 * Adds the items that the mod contains. As well as item recipes.
	 */
	public static void init() {

		magicDust = new ItemMagicDust(ItemIDs.MAGICDUSTS);
		magicIngot = new ItemMagicIngot(ItemIDs.MAGICINGOTS);
		duplicatorGem = new ItemDuplicatorGem(ItemIDs.DUPLICATORGEM);

		registerRecipes();

	}

	/**
	 * Adds the recipes for the craftable items.
	 */
	public static void registerRecipes() {

		GameRegistry.addRecipe(new ItemStack(duplicatorGem), new Object[] { "XYX", "YZY", "XYX", Character.valueOf('X'), new ItemStack(magicDust, 1, 0), Character.valueOf('Y'), Item.diamond, Character.valueOf('Z'), Item.emerald });

		duplicateItems();

	}

	public static void duplicateItems() {

		for (int i = 0; i < duplicatorGem.getMaxDamage(); ++i) {
			GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 0), new ItemStack(Item.coal, 1, 0), new ItemStack(duplicatorGem, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 1), new ItemStack(Item.coal, 1, 1), new ItemStack(duplicatorGem, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 2, 0), new ItemStack(Item.ingotIron, 1, 0), new ItemStack(duplicatorGem, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 2, 0), new ItemStack(Item.ingotGold, 1, 0), new ItemStack(duplicatorGem, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 2, 0), new ItemStack(Item.diamond, 1, 0), new ItemStack(duplicatorGem, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 2, 0), new ItemStack(Item.emerald, 1, 0), new ItemStack(duplicatorGem, 1, i));
		}

	}

}
