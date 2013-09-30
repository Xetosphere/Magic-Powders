package com.xetosphere.arcane.item;

import com.xetosphere.arcane.ArchaniCommutatio;
import com.xetosphere.arcane.lib.Strings;

public class ItemStuddedPaper extends ItemARC {

	public ItemStuddedPaper(int id) {

		super(id);
		setCreativeTab(ArchaniCommutatio.tabARC);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.STUDDED_PAPER_NAME);
		maxStackSize = 64;
	}

}
