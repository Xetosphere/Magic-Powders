package net.blazecoding.magicpowders.inventory;

import net.blazecoding.magicpowders.tileentity.TileEntityAlloyHeater;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * Magic Powders
 * 
 * ContainerAlloyHeater
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ContainerAlloyHeater extends Container {

	private TileEntityAlloyHeater alloyHeater;

	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public ContainerAlloyHeater(InventoryPlayer inventory, TileEntityAlloyHeater tileEntityAlloyHeater) {

		alloyHeater = tileEntityAlloyHeater;

		this.addSlotToContainer(new Slot(tileEntityAlloyHeater, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileEntityAlloyHeater, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileEntityAlloyHeater, 2, 116, 35));

		int var3;

		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(inventory, var3, 8 + var3 * 18, 142));
		}

	}

	public void addCraftingToCrafters(ICrafting iCrafting) {

		super.addCraftingToCrafters(iCrafting);

		iCrafting.sendProgressBarUpdate(this, 0, alloyHeater.heaterCookTime);
		iCrafting.sendProgressBarUpdate(this, 1, alloyHeater.heaterBurnTime);
		iCrafting.sendProgressBarUpdate(this, 2, alloyHeater.currentItemBurnTime);

	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {

		super.detectAndSendChanges();

		for (int var1 = 0; var1 < this.crafters.size(); ++var1) {

			ICrafting var2 = (ICrafting) this.crafters.get(var1);

			if (this.lastCookTime != alloyHeater.heaterCookTime) {
				var2.sendProgressBarUpdate(this, 0, alloyHeater.heaterCookTime);
			}

			if (this.lastBurnTime != alloyHeater.heaterBurnTime) {
				var2.sendProgressBarUpdate(this, 1, alloyHeater.heaterBurnTime);
			}

			if (this.lastItemBurnTime != this.alloyHeater.currentItemBurnTime) {
				var2.sendProgressBarUpdate(this, 2, alloyHeater.currentItemBurnTime);
			}

		}

		this.lastCookTime = alloyHeater.heaterCookTime;
		this.lastBurnTime = alloyHeater.heaterBurnTime;
		this.lastItemBurnTime = alloyHeater.currentItemBurnTime;

	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {

		if (par1 == 0) {
			alloyHeater.heaterCookTime = par2;
		}

		if (par1 == 1) {
			alloyHeater.heaterBurnTime = par2;
		}

		if (par1 == 2) {
			alloyHeater.currentItemBurnTime = par2;
		}

	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return alloyHeater.isUseableByPlayer(par1EntityPlayer);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {

		ItemStack var3 = null;

		Slot var4 = (Slot) this.inventorySlots.get(par2);

		if (var4 != null && var4.getHasStack()) {

			ItemStack var5 = var4.getStack();

			var3 = var5.copy();

			if (par2 == 2) {

				if (!this.mergeItemStack(var5, 3, 39, true)) {
					return null;
				}

				var4.onSlotChange(var5, var3);

			} else if (par2 != 1 && par2 != 0) {

				if (FurnaceRecipes.smelting().getSmeltingResult(var5) != null) {

					if (!this.mergeItemStack(var5, 0, 1, false)) {
						return null;
					}

				} else if (TileEntityAlloyHeater.isItemFuel(var5)) {

					if (!this.mergeItemStack(var5, 1, 2, false)) {
						return null;
					}

				} else if (par2 >= 3 && par2 < 30) {

					if (!this.mergeItemStack(var5, 30, 39, false)) {
						return null;
					}

				} else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(var5, 3, 30, false)) {
					return null;
				}

			} else if (!this.mergeItemStack(var5, 3, 39, false)) {
				return null;
			}

			if (var5.stackSize == 0) {
				var4.putStack((ItemStack) null);

			} else {

				var4.onSlotChanged();

			}

			if (var5.stackSize == var3.stackSize) {
				return null;
			}

			var4.onPickupFromSlot(par1EntityPlayer, var5);

		}
		return var3;
	}

}
