package net.blazecoding.magicpowders.block;

import java.util.Random;

import net.blazecoding.magicpowders.MagicPowders;
import net.blazecoding.magicpowders.lib.GuiIDs;
import net.blazecoding.magicpowders.lib.References;
import net.blazecoding.magicpowders.lib.RenderIDs;
import net.blazecoding.magicpowders.lib.Strings;
import net.blazecoding.magicpowders.tileentity.TileEntityAlloyHeater;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * Magic Powders
 * 
 * BlockAlloyHeater
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockAlloyHeater extends BlockContainer {

	private static final String[] NAMES = { "Idle", "Active", "Side", "Top" };

	private Random alloyHeaterRandom = new Random();

	private final boolean isActive;
	private static boolean keepHeaterInventory = false;

	@SideOnly(Side.CLIENT)
	private Icon heaterTop;
	@SideOnly(Side.CLIENT)
	private Icon heaterFront;

	public BlockAlloyHeater(int id, boolean active) {
		super(id, Material.iron);
		this.isActive = active;
		setUnlocalizedName(Strings.ALLOYHEATER_ACTIVE_NAME);

		if (!isActive) {
			setCreativeTab(MagicPowders.tabMP);
			setUnlocalizedName(Strings.ALLOYHEATER_IDLE_NAME);
		}

	}

	public int getRenderType() {
		return RenderIDs.alloyHeaterRenderID;
	}

	public int idDropped(int id, Random random, int meta) {
		return ModBlocks.alloyHeaterIdle.blockID;
	}

	public void onBlockAdded(World world, int x, int y, int z) {

		super.onBlockAdded(world, x, y, z);
		setDefaultDirection(world, x, y, z);

	}

	private void setDefaultDirection(World world, int x, int y, int z) {

		if (!world.isRemote) {

			int i = world.getBlockId(x, y, z - 1);
			int j = world.getBlockId(x, y, z + 1);
			int i2 = world.getBlockId(x - 1, y, z);
			int j2 = world.getBlockId(x + 1, y, z);

			byte b0 = 3;

			if (Block.opaqueCubeLookup[i] && !Block.opaqueCubeLookup[j]) {
				b0 = 3;
			}

			if (Block.opaqueCubeLookup[j] && !Block.opaqueCubeLookup[i]) {
				b0 = 2;
			}

			if (Block.opaqueCubeLookup[i2] && !Block.opaqueCubeLookup[j2]) {
				b0 = 5;
			}

			if (Block.opaqueCubeLookup[j2] && !Block.opaqueCubeLookup[i2]) {
				b0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);

		}

	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return side == 1 ? heaterTop : (side == 0 ? heaterTop : (side != meta ? blockIcon : heaterFront));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		blockIcon = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + Strings.ALLOYHEATER_IDLE_NAME + NAMES[2]);
		heaterFront = iconRegister.registerIcon(isActive ? References.MOD_ID.toLowerCase() + ":" + Strings.ALLOYHEATER_IDLE_NAME + NAMES[1] : References.MOD_ID.toLowerCase() + ":" + Strings.ALLOYHEATER_ACTIVE_NAME + NAMES[0]);
		heaterTop = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + Strings.ALLOYHEATER_IDLE_NAME + NAMES[3]);

	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {

		if (this.isActive) {

			int var6 = world.getBlockMetadata(x, y, z);

			float var7 = (float) x + 0.5F;
			float var8 = (float) y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
			float var9 = (float) z + 0.5F;
			float var10 = 0.52F;
			float var11 = random.nextFloat() * 0.6F - 0.3F;

			if (var6 == 4) {

				world.spawnParticle("smoke", (double) (var7 - var10), (double) var8, (double) (var9 + var11), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double) (var7 - var10), (double) var8, (double) (var9 + var11), 0.0D, 0.0D, 0.0D);

			} else if (var6 == 5) {

				world.spawnParticle("smoke", (double) (var7 + var10), (double) var8, (double) (var9 + var11), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double) (var7 + var10), (double) var8, (double) (var9 + var11), 0.0D, 0.0D, 0.0D);

			} else if (var6 == 2) {

				world.spawnParticle("smoke", (double) (var7 + var11), (double) var8, (double) (var9 - var10), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double) (var7 + var11), (double) var8, (double) (var9 - var10), 0.0D, 0.0D, 0.0D);

			} else if (var6 == 3) {

				world.spawnParticle("smoke", (double) (var7 + var11), (double) var8, (double) (var9 - var10), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double) (var7 + var11), (double) var8, (double) (var9 - var10), 0.0D, 0.0D, 0.0D);

			}

		}

	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer thePlayer, int par6, float par7, float par8, float par9) {

		if (world.isRemote) {
			return true;
		} else if (!thePlayer.isSneaking()) {

			TileEntityAlloyHeater var10 = (TileEntityAlloyHeater) world.getBlockTileEntity(x, y, z);

			if (var10 != null) {
				thePlayer.openGui(MagicPowders.instance, GuiIDs.ALLOYHEATER, world, x, y, z);
			}

			return true;

		} else {
			return false;
		}

	}

	public static void updateFurnaceBlockState(boolean active, World world, int x, int y, int z) {

		int var5 = world.getBlockMetadata(x, y, z);

		TileEntity var6 = world.getBlockTileEntity(x, y, z);

		keepHeaterInventory = true;

		if (active) {

			world.setBlock(x, y, z, ModBlocks.alloyHeaterActive.blockID);

		} else {

			world.setBlock(x, y, z, ModBlocks.alloyHeaterIdle.blockID);
		}

		keepHeaterInventory = false;
		world.setBlockMetadataWithNotify(x, y, z, var5, 2);

		if (var6 != null) {

			var6.validate();
			world.setBlockTileEntity(x, y, z, var6);

		}

	}

	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAlloyHeater();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {

		int i = MathHelper.floor_double((double) (entityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (i == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (i == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (i == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (i == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if (itemStack.hasDisplayName()) {
			((TileEntityAlloyHeater) world.getBlockTileEntity(x, y, z)).setGuiDisplayName((itemStack.getDisplayName()));
		}

	}

	public void breakBlock(World world, int par2, int par3, int par4, int par5, int par6) {

		if (!keepHeaterInventory) {

			TileEntityAlloyHeater var7 = (TileEntityAlloyHeater) world.getBlockTileEntity(par2, par3, par4);

			if (var7 != null) {

				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8) {

					ItemStack itemstack = var7.getStackInSlot(var8);

					if (itemstack != null) {

						float f = alloyHeaterRandom.nextFloat() * 0.8F + 0.1F;
						float f1 = alloyHeaterRandom.nextFloat() * 0.8F + 0.1F;
						float f2 = alloyHeaterRandom.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0) {

							int k1 = alloyHeaterRandom.nextInt(21) + 10;

							if (k1 > itemstack.stackSize) {
								k1 = itemstack.stackSize;
							}

							itemstack.stackSize -= k1;

							EntityItem entityItem = new EntityItem(world, (double) ((float) par2 + f), (double) ((float) par3 + f1), (double) ((float) par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}

							float f3 = 0.05F;

							entityItem.motionX = (double) ((float) alloyHeaterRandom.nextGaussian() * f3);
							entityItem.motionY = (double) ((float) alloyHeaterRandom.nextGaussian() * f3 + 0.2F);
							entityItem.motionZ = (double) ((float) alloyHeaterRandom.nextGaussian() * f3);

							world.spawnEntityInWorld(entityItem);

						}

					}

				}
				world.func_96440_m(par2, par3, par4, par5);
			}

		}
		super.breakBlock(world, par2, par3, par4, par5, par6);
	}

	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5) {
		return Container.calcRedstoneFromInventory((IInventory) par1World.getBlockTileEntity(par2, par3, par4));
	}

}
