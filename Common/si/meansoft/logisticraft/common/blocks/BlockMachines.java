/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import si.meansoft.logisticraft.common.library.Info;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockMachines extends Block{
	
	public boolean onState;
	public boolean finished = false;
	
	public BlockMachines(int par1, int par2, boolean state) {
		super(par1, Material.iron);
		setStepSound(soundMetalFootstep);
		setHardness(2.0F);
		setResistance(1.0F);
		blockIndexInTexture = par2;
		onState = state;
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
    public String getTextureFile() {
    	return Info.TEX_BLOCK;
    }
	
	@Override
    public void getSubBlocks(int par1, CreativeTabs tabs, List list) {
        for (int var4 = 0; var4 < 3; ++var4) {
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
        return 0;
    }
	
	public int getBlockTextureFromSideAndMetadata(int side, int data) {
		if(data == 0) {
			if(side == 0 || side == 1) { //top and bottom
				return blockIndexInTexture + 1;
			}
			else {						 //sides
				return blockIndexInTexture;
			}
		}
		if(data == 2) {
			return 27;
		}
		else {
			if(side == 0 || side == 1) { //top and bottom
				return blockIndexInTexture + 2;
			}
			else {						 //sides
				return blockIndexInTexture;
			}
		}
	}
	
	public boolean isOpaqueCube() {
        return false;
    }
	
    public int tickRate() {
        return 10;
    }
	
    private boolean ignoreTick(int i, int j) {
        if (i == 2) {
            return j == Block.lavaStill.blockID || j == Block.lavaMoving.blockID;
        }
        else {
        	finished = true;
        }
        return false;
    }
    
    private void expand(World world, int i, int j, int k) {
        if(!world.isRemote) {
            int l = world.getBlockMetadata(i, j, k);
            int i1 = world.getBlockId(i - 1, j, k);
            int j1 = world.getBlockId(i + 1, j, k);
            int k1 = world.getBlockId(i, j - 1, k);
            int l1 = world.getBlockId(i, j + 1, k);
            int i2 = world.getBlockId(i, j, k - 1);
            int j2 = world.getBlockId(i, j, k + 1);
            if(ignoreTick(l, i1)) {
                world.setBlockAndMetadata(i - 1, j, k, blockID, l);
                world.scheduleBlockUpdate(i - 1, j, k, blockID, tickRate());
            }
            
            if(ignoreTick(l, j1)) {
                world.setBlockAndMetadata(i + 1, j, k, blockID, l);
                world.scheduleBlockUpdate(i + 1, j, k, blockID, tickRate());
            }
            
            if(ignoreTick(l, k1)) {
                world.setBlockAndMetadata(i, j - 1, k, blockID, l);
                world.scheduleBlockUpdate(i, j - 1, k, blockID, tickRate());
            }
            
            if(ignoreTick(l, l1)) {
                world.setBlockAndMetadata(i, j + 1, k, blockID, l);
                world.scheduleBlockUpdate(i, j + 1, k, blockID, tickRate());
            }
            
            if(ignoreTick(l, i2)) {
                world.setBlockAndMetadata(i, j, k - 1, blockID, l);
                world.scheduleBlockUpdate(i, j, k - 1, blockID, tickRate());
            }
            
            if(ignoreTick(l, j2)) {
                world.setBlockAndMetadata(i, j, k + 1, blockID, l);
                world.scheduleBlockUpdate(i, j, k + 1, blockID, tickRate());
            }
        }
    }
    
    public void updateTick(World world, int i, int j, int k, Random random) {
        if(!world.isRemote){
	    	if(world.getBlockId(i, j, k) == this.blockID) {
	        	expand(world, i, j, k);
	            world.setBlockWithNotify(i, j, k, 0);
	        }
        }
    }
    
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer player) {
		Random random = new Random();
		if (!world.isRemote) {
	    	if(world.getBlockMetadata(i, j, k) == 0 || world.getBlockMetadata(i, j, k) == 1) {
		    	if (!onState) {
		    		world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 1);
		    		int l = world.getBlockId(i, j - 1, k);
		            byte byte0 = -1;
		            if(l == Block.lavaStill.blockID || l == Block.lavaMoving.blockID) {
		            	onState = true;
		                byte0 = 2;
		            }
		            if(byte0 == -1) {
		                world.setBlockAndMetadataWithNotify(i, j, k, blockID, 0);
		                return true;
		            } 
		            else {
		                world.setBlockMetadataWithNotify(i, j, k, byte0);
		                expand(world, i, j, k);
		                world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 1);
		                return true;
		            }
		    		
		    	}
		    	else if(finished) {
		    		onState = false;
		    		world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 0);
		    	}
		    	else {
		    		onState = false;
		    		world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 0);
		    	}
	    	}
	    }
		return true;
	}
	
	//@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int par2, int par3, int par4, Random random) {
		if(!world.isRemote) {
			int var5 = 8;
			int var6;
	        float var7;
	        float var8;
	        float var9;
	        double doub = 0.0D;
			if(world.getBlockMetadata(par2, par3, par4) == 1) {
	            for (var6 = 0; var6 < var5; ++var6) {
	            	var7 = (float)par2 + random.nextFloat() * 0.1F;
	                var8 = (float)par3 + random.nextFloat();
	                var9 = (float)par4 + random.nextFloat();
	                world.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, doub, doub, doub);
	            	
	            	var7 = (float)(par2 + 1) - random.nextFloat() * 0.1F;
	                var8 = (float)par3 + random.nextFloat();
	                var9 = (float)par4 + random.nextFloat();
	                world.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, doub, doub, doub);
	            	
	            	var7 = (float)par2 + random.nextFloat();
	                var8 = (float)par3 + random.nextFloat();
	                var9 = (float)par4 + random.nextFloat() * 0.1F;
	                world.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, doub, doub, doub);
	                
	                var7 = (float)par2 + random.nextFloat();
	                var8 = (float)par3 + random.nextFloat();
	                var9 = (float)(par4 + 1) - random.nextFloat() * 0.1F;
	                world.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, doub, doub, doub);
	                
	                var7 = (float)par2 + random.nextFloat();
		            var8 = (float)par3 + random.nextFloat() * 0.5F + 0.5F;
		            var9 = (float)par4 + random.nextFloat();
		            world.spawnParticle("largesmoke", (double)par2, (double)var8, (double)par4, doub, doub, doub);
	            }
			}
		}
    }
}
