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
		tarditePaxel = new ItemPaxel(ItemIDs.TARDITEPAXEL, toolTardite).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.TARDITEPAXEL_NAME);
		koroninPaxel = new ItemPaxel(ItemIDs.KORONINPAXEL, toolKoronin).setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.KORONINPAXEL_NAME);

		registerRecipes();

	}

	/**
	 * Adds the recipes for the craftable items.
	 */
	public static void registerRecipes() {

		GameRegistry.addRecipe(new ItemStack(arcaneGem), new Object[] { "XYX", "YZY", "XYX", Character.valueOf('X'), new ItemStack(magicDust, 1, 0), Character.valueOf('Y'), Item.diamond, Character.valueOf('Z'), Item.emerald });

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
