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
import si.meansoft.logisticraft.common.core.interfaces.IStackRecipe;
import si.meansoft.logisticraft.common.items.LCItems;
import si.meansoft.logisticraft.common.library.Info;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
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
	
	for (int i = 0; i < 16; i++) {
	    this.addRecipe(Info.items[i].getItem().getItemStackLimit(), new ItemStack(LCBlocks.box.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', Info.items[i]});
	    this.addRecipe(1, new ItemStack(LCBlocks.crate.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 2), new Object[] { "###", "###", "###", '#', new ItemStack(LCBlocks.box.blockID, 1, i)});
	    this.addRecipe(1, new ItemStack(LCBlocks.crate2.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 2), new Object[] { "###", "###", "###", '#', new ItemStack(LCBlocks.box2.blockID, 1, i)});
	    this.addRecipe(Info.items2[i].getMaxStackSize(), new ItemStack(LCBlocks.box2.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', Info.items2[i]});
	}
	
	/*for (int i = 0; i < 16; i++) {
	    if(i == 9 ) {
		this.addRecipe(LCItems.ingotSilver.getItemStackLimit(), new ItemStack(LCBlocks.box2.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', new ItemStack(LCItems.ingotSilver, 1, 0) });
	    }
	    else if(i == 10 ) {
		this.addRecipe(LCItems.ingotCopper.getItemStackLimit(), new ItemStack(LCBlocks.box2.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', new ItemStack(LCItems.ingotCopper, 1, 0) });
	    }
	    else if(i == 0) {
		this.addRecipe(items2[i].getItemStackLimit(), new ItemStack(LCBlocks.box2.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', new ItemStack(items2[i], 1, 15) });
	    }
	    else if(i == 4) {
		this.addRecipe(items2[i].getItemStackLimit(), new ItemStack(LCBlocks.box2.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', new ItemStack(items2[i], 1, 0) });
	    }
	    else {
		this.addRecipe(items2[i].getItemStackLimit(), new ItemStack(LCBlocks.box2.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', new ItemStack(items2[i], 1, 0) });
	    }
	}*/
	
	this.addShapelessRecipe(64, new ItemStack(LCItems.coins, 1, 1), null, new Object[] {new ItemStack(LCItems.coins, 1, 0)});
	this.addShapelessRecipe(64, new ItemStack(LCItems.coins, 1, 2), null, new Object[] {new ItemStack(LCItems.coins, 1, 1)});
	this.addShapelessRecipe(64, new ItemStack(LCItems.coins, 1, 3), null, new Object[] {new ItemStack(LCItems.coins, 1, 2)});

	Collections.sort(this.recipes, new StackRecipeSorter(this));
	System.out.println(this.recipes.size() + " stack recipes.");
    }

    /**
     * Adds a recipe. See spreadsheet on first page for details.
     */
    public void addRecipe(int stackSize, ItemStack stackGet, ItemStack addBlock, Object... obj) {
	String var3 = "";
	int var4 = 0;
	int var5 = 0;
	int var6 = 0;
	int var9;

	if (obj[var4] instanceof String[]) {
	    String[] var7 = (String[]) ((String[]) obj[var4++]);
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
	    while (obj[var4] instanceof String) {
		String var13 = (String) obj[var4++];
		++var6;
		var5 = var13.length();
		var3 = var3 + var13;
	    }
	}

	HashMap var14;

	for (var14 = new HashMap(); var4 < obj.length; var4 += 2) {
	    Character var16 = (Character) obj[var4];
	    ItemStack var17 = null;

	    if (obj[var4 + 1] instanceof Item) {
		var17 = new ItemStack((Item) obj[var4 + 1]);
	    }
	    else if (obj[var4 + 1] instanceof Block) {
		var17 = new ItemStack((Block) obj[var4 + 1], 1, -1);
	    }
	    else if (obj[var4 + 1] instanceof ItemStack) {
		var17 = (ItemStack) obj[var4 + 1];
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

	this.recipes.add(new StackShapedRecipes(var5, var6, var15, stackGet, addBlock, stackSize));
	//System.out.println("Added: " + var5 + ":" + var6 + "  " + stackGet.getItemName() + " | " + stackSize);
    }

    public void addShapelessRecipe(int stackSize, ItemStack stackGet, ItemStack addBlock, Object... obj) {
	ArrayList var3 = new ArrayList();
	Object[] var4 = obj;
	int var5 = obj.length;

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
		    throw new RuntimeException("Invalid shapeless recipe!");
		}

		var3.add(new ItemStack((Block) var7));
	    }
	}

	this.recipes.add(new StackShapelessRecipes(stackGet, addBlock, var3, stackSize));
	//System.out.println("Added: " + var3 + "  " + stackGet.getItemName() + " | " + stackSize);
    }
    
    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, InventoryCrafting par1InventoryCrafting2) {
	Iterator var11 = this.recipes.iterator();
	IStackRecipe var13;

	do {
	    if (!var11.hasNext()) {
		return null;
	    }

	    var13 = (IStackRecipe) var11.next();
	} while (!var13.matches(par1InventoryCrafting, par1InventoryCrafting2));

	return var13.getCraftingResult(par1InventoryCrafting);
    }

    public List getRecipeList() {
	return this.recipes;
    }
}
