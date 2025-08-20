package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;

public class CPSCounter {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    private static int leftClicks = 0, rightClicks = 0;
    private static int lCps = 0, rCps = 0;
    private static long lastTime = System.currentTimeMillis();

    public static void onTick() {
        if (!ConfigManager.isEnabled(Module.CPS)) return;

        long now = System.currentTimeMillis();
        if (now - lastTime >= 1000) {
            lCps = leftClicks;
            rCps = rightClicks;
            leftClicks = 0;
            rightClicks = 0;
            lastTime = now;
        }

        if (GLFW.glfwGetMouseButton(mc.getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_1) == GLFW.GLFW_PRESS) {
            leftClicks++;
        }
        if (GLFW.glfwGetMouseButton(mc.getWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_2) == GLFW.GLFW_PRESS) {
            rightClicks++;
        }
    }

    public static void render(DrawContext context) {
        if (ConfigManager.isEnabled(Module.CPS)) {
            String cps = "CPS: L " + lCps + " | R " + rCps;
            context.drawText(mc.textRenderer, cps, 5, 20, 0xFFFFFF, true);
        }
    }
}
