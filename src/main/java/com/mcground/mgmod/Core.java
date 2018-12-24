package com.mcground.mgmod;

import com.mcground.mgmod.common.CommonProxy;
import com.mcground.mgmod.common.logger.MgmodLog;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.Mod;

@Mod(
        modid = Core.MODID,
        name = Core.MODNAME,
        version = Core.VERSION
)
public class Core
{
    public static final String MODID = "mgmod";
    public static final String MODNAME = "Mcground mod";
    public static final String VERSION = "0.0.1";
    public static final String BUILD = "1";


    @Mod.Instance("mgmod")
    public static Core instance;
    @SidedProxy(
            clientSide = "com.mcground.mgmod.rpg.client.ClientProxy",
            serverSide = "com.mcground.mgmod.rpg.common.CommonProxy"
    )
    public static CommonProxy proxy;




    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent e) {
        MgmodLog.success("Mgmod server side successfully started");
    }

    @Mod.EventHandler
    public void serverStoping(FMLServerStoppingEvent e) {
        MgmodLog.success("Mgmod server side successfully stopped");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        //PacketDispatcher.registerPackets();
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init(e);
        MgmodLog.success("Mgmod Mod has been successfully initialized");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){
        proxy.postInit(e);

    }
}
