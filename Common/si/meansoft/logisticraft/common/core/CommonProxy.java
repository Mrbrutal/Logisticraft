/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public static CommonProxy proxy;
	
	public void registerKeyBindingHandler() {}

    public void setKeyBinding(String name, int value) {}

    public void registerSoundHandler() {}

    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

	public void preloadTextures() {}
	
	/* LOCALIZATION */
	public String getCurrentLanguage() {
		return null;
	}
	
	public void addName(Object obj, String s) {}
	public void addLocalization(String s1, String string) {}
	public String getItemDisplayName(ItemStack newStack) { return ""; }
	
	public void addSmelting(ItemStack res, ItemStack prod) {
	    ModLoader.addSmelting(res.getIconIndex(), prod);
	}
}
