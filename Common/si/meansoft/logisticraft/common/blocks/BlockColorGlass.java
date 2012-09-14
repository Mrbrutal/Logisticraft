package si.meansoft.logisticraft.common.blocks;

import java.util.List;
import java.util.Random;

import si.meansoft.logisticraft.common.core.Reflector;
import si.meansoft.logisticraft.common.library.Info;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class BlockColorGlass extends Block{

	public BlockColorGlass(int par1, int par2, Material mat) {
		super(par1, par2, mat);
		blockIndexInTexture = par2;
		setBlockName("Colored glass");
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
    public String getTextureFile() {
    	return Info.TEX_BLOCK;
    }
	
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		if(this.blockID == LCBlocks.coloredGlass.blockID) {
	        for (int var4 = 0; var4 < 16; ++var4) {
	            par3List.add(new ItemStack(this, 1, var4));
	        }
		}
    }
	
	public int quantityDropped(Random par1Random) {
		return 0;
	}
	
	public int getBlockTextureFromSideAndMetadata(int side, int data) {
		if(this.blockID == LCBlocks.coloredGlass.blockID) {
			int base = blockIndexInTexture;
		}
		else {
			int base = blockIndexInTexture - 16;
		}
		switch(data) {
		case 0: return blockIndexInTexture;
		case 1: return blockIndexInTexture+1;
		case 2: return blockIndexInTexture+2;
		case 3: return blockIndexInTexture+3;
		case 4: return blockIndexInTexture+4;
		case 5: return blockIndexInTexture+5;
		case 6: return blockIndexInTexture+6;
		case 7: return blockIndexInTexture+7;
		case 8: return blockIndexInTexture+8;
		case 9: return blockIndexInTexture+9;
		case 10: return blockIndexInTexture+10;
		case 11: return blockIndexInTexture+11;
		case 12: return blockIndexInTexture+12;
		case 13: return blockIndexInTexture+13;
		case 14: return blockIndexInTexture+14;
		case 15: return blockIndexInTexture+15;
		default: return blockIndexInTexture+15;
		}
	}
	
	public int getRenderBlockPass() {
		return 1;
    }
	
	public boolean isOpaqueCube() {
        return false;
    }
	
	protected boolean canSilkHarvest() {
		if(this.blockID == LCBlocks.beam.blockID) {
			return false;
		}
		else {
			return true;
		}
    }
	
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3D, Vec3 par6Vec3D) {
		if(this.blockID == LCBlocks.beam.blockID) {
			return null;
		}
		else {
			return super.collisionRayTrace(par1World, par2,  par3, par4, par5Vec3D, par6Vec3D);
		}
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		if(this.blockID == LCBlocks.beam.blockID) {
			return null;
		}
		else {
			return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
		}
    }
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) {
		if(this.blockID == LCBlocks.beam.blockID) {
			if (Reflector.findReflector(world, x, y-1, z)) {
				Reflector.add(world, x, y+1, z);
			}
			else {
				Reflector.remove(world, x, y, z);
			}
		}
	}
	
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		if(this.blockID == LCBlocks.beam.blockID) {
			return false;
		}
		else {
			return true;
		}
    }
	
	public boolean isBlockReplacable() {
		if(this.blockID == LCBlocks.beam.blockID) {
			return true;
		}
		else {
			return false;
		}
	}
}
