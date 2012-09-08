/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.handlers;

import java.io.File;
import java.util.logging.Level;

import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.library.BlockIDs;
import si.meansoft.logisticraft.common.library.ItemIDs;
import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;
import static net.minecraftforge.common.Configuration.*;

public class ConfigHandler {
	public static boolean AUTO_RESOLVE_IDS;
    public static boolean ENABLE_PARTICLES;
    public static boolean GEN_ORE_COPPER;
    public static boolean GEN_ORE_SILVER;
    public static boolean GEN_ORE_PLATINUM;

    public static void init(File configFile) {
        Configuration cf = new Configuration(configFile);

        try {
        	cf.load();

            /* General */
            AUTO_RESOLVE_IDS = cf.getOrCreateBooleanProperty("AUTO_RESOLVE_IDS", CATEGORY_BLOCK, false).getBoolean(false);
            ENABLE_PARTICLES = cf.getOrCreateBooleanProperty("ENABLE_PARTICLES", CATEGORY_GENERAL, true).getBoolean(true);
            GEN_ORE_COPPER = cf.getOrCreateBooleanProperty("GEN_ORE_COPPER", CATEGORY_GENERAL, true).getBoolean(true);
            GEN_ORE_SILVER = cf.getOrCreateBooleanProperty("GEN_ORE_SILVER", CATEGORY_GENERAL, true).getBoolean(true);
            GEN_ORE_PLATINUM = cf.getOrCreateBooleanProperty("GEN_ORE_PLATINUM", CATEGORY_GENERAL, true).getBoolean(true);
            
            /* Block */
            BlockIDs.ores = cf.getOrCreateIntProperty("block_ores", CATEGORY_BLOCK, 400).getInt(400);
            BlockIDs.playerPlate = cf.getOrCreateIntProperty("block_player_plate", CATEGORY_BLOCK, 401).getInt(401);
            
            /* Item */
            ItemIDs.ingotCopper = cf.getOrCreateIntProperty("ingot_copper", Configuration.CATEGORY_ITEM, 1100).getInt();
            ItemIDs.ingotSilver = cf.getOrCreateIntProperty("ingot_silver", Configuration.CATEGORY_ITEM, 1101).getInt();
            ItemIDs.ingotPlatinum = cf.getOrCreateIntProperty("ingot_platinum", Configuration.CATEGORY_ITEM, 1102).getInt();
            
            ItemIDs.coins = cf.getOrCreateIntProperty("coins", Configuration.CATEGORY_ITEM, 1103).getInt();
            
        }
        catch (Exception e) {
            Logisticraft.lcLog.severe("Logisticraft had a problem loading its configuration\n" + e);
        }
        finally {
        	cf.save();
        }
    }
}