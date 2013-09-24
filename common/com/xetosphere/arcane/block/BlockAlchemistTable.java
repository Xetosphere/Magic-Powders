package com.xetosphere.arcane.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.xetosphere.arcane.ArchaniCommutatio;
import com.xetosphere.arcane.lib.GuiIDs;
import com.xetosphere.arcane.lib.RenderIDs;
import com.xetosphere.arcane.lib.Strings;
import com.xetosphere.arcane.tileentity.TileAlchemistTable;

public class BlockAlchemistTable extends BlockARC {

	public BlockAlchemistTable(int i) {
		super(i, Material.ground);
		setCreativeTab(ArchaniCommutatio.tabARC);
		setUnlocalizedName(Strings.ALCHEMISTTABLE_NAME);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9F, 1.0F);
		setHardness(1.5F);
		setResistance(12.0F);
	}

	@Override
	public String getUnlocalizedName() {

		StringBuilder unlocalizedName = new StringBuilder();

		unlocalizedName.append("tile.");
		unlocalizedName.append(Strings.RESOURCE_PREFIX);
		unlocalizedName.append(Strings.ALCHEMISTTABLE_NAME);

		return unlocalizedName.toString();
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getRenderType() {
		return RenderIDs.alchemistTableRender;
	}

	public TileEntity createNewTileEntity(World world) {
		return new TileAlchemistTable();
	}

	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {

		if (!player.isSneaking()) {

			player.openGui(ArchaniCommutatio.instance, GuiIDs.ALCHEMISTTABLE, var1, var2, var3, var4);
			return true;

		} else {

			return false;

		}
	}

}