package net.fIrepdx.bbclient.mixin;

import net.fIrepdx.bbclient.ui.ClientMenuScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class InGameMenuMixin extends Screen {
    protected InGameMenuMixin(Text title) {
        super(title);
    }

    @Inject(method = "initWidgets", at = @At("TAIL"))
    private void addSimpleUtilitiesButton(CallbackInfo ci) {
        this.addDrawableChild(
                ButtonWidget.builder(Text.literal("Simple Utilities"), button -> {
                    MinecraftClient.getInstance().setScreen(new ClientMenuScreen());
                }).dimensions(this.width / 2 - 100, this.height / 4 + 120, 200, 20).build()
        );
    }
}
