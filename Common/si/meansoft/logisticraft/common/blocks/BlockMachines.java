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

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import si.meansoft.logisticraft.common.core.Reflector;
import si.meansoft.logisticraft.common.library.Info;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.ForgeHooks;

public class BlockMachines extends Block {

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
	list.add(new ItemStack(this, 1, 0));
	list.add(new ItemStack(this, 1, 3));
	list.add(new ItemStack(this, 1, 4));
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
	if (data == 0) {
	    if (side == 0 || side == 1) { // top and bottom
		return blockIndexInTexture + 3;
	    }
	    else { // sides
		return blockIndexInTexture;
	    }
	}
	else if (data == 1) {
	    if (side == 0 || side == 1) { // top and bottom
		return blockIndexInTexture + 1;
	    }
	    else { // sides
		return blockIndexInTexture;
	    }
	}
	else if (data == 2) {
	    return 28;
	}
	else if (data == 3) {
	    return blockIndexInTexture - 5;
	}
	else if (data == 4) {
	    if (side == 0) { // bottom
		return blockIndexInTexture - 8;
	    }
	    else if (side == 1) { // Top
		return blockIndexInTexture - 6;
	    }
	    else { // sides
		return blockIndexInTexture - 7;
	    }
	}
	else if (data == 5) {
	    if (side == 0) { // bottom
		return blockIndexInTexture - 8;
	    }
	    else if (side == 1) { // Top
		return blockIndexInTexture - 22;
	    }
	    else { // sides
		return blockIndexInTexture - 23;
	    }
	}
	else {
	    return 0;
	}
    }

    public boolean isOpaqueCube() {
	return false;
    }

    public int tickRate() {
	return 6;
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

    public void onBlockAdded(World world, int x, int y, int z) {
	int mb = world.getBlockMetadata(x, y, z);
	if (!world.isRemote) {
	    if (mb == 0 || mb == 1) {
		Material mat = world.getBlockMaterial(x, y - 1, z);
		if (isActive(world, x, y, z) && (mat == Material.lava)) {
		    world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, 1);
		    world.setBlockMetadataWithNotify(x, y - 1, z, 2);
		    expand(world, x, y - 1, z);
		}
		else {
		    onState = false;
		    world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, 0);
		}
	    }
	    else if (mb == 4 || mb == 5) {
		world.setBlockAndMetadata(x, y, z, blockID, 0);
		update(world, x, y, z);
	    }
	    else if (mb == 3) {
		if (isActive(world, x, y, z)) {
		    world.setWorldTime(1000);
		    EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
		    player.sendChatToPlayer("Setting time to day!");
		}
	    }
	}
    }

    public void onBlockRemoval(World world, int x, int y, int z) {
	if (!world.isRemote) {
	    if (world.getBlockMetadata(x, y, z) == 4 || world.getBlockMetadata(x, y, z) == 5) {
		update(world, x, y, z);
	    }
	}
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID) {
	int mb = world.getBlockMetadata(x, y, z);
	if (!world.isRemote) {
	    if (mb == 0 || mb == 1) {
		Material mat = world.getBlockMaterial(x, y - 1, z);
		if (isActive(world, x, y, z) && (mat == Material.lava)) {
		    world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, 1);
		    world.setBlockMetadataWithNotify(x, y - 1, z, 2);
		    expand(world, x, y - 1, z);
		}
		else {
		    onState = false;
		    world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, 0);
		}
	    }
	    else if (mb == 4 || mb == 5) {
		update(world, x, y, z);
	    }
	    else if (mb == 3) {
		if (isActive(world, x, y, z)) {
		    world.setWorldTime(1000);
		    EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
		    player.sendChatToPlayer("Setting time to day!");
		    //world.spawnParticle("portal", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 0.0D);
		    //world.spawnParticle("largesmoke", player.posX, player.posY, player.posZ, 0.0D, 1.0D, 0.0D);
		}
	    }
	}
    }

    public boolean update(World world, int x, int y, int z) {
	if (!world.isRemote) {
	    boolean isActive = Reflector.findReflector(world, x, y, z);

	    setMetadata(world, x, y, z, isActive);

	    if (isActive) {
		Reflector.add(world, x, y + 1, z);
	    }
	    else {
		Reflector.remove(world, x, y + 1, z);
	    }
	}
	return true;
    }

    public void setMetadata(World world, int x, int y, int z, boolean isActive) {
	int oldMeta = world.getBlockMetadata(x, y, z);
	int newMeta = (oldMeta & 0xe) | (isActive ? 5 : 4);
	if (oldMeta != newMeta) {
	    world.setBlockMetadata(x, y, z, newMeta);
	    world.markBlockNeedsUpdate(x, y, z);
	}
    }

    public boolean isActive(World world, int x, int y, int z) {
	return world.isBlockIndirectlyGettingPowered(x, y, z);
    }

    private void expand(World world, int i, int j, int k) {
	if (!world.isRemote) {
	    int l = world.getBlockMetadata(i, j, k);
	    int i1 = world.getBlockId(i - 1, j, k);
	    int j1 = world.getBlockId(i + 1, j, k);
	    int k1 = world.getBlockId(i, j - 1, k);
	    int l1 = world.getBlockId(i, j + 1, k);
	    int i2 = world.getBlockId(i, j, k - 1);
	    int j2 = world.getBlockId(i, j, k + 1);
	    if (ignoreTick(l, i1)) {
		world.setBlockAndMetadata(i - 1, j, k, blockID, l);
		world.scheduleBlockUpdate(i - 1, j, k, blockID, tickRate());
	    }

	    if (ignoreTick(l, j1)) {
		world.setBlockAndMetadata(i + 1, j, k, blockID, l);
		world.scheduleBlockUpdate(i + 1, j, k, blockID, tickRate());
	    }

	    if (ignoreTick(l, k1)) {
		world.setBlockAndMetadata(i, j - 1, k, blockID, l);
		world.scheduleBlockUpdate(i, j - 1, k, blockID, tickRate());
	    }

	    if (ignoreTick(l, l1)) {
		world.setBlockAndMetadata(i, j + 1, k, blockID, l);
		world.scheduleBlockUpdate(i, j + 1, k, blockID, tickRate());
	    }

	    if (ignoreTick(l, i2)) {
		world.setBlockAndMetadata(i, j, k - 1, blockID, l);
		world.scheduleBlockUpdate(i, j, k - 1, blockID, tickRate());
	    }

	    if (ignoreTick(l, j2)) {
		world.setBlockAndMetadata(i, j, k + 1, blockID, l);
		world.scheduleBlockUpdate(i, j, k + 1, blockID, tickRate());
	    }
	}
    }

    public void updateTick(World world, int i, int j, int k, Random random) {
	if (!world.isRemote) {
	    if (world.getBlockId(i, j, k) == this.blockID && world.getBlockMetadata(i, j, k) == 2) {
		expand(world, i, j, k);
		world.setBlockWithNotify(i, j, k, 0);
	    }
	}
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int par2, int par3, int par4, Random random) {
	int var5 = 8;
	int var6;
	float var7;
	float var8;
	float var9;
	double doub = 0.0D;
	if (world.getBlockMetadata(par2, par3, par4) == 2) {
	    for (var6 = 0; var6 < var5; ++var6) {
		var7 = (float) par2 + random.nextFloat() * 0.1F;
		var8 = (float) par3 + random.nextFloat();
		var9 = (float) par4 + random.nextFloat();
		world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, doub, doub, doub);

		var7 = (float) (par2 + 1) - random.nextFloat() * 0.1F;
		var8 = (float) par3 + random.nextFloat();
		var9 = (float) par4 + random.nextFloat();
		world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, doub, doub, doub);

		var7 = (float) par2 + random.nextFloat();
		var8 = (float) par3 + random.nextFloat();
		var9 = (float) par4 + random.nextFloat() * 0.1F;
		world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, doub, doub, doub);

		var7 = (float) par2 + random.nextFloat();
		var8 = (float) par3 + random.nextFloat();
		var9 = (float) (par4 + 1) - random.nextFloat() * 0.1F;
		world.spawnParticle("largesmoke", (double) var7, (double) var8, (double) var9, doub, doub, doub);

		var7 = (float) par2 + random.nextFloat();
		var8 = (float) par3 + random.nextFloat() * 0.5F + 0.5F;
		var9 = (float) par4 + random.nextFloat();
		world.spawnParticle("largesmoke", (double) par2, (double) var8, (double) par4, doub, doub, doub);
	    }
	}
    }
}
