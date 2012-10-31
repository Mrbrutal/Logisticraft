/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;

import si.meansoft.logisticraft.common.Logisticraft;
import si.meansoft.logisticraft.common.core.handlers.ConfigHandler;
import si.meansoft.logisticraft.common.library.Info;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Version {
    private static String major;
    private static String minor;
    private static String rev;
    private static String sub;
    private static String forgever;
    private static String mcversion;
    private static String majorUp;
    private static String minorUp;
    private static String revUp;
    private static String subUp;
    private static String forgeverUp;
    private static String mcversionUp;
    private static boolean loaded;

    // All possible results of the remote version number check
    public static final byte UNN = 0; // Unninitialised
    public static final byte CUR = 1; // Current
    public static final byte OUT = 2; // Outdated
    public static final byte ERR = 3; // Errored

    // Var to hold the result of the remote version check, initially set to uninitialized
    public static byte result = UNN;

    private static void getVerCurrent() {
	InputStream stream = Version.class.getClassLoader().getResourceAsStream("lcver.properties");
	Properties properties = new Properties();

	if (stream != null) {
	    try {
		properties.load(stream);
		major = properties.getProperty("lc.build.major.number");
		minor = properties.getProperty("lc.build.minor.number");
		rev = properties.getProperty("lc.build.revision.number");
		sub = properties.getProperty("lc.build.subversion.number");
		forgever = properties.getProperty("lc.build.forgever.number");
		mcversion = properties.getProperty("lc.build.mcclientversion");
		//Logisticraft.lcLog.log(Level.SEVERE, (Info.MOD_PFX + "LO " + major + "." + minor + "." + rev + "_" + sub));
		stream.close();
	    } catch (IOException ex) {
		Logisticraft.lcLog.log(Level.SEVERE, (Info.MOD_PFX + "Could not get Logisticraft version information - corrupted installation, please reinstall!"), ex);
		throw new RuntimeException(ex);
	    }
	}
	else {
	    Logisticraft.lcLog.log(Level.SEVERE, (Info.MOD_PFX + "Stream returned null!"));
	}
	loaded = true;
    }

    @SuppressWarnings("unused") 
    private static void getVerUpdated() {
	URL url;
	try {
	    url = new URL(Info.REMOTE_VERSION);
	    InputStreamReader is = new InputStreamReader(url.openStream());
	    Properties properties = new Properties();

	    if (is != null) {
		try {
		    properties.load(is);
		    majorUp = properties.getProperty("lc.build.major.number");
		    minorUp = properties.getProperty("lc.build.minor.number");
		    revUp = properties.getProperty("lc.build.revision.number");
		    subUp = properties.getProperty("lc.build.subversion.number");
		    forgeverUp = properties.getProperty("lc.build.forgever.number");
		    mcversionUp = properties.getProperty("lc.build.mcclientversion");
		    //Logisticraft.lcLog.log(Level.SEVERE, (Info.MOD_PFX + " DB " + major + "." + minor + "." + rev + "_" + sub));
		    is.close();
		} catch (IOException ex) {
		    Logisticraft.lcLog.log(Level.SEVERE, (Info.MOD_PFX + "DB Could not get Logisticraft version information - corrupted installation, please reinstall!"), ex);
		    throw new RuntimeException(ex);
		}
	    }
	    else {
		Logisticraft.lcLog.log(Level.SEVERE, (Info.MOD_PFX + "DB Stream returned null!"));
	    }
	} catch (IOException e) {
	    Logisticraft.lcLog.log(Level.SEVERE, (Info.MOD_PFX + "No file found at URL!"));
	}
    }

    public static void checkVersion() {
	if (!verCurrent().contains("null") && !verUpdated().contains("null")) {
	    if (verCurrent().equals(verUpdated())) {
		result = CUR;
	    }
	    else {
		result = OUT;
	    }
	}
	else {
	    result = ERR;
	}
    }

    public static String getVerString() {
	if (ConfigHandler.SHOW_VERSION_UPDATE) {
	    switch (result) {
	    case UNN:
		return LanguageRegistry.instance().getStringLocalization(Info.UNN_MESSAGE);
	    case CUR:
		return LanguageRegistry.instance().getStringLocalization(Info.CUR_MESSAGE) + " Cur: \u00a72" + verCurrent() + "_" + sub + " \u00a7fNew: \u00a72" + verUpdated() + "_" + subUp;
	    case OUT:
		return LanguageRegistry.instance().getStringLocalization(Info.OUT_MESSAGE) + " Cur: \u00a74" + verCurrent() + "_" + sub + " \u00a7fNew: \u00a72" + verUpdated() + "_" + subUp + " \u00a7f" + LanguageRegistry.instance().getStringLocalization(Info.DL_MESSAGE) + "\u00a79 " + Info.REMOTE_DOWNLOAD;
	    case ERR:
		return "\u00a74" + LanguageRegistry.instance().getStringLocalization(Info.ERR_MESSAGE);
	    default:
		return "\u00a74" + LanguageRegistry.instance().getStringLocalization(Info.ERR_MESSAGE);
	    }
	}
	else {
	    return LanguageRegistry.instance().getStringLocalization(Info.VERSION_CHECK_DISABLED);
	}
    }

    public static final String verCurrent() {
	if (!loaded) {
	    getVerCurrent();
	}
	return major + "." + minor + "." + rev;
    }

    public static String fullVerCurrent() {
	if (!loaded) {
	    getVerCurrent();
	}
	return String.format("%s.%s.%s_%s for %s", major, minor, rev, sub, mcversion);
    }

    public static final String verUpdated() {
	getVerUpdated();
	return majorUp + "." + minorUp + "." + revUp;
    }

    public static String fullVerUpdated() {
	getVerUpdated();
	return String.format("%s.%s.%s_%s for %s", majorUp, minorUp, revUp, subUp, mcversionUp);
    }
}