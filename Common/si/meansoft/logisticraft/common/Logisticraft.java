/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common;

import java.io.File;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.core.CommonProxy;
import si.meansoft.logisticraft.common.core.Info;
import si.meansoft.logisticraft.common.core.Version;
import si.meansoft.logisticraft.common.core.handlers.Config;

@Mod(modid = Info.modID, name = Info.modName, version = Info.modVersion)
@NetworkMod(channels = { Info.channel }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)
public class Logisticraft {

	/* Logisticraft instance */
	@Instance
	public static Logisticraft instance;
	/* Sided proxies and proxy */
	@SidedProxy(clientSide = "si.meansoft.logisticraft.client.core.ClientProxy", serverSide = "si.meansoft.logisticraft.common.core.CommonProxy")
	public static CommonProxy proxy;
	/* Logger */
	public static Logger lcLog = Logger.getLogger(Info.modID);

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		event.getModMetadata().version = Version.fullVer();
		lcLog.setParent(FMLLog.getLogger());
		lcLog.info("Starting Logisticraft " + Version.fullVer() + "!");

		/* Register config file */
		Config.init(new File(event.getModConfigurationDirectory(), Info.modName + ".cfg"));
		
		/* Blocks + recipes */
		LCBlocks.loadBlocks();
		LCBlocks.registerBlocks();
		LCBlocks.nameBlocks();
		LCBlocks.blockRecipes();
		
		/* Items + recipes */
	}

	@Init
	public void load(FMLInitializationEvent evt) {
		
	}

	@PostInit
	public void modsLoaded(FMLPostInitializationEvent evt) {
		// All the mod checking here
	}
}
