package net.blazecoding.magicpowders.item;

import net.blazecoding.magicpowders.lib.ItemIDs;
import net.minecraft.item.EnumToolMaterial;
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

		ItemStack soronite = new ItemStack(magicDust, 1, 0);
		ItemStack tardite = new ItemStack(magicDust, 1, 1);
		ItemStack koronin = new ItemStack(magicDust, 1, 2);

		Item diamond = Item.diamond;
		Item gold = Item.ingotGold;
		Item iron = Item.ingotIron;

		doubleItemOutput(diamond, 0, soronite);
		doubleItemOutput(gold, 0, soronite);
		doubleItemOutput(iron, 0, soronite);

		quadItemOutput(diamond, 0, soronite);
		quadItemOutput(gold, 0, soronite);
		quadItemOutput(iron, 0, soronite);

		octaItemOutput(diamond, 0, soronite);
		octaItemOutput(gold, 0, soronite);
		octaItemOutput(iron, 0, soronite);

		for (int i = 1; i < EnumToolMaterial.WOOD.getMaxUses(); i++) {
			repairTools(Item.swordWood, tardite, i);
			repairTools(Item.pickaxeWood, tardite, i);
			repairTools(Item.axeWood, tardite, i);
			repairTools(Item.shovelWood, tardite, i);
			repairTools(Item.hoeWood, tardite, i);
		}

		for (int i = 1; i < EnumToolMaterial.STONE.getMaxUses(); i++) {
			repairTools(Item.swordStone, tardite, i);
			repairTools(Item.pickaxeStone, tardite, i);
			repairTools(Item.axeStone, tardite, i);
			repairTools(Item.shovelStone, tardite, i);
			repairTools(Item.hoeStone, tardite, i);
		}

		for (int i = 1; i < EnumToolMaterial.IRON.getMaxUses(); i++) {
			repairTools(Item.swordIron, tardite, i);
			repairTools(Item.pickaxeIron, tardite, i);
			repairTools(Item.axeIron, tardite, i);
			repairTools(Item.shovelIron, tardite, i);
			repairTools(Item.hoeIron, tardite, i);
		}

		for (int i = 1; i < EnumToolMaterial.GOLD.getMaxUses(); i++) {
			repairTools(Item.swordGold, tardite, i);
			repairTools(Item.pickaxeGold, tardite, i);
			repairTools(Item.axeGold, tardite, i);
			repairTools(Item.shovelGold, tardite, i);
			repairTools(Item.hoeGold, tardite, i);
		}

		for (int i = 1; i < EnumToolMaterial.EMERALD.getMaxUses(); i++) {
			repairTools(Item.swordDiamond, tardite, i);
			repairTools(Item.pickaxeDiamond, tardite, i);
			repairTools(Item.axeDiamond, tardite, i);
			repairTools(Item.shovelDiamond, tardite, i);
			repairTools(Item.hoeDiamond, tardite, i);
		}

		for (int i = 0; i < EnumToolMaterial.WOOD.getMaxUses(); i++) {
			repairAndDoubleTools(Item.swordWood, koronin, i);
			repairAndDoubleTools(Item.pickaxeWood, koronin, i);
			repairAndDoubleTools(Item.axeWood, koronin, i);
			repairAndDoubleTools(Item.shovelWood, koronin, i);
			repairAndDoubleTools(Item.hoeWood, koronin, i);
		}

		for (int i = 0; i < EnumToolMaterial.STONE.getMaxUses(); i++) {
			repairAndDoubleTools(Item.swordStone, koronin, i);
			repairAndDoubleTools(Item.pickaxeStone, koronin, i);
			repairAndDoubleTools(Item.axeStone, koronin, i);
			repairAndDoubleTools(Item.shovelStone, koronin, i);
			repairAndDoubleTools(Item.hoeStone, koronin, i);
		}

		for (int i = 0; i < EnumToolMaterial.IRON.getMaxUses(); i++) {
			repairAndDoubleTools(Item.swordIron, koronin, i);
			repairAndDoubleTools(Item.pickaxeIron, koronin, i);
			repairAndDoubleTools(Item.axeIron, koronin, i);
			repairAndDoubleTools(Item.shovelIron, koronin, i);
			repairAndDoubleTools(Item.hoeIron, koronin, i);
		}

		for (int i = 0; i < EnumToolMaterial.GOLD.getMaxUses(); i++) {
			repairAndDoubleTools(Item.swordGold, koronin, i);
			repairAndDoubleTools(Item.pickaxeGold, koronin, i);
			repairAndDoubleTools(Item.axeGold, koronin, i);
			repairAndDoubleTools(Item.shovelGold, koronin, i);
			repairAndDoubleTools(Item.hoeGold, koronin, i);
		}

		for (int i = 0; i < EnumToolMaterial.EMERALD.getMaxUses(); i++) {
			repairAndDoubleTools(Item.swordDiamond, koronin, i);
			repairAndDoubleTools(Item.pickaxeDiamond, koronin, i);
			repairAndDoubleTools(Item.axeDiamond, koronin, i);
			repairAndDoubleTools(Item.shovelDiamond, koronin, i);
			repairAndDoubleTools(Item.hoeDiamond, koronin, i);
		}

	}

	public static void doubleItemOutput(Item itemCopied, int meta, ItemStack dustStack) {
		GameRegistry.addShapelessRecipe(new ItemStack(itemCopied, 2, meta), itemCopied, dustStack);
	}

	public static void quadItemOutput(Item itemCopied, int meta, ItemStack dustStack) {
		GameRegistry.addShapelessRecipe(new ItemStack(itemCopied, 4, meta), itemCopied, dustStack, dustStack);
	}

	public static void octaItemOutput(Item itemCopied, int meta, ItemStack dustStack) {
		GameRegistry.addShapelessRecipe(new ItemStack(itemCopied, 8, meta), itemCopied, dustStack, dustStack, dustStack);
	}

	public static void repairTools(Item repaired, ItemStack dustStack, int state) {
		GameRegistry.addRecipe(new ItemStack(repaired, 1, 0), new Object[] { "ddd", "drd", "ddd", Character.valueOf('d'), dustStack, Character.valueOf('r'), new ItemStack(repaired, 1, state) });
	}

	public static void repairAndDoubleTools(Item repaired, ItemStack dustStack, int state) {
		GameRegistry.addRecipe(new ItemStack(repaired, 2, 0), new Object[] { "ddd", "drd", "ddd", Character.valueOf('d'), dustStack, Character.valueOf('r'), new ItemStack(repaired, 1, state) });
	}

}
