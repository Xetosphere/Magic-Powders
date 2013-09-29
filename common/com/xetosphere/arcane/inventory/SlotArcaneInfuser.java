package com.xetosphere.arcane.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotArcaneInfuser extends Slot {

	public SlotArcaneInfuser(IInventory inventory, int slot, int x, int y) {

		super(inventory, slot, x, y);
	}

	public boolean isItemValid(ItemStack par1ItemStack) {

		return false;
	}

}
