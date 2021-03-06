/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockMachines extends ItemBlock {

    public ItemBlockMachines(int i) {
	super(i);
	setMaxDamage(0);
	setHasSubtypes(true);
	setMaxStackSize(64);
    }

    public String[] blockNames = { "lavaRemover", "lavaRemoverOn", "lavaRemoverBlock", "timeSetter", "reflector", "reflectorOn" };

    public String getItemNameIS(ItemStack itemstack) {
	return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames[itemstack.getItemDamage()]).toString();
    }

    public int getMetadata(int i) {
	return i;
    }

}
