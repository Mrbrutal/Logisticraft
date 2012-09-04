/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.generation;

import java.util.Random;

import si.meansoft.logisticraft.common.blocks.LCBlocks;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenOres implements IWorldGenerator {

	private static int bID;
    private static int meta;
    private static int size;
    
    public WorldGenOres(int blockID, int metadata, int sizeOfVein) {
        bID = blockID;
        meta = metadata;
        size = sizeOfVein;
    }
    
    public static boolean generate(World world, Random random, int i, int j, int k) {
        float f = random.nextFloat() * 3.141593F;
        double d = (float)(i + 8) + (MathHelper.sin(f) * (float)size) / 8F;
        double d1 = (float)(i + 8) - (MathHelper.sin(f) * (float)size) / 8F;
        double d2 = (float)(k + 8) + (MathHelper.cos(f) * (float)size) / 8F;
        double d3 = (float)(k + 8) - (MathHelper.cos(f) * (float)size) / 8F;
        double d4 = (j + random.nextInt(3)) - 2;
        double d5 = (j + random.nextInt(3)) - 2;
        for (int l = 0; l <= size; l++) {
            double d6 = d + ((d1 - d) * (double)l) / (double)size;
            double d7 = d4 + ((d5 - d4) * (double)l) / (double)size;
            double d8 = d2 + ((d3 - d2) * (double)l) / (double)size;
            double d9 = (random.nextDouble() * (double)size) / 16D;
            double d10 = (double)(MathHelper.sin(((float)l * 3.141593F) / (float)size) + 1.0F) * d9 + 1.0D;
            double d11 = (double)(MathHelper.sin(((float)l * 3.141593F) / (float)size) + 1.0F) * d9 + 1.0D;
            int i1 = MathHelper.floor_double(d6 - d10 / 2D);
            int j1 = MathHelper.floor_double(d7 - d11 / 2D);
            int k1 = MathHelper.floor_double(d8 - d10 / 2D);
            int l1 = MathHelper.floor_double(d6 + d10 / 2D);
            int i2 = MathHelper.floor_double(d7 + d11 / 2D);
            int j2 = MathHelper.floor_double(d8 + d10 / 2D);
            for (int xGen = i1; xGen <= l1; xGen++) {
                double d12 = (((double)xGen + 0.5D) - d6) / (d10 / 2D);
                if (d12 * d12 >= 1.0D) {
                        continue;
                }
                for (int yGen = j1; yGen <= i2; yGen++) {
                    double d13 = (((double)yGen + 0.5D) - d7) / (d11 / 2D);
                    if (d12 * d12 + d13 * d13 >= 1.0D) {
                    	continue;
                    }
                    for (int zGen = k1; zGen <= j2; zGen++) {
						double d14 = (((double) zGen + 0.5D) - d8) / (d10 / 2D);
						if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && world.getBlockId(xGen, yGen, zGen) == Block.stone.blockID) {
							world.setBlockAndMetadata(xGen, yGen, zGen, bID, meta);
						}
                    }
                }
            }
        }
        return true;
    }
    
    public static boolean generateVeins(World world, Random random, int chunkX, int chunkZ, int rarity, int height) {
   		 for (int i = 0; i < rarity; i++) {
                int hi = random.nextInt(height);
                int randX = chunkX + random.nextInt(16);
                int randZ = chunkZ + random.nextInt(16);
                generate(world, random, randX, hi, randZ);
   		 }
   		 return true;
   	 }
    
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		System.out.println("Block ores are being generated!");
		WorldGenOres oresGen1 = new WorldGenOres(LCBlocks.ores.blockID, 2, 12);
		WorldGenOres oresGen2 = new WorldGenOres(LCBlocks.ores.blockID, 1, 6);
		WorldGenOres oresGen3 = new WorldGenOres(LCBlocks.ores.blockID, 0, 3);
	}

}
