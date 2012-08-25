/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at 
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Mrbrutal
 ******************************************************************************/

package si.meansoft.logisticraft.common.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import cpw.mods.fml.common.FMLCommonHandler;

public final class Version {
	public static String fullVersion;
	private static String major;
	private static String minor;
	private static String rev;
	private static String sub;
	private static String forgever;
	private static String mcversion;
	private static boolean loaded;

	private static void init() {
		InputStream stream = Version.class.getClassLoader()
				.getResourceAsStream("lcver.properties");
		Properties properties = new Properties();

		if (stream != null) {
			try {
				properties.load(stream);
				major = properties.getProperty("lc.build.major.number");
				minor = properties.getProperty("lc.build.minor.number");
				rev = properties.getProperty("lc.build.revision.number");
				sub = properties.getProperty("lc.build.subversion.number");
				forgever = properties.getProperty("lc.build.forgever.number");
				mcversion = properties.getProperty("lc.build.mcversion");
			} catch (IOException ex) {
				FMLCommonHandler
						.instance()
						.getFMLLogger()
						.log(Level.SEVERE,
								"[LC]Could not get Logisticraft version information - corrupted installation detected, please reinstall!",
								ex);
				throw new RuntimeException(ex);
			}
		}
		loaded = true;
	}

	public static final String ver() {
		if (!loaded) {
			init();
		}
		return major + "." + minor + "." + rev;
	}

	public static String fullVer() {
		if (!loaded) {
			init();
			fullVersion = String.format("%s.%s.%s_%s for %s", major, minor,
					rev, sub, mcversion);
		}
		return String.format("%s.%s.%s_%s for %s", major, minor, rev, sub,
				mcversion);
	}
}