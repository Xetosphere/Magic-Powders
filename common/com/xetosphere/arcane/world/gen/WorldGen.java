package com.xetosphere.arcane.world.gen;

import com.xetosphere.arcane.configuration.ConfigurationSettings;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {

	private static OreGeneration oreGenerator = new OreGeneration();
	private static StructureGeneration structureGenerator = new StructureGeneration();

	public static void init() {

		GameRegistry.registerWorldGenerator(oreGenerator);

		if (ConfigurationSettings.enableCustomGeneration) {
			GameRegistry.registerWorldGenerator(structureGenerator);
		}
	}

}
