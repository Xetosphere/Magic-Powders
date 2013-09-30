package com.xetosphere.arcane.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.xetosphere.arcane.ArchaniCommutatio;
import com.xetosphere.arcane.lib.GuiIDs;
import com.xetosphere.arcane.lib.Reference;
import com.xetosphere.arcane.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRecipePapers extends ItemARC {

	private static final String[] PAPER_NAMES = new String[] { "AlchemistTable", "ArcaneGem", "Duplicator", "ArcaneFuser", "AuraCrusher" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemRecipePapers(int id) {

		super(id);
		setCreativeTab(ArchaniCommutatio.tabARC);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemStack) {

		StringBuilder unlocalizedName = new StringBuilder();
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, PAPER_NAMES.length);

		unlocalizedName.append("item.");
		unlocalizedName.append(Strings.RESOURCE_PREFIX);
		unlocalizedName.append(Strings.RECIPE_PAPER_NAME);
		unlocalizedName.append(PAPER_NAMES[meta]);

		return unlocalizedName.toString();
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {

		int j = MathHelper.clamp_int(meta, 0, PAPER_NAMES.length);
		return icons[j];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[PAPER_NAMES.length];

		for (int i = 0; i < PAPER_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.RECIPE_PAPER_NAME + PAPER_NAMES[i]);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs creativeTab, List list) {

		for (int meta = 0; meta < PAPER_NAMES.length; ++meta) {
			list.add(new ItemStack(id, 1, meta));
		}
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

		player.openGui(ArchaniCommutatio.instance, GuiIDs.RECIPE_PAPER, world, 0, 0, 0);

		return stack;
	}

}
