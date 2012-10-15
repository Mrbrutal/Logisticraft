/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.blocks;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStem;
import net.minecraft.src.EnumMobType;
import net.minecraft.src.Material;
import si.meansoft.logisticraft.common.items.ItemBlockBox;
import si.meansoft.logisticraft.common.items.ItemBlockChimney;
import si.meansoft.logisticraft.common.items.ItemBlockCrate;
import si.meansoft.logisticraft.common.items.ItemBlockGlass;
import si.meansoft.logisticraft.common.items.ItemBlockMachines;
import si.meansoft.logisticraft.common.items.ItemBlockOres;
import si.meansoft.logisticraft.common.library.BlockIDs;
import cpw.mods.fml.common.registry.GameRegistry;

public class LCBlocks {

    public static Block ores;
    public static Block box;
    public static Block box2;
    public static Block box3;
    public static Block box4;
    public static Block crate;
    public static Block crate2;
    public static Block crate3;
    public static Block crate4;
    public static Block playerPlate;
    public static Block coloredGlass;
    public static Block machines;
    public static Block beam;
    public static Block chimney;
    public static Block stackBench;
    public static Block cantaloupe;
    public static Block cantaloupeStem;

    /* Block declarations */
    public static void loadBlocks() {
	ores = new BlockOres(BlockIDs.ores, 3);
	box = new BlockBox(BlockIDs.box, 0);
	box2 = new BlockBox(BlockIDs.box2, 16);
	box3 = new BlockBox(BlockIDs.box3, 32+16);
	box4 = new BlockBox(BlockIDs.box4, 48+16);
	crate = new BlockCrate(BlockIDs.crate, 0);
	crate2 = new BlockCrate(BlockIDs.crate2, 16);
	crate3 = new BlockCrate(BlockIDs.crate3, 32+16);
	crate4 = new BlockCrate(BlockIDs.crate4, 48+16);
	playerPlate = new BlockPlayerPlate(BlockIDs.playerPlate, 0, EnumMobType.players, Material.rock).setHardness(0.5F);
	coloredGlass = new BlockColorGlass(BlockIDs.coloredGlass, 240, Material.glass);
	machines = new BlockMachines(BlockIDs.machines, 24, false);
	beam = new BlockColorGlass(BlockIDs.beam, 240 - 16, Material.vine).setLightOpacity(0).setLightValue(1.0F);
	chimney = new BlockChimney(BlockIDs.chimney, 32);
	stackBench = new BlockStackBench(BlockIDs.stackBench, 20);
	cantaloupe = new BlockCantaloupe(BlockIDs.cantaloupe, 6);
	cantaloupeStem = new BlockStem2(BlockIDs.cantaloupeStem, cantaloupe);
    }

    /* Block registration */
    public static void registerBlocks() {
	GameRegistry.registerBlock(playerPlate);
	GameRegistry.registerBlock(stackBench);
	GameRegistry.registerBlock(cantaloupe);
	GameRegistry.registerBlock(cantaloupeStem);
	GameRegistry.registerBlock(machines, ItemBlockMachines.class);
	GameRegistry.registerBlock(box, ItemBlockBox.class);
	GameRegistry.registerBlock(box2, ItemBlockBox.class);
	GameRegistry.registerBlock(box3, ItemBlockBox.class);
	GameRegistry.registerBlock(box4, ItemBlockBox.class);
	GameRegistry.registerBlock(crate, ItemBlockCrate.class);
	GameRegistry.registerBlock(crate2, ItemBlockCrate.class);
	GameRegistry.registerBlock(crate3, ItemBlockCrate.class);
	GameRegistry.registerBlock(crate4, ItemBlockCrate.class);
	GameRegistry.registerBlock(ores, ItemBlockOres.class);
	GameRegistry.registerBlock(coloredGlass, ItemBlockGlass.class);
	GameRegistry.registerBlock(beam, ItemBlockGlass.class);
	GameRegistry.registerBlock(chimney, ItemBlockChimney.class);
    }

    /* Block names and translations */
    public static void nameBlocks() {
	playerPlate.setBlockName("pressurePlate");
	stackBench.setBlockName("stackBench");
	cantaloupe.setBlockName("cantaloupe");
	cantaloupeStem.setBlockName("cantaloupeStem");
	ores.setBlockName("ore");
	box.setBlockName("box");
	box2.setBlockName("box2");
	box3.setBlockName("box3");
	box4.setBlockName("box4");
	crate.setBlockName("crate");
	crate2.setBlockName("crate2");
	crate3.setBlockName("crate3");
	crate4.setBlockName("crate4");
	machines.setBlockName("machine");
	coloredGlass.setBlockName("coloredGlass");
	beam.setBlockName("beam");
	chimney.setBlockName("chimney");
    }
}
