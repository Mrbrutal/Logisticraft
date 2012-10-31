/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.handlers;

import java.util.EnumSet;

import si.meansoft.logisticraft.common.core.Version;
import si.meansoft.logisticraft.common.library.Info;

import com.sun.naming.internal.VersionHelper;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionHandler implements ITickHandler {

    private static boolean initialized = false;

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	if (ConfigHandler.SHOW_VERSION_UPDATE) {
	    if (!initialized) {
		for (TickType tickType : type) {
		    if (tickType == TickType.CLIENT) {
			if (FMLClientHandler.instance().getClient().currentScreen == null) {
			    initialized = true;
			    //if (Version.result != Version.CUR) {
				FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("\u00a7e" + "[" + Info.modID + "]\u00a7f " + Version.getVerString());
			    //}
			}
		    }
		}
	    }
	}
	else {
	    if (!initialized) {
		for (TickType tickType : type) {
		    if (tickType == TickType.CLIENT) {
			if (FMLClientHandler.instance().getClient().currentScreen == null) {
			    initialized = true;
			    FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("\u00a7e" + "[" + Info.modID + "]\u00a7f " + Info.VERSION_CHECK_DISABLED);
			}
		    }
		}
	    } 
	}
    }

    @Override
    public EnumSet<TickType> ticks() {
	return EnumSet.of(TickType.CLIENT);
    }

    @Override
    public String getLabel() {
	return Info.modName + ": " + this.getClass().getSimpleName();
    }

}
