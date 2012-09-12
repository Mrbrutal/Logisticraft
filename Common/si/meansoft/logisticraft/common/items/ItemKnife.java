/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.library.Info;
import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemTool;

public class ItemKnife extends ItemTool {
	private static Block[] blocksEffectiveAgainst = new Block[] {LCBlocks.crate};
	
	public ItemKnife(int par1, EnumToolMaterial toolMaterial) {
		super(par1, par1, toolMaterial, blocksEffectiveAgainst);
		setMaxStackSize(1);
	}
	
	public boolean canHarvestBlock(Block block) {
		if(/*block.blockID == mod_Logisticraft.plantBlock.blockID || */block.blockID == LCBlocks.crate.blockID) {
			return true;
		}
		else {
			return false;
		}
    }
	
	public String getTextureFile() {
		return Info.TEX_ITEM;
	}
}
