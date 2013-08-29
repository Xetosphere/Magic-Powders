package net.blazecoding.magicpowders.tileentity;

import net.blazecoding.magicpowders.item.ModItems;
import net.blazecoding.magicpowders.lib.Strings;
import net.blazecoding.magicpowders.recipe.FuserRecipes;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * Magic Powders
 * 
 * TileFuser
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class TileFuser extends TileMP implements IInventory {

	private ItemStack[] inventory;

	public static final int INVENTORY_SIZE = 3;

	public static final int INPUT_INVENTORY_INDEX = 0;
	public static final int FUEL_INVENTORY_INDEX = 1;
	public static final int OUTPUT_INVENTORY_INDEX = 2;

	public int furnaceBurnTime;
	public int currentItemBurnTime;
	public int furnaceCookTime;

	public TileFuser() {
		inventory = new ItemStack[INVENTORY_SIZE];
	}

	public int getSizeInventory() {
		return inventory.length;
	}

	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	public ItemStack decrStackSize(int slot, int ammount) {
		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			if (itemStack.stackSize <= ammount) {
				setInventorySlotContents(slot, null);
			} else {
				itemStack = itemStack.splitStack(ammount);
				if (itemStack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return itemStack;
	}

	public ItemStack getStackInSlotOnClosing(int slot) {

		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			setInventorySlotContents(slot, null);
		}
		return itemStack;
	}

	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		inventory[slot] = itemStack;
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
			itemStack.stackSize = getInventoryStackLimit();
		}
	}

	public String getInvName() {
		return this.hasCustomName() ? this.getCustomName() : Strings.CONTAINER_FUSER_NAME;
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public void openChest() {
	}

	public void closeChest() {
	}

	public void readFromNBT(NBTTagCompound nbtTagCompound) {

		super.readFromNBT(nbtTagCompound);

		NBTTagList tagList = nbtTagCompound.getTagList("Items");
		inventory = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tagCompound.getByte("Slot");
			if (slot >= 0 && slot < inventory.length) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}

			this.furnaceBurnTime = nbtTagCompound.getShort("FuseTime");
			this.furnaceCookTime = nbtTagCompound.getShort("TimeSpent");

		}

	}

	public void writeToNBT(NBTTagCompound nbtTagCompound) {

		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setShort("FuseTime", (short) this.furnaceBurnTime);
		nbtTagCompound.setShort("TimeSpent", (short) this.furnaceCookTime);

		NBTTagList tagList = new NBTTagList();
		for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
			if (inventory[currentIndex] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) currentIndex);
				inventory[currentIndex].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}
		nbtTagCompound.setTag("Items", tagList);
	}

	public boolean isInvNameLocalized() {
		return this.hasCustomName();
	}

	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return true;
	}

	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(super.toString());

		stringBuilder.append("TileFuser Data - ");
		for (int i = 0; i < inventory.length; i++) {
			if (i != 0) {
				stringBuilder.append(", ");
			}

			if (inventory[i] != null) {
				stringBuilder.append(String.format("inventory[%d]: %s", i, inventory[i].toString()));
			} else {
				stringBuilder.append(String.format("inventory[%d]: empty", i));
			}
		}

		stringBuilder.append("\n");

		return stringBuilder.toString();

	}

	@SideOnly(Side.CLIENT)
	public int getCookProgressTimeScaled(int par1) {
		return this.furnaceCookTime * par1 / 200;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {

		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}

		return this.furnaceBurnTime * par1 / this.currentItemBurnTime;

	}

	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	public void updateEntity() {

		boolean flag = this.furnaceBurnTime > 0;
		boolean flag1 = false;

		if (this.furnaceBurnTime > 0) {
			--this.furnaceBurnTime;
		}

		if (!this.worldObj.isRemote) {
			if (this.furnaceBurnTime == 0 && this.canSmelt()) {
				this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.inventory[FUEL_INVENTORY_INDEX]);
				if (this.furnaceBurnTime > 0) {
					flag1 = true;
					if (this.inventory[FUEL_INVENTORY_INDEX] != null) {
						--this.inventory[FUEL_INVENTORY_INDEX].stackSize;
						if (this.inventory[FUEL_INVENTORY_INDEX].stackSize == 0) {
							this.inventory[FUEL_INVENTORY_INDEX] = this.inventory[FUEL_INVENTORY_INDEX].getItem().getContainerItemStack(inventory[FUEL_INVENTORY_INDEX]);
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt()) {
				++this.furnaceCookTime;

				if (this.furnaceCookTime == 200) {
					this.furnaceCookTime = 0;
					this.smeltItem();
					flag1 = true;
				}

			} else {

				this.furnaceCookTime = 0;

			}

			if (flag != this.furnaceBurnTime > 0) {
				flag1 = true;
			}

		}

		if (flag1) {
			this.onInventoryChanged();
		}
	}

	private boolean canSmelt() {

		if (this.inventory[INPUT_INVENTORY_INDEX] == null) {

			return false;

		} else {

			ItemStack itemstack = FuserRecipes.fusing().getFusingResult(this.inventory[INPUT_INVENTORY_INDEX]);

			if (itemstack == null) return false;
			if (this.inventory[OUTPUT_INVENTORY_INDEX] == null) return true;
			if (!this.inventory[OUTPUT_INVENTORY_INDEX].isItemEqual(itemstack)) return false;
			int result = inventory[OUTPUT_INVENTORY_INDEX].stackSize + itemstack.stackSize;

			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}

	public void smeltItem() {

		if (this.canSmelt()) {

			ItemStack itemstack = FuserRecipes.fusing().getFusingResult(this.inventory[INPUT_INVENTORY_INDEX]);

			if (this.inventory[OUTPUT_INVENTORY_INDEX] == null) {

				this.inventory[OUTPUT_INVENTORY_INDEX] = itemstack.copy();

			} else if (this.inventory[OUTPUT_INVENTORY_INDEX].isItemEqual(itemstack)) {

				inventory[OUTPUT_INVENTORY_INDEX].stackSize += itemstack.stackSize;

			}

			--this.inventory[INPUT_INVENTORY_INDEX].stackSize;

			if (this.inventory[INPUT_INVENTORY_INDEX].stackSize <= 0) {
				this.inventory[INPUT_INVENTORY_INDEX] = null;
			}
		}
	}

	public static int getItemBurnTime(ItemStack itemStack) {

		if (itemStack == null) {
			return 0;
		}

		int i = itemStack.getItem().itemID;
		int j = itemStack.getItemDamage();

		if (i == ModItems.magicDust.itemID && j == 0) return 200;
		if (i == ModItems.magicDust.itemID && j == 1) return 200;
		if (i == ModItems.magicDust.itemID && j == 2) return 200;

		return GameRegistry.getFuelValue(itemStack);

	}

	public static boolean isItemDust(ItemStack itemStack) {
		return getItemBurnTime(itemStack) > 0;
	}

}
