package net.blazecoding.magicpowders.item;

import net.blazecoding.magicpowders.lib.References;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;


public class ItemMP extends Item {

	public ItemMP(int id) {
		super(id - References.SHIFTED_ID_RANGE_CORRECTION);
		setNoRepair();
	}
	
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
