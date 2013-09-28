package com.xetosphere.arcane.core.proxy;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ForgeDirection;

import com.xetosphere.arcane.client.renderer.item.ItemAlchemistTableRenderer;
import com.xetosphere.arcane.client.renderer.tileentity.TileEntityAlchemistTableRenderer;
import com.xetosphere.arcane.lib.BlockIDs;
import com.xetosphere.arcane.lib.RenderIDs;
import com.xetosphere.arcane.tileentity.TileARC;
import com.xetosphere.arcane.tileentity.TileAlchemistTable;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public void initRenderingAndTextures() {

		RenderIDs.alchemistTableRender = RenderingRegistry.getNextAvailableRenderId();

		MinecraftForgeClient.registerItemRenderer(BlockIDs.ALCHEMISTTABLE, new ItemAlchemistTableRenderer());
	}

	public void registerTileEntities() {

		super.registerTileEntities();

		ClientRegistry.bindTileEntitySpecialRenderer(TileAlchemistTable.class, new TileEntityAlchemistTableRenderer());
	}

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
