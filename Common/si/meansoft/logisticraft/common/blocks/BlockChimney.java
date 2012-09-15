package si.meansoft.logisticraft.common.blocks;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.google.common.util.concurrent.SettableFuture;

import si.meansoft.logisticraft.common.library.Info;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockChimney extends Block {

	public BlockChimney(int par1, int par2) {
		super(par1, par2, Material.rock);
		setStepSound(soundStoneFootstep);
		setHardness(2.0F);
		setResistance(1.0F);
		blockIndexInTexture = par2;
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
    public String getTextureFile() {
    	return Info.TEX_BLOCK;
    }
	
	@Override
    public void getSubBlocks(int par1, CreativeTabs tabs, List list) {
        for (int var4 = 0; var4 < 2; ++var4) {
            list.add(new ItemStack(this, 1, var4));
        }
    }
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}
	
	public int quantityDropped(Random par1Random) {
		return 1;
	}
	
	protected int damageDropped(int i) {
        return i;
    }
	
	public int getBlockTextureFromSideAndMetadata(int side, int data) {
		if(data == 0) {
			if(side == 0 || side == 1) { //top and bottom
				return blockIndexInTexture;
			}
			else {						 //sides
				return blockIndexInTexture + 1;
			}
		}
		if(data == 1) {
			if(side == 0) { //top and bottom
				return blockIndexInTexture;
			}
			else if(side == 1) {
				return blockIndexInTexture + 3;
			}
			else {						 //sides
				return blockIndexInTexture + 2;
			}
		}
		else {
			if(side == 0 || side == 1) { //top and bottom
				return blockIndexInTexture;
			}
			else {						 //sides
				return blockIndexInTexture + 1;
			}
		}
	}
	
	public int tickRate() {
        return 2;
    }
	
	public void onBlockAdded(World world, int par2, int par3, int par4) {
        if (!world.isRemote) {
            if (!world.isRemote && (world.getBlockId(par2, par3+1, par4) != this.blockID && world.getBlockId(par2, par3-1, par4) == this.blockID)) {
            	world.setBlockAndMetadataWithNotify(par2, par3, par4, this.blockID, 1);
            	world.setBlockAndMetadataWithNotify(par2, par3-1, par4, this.blockID, 0);
            }
            else if(!world.isRemote && (world.getBlockId(par2, par3+1, par4) == this.blockID && world.getBlockId(par2, par3-1, par4) == this.blockID)){
            	world.setBlockAndMetadataWithNotify(par2, par3, par4, this.blockID, 0);
            	world.setBlockAndMetadataWithNotify(par2, par3-1, par4, this.blockID, 0);
            }
            else if(!world.isRemote && (world.getBlockId(par2, par3+1, par4) == this.blockID && world.getBlockId(par2, par3-1, par4) != this.blockID)) {
            	world.setBlockAndMetadataWithNotify(par2, par3, par4, this.blockID, 0);
            }
            else {
            	world.setBlockAndMetadataWithNotify(par2, par3, par4, this.blockID, 0);
            }
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int par2, int par3, int par4, Random random) {
		int var5 = 16;
		int var6;
        float var7;
        float var8;
        float var9;
        double spread = random.nextDouble()*0.1 - random.nextDouble()*0.1;
        if(spread >= 1.0D) {
        	spread -= 1.0D;
        }
        else if(spread <= -1.0D) {
        	spread += 1.0D;
        }
		if(findFire(world, par2, par3, par4)&& world.getBlockMetadata(par2, par3, par4)==1) {
            for (var6 = 0; var6 < var5; ++var6) {
            	var7 = (float)par2 + random.nextFloat() * 0.1F;
                var8 = (float)par3 + random.nextFloat();
                var9 = (float)par4 + random.nextFloat();
                world.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, spread, spread, spread);
            	
            	var7 = (float)(par2 + 1) - random.nextFloat() * 0.1F;
                var8 = (float)par3 + random.nextFloat();
                var9 = (float)par4 + random.nextFloat();
                world.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, spread, spread, spread);
            	
            	var7 = (float)par2 + random.nextFloat();
                var8 = (float)par3 + random.nextFloat();
                var9 = (float)par4 + random.nextFloat() * 0.1F;
                world.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, spread, spread, spread);
                
                var7 = (float)par2 + random.nextFloat();
                var8 = (float)par3 + random.nextFloat();
                var9 = (float)(par4 + 1) - random.nextFloat() * 0.1F;
                world.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, spread, spread, spread);
                
                var7 = (float)par2 + random.nextFloat();
	            var8 = (float)par3 + random.nextFloat() * 0.5F + 0.5F;
	            var9 = (float)par4 + random.nextFloat();
	            world.spawnParticle("largesmoke", (double)par2, (double)var8, (double)par4, spread, spread, spread);
            }
		}
    }

	private boolean findFire(World world, int par2, int par3, int par4) {
		boolean canSmoke = false;
		int x = par2;
		int y = par3;
		int z = par4;
		while(!canSmoke){
			if(world.getBlockId(x, y, z)==this.blockID) {
				y--;
			}
			else if(world.getBlockId(x, y, z)==Block.fire.blockID || world.getBlockId(x, y, z)==Block.stoneOvenActive.blockID) {
				canSmoke = true;
				break;
			}
			else {
				break;
			}
		}
		return canSmoke;
	}	
}
