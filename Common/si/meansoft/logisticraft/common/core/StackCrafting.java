/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import si.meansoft.logisticraft.common.blocks.LCBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.SlotCrafting;

public class StackCrafting extends SlotCrafting {

    /** The craft matrix inventory linked to this result slot. */
    private final IInventory craftMatrix;
    private final IInventory craftMatrix2;

    /** The player that is using the GUI where this slot resides. */
    private EntityPlayer thePlayer;

    /**
     * The number of items that have been crafted so far. Gets passed to ItemStack.onCrafting before being reset.
     */
    private int amountCrafted;
    
    public StackCrafting(EntityPlayer player, IInventory inv1, IInventory inv3, IInventory inv2, int x, int y, int z) {
	super(player, inv1, inv2, x, y, z);
	this.thePlayer = player;
        this.craftMatrix = inv1;
        this.craftMatrix2 = inv2;
    }

    @Override
    public void onPickupFromSlot(ItemStack par1ItemStack) {
	GameRegistry.onItemCrafted(thePlayer, par1ItemStack, craftMatrix);
	this.onCrafting(par1ItemStack);

	for (int var2 = 0; var2 < this.craftMatrix.getSizeInventory(); ++var2) {
	    ItemStack var3 = this.craftMatrix.getStackInSlot(var2);

	    if (var3 != null) {
		if (var3.getItemName().startsWith("tile.box")) {
		    this.craftMatrix.decrStackSize(var2, 1);
		    this.craftMatrix2.decrStackSize(0, 1);
		}
		else {
		    this.craftMatrix.decrStackSize(var2, var3.getMaxStackSize());
		    this.craftMatrix2.decrStackSize(0, 1);
		}

		if (var3.getItem().hasContainerItem()) {
		    ItemStack var4 = var3.getItem().getContainerItemStack(var3);

		    if (!var3.getItem().doesContainerItemLeaveCraftingGrid(var3) || !this.thePlayer.inventory.addItemStackToInventory(var4)) {
			if (this.craftMatrix.getStackInSlot(var2) == null) {
			    this.craftMatrix.setInventorySlotContents(var2, var4);
			}
			else {
			    this.thePlayer.dropPlayerItem(var4);
			}
		    }
		}
	    }
	}
	/*ItemStack var3 = this.craftMatrix2.getStackInSlot(0);
	if(var3 != null) {
	    this.craftMatrix2.decrStackSize(0, 1);
	}
	if (var3.getItem().hasContainerItem()) {
	    ItemStack var4 = var3.getItem().getContainerItemStack(var3);
	    if (!var3.getItem().doesContainerItemLeaveCraftingGrid(var3) || !this.thePlayer.inventory.addItemStackToInventory(var4)) {
		if (this.craftMatrix2.getStackInSlot(0) == null) {
		    this.craftMatrix2.setInventorySlotContents(0, var4);
		}
		else {
		    this.thePlayer.dropPlayerItem(var4);
		}
	    }
	}*/
    }
}
