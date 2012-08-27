/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import java.io.File;
import java.util.logging.Level;

import si.meansoft.logisticraft.common.Logisticraft;
import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;
import static net.minecraftforge.common.Configuration.*;

public class Config {
	public static boolean AUTO_RESOLVE_IDS;
    public static boolean ENABLE_SOUNDS;
    public static boolean ENABLE_PARTICLES;

    public static void init(File configFile) {
        Configuration configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* General */
            AUTO_RESOLVE_IDS = configuration.getOrCreateBooleanProperty("auto_resolve_ids", CATEGORY_BLOCK, false).getBoolean(false);
            
            /* Block */

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
