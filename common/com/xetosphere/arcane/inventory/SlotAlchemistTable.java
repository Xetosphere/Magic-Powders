package com.xetosphere.arcane.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SlotAlchemistTable extends Slot {

	private final IInventory craftMatrix;

	@SuppressWarnings("unused")
	private int amountCrafted;

	public SlotAlchemistTable(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3IInventory, int par4, int par5, int par6) {

		super(par3IInventory, par4, par5, par6);
		this.craftMatrix = par2IInventory;
	}

	public boolean isItemValid(ItemStack par1ItemStack) {

		return false;
	}

	public ItemStack decrStackSize(int par1) {

		if (this.getHasStack()) {
			this.amountCrafted += Math.min(par1, this.getStack().stackSize);
		}

		return super.decrStackSize(par1);
	}

	protected void onCrafting(ItemStack par1ItemStack, int par2) {

		this.amountCrafted += par2;
		this.onCrafting(par1ItemStack);
	}

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