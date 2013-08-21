package net.blazecoding.magicpowders.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

/**
 * 
 * Magic Powders
 * 
 * ItemBlockStorageBlocks
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemBlockStorageBlocks extends ItemBlock {

	public static final String[] BLOCK_NAMES = { "SironBlock", "TarmiteBlock", "KormondBlock" };

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
