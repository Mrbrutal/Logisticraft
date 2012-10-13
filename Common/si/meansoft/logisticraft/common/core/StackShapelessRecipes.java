/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import si.meansoft.logisticraft.common.core.interfaces.IStackRecipe;

import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.ItemStack;

public class StackShapelessRecipes implements IStackRecipe {

    /** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;

    /** Is a List of ItemStack that composes the recipe. */
    private final List recipeItems;
    
    /** Is the number of items in stack */
    private final int stack;
    
    /** Is the stack used in additional gui slot */
    private final ItemStack additionalBlock;

    public StackShapelessRecipes(ItemStack par1ItemStack, ItemStack addBlock, List par2List, int stackSize) {
	this.recipeOutput = par1ItemStack;
	this.recipeItems = par2List;
	this.stack = stackSize;
	this.additionalBlock = addBlock;
    }

    public ItemStack getRecipeOutput() {
	return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting par1InventoryCrafting, InventoryCrafting par1InventoryCrafting2) {
	ArrayList var2 = new ArrayList(this.recipeItems);

	for (int var3 = 0; var3 < 3; ++var3) {
	    for (int var4 = 0; var4 < 3; ++var4) {
		ItemStack var5 = par1InventoryCrafting.getStackInRowAndColumn(var4, var3);
		ItemStack var9 = par1InventoryCrafting2.getStackInSlot(0);

		if (var5 != null) {
		    boolean var6 = false;
		    Iterator var7 = var2.iterator();

		    while (var7.hasNext()) {
			ItemStack var8 = (ItemStack) var7.next();

			if (var5.itemID == var8.itemID && (var8.getItemDamage() == -1 || var5.getItemDamage() == var8.getItemDamage())) {
			    var6 = true;
			    var2.remove(var8);
			    break;
			}
		    }

		    if (!var6) {
			return false;
		    }
		}
	    }
	}

	return var2.isEmpty();
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting) {
	return this.recipeOutput.copy();
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize() {
	return this.recipeItems.size();
    }

    @Override
    public ItemStack getRecipeAdditional() {
	return additionalBlock;
    }

    @Override
    public int getStackSize() {
	return stack;
    }

    @Override
    public ItemStack[] getRecipeItems() {
	return /*(ItemStack[]) recipeItems.toArray()*/null;
    }

}
