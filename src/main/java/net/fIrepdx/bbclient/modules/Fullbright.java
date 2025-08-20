package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.MinecraftClient;

public class Fullbright {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static double oldGamma = 1.0;

    public static void onTick() {
        if (ConfigManager.isEnabled(Module.FULLBRIGHT)) {
            if (mc.options.getGamma().getValue() != 1000.0) {
                oldGamma = mc.options.getGamma().getValue();
                mc.options.getGamma().setValue(1000.0);
            }
        } else {
            if (mc.options.getGamma().getValue() == 1000.0) {
                mc.options.getGamma().setValue(oldGamma);
            }
        }
    }
}
