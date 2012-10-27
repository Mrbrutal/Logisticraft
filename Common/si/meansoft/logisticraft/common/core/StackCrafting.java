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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

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
	this.craftMatrix2 = inv3;
    }
   
    /*public void func_82870_a(EntityPlayer player, ItemStack par1ItemStack) {
	GameRegistry.onItemCrafted(thePlayer, par1ItemStack, craftMatrix);
	this.onCrafting(par1ItemStack);

	for (int var2 = 0; var2 < this.craftMatrix.getSizeInventory(); ++var2) {
	    ItemStack var3 = this.craftMatrix.getStackInSlot(var2);

	    if (var3 != null) {
		if (var3.getItemName().startsWith("tile.box")) {
		    this.craftMatrix.decrStackSize(var2, 1);
		}
		else {
		    this.craftMatrix.decrStackSize(var2, var3.getMaxStackSize());
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
	ItemStack var3 = this.craftMatrix2.getStackInSlot(0);
	if (var3 != null) {
	    this.craftMatrix2.decrStackSize(0, 1);
	    // System.out.println("Getting slot 0 with " + var3.getItemName());
	}
    }*/
    @Override
    public void func_82870_a(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
	GameRegistry.onItemCrafted(par1EntityPlayer, par2ItemStack, craftMatrix);
	this.onCrafting(par2ItemStack);

	for (int var3 = 0; var3 < this.craftMatrix.getSizeInventory(); ++var3) {
	    ItemStack var4 = this.craftMatrix.getStackInSlot(var3);

	    if (var4 != null) {
		if (var4.getItemName().startsWith("tile.box")) {
		    this.craftMatrix.decrStackSize(var3, 1);
		}
		else {
		    this.craftMatrix.decrStackSize(var3, var4.getMaxStackSize());
		}

		if (var4.getItem().hasContainerItem()) {
		    ItemStack var5 = var4.getItem().getContainerItemStack(var4);

		    if (var5.isItemStackDamageable() && var5.getItemDamage() > var5.getMaxDamage()) {
			MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, var5));
			var5 = null;
		    }

		    if (var5 != null && (!var4.getItem().doesContainerItemLeaveCraftingGrid(var4) || !this.thePlayer.inventory.addItemStackToInventory(var5))) {
			if (this.craftMatrix.getStackInSlot(var3) == null) {
			    this.craftMatrix.setInventorySlotContents(var3, var5);
			}
			else {
			    this.thePlayer.dropPlayerItem(var5);
			}
		    }
		}
	    }
	}
    }
}
