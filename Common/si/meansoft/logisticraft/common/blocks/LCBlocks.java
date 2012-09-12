/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import si.meansoft.logisticraft.common.items.ItemBlockBox;
import si.meansoft.logisticraft.common.items.ItemBlockCrate;
import si.meansoft.logisticraft.common.items.ItemBlockGlass;
import si.meansoft.logisticraft.common.items.ItemBlockMachines;
import si.meansoft.logisticraft.common.items.ItemBlockOres;
import si.meansoft.logisticraft.common.items.LCItems;
import si.meansoft.logisticraft.common.library.BlockIDs;
import si.meansoft.logisticraft.common.library.Info;
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
	public static Block box;
	public static Block crate;
	public static Block playerPlate;
	public static Block coloredGlass;
	public static Block machines;
	
	/* Block declarations */
	public static void loadBlocks() {
		ores = new BlockOres(BlockIDs.ores, 3);
		box = new BlockBox(BlockIDs.box, 48);
		crate = new BlockCrate(BlockIDs.crate, 32);
		playerPlate = new BlockPlayerPlate(BlockIDs.playerPlate, 0, EnumMobType.players, Material.rock).setHardness(0.5F);
		coloredGlass = new BlockColorGlass(BlockIDs.coloredGlass, 240);
		machines = new BlockMachines(BlockIDs.machines, 24, false);
	}
	
	/* Block registration */
	public static void registerBlocks() {
		GameRegistry.registerBlock(playerPlate);
		GameRegistry.registerBlock(machines, ItemBlockMachines.class);
		GameRegistry.registerBlock(box, ItemBlockBox.class);
		GameRegistry.registerBlock(crate, ItemBlockCrate.class);
		GameRegistry.registerBlock(ores, ItemBlockOres.class);
		GameRegistry.registerBlock(coloredGlass, ItemBlockGlass.class);
	}
	
	/* Block names and translations */
	public static void nameBlocks() {
		playerPlate.setBlockName("pressurePlate");
		
		addNames(Info.crateNames, "Crated ", crate, true);
		addNames(Info.glassNames, " glass", coloredGlass, false);
		addNames(Info.boxNames, "", box, false);
		
		LanguageRegistry.addName(playerPlate, "Player preasure plate");
		
		LanguageRegistry.addName(new ItemStack(ores, 1, 0), "Platinum ore");
		LanguageRegistry.addName(new ItemStack(ores, 1, 1), "Silver ore");
		LanguageRegistry.addName(new ItemStack(ores, 1, 2), "Copper ore");
		
		LanguageRegistry.addName(new ItemStack(machines, 1, 0), "Lava remover");
		LanguageRegistry.addName(new ItemStack(machines, 1, 1), "Lava remover on");
		LanguageRegistry.addName(new ItemStack(machines, 1, 2), "Lava remover block");
	}
	
	public static void addNames(String[] names, String name, Block block, boolean side) {
		if(side) {
			for (int i = 0; i < names.length; i++) {
				LanguageRegistry.addName(new ItemStack(block , 1, i), name + names[i]);
			}
		}
		else {
			for (int i = 0; i < names.length; i++) {
				LanguageRegistry.addName(new ItemStack(block , 1, i), names[i] + name);
			}
		}
	}
}
