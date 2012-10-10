/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.util;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {
    public static void load() {
	// For every file specified in the Localization library class, load them into the Language Registry
	for (String localizationFile : Localization.files) {
		LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationHelper.getLocaleFromFileName(localizationFile), LocalizationHelper.isXMLLanguageFile(localizationFile));
	}
    }
}
