package net.fIrepdx.bbclient.render;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class HudRenderer {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void init() {
        HudRenderCallback.EVENT.register(HudRenderer::onHudRender);
    }

    private static void onHudRender(DrawContext context, float tickDelta) {
        int x = 5;
        int y = 5;

        if (ConfigManager.isEnabled(Module.FPS)) {
            String fps = "FPS: " + client.getCurrentFps();
            context.drawText(client.textRenderer, fps, x, y, 0xFFFFFF, true);
            y += 12;
        }

        if (ConfigManager.isEnabled(Module.CPS)) {
            // Just a placeholder CPS counter (implement real CPS logic later)
            String cps = "CPS: 0";
            context.drawText(client.textRenderer, cps, x, y, 0xFFFFFF, true);
            y += 12;
        }

        if (ConfigManager.isEnabled(Module.KEYSTROKES)) {
            // Example: simple WASD keystrokes indicator
            String keys = "";
            if (client.options.forwardKey.isPressed()) keys += "W ";
            if (client.options.leftKey.isPressed()) keys += "A ";
            if (client.options.backKey.isPressed()) keys += "S ";
            if (client.options.rightKey.isPressed()) keys += "D ";
            context.drawText(client.textRenderer, "Keys: " + keys, x, y, 0xFFFFFF, true);
        }
    }
}
