/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.containers;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryCraftResult;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.World;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.core.StackCrafting;
import si.meansoft.logisticraft.common.core.StackCraftingManager;

public class ContainerStackbench extends Container {
    /** The crafting matrix inventory (3x3)+1. */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public InventoryCrafting craftMatrix2 = new InventoryCrafting(this, 1, 1);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerStackbench(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
	this.worldObj = par2World;
	this.posX = par3;
	this.posY = par4;
	this.posZ = par5;
	this.addSlotToContainer(new StackCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftMatrix2, this.craftResult, 0, 124, 53));
	int var6;
	int var7;

	for (var6 = 0; var6 < 3; ++var6) {
	    for (var7 = 0; var7 < 3; ++var7) {
		this.addSlotToContainer(new Slot(this.craftMatrix, var7 + var6 * 3, 30 + var7 * 18, 17 + var6 * 18));
	    }
	}

	for (var6 = 0; var6 < 3; ++var6) {
	    for (var7 = 0; var7 < 9; ++var7) {
		this.addSlotToContainer(new Slot(par1InventoryPlayer, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
	    }
	}

	for (var6 = 0; var6 < 9; ++var6) {
	    this.addSlotToContainer(new Slot(par1InventoryPlayer, var6, 8 + var6 * 18, 142));
	}
	
	this.addSlotToContainer(new Slot(this.craftMatrix2, 0, 124, 17));

	this.onCraftMatrixChanged(this.craftMatrix);
	//this.onCraftMatrixChanged(this.craftMatrix2);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory) {
	this.craftResult.setInventorySlotContents(0, StackCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.craftMatrix2));
	//GuiStackCrafting.drawNew(this.craftMatrix);
    }

    /**
     * Callback for when the crafting gui is closed.
     */
    public void onCraftGuiClosed(EntityPlayer par1EntityPlayer) {
	super.onCraftGuiClosed(par1EntityPlayer);

	if (!this.worldObj.isRemote) {
	    for (int var2 = 0; var2 < 9; ++var2) {
		ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);

		if (var3 != null) {
		    par1EntityPlayer.dropPlayerItem(var3);
		}
	    }
	    ItemStack var3 = this.craftMatrix2.getStackInSlotOnClosing(0);

	    if (var3 != null) {
		par1EntityPlayer.dropPlayerItem(var3);
	    }
	}
    }

    public boolean canInteractWith(EntityPlayer player) {
	return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != LCBlocks.stackBench.blockID ? false : player.getDistanceSq((double) this.posX + 0.5D, (double) this.posY + 0.5D, (double) this.posZ + 0.5D) <= 64.0D;
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift
     * clicking.
     */

    public ItemStack func_82846_b(EntityPlayer player, int par1) {
	ItemStack var2 = null;
	Slot var3 = (Slot) this.inventorySlots.get(par1);

	if (var3 != null && var3.getHasStack()) {
	    ItemStack var4 = var3.getStack();
	    var2 = var4.copy();

	    if (par1 == 0) {
		if (!this.mergeItemStack(var4, 10, 46, true)) {
		    return null;
		}

		var3.onSlotChange(var4, var2);
	    }
	    else if (par1 >= 10 && par1 < 37) {
		if (!this.mergeItemStack(var4, 37, 46, false)) {
		    return null;
		}
	    }
	    else if (par1 >= 37 && par1 < 46) {
		if (!this.mergeItemStack(var4, 10, 37, false)) {
		    return null;
		}
	    }
	    else if (!this.mergeItemStack(var4, 10, 46, false)) {
		return null;
	    }

	    if (var4.stackSize == 0) {
		var3.putStack((ItemStack) null);
	    }
	    else {
		var3.onSlotChanged();
	    }

	    if (var4.stackSize == var2.stackSize) {
		return null;
	    }
	    
	    var3.func_82870_a(player, var4);

	}
	return var2;
    }
}
