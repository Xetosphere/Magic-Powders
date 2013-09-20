package com.xetosphere.arcane.creativetab;

import com.xetosphere.arcane.item.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabARC extends CreativeTabs {

	public TabARC(int id, String nameInCode) {
		super(id, nameInCode);
	}

	public ItemStack getIconItemStack() {
		return new ItemStack(ModItems.magicDust, 1, 0);
	}

}
