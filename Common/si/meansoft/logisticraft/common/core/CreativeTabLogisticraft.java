/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import si.meansoft.logisticraft.common.blocks.LCBlocks;

public class CreativeTabLogisticraft extends CreativeTabs {

    public CreativeTabLogisticraft(int par1, String par2Str) {
	super(par1, par2Str);
    }
    
    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(LCBlocks.chimney, 1, 2);
    }
    
    @Override
    public String getTranslatedTabLabel() {
        return super.getTabLabel();
    }

}
