package com.xetosphere.arcane.item;

import java.util.List;

import com.xetosphere.arcane.ArcaneEphilesophy;
import com.xetosphere.arcane.lib.Strings;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemDuplicatorGem extends ItemAEX {

	public ItemDuplicatorGem(int id) {
		super(id);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.DUPLICATORGEM_NAME);
		setCreativeTab(ArcaneEphilesophy.tabAEX);
		setMaxDamage(32 - 1);
	}

	public String getItemDisplayName(ItemStack itemStack) {
		return EnumChatFormatting.BLUE + super.getItemDisplayName(itemStack);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par5Boolean) {
		list.add("Uses: " + (this.getMaxDamage() - itemStack.getItemDamage()));
	}

	public ItemStack getContainerItemStack(ItemStack itemStack) {

		ItemStack dupleStack = new ItemStack(ModItems.duplicatorGem, 1, (itemStack.getItemDamage() + 1));

		return dupleStack;
	}
	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack) {
		return false;
	}

}
