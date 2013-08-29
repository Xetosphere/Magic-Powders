package net.blazecoding.magicpowders.inventory;

import net.blazecoding.magicpowders.tileentity.TileFuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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

	private TileFuser tileFuser;

	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public ContainerFuser(InventoryPlayer inventoryPlayer, TileFuser fuser) {

		// Add the input slot to the container
		this.addSlotToContainer(new Slot(fuser, TileFuser.INPUT_INVENTORY_INDEX, 56, 17));

		// Add the fuel slot to the container
		this.addSlotToContainer(new Slot(fuser, TileFuser.FUEL_INVENTORY_INDEX, 56, 53));

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

	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.tileFuser.furnaceCookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.tileFuser.furnaceBurnTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.tileFuser.currentItemBurnTime);
	}

	public void detectAndSendChanges() {

		super.detectAndSendChanges();

		for (int var1 = 0; var1 < this.crafters.size(); ++var1) {

			ICrafting var2 = (ICrafting) this.crafters.get(var1);

			if (this.lastCookTime != this.tileFuser.furnaceCookTime) {
				var2.sendProgressBarUpdate(this, 0, this.tileFuser.furnaceCookTime);
			}

			if (this.lastBurnTime != this.tileFuser.furnaceBurnTime) {
				var2.sendProgressBarUpdate(this, 1, this.tileFuser.furnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.tileFuser.currentItemBurnTime) {
				var2.sendProgressBarUpdate(this, 2, this.tileFuser.currentItemBurnTime);
			}

			this.lastCookTime = this.tileFuser.furnaceCookTime;
			this.lastBurnTime = this.tileFuser.furnaceBurnTime;
			this.lastItemBurnTime = this.tileFuser.currentItemBurnTime;

		}
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {

		if (par1 == 0) {
			this.tileFuser.furnaceCookTime = par2;
		}

		if (par1 == 1) {
			this.tileFuser.furnaceBurnTime = par2;
		}

		if (par1 == 2) {
			this.tileFuser.currentItemBurnTime = par2;
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
