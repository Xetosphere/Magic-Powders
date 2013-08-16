package net.blazecoding.magicpowders.world.gen;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {

	private static EventManager eventManager = new EventManager();

	public static void init() {
		GameRegistry.registerWorldGenerator(eventManager);
	}

}
