package com.xetosphere.arcane.world.gen;

import com.xetosphere.arcane.lib.ModConfigurations;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {

	private static OreGeneration oreGenerator = new OreGeneration();
	private static StructureGeneration structureGenerator = new StructureGeneration();

	public static void init() {

		GameRegistry.registerWorldGenerator(oreGenerator);

		if (ModConfigurations.enableCustomGeneration) {
			GameRegistry.registerWorldGenerator(structureGenerator);
		}
	}

}
