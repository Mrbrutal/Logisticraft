/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.recipes;

import si.meansoft.logisticraft.common.api.LC;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.library.Info;

public class RecipesStack {
    
    public static void addRecipes() {
	/* Add boxes, crates */
	LC.addBox(LCBlocks.box, Info.items, Info.crateNames);
	LC.addBox(LCBlocks.box2, Info.items2, Info.crateNames2);
	LC.addBox(LCBlocks.box3, Info.items3, Info.crateNames3);
	LC.addBox(LCBlocks.box4, Info.items4, Info.crateNames4);
	
	LC.addCrate(LCBlocks.crate, Info.items, Info.crateNames);
	LC.addCrate(LCBlocks.crate2, Info.items2, Info.crateNames2);
	LC.addCrate(LCBlocks.crate3, Info.items3, Info.crateNames3);
	LC.addCrate(LCBlocks.crate4, Info.items4, Info.crateNames4);
	
	/* Add recipes */
    }
}
