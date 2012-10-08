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
    private RenderBlocks renderBlocks = new RenderBlocks();
    private ModelCrate moc = new ModelCrate();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	/*Tessellator tessellator = Tessellator.instance;
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
	GL11.glTranslatef(0.5F, 0.5F, 0.5F);*/
	
	Item item = Info.items[metadata];
	ItemStack itemstack = new ItemStack(item);
	IItemRenderer ren = MinecraftForgeClient.getItemRenderer(itemstack, ItemRenderType.INVENTORY);
	
	GL11.glPushMatrix();
	GL11.glTranslatef((float) 0.0F, (float)1.0F, (float)0.0F);
	GL11.glRotatef(180f, 0f, 0f, 1f);
	GL11.glBindTexture(GL11.GL_TEXTURE_2D, FMLClientHandler.instance().getClient().renderEngine.getTexture(Info.TEX_CRATE));				
	moc.render(0.0625F);
	GL11.glPopMatrix();
	
	GL11.glBindTexture(GL11.GL_TEXTURE_2D, FMLClientHandler.instance().getClient().renderEngine.getTexture("/gui/items.png"));
	
	if(ren != null) {
	    System.out.println("Rendering item!");
	    GL11.glDisable(GL11.GL_LIGHTING);
	    GL11.glDisable(GL11.GL_LIGHT0);
	    GL11.glDisable(GL11.GL_LIGHT1);
	    GL11.glDisable(GL11.GL_COLOR_MATERIAL);


	    GL11.glPushMatrix();

	    ren.renderItem(ItemRenderType.INVENTORY, itemstack, renderBlocks);

	    GL11.glPopMatrix();

	    GL11.glEnable(GL11.GL_LIGHTING);
	    GL11.glEnable(GL11.GL_LIGHT0);
	    GL11.glEnable(GL11.GL_LIGHT1);
	    GL11.glEnable(GL11.GL_COLOR_MATERIAL);
	}
	
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
	Tessellator teselator = Tessellator.instance;
	
	renderer.renderStandardBlock(block, x, y, z);

	int meta = world.getBlockMetadata(x, y, z);
	Item item = Info.items[meta];
	ItemStack itemstack = new ItemStack(item);
	IItemRenderer ren = MinecraftForgeClient.getItemRenderer(itemstack, ItemRenderType.INVENTORY);
	
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
