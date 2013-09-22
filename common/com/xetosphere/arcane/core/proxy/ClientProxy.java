package com.xetosphere.arcane.core.proxy;

import com.xetosphere.arcane.tileentity.TileARC;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {

	public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

		TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);

		if (tileEntity != null) {
			if (tileEntity instanceof TileARC) {
				((TileARC) tileEntity).setOrientation(orientation);
				((TileARC) tileEntity).setState(state);
				((TileARC) tileEntity).setCustomName(customName);
			}
		}

	}

	public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {
		this.handleTileEntityPacket(x, y, z, orientation, state, customName);
	}

}
