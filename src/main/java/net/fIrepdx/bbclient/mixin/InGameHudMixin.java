package net.fIrepdx.bbclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    private static final int WATERMARK_X = 5;
    private static final int WATERMARK_Y = 5;
    private static final int WATERMARK_COLOR = 0xFFFFFF; // White color

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(DrawContext context, float tickDelta, CallbackInfo ci) {
        renderWatermark(context);
    }

    private void renderWatermark(DrawContext context) {
        context.drawText(
                MinecraftClient.getInstance().textRenderer,
                Text.literal("Simple Utilities Client").formatted(Formatting.AQUA),
                WATERMARK_X, WATERMARK_Y, WATERMARK_COLOR, true
        );
    }
}
