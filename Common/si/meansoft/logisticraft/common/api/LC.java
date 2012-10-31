/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.api;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import si.meansoft.logisticraft.common.core.StackCraftingManager;

public class LC {
    
    public static List<Block> boxes = null;
    public static List<Block> crates = null;
    
    public static void addBox(Block block, ItemStack[] items, String[] names) {
	boxes.add(block);
    }
    
    public static void addCrate(Block block, ItemStack[] items, String[] names) {
	crates.add(block);
    }
    
    public static void addStackRecipe(int size, ItemStack additional, ItemStack get, Object obj) {
	StackCraftingManager.getInstance().addRecipe(size, get, additional, obj);
    }
    
    public static void addShapelessStackRecipe(int size, ItemStack additional, ItemStack get, Object obj) {
	StackCraftingManager.getInstance().addShapelessRecipe(size, additional, get, obj);
    }
    
    public static List<Block> getBoxes() {
	return boxes;
    }
    
    public static List<Block> getCrates() {
	return crates;
    }

}
