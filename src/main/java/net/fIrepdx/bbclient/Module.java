package net.fIrepdx.bbclient;

import net.minecraft.text.Text;

public enum Module {
    FPS("FPS Counter"),
    CPS("CPS Counter"),
    KEYSTROKES("Keystrokes"),
    FULLBRIGHT("FullBright"),
    TOGGLE_SPRINT("Toggle Sprint"),
    CROSSHAIR_DOT("Crosshair Dot");

    public final String display;
    Module(String d) { this.display = d; }

    public Text title() { return Text.literal(display); }
}
