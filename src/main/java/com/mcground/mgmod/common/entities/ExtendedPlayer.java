package com.mcground.mgmod.common.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {

    public static final String EXT_PROP_NAME = "ExtendedPlayer";
    private EntityPlayer player;



    public void init(Entity entity, World world) { }

    public ExtendedPlayer(EntityPlayer player) {
        this.player = player;
    }

    public static final void register(EntityPlayer player) {
        player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayer(player));
    }

    public static final ExtendedPlayer get(EntityPlayer player) {
        return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
    }

    public void copy(ExtendedPlayer props) {
        //Example:  this.experience = props.experience;

    }

    public final void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = new NBTTagCompound();

        //Example: properties.setFloat("hitscan", this.hitscan);
        compound.setTag(EXT_PROP_NAME, properties);
    }

    public final void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
        //Example: this.stamina = properties.getFloat("stamina");
    }

    public final EntityPlayer getEntityPlayer(ExtendedPlayer p) {
        return p.player;
    }



}