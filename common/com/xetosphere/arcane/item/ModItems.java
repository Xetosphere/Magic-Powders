package com.xetosphere.arcane.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

import com.xetosphere.arcane.item.armour.ItemKoroninArmour;
import com.xetosphere.arcane.item.armour.ItemSoroniteArmour;
import com.xetosphere.arcane.item.armour.ItemTarditeArmour;
import com.xetosphere.arcane.item.tools.ItemModAxe;
import com.xetosphere.arcane.item.tools.ItemModHoe;
import com.xetosphere.arcane.item.tools.ItemModPick;
import com.xetosphere.arcane.item.tools.ItemModShovel;
import com.xetosphere.arcane.item.tools.ItemModSword;
import com.xetosphere.arcane.item.tools.ItemPaxel;
import com.xetosphere.arcane.lib.ItemIDs;
import com.xetosphere.arcane.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item magicDust;
	public static Item magicIngot;
	public static Item arcaneGem;

	public static Item soroniteHelmet;
	public static Item soroniteChest;
	public static Item soroniteLegs;
	public static Item soroniteBoots;
	public static Item tarditeHelmet;
	public static Item tarditeChest;
	public static Item tarditeLegs;
	public static Item tarditeBoots;
	public static Item koroninHelmet;
	public static Item koroninChest;
	public static Item koroninLegs;
	public static Item koroninBoots;

	public static Item soronitePick;
	public static Item soroniteSword;
	public static Item soroniteAxe;
	public static Item soroniteShovel;
	public static Item soroniteHoe;

	public static Item tarditePick;
	public static Item tarditeSword;
	public static Item tarditeAxe;
	public static Item tarditeShovel;
	public static Item tarditeHoe;

	public static Item koroninPick;
	public static Item koroninSword;
	public static Item koroninAxe;
	public static Item koroninShovel;
	public static Item koroninHoe;

	public static Item soronitePaxel;
	public static Item tarditePaxel;
	public static Item koroninPaxel;

	public static Item metalDusts;
	public static Item recipeScroll;
	public static Item studdedPaper;
	public static Item runeSymbols;
	public static Item runeBase;

	public static EnumToolMaterial toolSoronite = EnumHelper.addToolMaterial("SORONITE", 2, 1800, 7.0F, 2.0F, 17);
	public static EnumToolMaterial toolTardite = EnumHelper.addToolMaterial("TARDITE", 2, 1800, 7.0F, 2.0F, 17);
	public static EnumToolMaterial toolKoronin = EnumHelper.addToolMaterial("KORONIN", 2, 1800, 7.0F, 2.0F, 17);

	public static EnumArmorMaterial armourSoronite = EnumHelper.addArmorMaterial("SORONITE", 12, new int[] { 3, 6, 4, 3 }, 10);
	public static EnumArmorMaterial armourTardite = EnumHelper.addArmorMaterial("TARDITE", 12, new int[] { 3, 6, 4, 3 }, 10);
	public static EnumArmorMaterial armourKoronin = EnumHelper.addArmorMaterial("KORONIN", 12, new int[] { 3, 6, 4, 3 }, 10);

	/**
	 * Adds the items that the mod contains. As well as item recipes.
	 */
	public static void init() {

		magicDust = new ItemMagicDust(ItemIDs.MAGICDUSTS);
		magicIngot = new ItemMagicIngot(ItemIDs.MAGICINGOTS);
		arcaneGem = new ItemArcaneGem(ItemIDs.ARCANE_GEM);
		metalDusts = new ItemMetalDusts(ItemIDs.METAL_DUSTS);
		recipeScroll = new ItemRecipeScrolls(ItemIDs.RECIPE_SCROLL);
		studdedPaper = new ItemStuddedPaper(ItemIDs.STUDDED_PAPER);
		runeSymbols = new ItemRuneSymbols(ItemIDs.RUNE_SYMBOLS);
		runeBase = new ItemRuneBase(ItemIDs.RUNE_BASE);

		soroniteHelmet = new ItemSoroniteArmour(ItemIDs.SORONITEHELMET, armourSoronite, 0, 0).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITEHELMET_NAME);
		soroniteChest = new ItemSoroniteArmour(ItemIDs.SORONITECHEST, armourSoronite, 0, 1).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITECHEST_NAME);
		soroniteLegs = new ItemSoroniteArmour(ItemIDs.SORONITELEGS, armourSoronite, 0, 2).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITELEGS_NAME);
		soroniteBoots = new ItemSoroniteArmour(ItemIDs.SORONITEBOOTS, armourSoronite, 0, 3).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITEBOOTS_NAME);
		tarditeHelmet = new ItemTarditeArmour(ItemIDs.TARDITEHELMET, armourTardite, 0, 0).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITEHELMET_NAME);
		tarditeChest = new ItemTarditeArmour(ItemIDs.TARDITECHEST, armourTardite, 0, 1).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITECHEST_NAME);
		tarditeLegs = new ItemTarditeArmour(ItemIDs.TARDITELEGS, armourTardite, 0, 2).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITELEGS_NAME);
		tarditeBoots = new ItemTarditeArmour(ItemIDs.TARDITEBOOTS, armourTardite, 0, 3).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITEBOOTS_NAME);
		koroninHelmet = new ItemKoroninArmour(ItemIDs.KORONINHELMET, armourKoronin, 0, 0).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINHELMET_NAME);
		koroninChest = new ItemKoroninArmour(ItemIDs.KORONINCHEST, armourKoronin, 0, 1).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINCHEST_NAME);
		koroninLegs = new ItemKoroninArmour(ItemIDs.KORONINLEGS, armourKoronin, 0, 2).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINLEGS_NAME);
		koroninBoots = new ItemKoroninArmour(ItemIDs.KORONINBOOTS, armourKoronin, 0, 3).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINBOOTS_NAME);

		soronitePaxel = new ItemPaxel(ItemIDs.SORONITEPAXEL, toolSoronite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITEPAXEL_NAME);
		soroniteSword = new ItemModSword(ItemIDs.SORONITESWORD, toolSoronite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITESWORD_NAME);
		soronitePick = new ItemModPick(ItemIDs.SORONITEPICK, toolSoronite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITEPICK_NAME);
		soroniteAxe = new ItemModAxe(ItemIDs.SORONITEAXE, toolSoronite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITEAXE_NAME);
		soroniteShovel = new ItemModShovel(ItemIDs.SORONITESHOVEL, toolSoronite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITESHOVEL_NAME);
		soroniteHoe = new ItemModHoe(ItemIDs.SORONITEHOE, toolSoronite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.SORONITEHOE_NAME);

		tarditePaxel = new ItemPaxel(ItemIDs.TARDITEPAXEL, toolTardite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITEPAXEL_NAME);
		tarditeSword = new ItemModSword(ItemIDs.TARDITESWORD, toolTardite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITESWORD_NAME);
		tarditePick = new ItemModPick(ItemIDs.TARDITEPICK, toolTardite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITEPICK_NAME);
		tarditeAxe = new ItemModAxe(ItemIDs.TARDITEAXE, toolTardite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITEAXE_NAME);
		tarditeShovel = new ItemModShovel(ItemIDs.TARDITESHOVEL, toolTardite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITESHOVEL_NAME);
		tarditeHoe = new ItemModHoe(ItemIDs.TARDITEHOE, toolTardite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITEHOE_NAME);

		koroninPaxel = new ItemPaxel(ItemIDs.KORONINPAXEL, toolKoronin).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINPAXEL_NAME);
		koroninSword = new ItemModSword(ItemIDs.KORONINSWORD, toolKoronin).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINSWORD_NAME);
		koroninPick = new ItemModPick(ItemIDs.KORONINPICK, toolKoronin).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINPICK_NAME);
		koroninAxe = new ItemModAxe(ItemIDs.KORONINAXE, toolKoronin).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINAXE_NAME);
		koroninShovel = new ItemModShovel(ItemIDs.KORONINSHOVEL, toolKoronin).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINSHOVEL_NAME);
		koroninHoe = new ItemModHoe(ItemIDs.KORONINHOE, toolKoronin).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINHOE_NAME);

		registerRecipes();
	}

	/**
	 * Adds the recipes for the craftable items.
	 */
	public static void registerRecipes() {

		// Furnace recipes
		addFurnaceRecipes();

		// Arcane gem duplicating recipes
		duplicateItems();
	}

	private static void addFurnaceRecipes() {

		FurnaceRecipes.smelting().addSmelting(metalDusts.itemID, 1, new ItemStack(Item.ingotIron), 0.2F);
		FurnaceRecipes.smelting().addSmelting(metalDusts.itemID, 2, new ItemStack(Item.ingotGold), 0.3F);
	}

	public static void duplicateItems() {

		int i = OreDictionary.WILDCARD_VALUE;

		Item dupleGem = arcaneGem.setContainerItem(ModItems.arcaneGem);

		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 0), new ItemStack(Item.coal, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 2, 1), new ItemStack(Item.coal, 1, 1), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 2, 0), new ItemStack(Item.ingotIron, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 2, 0), new ItemStack(Item.ingotGold, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 2, 0), new ItemStack(Item.diamond, 1, 0), new ItemStack(dupleGem, 1, i));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 2, 0), new ItemStack(Item.emerald, 1, 0), new ItemStack(dupleGem, 1, i));
	}

}
