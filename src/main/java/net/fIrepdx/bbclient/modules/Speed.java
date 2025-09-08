package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.MinecraftClient;

public class Speed {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static double speedMultiplier = 1.3; // 30% speed boost
    
    public static boolean isEnabled() {
        return ConfigManager.isEnabled(Module.SPEED);
    }
    
    public static void onTick() {
        if (!isEnabled() || mc.player == null) return;
        
        if (mc.player.isOnGround() && 
            (mc.player.input.movementForward != 0 || mc.player.input.movementSideways != 0)) {
            
            // Apply subtle speed boost
            mc.player.setVelocity(
                mc.player.getVelocity().x * speedMultiplier,
                mc.player.getVelocity().y,
                mc.player.getVelocity().z * speedMultiplier
            );
        }
    }
    
    public static double getSpeedMultiplier() {
        return speedMultiplier;
    }
    
    public static void setSpeedMultiplier(double multiplier) {
        speedMultiplier = Math.max(1.0, Math.min(2.0, multiplier));
    }
}