package com.xetosphere.arcane.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.xetosphere.arcane.block.ModBlocks;
import com.xetosphere.arcane.client.gui.inventory.GuiAlchemistTable;
import com.xetosphere.arcane.client.gui.inventory.GuiArcaneFuser;
import com.xetosphere.arcane.client.gui.inventory.GuiDuplicator;
import com.xetosphere.arcane.inventory.ContainerAlchemistTable;
import com.xetosphere.arcane.inventory.ContainerArcaneFuser;
import com.xetosphere.arcane.inventory.ContainerDuplicator;
import com.xetosphere.arcane.lib.GuiIDs;
import com.xetosphere.arcane.lib.Strings;
import com.xetosphere.arcane.tileentity.TileAlchemistTable;
import com.xetosphere.arcane.tileentity.TileArcaneFuser;
import com.xetosphere.arcane.tileentity.TileDuplicator;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

	public void initRenderingAndTextures() {

	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileArcaneFuser.class, Strings.ARCANE_FUSER_NAME);
		GameRegistry.registerTileEntity(TileDuplicator.class, Strings.DUPLICATOR_NAME);
		GameRegistry.registerTileEntity(TileAlchemistTable.class, Strings.ALCHEMISTTABLE_NAME);
	}

	public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

	}

	public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

	}

	public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

	}

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == GuiIDs.ARCANE_FUSER) {

			TileArcaneFuser tileFuser = (TileArcaneFuser) world.getBlockTileEntity(x, y, z);
			return new ContainerArcaneFuser(player.inventory, tileFuser);

		}

		else if (ID == GuiIDs.DUPLICATOR) {

			TileDuplicator tileDuplicator = (TileDuplicator) world.getBlockTileEntity(x, y, z);
			return new ContainerDuplicator(player.inventory, tileDuplicator);

		}

		else if (ID == GuiIDs.ALCHEMISTTABLE) {
			return ID == GuiIDs.ALCHEMISTTABLE && world.getBlockId(x, y, z) == ModBlocks.alchemistTable.blockID ? new ContainerAlchemistTable(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == GuiIDs.ARCANE_FUSER) {

			TileArcaneFuser tileFuser = (TileArcaneFuser) world.getBlockTileEntity(x, y, z);
			return new GuiArcaneFuser(player.inventory, tileFuser);

		}

		else if (ID == GuiIDs.DUPLICATOR) {

			TileDuplicator tileDuplicator = (TileDuplicator) world.getBlockTileEntity(x, y, z);
			return new GuiDuplicator(player.inventory, tileDuplicator);

		}

		else if (ID == GuiIDs.ALCHEMISTTABLE) {
			return ID == GuiIDs.ALCHEMISTTABLE && world.getBlockId(x, y, z) == ModBlocks.alchemistTable.blockID ? new GuiAlchemistTable(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

}
