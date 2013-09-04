package com.xetosphere.arcane.configuration;

import java.io.File;
import java.util.logging.Level;

import com.xetosphere.arcane.lib.BlockIDs;
import com.xetosphere.arcane.lib.ItemIDs;
import com.xetosphere.arcane.lib.ModConfigurations;
import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.lib.Strings;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class ConfigurationHandler {

	public static Configuration config;

	public static void init(File configFile) {

		config = new Configuration(configFile);

		try {

			config.load();

			// Blocks
			BlockIDs.MAGIC_ORES = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.POWDERORES_NAME, BlockIDs.POWDERORES_DEFAULT).getInt(BlockIDs.POWDERORES_DEFAULT);
			BlockIDs.STORAGE_BLOCKS = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.STORAGEBLOCKS_NAME, BlockIDs.STORAGEBLOCKS_DEFAULT).getInt(BlockIDs.STORAGEBLOCKS_DEFAULT);
			BlockIDs.ARCANE_FUSER = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.ARCANE_FUSER_NAME, BlockIDs.ARCANE_FUSER_DEFAULT).getInt(BlockIDs.ARCANE_FUSER_DEFAULT);
			BlockIDs.DUPLICATOR = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.DUPLICATOR_NAME, BlockIDs.DUPLICATOR_DEFAULT).getInt(BlockIDs.DUPLICATOR_DEFAULT);
			BlockIDs.ALCHEMISTTABLE = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.ALCHEMISTTABLE_NAME, BlockIDs.ALCHEMISTTABLE_DEFAULT).getInt(BlockIDs.ALCHEMISTTABLE_DEFAULT);

			// Items
			ItemIDs.MAGICDUSTS = config.getItem(Configuration.CATEGORY_ITEM, Strings.MAGICDUST_NAME, ItemIDs.MAGICDUSTS_DEFAULT).getInt(ItemIDs.MAGICDUSTS_DEFAULT);
			ItemIDs.MAGICINGOTS = config.getItem(Configuration.CATEGORY_ITEM, Strings.MAGICINGOT_NAME, ItemIDs.MAGICINGOTS_DEFAULT).getInt(ItemIDs.MAGICINGOTS_DEFAULT);
			ItemIDs.ARCANE_GEM = config.getItem(Configuration.CATEGORY_ITEM, Strings.ARCANE_GEM_NAME, ItemIDs.ARCANE_GEM_DEFAULT).getInt(ItemIDs.ARCANE_GEM_DEFAULT);

			// Misc
			ModConfigurations.enableCustomGeneration = config.get(Configuration.CATEGORY_GENERAL, Strings.ENABLE_CUSTOM_GEN, ModConfigurations.DEFAULT_GENERATION).getBoolean(ModConfigurations.DEFAULT_GENERATION);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + " had a problem loading its configuration file.");
		} finally {
			config.save();
		}

	}

}
