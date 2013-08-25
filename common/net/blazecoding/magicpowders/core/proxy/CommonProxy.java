package net.blazecoding.magicpowders.core.proxy;

import net.blazecoding.magicpowders.client.gui.inventory.GuiMagicInfuser;
import net.blazecoding.magicpowders.inventory.ContainerMagicInfuser;
import net.blazecoding.magicpowders.tileentity.TileEntityMagicInfuser;
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

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity instanceof TileEntityMagicInfuser) {
			return new ContainerMagicInfuser(player.inventory, (TileEntityMagicInfuser) tile_entity);
		}

		return null;

	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (tile_entity instanceof TileEntityMagicInfuser) {
			return new GuiMagicInfuser(player.inventory, (TileEntityMagicInfuser) tile_entity);
		}

		return null;

	}

}
