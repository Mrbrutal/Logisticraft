package si.meansoft.logisticraft;

import java.lang.reflect.Method;
import java.util.logging.Level;

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

@Mod(modid = "Logisticraft", name = "Logisticraft", version = "1.0.0")
@NetworkMod(channels = { "Logisticraft" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Logisticraft {
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
	}

	@Init
	public void load(FMLInitializationEvent evt) {
		
	}

	@PostInit
	public void modsLoaded(FMLPostInitializationEvent evt) {
		
	}
}
