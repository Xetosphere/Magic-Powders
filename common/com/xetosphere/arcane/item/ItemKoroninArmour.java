package com.xetosphere.arcane.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.xetosphere.arcane.ArchaniCommutatio;
import com.xetosphere.arcane.lib.Strings;
import com.xetosphere.arcane.lib.Textures;

public class ItemKoroninArmour extends ItemArmor {

	public ItemKoroninArmour(int id, EnumArmorMaterial armourMaterial, int renderIndex, int armourPart) {
		super(id, armourMaterial, renderIndex, armourPart);
		setCreativeTab(ArchaniCommutatio.tabARC);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (slot == 0 || slot == 1 || slot == 3) {
			return Strings.RESOURCE_PREFIX + Textures.ARMOR_SHEET_LOCATION + Strings.KORONINARMOUR_NAME + "_1.png";
		} else if (slot == 2) {
			return Strings.RESOURCE_PREFIX + Textures.ARMOR_SHEET_LOCATION + Strings.KORONINARMOUR_NAME + "_2.png";
		}
		return null;
	}

	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}
