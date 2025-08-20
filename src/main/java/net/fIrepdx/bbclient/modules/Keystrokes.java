package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;

public class Keystrokes {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(DrawContext context) {
        if (!ConfigManager.isEnabled(Module.KEYSTROKES)) return;

        long handle = mc.getWindow().getHandle();
        int x = 5, y = 50;

        drawKey(context, "W", GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS, x + 20, y);
        drawKey(context, "A", GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS, x, y + 20);
        drawKey(context, "S", GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS, x + 20, y + 20);
        drawKey(context, "D", GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS, x + 40, y + 20);

        drawKey(context, "LMB", GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_1) == GLFW.GLFW_PRESS, x, y + 50);
        drawKey(context, "RMB", GLFW.glfwGetMouseButton(handle, GLFW.GLFW_MOUSE_BUTTON_2) == GLFW.GLFW_PRESS, x + 40, y + 50);
    }

    private static void drawKey(DrawContext context, String key, boolean pressed, int x, int y) {
        int color = pressed ? 0x00FF00 : 0xFFFFFF;
        context.drawText(mc.textRenderer, key, x, y, color, true);
    }
}
