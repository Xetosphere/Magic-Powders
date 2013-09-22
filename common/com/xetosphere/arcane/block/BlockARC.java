package com.xetosphere.arcane.block;

import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.tileentity.TileARC;

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

public abstract class BlockARC extends BlockContainer {

	public BlockARC(int id, Material material) {
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
			((TileARC) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
		}

		((TileARC) world.getBlockTileEntity(x, y, z)).setOrientation(direction);

	}

}
