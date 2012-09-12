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
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockOres extends Block {

	public BlockOres(int par1, int par2) {
		super(par1, par2, Material.rock);
		blockIndexInTexture = par2;
		setCreativeTab(CreativeTabs.tabBlock);
		/* Separate Hardness and ressistance for diff ores */
		setHardness(2.5F);
		setResistance(3.5F);
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
        return i;
    }
	
	@SideOnly(Side.CLIENT)
	public int getBlockTextureFromSideAndMetadata(int side, int data) {
		switch(data) {
			case 0: return blockIndexInTexture;
			case 1: return blockIndexInTexture + 1;
			case 2: return blockIndexInTexture + 2;
			default: return blockIndexInTexture;
		}
	}
}
