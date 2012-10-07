/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import si.meansoft.logisticraft.common.core.interfaces.IStackRecipe;
import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ShapedRecipes;

public class StackShapedRecipes implements IStackRecipe {

    /* How many horizontal slots this recipe is wide. */
    private int recipeWidth;

    /* How many vertical slots this recipe uses. */
    private int recipeHeight;

    /* Is a array of ItemStack that composes the recipe. */
    private ItemStack[] recipeItems;

    /* Is the ItemStack that you get when craft the recipe. */
    private ItemStack recipeOutput;

    /* Is the ItemStack that you get when craft the recipe. */
    private ItemStack additionalOutput;

    /* Is the itemID of the output item that you get when craft the recipe. */
    public final int recipeOutputItemID;

    /* Stack size to be decremented */
    public static int stSize;

    public StackShapedRecipes(int par1, int par2, ItemStack[] arrayStack, ItemStack stack, ItemStack additionalBlock, int size) {
	this.recipeOutputItemID = stack.itemID;
	this.recipeWidth = par1;
	this.recipeHeight = par2;
	this.recipeItems = arrayStack;
	this.recipeOutput = stack;
	this.additionalOutput = additionalBlock;
	this.stSize = size;
	//System.out.println(size);
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting inv1, InventoryCrafting inv2) {
	for (int var2 = 0; var2 <= 3 - this.recipeWidth; ++var2) {
	    for (int var3 = 0; var3 <= 3 - this.recipeHeight; ++var3) {
		if(additionalOutput != null) {
		    if (this.checkMatch(inv1, inv2, var2, var3, true)) {
			return true;
		    }
		    if (this.checkMatch(inv1, inv2, var2, var3, false)) {
			return true;
		    }
		}
		else {  
		    /*if (this.checkMatch2(inv1, inv2, var2, var3, true)) {
			return true;
		    }
		    if (this.checkMatch2(inv1, inv2, var2, var3, false)) {
			return true;
		    }*/
		}
	    }
	}

	return false;
    }

    private boolean checkMatch(InventoryCrafting inv1, InventoryCrafting inv2, int par2, int par3, boolean par4) {
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

		ItemStack var10 = inv1.getStackInRowAndColumn(var5, var6);
		ItemStack var11 = inv2.getStackInSlot(0);
		ItemStack var12 = this.additionalOutput;

		//System.out.println("var11: " + var11.getItemName());
		if (var10 != null || var9 != null || var11 != null || var12 != null) {
		    if (var10 == null && var9 != null || var10 != null && var9 == null || var11 == null && var12 != null || var11 != null && var12 == null) {
			return false;
		    }

		    if (var9.itemID != var10.itemID) {
			return false;
		    }

		    if (getStackSize() != 1 && var10.stackSize != getStackSize()) {
			//System.out.println("StSize: " + getStackSize() + " Damages: 10:" + var10.stackSize + " 10:" + getStackSize());
			return false;
		    }

		    if (var10.getItemDamage() != -1 && var9.getItemDamage() != var10.getItemDamage()) {
			//System.out.println("StSize: " + getStackSize() + " Damages: 9:" + var9.getItemDamage() + " 10:" + var10.getItemDamage());
			return false;
		    }

		    if (var11.itemID != var12.itemID) {
			return false;
		    }

		    if (var11.getItemDamage() != var12.getItemDamage()) {
			return false;
		    }
		}
	    }
	}
	return true;
    }
    
    private boolean checkMatch2(InventoryCrafting inv1, InventoryCrafting inv2, int par2, int par3, boolean par4) {
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

		ItemStack var10 = inv1.getStackInRowAndColumn(var5, var6);
		ItemStack var11 = inv2.getStackInSlot(0);
		ItemStack var12 = this.additionalOutput;
		
		//if (var12 == null) {
		    if (var10 != null || var9 != null) {
			if (var10 == null && var9 != null || var10 != null && var9 == null /*|| var11 == null && var12 != null || var11 != null && var12 == null*/) {
			    return false;
			}

			if (var9.itemID != var10.itemID) {
			    return false;
			}
			
			if (getStackSize() != 1 && var10.stackSize != getStackSize()) {
			    return false;
			}

			if (var9.getItemDamage() != -1 && var9.getItemDamage() != var10.getItemDamage()) {
			    return false;
			}
		    }
		//}
	    }
	}
	return true;   
    }

    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting) {
	return new ItemStack(this.recipeOutput.itemID, this.recipeOutput.stackSize, this.recipeOutput.getItemDamage());
    }
    
    public ItemStack getRecipeOutput() {
	return this.recipeOutput;
    }

    public ItemStack getRecipeAdditional() {
	return this.additionalOutput;
    }

    public int getRecipeSize() {
	return this.recipeWidth * this.recipeHeight;
    }

    public int getStackSize() {
	return stSize;
    }

}
