package net.fIrepdx.bbclient;

import net.fIrepdx.bbclient.render.HudRenderer;
import net.fIrepdx.bbclient.ui.ClientMenuScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class SimpleUtilitiesMod implements ClientModInitializer {
    public static final String MODID = "simple_utilities";

    @Override
    public void onInitializeClient() {
        // Initialize configs, keybinds, and HUD renderer
        ConfigManager.init();
        KeyBindings.register(); // <-- fixed, was KeyBindings.init()
        HudRenderer.init();

        // Handle key presses and features each client tick
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Open GUI when key is pressed
            while (KeyBindings.openGui.wasPressed()) {
                client.setScreen(new ClientMenuScreen());
            }

            // Apply Fullbright if enabled
            if (ConfigManager.isEnabled(Module.FULLBRIGHT)) {
                client.options.getGamma().setValue(16.0); // max gamma
            } else {
                client.options.getGamma().setValue(1.0); // default
            }
        });
    }

    public static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }
}
