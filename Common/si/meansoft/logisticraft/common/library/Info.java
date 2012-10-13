/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.library;

import si.meansoft.logisticraft.common.items.LCItems;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class Info {

    /* Mod relevant information */
    public static final String modID = "LC";
    public static final String modName = "Logisticraft";
    public static final String modVersion = "1.0.0";
    public static final String channel = "Logisticraft";

    /* All the resources for the mod */
    public static final String texPrefix = "/si/meansoft/logisticraft/Resources/";
    public static final String guiPrefix = "/si/meansoft/logisticraft/Resources/GUI/";
    public static final String TEX_BLOCK = texPrefix + "Blocks.png";
    public static final String TEX_CRATES = texPrefix + "Crates.png";
    public static final String TEX_BOXES = texPrefix + "Boxes.png";
    public static final String TEX_ITEM = texPrefix + "Items.png";
    public static final String TEX_CRATE = texPrefix + "Crate.png";
    public static final String TEX_GUI_SB = guiPrefix + "stackCrafting.png";
    public static final String TEX_GUI_SQ = guiPrefix + "square.png";

    /* Additional information and constants */
    public static final String MOD_PFX = "[" + modID + "]";
    public static final String LANG_FILES = texPrefix + "lang/";

    /* Language */
    public static final String DEFAULT_LANGUAGE = "en_US";

    /* Block/Item name arrays */
    public static final String[] crateNames = { "wheat", "sugarcane", "apples", "eggs", "cake", "bread", "zombieFlesh", "cookies", "melon", "porkchops", "fish", "beef", "chicken", "slime", "watermelon", "cocoa" };
    public static final String[] crateNames2 = { "bonemeal", "blazeRods", "enderPearls", "leather", "inkSacks", "glowstoneDust", "redstone", "gunPowder", "ironIngots", "silverIngots", "copperIngots", "flint", "coal", "string", "seeds", "arrows" };
    public static final String[] crateNames3 = { "smoothStone", "cobbleStone", "dirt", "sand", "gravel", "bricks", "mossy", "obsidian", "stoneBricks", "cacti", "netherRack", "slowSand", "glowStone", "pumpkins", "glass", "sandStone" };
    public static final String[] crateNames4 = { "oakWood", "pineWood", "birchWood", "jungleWood", "oakPlanks", "pinePlanks", "birchPlanks", "junglePlanks", "mossyStoneBricks", "brokenStoneBricks", "decStoneBricks", "creeperSandStone", "smoothSandStone", "netherBricks", "redstoneLamp", "torches" };
    public static final String[] glassNames = { "black", "red", "green", "brown", "blue", "purple", "cyan", "lightGrey", "darkGrey", "pink", "lightGreen", "yellow", "lightBlue", "magenta", "orange", "white" };

    /* Item arrays for crates/boxes */    
    public static ItemStack[] items;
    public static ItemStack[] items2;
    public static ItemStack[] items3;
    public static ItemStack[] items4;

	public static void initArrays() {
		ItemStack[] items = {new ItemStack(Item.wheat), new ItemStack(Item.reed), new ItemStack(Item.appleRed), new ItemStack(Item.egg), new ItemStack(Item.cake), new ItemStack(Item.bread), new ItemStack(Item.rottenFlesh), new ItemStack(Item.cookie), new ItemStack(Item.arrow), new ItemStack(Item.porkRaw), new ItemStack(Item.fishRaw), new ItemStack(Item.beefRaw), new ItemStack(Item.chickenRaw), new ItemStack(Item.slimeBall), new ItemStack(Item.melon), new ItemStack(Item.dyePowder, 1, 4)};
		ItemStack[] items2 = {new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.blazeRod), new ItemStack(Item.enderPearl), new ItemStack(Item.leather), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Item.lightStoneDust), new ItemStack(Item.redstone), new ItemStack(Item.gunpowder), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.flint), new ItemStack(Item.coal), new ItemStack(Item.silk), new ItemStack(Item.seeds), new ItemStack(Item.arrow)};
		ItemStack[] items3 = {new ItemStack(Block.stone), new ItemStack(Block.cobblestone), new ItemStack(Block.dirt), new ItemStack(Block.sand), new ItemStack(Block.gravel, 1, 8), new ItemStack(Item.lightStoneDust), new ItemStack(Item.redstone), new ItemStack(Item.gunpowder), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.flint), new ItemStack(Item.coal), new ItemStack(Item.silk), new ItemStack(Item.seeds), new ItemStack(Item.arrow)};
		ItemStack[] items4 = {new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.blazeRod), new ItemStack(Item.enderPearl), new ItemStack(Item.leather), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Item.lightStoneDust), new ItemStack(Item.redstone), new ItemStack(Item.gunpowder), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.ingotIron), new ItemStack(Item.flint), new ItemStack(Item.coal), new ItemStack(Item.silk), new ItemStack(Item.seeds), new ItemStack(Item.arrow)};
	}
}
