package net.fIrepdx.bbclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.client.MinecraftClient;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Map;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_NAME = "simple_utilities.json";
    private static Path configPath;

    private static final Map<Module, Boolean> states = new EnumMap<>(Module.class);

    public static void init() {
        // ✅ safe run dir (in case client not yet ready)
        File runDir = MinecraftClient.getInstance() != null
                ? MinecraftClient.getInstance().runDirectory
                : new File(".");

        configPath = runDir.toPath().resolve(FILE_NAME);

        // ✅ set defaults first
        setDefaults();

        // ✅ if file exists → load it
        if (Files.exists(configPath)) {
            load();
        }

        // ✅ always save (creates file if missing)
        save();
    }

    private static void setDefaults() {
        states.put(Module.FULLBRIGHT, true);
        states.put(Module.FPS, true);
        states.put(Module.CPS, false);
        states.put(Module.KEYSTROKES, false);
        states.put(Module.WATERMARK, true);
        states.put(Module.TOGGLE_SPRINT, false);
        states.put(Module.CROSSHAIR_DOT, false);
    }

    public static boolean isEnabled(Module m) {
        return states.getOrDefault(m, false);
    }

    public static void toggle(Module m) {
        states.put(m, !isEnabled(m));
        save();
    }

    public static void set(Module m, boolean value) {
        states.put(m, value);
        save();
    }

    private static void save() {
        try {
            JsonObject root = new JsonObject();
            for (Module m : Module.values()) {
                root.addProperty(m.name(), isEnabled(m));
            }

            // ✅ auto-create if missing
            if (!Files.exists(configPath)) {
                Files.createFile(configPath);
            }

            Files.writeString(configPath, GSON.toJson(root), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("[SimpleUtilities] Failed to save config!");
            e.printStackTrace();
        }
    }

    private static void load() {
        try (Reader r = new InputStreamReader(new FileInputStream(configPath.toFile()), StandardCharsets.UTF_8)) {
            JsonObject root = GSON.fromJson(r, JsonObject.class);
            for (Module m : Module.values()) {
                if (root.has(m.name())) {
                    states.put(m, root.get(m.name()).getAsBoolean());
                }
            }
        } catch (Exception e) {
            System.err.println("[SimpleUtilities] Failed to load config, using defaults.");
            e.printStackTrace();
            setDefaults(); // fallback to safe defaults
        }
    }
}
