package si.meansoft.logisticraft.common.core;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import si.meansoft.logisticraft.common.blocks.LCBlocks;

public class Crate {

    /* True == OK, False == NOT OK */

    public static Block[] boxes = { LCBlocks.box, LCBlocks.box2, LCBlocks.box3, LCBlocks.box4, LCBlocks.box5, LCBlocks.box6, LCBlocks.box7 };
    public static Block[] crates = { LCBlocks.crate, LCBlocks.crate2, LCBlocks.crate3, LCBlocks.crate4, LCBlocks.crate5, LCBlocks.crate6, LCBlocks.crate7 };

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

    public static boolean checkWaterBox(World world, int x, int y, int z) {
	Boolean isBox = false;
	Material up = world.getBlockMaterial(x, y + 1, z);
	Material dn = world.getBlockMaterial(x, y - 1, z);
	Material so = world.getBlockMaterial(x - 1, y, z);
	Material no = world.getBlockMaterial(x + 1, y, z);
	Material ea = world.getBlockMaterial(x, y, z - 1);
	Material we = world.getBlockMaterial(x, y, z + 1);

	Material ma = Material.water;

	int md = world.getBlockMetadata(x, y, z);
	int bl = world.getBlockId(x, y, z);

	for (Block box : boxes) {
	    if (box != null && bl == box.blockID) {
		isBox = true;
	    }
	}

	if (isBox) {
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

    public static boolean checkWaterCrate(World world, int x, int y, int z) {
	Boolean isCrate = false;
	Material up = world.getBlockMaterial(x, y + 1, z);
	Material dn = world.getBlockMaterial(x, y - 1, z);
	Material so = world.getBlockMaterial(x - 1, y, z);
	Material no = world.getBlockMaterial(x + 1, y, z);
	Material ea = world.getBlockMaterial(x, y, z - 1);
	Material we = world.getBlockMaterial(x, y, z + 1);

	Material ma = Material.water;

	int md = world.getBlockMetadata(x, y, z);
	int bl = world.getBlockId(x, y, z);

	for (Block crate : crates) {
	    if (crate != null && bl == crate.blockID) {
		isCrate = true;
	    }
	}
	if (isCrate) {
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

    public static boolean checkRainBox(World world, int x, int y, int z) {
	int bl = world.getBlockId(x, y, z);
	int md = world.getBlockMetadata(x, y, z);
	boolean blockAbove = false;
	y++;

	if (!world.isRemote) {
	    for (Block box : boxes) {
		if (box != null && bl == box.blockID) {
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
	}
	return blockAbove;
    }

    public static boolean checkRainCrate(World world, int x, int y, int z) {
	int bl = world.getBlockId(x, y, z);
	int md = world.getBlockMetadata(x, y, z);
	boolean blockAbove = false;
	y++;

	if (!world.isRemote) {
	    for (Block crate : crates) {
		if (crate != null && bl == crate.blockID) {
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
	}
	return blockAbove;
    }
}
