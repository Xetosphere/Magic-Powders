package net.blazecoding.magicpowders.core.proxy;

import net.blazecoding.magicpowders.tileentity.TileMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.FMLClientHandler;

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

	public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

		TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);

		if (tileEntity != null) {
			if (tileEntity instanceof TileMP) {
				((TileMP) tileEntity).setOrientation(orientation);
				((TileMP) tileEntity).setState(state);
				((TileMP) tileEntity).setCustomName(customName);
			}
		}

	}

	public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {
		this.handleTileEntityPacket(x, y, z, orientation, state, customName);
	}

}
