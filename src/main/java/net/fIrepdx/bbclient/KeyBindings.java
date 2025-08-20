package net.fIrepdx.bbclient;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static KeyBinding openGui;

    public static void init() {
        openGui = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.bbclient.opengui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT, // Right Shift default
                "category.bbclient"
        ));
    }
}
