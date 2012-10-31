/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.handlers;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import si.meansoft.logisticraft.common.blocks.BlockStem2;
import si.meansoft.logisticraft.common.blocks.LCBlocks;

public class BonemealHandler {

    @ForgeSubscribe
    public void onUseBonemeal(BonemealEvent event) {
	if (event.ID == LCBlocks.cantaloupeStem.blockID) {
	    if (!event.world.isRemote) {
		((BlockStem2)LCBlocks.cantaloupeStem).fertilizeStem(event.world, event.X, event.Y, event.Z);
	    }
	}
    }
}
