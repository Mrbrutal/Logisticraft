/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import si.meansoft.logisticraft.common.library.Info;

public class ItemCoin extends Item{
	
	public static final String[] coinNames = new String[] {"Copper coin", "Silver coin", "Gold coin", "Platinum coin"};
	
	public ItemCoin(int par1) {
		super(par1);
		setMaxDamage(0);
		setMaxStackSize(64);
		setHasSubtypes(true);
		setTabToDisplayOn(CreativeTabs.tabBrewing);
	}
	
	public String getTextureFile() {
		return Info.TEX_ITEM;
	}
	
	public int getIconFromDamage(int par1) {
        int var2 = MathHelper.clamp_int(par1, 0, 4);
        return this.iconIndex - var2;
    }

    public String getItemNameIS(ItemStack par1ItemStack) {
        return coinNames[par1ItemStack.getItemDamage()];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int var4 = 0; var4 < 4; ++var4) {
            par3List.add(new ItemStack(this, 1, var4));
        }
    }
}