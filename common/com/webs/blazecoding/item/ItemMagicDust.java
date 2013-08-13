package com.webs.blazecoding.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.webs.blazecoding.MagicPowders;
import com.webs.blazecoding.lib.References;

/**
 * 
 * Magic Powders
 * 
 * ItemMagicDust
 * 
 * @author BlazeCoding
 * @license Lesser Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */

public class ItemMagicDust extends Item {

	public ItemMagicDust(int id) {
		super(id);
		setCreativeTab(MagicPowders.tabMP);
	}

	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(String.format("%s:%s", References.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
