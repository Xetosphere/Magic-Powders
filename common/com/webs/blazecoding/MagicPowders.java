package com.webs.blazecoding;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.webs.blazecoding.block.ModBlocks;
import com.webs.blazecoding.configuration.ConfigurationHandler;
import com.webs.blazecoding.core.handlers.LocalizationHandler;
import com.webs.blazecoding.core.proxy.CommonProxy;
import com.webs.blazecoding.creativetab.TabMP;
import com.webs.blazecoding.item.ModItems;
import com.webs.blazecoding.lib.References;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * 
 * Magic Powders
 * 
 * MagicPowders
 * 
 * @author BlazeCoding
 * @license Lesser Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.VERSION, dependencies = References.DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MagicPowders {

	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy proxy;

	// Adds the Magic Powder tab in the creative tabs.
	public static final CreativeTabs tabMP = new TabMP(CreativeTabs.getNextID(), References.MOD_ID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {

		// Gives the right language file for each language as well as giving the blocks, items, creative tabs etc. it's real name.
		LocalizationHandler.loadLanguages();

		// Adds the config, that can change block and item ids as well as making the mob spawn in an already existing world.
		ConfigurationHandler.init(new File(e.getModConfigurationDirectory().getAbsolutePath() + File.separator + References.CHANNEL_NAME + File.separator + References.MOD_ID + ".cfg"));

		// Adds the items that the mod contains. As well as item recipes.
		ModItems.init();

		// Adds the blocks that the mod contains. As well as block recipes and registering the blocks.
		ModBlocks.init();

	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

}
