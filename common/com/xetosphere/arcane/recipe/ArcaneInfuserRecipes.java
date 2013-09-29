package com.xetosphere.arcane.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;

public class ArcaneInfuserRecipes {

	private static final ArcaneInfuserRecipes infusingBase = new ArcaneInfuserRecipes();

	@SuppressWarnings("rawtypes")
	private Map infusingList = new HashMap();
	private HashMap<List<Integer>, ItemStack> metaInfusingList = new HashMap<List<Integer>, ItemStack>();

	public static final ArcaneInfuserRecipes infusing() {

		return infusingBase;
	}

	private ArcaneInfuserRecipes() {

	}

	@SuppressWarnings("unchecked")
	public void addInfusing(int par1, ItemStack par2ItemStack) {

		this.infusingList.put(Integer.valueOf(par1), par2ItemStack);
	}

	@Deprecated
	public ItemStack getInfusingResult(int par1) {

		return (ItemStack) this.infusingList.get(Integer.valueOf(par1));
	}

	@SuppressWarnings("rawtypes")
	public Map getInfusingList() {

		return this.infusingList;
	}

	public void addInfusing(int itemID, int metadata, ItemStack itemstack) {

		metaInfusingList.put(Arrays.asList(itemID, metadata), itemstack);
	}

	public ItemStack getInfusingResult(ItemStack item) {

		if (item == null) {
			return null;
		}

		ItemStack ret = (ItemStack) metaInfusingList.get(Arrays.asList(item.itemID, item.getItemDamage()));

		if (ret != null) {
			return ret;
		}

		return (ItemStack) infusingList.get(Integer.valueOf(item.itemID));
	}

	public Map<List<Integer>, ItemStack> getMetaSmeltingList() {

		return metaInfusingList;
	}

}
