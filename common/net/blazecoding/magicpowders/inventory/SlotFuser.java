package net.blazecoding.magicpowders.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * 
 * Magic Powders
 * 
 * SlotFuser
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SlotFuser extends Slot {

	public SlotFuser(IInventory inventory, int x, int y, int z) {
		super(inventory, x, y, z);
	}

	public boolean isItemValid(ItemStack par1ItemStack) {
		return false;
	}

}
