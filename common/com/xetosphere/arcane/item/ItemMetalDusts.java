package com.xetosphere.arcane.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMetalDusts extends ItemARC {

	private static final String[] DUST_NAMES = new String[] { "Coal", "Iron", "Gold" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemMetalDusts(int id) {

		super(id);
		setCreativeTab(CreativeTabs.tabMaterials);
		setHasSubtypes(true);
		maxStackSize = 64;
	}

	public String getUnlocalizedName(ItemStack itemStack) {

		StringBuilder unlocalizedName = new StringBuilder();
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, DUST_NAMES.length);

		unlocalizedName.append("item.");
		unlocalizedName.append(Strings.RESOURCE_PREFIX);
		unlocalizedName.append(Strings.METAL_DUST_NAME);
		unlocalizedName.append(DUST_NAMES[meta]);

		return unlocalizedName.toString();
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {

		int j = MathHelper.clamp_int(meta, 0, DUST_NAMES.length);
		return icons[j];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[DUST_NAMES.length];

		for (int i = 0; i < DUST_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.METAL_DUST_NAME + DUST_NAMES[i]);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs creativeTab, List list) {

		for (int meta = 0; meta < DUST_NAMES.length; ++meta) {
			list.add(new ItemStack(id, 1, meta));
		}
	}

}
