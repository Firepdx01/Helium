package net.fIrepdx.bbclient.modules;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;

public class AutoClicker {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static int minCPS = 8;
    private static int maxCPS = 12;
    private static long lastClick = 0;
    private static long nextClickDelay = 0;
    
    public static boolean isEnabled() {
        return ConfigManager.isEnabled(Module.AUTO_CLICKER);
    }
    
    public static void onTick() {
        if (!isEnabled() || mc.player == null) return;
        
        long currentTime = System.currentTimeMillis();
        
        // Only auto-click if looking at a block and holding left mouse
        if (mc.options.attackKey.isPressed() && 
            mc.crosshairTarget != null && 
            mc.crosshairTarget.getType() == HitResult.Type.BLOCK) {
            
            if (currentTime - lastClick >= nextClickDelay) {
                // Randomize click timing to avoid detection
                int randomCPS = minCPS + (int)(Math.random() * (maxCPS - minCPS + 1));
                nextClickDelay = 1000 / randomCPS + (int)(Math.random() * 50 - 25); // Add jitter
                
                if (mc.crosshairTarget instanceof BlockHitResult) {
                    mc.interactionManager.attackBlock(
                        ((BlockHitResult) mc.crosshairTarget).getBlockPos(),
                        ((BlockHitResult) mc.crosshairTarget).getSide()
                    );
                }
                
                lastClick = currentTime;
            }
        }
    }
    
    public static void setMinCPS(int cps) {
        minCPS = Math.max(1, Math.min(20, cps));
    }
    
    public static void setMaxCPS(int cps) {
        maxCPS = Math.max(minCPS, Math.min(20, cps));
    }
    
    public static int getMinCPS() {
        return minCPS;
    }
    
    public static int getMaxCPS() {
        return maxCPS;
    }
}