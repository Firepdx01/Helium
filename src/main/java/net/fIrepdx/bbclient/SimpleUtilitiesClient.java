package net.fIrepdx.bbclient;

import net.fabricmc.api.ClientModInitializer;
import net.fIrepdx.bbclient.render.HudRenderer;

public class SimpleUtilitiesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ConfigManager.init();
        KeyBindings.register();
        HudRenderer.init();
    }
}
