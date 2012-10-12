/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class ItemBlockOres extends ItemBlock {
	public ItemBlockOres(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(64);
	}
	public String[] blockNames = { "platinum", "silver", "copper"};
	
	public String getItemNameIS(ItemStack par1ItemStack) {
        return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames[par1ItemStack.getItemDamage()]).toString();
    }
	
	public int getMetadata(int i) {
		return i;
	}
}