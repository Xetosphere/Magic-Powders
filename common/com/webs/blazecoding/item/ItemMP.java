package com.webs.blazecoding.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.webs.blazecoding.lib.References;

public class ItemMP extends Item {

	public ItemMP(int id) {
		super(id - References.SHIFTED_ID_RANGE_CORRECTION);
		setNoRepair();
	}
	
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
