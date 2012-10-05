/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.interfaces;

import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.ItemStack;

public interface IStackRecipe {
    /**
     * Used to check if a recipe matches current crafting inventory
     * @param par1InventoryCrafting2 
     */
    boolean matches(InventoryCrafting var1, InventoryCrafting var2);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(InventoryCrafting var1);

    /**
     * Returns the size of the recipe area
     */
    int getRecipeSize();

    ItemStack getRecipeOutput();
    
    ItemStack getRecipeAdditional();
    
    int getStackSize();
}
