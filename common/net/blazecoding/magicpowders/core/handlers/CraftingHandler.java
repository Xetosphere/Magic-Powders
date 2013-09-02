package net.blazecoding.magicpowders.core.handlers;

import net.blazecoding.magicpowders.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

/**
 * 
 * Magic Powders
 * 
 * CraftingHandler
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CraftingHandler implements ICraftingHandler {

	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {

		dupleCrafting(craftMatrix);
		
	}

	public void onSmelting(EntityPlayer player, ItemStack item) {

	}

	private static void dupleCrafting(IInventory craftMatrix) {

		for (int i = 0; i < craftMatrix.getSizeInventory(); ++i) {

			if (craftMatrix.getStackInSlot(i) != null) {

				ItemStack craftStack = craftMatrix.getStackInSlot(i);

				if (craftStack.getItem() != null && craftStack.getItem() == ModItems.duplicatorGem) {

					ItemStack dupleGem = new ItemStack(ModItems.duplicatorGem, 2, (craftStack.getItemDamage() + 1));

					if (dupleGem.getItemDamage() >= dupleGem.getMaxDamage()) {
						--dupleGem.stackSize;
					}

					craftMatrix.setInventorySlotContents(i, dupleGem);

				}
			}
		}
	}

}
