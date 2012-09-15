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
import si.meansoft.logisticraft.common.core.Crate;
import si.meansoft.logisticraft.common.items.LCItems;
import si.meansoft.logisticraft.common.library.*;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCrate extends Block {

	public BlockCrate(int par1, int par2) {
		super(par1, par2, Material.rock);
		blockIndexInTexture = par2;
		setTickRandomly(true);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public String getTextureFile() {
		return Info.TEX_BLOCK;
	}

	/*@Override 
	public int getRenderType() { 
		return RenderIDs.crateID; 
	} */

	@SideOnly(Side.CLIENT)
	public int getBlockTextureFromSideAndMetadata(int side, int data) {
		int base = blockIndexInTexture;
		switch (data) {
		case 0:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 1;
			}
		case 1:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 2;
			}
		case 2:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 3;
			}
		case 3:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 4;
			}
		case 4:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 5;
			}
		case 5:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 6;
			}
		case 6:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 7;
			}
		case 7:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 8;
			}
		case 8:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 9;
			}
		case 9:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 10;
			}
		case 10:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 11;
			}
		case 11:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 12;
			}
		case 12:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 13;
			}
		case 13:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 14;
			}
		case 14:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 15;
			}
		case 15:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base - 1;
			}
		default:
			if (side == 0 || side == 1) { // top and bottom
				return base;
			} else { // sides
				return base + 1;
			}
		}
	}

	public int idDropped(int par1, Random random, int par3) {
		return 0;
	}

	protected int damageDropped(int i) {
		return i;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}

	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs tabs, List list) {
		for (int var4 = 0; var4 < 16; ++var4) {
			list.add(new ItemStack(this, 1, var4));
		}
	}

	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		if (par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().getItem() == LCItems.knife) {
			this.dropBlockAsItem_do(par1World, par3, par4, par5, this.createStackedBlock(par6));
			super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
		}
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		// this.tryToFall(world, x, y, z);
		int getId = world.getBlockId(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		int crate = LCBlocks.crate.blockID;
		if (getId == crate && meta != 0) {
			if (Crate.checkRain(world, x, y, z)) {
				world.setBlockAndMetadataWithNotify(x, y, z, crate, 0);
			}

			if (Crate.checkWater(world, x, y, z)) {
				world.setBlockAndMetadataWithNotify(x, y, z, crate, 0);
			}

			if (meta == 5 || meta == 10 || meta == 11 || meta == 12 || meta == 13) {
				if (!Crate.checkIce(world, x, y, z)) {
					world.setBlockAndMetadataWithNotify(x, y, z, crate, 0);
				}
			}
		}
	}
}
