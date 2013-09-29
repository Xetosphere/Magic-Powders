package com.xetosphere.arcane.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.xetosphere.arcane.tileentity.TileArcaneFuser;
import com.xetosphere.arcane.tileentity.TileArcaneInfuser;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerArcaneInfuser extends Container {

	private TileArcaneInfuser infuser;

	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public ContainerArcaneInfuser(InventoryPlayer inventoryPlayer, TileArcaneInfuser infuser) {

		this.infuser = infuser;

		// Add the input slot to the container
		this.addSlotToContainer(new Slot(infuser, TileArcaneFuser.INPUT_INVENTORY_INDEX, 56, 17));

		// Add the fuel slot to the container
		this.addSlotToContainer(new Slot(infuser, TileArcaneFuser.FUEL_INVENTORY_INDEX, 56, 53));

		// Add the dust input slot to the container
		this.addSlotToContainer(new SlotArcaneInfuser(infuser, TileArcaneFuser.DUST_INVENTORY_INDEX, 116, 25));

		// Add the output results slot to the container
		this.addSlotToContainer(new SlotArcaneInfuser(infuser, TileArcaneFuser.OUTPUT_INVENTORY_INDEX, 116, 45));

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
		par1ICrafting.sendProgressBarUpdate(this, 0, this.infuser.infuserFusedTime2);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.infuser.infuserFuseTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemFuseTime);
	}

	public void detectAndSendChanges() {

		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {

			ICrafting iCrafting = (ICrafting) this.crafters.get(i);

			if (this.lastCookTime != this.infuser.infuserFusedTime2) {
				iCrafting.sendProgressBarUpdate(this, 0, this.infuser.infuserFusedTime2);
			}

			if (this.lastBurnTime != this.infuser.infuserFuseTime) {
				iCrafting.sendProgressBarUpdate(this, 1, this.infuser.infuserFuseTime);
			}

			if (this.lastItemBurnTime != this.infuser.currentItemFuseTime) {
				iCrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemFuseTime);
			}

			this.lastCookTime = this.infuser.infuserFusedTime2;
			this.lastBurnTime = this.infuser.infuserFuseTime;
			this.lastItemBurnTime = this.infuser.currentItemFuseTime;
		}
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {

		if (par1 == 0) {
			this.infuser.infuserFusedTime2 = par2;
		}

		if (par1 == 1) {
			this.infuser.infuserFuseTime = par2;
		}

		if (par1 == 2) {
			this.infuser.currentItemFuseTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer player) {

		return infuser.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {

		ItemStack itemStack = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack()) {

			ItemStack slotItemStack = slot.getStack();
			itemStack = slotItemStack.copy();

			if (slotIndex < TileArcaneInfuser.INVENTORY_SIZE) {

				if (!this.mergeItemStack(slotItemStack, TileArcaneInfuser.INVENTORY_SIZE, inventorySlots.size(), false)) {
					return null;
				}

			} else {

				if (TileArcaneInfuser.isItemFuel(slotItemStack)) {
					if (!this.mergeItemStack(slotItemStack, TileArcaneInfuser.FUEL_INVENTORY_INDEX, TileArcaneFuser.OUTPUT_INVENTORY_INDEX, false)) {
						return null;
					}
				}

				else if (!this.mergeItemStack(slotItemStack, TileArcaneInfuser.INPUT_INVENTORY_INDEX, TileArcaneFuser.OUTPUT_INVENTORY_INDEX, false)) {
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
