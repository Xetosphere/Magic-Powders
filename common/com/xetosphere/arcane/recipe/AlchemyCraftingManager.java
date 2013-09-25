package com.xetosphere.arcane.recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

import com.xetosphere.arcane.block.ModBlocks;
import com.xetosphere.arcane.item.ModItems;

public class AlchemyCraftingManager {

	private static final AlchemyCraftingManager instance = new AlchemyCraftingManager();

	@SuppressWarnings("rawtypes")
	private List recipes = new ArrayList();

	public static final AlchemyCraftingManager getInstance() {
		return instance;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AlchemyCraftingManager() {

		ItemStack soroniteHelmet = new ItemStack(ModItems.soroniteHelmet);
		ItemStack soroniteArmour = new ItemStack(ModItems.soroniteChest);
		ItemStack soroniteLeggings = new ItemStack(ModItems.soroniteLegs);
		ItemStack soroniteBoots = new ItemStack(ModItems.soroniteBoots);
		ItemStack tarditeHelmet = new ItemStack(ModItems.tarditeHelmet);
		ItemStack tarditeArmour = new ItemStack(ModItems.tarditeChest);
		ItemStack tarditeLeggings = new ItemStack(ModItems.tarditeLegs);
		ItemStack tarditeBoots = new ItemStack(ModItems.tarditeBoots);
		ItemStack koroninHelmet = new ItemStack(ModItems.koroninHelmet);
		ItemStack koroninArmour = new ItemStack(ModItems.koroninChest);
		ItemStack koroninLeggings = new ItemStack(ModItems.koroninLegs);
		ItemStack koroninBoots = new ItemStack(ModItems.koroninBoots);

		soroniteHelmet.addEnchantment(Enchantment.protection, 1);
		soroniteArmour.addEnchantment(Enchantment.blastProtection, 1);
		soroniteLeggings.addEnchantment(Enchantment.fireProtection, 1);
		soroniteBoots.addEnchantment(Enchantment.projectileProtection, 1);
		tarditeHelmet.addEnchantment(Enchantment.aquaAffinity, 1);
		tarditeArmour.addEnchantment(Enchantment.respiration, 1);
		tarditeLeggings.addEnchantment(Enchantment.thorns, 1);
		tarditeBoots.addEnchantment(Enchantment.featherFalling, 1);
		koroninHelmet.addEnchantment(Enchantment.thorns, 1);
		koroninArmour.addEnchantment(Enchantment.unbreaking, 1);
		koroninLeggings.addEnchantment(Enchantment.unbreaking, 1);
		koroninBoots.addEnchantment(Enchantment.thorns, 1);

		recipes = new ArrayList();

		addRecipe(new ItemStack(ModBlocks.duplicator), new Object[] { "GPG", "BDB", "BFB", Character.valueOf('G'), Item.ingotGold, Character.valueOf('P'), new ItemStack(Block.cloth, 1, 10), Character.valueOf('B'), Block.netherBrick, Character.valueOf('D'), new ItemStack(ModItems.arcaneGem, 1, 0), Character.valueOf('F'), Block.furnaceIdle });
		addRecipe(new ItemStack(ModBlocks.fuser), new Object[] { "IGI", "BDB", "BFB", Character.valueOf('I'), Item.ingotGold, Character.valueOf('G'), new ItemStack(Block.cloth, 1, 5), Character.valueOf('B'), Block.brick, Character.valueOf('D'), new ItemStack(Item.diamond), Character.valueOf('F'), Block.furnaceIdle });
		addRecipe(soroniteHelmet, new Object[] { "SSS", "S S", Character.valueOf('S'), new ItemStack(ModItems.magicIngot, 1, 0) });
		addRecipe(soroniteArmour, new Object[] { "S S", "SSS", "SSS", Character.valueOf('S'), new ItemStack(ModItems.magicIngot, 1, 0) });
		addRecipe(soroniteLeggings, new Object[] { "SSS", "S S", "S S", Character.valueOf('S'), new ItemStack(ModItems.magicIngot, 1, 0) });
		addRecipe(soroniteBoots, new Object[] { "S S", "S S", Character.valueOf('S'), new ItemStack(ModItems.magicIngot, 1, 0) });
		addRecipe(tarditeHelmet, new Object[] { "TTT", "T T", Character.valueOf('T'), new ItemStack(ModItems.magicIngot, 1, 1) });
		addRecipe(tarditeArmour, new Object[] { "T T", "TTT", "TTT", Character.valueOf('T'), new ItemStack(ModItems.magicIngot, 1, 1) });
		addRecipe(tarditeLeggings, new Object[] { "TTT", "T T", "T T", Character.valueOf('T'), new ItemStack(ModItems.magicIngot, 1, 1) });
		addRecipe(tarditeBoots, new Object[] { "T T", "T T", Character.valueOf('T'), new ItemStack(ModItems.magicIngot, 1, 1) });
		addRecipe(koroninHelmet, new Object[] { "KKK", "K K", Character.valueOf('K'), new ItemStack(ModItems.magicIngot, 1, 2) });
		addRecipe(koroninArmour, new Object[] { "K K", "KKK", "KKK", Character.valueOf('K'), new ItemStack(ModItems.magicIngot, 1, 2) });
		addRecipe(koroninLeggings, new Object[] { "KKK", "K K", "K K", Character.valueOf('K'), new ItemStack(ModItems.magicIngot, 1, 2) });
		addRecipe(koroninBoots, new Object[] { "K K", "K K", Character.valueOf('K'), new ItemStack(ModItems.magicIngot, 1, 2) });

		Collections.sort(this.recipes, new AlchemyRecipeSorter(this));

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ShapedRecipes addRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {

		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (par2ArrayOfObj[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) par2ArrayOfObj[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		} else {
			while (par2ArrayOfObj[i] instanceof String) {
				String s2 = (String) par2ArrayOfObj[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap hashmap;

		for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2) {
			Character character = (Character) par2ArrayOfObj[i];
			ItemStack itemstack1 = null;

			if (par2ArrayOfObj[i + 1] instanceof Item) {
				itemstack1 = new ItemStack((Item) par2ArrayOfObj[i + 1]);
			} else if (par2ArrayOfObj[i + 1] instanceof Block) {
				itemstack1 = new ItemStack((Block) par2ArrayOfObj[i + 1], 1, 32767);
			} else if (par2ArrayOfObj[i + 1] instanceof ItemStack) {
				itemstack1 = (ItemStack) par2ArrayOfObj[i + 1];
			}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0))) {
				aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).copy();
			} else {
				aitemstack[i1] = null;
			}
		}

		ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, par1ItemStack);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {

		ArrayList arraylist = new ArrayList();
		Object[] aobject = par2ArrayOfObj;
		int i = par2ArrayOfObj.length;

		for (int j = 0; j < i; ++j) {
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack) object1).copy());
			} else if (object1 instanceof Item) {
				arraylist.add(new ItemStack((Item) object1));
			} else {
				if (!(object1 instanceof Block)) {
					throw new RuntimeException("Invalid shapeless recipy!");
				}

				arraylist.add(new ItemStack((Block) object1));
			}
		}

		this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j) {
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

			if (itemstack2 != null) {
				if (i == 0) {
					itemstack = itemstack2;
				}

				if (i == 1) {
					itemstack1 = itemstack2;
				}

				++i;
			}
		}

		if (i == 2 && itemstack.itemID == itemstack1.itemID && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && Item.itemsList[itemstack.itemID].isRepairable()) {
			Item item = Item.itemsList[itemstack.itemID];
			int k = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int l = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int i1 = k + l + item.getMaxDamage() * 5 / 100;
			int j1 = item.getMaxDamage() - i1;

			if (j1 < 0) {
				j1 = 0;
			}

			return new ItemStack(itemstack.itemID, 1, j1);
		} else {
			for (j = 0; j < this.recipes.size(); ++j) {
				IRecipe irecipe = (IRecipe) this.recipes.get(j);

				if (irecipe.matches(par1InventoryCrafting, par2World)) {
					return irecipe.getCraftingResult(par1InventoryCrafting);
				}
			}

			return null;
		}

	}

	@SuppressWarnings("rawtypes")
	public List getRecipeList() {
		return this.recipes;
	}

}
