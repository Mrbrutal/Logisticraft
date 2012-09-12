/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import java.util.List;
import java.util.Random;

import si.meansoft.logisticraft.common.items.LCItems;
import si.meansoft.logisticraft.common.library.Info;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockBox extends Block {
	
	public BlockBox(int i, int j) {
		super(i, j, Material.grass);
		blockIndexInTexture = j;
	    setHardness(2.0F);
	    setStepSound(soundGrassFootstep);
	    setResistance(1.0F);
	    setTickRandomly(true);
	    setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
    public String getTextureFile() {
    	return Info.TEX_BLOCK;
    }
	
	public int idDropped(int par1, Random random, int par3) {
		return 0;
	}

	public int quantityDropped(int meta, Random random, int fortune) {
		return 1;
	}
	
	protected int damageDropped(int i) {
        return i;
    }

	public int getBlockTextureFromSideAndMetadata(int side, int data) {
		int base = blockIndexInTexture;
		switch(data) {
		case 0:
			if(side == 0 || side == 1) { //top and bottom
				return base + 1;
			}
			else {						 //sides
				return base;
			}
		case 1:
			if(side == 0 || side == 1) { //top and bottom
				return base + 3;
			}
			else {						 //sides
				return base + 2;
			}
		case 2:
			if(side == 0 || side == 1) { //top and bottom
				return base + 5;
			}
			else {						 //sides
				return base + 4;
			}
		case 3:
			if(side == 0 || side == 1) { //top and bottom
				return base + 7;
			}
			else {						 //sides
				return base + 6;
			}
		case 4:
			if(side == 0 || side == 1) { //top and bottom
				return base + 9;
			}
			else {						 //sides
				return base + 8;
			}
		case 5:
			if(side == 0 || side == 1) { //top and bottom
				return base + 11;
			}
			else {						 //sides
				return base + 10;
			}
		case 6:
			if(side == 0 || side == 1) { //top and bottom
				return base + 13;
			}
			else {						 //sides
				return base + 12;
			}
		case 7:
			if(side == 0 || side == 1) { //top and bottom
				return base + 15;
			}
			else {						 //sides
				return base + 14;
			}
		case 8:
			if(side == 0 || side == 1) { //top and bottom
				return base + 17;
			}
			else {						 //sides
				return base + 16;
			}
		case 9:
			if(side == 0 || side == 1) { //top and bottom
				return base + 19;
			}
			else {						 //sides
				return base + 18;
			}
		case 10:
			if(side == 0 || side == 1) { //top and bottom
				return base + 21;
			}
			else {						 //sides
				return base + 20;
			}
		case 11:
			if(side == 0 || side == 1) { //top and bottom
				return base + 23;
			}
			else {						 //sides
				return base + 22;
			}
		case 12:
			if(side == 0 || side == 1) { //top and bottom
				return base + 25;
			}
			else {						 //sides
				return base + 24;
			}
		case 13:
			if(side == 0 || side == 1) { //top and bottom
				return base + 27;
			}
			else {						 //sides
				return base + 26;
			}
		case 14:
			if(side == 0 || side == 1) { //top and bottom
				return base + 29;
			}
			else {						 //sides
				return base + 28;
			}
		case 15:
			if(side == 0 || side == 1) { //top and bottom
				return base + 31;
			}
			else {						 //sides
				return base + 30;
			}
		default: 
			if(side == 0 || side == 1) { //top and bottom
				return base;
			}
			else {						 //sides
				return base + 1;
			}
		}
	}
	
	@Override
    public void getSubBlocks(int par1, CreativeTabs tabs, List list) {
        for (int var4 = 0; var4 < 15; ++var4) {
            list.add(new ItemStack(this, 1, var4));
        }
    }
	
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		if(par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().getItem() == LCItems.knife){
			this.dropBlockAsItem_do(par1World, par3, par4, par5, this.createStackedBlock(par6));
			super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
		}
    }
	
	protected boolean canSilkHarvest() {
        return true;
    }
}
