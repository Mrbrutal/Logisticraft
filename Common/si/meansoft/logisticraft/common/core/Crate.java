package si.meansoft.logisticraft.common.core;

import si.meansoft.logisticraft.common.blocks.LCBlocks;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class Crate {

    /* True == OK, False == NOT OK */

    public static boolean checkIce(World world, int x, int y, int z) {
	int size = 3;
	for (int var5 = x - size; var5 <= x + size; ++var5) {
	    for (int var6 = y - size; var6 <= y + size; ++var6) {
		for (int var7 = z - size; var7 <= z + size; ++var7) {
		    if (world.getBlockId(var5, var6, var7) == Block.ice.blockID || world.getBlockId(var5, var6, var7) == Block.blockSnow.blockID || world.getBlockId(var5, var6, var7) == Block.snow.blockID) {
			return true;
		    }
		}
	    }
	}

	return false;
    }

    public static boolean checkWater(World world, int x, int y, int z) {
	Material up = world.getBlockMaterial(x, y + 1, z);
	Material dn = world.getBlockMaterial(x, y - 1, z);
	Material so = world.getBlockMaterial(x - 1, y, z);
	Material no = world.getBlockMaterial(x + 1, y, z);
	Material ea = world.getBlockMaterial(x, y, z - 1);
	Material we = world.getBlockMaterial(x, y, z + 1);

	Material ma = Material.water;

	int md = world.getBlockMetadata(x, y, z);
	int bl = world.getBlockId(x, y, z);

	if ((bl == LCBlocks.crate.blockID) || (bl == LCBlocks.crate2.blockID) || (bl == LCBlocks.crate3.blockID) || (bl == LCBlocks.crate4.blockID) || (bl == LCBlocks.box.blockID) || (bl == LCBlocks.box2.blockID) || (bl == LCBlocks.box3.blockID) || (bl == LCBlocks.box4.blockID)) {
	    if ((up == ma) || (dn == ma) || (so == ma) || (no == ma) || (ea == ma) || (we == ma)) {
		return true;
	    }
	    else {
		return false;
	    }
	}
	else {
	    return false;
	}
    }

    public static boolean checkRain(World world, int x, int y, int z) {
	int bl = world.getBlockId(x, y, z);
	int md = world.getBlockMetadata(x, y, z);
	boolean blockAbove = false;
	y++;

	if (!world.isRemote) {
	    if ((bl == LCBlocks.crate.blockID && (md != 15 || md != 14 || md != 7)) || (bl == LCBlocks.crate2.blockID) || (bl == LCBlocks.crate3.blockID) || (bl == LCBlocks.crate4.blockID) || bl == LCBlocks.box.blockID || bl == LCBlocks.box2.blockID || bl == LCBlocks.box3.blockID || bl == LCBlocks.box4.blockID) {
		while (blockAbove != true && y <= (y + (256 - y))) {
		    if (!world.isAirBlock(x, y, z)) {
			blockAbove = true;
			break;
		    }
		    else {
			y++;
		    }
		}
	    }
	}
	return blockAbove;
    }
}
