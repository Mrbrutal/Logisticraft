/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import si.meansoft.logisticraft.common.items.ItemBlockOres;
import si.meansoft.logisticraft.common.library.BlockIDs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.BlockPressurePlate;
import net.minecraft.src.EnumMobType;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class LCBlocks {
	
	public static Block ores;
	public static Block playerPlate;
	
	/* Block declarations */
	public static void loadBlocks() {
		ores = new BlockOres(BlockIDs.ores, 3);
		playerPlate = new BlockPlayerPlate(BlockIDs.playerPlate, 0, EnumMobType.players, Material.rock).setHardness(0.5F);
	}
	
	/* Block registration */
	public static void registerBlocks() {
		GameRegistry.registerBlock(playerPlate);
		GameRegistry.registerBlock(ores, ItemBlockOres.class);
	}
	
	/* Block names and translations */
	public static void nameBlocks() {
		playerPlate.setBlockName("pressurePlate");
		
		LanguageRegistry.addName(playerPlate, "Player preasure plate");
		LanguageRegistry.addName(new ItemStack(ores, 1, 0), "Platinum ore");
		LanguageRegistry.addName(new ItemStack(ores, 1, 1), "Silver ore");
		LanguageRegistry.addName(new ItemStack(ores, 1, 2), "Copper ore");
	}
	
	/* Register recipes for blocks */
	public static void blockRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(ores, 1, 0), Block.dirt);
		GameRegistry.addShapelessRecipe(new ItemStack(ores, 1, 1), Block.cobblestone);
		GameRegistry.addShapelessRecipe(new ItemStack(ores, 1, 2), Block.stone);
	}
}
