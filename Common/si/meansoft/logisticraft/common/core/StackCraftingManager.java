/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import si.meansoft.logisticraft.common.blocks.LCBlocks;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
//import net.minecraft.src.RecipeSorter;
import net.minecraft.src.RecipesArmor;
import net.minecraft.src.RecipesCrafting;
import net.minecraft.src.RecipesDyes;
import net.minecraft.src.RecipesFood;
import net.minecraft.src.RecipesIngots;
import net.minecraft.src.RecipesTools;
import net.minecraft.src.RecipesWeapons;
import net.minecraft.src.ShapelessRecipes;

public class StackCraftingManager {

    /* The static instance of this class */
    private static final StackCraftingManager instance = new StackCraftingManager();

    /* A list of all the recipes added */
    private List recipes = new ArrayList();

    /* Returns the static instance of this class */
    public static final StackCraftingManager getInstance() {
	return instance;
    }

    private StackCraftingManager() {

	Item[] items = new Item[] { Item.wheat, Item.reed, Item.appleRed, Item.egg, Item.cake, Item.bread, Item.rottenFlesh, Item.cookie, Item.arrow, Item.porkRaw, Item.fishRaw, Item.beefRaw, Item.chickenRaw, Item.slimeBall, Item.melon, Item.coal };

	for (int i = 0; i < 16; i++) {
	    if (i == 4) {
		this.addRecipe(1, new ItemStack(LCBlocks.box.blockID, 1, i), new ItemStack(LCBlocks.crate, 1, 15), new Object[] { "###", "###", "###", '#', items[i] });
		//System.out.println("Added recipe for: " + items[i] + " | box(" + i + ")");
	    }
	    else if (i == 5) {
		this.addRecipe(16, new ItemStack(LCBlocks.box.blockID, 1, i), new ItemStack(LCBlocks.crate, 1, 15), new Object[] { "###", "###", "###", '#', items[i] });
		//System.out.println("Added recipe for: " + items[i] + " | box(" + i + ")");
	    }
	    else {
		this.addRecipe(64, new ItemStack(LCBlocks.box.blockID, 1, i), new ItemStack(LCBlocks.crate, 1, 15), new Object[] { "###", "###", "###", '#', items[i] });
		//System.out.println("Added recipe for: " + items[i] + " | box(" + i + ")");
	    }

	    this.addRecipe(-1, new ItemStack(LCBlocks.crate.blockID, 1, i), new ItemStack(LCBlocks.crate, 1, 15), new Object[] { "###", "###", "###", '#', new ItemStack(LCBlocks.box.blockID, 1, i) });
	    //System.out.println("Added recipe for: Crate" + i + " | box(" + i + ")");
	}

	// Collections.sort(this.recipes, new RecipeSorter(this));
	System.out.println(this.recipes.size() + " recipes");
    }

    /**
     * Adds a recipe. See spreadsheet on first page for details.
     */
    public void addRecipe(int stackSize, ItemStack par1ItemStack, ItemStack addBlock, Object... par2ArrayOfObj) {
	String var3 = "";
	int var4 = 0;
	int var5 = 0;
	int var6 = 0;
	int var9;

	if (par2ArrayOfObj[var4] instanceof String[]) {
	    String[] var7 = (String[]) ((String[]) par2ArrayOfObj[var4++]);
	    String[] var8 = var7;
	    var9 = var7.length;

	    for (int var10 = 0; var10 < var9; ++var10) {
		String var11 = var8[var10];
		++var6;
		var5 = var11.length();
		var3 = var3 + var11;
	    }
	}
	else {
	    while (par2ArrayOfObj[var4] instanceof String) {
		String var13 = (String) par2ArrayOfObj[var4++];
		++var6;
		var5 = var13.length();
		var3 = var3 + var13;
	    }
	}

	HashMap var14;

	for (var14 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2) {
	    Character var16 = (Character) par2ArrayOfObj[var4];
	    ItemStack var17 = null;

	    if (par2ArrayOfObj[var4 + 1] instanceof Item) {
		var17 = new ItemStack((Item) par2ArrayOfObj[var4 + 1]);
	    }
	    else if (par2ArrayOfObj[var4 + 1] instanceof Block) {
		var17 = new ItemStack((Block) par2ArrayOfObj[var4 + 1], 1, -1);
	    }
	    else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack) {
		var17 = (ItemStack) par2ArrayOfObj[var4 + 1];
	    }

	    var14.put(var16, var17);
	}

	ItemStack[] var15 = new ItemStack[var5 * var6];

	for (var9 = 0; var9 < var5 * var6; ++var9) {
	    char var18 = var3.charAt(var9);

	    if (var14.containsKey(Character.valueOf(var18))) {
		var15[var9] = ((ItemStack) var14.get(Character.valueOf(var18))).copy();
	    }
	    else {
		var15[var9] = null;
	    }
	}

	this.recipes.add(new StackShapedRecipes(var5, var6, var15, par1ItemStack, stackSize));
	//System.out.println("Added: " + var5 + ":" + var6 + " " + par1ItemStack.getItemName() + " | " + stackSize);
    }

    /*public void addShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
	ArrayList var3 = new ArrayList();
	Object[] var4 = par2ArrayOfObj;
	int var5 = par2ArrayOfObj.length;

	for (int var6 = 0; var6 < var5; ++var6) {
	    Object var7 = var4[var6];

	    if (var7 instanceof ItemStack) {
		var3.add(((ItemStack) var7).copy());
	    }
	    else if (var7 instanceof Item) {
		var3.add(new ItemStack((Item) var7));
	    }
	    else {
		if (!(var7 instanceof Block)) {
		    throw new RuntimeException("Invalid shapeless recipy!");
		}

		var3.add(new ItemStack((Block) var7));
	    }
	}

	this.recipes.add(new ShapelessRecipes(par1ItemStack, var3));
    }*/
    
    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting) {
	Iterator var11 = this.recipes.iterator();
	IRecipe var13;

	do {
	    if (!var11.hasNext()) {
		return null;
	    }

	    var13 = (IRecipe) var11.next();
	} while (!var13.matches(par1InventoryCrafting));

	return var13.getCraftingResult(par1InventoryCrafting);
    }

    public List getRecipeList() {
	return this.recipes;
    }
}
