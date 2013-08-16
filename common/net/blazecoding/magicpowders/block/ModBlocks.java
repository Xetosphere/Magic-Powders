package net.blazecoding.magicpowders.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.blazecoding.magicpowders.item.ItemBlockMagicPowderOres;
import net.blazecoding.magicpowders.lib.BlockIDs;
import net.blazecoding.magicpowders.lib.Strings;
import net.minecraft.block.Block;

/**
 * 
 * Magic Powders
 * 
 * ModBlocks
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ModBlocks {

	public static Block magicPowderOres;

	/**
	 * Initializes the blocks that the mod contains. As well as block recipes and registering the blocks.
	 */
	public static void init() {

		magicPowderOres = new BlockMagicPowderOres(BlockIDs.powderOresID);

		registerBlocks();

	}

	public static void registerBlocks() {

		GameRegistry.registerBlock(magicPowderOres, ItemBlockMagicPowderOres.class, Strings.POWDERORES_NAME);

	}

}
