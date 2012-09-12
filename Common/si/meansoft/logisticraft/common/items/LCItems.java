/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import net.minecraft.src.CraftingManager;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import si.meansoft.logisticraft.common.library.BlockIDs;
import si.meansoft.logisticraft.common.library.ItemIDs;

public class LCItems {
	
	public static Item ingotCopper;
	public static Item ingotSilver;
	public static Item ingotPlatinum;
	
	public static Item coins;
	public static Item dusts;
	public static Item knife;
	
	public static ItemBlockOres ores;
	
	/* Item declarations */
	public static void loadItems() {
		ingotCopper = new ItemIngot(ItemIDs.ingotCopper).setIconIndex(18).setTabToDisplayOn(CreativeTabs.tabMaterials);
		ingotSilver = new ItemIngot(ItemIDs.ingotSilver).setIconIndex(17).setTabToDisplayOn(CreativeTabs.tabMaterials);
		ingotPlatinum = new ItemIngot(ItemIDs.ingotPlatinum).setIconIndex(16).setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		coins = new ItemCoins(ItemIDs.coins).setIconCoord(5, 0);
		
		dusts = new ItemDusts(ItemIDs.dusts).setIconIndex(19);
		
		EnumToolMaterial materialKnife = EnumHelper.addToolMaterial("Knife", 1, 50, 5.0F, 1, 7);
		knife = new ItemKnife(ItemIDs.knife, materialKnife).setIconCoord(1, 0);
	}
	
	/* Item names and translations */
	public static void nameItems() {
		ingotCopper.setItemName("Copper Ingot");
		ingotSilver.setItemName("Silver Ingot");
		ingotPlatinum.setItemName("Platinum Ingot");
		knife.setItemName("Knife");
		
		LanguageRegistry.addName(ingotCopper, "Copper Ingot");
		LanguageRegistry.addName(ingotSilver, "Silver Ingot");
		LanguageRegistry.addName(ingotPlatinum, "Platinum Ingot");
		
		LanguageRegistry.addName(new ItemStack(coins, 1, 0), "Copper coin");
		LanguageRegistry.addName(new ItemStack(coins, 1, 1), "Silver coin");
		LanguageRegistry.addName(new ItemStack(coins, 1, 2), "Gold coin");
		LanguageRegistry.addName(new ItemStack(coins, 1, 3), "Platinum coin");
		
		LanguageRegistry.addName(new ItemStack(dusts, 1, 0), "Copper dust");
		LanguageRegistry.addName(new ItemStack(dusts, 1, 1), "Silver dust");
		LanguageRegistry.addName(new ItemStack(dusts, 1, 2), "Platinum dust");
		
		LanguageRegistry.addName(knife, "Knife");
	}
}
