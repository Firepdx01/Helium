package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class FPSCounter {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(DrawContext context) {
        if (ConfigManager.isEnabled(Module.FPS)) {
            String fps = "FPS: " + mc.getCurrentFps();
            context.drawText(mc.textRenderer, fps, 5, 5, 0xFFFFFF, true);
        }
    }
}
