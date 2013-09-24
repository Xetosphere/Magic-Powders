package com.xetosphere.arcane.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.xetosphere.arcane.ArchaniCommutatio;
import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagicDust extends ItemARC {

	private static final String[] MAGIC_DUST_NAMES = new String[] { "Soronite", "Tardite", "Koronin" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemMagicDust(int id) {
		super(id);
		setCreativeTab(ArchaniCommutatio.tabARC);
		setHasSubtypes(true);
		maxStackSize = 64;
	}

	public String getUnlocalizedName(ItemStack itemStack) {

		StringBuilder unlocalizedName = new StringBuilder();
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, MAGIC_DUST_NAMES.length);

		unlocalizedName.append("item.");
		unlocalizedName.append(Strings.RESOURCE_PREFIX);
		unlocalizedName.append(Strings.MAGICDUST_NAME);
		unlocalizedName.append(MAGIC_DUST_NAMES[meta]);

		return unlocalizedName.toString();

	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {

		int j = MathHelper.clamp_int(meta, 0, MAGIC_DUST_NAMES.length);
		return icons[j];

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[MAGIC_DUST_NAMES.length];

		for (int i = 0; i < MAGIC_DUST_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.MAGICDUST_NAME + MAGIC_DUST_NAMES[i]);
		}

	}

	public String getItemDisplayName(ItemStack itemStack) {

		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, MAGIC_DUST_NAMES.length);

		switch (meta) {
		case 0:
			return EnumChatFormatting.BLUE + super.getItemDisplayName(itemStack);
		case 1:
			return EnumChatFormatting.YELLOW + super.getItemDisplayName(itemStack);
		case 2:
			return EnumChatFormatting.AQUA + super.getItemDisplayName(itemStack);
		default:
			return EnumChatFormatting.WHITE + super.getItemDisplayName(itemStack);

		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs creativeTab, List list) {

		for (int meta = 0; meta < MAGIC_DUST_NAMES.length; ++meta) {
			list.add(new ItemStack(id, 1, meta));
		}

	}

}
