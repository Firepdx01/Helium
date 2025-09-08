package net.fIrepdx.bbclient.mixin;

import net.fIrepdx.bbclient.KeyBindings;
import net.fIrepdx.bbclient.ui.ClientMenuScreen;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientTickMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onClientTick(CallbackInfo ci) {
        // Handle Right Shift key press to open GUI
        if (KeyBindings.openGui != null && KeyBindings.openGui.wasPressed()) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.currentScreen == null) { // Only open if no other screen is open
                client.setScreen(new ClientMenuScreen());
            }
        }
    }
}