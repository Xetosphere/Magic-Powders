package net.blazecoding.magicpowders.block;

import net.blazecoding.magicpowders.MagicPowders;
import net.blazecoding.magicpowders.lib.GuiIDs;
import net.blazecoding.magicpowders.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAlchemistTable extends Block {

	@SideOnly(Side.CLIENT)
	private Icon tableTop;
	@SideOnly(Side.CLIENT)
	private Icon tableFront;

	public BlockAlchemistTable(int i) {
		super(i, Material.ground);
		setCreativeTab(MagicPowders.tabMP);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.ALCHEMISTTABLE_NAME);
		setHardness(1F);
		setResistance(12F);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return par1 == 1 ? this.tableTop : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.tableFront));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Strings.RESOURCE_PREFIX + Strings.ALCHEMISTTABLE_NAME + "_side");
		this.tableTop = par1IconRegister.registerIcon(Strings.RESOURCE_PREFIX + Strings.ALCHEMISTTABLE_NAME + "_top");
		this.tableFront = par1IconRegister.registerIcon(Strings.RESOURCE_PREFIX + Strings.ALCHEMISTTABLE_NAME + "_front");
	}

	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {

		if (!player.isSneaking()) {

			player.openGui(MagicPowders.instance, GuiIDs.ALCHEMISTTABLE, var1, var2, var3, var4);
			return true;

		} else {

			return false;

		}
	}
}