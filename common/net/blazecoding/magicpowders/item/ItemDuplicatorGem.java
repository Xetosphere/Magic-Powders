package net.blazecoding.magicpowders.item;

import java.util.List;

import net.blazecoding.magicpowders.MagicPowders;
import net.blazecoding.magicpowders.lib.Strings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

/**
 * 
 * Magic Powders
 * 
 * ItemDuplicatorGem
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemDuplicatorGem extends ItemMP {

	public ItemDuplicatorGem(int id) {
		super(id);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.DUPLICATORGEM_NAME);
		setCreativeTab(MagicPowders.tabMP);
		setMaxDamage(32 - 1);
	}

	public String getItemDisplayName(ItemStack itemStack) {
		return EnumChatFormatting.BLUE + super.getItemDisplayName(itemStack);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par5Boolean) {
		list.add("Uses: " + (this.getMaxDamage() - itemStack.getItemDamage()));
	}

	public ItemStack getContainerItemStack(ItemStack itemStack) {

		ItemStack dupleStack = new ItemStack(ModItems.duplicatorGem, 1, (itemStack.getItemDamage() + 1));

		return dupleStack;
	}

}
