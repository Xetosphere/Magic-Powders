package com.xetosphere.arcane.item;

import java.util.List;

import net.minecraft.client.Minecraft;
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
import com.xetosphere.arcane.stats.ModAchievements;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRecipeScrolls extends ItemARC {

	private static final String[] SCROLL_NAMES = new String[] { "AlchemistTable", "ArcaneGem", "Duplicator", "ArcaneFuser", "AuraCrusher", "Runes", "Paxel" };

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemRecipeScrolls(int id) {

		super(id);
		setCreativeTab(ArchaniCommutatio.tabARC);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemStack) {

		StringBuilder unlocalizedName = new StringBuilder();
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, SCROLL_NAMES.length);

		unlocalizedName.append("item.");
		unlocalizedName.append(Strings.RESOURCE_PREFIX);
		unlocalizedName.append(Strings.RECIPE_SCROLL_NAME);
		unlocalizedName.append(SCROLL_NAMES[meta]);

		return unlocalizedName.toString();
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {

		int j = MathHelper.clamp_int(meta, 0, SCROLL_NAMES.length);
		return icons[j];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		icons = new Icon[SCROLL_NAMES.length];

		for (int i = 0; i < SCROLL_NAMES.length; ++i) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.RECIPE_SCROLL_NAME);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs creativeTab, List list) {

		for (int meta = 0; meta < SCROLL_NAMES.length; ++meta) {
			list.add(new ItemStack(id, 1, meta));
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par5Boolean) {

		if (itemStack.getItemDamage() == 0) {
			list.add("Contains: Alchemist Table");
		}

		else if (itemStack.getItemDamage() == 1) {
			list.add("Contains: Arcane Gem");
		}

		else if (itemStack.getItemDamage() == 2) {
			list.add("Contains: Duplicator");
		}

		else if (itemStack.getItemDamage() == 3) {
			list.add("Contains: Arcane Fuser");
		}

		else if (itemStack.getItemDamage() == 4) {
			list.add("Contains: Aura Crusher");
		}

		else if (itemStack.getItemDamage() == 5) {
			list.add("Contains: Runes");
		}
		
		else if (itemStack.getItemDamage() == 6) {
			list.add("Contains: Paxel");
		}
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

		world.playSoundAtEntity(player, Strings.RESOURCE_PREFIX + "scroll", 1.0F, 1.0F);
		player.openGui(ArchaniCommutatio.instance, GuiIDs.RECIPE_SCROLL, world, 0, 0, 0);
		
		if (stack.getItemDamage() == 0) {
			player.addStat(ModAchievements.alchemistTable, 1);
		}

		else if (stack.getItemDamage() == 1) {
			player.addStat(ModAchievements.arcaneGem, 1);
		}

		else if (stack.getItemDamage() == 2) {
			player.addStat(ModAchievements.duplicator, 1);
		}

		else if (stack.getItemDamage() == 3) {
			player.addStat(ModAchievements.arcaneFuser, 1);
		}

		else if (stack.getItemDamage() == 4) {
			player.addStat(ModAchievements.auraCrusher, 1);
		}

		else if (stack.getItemDamage() == 5) {
			player.addStat(ModAchievements.runes, 1);
		}

		else if (stack.getItemDamage() == 6) {
			player.addStat(ModAchievements.paxel, 1);
		}

		return stack;
	}

	public static int getGuiText() {

		ItemStack stack = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();

		if (stack != null) {

			if (stack.getItem() instanceof ItemRecipeScrolls && stack.getItemDamage() == 1) {
				return 1;
			}

			else if (stack.getItem() instanceof ItemRecipeScrolls && stack.getItemDamage() == 2) {
				return 2;
			}

			else if (stack.getItem() instanceof ItemRecipeScrolls && stack.getItemDamage() == 3) {
				return 3;
			}

			if (stack.getItem() instanceof ItemRecipeScrolls && stack.getItemDamage() == 4) {
				return 4;
			}

			if (stack.getItem() instanceof ItemRecipeScrolls && stack.getItemDamage() == 5) {
				return 5;
			}

			if (stack.getItem() instanceof ItemRecipeScrolls && stack.getItemDamage() == 6) {
				return 6;
			}

		}

		return 0;
	}

}
