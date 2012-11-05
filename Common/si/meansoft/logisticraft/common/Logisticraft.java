/*******************************************************************************
 * Copyright (c) 2012 Mrbrutal. All rights reserved.
 * @name Logisticraft
 * @author Mrbrutal
 * @licence Lesser GNU Public License v3 http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package si.meansoft.logisticraft.common;

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import si.meansoft.logisticraft.common.blocks.LCBlocks;
import si.meansoft.logisticraft.common.core.CommonProxy;
import si.meansoft.logisticraft.common.core.Version;
import si.meansoft.logisticraft.common.core.handlers.BonemealHandler;
import si.meansoft.logisticraft.common.core.handlers.ConfigHandler;
import si.meansoft.logisticraft.common.core.handlers.CraftingHandler;
import si.meansoft.logisticraft.common.core.handlers.ModHandler;
import si.meansoft.logisticraft.common.core.handlers.OreHandler;
import si.meansoft.logisticraft.common.core.handlers.PacketHandler;
import si.meansoft.logisticraft.common.core.handlers.VersionHandler;
import si.meansoft.logisticraft.common.core.util.LocalizationHandler;
import si.meansoft.logisticraft.common.generation.WorldGenWorld;
import si.meansoft.logisticraft.common.items.LCItems;
import si.meansoft.logisticraft.common.library.Info;
import si.meansoft.logisticraft.common.recipes.RecipesBlocks;
import si.meansoft.logisticraft.common.recipes.RecipesForestry;
import si.meansoft.logisticraft.common.recipes.RecipesIC2;
import si.meansoft.logisticraft.common.recipes.RecipesItems;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;

@Mod(modid = Info.modID, name = Info.modName, version=Info.modVersion, dependencies="required-after:Forge@[6.0.1,)") 
@NetworkMod(channels = { Info.channel }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class) 
public class Logisticraft {
    
    /* Logisticraft instance */
    @Instance(Info.modID) 
    public static Logisticraft instance;

    /* Sided proxies and proxy */
    @SidedProxy(clientSide = "si.meansoft.logisticraft.client.core.ClientProxy", serverSide = "si.meansoft.logisticraft.common.core.CommonProxy") 
    public static CommonProxy proxy;

    /* Logger */
    public static Logger lcLog = Logger.getLogger(Info.modID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
	event.getModMetadata().version = Version.fullVerCurrent();
	lcLog.setParent(FMLLog.getLogger());
	lcLog.info("Starting Logisticraft " + Version.fullVerCurrent() + "!");

	/* Localisation */
	LocalizationHandler.load();

	/* Register config file */
	ConfigHandler.init(new File(event.getModConfigurationDirectory(), Info.modName + ".cfg"));
	
	/* Check the version */
        if (ConfigHandler.SHOW_VERSION_UPDATE) {
        	Version.checkVersion();
        }
        
        /* Initialize the Version Handler  */
        TickRegistry.registerTickHandler(new VersionHandler(), Side.CLIENT);

	/* Preload textures */
	proxy.preloadTextures();

	/* Generators */
	GameRegistry.registerWorldGenerator(new WorldGenWorld());

	/* Register events */
	MinecraftForge.EVENT_BUS.register(new BonemealHandler());
    }

    @Init
    public void load(FMLInitializationEvent evt) {

	// Register the GUI Handler
	NetworkRegistry.instance().registerGuiHandler(instance, proxy);

	// Register the Crafting Handler
	GameRegistry.registerCraftingHandler(new CraftingHandler());

	/* Items */
	LCItems.loadItems();
	LCItems.nameItems();

	/* Blocks */
	LCBlocks.loadBlocks();
	LCBlocks.registerBlocks();
	LCBlocks.nameBlocks();

	/* Other items/blocks */
	LCItems.loadItems2();

	/* Ores */
	OreHandler.registerOres();

	/* Recipes */
	RecipesBlocks.blockRecipes();
	RecipesItems.itemRecipes();
	//RecipesStack.addRecipes();

	/* Seeds to grass */
	MinecraftForge.addGrassSeed(new ItemStack(Item.melonSeeds), 6);
	MinecraftForge.addGrassSeed(new ItemStack(LCItems.cantaloupeSeeds), 10);
    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent evt) {
	ModHandler.init();
	RecipesIC2.addIC2Recipes();
	RecipesForestry.addFORecipes();
    }
}
