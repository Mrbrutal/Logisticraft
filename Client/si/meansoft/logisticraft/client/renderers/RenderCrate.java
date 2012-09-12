/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.client.renderers;

import org.lwjgl.opengl.GL11;

import si.meansoft.logisticraft.common.library.Info;
import si.meansoft.logisticraft.common.library.RenderIDs;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.Tessellator;
import net.minecraftforge.client.ForgeHooksClient;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderCrate implements ISimpleBlockRenderingHandler {
	
	private ModelBase model = new ModelBase() {};
	static final float factor = (float) (1.0 / 16.0);
	
	private final ModelRenderer box;
	
	private final ModelRenderer vert[] = new ModelRenderer[4];
	private final ModelRenderer hor[] = new ModelRenderer[4];
	
	public RenderCrate() {
		box = new ModelRenderer(model, 0, 0);
		box.addBox(0F, 0F, 0F, 14, 14, 14);
		box.setRotationPoint(-7F, 9F, -7F);
		box.setTextureSize(128, 64);
		box.mirror = true;
		
		vert[0] = new ModelRenderer(model, 0, 0);
	}
	
	private boolean render(double x, double y, double z) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glTranslated(x, y, z);
		ForgeHooksClient.bindTexture(Info.TEX_CRATE, 0);


		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
		return true;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		block.setBlockBoundsForItemRender();
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderer.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, 0));
		tessellator.draw();
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, 0));
		tessellator.draw();
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderer.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, 0));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, 0));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderer.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, 0));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, 0));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		/*if(modelId == RenderIDs.crateID) {
			return render((double)x, (double)y, (double)z);
		}
		else {
			return false;
		}*/
		
		ModelCrate crate = ModelCrate.getInstance();		
		//crate.render(null,  0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		box.render(factor);
		
		return true;
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
