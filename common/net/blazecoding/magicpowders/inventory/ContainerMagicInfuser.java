package net.blazecoding.magicpowders.inventory;

import net.blazecoding.magicpowders.inventory.slot.SlotMagicInfuser;
import net.blazecoding.magicpowders.tileentity.TileEntityMagicInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMagicInfuser extends Container {

	private TileEntityMagicInfuser infuser;

	private int dualCookTime;
	private int dualBurnTime;
	private int lastItemBurnTime;

	public ContainerMagicInfuser(InventoryPlayer inventoryplayer, TileEntityMagicInfuser tileentityInputFurnace) {

		dualCookTime = 0;
		dualBurnTime = 0;
		lastItemBurnTime = 0;

		infuser = tileentityInputFurnace;

		this.addSlotToContainer(new Slot(tileentityInputFurnace, 0, 38, 17));
		this.addSlotToContainer(new Slot(tileentityInputFurnace, 1, 74, 17));
		this.addSlotToContainer(new Slot(tileentityInputFurnace, 2, 56, 53));
		this.addSlotToContainer(new SlotMagicInfuser(inventoryplayer.player, tileentityInputFurnace, 3, 116, 35));

		for (int i = 0; i < 3; i++) {

			for (int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}

		}

		for (int j = 0; j < 9; j++) {
			this.addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
		}

	}

	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.infuser.dualCookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.infuser.dualBurnTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int var1 = 0; var1 < this.crafters.size(); ++var1) {

			ICrafting var2 = (ICrafting) this.crafters.get(var1);

			if (this.dualCookTime != this.infuser.dualCookTime) {
				var2.sendProgressBarUpdate(this, 0, this.infuser.dualCookTime);
			}

			if (this.dualBurnTime != this.infuser.dualBurnTime) {
				var2.sendProgressBarUpdate(this, 1, this.infuser.dualBurnTime);
			}

			if (this.lastItemBurnTime != this.infuser.currentItemBurnTime) {
				var2.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
			}

		}

		this.dualCookTime = this.infuser.dualCookTime;
		this.dualBurnTime = this.infuser.dualBurnTime;
		this.lastItemBurnTime = this.infuser.currentItemBurnTime;

	}

	public void updateProgressBar(int i, int j) {

		if (i == 0) {
			infuser.dualCookTime = j;
		}

		if (i == 1) {
			infuser.dualBurnTime = j;
		}

		if (i == 2) {
			infuser.currentItemBurnTime = j;
		}

	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {

		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {

			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 2) {

				if (!mergeItemStack(itemstack1, 3, 39, true)) {
					return null;
				}

			} else if (par2 >= 3 && par2 < 30) {

				if (!mergeItemStack(itemstack1, 30, 39, false)) {
					return null;
				}

			} else if (par2 >= 30 && par2 < 39) {

				if (!mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}

			} else if (!mergeItemStack(itemstack1, 3, 39, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {

				slot.putStack(null);

			} else {

				slot.onSlotChanged();

			}

			if (itemstack1.stackSize != itemstack.stackSize) {
				slot.onPickupFromSlot(par1EntityPlayer, itemstack1);

			} else {

				return null;

			}

		}
		return itemstack;
	}

	public boolean canInteractWith(EntityPlayer entityplayer) {
		return infuser.isUseableByPlayer(entityplayer);
	}
}
