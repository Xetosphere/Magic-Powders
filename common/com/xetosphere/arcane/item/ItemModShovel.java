package com.xetosphere.arcane.item;

import java.util.List;

import com.xetosphere.arcane.ArchaniCommutatio;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemModShovel extends ItemSpade {

	public ItemModShovel(int id, EnumToolMaterial toolMaterial) {
		super(id, toolMaterial);
		setCreativeTab(ArchaniCommutatio.tabARC);
	}

	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par5Boolean) {
		list.add("Uses: " + (this.getMaxDamage() - itemStack.getItemDamage()));
	}

	public String getItemDisplayName(ItemStack itemStack) {
		if (itemStack.getItem() == ModItems.soroniteShovel) {
			return EnumChatFormatting.BLUE + super.getItemDisplayName(itemStack);
		}
		if (itemStack.getItem() == ModItems.tarditeShovel) {
			return EnumChatFormatting.YELLOW + super.getItemDisplayName(itemStack);
		}
		if (itemStack.getItem() == ModItems.koroninShovel) {
			return EnumChatFormatting.AQUA + super.getItemDisplayName(itemStack);
		}
		return null;
	}

}
