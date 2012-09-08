/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import si.meansoft.logisticraft.common.items.ItemBlockOres;
import si.meansoft.logisticraft.common.items.LCItems;
import si.meansoft.logisticraft.common.library.BlockIDs;
import si.meansoft.logisticraft.common.library.ItemIDs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.BlockPressurePlate;
import net.minecraft.src.EnumMobType;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;

public class LCBlocks {
	
	public static Block ores;
	public static Block crate;
	public static Block playerPlate;
	
	/* Block declarations */
	public static void loadBlocks() {
		ores = new BlockOres(BlockIDs.ores, 3);
		crate = new BlockCrate(BlockIDs.crate, 32);
		playerPlate = new BlockPlayerPlate(BlockIDs.playerPlate, 0, EnumMobType.players, Material.rock).setHardness(0.5F);
	}
	
	/* Block registration */
	public static void registerBlocks() {
		GameRegistry.registerBlock(playerPlate);
		GameRegistry.registerBlock(crate);
		GameRegistry.registerBlock(ores, ItemBlockOres.class);
	}
	
	/* Block names and translations */
	public static void nameBlocks() {
		playerPlate.setBlockName("pressurePlate");
		crate.setBlockName("Crate");
		
		LanguageRegistry.addName(crate, "Crate");
		LanguageRegistry.addName(playerPlate, "Player preasure plate");
		LanguageRegistry.addName(new ItemStack(ores, 1, 0), "Platinum ore");
		LanguageRegistry.addName(new ItemStack(ores, 1, 1), "Silver ore");
		LanguageRegistry.addName(new ItemStack(ores, 1, 2), "Copper ore");
	}
}
