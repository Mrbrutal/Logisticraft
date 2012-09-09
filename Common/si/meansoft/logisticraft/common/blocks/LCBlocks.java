/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import si.meansoft.logisticraft.common.items.ItemBlockGlass;
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
	public static Block coloredGlass;
	
	/* Block declarations */
	public static void loadBlocks() {
		ores = new BlockOres(BlockIDs.ores, 3);
		crate = new BlockCrate(BlockIDs.crate, 32);
		playerPlate = new BlockPlayerPlate(BlockIDs.playerPlate, 0, EnumMobType.players, Material.rock).setHardness(0.5F);
		coloredGlass = new BlockColorGlass(BlockIDs.coloredGlass, 240);
	}
	
	/* Block registration */
	public static void registerBlocks() {
		GameRegistry.registerBlock(playerPlate);
		GameRegistry.registerBlock(crate);
		GameRegistry.registerBlock(ores, ItemBlockOres.class);
		GameRegistry.registerBlock(coloredGlass, ItemBlockGlass.class);
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
		
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 0), "Black glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 1), "Red glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 2), "Green glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 3), "Brown glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 4), "Blue glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 5), "Purple glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 6), "Cyan glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 7), "Light grey glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 8), "Dark grey glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 9), "Pink glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 10), "Light green glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 11), "Yellow glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 12), "Light blue glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 13), "Magenta glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 14), "Orange glass");
		LanguageRegistry.addName(new ItemStack(coloredGlass, 1, 15), "White glass");
	}
}
