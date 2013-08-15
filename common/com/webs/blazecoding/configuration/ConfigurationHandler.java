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
			
			ItemIDs.magicDustID = config.getItem(Configuration.CATEGORY_ITEM, Strings.MAGICDUST_NAME, ItemIDs.MAGICDUST_ID_DEFAULT).getInt(ItemIDs.MAGICDUST_ID_DEFAULT);
			
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, References.MOD_ID + " had a problem loading its configuration file.");
		} finally {
			config.save();
		}
		
	}

}
