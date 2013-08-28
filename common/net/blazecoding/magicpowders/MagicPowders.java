package net.blazecoding.magicpowders;

import java.io.File;

import net.blazecoding.magicpowders.block.ModBlocks;
import net.blazecoding.magicpowders.configuration.ConfigurationHandler;
import net.blazecoding.magicpowders.core.handlers.LocalizationHandler;
import net.blazecoding.magicpowders.core.proxy.CommonProxy;
import net.blazecoding.magicpowders.creativetab.TabMP;
import net.blazecoding.magicpowders.item.ModItems;
import net.blazecoding.magicpowders.lib.Reference;
import net.blazecoding.magicpowders.network.PacketHandler;
import net.blazecoding.magicpowders.world.gen.WorldGen;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * 
 * Magic Powders
 * 
 * MagicPowders
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class MagicPowders {

	@Instance(Reference.CHANNEL_NAME)
	public static MagicPowders instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	// Adds the Magic Powder tab in the creative tabs.
	public static final CreativeTabs tabMP = new TabMP(CreativeTabs.getNextID(), Reference.MOD_ID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {

		// Gives the right language file for each language as well as giving the blocks, items, creative tabs etc. it's real name.
		LocalizationHandler.loadLanguages();

		// Adds the config, that can change block and item ids as well as making the mob spawn in an already existing world.
		ConfigurationHandler.init(new File(e.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));

		// Adds the items that the mod contains. As well as item recipes.
		ModItems.init();

		// Adds the blocks that the mod contains. As well as block recipes and registering the blocks.
		ModBlocks.init();

		// Adds everything that has to do with generation.
		WorldGen.init();

	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

		// Register the GUI Handler
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		// Initialize mod tile entities
		proxy.registerTileEntities();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

}
