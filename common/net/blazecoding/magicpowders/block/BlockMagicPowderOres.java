package net.blazecoding.magicpowders.block;

import java.util.List;
import java.util.Random;

import net.blazecoding.magicpowders.MagicPowders;
import net.blazecoding.magicpowders.item.ModItems;
import net.blazecoding.magicpowders.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * Magic Powders
 * 
 * BlockMagicPowderOres
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BlockMagicPowderOres extends Block {

	public static final String[] POWDERORE_NAMES = { "SoroniteOre", "TarditeOre", "KoroninOre" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public BlockMagicPowderOres(int id) {
		super(id, Material.rock);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.POWDERORES_NAME);
		setCreativeTab(MagicPowders.tabMP);
		setHardness(3.0F);
		setResistance(8.0F);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[POWDERORE_NAMES.length];

		for (int i = 0; i < POWDERORE_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(Strings.RESOURCE_PREFIX + Strings.POWDERORES_NAME + POWDERORE_NAMES[i]);
		}

	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int id, int meta) {
		return icons[meta];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {

		for (int var4 = 0; var4 < 3; ++var4) {
			par3List.add(new ItemStack(par1, 1, var4));
		}

	}

	public int idDropped(int id, Random random, int meta) {
		return ModItems.magicDust.itemID;
	}

	public int damageDropped(int meta) {
		return meta == 0 ? 0 : (meta == 1 ? 1 : (meta == 2 ? 2 : 0));
	}

}
