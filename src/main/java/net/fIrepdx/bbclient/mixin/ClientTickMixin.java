package net.fIrepdx.bbclient.mixin;

import net.fIrepdx.bbclient.KeyBindings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientTickMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onClientTick(CallbackInfo ci) {
        if (KeyBindings.openGui != null && KeyBindings.openGui.wasPressed()) {
            MinecraftClient client = MinecraftClient.getInstance();
            Screen screen = new OptionsScreen(client.currentScreen, client.options);
            client.setScreen(screen);
        }
    }
}
