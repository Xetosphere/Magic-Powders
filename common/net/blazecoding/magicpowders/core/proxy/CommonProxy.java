package net.blazecoding.magicpowders.core.proxy;

import net.blazecoding.magicpowders.client.gui.inventory.GuiFuser;
import net.blazecoding.magicpowders.inventory.ContainerFuser;
import net.blazecoding.magicpowders.lib.GuiIDs;
import net.blazecoding.magicpowders.lib.Strings;
import net.blazecoding.magicpowders.tileentity.TileFuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Magic Powders
 * 
 * CommonProxy
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class CommonProxy implements IGuiHandler {

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileFuser.class, Strings.FUSER_NAME);
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

		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == GuiIDs.FUSER) {

			TileFuser tileFuser = (TileFuser) world.getBlockTileEntity(x, y, z);
			return new GuiFuser(player.inventory, tileFuser);

		}

		return null;
	}

}
