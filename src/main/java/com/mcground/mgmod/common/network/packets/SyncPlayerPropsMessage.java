package com.mcground.mgmod.common.network.packets;

import com.mcground.mgmod.common.entities.ExtendedPlayer;
import com.mcground.mgmod.common.network.AbstractMessage;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class SyncPlayerPropsMessage extends AbstractMessage.AbstractClientMessage {

    private NBTTagCompound data;


    public SyncPlayerPropsMessage() {}

    public SyncPlayerPropsMessage(EntityPlayer player) {
        this.data = new NBTTagCompound();
        ExtendedPlayer.get(player).saveNBTData(this.data);
    }

    protected void read(PacketBuffer buffer) throws IOException {
        this.data = buffer.readNBTTagCompoundFromBuffer();
    }

    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeNBTTagCompoundToBuffer(this.data);
    }

    public void process(EntityPlayer player, Side side) {
        ExtendedPlayer.get(player).loadNBTData(this.data);
    }
}
