/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.library;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import si.meansoft.logisticraft.common.items.LCItems;

public class Info {

    /* Mod relevant information */
    public static final String modID = "LC";
    public static final String modName = "Logisticraft";
    public static final String modVersion = "1.0.0";
    public static final String channel = "Logisticraft";
    public static final String REMOTE_VERSION = "http://dl.dropbox.com/u/25602663/Logisticraft/Version/lcver.properties";
    public static final String REMOTE_DOWNLOAD = "http://adf.ly/EE6IK";
    
    /* Localization keys for versioning */
    public static final String VERSION_CHECK_DISABLED = "version.check_disabled";
    public static final String UNN_MESSAGE = "version.uninitialized";
    public static final String CUR_MESSAGE = "version.current";
    public static final String OUT_MESSAGE = "version.outdated";
    public static final String ERR_MESSAGE = "version.error";
    public static final String DL_MESSAGE = "version.download";

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
    public static final String[] crateNames5 = { "rubberWood", "reinforcedStone", "reinforcedGlass", "scaffoldWooden", "scaffoldIron", "rubberSapling", "rubber", "refinedIron", "tin", "bronze", "uranium", "scrap", "uuMatter", "advancedAlloy", "iridiumOre", "plantBall" };
    public static final String[] crateNames6 = { "waxCapsule", "refactoryCapsule", "can", "moldyWheat", "compost", "fertiliser", "mulch", "woodPulp", "beesWax", "refactoryWax", "peat", "bituminousPeat", "ash", "phosphor", "apatite", "honeyedSlice" };
    public static final String[] crateNames7 = { "honeyComb", "cocoaCombs", "simmeringComb", "stringyComb", "frozenComb", "drippingComb", "silkyComb", "parchedComb", "mossyComb", "honeyDrop", "honeyDew", "pollen", "crysPollen", "propolis", "stickyPropolis", "silkyPropolis" };
    public static final String[] glassNames = { "black", "red", "green", "brown", "blue", "purple", "cyan", "lightGrey", "darkGrey", "pink", "lightGreen", "yellow", "lightBlue", "magenta", "orange", "white" };
    
    /* Item arrays for crates/boxes */    
    public static final ItemStack[] items = {new ItemStack(Item.wheat, 1, 0), new ItemStack(Item.reed, 1, 0), new ItemStack(Item.appleRed, 1, 0), new ItemStack(Item.egg, 1, 0), new ItemStack(Item.cake, 1, 0), new ItemStack(Item.bread, 1, 0), new ItemStack(Item.rottenFlesh, 1, 0), new ItemStack(Item.cookie, 1, 0), new ItemStack(LCItems.cantaloupe, 1, 0), new ItemStack(Item.porkRaw, 1, 0), new ItemStack(Item.fishRaw, 1, 0), new ItemStack(Item.beefRaw, 1, 0), new ItemStack(Item.chickenRaw, 1, 0), new ItemStack(Item.slimeBall, 1, 0), new ItemStack(Item.melon, 1, 0), new ItemStack(Item.dyePowder, 1, 4)};
    public static final ItemStack[] items2 = {new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.blazeRod, 1, 0), new ItemStack(Item.enderPearl, 1, 0), new ItemStack(Item.leather, 1, 0), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Item.lightStoneDust, 1, 0), new ItemStack(Item.redstone, 1, 0), new ItemStack(Item.gunpowder, 1, 0), new ItemStack(Item.ingotIron, 1, 0), new ItemStack(LCItems.ingotSilver, 1, 0), new ItemStack(LCItems.ingotCopper, 1, 0), new ItemStack(Item.flint, 1, 0), new ItemStack(Item.coal, 1, 0), new ItemStack(Item.silk, 1, 0), new ItemStack(Item.seeds, 1, 0), new ItemStack(Item.arrow, 1, 0)};
    public static final ItemStack[] items3 = {new ItemStack(Block.stone, 1, 0), new ItemStack(Block.cobblestone, 1, 0), new ItemStack(Block.dirt, 1, 0), new ItemStack(Block.sand, 1, 0), new ItemStack(Block.gravel, 1, 8), new ItemStack(Block.brick, 1, 0), new ItemStack(Block.cobblestoneMossy, 1, 0), new ItemStack(Block.obsidian, 1, 0), new ItemStack(Block.stoneBrick, 1, 0), new ItemStack(Block.cactus, 1, 0), new ItemStack(Block.netherrack, 1, 0), new ItemStack(Block.slowSand, 1, 0), new ItemStack(Block.glowStone, 1, 0), new ItemStack(Block.pumpkin, 1, 0), new ItemStack(Block.glass, 1, 0), new ItemStack(Block.sandStone, 1, 0)};
    public static final ItemStack[] items4 = {new ItemStack(Block.wood, 1, 0), new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 3), new ItemStack(Block.planks, 1, 0), new ItemStack(Block.planks, 1, 1), new ItemStack(Block.planks, 1, 2), new ItemStack(Block.planks, 1, 3), new ItemStack(Block.stoneBrick, 1, 1), new ItemStack(Block.stoneBrick, 1, 2), new ItemStack(Block.stoneBrick, 1, 3), new ItemStack(Block.sandStone, 1, 1), new ItemStack(Block.sandStone, 1, 2), new ItemStack(Block.netherBrick, 1, 0), new ItemStack(Block.redstoneLampIdle, 1, 0), new ItemStack(Block.torchWood, 1, 0)};
}
