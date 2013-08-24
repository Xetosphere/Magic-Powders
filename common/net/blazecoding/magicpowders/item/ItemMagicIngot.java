package net.blazecoding.magicpowders.item;

import java.util.List;

import net.blazecoding.magicpowders.MagicPowders;
import net.blazecoding.magicpowders.lib.References;
import net.blazecoding.magicpowders.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * Magic Powders
 * 
 * ItemMagicIngot
 * 
 * @author BlazeCoding
 * @license Lesser Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemMagicIngot extends ItemMP {

	private static final String[] MAGIC_INGOT_NAMES = new String[] { "SoroniteIngot", "TarditeIngot", "KoroninIngot" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemMagicIngot(int id) {
		super(id);
		setUnlocalizedName(Strings.MAGICINGOT_NAME);
		setCreativeTab(MagicPowders.tabMP);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemStack) {

		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, MAGIC_INGOT_NAMES.length);
		return super.getUnlocalizedName() + MAGIC_INGOT_NAMES[meta];

	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {

		int j = MathHelper.clamp_int(meta, 0, MAGIC_INGOT_NAMES.length);
		return icons[j];

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[MAGIC_INGOT_NAMES.length];

		for (int i = 0; i < MAGIC_INGOT_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(References.MOD_ID.toLowerCase() + ":" + Strings.MAGICINGOT_NAME + MAGIC_INGOT_NAMES[i]);
		}

	}

	public String getItemDisplayName(ItemStack itemStack) {

		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, MAGIC_INGOT_NAMES.length);

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

		for (int meta = 0; meta < MAGIC_INGOT_NAMES.length; ++meta) {
			list.add(new ItemStack(id, 1, meta));
		}

	}

}
