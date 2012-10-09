/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import si.meansoft.logisticraft.common.library.Info;
import net.minecraft.src.*;

public class ItemBlockBox extends ItemBlock {

    public ItemBlockBox(int i) {
	super(i);
	setMaxDamage(0);
	setHasSubtypes(true);
	setMaxStackSize(64);
    }

    public String[] blockNames = Info.crateNames;

    public String getItemNameIS(ItemStack itemstack) {
	return (new StringBuilder()).append(super.getItemName()).append(".").append("Box of " + blockNames[itemstack.getItemDamage()]).toString();
    }

    public int getMetadata(int i) {
	return i;
    }

}
