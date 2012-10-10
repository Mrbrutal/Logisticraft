package si.meansoft.logisticraft.common.core.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.core.CommonProxy;

public class Localization {

    public static String[] files;

    public static String[] getFiles(String path) {
	File folder = new File(path);
	System.out.println(path + " : " + folder.getName());
	String[] listOfFiles = folder.list();

	if(listOfFiles != null) {
	    for (int i = 0; i < listOfFiles.length; i++) {
		File f = new File(listOfFiles[i]);
		if (f.isFile() && f.getName().toLowerCase().endsWith(".xml")) {
		    files[i] = f.getName();
		    System.out.println(files);
		}
	    }
	}
	else {
	    Logisticraft.lcLog.severe("lang folder does not contain any language files.");
	}
	return files;
    }
}
