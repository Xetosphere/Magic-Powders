package com.xetosphere.arcane.creativetab;

import com.xetosphere.arcane.item.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabAEX extends CreativeTabs {

	public TabAEX(int id, String nameInCode) {
		super(id, nameInCode);
	}

	public ItemStack getIconItemStack() {
		return new ItemStack(ModItems.magicDust, 1, 0);
	}

}
