/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import si.meansoft.logisticraft.common.library.*;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockCrate extends Block {

	public BlockCrate(int par1, int par2) {
		super(par1, par2, Material.rock);
		blockIndexInTexture = par2;
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
    public String getTextureFile() {
    	return Info.TEX_BLOCK;
    }
	
	@Override
	public int getRenderType() {
        return RenderIDs.crateID;
	}
		
}
