package net.blazecoding.magicpowders.core.proxy;

import net.blazecoding.magicpowders.lib.RenderIDs;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * 
 * Magic Powders
 * 
 * ClientProxy
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ClientProxy extends CommonProxy {

	public void initRenderingAndTextures() {
		RenderIDs.alloyHeaterRenderID = RenderingRegistry.getNextAvailableRenderId();
	}

}
