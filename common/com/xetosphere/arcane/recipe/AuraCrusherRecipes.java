package com.xetosphere.arcane.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xetosphere.arcane.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AuraCrusherRecipes {

	private static final AuraCrusherRecipes crushingBase = new AuraCrusherRecipes();

	@SuppressWarnings("rawtypes")
	private Map crushingList = new HashMap();
	private HashMap<List<Integer>, ItemStack> metaCrushingList = new HashMap<List<Integer>, ItemStack>();

	public static final AuraCrusherRecipes crushing() {

		return crushingBase;
	}

	private AuraCrusherRecipes() {

		addCrushing(Item.coal.itemID, 0, new ItemStack(ModItems.metalDusts, 1, 0));
		addCrushing(Item.coal.itemID, 1, new ItemStack(ModItems.metalDusts, 1, 0));
		addCrushing(Item.ingotIron.itemID, 0, new ItemStack(ModItems.metalDusts, 1, 1));
		addCrushing(Item.ingotGold.itemID, 0, new ItemStack(ModItems.metalDusts, 1, 2));
		addCrushing(Item.bone.itemID, 0, new ItemStack(Item.dyePowder, 10, 15));
		addCrushing(Item.blazeRod.itemID, 0, new ItemStack(Item.blazePowder, 5));

		addCrushing(Block.oreCoal.blockID, 0, new ItemStack(ModItems.metalDusts, 2, 0));
		addCrushing(Block.oreIron.blockID, 0, new ItemStack(ModItems.metalDusts, 2, 1));
		addCrushing(Block.oreGold.blockID, 0, new ItemStack(ModItems.metalDusts, 2, 2));
		addCrushing(Block.oreLapis.blockID, 0, new ItemStack(Item.dyePowder, 8, 4));
		addCrushing(Block.oreRedstone.blockID, 0, new ItemStack(Item.redstone, 8, 0));
		addCrushing(Block.gravel.blockID, 0, new ItemStack(Item.flint, 4, 0));
		addCrushing(Block.coalBlock.blockID, 0, new ItemStack(ModItems.metalDusts, 8, 0));
		addCrushing(Block.blockIron.blockID, 0, new ItemStack(ModItems.metalDusts, 8, 1));
		addCrushing(Block.blockGold.blockID, 0, new ItemStack(ModItems.metalDusts, 8, 2));
		addCrushing(Block.brick.blockID, 0, new ItemStack(Item.clay, 4));
		addCrushing(Block.cobblestone.blockID, 0, new ItemStack(ModItems.runeBase, 3));
		addCrushing(Block.cobblestoneMossy.blockID, 0, new ItemStack(ModItems.runeBase, 4));
		addCrushing(Block.stone.blockID, 0, new ItemStack(ModItems.runeBase, 5));
	}

	@SuppressWarnings("unchecked")
	public void addCrushing(int par1, ItemStack par2ItemStack) {

		this.crushingList.put(Integer.valueOf(par1), par2ItemStack);
	}

	@Deprecated
	public ItemStack getCrushingResult(int par1) {

		return (ItemStack) this.crushingList.get(Integer.valueOf(par1));
	}

	@SuppressWarnings("rawtypes")
	public Map getCrushingList() {

		return this.crushingList;
	}

	public void addCrushing(int itemID, int metadata, ItemStack itemstack) {

		metaCrushingList.put(Arrays.asList(itemID, metadata), itemstack);
	}

	public ItemStack getCrushingResult(ItemStack item) {

		if (item == null) {
			return null;
		}

		ItemStack ret = (ItemStack) metaCrushingList.get(Arrays.asList(item.itemID, item.getItemDamage()));

		if (ret != null) {
			return ret;
		}

		return (ItemStack) crushingList.get(Integer.valueOf(item.itemID));
	}

	public Map<List<Integer>, ItemStack> getMetaCrushingList() {

		return metaCrushingList;
	}

}
