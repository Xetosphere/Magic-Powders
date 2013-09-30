package com.xetosphere.arcane.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.xetosphere.arcane.ArchaniCommutatio;
import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRuneSymbols extends ItemARC {

	private static final String[] RUNE_NAMES = new String[] { "BlackRune", "RedRune", "GreenRune", "BrownRune", "BlueRune", "PurpleRune", "YellowRune", "OrangeRune", "WhiteRune" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemRuneSymbols(int id) {

		super(id);
		setCreativeTab(ArchaniCommutatio.tabARC);
		setHasSubtypes(true);
		maxStackSize = 64;
	}

	public String getUnlocalizedName(ItemStack itemStack) {

		StringBuilder unlocalizedName = new StringBuilder();
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, RUNE_NAMES.length);

		unlocalizedName.append("item.");
		unlocalizedName.append(Strings.RESOURCE_PREFIX);
		unlocalizedName.append(Strings.RUNE_SYMBOLS_NAME);
		unlocalizedName.append(RUNE_NAMES[meta]);

		return unlocalizedName.toString();
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {

		int j = MathHelper.clamp_int(meta, 0, RUNE_NAMES.length);
		return icons[j];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[RUNE_NAMES.length];

		for (int i = 0; i < RUNE_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.RUNE_SYMBOLS_NAME + RUNE_NAMES[i]);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs creativeTab, List list) {

		for (int meta = 0; meta < RUNE_NAMES.length; ++meta) {
			list.add(new ItemStack(id, 1, meta));
		}
	}

}
