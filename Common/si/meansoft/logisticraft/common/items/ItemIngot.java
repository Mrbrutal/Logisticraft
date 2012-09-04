/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import si.meansoft.logisticraft.common.library.Info;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemIngot extends Item{

	protected ItemIngot(int par1) {
		super(par1);
		setMaxDamage(0);
		setMaxStackSize(64);
		setTabToDisplayOn(CreativeTabs.tabMaterials);
	}
	
	public String getTextureFile() {
		return Info.TEX_ITEM;
	}

}
