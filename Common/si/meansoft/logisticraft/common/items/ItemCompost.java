/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.library.Info;
import net.minecraft.src.Block;
import net.minecraft.src.BlockCrops;
import net.minecraft.src.BlockDirectional;
import net.minecraft.src.BlockMushroom;
import net.minecraft.src.BlockSapling;
import net.minecraft.src.BlockStem;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class ItemCompost extends Item {

    protected ItemCompost(int par1) {
	super(par1);
	setMaxStackSize(64);
	setCreativeTab(CreativeTabs.tabMaterials);
	setTextureFile(Info.TEX_ITEM);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer entity, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
	int var11 = world.getBlockId(par4, par5, par6);
	int var12;

	BonemealEvent event = new BonemealEvent(entity, world, var11, par4, par5, par6);
	if (MinecraftForge.EVENT_BUS.post(event)) {
	    return false;
	}

	if (event.hasResult()) {
	    if (!world.isRemote) {
		stack.stackSize--;
	    }
	    return true;
	}

	if (var11 == Block.sapling.blockID) {
	    if (!world.isRemote) {
		((BlockSapling) Block.sapling).growTree(world, par4, par5, par6, world.rand);
		--stack.stackSize;
	    }

	    return true;
	}

	if (var11 == Block.mushroomBrown.blockID || var11 == Block.mushroomRed.blockID) {
	    if (!world.isRemote && ((BlockMushroom) Block.blocksList[var11]).fertilizeMushroom(world, par4, par5, par6, world.rand)) {
		--stack.stackSize;
	    }

	    return true;
	}

	if (var11 == Block.melonStem.blockID || var11 == Block.pumpkinStem.blockID || var11 == LCBlocks.cantaloupeStem.blockID) {
	    if (world.getBlockMetadata(par4, par5, par6) == 7) {
		return false;
	    }

	    if (!world.isRemote) {
		((BlockStem) Block.blocksList[var11]).fertilizeStem(world, par4, par5, par6);
		--stack.stackSize;
	    }

	    return true;
	}

	if (var11 == Block.crops.blockID) {
	    if (world.getBlockMetadata(par4, par5, par6) == 7) {
		return false;
	    }

	    if (!world.isRemote) {
		((BlockCrops) Block.crops).fertilize(world, par4, par5, par6);
		--stack.stackSize;
	    }

	    return true;
	}

	if (var11 == Block.cocoaPlant.blockID) {
	    if (!world.isRemote) {
		world.setBlockMetadataWithNotify(par4, par5, par6, 8 | BlockDirectional.getDirection(world.getBlockMetadata(par4, par5, par6)));
		--stack.stackSize;
	    }

	    return true;
	}

	if (var11 == Block.dirt.blockID) {
	    if (!world.isRemote) {
		--stack.stackSize;
		int size = 2;
		
		for (int i = par4-size; i < par4 + size; i++) {
		    for (int j = par6-size; j < par6 + size; j++) {
			if(world.getBlockId(i, par5, j) == Block.dirt.blockID) {
			    world.setBlockWithNotify(i, par5, j, Block.grass.blockID);
			}
		    }
		}
	    }

	    return true;
	}
	return true;
    }

}
