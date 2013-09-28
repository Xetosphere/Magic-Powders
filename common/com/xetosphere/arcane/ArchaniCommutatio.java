package com.xetosphere.arcane;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.xetosphere.arcane.block.ModBlocks;
import com.xetosphere.arcane.configuration.ConfigurationHandler;
import com.xetosphere.arcane.core.proxy.CommonProxy;
import com.xetosphere.arcane.core.util.LogHelper;
import com.xetosphere.arcane.creativetab.TabARC;
import com.xetosphere.arcane.item.ModItems;
import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.network.PacketHandler;
import com.xetosphere.arcane.world.gen.WorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class ArchaniCommutatio {

	@Instance(Reference.MOD_ID)
	public static ArchaniCommutatio instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	// Adds the Magic Powder tab in the creative tabs.
	public static final CreativeTabs tabARC = new TabARC(CreativeTabs.getNextID(), Reference.MOD_ID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {

		// Initialize the log helper
		LogHelper.init();

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

		// Initialize custom rendering and pre-load textures (Client only)
		proxy.initRenderingAndTextures();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

}
