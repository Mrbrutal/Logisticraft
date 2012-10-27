/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * 
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.client.Minecraft;

import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.core.CommonProxy;
import si.meansoft.logisticraft.common.library.Info;

public class Localization {

    /**
     * Getting and formatting localization files.
     * 
     * @param path Path to the files.
     * @return An array of formatted file locations.
     * @throws URISyntaxException
     * @throws IOException
     */
    public String[] getFiles(String path) {
	String[] files = null;
	String[] files2 = null;

	try {
	    files = getResourceListing(this.getClass()/*Minecraft.class*/, path);
	} catch (URISyntaxException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	if (files != null) {
	    files2 = removeEl(files);
	}
	else {
	    System.out.println("No files in lang");
	}

	if (files2 != null) {
	    for (int i = 0; i < files2.length; i++) {
		System.out.println(files2[i]);
	    }
	}
	return files2;
    }

    /**
     * List directory contents for a resource folder.
     * 
     * @param clazz Any java class that lives in the same place as the resources you want.
     * @param path Should end with "/", but not start with one.
     * @return Just the name of each member item, not the full paths.
     * @throws URISyntaxException
     * @throws IOException
     */
    public String[] getResourceListing(Class clazz, String path) throws URISyntaxException, IOException {
	URL dirURL = clazz.getClassLoader().getResource(path);
	if (dirURL != null && dirURL.getProtocol().equals("file")) {
	    System.out.println("-----dirURL is a file!");
	    return new File(dirURL.toURI()).list();
	}

	if (dirURL == null) {
	    String me = clazz.getName().replace(".", "/") + ".class";
	    dirURL = clazz.getClassLoader().getResource(me);
	    System.out.println("-----dirURL is a file! : " + me);
	}

	if (dirURL.getProtocol().equals("jar")) {
	    String jarPath = dirURL.getPath().substring(5, dirURL.getPath().indexOf("!"));
	    JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
	    Enumeration<JarEntry> entries = jar.entries();
	    Set<String> result = new HashSet<String>();

	    while (entries.hasMoreElements()) {
		String name = entries.nextElement().getName();

		if (name.startsWith(path)) {
		    String entry = name.substring(path.length());
		    int checkSubdir = entry.indexOf("/");
		    if (checkSubdir >= 0) {
			entry = entry.substring(0, checkSubdir);
		    }
		    result.add(entry);
		}
	    }
	    return result.toArray(new String[result.size()]);
	}

	throw new UnsupportedOperationException("Cannot list files for URL " + dirURL);
    }

    /**
     * Remove empty array items.
     * 
     * @param input An array of items to be sorted and formated.
     * @return The same array as input, now formated.
     */
    public static String[] removeEl(String[] input) {
	List result = new LinkedList();

	for (String item : input) {
	    if (item.endsWith(".xml") && item != null) {
		item = Info.LANG_FILES + item;
		result.add(item);
	    }
	}

	return (String[]) result.toArray(new String[result.size()]);
    }
}
