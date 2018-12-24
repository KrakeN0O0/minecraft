package com.mcground.mgmod.client.events;

import com.mcground.mgmod.client.handlers.MgmodRenderGameOverlayHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class MgmodClientEvents {

    Minecraft mc = Minecraft.getMinecraft();
    MgmodRenderGameOverlayHandler overlay = new MgmodRenderGameOverlayHandler();

    @SubscribeEvent
    public void gameRender(RenderGameOverlayEvent event) {
        if (event instanceof RenderGameOverlayEvent.Text && !this.mc.gameSettings.showDebugInfo) {
            // Здесь рендерить события из MgmodRenderGameOverlayHandler
            this.overlay.MgmodRenderGameOverlayHandler(mc);// init переменных
        }
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onDrawBlockHighlight(DrawBlockHighlightEvent e) {
        if (!e.player.capabilities.isCreativeMode) {
            e.setCanceled(true);// Отключаем подсвечивание граней кубов
            RenderManager.debugBoundingBox = false;// Отключаем подсветку хитбокса entity
        } else {
            e.setCanceled(false);// Включаем(если отключено) подсвечивание граней кубов
        }
    }
}
