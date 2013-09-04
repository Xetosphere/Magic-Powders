package com.xetosphere.arcane.recipe;

import com.xetosphere.arcane.item.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
