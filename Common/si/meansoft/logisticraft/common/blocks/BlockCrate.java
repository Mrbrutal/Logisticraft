/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import java.util.ArrayList;
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
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCrate extends Block {

    public BlockCrate(int i, int j) {
	super(i, j, Material.grass);
	blockIndexInTexture = j;
	setTickRandomly(true);
	setCreativeTab(CreativeTabs.tabBlock);
	setHardness(1.0F);
    }

    @Override
    public String getTextureFile() {
	return Info.TEX_CRATES;
    }

    // @Override public int getRenderType() { return RenderIDs.crateID; }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
	if (this.blockID == LCBlocks.crate.blockID) {
	    ret.add(new ItemStack(LCBlocks.box, 9, this.damageDropped(metadata)));
	}
	else if (this.blockID == LCBlocks.crate2.blockID) {
	    ret.add(new ItemStack(LCBlocks.box2, 9, this.damageDropped(metadata)));
	}
	else if (this.blockID == LCBlocks.crate3.blockID) {
	    ret.add(new ItemStack(LCBlocks.box3, 9, this.damageDropped(metadata)));
	}
	else if (this.blockID == LCBlocks.crate4.blockID) {
	    ret.add(new ItemStack(LCBlocks.box4, 9, this.damageDropped(metadata)));
	}
	else if (this.blockID == LCBlocks.crate5.blockID) {
	    ret.add(new ItemStack(LCBlocks.box5, 9, this.damageDropped(metadata)));
	}
	else if (this.blockID == LCBlocks.crate6.blockID) {
	    ret.add(new ItemStack(LCBlocks.box6, 9, this.damageDropped(metadata)));
	}
	else {
	    ret.add(new ItemStack(LCBlocks.box7, 9, this.damageDropped(metadata)));
	}
	return ret;
    }

    @SideOnly(Side.CLIENT)
    public int getBlockTextureFromSideAndMetadata(int side, int data) {
	int base = blockIndexInTexture;
	int top = 255;
	switch (data) {
	case 0:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base;
	    }
	case 1:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 1;
	    }
	case 2:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 2;
	    }
	case 3:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 3;
	    }
	case 4:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 4;
	    }
	case 5:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 5;
	    }
	case 6:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 6;
	    }
	case 7:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 7;
	    }
	case 8:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 8;
	    }
	case 9:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 9;
	    }
	case 10:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 10;
	    }
	case 11:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 11;
	    }
	case 12:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 12;
	    }
	case 13:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 13;
	    }
	case 14:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 14;
	    }
	case 15:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return base + 15;
	    }
	default:
	    if (side == 0 || side == 1) { // top and bottom
		return top;
	    }
	    else { // sides
		return top;
	    }
	}
    }

    @Override
    public void getSubBlocks(int par1, CreativeTabs tabs, List list) {
	int size = 16;
	for (int var4 = 0; var4 < size; ++var4) {
	    list.add(new ItemStack(this, 1, var4));
	}
    }

    public int damageDropped(int i) {
	return i;
    }

    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
	if (par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().getItem() == LCItems.knife) {
	    this.dropBlockAsItem_do(par1World, par3, par4, par5, this.createStackedBlock(par6));
	}
	else {
	    super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	}
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
	int getId = world.getBlockId(x, y, z);
	int meta = world.getBlockMetadata(x, y, z);
	int crate = LCBlocks.chimney.blockID;
	if (world.isRaining()) {
	    if (!Crate.checkRainCrate(world, x, y, z)) {
		world.setBlockAndMetadataWithNotify(x, y, z, crate, 4);
	    }
	}

	if (Crate.checkWaterCrate(world, x, y, z)) {
	    world.setBlockAndMetadataWithNotify(x, y, z, crate, 4);
	}
	
	if (this.blockID == LCBlocks.crate.blockID) {
	    if (meta == 4 || meta == 9 || meta == 10 || meta == 11 || meta == 12) {
		if (!Crate.checkIce(world, x, y, z)) {
		    world.setBlockAndMetadataWithNotify(x, y, z, crate, 4);
		}
	    }
	}
    }
}
