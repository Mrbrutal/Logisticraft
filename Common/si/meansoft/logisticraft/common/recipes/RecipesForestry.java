/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.recipes;

import net.minecraft.src.ItemStack;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.core.StackCraftingManager;
import si.meansoft.logisticraft.common.core.handlers.ModHandler;

public class RecipesForestry {
    public static void addFORecipes() {
	if (ModHandler.fo) {   
	    for (int i = 0; i < 16; i++) {
		StackCraftingManager.getInstance().addRecipe(ModHandler.foItems[i].getMaxStackSize(), new ItemStack(LCBlocks.box6.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', ModHandler.foItems[i]});
		StackCraftingManager.getInstance().addRecipe(ModHandler.foItems2[i].getMaxStackSize(), new ItemStack(LCBlocks.box7.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', ModHandler.foItems2[i]});
		StackCraftingManager.getInstance().addRecipe(1, new ItemStack(LCBlocks.crate6.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 2), new Object[] { "###", "###", "###", '#', new ItemStack(LCBlocks.box6.blockID, 1, i)});
		StackCraftingManager.getInstance().addRecipe(1, new ItemStack(LCBlocks.crate7.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 2), new Object[] { "###", "###", "###", '#', new ItemStack(LCBlocks.box7.blockID, 1, i)});
	    }
	}
    }
}
