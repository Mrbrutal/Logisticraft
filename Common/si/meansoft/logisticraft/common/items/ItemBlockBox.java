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
    public String[] blockNames2 = Info.crateNames2;
    public String[] blockNames3 = Info.crateNames3;
    public String[] blockNames4 = Info.crateNames4;
    public String[] blockNames5 = Info.crateNames5;
    public String[] blockNames6 = Info.crateNames6;
    public String[] blockNames7 = Info.crateNames7;

    public String getItemNameIS(ItemStack itemstack) {
	Item stack = itemstack.getItem();
	if(stack.getItemName().endsWith("box")) {
	    return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames[itemstack.getItemDamage()]).toString();
	}
	else if(stack.getItemName().endsWith("box2")){
	    return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames2[itemstack.getItemDamage()]).toString();
	}
	else if(stack.getItemName().endsWith("box3")) {
	    return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames3[itemstack.getItemDamage()]).toString();
	}
	else if(stack.getItemName().endsWith("box4")) {
	    return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames4[itemstack.getItemDamage()]).toString();
	}
	else if(stack.getItemName().endsWith("box5")) {
	    return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames5[itemstack.getItemDamage()]).toString();
	}
	else if(stack.getItemName().endsWith("box6")) {
	    return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames6[itemstack.getItemDamage()]).toString();
	}
	else {
	    return (new StringBuilder()).append(super.getItemName()).append(".").append(blockNames7[itemstack.getItemDamage()]).toString();
	}
    }

    public int getMetadata(int i) {
	return i;
    }

}
