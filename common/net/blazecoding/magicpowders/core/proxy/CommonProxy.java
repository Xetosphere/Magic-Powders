package net.blazecoding.magicpowders.core.proxy;

import net.blazecoding.magicpowders.client.gui.inventory.GuiAlloyHeater;
import net.blazecoding.magicpowders.inventory.ContainerAlloyHeater;
import net.blazecoding.magicpowders.tileentity.TileEntityAlloyHeater;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

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

	public void initRenderingAndTextures() {

	}

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		switch (ID) {
			case 0:
				return new ContainerAlloyHeater(player.inventory, (TileEntityAlloyHeater) tileEntity);
		}

		return null;

	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		switch (ID) {
			case 0:
				return new GuiAlloyHeater(player.inventory, (TileEntityAlloyHeater) tileEntity);
		}

		return null;

	}

}
