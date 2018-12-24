package com.mcground.mgmod.client;

import com.mcground.mgmod.client.events.MgmodClientEvents;
import com.mcground.mgmod.common.CommonProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;


@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {


    public void preInit(FMLPreInitializationEvent e){
        super.preInit(e);

    }


    public void init(FMLInitializationEvent e){
        super.init(e);
        // Регистрация фаилов с событиями на клиенте
        Example:MinecraftForge.EVENT_BUS.register(new MgmodClientEvents());
    }


    public void postInit(FMLPostInitializationEvent e){
        super.postInit(e);

    }

    public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return (EntityPlayer) (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
    }
}
