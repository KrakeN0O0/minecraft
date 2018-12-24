package com.mcground.mgmod.client.handlers;

import com.mcground.mgmod.common.entities.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class MgmodRenderGameOverlayHandler extends Gui {
    private Minecraft mc;
    private EntityClientPlayerMP player;
    private ExtendedPlayer explayer;
    private ScaledResolution scaledresolution;
    private float w, h;

    public void MgmodRenderGameOverlayHandler(Minecraft mc){
        this.mc = mc;
        this.player = this.mc.thePlayer;
        this.explayer = ExtendedPlayer.get(this.player);
        this.scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        this.w = this.scaledresolution.getScaledWidth();
        this.h = this.scaledresolution.getScaledHeight();
    }
}
