package com.xetosphere.arcane.world.gen;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.xetosphere.arcane.item.ModItems;

public class DungeonLoot {

	public static void addLoot() {

		ChestGenHooks bonusChest = ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST);
		ChestGenHooks dungeonChest = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		ChestGenHooks mineshaftChest = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		ChestGenHooks pyramidChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		ChestGenHooks jungleChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		ChestGenHooks strongholdChest = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR);
		ChestGenHooks crossingChest = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING);
		ChestGenHooks libraryChest = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY);
		ChestGenHooks blacksmithChest = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);

		ItemStack ancientScroll1 = new ItemStack(ModItems.recipeScroll, 1, 0);
		ItemStack ancientScroll2 = new ItemStack(ModItems.recipeScroll, 1, 1);
		ItemStack ancientScroll3 = new ItemStack(ModItems.recipeScroll, 1, 2);
		ItemStack ancientScroll4 = new ItemStack(ModItems.recipeScroll, 1, 3);
		ItemStack ancientScroll5 = new ItemStack(ModItems.recipeScroll, 1, 4);

		bonusChest.addItem(new WeightedRandomChestContent(ancientScroll1, 1, 1, 50));
		dungeonChest.addItem(new WeightedRandomChestContent(ancientScroll1, 0, 1, 5));
		mineshaftChest.addItem(new WeightedRandomChestContent(ancientScroll1, 0, 1, 5));
		pyramidChest.addItem(new WeightedRandomChestContent(ancientScroll1, 0, 1, 5));
		jungleChest.addItem(new WeightedRandomChestContent(ancientScroll1, 0, 1, 5));
		strongholdChest.addItem(new WeightedRandomChestContent(ancientScroll1, 0, 1, 5));
		crossingChest.addItem(new WeightedRandomChestContent(ancientScroll1, 0, 1, 5));
		libraryChest.addItem(new WeightedRandomChestContent(ancientScroll1, 0, 1, 5));
		blacksmithChest.addItem(new WeightedRandomChestContent(ancientScroll1, 0, 1, 5));

		dungeonChest.addItem(new WeightedRandomChestContent(ancientScroll2, 0, 1, 5));
		mineshaftChest.addItem(new WeightedRandomChestContent(ancientScroll2, 0, 1, 5));
		pyramidChest.addItem(new WeightedRandomChestContent(ancientScroll2, 0, 1, 5));
		jungleChest.addItem(new WeightedRandomChestContent(ancientScroll2, 0, 1, 5));
		strongholdChest.addItem(new WeightedRandomChestContent(ancientScroll2, 0, 1, 5));
		crossingChest.addItem(new WeightedRandomChestContent(ancientScroll2, 0, 1, 5));
		libraryChest.addItem(new WeightedRandomChestContent(ancientScroll2, 0, 1, 5));
		blacksmithChest.addItem(new WeightedRandomChestContent(ancientScroll2, 0, 1, 5));

		dungeonChest.addItem(new WeightedRandomChestContent(ancientScroll3, 0, 1, 5));
		mineshaftChest.addItem(new WeightedRandomChestContent(ancientScroll3, 0, 1, 5));
		pyramidChest.addItem(new WeightedRandomChestContent(ancientScroll3, 0, 1, 5));
		jungleChest.addItem(new WeightedRandomChestContent(ancientScroll3, 0, 1, 5));
		strongholdChest.addItem(new WeightedRandomChestContent(ancientScroll3, 0, 1, 5));
		crossingChest.addItem(new WeightedRandomChestContent(ancientScroll3, 0, 1, 5));
		libraryChest.addItem(new WeightedRandomChestContent(ancientScroll3, 0, 1, 5));
		blacksmithChest.addItem(new WeightedRandomChestContent(ancientScroll3, 0, 1, 5));

		dungeonChest.addItem(new WeightedRandomChestContent(ancientScroll4, 0, 1, 5));
		mineshaftChest.addItem(new WeightedRandomChestContent(ancientScroll4, 0, 1, 5));
		pyramidChest.addItem(new WeightedRandomChestContent(ancientScroll4, 0, 1, 5));
		jungleChest.addItem(new WeightedRandomChestContent(ancientScroll4, 0, 1, 5));
		strongholdChest.addItem(new WeightedRandomChestContent(ancientScroll4, 0, 1, 5));
		crossingChest.addItem(new WeightedRandomChestContent(ancientScroll4, 0, 1, 5));
		libraryChest.addItem(new WeightedRandomChestContent(ancientScroll4, 0, 1, 5));
		blacksmithChest.addItem(new WeightedRandomChestContent(ancientScroll4, 0, 1, 5));

		dungeonChest.addItem(new WeightedRandomChestContent(ancientScroll5, 0, 1, 5));
		mineshaftChest.addItem(new WeightedRandomChestContent(ancientScroll5, 0, 1, 5));
		pyramidChest.addItem(new WeightedRandomChestContent(ancientScroll5, 0, 1, 5));
		jungleChest.addItem(new WeightedRandomChestContent(ancientScroll5, 0, 1, 5));
		strongholdChest.addItem(new WeightedRandomChestContent(ancientScroll5, 0, 1, 5));
		crossingChest.addItem(new WeightedRandomChestContent(ancientScroll5, 0, 1, 5));
		libraryChest.addItem(new WeightedRandomChestContent(ancientScroll5, 0, 1, 5));
		blacksmithChest.addItem(new WeightedRandomChestContent(ancientScroll5, 0, 1, 5));
	}

}
