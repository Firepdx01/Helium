package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;

public class Reach {
    private static double reachDistance = 4.5; // Default reach distance (vanilla is 3.0)
    
    public static boolean isEnabled() {
        return ConfigManager.isEnabled(Module.REACH);
    }
    
    public static double getReachDistance() {
        return isEnabled() ? reachDistance : 3.0;
    }
    
    public static void setReachDistance(double distance) {
        reachDistance = Math.max(3.0, Math.min(6.0, distance)); // Clamp between 3.0 and 6.0
    }
}