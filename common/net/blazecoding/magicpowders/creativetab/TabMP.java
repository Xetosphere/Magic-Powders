package net.blazecoding.magicpowders.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * 
 * Magic Powders
 * 
 * TabMP
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class TabMP extends CreativeTabs {

	public TabMP(int id, String nameInCode) {
		super(id, nameInCode);
	}

	public ItemStack getIconItemStack() {
		return new ItemStack(Item.diamond.itemID, 1, 0);
	}

}
