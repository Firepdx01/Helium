package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;

public class NoFall {
    public static boolean isEnabled() {
        return ConfigManager.isEnabled(Module.NO_FALL);
    }
    
    public static boolean shouldCancelFallDamage() {
        return isEnabled();
    }
}