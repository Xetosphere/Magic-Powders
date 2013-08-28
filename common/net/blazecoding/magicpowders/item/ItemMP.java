package net.blazecoding.magicpowders.item;

import net.blazecoding.magicpowders.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

/**
 * 
 * Magic Powders
 * 
 * ItemMP
 * 
 * @author BlazeCoding
 * @license Lesser Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemMP extends Item {

	public ItemMP(int id) {
		super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
		setNoRepair();
	}

	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
