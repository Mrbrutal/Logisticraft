/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.handlers;

import static net.minecraftforge.common.Configuration.CATEGORY_BLOCK;
import static net.minecraftforge.common.Configuration.CATEGORY_GENERAL;
import static net.minecraftforge.common.Configuration.CATEGORY_ITEM;

import java.io.File;

import net.minecraftforge.common.Configuration;
import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.library.BlockIDs;
import si.meansoft.logisticraft.common.library.ItemIDs;

public class ConfigHandler {
	public static boolean AUTO_RESOLVE_IDS;
    public static boolean ENABLE_PARTICLES;
    public static boolean GEN_ORE_COPPER;
    public static boolean GEN_ORE_SILVER;
    public static boolean GEN_ORE_PLATINUM;
    public static boolean GEN_MELON;
    public static boolean GEN_CANTALOUPE;
    public static boolean SHOW_VERSION_UPDATE;

    public static void init(File configFile) {
        Configuration cf = new Configuration(configFile);

        try {
            cf.load();

            /* General */
            SHOW_VERSION_UPDATE = cf.get(CATEGORY_GENERAL, "SHOW_VERSION_UPDATE", true).getBoolean(true);
            AUTO_RESOLVE_IDS = cf.get(CATEGORY_GENERAL, "AUTO_RESOLVE_IDS", false).getBoolean(false);
            ENABLE_PARTICLES = cf.get(CATEGORY_GENERAL, "ENABLE_PARTICLES", true).getBoolean(true);
            GEN_ORE_COPPER = cf.get(CATEGORY_GENERAL, "GEN_ORE_COPPER", true).getBoolean(true);
            GEN_ORE_SILVER = cf.get(CATEGORY_GENERAL, "GEN_ORE_SILVER", true).getBoolean(true);
            GEN_ORE_PLATINUM = cf.get(CATEGORY_GENERAL, "GEN_ORE_PLATINUM", true).getBoolean(true);
            GEN_MELON = cf.get(CATEGORY_GENERAL, "GEN_MELON", true).getBoolean(true);
            GEN_CANTALOUPE = cf.get(CATEGORY_GENERAL, "GEN_CANTALOUPE", true).getBoolean(true);
            
            /* Block */
            BlockIDs.ores = cf.getBlock(CATEGORY_BLOCK, "block_ores", 400).getInt(400);
            BlockIDs.box = cf.getBlock(CATEGORY_BLOCK, "block_box", 401).getInt(401);
            BlockIDs.box2 = cf.getBlock(CATEGORY_BLOCK, "block_box2", 402).getInt(402);
            BlockIDs.box3 = cf.getBlock(CATEGORY_BLOCK, "block_box3", 403).getInt(403);
            BlockIDs.box4 = cf.getBlock(CATEGORY_BLOCK, "block_box4", 404).getInt(404);
            BlockIDs.box4 = cf.getBlock(CATEGORY_BLOCK, "block_box4", 405).getInt(405);
            BlockIDs.box5 = cf.getBlock(CATEGORY_BLOCK, "block_box5", 406).getInt(406);
            BlockIDs.box6 = cf.getBlock(CATEGORY_BLOCK, "block_box6", 407).getInt(407);
            BlockIDs.box7 = cf.getBlock(CATEGORY_BLOCK, "block_box7", 408).getInt(408);
            BlockIDs.crate = cf.getBlock(CATEGORY_BLOCK, "block_crate", 410).getInt(410);
            BlockIDs.crate2 = cf.getBlock(CATEGORY_BLOCK, "block_crate2", 411).getInt(411);
            BlockIDs.crate3 = cf.getBlock(CATEGORY_BLOCK, "block_crate3", 412).getInt(412);
            BlockIDs.crate4 = cf.getBlock(CATEGORY_BLOCK, "block_crate4", 413).getInt(413);
            BlockIDs.crate5 = cf.getBlock(CATEGORY_BLOCK, "block_crate5", 414).getInt(414);
            BlockIDs.crate6 = cf.getBlock(CATEGORY_BLOCK, "block_crate6", 415).getInt(415);
            BlockIDs.crate7 = cf.getBlock(CATEGORY_BLOCK, "block_crate7", 416).getInt(416);
            BlockIDs.playerPlate = cf.getBlock(CATEGORY_BLOCK, "block_player_plate", 419).getInt(419);
            BlockIDs.coloredGlass = cf.getBlock(CATEGORY_BLOCK, "block_colored_glass", 420).getInt(420);
            BlockIDs.machines = cf.getBlock(CATEGORY_BLOCK, "block_machines", 421).getInt(421);
            BlockIDs.beam = cf.getBlock(CATEGORY_BLOCK, "block_beam", 422).getInt(422);
            BlockIDs.chimney = cf.getBlock(CATEGORY_BLOCK, "block_chimney", 423).getInt(423);
            BlockIDs.stackBench = cf.getBlock(CATEGORY_BLOCK, "block_stack_bench", 424).getInt(424);
            BlockIDs.cantaloupe = cf.getBlock(CATEGORY_BLOCK, "block_cantaloupe", 425).getInt(425);
            BlockIDs.cantaloupeStem = cf.getBlock(CATEGORY_BLOCK, "block_cantaloupe_stem", 426).getInt(426);
            
            /* Item */
            ItemIDs.ingotCopper = cf.getItem(CATEGORY_ITEM, "ingot_copper", 1100).getInt();
            ItemIDs.ingotSilver = cf.getItem(CATEGORY_ITEM, "ingot_silver", 1101).getInt();
            ItemIDs.ingotPlatinum = cf.getItem(CATEGORY_ITEM, "ingot_platinum", 1102).getInt();
            
            ItemIDs.dusts = cf.getItem(CATEGORY_ITEM, "dusts", 1103).getInt();
            ItemIDs.coins = cf.getItem(CATEGORY_ITEM, "coins", 1104).getInt();
            ItemIDs.knife = cf.getItem(CATEGORY_ITEM, "knife", 1105).getInt();
            ItemIDs.nails = cf.getItem(CATEGORY_ITEM, "nails", 1106).getInt();
            ItemIDs.cardboard = cf.getItem(CATEGORY_ITEM, "cardboard", 1107).getInt();
            ItemIDs.boards = cf.getItem(CATEGORY_ITEM, "boards", 1108).getInt();
            ItemIDs.compost = cf.getItem(CATEGORY_ITEM, "compost", 1109).getInt();
            ItemIDs.cantaloupe = cf.getItem(CATEGORY_ITEM, "cantaloupe", 1110).getInt();
            ItemIDs.cantaloupeSeeds = cf.getItem(CATEGORY_ITEM, "cantaloupeSeeds", 1111).getInt();            
        }
        catch (Exception e) {
            Logisticraft.lcLog.severe("Logisticraft had a problem loading its configuration\n" + e);
        }
        finally {
        	cf.save();
        }
    }
}
