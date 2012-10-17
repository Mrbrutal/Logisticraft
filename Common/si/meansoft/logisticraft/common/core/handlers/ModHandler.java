/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.handlers;

import java.util.List;

import net.minecraft.src.ItemStack;
import net.minecraft.src.ic2.api.Items;

import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.blocks.BlockBox;
import si.meansoft.logisticraft.common.blocks.BlockCrate;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.items.ItemBlockBox;
import si.meansoft.logisticraft.common.items.ItemBlockCrate;
import si.meansoft.logisticraft.common.library.BlockIDs;
import si.meansoft.logisticraft.common.library.ItemIDs;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModHandler {

    public static boolean ic2 = false;
    public static boolean fo = false;
    public static ItemStack[] ic2Items;
    public static ItemStack[] foItems;
    
    public static void init() {
	ic2 = isPresent("IC2");
	if(ic2) {
	    Logisticraft.lcLog.fine("Loading IC2 items/blocks");
	    getIC2items();
	    loadIC2items();
	}
	fo = isPresent("Forestry");
	if(fo) {
	    Logisticraft.lcLog.fine("Loading Forestry items/blocks");
	    getIC2items();
	    loadFoitems();
	}
    }
    
    private static void loadIC2items() {
	LCBlocks.box5 = new BlockBox(BlockIDs.box5, 96);
	LCBlocks.crate5 = new BlockCrate(BlockIDs.crate5, 96);
	
	GameRegistry.registerBlock(LCBlocks.box5, ItemBlockBox.class);
	GameRegistry.registerBlock(LCBlocks.crate5, ItemBlockCrate.class);
	
	LCBlocks.box5.setBlockName("box5");
	LCBlocks.crate5.setBlockName("crate5");
    }
    
    private static void loadFoitems() {
	LCBlocks.box5 = new BlockBox(BlockIDs.box5, 96);
	LCBlocks.crate5 = new BlockCrate(BlockIDs.crate5, 96);
	
	GameRegistry.registerBlock(LCBlocks.box5, ItemBlockBox.class);
	GameRegistry.registerBlock(LCBlocks.crate5, ItemBlockCrate.class);
	
	LCBlocks.box5.setBlockName("box5");
	LCBlocks.crate5.setBlockName("crate5");
    }

    private static void getIC2items() {
	/*BlockIDs.rubberWood = Items.getItem("rubberWood").itemID;
	BlockIDs.reinforcedStone = Items.getItem("reinforcedStone").itemID;
	BlockIDs.reinforcedGlass = Items.getItem("reinforcedGlass").itemID;
	BlockIDs.scaffold = Items.getItem("scaffold").itemID;
	
	ItemIDs.rubberSapling = Items.getItem("rubberSapling").itemID;
	ItemIDs.rubber = Items.getItem("rubber").itemID;
	ItemIDs.refinedIron = Items.getItem("refinedIronIngot").itemID;
	ItemIDs.tin = Items.getItem("tinIngot").itemID;
	ItemIDs.bronze = Items.getItem("bronzeIngot").itemID;
	ItemIDs.uranium = Items.getItem("uraniumIngot").itemID;
	ItemIDs.scrap = Items.getItem("scrap").itemID;
	ItemIDs.uuMatter = Items.getItem("matter").itemID;
	ItemIDs.advancedAlloy = Items.getItem("advancedAlloy").itemID;
	ItemIDs.iridiumOre = Items.getItem("iridiumOre").itemID;
	ItemIDs.plantBall = Items.getItem("plantBall").itemID;*/
	
	ItemStack[] items = {Items.getItem("rubberWood"), Items.getItem("reinforcedStone"), Items.getItem("reinforcedGlass"), new ItemStack(Items.getItem("scaffold").copy().getItem(), 1, 0), new ItemStack(Items.getItem("scaffold").copy().getItem(), 1, 1), Items.getItem("rubberSapling"), Items.getItem("rubber"), Items.getItem("refinedIronIngot"), Items.getItem("tinIngot"), Items.getItem("bronzeIngot"), Items.getItem("uraniumIngot"), Items.getItem("scrap"), Items.getItem("matter"), Items.getItem("advancedAlloy"), Items.getItem("iridiumOre"), Items.getItem("plantBall")};
	ic2Items = items;
    }
    
    private static void getFoitems() {
	ItemStack[] items = {};
	foItems = items;
    }

    public static boolean isPresent(String modId) {
	if(Loader.instance().getActiveModList() != null) {
	    List<ModContainer> mods = Loader.instance().getActiveModList();
	    for (int i = 0; i < mods.size(); i++) {
		if(mods.get(i).getModId().equals(modId)) {
		    return true;
		}
		System.out.println("[LC] Mod:" + mods.get(i).getName() + " | " + mods.get(i).getModId());
	    }
	}
	return false;
    }
}
