/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.util;

public class LocalizationHelper {

    public static boolean isXml(String fileName) {
	return fileName.endsWith(".xml");
    }

    public static String getLocaleFromFileName(String fileName) {
	return fileName.substring(fileName.lastIndexOf('/') + 1, fileName.lastIndexOf('.'));
    }
}
