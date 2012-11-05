/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.client.renderers;

import org.lwjgl.opengl.GL11;

import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.library.Info;
import si.meansoft.logisticraft.common.library.RenderIDs;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.Tessellator;
import net.minecraftforge.client.ForgeHooksClient;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TestRenderer implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	Tessellator tessellator = Tessellator.instance;

	block.setBlockBoundsForItemRender();
	GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	tessellator.startDrawingQuads();
	tessellator.setNormal(0.0F, -1F, 0.0F);
	renderer.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, metadata));
	renderer.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, metadata + 1));
	tessellator.draw();

	tessellator.startDrawingQuads();
	tessellator.setNormal(0.0F, 1.0F, 0.0F);
	renderer.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, metadata));
	renderer.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, metadata + 1));
	tessellator.draw();

	tessellator.startDrawingQuads();
	tessellator.setNormal(0.0F, 0.0F, -1F);
	renderer.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, metadata));
	renderer.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, metadata + 1));
	tessellator.draw();
	tessellator.startDrawingQuads();
	tessellator.setNormal(0.0F, 0.0F, 1.0F);
	renderer.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, metadata));
	renderer.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, metadata + 1));
	tessellator.draw();
	tessellator.startDrawingQuads();
	tessellator.setNormal(-1F, 0.0F, 0.0F);
	renderer.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, metadata));
	renderer.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, metadata + 1));
	tessellator.draw();
	tessellator.startDrawingQuads();
	tessellator.setNormal(1.0F, 0.0F, 0.0F);
	renderer.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, metadata));
	renderer.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, metadata + 1));
	tessellator.draw();
	GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
	ForgeHooksClient.bindTexture("/terrain.png", 0);
	renderInnerBlock(world, x, y, z, block, modelId, renderer, 10000, 13);
	ForgeHooksClient.unbindTexture();
	
	ForgeHooksClient.bindTexture(Info.TEX_BLOCK, 0);
	renderOuterBlock(world, x, y, z, block, modelId, renderer);
	//renderInnerBlock(world, x, y, z, block, modelId, renderer, 1, block.getBlockTexture(world, x, y, z, 0));
	ForgeHooksClient.unbindTexture();
	return true;
    }
    
    public void renderInnerBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer, int brightness, int textureId) {
	Tessellator tessellator = Tessellator.instance;
	renderer.enableAO = false;
	
	if (renderer.renderAllFaces || block.shouldSideBeRendered(world, x, y - 1, z, 0)) {
	    tessellator.setBrightness(renderer.field_83027_i > 0.0D ? block.getMixedBrightnessForBlock(world, x, y - 1, z) : brightness);
	    tessellator.setColorOpaque(250, 250, 250);
	    renderer.renderBottomFace(block, x, y, z, textureId);
	}
	if (renderer.renderAllFaces || block.shouldSideBeRendered(world, x, y + 1, z, 0)) {
	    tessellator.setBrightness(renderer.field_83027_i > 0.0D ? block.getMixedBrightnessForBlock(world, x, y + 1, z) : brightness);
	    tessellator.setColorOpaque(250, 250, 250);
	    renderer.renderTopFace(block, x, y, z, textureId);
	}
	if (renderer.renderAllFaces || block.shouldSideBeRendered(world, x, y, z - 1, 0)) {
	    tessellator.setBrightness(renderer.field_83027_i > 0.0D ? block.getMixedBrightnessForBlock(world, x, y, z - 1) : brightness);
	    tessellator.setColorOpaque(250, 250, 250);
	    renderer.renderEastFace(block, x, y, z, textureId);
	}
	if (renderer.renderAllFaces || block.shouldSideBeRendered(world, x, y, z + 1, 0)) {
	    tessellator.setBrightness(renderer.field_83027_i > 0.0D ? block.getMixedBrightnessForBlock(world, x, y, z + 1) : brightness);
	    tessellator.setColorOpaque(250, 250, 250);
	    renderer.renderWestFace(block, x, y, z, textureId);
	}
	if (renderer.renderAllFaces || block.shouldSideBeRendered(world, x - 1, y, z, 0)) {
	    tessellator.setBrightness(renderer.field_83027_i > 0.0D ? block.getMixedBrightnessForBlock(world, x - 1, y, z) : brightness);
	    tessellator.setColorOpaque(250, 250, 250);
	    renderer.renderNorthFace(block, x, y, z, textureId);
	}
	if (renderer.renderAllFaces || block.shouldSideBeRendered(world, x + 1, y, z, 0)) {
	    tessellator.setBrightness(renderer.field_83027_i > 0.0D ? block.getMixedBrightnessForBlock(world, x + 1, y, z) : brightness);
	    tessellator.setColorOpaque(250, 250, 250);
	    renderer.renderSouthFace(block, x, y, z, textureId);
	}
    }
    
    public void renderOuterBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
	renderer.renderStandardBlock(block, x, y, z);
    }

    @Override
    public boolean shouldRender3DInInventory() {
	return true;
    }

    @Override
    public int getRenderId() {
	return RenderIDs.crateID;
    }

}
