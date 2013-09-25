package com.xetosphere.arcane.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

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

		GameRegistry.addRecipe(new ItemStack(arcaneGem), new Object[] { "XYX", "YZY", "XYX", Character.valueOf('X'), new ItemStack(magicDust, 1, 0), Character.valueOf('Y'), Item.diamond, Character.valueOf('Z'), Item.emerald });

		GameRegistry.addRecipe(new ItemStack(soroniteHelmet), new Object[] { "SSS", "S S", Character.valueOf('S'), new ItemStack(magicIngot, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(soroniteChest), new Object[] { "S S", "SSS", "SSS", Character.valueOf('S'), new ItemStack(magicIngot, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(soroniteLegs), new Object[] { "SSS", "S S", "S S", Character.valueOf('S'), new ItemStack(magicIngot, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(soroniteBoots), new Object[] { "S S", "S S", Character.valueOf('S'), new ItemStack(magicIngot, 1, 0) });

		GameRegistry.addRecipe(new ItemStack(tarditeHelmet), new Object[] { "TTT", "T T", Character.valueOf('T'), new ItemStack(magicIngot, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(tarditeChest), new Object[] { "T T", "TTT", "TTT", Character.valueOf('T'), new ItemStack(magicIngot, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(tarditeLegs), new Object[] { "TTT", "T T", "T T", Character.valueOf('T'), new ItemStack(magicIngot, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(tarditeBoots), new Object[] { "T T", "T T", Character.valueOf('T'), new ItemStack(magicIngot, 1, 1) });

		GameRegistry.addRecipe(new ItemStack(koroninHelmet), new Object[] { "KKK", "K K", Character.valueOf('K'), new ItemStack(magicIngot, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(koroninChest), new Object[] { "K K", "KKK", "KKK", Character.valueOf('K'), new ItemStack(magicIngot, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(koroninLegs), new Object[] { "KKK", "K K", "K K", Character.valueOf('K'), new ItemStack(magicIngot, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(koroninBoots), new Object[] { "K K", "K K", Character.valueOf('K'), new ItemStack(magicIngot, 1, 2) });

		GameRegistry.addRecipe(new ItemStack(soroniteSword), new Object[] { "X", "X", "S", Character.valueOf('X'), new ItemStack(magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(soronitePick), new Object[] { "XXX", " S ", " S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(soroniteAxe), new Object[] { "XX", "SX", "S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(soroniteShovel), new Object[] { "X", "S", "S", Character.valueOf('X'), new ItemStack(magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(soroniteHoe), new Object[] { "XX", "S ", "S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 0), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(soronitePaxel), new Object[] { " S ", "APG", " H ", Character.valueOf('S'), ModItems.soroniteSword, Character.valueOf('A'), ModItems.soroniteAxe, Character.valueOf('P'), ModItems.soronitePick, Character.valueOf('G'), ModItems.soroniteShovel, Character.valueOf('H'), ModItems.soroniteHoe });

		GameRegistry.addRecipe(new ItemStack(tarditeSword), new Object[] { "X", "X", "S", Character.valueOf('X'), new ItemStack(magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(tarditePick), new Object[] { "XXX", " S ", " S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(tarditeAxe), new Object[] { "XX", "SX", "S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(tarditeShovel), new Object[] { "X", "S", "S", Character.valueOf('X'), new ItemStack(magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(tarditeHoe), new Object[] { "XX", "S ", "S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 1), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(tarditePaxel), new Object[] { " S ", "APG", " H ", Character.valueOf('S'), ModItems.tarditeSword, Character.valueOf('A'), ModItems.tarditeAxe, Character.valueOf('P'), ModItems.tarditePick, Character.valueOf('G'), ModItems.tarditeShovel, Character.valueOf('H'), ModItems.tarditeHoe });

		GameRegistry.addRecipe(new ItemStack(koroninSword), new Object[] { "X", "X", "S", Character.valueOf('X'), new ItemStack(magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(koroninPick), new Object[] { "XXX", " S ", " S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(koroninAxe), new Object[] { "XX", "SX", "S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(koroninShovel), new Object[] { "X", "S", "S", Character.valueOf('X'), new ItemStack(magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(koroninHoe), new Object[] { "XX", "S ", "S ", Character.valueOf('X'), new ItemStack(magicIngot, 1, 2), Character.valueOf('S'), Item.stick });
		GameRegistry.addRecipe(new ItemStack(koroninPaxel), new Object[] { " S ", "APG", " H ", Character.valueOf('S'), ModItems.koroninSword, Character.valueOf('A'), ModItems.koroninAxe, Character.valueOf('P'), ModItems.koroninPick, Character.valueOf('G'), ModItems.koroninShovel, Character.valueOf('H'), ModItems.koroninHoe });

		duplicateItems();

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
