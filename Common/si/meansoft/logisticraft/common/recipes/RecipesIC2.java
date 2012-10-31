/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.recipes;

import net.minecraft.src.ItemStack;
import net.minecraft.src.ic2.api.Ic2Recipes;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.core.StackCraftingManager;
import si.meansoft.logisticraft.common.core.handlers.ModHandler;
import si.meansoft.logisticraft.common.items.LCItems;

public class RecipesIC2 {
    public static void addIC2Recipes() {
	if (ModHandler.ic2) {
	    Ic2Recipes.addMaceratorRecipe(new ItemStack(LCBlocks.ores, 1, 2), new ItemStack(LCItems.dusts, 1, 0));
	    Ic2Recipes.addMaceratorRecipe(new ItemStack(LCBlocks.ores, 1, 1), new ItemStack(LCItems.dusts, 1, 1));
	    Ic2Recipes.addMaceratorRecipe(new ItemStack(LCBlocks.ores, 1, 0), new ItemStack(LCItems.dusts, 1, 2));
	    
	    for (int i = 0; i < 16; i++) {
		StackCraftingManager.getInstance().addRecipe(ModHandler.ic2Items[i].getMaxStackSize(), new ItemStack(LCBlocks.box5.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 3), new Object[] { "###", "###", "###", '#', ModHandler.ic2Items[i]});
		StackCraftingManager.getInstance().addRecipe(1, new ItemStack(LCBlocks.crate5.blockID, 1, i), new ItemStack(LCBlocks.chimney, 1, 2), new Object[] { "###", "###", "###", '#', new ItemStack(LCBlocks.box5.blockID, 1, i)});
	    }
	}
    }
}
