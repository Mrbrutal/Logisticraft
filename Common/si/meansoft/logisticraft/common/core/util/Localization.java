package si.meansoft.logisticraft.common.core.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.Properties;

import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.core.CommonProxy;
import si.meansoft.logisticraft.common.library.Info;

public class Localization {

    public static String[] files;

    public static String[] getFiles(String path) {
	/*File folder = new File("D:\\Logisticraft1.3.2\\Project\\Logisticraft\\Resources\\");
	String path2 = Localization.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	String decodedPath = null;
	try {
	    decodedPath = URLDecoder.decode(path, "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
	System.out.println(decodedPath + " : " + folder.getName());
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
	}*/
	files = new String[]{Info.LANG_FILES + "en_US.xml"};
	
	return files;
    }
}
