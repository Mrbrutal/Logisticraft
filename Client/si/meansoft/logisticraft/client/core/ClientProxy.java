/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.client.core;

import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import si.meansoft.logisticraft.common.core.CommonProxy;
import si.meansoft.logisticraft.common.library.Info;
import si.meansoft.logisticraft.common.library.RenderIDs;
import si.meansoft.logisticraft.renderers.RenderCrate;

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
        MinecraftForgeClient.preloadTexture(Info.TEX_ITEM);
        
        //RenderingRegistry.instance().registerEntityRenderingHandler(EntityTest.class, new RenderCatTest());//TODO--NPE on texture load
        RenderIDs.crateID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderCrate());
    }
}
