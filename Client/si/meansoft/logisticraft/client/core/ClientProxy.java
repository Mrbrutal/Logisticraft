/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.client.core;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import si.meansoft.logisticraft.client.GUI.GuiStackCrafting;
import si.meansoft.logisticraft.client.renderers.TestRenderer;
import si.meansoft.logisticraft.common.core.CommonProxy;
import si.meansoft.logisticraft.common.library.GuiIDs;
import si.meansoft.logisticraft.common.library.Info;
import si.meansoft.logisticraft.common.library.RenderIDs;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerKeyBindingHandler() {
    }

    @Override
    public void setKeyBinding(String name, int value) {
    }

    @Override
    public void registerSoundHandler() {
    }

    @Override
    public void preloadTextures() {
	MinecraftForgeClient.preloadTexture(Info.TEX_BLOCK);
	MinecraftForgeClient.preloadTexture(Info.TEX_CRATES);
	MinecraftForgeClient.preloadTexture(Info.TEX_BOXES);
	MinecraftForgeClient.preloadTexture(Info.TEX_ITEM);
	//MinecraftForgeClient.preloadTexture(Info.TEX_CRATE);

	RenderIDs.crateID = RenderingRegistry.getNextAvailableRenderId();
	RenderingRegistry.registerBlockHandler(new TestRenderer());
    }

    @Override
    public World getClientWorld() {
	return FMLClientHandler.instance().getClient().theWorld;
    }

    /* LOCALIZATION */
    @Override
    public String getCurrentLanguage() {
	return StringTranslate.getInstance().getCurrentLanguage();
    }

    @Override
    public void addName(Object obj, String s) {
	LanguageRegistry.addName(obj, s);
    }

    @Override
    public void addLocalization(String s1, String string) {
	LanguageRegistry.instance().addStringLocalization(s1, string);
    }

    @Override
    public String getItemDisplayName(ItemStack stack) {
	if (Item.itemsList[stack.itemID] == null)
	    return "";

	return Item.itemsList[stack.itemID].getItemDisplayName(stack);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	if (ID == GuiIDs.GUI_STACKBENCH) {
	    return new GuiStackCrafting(player.inventory, world, x, y, z);
	}
	else {
	    return null;
	}
    }
}
