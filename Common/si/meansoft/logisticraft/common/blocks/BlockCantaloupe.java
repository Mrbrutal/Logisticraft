/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import java.util.Random;

import si.meansoft.logisticraft.common.items.LCItems;
import si.meansoft.logisticraft.common.library.Info;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCantaloupe extends Block {

    public BlockCantaloupe(int par1, int par2) {
	super(par1, par2, Material.pumpkin);
	setStepSound(soundGrassFootstep);
	setHardness(2.0F);
	setResistance(1.0F);
	blockIndexInTexture = par2;
	setCreativeTab(CreativeTabs.tabBlock);
	setTextureFile(Info.TEX_BLOCK);
    }

    public int getBlockTextureFromSide(int par1) {
	if (par1 == 0 || par1 == 1) {
	    return blockIndexInTexture + 1;
	}
	else {
	    return blockIndexInTexture;
	}
    }

    public int idDropped(int par1, Random par2Random, int par3) {
	return LCItems.cantaloupe.shiftedIndex;
    }

    public int quantityDropped(Random par1Random) {
	return 2 + par1Random.nextInt(5);
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
	if (world.getBlockId(x, y - 1, z) == this.blockID || world.getBlockId(x, y + 1, z) == this.blockID) {
	    return false;
	}
	else {
	    return true;
	}
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
	float var5 = 0.0625F;
	return AxisAlignedBB.getBoundingBox((double) ((float) par2 + var5), (double) par3, (double) ((float) par4 + var5), (double) ((float) (par2 + 1) - var5), (double) ((float) (par3 + 1) - var5), (double) ((float) (par4 + 1) - var5));
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
	float var5 = 0.0625F;
	return AxisAlignedBB.getBoundingBox((double) ((float) par2 + var5), (double) par3, (double) ((float) par4 + var5), (double) ((float) (par2 + 1) - var5), (double) (par3 + 1), (double) ((float) (par4 + 1) - var5));
    }

    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
	if (par5 == 0 && par1IBlockAccess.getBlockMaterial(par2, par3, par4).isOpaque()) {
	    return false;
	}
	else {
	    return true;
	}
    }

    public boolean renderAsNormalBlock() {
	return true;
    }

    public boolean isOpaqueCube() {
	return false;
    }

    public int getRenderType() {
	return 13;
    }

}
