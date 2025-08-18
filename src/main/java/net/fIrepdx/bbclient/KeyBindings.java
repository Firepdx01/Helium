package net.fIrepdx.bbclient;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static KeyBinding openGui;

    public static void register() {
        openGui = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.simple_utilities.open_gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_U, // default key: U
                "category.simple_utilities"
        ));
    }
}
