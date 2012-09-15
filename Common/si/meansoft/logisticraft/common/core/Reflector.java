package si.meansoft.logisticraft.common.core;

import si.meansoft.logisticraft.common.blocks.BlockMachines;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import net.minecraft.src.*;

public class Reflector {
	
	public static boolean findReflector(World world, int x, int y, int z) {
		int height = world.getHeight();
		while(y<height) {
			if(world.getBlockId(x, y, z) == LCBlocks.machines.blockID && (world.getBlockMetadata(x, y, z) == 4 || world.getBlockMetadata(x, y, z) == 5)){
				BlockMachines block = (BlockMachines)Block.blocksList[world.getBlockId(x, y, z)];
				return block.isActive(world, x, y, z);
			}
			else if(world.getBlockId(x, y, z) == LCBlocks.beam.blockID) {
				return true;
			}
			else if(world.getBlockId(x, y, z) == 0 || Block.blocksList[world.getBlockId(x, y, z)].isOpaqueCube()){
				return false;
			}
			y--;
		}
		return false;
	}
	
	public static void add(World world, int x, int y, int z) {
		turnLight(world, LCBlocks.beam.blockID, 0, x, y, z);
	}
	
	public static void remove(World world, int x, int y, int z) {
		turnLight(world, 0, LCBlocks.beam.blockID, x, y, z);
	}
	
	public static void turnLight(World world, int blockNew, int blockOld, int x, int y, int z) {
		while(y <= world.getHeight()) {
			if(world.getBlockId(x, y, z) == blockOld) {
				world.setBlockAndMetadataWithNotify(x, y, z, blockNew, 2); // Beam color
			}
			else if (world.getBlockId(x, y, z) != 0 && Block.blocksList[world.getBlockId(x, y, z)].isOpaqueCube()){
				break;
			}
			y++;
		}
	}
}

