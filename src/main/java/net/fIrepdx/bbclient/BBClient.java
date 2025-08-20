package net.fIrepdx.bbclient;

import net.fabricmc.api.ClientModInitializer;

public class BBClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[BB Client] Initializing...");
        ConfigManager.init();
        KeyBindings.init(); // ✅ register keybind
    }
}
