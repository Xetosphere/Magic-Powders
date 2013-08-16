package net.blazecoding.magicpowders.world.gen;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Magic Powders
 * 
 * WorldGen
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class WorldGen {

	private static EventManager eventManager = new EventManager();

	public static void init() {
		GameRegistry.registerWorldGenerator(eventManager);
	}

}
