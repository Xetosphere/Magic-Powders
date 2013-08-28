package net.blazecoding.magicpowders.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.blazecoding.magicpowders.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * 
 * Magic Powders
 * 
 * FuserRecipes
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class FuserRecipes {

	private static final FuserRecipes fusingBase = new FuserRecipes();

	@SuppressWarnings("rawtypes")
	private Map fusingList = new HashMap();
	private HashMap<List<Integer>, ItemStack> metaFusingList = new HashMap<List<Integer>, ItemStack>();

	public static final FuserRecipes fusing() {
		return fusingBase;
	}

	private FuserRecipes() {
		addFusing(Item.ingotIron.itemID, new ItemStack(ModItems.magicIngot, 1, 0));
	}

	@SuppressWarnings("unchecked")
	public void addFusing(int par1, ItemStack par2ItemStack) {
		this.fusingList.put(Integer.valueOf(par1), par2ItemStack);
	}

	@Deprecated
	public ItemStack getFusingResult(int par1) {
		return (ItemStack) this.fusingList.get(Integer.valueOf(par1));
	}

	@SuppressWarnings("rawtypes")
	public Map getFusingList() {
		return this.fusingList;
	}

	public void addFusing(int itemID, int metadata, ItemStack itemstack) {
		metaFusingList.put(Arrays.asList(itemID, metadata), itemstack);
	}

	public ItemStack getFusingResult(ItemStack item) {

		if (item == null) {
			return null;
		}

		ItemStack ret = (ItemStack) metaFusingList.get(Arrays.asList(item.itemID, item.getItemDamage()));

		if (ret != null) {
			return ret;
		}

		return (ItemStack) fusingList.get(Integer.valueOf(item.itemID));

	}

	public Map<List<Integer>, ItemStack> getMetaSmeltingList() {
		return metaFusingList;
	}

}
