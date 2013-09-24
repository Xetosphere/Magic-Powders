package com.xetosphere.arcane.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.xetosphere.arcane.item.ModItems;

public class TabARC extends CreativeTabs {

	public TabARC(int id, String nameInCode) {
		super(id, nameInCode);
	}

	public ItemStack getIconItemStack() {
		return new ItemStack(ModItems.magicDust, 1, 0);
	}

}
