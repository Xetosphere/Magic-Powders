package com.webs.blazecoding.configuration;

import java.io.File;
import java.util.logging.Level;

import com.webs.blazecoding.lib.ItemIDs;
import com.webs.blazecoding.lib.References;
import com.webs.blazecoding.lib.Strings;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

/**
 * 
 * Magic Powders
 * 
 * ConfigurationHandler
 * 
 * @author BlazeCoding
 * @license Lesser Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */

public class ConfigurationHandler {
	
	public static Configuration config;

	public static void init(File configFile) {
		
		config = new Configuration(configFile);
		
		try {
			
			config.load();
			
			ItemIDs.soroniteID = config.getItem(Configuration.CATEGORY_ITEM, Strings.SORONITE_NAME, ItemIDs.SORONITE_ID_DEFAULT).getInt(ItemIDs.SORONITE_ID_DEFAULT);
			ItemIDs.tarditeID = config.getItem(Configuration.CATEGORY_ITEM, Strings.TARDITE_NAME, ItemIDs.TARDITE_ID_DEFAULT).getInt(ItemIDs.TARDITE_ID_DEFAULT);
			ItemIDs.koroninID = config.getItem(Configuration.CATEGORY_ITEM, Strings.KORONIN_NAME, ItemIDs.KORONIN_ID_DEFAULT).getInt(ItemIDs.KORONIN_ID_DEFAULT);
			
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, References.MOD_ID + " had a problem loading its configuration file.");
		} finally {
			config.save();
		}
		
	}

}
