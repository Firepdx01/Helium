package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;

public class Velocity {
    private static double horizontalMultiplier = 0.6; // Reduce horizontal knockback
    private static double verticalMultiplier = 1.0;   // Keep vertical knockback normal
    
    public static boolean isEnabled() {
        return ConfigManager.isEnabled(Module.VELOCITY);
    }
    
    public static double getHorizontalMultiplier() {
        return isEnabled() ? horizontalMultiplier : 1.0;
    }
    
    public static double getVerticalMultiplier() {
        return isEnabled() ? verticalMultiplier : 1.0;
    }
    
    public static void setHorizontalMultiplier(double multiplier) {
        horizontalMultiplier = Math.max(0.0, Math.min(1.0, multiplier));
    }
    
    public static void setVerticalMultiplier(double multiplier) {
        verticalMultiplier = Math.max(0.0, Math.min(1.0, multiplier));
    }
}