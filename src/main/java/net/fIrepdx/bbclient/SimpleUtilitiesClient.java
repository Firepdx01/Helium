package net.fIrepdx.bbclient;

import net.fabricmc.api.ClientModInitializer;

public class SimpleUtilitiesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[Simple Utilities] Initializing...");

        // Load saved states
        ConfigManager.init();

        // Register keybinds
        KeyBindings.init();

        // HudRenderer isn't needed if we already render via InGameHudMixin.
        // If you want a central HudRenderer class, call its init here instead.
    }
}
