/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import java.util.Comparator;

import si.meansoft.logisticraft.common.core.interfaces.IStackRecipe;

import net.minecraft.src.CraftingManager;
import net.minecraft.src.ShapedRecipes;
import net.minecraft.src.ShapelessRecipes;

public class StackRecipeSorter implements Comparator {
    final StackCraftingManager scm;

    StackRecipeSorter(StackCraftingManager mng) {
	this.scm = mng;
    }

    public int compareRecipes(IStackRecipe rec1, IStackRecipe rec2) {
	return rec1 instanceof StackShapelessRecipes && rec2 instanceof StackShapedRecipes ? 1 : (rec2 instanceof StackShapelessRecipes	&& rec1 instanceof StackShapedRecipes ? -1 : (rec2.getRecipeSize() < rec1.getRecipeSize() ? -1 : (rec2.getRecipeSize() > rec1.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object obj1, Object obj2) {
	return this.compareRecipes((IStackRecipe) obj1, (IStackRecipe) obj2);
    }
}
