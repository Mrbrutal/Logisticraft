/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import net.minecraft.src.BlockPressurePlate;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumMobType;
import net.minecraft.src.Material;

public class BlockPlayerPlate extends BlockPressurePlate {

    private EnumMobType triggerMobType;

    public BlockPlayerPlate(int par1, int par2, EnumMobType par3EnumMobType, Material par4Material) {
	super(par1, par2, par3EnumMobType, par4Material);
	triggerMobType = par3EnumMobType;
	setCreativeTab(CreativeTabs.tabRedstone);
	setTickRandomly(true);
	float var5 = 0.0625F;
	setBlockBounds(var5, 0.0F, var5, 1.0F - var5, 0.03125F, 1.0F - var5);
	setRequiresSelfNotify();
    }

    public int tickRate() {
	return 10;
    }
}