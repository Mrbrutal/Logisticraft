/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import si.meansoft.logisticraft.common.core.CreativeTabLogisticraft;
import si.meansoft.logisticraft.common.library.Info;
import si.meansoft.logisticraft.common.library.RenderIDs;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockTest extends Block{

    public BlockTest(int par1, int par2) {
	super(par1, par2, Material.rock);
	setCreativeTab(LCBlocks.lcTab);
	blockIndexInTexture = par2;
	setTextureFile(Info.TEX_BLOCK);
    }
    
    public int getBlockTextureFromSideAndMetadata(int side, int data) {
	if(data == 0) {
	    return blockIndexInTexture;
	}
	else {
	    return blockIndexInTexture + 1;
	}
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public int getRenderType() {
        return RenderIDs.crateID;
    }
}
