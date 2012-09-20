/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.library;

public class Info {

	/*Mod relevant information*/
	public static final String modID = "LC";
	public static final String modName = "Logisticraft";
	public static final String modVersion = "1.0.0";
	public static final String channel = "Logisticraft";

	/*All the resources for the mod*/
	public static final String texPrefix = "/si/meansoft/logisticraft/Resources/";
	public static final String guiPrefix = "/si/meansoft/logisticraft/Resources/GUI/";
	public static final String TEX_BLOCK = texPrefix + "Blocks.png";
	public static final String TEX_ITEM = texPrefix + "Items.png";
	public static final String TEX_CRATE = texPrefix + "Crate.png";
	public static final String TEX_GUI_SB = guiPrefix + "stackCrafting.png";
	public static final String TEX_GUI_SQ = guiPrefix + "square.png";
	
	/*Additional information and constants*/
	public static final String MOD_PFX = "[" + modID + "]";
	
	/* Language */
	public static final String DEFAULT_LANGUAGE = "en_US";
	
	/* Block/Item name arrays */
	
	public static final String[] crateNames = {"wheat", "sugarcane", "apples", "eggs", " cake", "bread", "zombie flesh", "cookies", "melon", "porkchops", "fish", "beef", " chicken", "slimebals", "watermelon", "rott"};
	public static final String[] glassNames = {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Light grey", "Dark grey", "Pink", "Light green", "Yellow", "Light blue", "Magenta", "Orange", "White"};
	public static final String[] boxNames = {"Block wheat", "Block sugarcane", "Apple basket", "Egg basket", "Cake basket", "Bread basket", "Zombie basket", "Cookie basket", "Watermelon basket", "Box of pork", "Box of fish", "Box of beef", "Box of chicken", "SlimeBall basket", "Box of watermelon", "Compost basket"};
}
