package net.fIrepdx.bbclient;

import net.minecraft.text.Text;

public enum Module {
    FPS("FPS Counter"),
    CPS("CPS Counter"),
    KEYSTROKES("Keystrokes"),
    FULLBRIGHT("FullBright"),
    TOGGLE_SPRINT("Toggle Sprint"),
    CROSSHAIR_DOT("Crosshair Dot"),
    WATERMARK("Watermark"),
    REACH("Reach"),
    VELOCITY("Velocity"),
    AUTO_CLICKER("Auto Clicker"),
    NO_FALL("No Fall"),
    SPEED("Speed");

    public final String display;

    Module(String d) {
        this.display = d;
    }

    public Text title() {
        return Text.literal(display);
    }
}
