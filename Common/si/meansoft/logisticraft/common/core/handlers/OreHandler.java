/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.handlers;

import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.items.LCItems;
import net.minecraft.src.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreHandler {

	public static void registerOres() {
		OreDictionary.registerOre("ingotCopper", new ItemStack(LCItems.ingotCopper));
		OreDictionary.registerOre("ingotSilver", new ItemStack(LCItems.ingotSilver));
		OreDictionary.registerOre("ingotPlatinum", new ItemStack(LCItems.ingotPlatinum));
		
		OreDictionary.registerOre("Platinum ore", new ItemStack(LCBlocks.ores, 1, 0));
		OreDictionary.registerOre("Platinum ore", new ItemStack(LCBlocks.ores, 1, 1));
		OreDictionary.registerOre("Platinum ore", new ItemStack(LCBlocks.ores, 1, 2));
		
	}
}
