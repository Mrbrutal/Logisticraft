/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;

public class LCBlocks {
	
	public static Block TEST;
	
	/* Block declarations */
	public static void loadBlocks() {
		TEST = new BlockTest(BlockIDs.TEST, 0);
	}
	
	/* Block registration */
	public static void registerBlocks() {
		GameRegistry.registerBlock(TEST);
	}
	
	/* Block names and translations */
	public static void nameBlocks() {
		TEST.setBlockName("TestBlock");
		
		LanguageRegistry.addName(TEST, "Test block");
	}
	
	/* Register recipes for blocks */
	public static void blockRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(TEST), Block.dirt);
	}
}
