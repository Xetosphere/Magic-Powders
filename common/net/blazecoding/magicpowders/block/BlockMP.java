package net.blazecoding.magicpowders.block;

import net.blazecoding.magicpowders.lib.Reference;
import net.blazecoding.magicpowders.tileentity.TileMP;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * Magic Powders
 * 
 * BlockMP
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public abstract class BlockMP extends BlockContainer {

	public BlockMP(int id, Material material) {
		super(id, material);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(":") + 1);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {

		int direction = 0;
		int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

		if (facing == 0) {
			direction = ForgeDirection.NORTH.ordinal();
		}

		else if (facing == 1) {
			direction = ForgeDirection.EAST.ordinal();
		}

		else if (facing == 2) {
			direction = ForgeDirection.SOUTH.ordinal();
		}

		else if (facing == 3) {
			direction = ForgeDirection.WEST.ordinal();
		}

		world.setBlockMetadataWithNotify(x, y, z, direction, 3);

		if (itemStack.hasDisplayName()) {
			((TileMP) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
		}

		((TileMP) world.getBlockTileEntity(x, y, z)).setOrientation(direction);

	}

}
