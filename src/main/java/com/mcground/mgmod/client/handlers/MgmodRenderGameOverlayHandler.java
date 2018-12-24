package com.mcground.mgmod.client.handlers;

import com.mcground.mgmod.common.entities.ExtendedPlayer;
import com.mcground.mgmod.common.register.ResReg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

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

    public void renderStatBar(RenderGameOverlayEvent e){
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F,1.0F);
        GL11.glDisable(2896);
        this.mc.getTextureManager().bindTexture(ResReg.statBar);
        GL11.glEnable(3553);
        this.drawTexturedModalRect(-1, -2, 0, 0, 256, 256);
        GL11.glScalef(1.0047F, 0.1F, 0.1F);
        GL11.glPopMatrix();
    }
}
