/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.generation;

import java.util.Random;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenMelon extends WorldGenerator {

    private int genBlockId;

    public WorldGenMelon(int par1) {
	this.genBlockId = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
	for (int var6 = 0; var6 < 128; ++var6) {
	    int var7 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
	    int var8 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
	    int var9 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

	    if (par1World.isAirBlock(var7, var8, var9) && (par1World.getBlockId(var7, var8 - 1, var9) == Block.grass.blockID || par1World.getBlockId(var7, var8 - 1, var9) == Block.dirt.blockID) && Block.melon.canPlaceBlockAt(par1World, var7, var8, var9)) {
		par1World.setBlock(var7, var8, var9, genBlockId);
		//System.out.println("Generating melons at " + var7 +" | "+ var8 +" | " + var9);
	    }
	}
	return true;
    }

    public void watermelon(Random random, int chunkX, int chunkZ, World world) {
	BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
	if (b.biomeName.equals("Forest") || b.biomeName.equals("Plains") || b.biomeName.equals("ForestHills") || b.biomeName.equals("Extreme Hills") && !b.getEnableSnow()) {
	    if (random.nextInt(64) == 0) {
		int var2 = chunkX * 16 - random.nextInt(16);
		int var3;
		if(world.getTopSolidOrLiquidBlock(chunkX, chunkZ) > 64) {
		    var3 = world.getTopSolidOrLiquidBlock(chunkX, chunkZ);
		}
		else {
		    var3 = 64 + random.nextInt(16);
		}
		int var4 = chunkZ * 16 - random.nextInt(16);
		generate(world, random, var2, var3, var4);
	    }
	}
    }
}
