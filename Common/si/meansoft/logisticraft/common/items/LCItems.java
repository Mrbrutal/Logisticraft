/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
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
	
	/* Item declarations */
	public static void loadItems() {
		ingotCopper = new ItemIngot(ItemIDs.ingotCopper).setIconCoord(2, 1);
		ingotSilver = new ItemIngot(ItemIDs.ingotSilver).setIconCoord(1, 1);
		ingotPlatinum = new ItemIngot(ItemIDs.ingotPlatinum).setIconCoord(0, 1);
		
		coins = new ItemCoin(ItemIDs.coins).setIconCoord(5, 0);

	}
	
	/* Item names and translations */
	public static void nameItems() {
		ingotCopper.setItemName("Copper Ingot");
		ingotSilver.setItemName("Silver Ingot");
		ingotPlatinum.setItemName("Platinum Ingot");
		
		LanguageRegistry.addName(ingotCopper, "Copper Ingot");
		LanguageRegistry.addName(ingotSilver, "Silver Ingot");
		LanguageRegistry.addName(ingotPlatinum, "Platinum Ingot");
		
		LanguageRegistry.addName(new ItemStack(coins, 1, 0), "Copper coin");
		LanguageRegistry.addName(new ItemStack(coins, 1, 1), "Silver coin");
		LanguageRegistry.addName(new ItemStack(coins, 1, 2), "Gold coin");
		LanguageRegistry.addName(new ItemStack(coins, 1, 3), "Platinum coin");
	}
	
	/* Register recipes for items */
	public static void itemRecipes() {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(coins, 8, 0), true, new Object[]{ " # ", "###", " # ", Character.valueOf('#'), ingotCopper}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(coins, 8, 1), true, new Object[]{ " # ", "###", " # ", Character.valueOf('#'), ingotSilver}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(coins, 8, 2), true, new Object[]{ " # ", "###", " # ", Character.valueOf('#'), Item.ingotGold}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(coins, 8, 3), true, new Object[]{ " # ", "###", " # ", Character.valueOf('#'), ingotPlatinum}));
	}
}
