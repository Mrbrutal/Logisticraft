package si.meansoft.logisticraft.common.generation;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.core.handlers.ConfigHandler;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenWorld implements IWorldGenerator {

    WorldGenMelon watermelon;
    WorldGenMelon cantaloupe;

    public WorldGenWorld() {}

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

	watermelon = new WorldGenMelon(Block.melon.blockID);
	if (ConfigHandler.GEN_MELON) {
	    watermelon.watermelon(random, chunkX, chunkZ, world);
	}
	
	cantaloupe = new WorldGenMelon(LCBlocks.cantaloupe.blockID);
	if (ConfigHandler.GEN_CANTALOUPE) {
	    cantaloupe.watermelon(random, chunkX, chunkZ, world);
	}
	

	WorldGenOres CopperOres = new WorldGenOres(LCBlocks.ores.blockID, 2, 10);
	WorldGenOres SilverOres = new WorldGenOres(LCBlocks.ores.blockID, 1, 6);
	WorldGenOres PlatinumOres = new WorldGenOres(LCBlocks.ores.blockID, 0, 3);

	if (ConfigHandler.GEN_ORE_COPPER) {
	    CopperOres.generateVeins(world, random, chunkX * 16, chunkZ * 16, 24, 128);
	}
	if (ConfigHandler.GEN_ORE_SILVER) {
	    SilverOres.generateVeins(world, random, chunkX * 16, chunkZ * 16, 12, 32);
	}
	if (ConfigHandler.GEN_ORE_PLATINUM) {
	    PlatinumOres.generateVeins(world, random, chunkX * 16, chunkZ * 16, 2, 14);
	}
    }
}