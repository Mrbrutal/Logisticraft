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
    public static boolean GEN_MELON;
    public static boolean GEN_CANTALOUPE;

    public static void init(File configFile) {
        Configuration cf = new Configuration(configFile);

        try {
            cf.load();

            /* General */
            AUTO_RESOLVE_IDS = cf.get("AUTO_RESOLVE_IDS", CATEGORY_BLOCK, false).getBoolean(false);
            ENABLE_PARTICLES = cf.get("ENABLE_PARTICLES", CATEGORY_GENERAL, true).getBoolean(true);
            GEN_ORE_COPPER = cf.get("GEN_ORE_COPPER", CATEGORY_GENERAL, true).getBoolean(true);
            GEN_ORE_SILVER = cf.get("GEN_ORE_SILVER", CATEGORY_GENERAL, true).getBoolean(true);
            GEN_ORE_PLATINUM = cf.get("GEN_ORE_PLATINUM", CATEGORY_GENERAL, true).getBoolean(true);
            GEN_MELON = cf.get("GEN_MELON", CATEGORY_GENERAL, true).getBoolean(true);
            GEN_CANTALOUPE = cf.get("GEN_CANTALOUPE", CATEGORY_GENERAL, true).getBoolean(true);
            
            /* Block */
            BlockIDs.ores = cf.getBlock("block_ores", CATEGORY_BLOCK, 400).getInt(400);
            BlockIDs.box = cf.getBlock("block_box", CATEGORY_BLOCK, 401).getInt(401);
            BlockIDs.box2 = cf.getBlock("block_box2", CATEGORY_BLOCK, 402).getInt(402);
            BlockIDs.box3 = cf.getBlock("block_box3", CATEGORY_BLOCK, 403).getInt(403);
            BlockIDs.box4 = cf.getBlock("block_box4", CATEGORY_BLOCK, 404).getInt(404);
            BlockIDs.box4 = cf.getBlock("block_box4", CATEGORY_BLOCK, 405).getInt(405);
            BlockIDs.box5 = cf.getBlock("block_box5", CATEGORY_BLOCK, 406).getInt(406);
            BlockIDs.box6 = cf.getBlock("block_box6", CATEGORY_BLOCK, 407).getInt(407);
            BlockIDs.box7 = cf.getBlock("block_box7", CATEGORY_BLOCK, 408).getInt(408);
            BlockIDs.crate = cf.getBlock("block_crate", CATEGORY_BLOCK, 410).getInt(410);
            BlockIDs.crate2 = cf.getBlock("block_crate2", CATEGORY_BLOCK, 411).getInt(411);
            BlockIDs.crate3 = cf.getBlock("block_crate3", CATEGORY_BLOCK, 412).getInt(412);
            BlockIDs.crate4 = cf.getBlock("block_crate4", CATEGORY_BLOCK, 413).getInt(413);
            BlockIDs.crate5 = cf.getBlock("block_crate5", CATEGORY_BLOCK, 414).getInt(414);
            BlockIDs.crate6 = cf.getBlock("block_crate6", CATEGORY_BLOCK, 415).getInt(415);
            BlockIDs.crate7 = cf.getBlock("block_crate7", CATEGORY_BLOCK, 416).getInt(416);
            BlockIDs.playerPlate = cf.getBlock("block_player_plate", CATEGORY_BLOCK, 419).getInt(419);
            BlockIDs.coloredGlass = cf.getBlock("block_colored_glass", CATEGORY_BLOCK, 420).getInt(420);
            BlockIDs.machines = cf.getBlock("block_machines", CATEGORY_BLOCK, 421).getInt(421);
            BlockIDs.beam = cf.getBlock("block_beam", CATEGORY_BLOCK, 422).getInt(422);
            BlockIDs.chimney = cf.getBlock("block_chimney", CATEGORY_BLOCK, 423).getInt(423);
            BlockIDs.stackBench = cf.getBlock("block_stack_bench", CATEGORY_BLOCK, 424).getInt(424);
            BlockIDs.cantaloupe = cf.getBlock("block_cantaloupe", CATEGORY_BLOCK, 425).getInt(425);
            BlockIDs.cantaloupeStem = cf.getBlock("block_cantaloupe_stem", CATEGORY_BLOCK, 426).getInt(426);
            
            /* Item */
            ItemIDs.ingotCopper = cf.getItem("ingot_copper", CATEGORY_ITEM, 1100).getInt();
            ItemIDs.ingotSilver = cf.getItem("ingot_silver", CATEGORY_ITEM, 1101).getInt();
            ItemIDs.ingotPlatinum = cf.getItem("ingot_platinum", CATEGORY_ITEM, 1102).getInt();
            
            ItemIDs.dusts = cf.getItem("dusts", CATEGORY_ITEM, 1103).getInt();
            ItemIDs.coins = cf.getItem("coins", CATEGORY_ITEM, 1104).getInt();
            ItemIDs.knife = cf.getItem("knife", CATEGORY_ITEM, 1105).getInt();
            ItemIDs.nails = cf.getItem("nails", CATEGORY_ITEM, 1106).getInt();
            ItemIDs.cardboard = cf.getItem("cardboard", CATEGORY_ITEM, 1107).getInt();
            ItemIDs.boards = cf.getItem("boards", CATEGORY_ITEM, 1108).getInt();
            ItemIDs.compost = cf.getItem("compost", CATEGORY_ITEM, 1109).getInt();
            ItemIDs.cantaloupe = cf.getItem("cantaloupe", CATEGORY_ITEM, 1110).getInt();
            ItemIDs.cantaloupeSeeds = cf.getItem("cantaloupeSeeds", CATEGORY_ITEM, 1111).getInt();            
        }
        catch (Exception e) {
            Logisticraft.lcLog.severe("Logisticraft had a problem loading its configuration\n" + e);
        }
        finally {
        	cf.save();
        }
    }
}
