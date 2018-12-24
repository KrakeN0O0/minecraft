package com.mcground.mgmod.common.events;

import com.mcground.mgmod.common.entities.ExtendedPlayer;
import com.mcground.mgmod.common.network.PacketDispatcher;
import com.mcground.mgmod.common.network.packets.SyncPlayerPropsMessage;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class MgmodSyncEvents {


    // Файл синхронизации ExtendedPlayer

    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        if (!event.entity.worldObj.isRemote && event.entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entityLiving;
            PacketDispatcher.sendTo(new SyncPlayerPropsMessage(player), (EntityPlayerMP) player);
        }
    }


    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null) {
            ExtendedPlayer.register((EntityPlayer) event.entity);
        }
    }


    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
            PacketDispatcher.sendTo(new SyncPlayerPropsMessage((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);
        }
    }

    @SubscribeEvent
    public void onClonePlayer(PlayerEvent.Clone event) {
        ExtendedPlayer.get(event.entityPlayer).copy(ExtendedPlayer.get(event.original));
    }

}
