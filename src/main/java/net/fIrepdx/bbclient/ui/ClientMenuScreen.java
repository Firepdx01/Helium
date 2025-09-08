package net.fIrepdx.bbclient.ui;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ClientMenuScreen extends Screen {
    public ClientMenuScreen() {
        super(Text.literal("BB Client"));
    }

    @Override
    protected void init() {
        int y = this.height / 4;

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getFullbrightText()), b -> {
            ConfigManager.toggle(Module.FULLBRIGHT);
            b.setMessage(Text.literal(getFullbrightText()));
        }).dimensions(this.width / 2 - 100, y, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getFpsText()), b -> {
            ConfigManager.toggle(Module.FPS);
            b.setMessage(Text.literal(getFpsText()));
        }).dimensions(this.width / 2 - 100, y + 25, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getCpsText()), b -> {
            ConfigManager.toggle(Module.CPS);
            b.setMessage(Text.literal(getCpsText()));
        }).dimensions(this.width / 2 - 100, y + 50, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getKeystrokesText()), b -> {
            ConfigManager.toggle(Module.KEYSTROKES);
            b.setMessage(Text.literal(getKeystrokesText()));
        }).dimensions(this.width / 2 - 100, y + 75, 200, 20).build());

        // Ghost Client Features
        this.addDrawableChild(ButtonWidget.builder(Text.literal(getReachText()), b -> {
            ConfigManager.toggle(Module.REACH);
            b.setMessage(Text.literal(getReachText()));
        }).dimensions(this.width / 2 - 100, y + 100, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getVelocityText()), b -> {
            ConfigManager.toggle(Module.VELOCITY);
            b.setMessage(Text.literal(getVelocityText()));
        }).dimensions(this.width / 2 - 100, y + 125, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getAutoClickerText()), b -> {
            ConfigManager.toggle(Module.AUTO_CLICKER);
            b.setMessage(Text.literal(getAutoClickerText()));
        }).dimensions(this.width / 2 - 100, y + 150, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getNoFallText()), b -> {
            ConfigManager.toggle(Module.NO_FALL);
            b.setMessage(Text.literal(getNoFallText()));
        }).dimensions(this.width / 2 - 100, y + 175, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getSpeedText()), b -> {
            ConfigManager.toggle(Module.SPEED);
            b.setMessage(Text.literal(getSpeedText()));
        }).dimensions(this.width / 2 - 100, y + 200, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
    }

    private String getFullbrightText() {
        return "Fullbright: " + (ConfigManager.isEnabled(Module.FULLBRIGHT) ? "ON" : "OFF");
    }

    private String getFpsText() {
        return "FPS Counter: " + (ConfigManager.isEnabled(Module.FPS) ? "ON" : "OFF");
    }

    private String getCpsText() {
        return "CPS Counter: " + (ConfigManager.isEnabled(Module.CPS) ? "ON" : "OFF");
    }

    private String getKeystrokesText() {
        return "Keystrokes: " + (ConfigManager.isEnabled(Module.KEYSTROKES) ? "ON" : "OFF");
    }

    private String getReachText() {
        return "Reach: " + (ConfigManager.isEnabled(Module.REACH) ? "ON" : "OFF");
    }

    private String getVelocityText() {
        return "Velocity: " + (ConfigManager.isEnabled(Module.VELOCITY) ? "ON" : "OFF");
    }

    private String getAutoClickerText() {
        return "Auto Clicker: " + (ConfigManager.isEnabled(Module.AUTO_CLICKER) ? "ON" : "OFF");
    }

    private String getNoFallText() {
        return "No Fall: " + (ConfigManager.isEnabled(Module.NO_FALL) ? "ON" : "OFF");
    }

    private String getSpeedText() {
        return "Speed: " + (ConfigManager.isEnabled(Module.SPEED) ? "ON" : "OFF");
    }
}
