/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.library;

import si.meansoft.logisticraft.common.items.LCItems;
import net.minecraft.src.Item;

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
    public static final String[] crateNames = { "wheat", "sugarcane", "apples", "eggs", "cake", "bread", "zombie flesh", "cookies", "melon", "porkchops", "fish", "beef", "chicken", "slimebals", "watermelon", "cocoa" };
    public static final String[] crateNames2 = { "bonemeal", "blaze rods", "ender pearls", "leather", "ink sacks", "glowstone dust", "redstone", "gun powder", "iron ingots", "silver ingots", "copper ingots", "flint", "coal", "string", "seeds", "arrows" };
    public static final String[] glassNames = { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Light grey", "Dark grey", "Pink", "Light green", "Yellow", "Light blue", "Magenta", "Orange", "White" };

    /* Item arrays for crates/boxes */
    public static final Item[] items = { Item.wheat, Item.reed, Item.appleRed, Item.egg, Item.cake, Item.bread, Item.rottenFlesh, Item.cookie, Item.arrow, Item.porkRaw, Item.fishRaw, Item.beefRaw, Item.chickenRaw, Item.slimeBall, Item.melon, Item.dyePowder };
    public static final Item[] items2 = { Item.dyePowder, Item.blazeRod, Item.enderPearl, Item.leather, Item.dyePowder, Item.lightStoneDust, Item.redstone, Item.gunpowder, Item.ingotIron, LCItems.ingotSilver, LCItems.ingotCopper, Item.flint, Item.coal, Item.silk, Item.seeds, Item.arrow };
}
