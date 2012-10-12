/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.util;

import si.meansoft.logisticraft.common.Logisticraft;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {
    public static void load() {

	String[] files = null;
	Localization loc = new Localization();
	files = loc.getFiles("si/meansoft/logisticraft/Resources/lang/");
	
	if(files != null) {
	    for (String file : files) {
		Logisticraft.lcLog.info("Adding language: " + LocalizationHelper.getLocaleFromFileName(file));
		LanguageRegistry.instance().loadLocalization(file, LocalizationHelper.getLocaleFromFileName(file), LocalizationHelper.isXml(file));
	    }
	}
	else {
	    Logisticraft.lcLog.severe("No language files found. Your installation might be corrupt!");
	}
    }
}
