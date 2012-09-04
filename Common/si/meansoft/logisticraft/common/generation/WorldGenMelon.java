/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.generation;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenPumpkin;

public class WorldGenMelon extends WorldGenPumpkin{
	
	private int genBlockId;

	public WorldGenMelon(int par1) {
		this.genBlockId = par1;
	}
	
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5){
        for (int var6 = 0; var6 < 256; ++var6){
            int var7 = par3 + par2Random.nextInt(16) - par2Random.nextInt(6);
            int var8 = par4 + par2Random.nextInt(8) - par2Random.nextInt(2);
            int var9 = par5 + par2Random.nextInt(16) - par2Random.nextInt(6);

            if (par1World.isAirBlock(var7, var8, var9) && par1World.getBlockId(var7, var8 - 1, var9) == Block.grass.blockID && Block.blocksList[genBlockId].canPlaceBlockAt(par1World, var7, var8, var9)){
                par1World.setBlockWithNotify(var7, var8, var9, genBlockId);
                //System.out.println("Generating melons at " + var7 +" | "+ var8 +" | " + var9);
            }
        }
        return true;
    }
}
