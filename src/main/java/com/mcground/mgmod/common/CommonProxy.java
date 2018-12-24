package com.mcground.mgmod.common;

import com.mcground.mgmod.common.events.MgmodServerEvents;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {



    public void preInit(FMLPreInitializationEvent e){

    }


    public void init(FMLInitializationEvent e){
        // Регистрация фаилов с событиями на сервере
        MinecraftForge.EVENT_BUS.register(new MgmodServerEvents());
    }


    public void postInit(FMLPostInitializationEvent e){

    }

    public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return ctx.getServerHandler().playerEntity;
    }
}
