package com.xetosphere.arcane.configuration;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.xetosphere.arcane.lib.BlockIDs;
import com.xetosphere.arcane.lib.ItemIDs;
import com.xetosphere.arcane.lib.ModConfigurations;
import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.lib.Strings;

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
			ItemIDs.SORONITEHELMET = config.getItem(Configuration.CATEGORY_ITEM, Strings.SORONITEHELMET_NAME, ItemIDs.SORONITEHELMET_DEFAULT).getInt(ItemIDs.SORONITEHELMET_DEFAULT);
			ItemIDs.SORONITECHEST = config.getItem(Configuration.CATEGORY_ITEM, Strings.SORONITECHEST_NAME, ItemIDs.SORONITECHEST_DEFAULT).getInt(ItemIDs.SORONITECHEST_DEFAULT);
			ItemIDs.SORONITELEGS = config.getItem(Configuration.CATEGORY_ITEM, Strings.SORONITELEGS_NAME, ItemIDs.SORONITELEGS_DEFAULT).getInt(ItemIDs.SORONITELEGS_DEFAULT);
			ItemIDs.SORONITEBOOTS = config.getItem(Configuration.CATEGORY_ITEM, Strings.SORONITEBOOTS_NAME, ItemIDs.SORONITEBOOTS_DEFAULT).getInt(ItemIDs.SORONITEBOOTS_DEFAULT);
			ItemIDs.TARDITEHELMET = config.getItem(Configuration.CATEGORY_ITEM, Strings.TARDITEHELMET_NAME, ItemIDs.TARDITEHELMET_DEFAULT).getInt(ItemIDs.TARDITEHELMET_DEFAULT);
			ItemIDs.TARDITECHEST = config.getItem(Configuration.CATEGORY_ITEM, Strings.TARDITECHEST_NAME, ItemIDs.TARDITECHEST_DEFAULT).getInt(ItemIDs.TARDITECHEST_DEFAULT);
			ItemIDs.TARDITELEGS = config.getItem(Configuration.CATEGORY_ITEM, Strings.TARDITELEGS_NAME, ItemIDs.TARDITELEGS_DEFAULT).getInt(ItemIDs.TARDITELEGS_DEFAULT);
			ItemIDs.TARDITEBOOTS = config.getItem(Configuration.CATEGORY_ITEM, Strings.TARDITEBOOTS_NAME, ItemIDs.TARDITEBOOTS_DEFAULT).getInt(ItemIDs.TARDITEBOOTS_DEFAULT);
			ItemIDs.KORONINHELMET = config.getItem(Configuration.CATEGORY_ITEM, Strings.KORONINHELMET_NAME, ItemIDs.KORONINHELMET_DEFAULT).getInt(ItemIDs.KORONINHELMET_DEFAULT);
			ItemIDs.KORONINCHEST = config.getItem(Configuration.CATEGORY_ITEM, Strings.KORONINCHEST_NAME, ItemIDs.KORONINCHEST_DEFAULT).getInt(ItemIDs.KORONINCHEST_DEFAULT);
			ItemIDs.KORONINLEGS = config.getItem(Configuration.CATEGORY_ITEM, Strings.KORONINLEGS_NAME, ItemIDs.KORONINLEGS_DEFAULT).getInt(ItemIDs.KORONINLEGS_DEFAULT);
			ItemIDs.KORONINBOOTS = config.getItem(Configuration.CATEGORY_ITEM, Strings.KORONINBOOTS_NAME, ItemIDs.KORONINBOOTS_DEFAULT).getInt(ItemIDs.KORONINBOOTS_DEFAULT);
			ItemIDs.SORONITEPAXEL = config.getItem(Configuration.CATEGORY_ITEM, Strings.SORONITEPAXEL_NAME, ItemIDs.SORONITEPAXEL_DEFAULT).getInt(ItemIDs.SORONITEPAXEL_DEFAULT);
			ItemIDs.TARDITEPAXEL = config.getItem(Configuration.CATEGORY_ITEM, Strings.TARDITEPAXEL_NAME, ItemIDs.TARDITEPAXEL_DEFAULT).getInt(ItemIDs.TARDITEPAXEL_DEFAULT);
			ItemIDs.KORONINPAXEL = config.getItem(Configuration.CATEGORY_ITEM, Strings.KORONINPAXEL_NAME, ItemIDs.KORONINPAXEL_DEFAULT).getInt(ItemIDs.KORONINPAXEL_DEFAULT);

			// Misc
			ModConfigurations.enableCustomGeneration = config.get(Configuration.CATEGORY_GENERAL, Strings.ENABLE_CUSTOM_GEN, ModConfigurations.DEFAULT_GENERATION).getBoolean(ModConfigurations.DEFAULT_GENERATION);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + " had a problem loading its configuration file.");
		} finally {
			config.save();
		}

	}

}
