package com.xetosphere.arcane.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.xetosphere.arcane.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModCraftingRecipes {

	public static void addCraftingRecipes() {

		addShapedRecipes();
		addShapelessRecipes();
	}

	public static void addShapedRecipes() {

		GameRegistry.addRecipe(new ItemStack(ModItems.arcaneGem), new Object[] { "XYX", "YZY", "XYX", Character.valueOf('X'), new ItemStack(ModItems.magicDust, 1, 0), Character.valueOf('Y'), Item.diamond, Character.valueOf('Z'), Item.emerald });

		GameRegistry.addRecipe(new ItemStack(ModItems.soroniteHelmet), new Object[] { "SSS", "S S", Character.valueOf('S'), new ItemStack(ModItems.magicIngot, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ModItems.soroniteChest), new Object[] { "S S", "SSS", "SSS", Character.valueOf('S'), new ItemStack(ModItems.magicIngot, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ModItems.soroniteLegs), new Object[] { "SSS", "S S", "S S", Character.valueOf('S'), new ItemStack(ModItems.magicIngot, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ModItems.soroniteBoots), new Object[] { "S S", "S S", Character.valueOf('S'), new ItemStack(ModItems.magicIngot, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(ModItems.tarditeHelmet), new Object[] { "TTT", "T T", Character.valueOf('T'), new ItemStack(ModItems.magicIngot, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(ModItems.tarditeChest), new Object[] { "T T", "TTT", "TTT", Character.valueOf('T'), new ItemStack(ModItems.magicIngot, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(ModItems.tarditeLegs), new Object[] { "TTT", "T T", "T T", Character.valueOf('T'), new ItemStack(ModItems.magicIngot, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(ModItems.tarditeBoots), new Object[] { "T T", "T T", Character.valueOf('T'), new ItemStack(ModItems.magicIngot, 1, 1) });

		GameRegistry.addRecipe(new ItemStack(ModItems.koroninHelmet), new Object[] { "KKK", "K K", Character.valueOf('K'), new ItemStack(ModItems.magicIngot, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(ModItems.koroninChest), new Object[] { "K K", "KKK", "KKK", Character.valueOf('K'), new ItemStack(ModItems.magicIngot, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(ModItems.koroninLegs), new Object[] { "KKK", "K K", "K K", Character.valueOf('K'), new ItemStack(ModItems.magicIngot, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(ModItems.koroninBoots), new Object[] { "K K", "K K", Character.valueOf('K'), new ItemStack(ModItems.magicIngot, 1, 2) });

		GameRegistry.addRecipe(new ItemStack(ModItems.soroniteSword), new Object[] { "X", "X", "S", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.soronitePick), new Object[] { "XXX", " S ", " S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.soroniteAxe), new Object[] { "XX", "SX", "S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.soroniteShovel), new Object[] { "X", "S", "S", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.soroniteHoe), new Object[] { "XX", "S ", "S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.soronitePaxel), new Object[] { " S ", "APG", " H ", Character.valueOf('S'), ModItems.soroniteSword, Character.valueOf('A'), ModItems.soroniteAxe, Character.valueOf('P'), ModItems.soronitePick, Character.valueOf('G'), ModItems.soroniteShovel, Character.valueOf('H'), ModItems.soroniteHoe });

		GameRegistry.addRecipe(new ItemStack(ModItems.tarditeSword), new Object[] { "X", "X", "S", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.tarditePick), new Object[] { "XXX", " S ", " S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.tarditeAxe), new Object[] { "XX", "SX", "S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.tarditeShovel), new Object[] { "X", "S", "S", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.tarditeHoe), new Object[] { "XX", "S ", "S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.tarditePaxel), new Object[] { " S ", "APG", " H ", Character.valueOf('S'), ModItems.tarditeSword, Character.valueOf('A'), ModItems.tarditeAxe, Character.valueOf('P'), ModItems.tarditePick, Character.valueOf('G'), ModItems.tarditeShovel, Character.valueOf('H'), ModItems.tarditeHoe });

		GameRegistry.addRecipe(new ItemStack(ModItems.koroninSword), new Object[] { "X", "X", "S", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.koroninPick), new Object[] { "XXX", " S ", " S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.koroninAxe), new Object[] { "XX", "SX", "S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.koroninShovel), new Object[] { "X", "S", "S", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.koroninHoe), new Object[] { "XX", "S ", "S ", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(ModItems.koroninPaxel), new Object[] { " S ", "APG", " H ", Character.valueOf('S'), ModItems.koroninSword, Character.valueOf('A'), ModItems.koroninAxe, Character.valueOf('P'), ModItems.koroninPick, Character.valueOf('G'), ModItems.koroninShovel, Character.valueOf('H'), ModItems.koroninHoe });
	}

	public static void addShapelessRecipes() {

	}

}
