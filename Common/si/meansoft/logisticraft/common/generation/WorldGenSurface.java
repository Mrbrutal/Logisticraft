package si.meansoft.logisticraft.common.generation;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenSurface implements IWorldGenerator {

	public WorldGenSurface() {}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		WorldGenMelon watermelon = new WorldGenMelon(Block.melon.blockID);
		
		int xCoord = chunkX;
		int zCoord = chunkZ;
		int yCoord = world.getTopSolidOrLiquidBlock(xCoord, zCoord);
		
		if (random.nextInt(16) == 0) {
            int var2 = chunkX + random.nextInt(16) + 8;
            int var3 = random.nextInt(256);
            int var4 = chunkZ + random.nextInt(16) + 8;
            watermelon.generate(world, random, var2, var3, var4);
        }		
	}

}
