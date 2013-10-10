package com.xetosphere.arcane.item.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemBlockMagicPowderOres extends ItemBlock {

	public static final String[] ORE_NAMES = { "SoroniteOre", "TarditeOre", "KoroninOre" };

	public ItemBlockMagicPowderOres(int id) {

		super(id);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemStack) {

		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, ORE_NAMES.length);
		return super.getUnlocalizedName() + ORE_NAMES[meta];

	}

	public int getMetadata(int meta) {

		return meta;
	}

}
