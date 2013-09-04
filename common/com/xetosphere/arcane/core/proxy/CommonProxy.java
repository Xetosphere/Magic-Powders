package com.xetosphere.arcane.core.proxy;

import com.xetosphere.arcane.block.ModBlocks;
import com.xetosphere.arcane.client.gui.inventory.GuiAlchemistTable;
import com.xetosphere.arcane.client.gui.inventory.GuiDuplicator;
import com.xetosphere.arcane.client.gui.inventory.GuiFuser;
import com.xetosphere.arcane.inventory.ContainerAlchemistTable;
import com.xetosphere.arcane.inventory.ContainerDuplicator;
import com.xetosphere.arcane.inventory.ContainerFuser;
import com.xetosphere.arcane.lib.GuiIDs;
import com.xetosphere.arcane.lib.Strings;
import com.xetosphere.arcane.tileentity.TileDuplicator;
import com.xetosphere.arcane.tileentity.TileFuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileFuser.class, Strings.FUSER_NAME);
		GameRegistry.registerTileEntity(TileDuplicator.class, Strings.DUPLICATOR_NAME);
	}

	public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

	}

	public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

	}

	public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

	}

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == GuiIDs.FUSER) {

			TileFuser tileFuser = (TileFuser) world.getBlockTileEntity(x, y, z);
			return new ContainerFuser(player.inventory, tileFuser);

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

		if (ID == GuiIDs.FUSER) {

			TileFuser tileFuser = (TileFuser) world.getBlockTileEntity(x, y, z);
			return new GuiFuser(player.inventory, tileFuser);

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
