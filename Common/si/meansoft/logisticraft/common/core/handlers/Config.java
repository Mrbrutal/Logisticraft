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
import si.meansoft.logisticraft.common.blocks.BlockIDs;
import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;
import static net.minecraftforge.common.Configuration.*;

public class Config {
	public static boolean AUTO_RESOLVE_IDS;
    public static boolean ENABLE_PARTICLES;
    public static boolean GEN_ORE_COPPER;
    public static boolean GEN_ORE_SILVER;
    public static boolean GEN_ORE_PLATINUM;

    public static void init(File configFile) {
        Configuration configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* General */
            AUTO_RESOLVE_IDS = configuration.getOrCreateBooleanProperty("AUTO_RESOLVE_IDS", CATEGORY_BLOCK, false).getBoolean(false);
            ENABLE_PARTICLES = configuration.getOrCreateBooleanProperty("ENABLE_PARTICLES", CATEGORY_BLOCK, true).getBoolean(true);
            GEN_ORE_COPPER = configuration.getOrCreateBooleanProperty("GEN_ORE_COPPER", CATEGORY_BLOCK, true).getBoolean(true);
            GEN_ORE_SILVER = configuration.getOrCreateBooleanProperty("GEN_ORE_SILVER", CATEGORY_BLOCK, true).getBoolean(true);
            GEN_ORE_PLATINUM = configuration.getOrCreateBooleanProperty("GEN_ORE_PLATINUM", CATEGORY_BLOCK, true).getBoolean(true);
            
            /* Block */
            BlockIDs.TEST = configuration.getOrCreateIntProperty("block_test", CATEGORY_BLOCK, 400).getInt(400);

            /* Item */
            
                        
        }
        catch (Exception e) {
            Logisticraft.lcLog.severe("Logisticraft had a problem loading its configuration\n" + e);
        }
        finally {
            configuration.save();
        }
    }
}
