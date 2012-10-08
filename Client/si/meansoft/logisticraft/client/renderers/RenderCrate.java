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
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderManager;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderCrate implements ISimpleBlockRenderingHandler {

    RenderManager rendermanager = RenderManager.instance;
    private ModelCrate mc = new ModelCrate();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	Tessellator tessellator = Tessellator.instance;
	block.setBlockBoundsForItemRender();
	GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	tessellator.startDrawingQuads();
	tessellator.setNormal(0.0F, -1F, 0.0F);
	renderer.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(0, metadata));
	tessellator.draw();

	tessellator.startDrawingQuads();
	tessellator.setNormal(0.0F, 1.0F, 0.0F);
	renderer.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(1, metadata));
	tessellator.draw();

	tessellator.startDrawingQuads();
	tessellator.setNormal(0.0F, 0.0F, -1F);
	renderer.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(2, metadata));
	tessellator.draw();
	tessellator.startDrawingQuads();
	tessellator.setNormal(0.0F, 0.0F, 1.0F);
	renderer.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(3, metadata));
	tessellator.draw();
	tessellator.startDrawingQuads();
	tessellator.setNormal(-1F, 0.0F, 0.0F);
	renderer.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(4, metadata));
	tessellator.draw();
	tessellator.startDrawingQuads();
	tessellator.setNormal(1.0F, 0.0F, 0.0F);
	renderer.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSideAndMetadata(5, metadata));
	tessellator.draw();
	GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
	//renderer.renderStandardBlock(block, x, y, z);

	/*int meta = world.getBlockMetadata(x, y, z);
	Item item = Info.items[meta];
	ItemStack itemstack = new ItemStack(item);
	if (item != null) {
	    System.out.println(item.getItemName());
	}
	IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, ItemRenderType.INVENTORY);*/
	
	GL11.glPushMatrix();
	GL11.glTranslatef((float) 0.0F, (float)1.5F, (float)0.0F);
	GL11.glRotatef(180f, 0f, 0f, 1f);
	GL11.glBindTexture(GL11.GL_TEXTURE_2D, FMLClientHandler.instance().getClient().renderEngine.getTexture(Info.TEX_CRATE));				
	mc.render(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	GL11.glPopMatrix();

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
