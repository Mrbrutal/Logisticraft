/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.renderers;

import si.meansoft.logisticraft.common.library.RenderIDs;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.RenderBlocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderCrate implements ISimpleBlockRenderingHandler{
	
	

	private boolean renderCrate(Block block, int x, int y, int z, RenderBlocks renderer) {
		
		return false;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		if(modelId == RenderIDs.crateID) {
			return renderCrate(block, x, y, z, renderer);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean shouldRender3DInInventory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return RenderIDs.crateID;
	}
	
}
