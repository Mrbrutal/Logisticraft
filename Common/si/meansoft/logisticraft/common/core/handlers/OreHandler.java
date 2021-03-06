/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.handlers;

import net.minecraft.src.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.items.LCItems;

public class OreHandler {

	public static void registerOres() {
		OreDictionary.registerOre("ingotCopper", new ItemStack(LCItems.ingotCopper));
		OreDictionary.registerOre("ingotSilver", new ItemStack(LCItems.ingotSilver));
		OreDictionary.registerOre("ingotPlatinum", new ItemStack(LCItems.ingotPlatinum));
		
		OreDictionary.registerOre("Platinum ore", new ItemStack(LCBlocks.ores, 1, 0));
		OreDictionary.registerOre("Silver ore", new ItemStack(LCBlocks.ores, 1, 1));
		OreDictionary.registerOre("Copper ore", new ItemStack(LCBlocks.ores, 1, 2));
		
		OreDictionary.registerOre("Platinum dust", new ItemStack(LCItems.dusts, 1, 0));
		OreDictionary.registerOre("Silver dust", new ItemStack(LCItems.dusts, 1, 1));
		OreDictionary.registerOre("Copper dust", new ItemStack(LCItems.dusts, 1, 2));
	}
}
