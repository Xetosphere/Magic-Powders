package net.blazecoding.magicpowders.block;

import net.blazecoding.magicpowders.item.ItemBlockMagicPowderOres;
import net.blazecoding.magicpowders.item.ItemBlockStorageBlocks;
import net.blazecoding.magicpowders.item.ModItems;
import net.blazecoding.magicpowders.lib.BlockIDs;
import net.blazecoding.magicpowders.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

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
	public static Block storageBlocks;
	public static Block fuser;
	public static Block duplicator;

	/**
	 * Initializes the blocks that the mod contains. As well as block recipes and registering the blocks.
	 */
	public static void init() {

		magicPowderOres = new BlockMagicPowderOres(BlockIDs.MAGIC_ORES);
		storageBlocks = new BlockStorageBlocks(BlockIDs.STORAGE_BLOCKS);
		fuser = new BlockFuser(BlockIDs.FUSER);
		duplicator = new BlockDuplicator(BlockIDs.DUPLICATOR);

		GameRegistry.registerBlock(fuser, Strings.FUSER_NAME);
		GameRegistry.registerBlock(duplicator, Strings.DUPLICATOR_NAME);

		GameRegistry.registerBlock(magicPowderOres, ItemBlockMagicPowderOres.class, Strings.POWDERORES_NAME);
		GameRegistry.registerBlock(storageBlocks, ItemBlockStorageBlocks.class, Strings.STORAGEBLOCKS_NAME);

		addOreLevels();
		initToOreDictionary();
		addRecipe();

	}

	public static void addOreLevels() {

		MinecraftForge.setBlockHarvestLevel(magicPowderOres, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(magicPowderOres, 1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(magicPowderOres, 2, "pickaxe", 2);

		MinecraftForge.setBlockHarvestLevel(storageBlocks, 0, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(storageBlocks, 1, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(storageBlocks, 2, "pickaxe", 0);

	}

	public static void initToOreDictionary() {

		OreDictionary.registerOre("oreSoronite", new ItemStack(magicPowderOres, 1, 0));
		OreDictionary.registerOre("oreTardite", new ItemStack(magicPowderOres, 1, 1));
		OreDictionary.registerOre("oreKoronin", new ItemStack(magicPowderOres, 1, 2));

	}

	private static void addRecipe() {

		ItemStack soroniteBlock = new ItemStack(storageBlocks, 1, 0);
		ItemStack tarditeBlock = new ItemStack(storageBlocks, 1, 1);
		ItemStack koroninBlock = new ItemStack(storageBlocks, 1, 2);

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.magicIngot, 9, 0), soroniteBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.magicIngot, 9, 1), tarditeBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.magicIngot, 9, 2), koroninBlock);

		GameRegistry.addRecipe(new ItemStack(storageBlocks, 1, 0), new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(storageBlocks, 1, 1), new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(storageBlocks, 1, 2), new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(ModItems.magicIngot, 1, 2) });
		
		GameRegistry.addRecipe(new ItemStack(duplicator), new Object[] { "GRG", "BDB", "BFB", Character.valueOf('G'), Item.ingotGold, Character.valueOf('R'), new ItemStack(Block.cloth, 1, 10), Character.valueOf('B'), Block.netherBrick, Character.valueOf('D'), ModItems.duplicatorGem, Character.valueOf('F'), Block.furnaceIdle });
		GameRegistry.addRecipe(new ItemStack(fuser), new Object[] { "IGI", "BDB", "BFB", Character.valueOf('I'), Item.ingotGold, Character.valueOf('G'), new ItemStack(Block.cloth, 1, 5), Character.valueOf('B'), Block.brick, Character.valueOf('D'), Item.diamond, Character.valueOf('F'), Block.furnaceIdle });
		
	}

}
