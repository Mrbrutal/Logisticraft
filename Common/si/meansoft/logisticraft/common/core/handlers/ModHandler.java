/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.handlers;

import java.util.List;

import net.minecraft.src.Block;
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
import forestry.api.core.BlockInterface;
import forestry.api.core.ItemInterface;

public class ModHandler {

    public static boolean ic2 = false;
    public static boolean fo = false;
    public static ItemStack[] ic2Items;
    public static ItemStack[] foItems;
    public static ItemStack[] foItems2;
    
    public static void init() {
	ic2 = isPresent("IC2");
	if(ic2) {
	    Logisticraft.lcLog.info("Loading IC2 items/blocks");
	    getIC2items();
	    loadIC2items();
	}
	else {
	    Logisticraft.lcLog.info("IC2 items/blocks not loaded");
	}
	fo = isPresent("Forestry");
	if(fo) {
	    Logisticraft.lcLog.info("Loading Forestry items/blocks");
	    getFoitems();
	    loadFoitems();
	}
	else {
	    Logisticraft.lcLog.info("Forestry items/blocks not loaded");
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
	LCBlocks.box6 = new BlockBox(BlockIDs.box6, 112);
	LCBlocks.crate6 = new BlockCrate(BlockIDs.crate6, 112);
	LCBlocks.box7 = new BlockBox(BlockIDs.box7, 128);
	LCBlocks.crate7 = new BlockCrate(BlockIDs.crate7, 128);
	
	GameRegistry.registerBlock(LCBlocks.box6, ItemBlockBox.class);
	GameRegistry.registerBlock(LCBlocks.crate6, ItemBlockCrate.class);
	GameRegistry.registerBlock(LCBlocks.box7, ItemBlockBox.class);
	GameRegistry.registerBlock(LCBlocks.crate7, ItemBlockCrate.class);
	
	LCBlocks.box6.setBlockName("box6");
	LCBlocks.crate6.setBlockName("crate6");
	LCBlocks.box7.setBlockName("box7");
	LCBlocks.crate7.setBlockName("crate7");
    }

    private static void getIC2items() {
	ItemStack[] items = {Items.getItem("rubberWood"), Items.getItem("reinforcedStone"), Items.getItem("reinforcedGlass"), new ItemStack(Items.getItem("scaffold").copy().getItem(), 1, 0), new ItemStack(Items.getItem("scaffold").copy().getItem(), 1, 1), Items.getItem("rubberSapling"), Items.getItem("rubber"), Items.getItem("refinedIronIngot"), Items.getItem("tinIngot"), Items.getItem("bronzeIngot"), Items.getItem("uraniumIngot"), Items.getItem("scrap"), Items.getItem("matter"), Items.getItem("advancedAlloy"), Items.getItem("iridiumOre"), Items.getItem("plantBall")};
	ic2Items = items;
    }
    
    private static void getFoitems() {	
	ItemStack[] items2 = {ItemInterface.getItem("waxCapsule"), ItemInterface.getItem("refractoryEmpty"), ItemInterface.getItem("canEmpty"), ItemInterface.getItem("mouldyWheat"), ItemInterface.getItem("fertilizerBio"), ItemInterface.getItem("fertilizerCompound"), ItemInterface.getItem("mulch"), ItemInterface.getItem("woodPulp"), ItemInterface.getItem("beeswax"), ItemInterface.getItem("refractoryWax"), ItemInterface.getItem("peat"), ItemInterface.getItem("bituminousPeat"), ItemInterface.getItem("ash"), ItemInterface.getItem("phosphor"), ItemInterface.getItem("apatite"), ItemInterface.getItem("honeyedSlice")};
	foItems = items2;
	ItemStack[] items3 = {new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 0), new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 1), new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 2), new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 3), new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 4), new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 5), new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 6), new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 7), new ItemStack(ItemInterface.getItem("beeComb").getItem(), 1, 15), ItemInterface.getItem("honeyDrop"), ItemInterface.getItem("honeydew"), /*ItemInterface.getItem("royalJelly"),*/ new ItemStack(ItemInterface.getItem("pollen").getItem(), 1, 0), new ItemStack(ItemInterface.getItem("pollen").getItem(), 1, 1), new ItemStack(ItemInterface.getItem("propolis").getItem(), 1, 0), new ItemStack(ItemInterface.getItem("propolis").getItem(), 1, 1), new ItemStack(ItemInterface.getItem("propolis").getItem(), 1, 3)};
	foItems2 = items3;
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
