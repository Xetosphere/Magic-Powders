package com.xetosphere.arcane.block;

import java.util.List;

import com.xetosphere.arcane.ArcaneEphilesophy;
import com.xetosphere.arcane.lib.Strings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStorageBlocks extends Block {

	public static final String[] BLOCK_NAMES = { "SoroniteBlock", "TarditeBlock", "KoroninBlock" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public BlockStorageBlocks(int id) {
		super(id, Material.rock);
		setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.STORAGEBLOCKS_NAME);
		setCreativeTab(ArcaneEphilesophy.tabAEX);
		setHardness(3.0F);
		setResistance(12.0F);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[BLOCK_NAMES.length];

		for (int i = 0; i < BLOCK_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(Strings.RESOURCE_PREFIX + Strings.STORAGEBLOCKS_NAME + BLOCK_NAMES[i]);
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

	public int damageDropped(int meta) {
		return meta == 0 ? 0 : (meta == 1 ? 1 : (meta == 2 ? 2 : 0));
	}

}
