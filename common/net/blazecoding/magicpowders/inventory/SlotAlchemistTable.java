package net.blazecoding.magicpowders.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Magic Powders
 * 
 * SlotAlchemistTable
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class SlotAlchemistTable extends Slot {

	/** The craft matrix inventory linked to this result slot. */
	private final IInventory craftMatrix;
	/**
	 * The number of items that have been crafted so far. Gets passed to ItemStack.onCrafting before being reset.
	 */
	@SuppressWarnings("unused")
	private int amountCrafted;

	public SlotAlchemistTable(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3IInventory, int par4, int par5, int par6) {
		super(par3IInventory, par4, par5, par6);
		this.craftMatrix = par2IInventory;
	}

	/**
	 * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
	 */
	public boolean isItemValid(ItemStack par1ItemStack) {
		return false;
	}

	/**
	 * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new stack.
	 */
	public ItemStack decrStackSize(int par1) {
		if (this.getHasStack()) {
			this.amountCrafted += Math.min(par1, this.getStack().stackSize);
		}
		return super.decrStackSize(par1);
	}

	/**
	 * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an internal count then calls onCrafting(item).
	 */
	protected void onCrafting(ItemStack par1ItemStack, int par2) {
		this.amountCrafted += par2;
		this.onCrafting(par1ItemStack);
	}

	/**
	 * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
	 */
	protected void onCrafting(ItemStack par1ItemStack) {

	}

	public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
		GameRegistry.onItemCrafted(par1EntityPlayer, par2ItemStack, craftMatrix);
		this.onCrafting(par2ItemStack);
		for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i) {
			ItemStack itemstack1 = this.craftMatrix.getStackInSlot(i);
			if (itemstack1 != null) {
				this.craftMatrix.decrStackSize(i, 1);
			}
		}
	}
}