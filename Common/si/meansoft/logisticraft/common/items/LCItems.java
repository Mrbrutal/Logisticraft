/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemSeeds;
import net.minecraftforge.common.EnumHelper;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.library.Info;
import si.meansoft.logisticraft.common.library.ItemIDs;

public class LCItems {

    public static Item ingotCopper;
    public static Item ingotSilver;
    public static Item ingotPlatinum;

    public static Item coins;
    public static Item dusts;
    public static Item knife;
    public static Item nails;
    public static Item cardboard;
    public static Item boards;
    public static Item compost;
    public static Item cantaloupe;
    public static Item cantaloupeSeeds;

    public static ItemBlockOres ores;

    /* Item declarations */
    public static void loadItems() {
	ingotCopper = new ItemIngot(ItemIDs.ingotCopper).setIconIndex(18).setCreativeTab(CreativeTabs.tabMaterials);
	ingotSilver = new ItemIngot(ItemIDs.ingotSilver).setIconIndex(17).setCreativeTab(CreativeTabs.tabMaterials);
	ingotPlatinum = new ItemIngot(ItemIDs.ingotPlatinum).setIconIndex(16).setCreativeTab(CreativeTabs.tabMaterials);

	coins = new ItemCoins(ItemIDs.coins).setIconCoord(5, 0);

	dusts = new ItemDusts(ItemIDs.dusts).setIconIndex(19);

	EnumToolMaterial materialKnife = EnumHelper.addToolMaterial("Knife", 1, 50, 5.0F, 1, 7);
	knife = new ItemKnife(ItemIDs.knife, materialKnife).setIconCoord(1, 0);
	nails = new ItemNails(ItemIDs.nails).setIconCoord(0, 0);
	cardboard = new ItemCardboard(ItemIDs.cardboard).setIconCoord(1, 3);
	boards = new ItemBoards(ItemIDs.boards).setIconCoord(0, 3);
	compost = new ItemCompost(ItemIDs.compost).setIconCoord(2, 2);
	cantaloupe = new ItemFood(ItemIDs.cantaloupe, 2, 0.3F, false).setIconCoord(0,2);
	cantaloupe.setTextureFile(Info.TEX_ITEM);
    }
    
    public static void loadItems2() {
	cantaloupeSeeds = new ItemSeeds(ItemIDs.cantaloupeSeeds, LCBlocks.cantaloupeStem.blockID, Block.tilledField.blockID).setIconCoord(1,2);
	cantaloupeSeeds.setTextureFile(Info.TEX_ITEM);
	cantaloupeSeeds.setItemName("cantaloupeSeeds");
    }

    /* Item names and translations */
    public static void nameItems() {
	ingotCopper.setItemName("copperIngot");
	ingotSilver.setItemName("silverIngot");
	ingotPlatinum.setItemName("platinumIngot");
	knife.setItemName("knife");
	dusts.setItemName("dust");
	coins.setItemName("coin");
	nails.setItemName("nails");
	cardboard.setItemName("cardboard");
	boards.setItemName("boards");
	compost.setItemName("compost");
	cantaloupe.setItemName("cantaloupe");
    }
}
