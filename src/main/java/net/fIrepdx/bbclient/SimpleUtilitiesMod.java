package net.fIrepdx.bbclient;

import net.fIrepdx.bbclient.render.HudRenderer;
import net.fIrepdx.bbclient.ui.ClientMenuScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class SimpleUtilitiesMod implements ClientModInitializer {
    public static final String MODID = "simple_utilities";
    private static double oldGamma = 1.0;

    @Override
    public void onInitializeClient() {
        // Initialize configs, keybinds, and HUD renderer
        ConfigManager.init();
        KeyBindings.init();  // ✅ fixed
        HudRenderer.init();  // safe to keep (even if empty right now)

        // Handle key presses and features each client tick
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Open GUI when key is pressed
            while (KeyBindings.openGui.wasPressed()) {
                client.setScreen(new ClientMenuScreen());
            }

            // Apply Fullbright toggle
            if (ConfigManager.isEnabled(Module.FULLBRIGHT)) {
                if (client.options.getGamma().getValue() != 16.0) {
                    oldGamma = client.options.getGamma().getValue();
                    client.options.getGamma().setValue(16.0); // max gamma
                }
            } else {
                if (client.options.getGamma().getValue() == 16.0) {
                    client.options.getGamma().setValue(oldGamma); // restore previous gamma
                }
            }
        });
    }

    public static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }
}
