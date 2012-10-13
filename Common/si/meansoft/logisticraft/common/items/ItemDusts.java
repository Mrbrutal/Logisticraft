/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.items;

import java.util.List;

import si.meansoft.logisticraft.common.library.Info;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;

public class ItemDusts extends Item{
	
	public static final String[] dustNames = new String[] {"copper", "silver", "platinum"};
	
	public ItemDusts(int par1) {
		super(par1);
		setMaxDamage(0);
		setMaxStackSize(64);
		setHasSubtypes(true);
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureFile(Info.TEX_ITEM);
	}
	
	public int getIconFromDamage(int par1) {
        if(par1 == 0) {
        	return this.iconIndex + 2;
        }
        else if(par1 == 1) {
        	return this.iconIndex + 1;
        }
        else {
        	return this.iconIndex;
        }
    }

    public String getItemNameIS(ItemStack par1ItemStack) {
        return (new StringBuilder()).append(super.getItemName()).append(".").append(dustNames[par1ItemStack.getItemDamage()]).toString();
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int var4 = 0; var4 < 3; ++var4) {
            par3List.add(new ItemStack(this, 1, var4));
        }
    }
}
