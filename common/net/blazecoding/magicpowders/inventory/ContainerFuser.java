package net.blazecoding.magicpowders.inventory;

import net.blazecoding.magicpowders.tileentity.TileFuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * 
 * Magic Powders
 * 
 * ContainerFuser
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ContainerFuser extends Container {

	public ContainerFuser(InventoryPlayer inventoryPlayer, TileFuser fuser) {

		// Add the fuel slot to the container
		this.addSlotToContainer(new Slot(fuser, TileFuser.FUEL_INVENTORY_INDEX, 56, 53));

		// Add the input slot to the container
		this.addSlotToContainer(new Slot(fuser, TileFuser.INPUT_INVENTORY_INDEX, 56, 17));

		// Add the output results slot to the container
		this.addSlotToContainer(new SlotFuser(fuser, TileFuser.OUTPUT_INVENTORY_INDEX, 116, 35));

		// Add the player's inventory slots to the container
		for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
			for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
				this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
			}
		}

		// Add the player's action bar slots to the container
		for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
			this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
		}

	}

	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {

		ItemStack itemStack = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack()) {

			ItemStack slotItemStack = slot.getStack();
			itemStack = slotItemStack.copy();

			if (slotIndex < TileFuser.INVENTORY_SIZE) {

				if (!this.mergeItemStack(slotItemStack, TileFuser.INVENTORY_SIZE, inventorySlots.size(), false)) {
					return null;
				}

			} else {

				if (TileFuser.isItemDust(slotItemStack)) {
					if (!this.mergeItemStack(slotItemStack, TileFuser.FUEL_INVENTORY_INDEX, TileFuser.OUTPUT_INVENTORY_INDEX, false)) {
						return null;
					}
				}

				else if (!this.mergeItemStack(slotItemStack, TileFuser.INPUT_INVENTORY_INDEX, TileFuser.OUTPUT_INVENTORY_INDEX, false)) {
					return null;
				}

			}

			if (slotItemStack.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

		}

		return itemStack;

	}

}
