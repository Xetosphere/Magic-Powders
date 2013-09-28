package com.xetosphere.arcane.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemBlockStorageBlocks extends ItemBlock {

	public static final String[] BLOCK_NAMES = { "SoroniteBlock", "TarditeBlock", "KoroninBlock" };

	public ItemBlockStorageBlocks(int id) {

		super(id);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemStack) {

		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, BLOCK_NAMES.length);
		return super.getUnlocalizedName() + BLOCK_NAMES[meta];

	}

	public int getMetadata(int meta) {

		return meta;
	}

}
