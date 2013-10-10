package com.xetosphere.arcane.item.tools;

import java.util.List;

import com.xetosphere.arcane.ArchaniCommutatio;
import com.xetosphere.arcane.item.ModItems;
import com.xetosphere.arcane.lib.Reference;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemModAxe extends ItemAxe {

	public ItemModAxe(int id, EnumToolMaterial toolMaterial) {

		super(id - Reference.SHIFTED_ID_RANGE_CORRECTION, toolMaterial);
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

		if (itemStack.getItem() == ModItems.soroniteAxe) {
			return EnumChatFormatting.BLUE + super.getItemDisplayName(itemStack);
		}
		if (itemStack.getItem() == ModItems.tarditeAxe) {
			return EnumChatFormatting.YELLOW + super.getItemDisplayName(itemStack);
		}
		if (itemStack.getItem() == ModItems.koroninAxe) {
			return EnumChatFormatting.AQUA + super.getItemDisplayName(itemStack);
		}

		return null;
	}

}
