package net.fIrepdx.bbclient.ui;

import net.fIrepdx.bbclient.ConfigManager;
import net.fIrepdx.bbclient.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ClientMenuScreen extends Screen {
    public ClientMenuScreen() {
        super(Text.literal("Helium Client"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int startY = this.height / 4 - 20;
        int buttonWidth = 200;
        int buttonHeight = 20;
        int spacing = 25;

        // Visual Features
        this.addDrawableChild(ButtonWidget.builder(Text.literal(getFullbrightText()), b -> {
            ConfigManager.toggle(Module.FULLBRIGHT);
            b.setMessage(Text.literal(getFullbrightText()));
        }).dimensions(centerX - buttonWidth/2, startY, buttonWidth, buttonHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getFpsText()), b -> {
            ConfigManager.toggle(Module.FPS);
            b.setMessage(Text.literal(getFpsText()));
        }).dimensions(centerX - buttonWidth/2, startY + spacing, buttonWidth, buttonHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getCpsText()), b -> {
            ConfigManager.toggle(Module.CPS);
            b.setMessage(Text.literal(getCpsText()));
        }).dimensions(centerX - buttonWidth/2, startY + spacing * 2, buttonWidth, buttonHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getKeystrokesText()), b -> {
            ConfigManager.toggle(Module.KEYSTROKES);
            b.setMessage(Text.literal(getKeystrokesText()));
        }).dimensions(centerX - buttonWidth/2, startY + spacing * 3, buttonWidth, buttonHeight).build());

        // Ghost Client Features
        this.addDrawableChild(ButtonWidget.builder(Text.literal(getReachText()), b -> {
            ConfigManager.toggle(Module.REACH);
            b.setMessage(Text.literal(getReachText()));
        }).dimensions(centerX - buttonWidth/2, startY + spacing * 4, buttonWidth, buttonHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getVelocityText()), b -> {
            ConfigManager.toggle(Module.VELOCITY);
            b.setMessage(Text.literal(getVelocityText()));
        }).dimensions(centerX - buttonWidth/2, startY + spacing * 5, buttonWidth, buttonHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getAutoClickerText()), b -> {
            ConfigManager.toggle(Module.AUTO_CLICKER);
            b.setMessage(Text.literal(getAutoClickerText()));
        }).dimensions(centerX - buttonWidth/2, startY + spacing * 6, buttonWidth, buttonHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getNoFallText()), b -> {
            ConfigManager.toggle(Module.NO_FALL);
            b.setMessage(Text.literal(getNoFallText()));
        }).dimensions(centerX - buttonWidth/2, startY + spacing * 7, buttonWidth, buttonHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal(getSpeedText()), b -> {
            ConfigManager.toggle(Module.SPEED);
            b.setMessage(Text.literal(getSpeedText()));
        }).dimensions(centerX - buttonWidth/2, startY + spacing * 8, buttonWidth, buttonHeight).build());

        // Close button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Close"), b -> {
            this.close();
        }).dimensions(centerX - 50, startY + spacing * 10, 100, buttonHeight).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        
        // Title
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        
        // Categories
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal("Visual Features"), this.width / 2, this.height / 4 - 40, 0x55FF55);
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal("Ghost Client Features"), this.width / 2, this.height / 4 + 60, 0xFF5555);
    }

    @Override
    public boolean shouldPause() {
        return false; // Don't pause the game when GUI is open
    }

    private String getFullbrightText() {
        return "Fullbright: " + (ConfigManager.isEnabled(Module.FULLBRIGHT) ? "§aON" : "§cOFF");
    }

    private String getFpsText() {
        return "FPS Counter: " + (ConfigManager.isEnabled(Module.FPS) ? "§aON" : "§cOFF");
    }

    private String getCpsText() {
        return "CPS Counter: " + (ConfigManager.isEnabled(Module.CPS) ? "§aON" : "§cOFF");
    }

    private String getKeystrokesText() {
        return "Keystrokes: " + (ConfigManager.isEnabled(Module.KEYSTROKES) ? "§aON" : "§cOFF");
    }

    private String getReachText() {
        return "Reach: " + (ConfigManager.isEnabled(Module.REACH) ? "§aON" : "§cOFF");
    }

    private String getVelocityText() {
        return "Velocity: " + (ConfigManager.isEnabled(Module.VELOCITY) ? "§aON" : "§cOFF");
    }

    private String getAutoClickerText() {
        return "Auto Clicker: " + (ConfigManager.isEnabled(Module.AUTO_CLICKER) ? "§aON" : "§cOFF");
    }

    private String getNoFallText() {
        return "No Fall: " + (ConfigManager.isEnabled(Module.NO_FALL) ? "§aON" : "§cOFF");
    }

    private String getSpeedText() {
        return "Speed: " + (ConfigManager.isEnabled(Module.SPEED) ? "§aON" : "§cOFF");
    }
}