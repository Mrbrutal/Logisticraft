/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ShapedRecipes;

public class StackShapedRecipes implements IRecipe{

    /* How many horizontal slots this recipe is wide. */
    private int recipeWidth;

    /* How many vertical slots this recipe uses. */
    private int recipeHeight;

    /* Is a array of ItemStack that composes the recipe. */
    private ItemStack[] recipeItems;

    /* Is the ItemStack that you get when craft the recipe. */
    private ItemStack recipeOutput;

    /* Is the itemID of the output item that you get when craft the recipe. */
    public final int recipeOutputItemID;
    
    /* Stack size to be decremented */
    public static int stackSize;

    public StackShapedRecipes(int par1, int par2, ItemStack[] arrayStack, ItemStack stack, int size) {
	this.recipeOutputItemID = stack.itemID;
	this.recipeWidth = par1;
	this.recipeHeight = par2;
	this.recipeItems = arrayStack;
	this.recipeOutput = stack;
	this.stackSize = size;
    }

    public ItemStack getRecipeOutput() {
	return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting par1InventoryCrafting) {
	for (int var2 = 0; var2 <= 3 - this.recipeWidth; ++var2) {
	    for (int var3 = 0; var3 <= 3 - this.recipeHeight; ++var3) {
		if (this.checkMatch(par1InventoryCrafting, var2, var3, true)) {
		    return true;
		}

		if (this.checkMatch(par1InventoryCrafting, var2, var3, false)) {
		    return true;
		}
	    }
	}

	return false;
    }

    private boolean checkMatch(InventoryCrafting par1InventoryCrafting, int par2, int par3, boolean par4) {
	for (int var5 = 0; var5 < 3; ++var5) {
	    for (int var6 = 0; var6 < 3; ++var6) {
		int var7 = var5 - par2;
		int var8 = var6 - par3;
		ItemStack var9 = null;

		if (var7 >= 0 && var8 >= 0 && var7 < this.recipeWidth && var8 < this.recipeHeight) {
		    if (par4) {
			var9 = this.recipeItems[this.recipeWidth - var7 - 1 + var8 * this.recipeWidth];
		    }
		    else {
			var9 = this.recipeItems[var7 + var8 * this.recipeWidth];
		    }
		}

		ItemStack var10 = par1InventoryCrafting.getStackInRowAndColumn(var5, var6);

		if (var10 != null || var9 != null) {
		    if (var10 == null && var9 != null || var10 != null && var9 == null) {
			return false;
		    }

		    if (var9.itemID != var10.itemID) {
			return false;
		    }

		    if (var9.getItemDamage() != -1 && var9.getItemDamage() != var10.getItemDamage()) {
			return false;
		    }

		    if(stackSize != 0) {
			if (var10.stackSize != stackSize) {
			    return false;
			}
		    }
		}
	    }
	}

	return true;
    }

    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting) {
	return new ItemStack(this.recipeOutput.itemID, this.recipeOutput.stackSize, this.recipeOutput.getItemDamage());
    }

    public int getRecipeSize() {
	return this.recipeWidth * this.recipeHeight;
    }
    
    public static int getStackSize() {
	return stackSize;
    }

}
