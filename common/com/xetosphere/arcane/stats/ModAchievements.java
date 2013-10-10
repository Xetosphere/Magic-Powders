package com.xetosphere.arcane.stats;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

import com.xetosphere.arcane.block.ModBlocks;
import com.xetosphere.arcane.item.ModItems;
import com.xetosphere.arcane.lib.Reference;

public class ModAchievements {

	public static AchievementPage achievementPage;

	public static Achievement alchemistTable;
	public static Achievement arcaneGem;
	public static Achievement duplicator;
	public static Achievement arcaneFuser;
	public static Achievement auraCrusher;
	public static Achievement runes;
	public static Achievement paxel;

	public static void init() {

		alchemistTable = new Achievement(AchievementList.achievementList.size() + 1, "alchemistTable", 0, 0, ModBlocks.alchemistTable, null).registerAchievement().setSpecial();
		arcaneGem = new Achievement(AchievementList.achievementList.size() + 1, "arcaneGem", 0, 2, ModItems.arcaneGem, null).registerAchievement();
		duplicator = new Achievement(AchievementList.achievementList.size() + 1, "duplicator", 2, 2, ModBlocks.duplicator, alchemistTable).registerAchievement();
		arcaneFuser = new Achievement(AchievementList.achievementList.size() + 1, "arcaneFuser", 2, -2, ModBlocks.fuser, alchemistTable).registerAchievement();
		auraCrusher = new Achievement(AchievementList.achievementList.size() + 1, "auraCrusher", -2, -2, ModBlocks.crusher, alchemistTable).registerAchievement();
		runes = new Achievement(AchievementList.achievementList.size() + 1, "runes", -3, 3, ModItems.runeSymbols, null).registerAchievement();
		paxel = new Achievement(AchievementList.achievementList.size() + 1, "paxel", -2, 3, ModItems.soronitePaxel, null).registerAchievement();

		achievementPage = new AchievementPage(Reference.MOD_NAME, alchemistTable, arcaneGem, duplicator, arcaneFuser, auraCrusher, runes, paxel);
		AchievementPage.registerAchievementPage(achievementPage);
	}

}
