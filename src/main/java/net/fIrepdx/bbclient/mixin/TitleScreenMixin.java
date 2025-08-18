package net.fIrepdx.bbclient.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fIrepdx.bbclient.ui.ClientMenuScreen;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void addSimpleUtilitiesButton(CallbackInfo ci) {
        this.addDrawableChild(
                ButtonWidget.builder(Text.literal("Simple Utilities"), button -> {
                    MinecraftClient.getInstance().setScreen(new ClientMenuScreen());
                }).dimensions(this.width / 2 - 100, this.height / 4 + 120, 200, 20).build()
        );
    }
}
