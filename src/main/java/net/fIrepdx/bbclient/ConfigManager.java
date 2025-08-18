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
        configPath = MinecraftClient.getInstance().runDirectory.toPath().resolve(FILE_NAME);
        for (Module m : Module.values()) states.put(m, false);
        load();
    }

    public static boolean isEnabled(Module m) {
        return states.getOrDefault(m, false);
    }

    public static void toggle(Module m) {
        states.put(m, !isEnabled(m));
        save();
    }

    private static void save() {
        try {
            JsonObject root = new JsonObject();
            for (Module m : Module.values()) root.addProperty(m.name(), isEnabled(m));
            Files.writeString(configPath, GSON.toJson(root), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void load() {
        if (Files.notExists(configPath)) return;
        try (Reader r = new InputStreamReader(new FileInputStream(configPath.toFile()), StandardCharsets.UTF_8)) {
            JsonObject root = GSON.fromJson(r, JsonObject.class);
            for (Module m : Module.values()) {
                if (root.has(m.name())) states.put(m, root.get(m.name()).getAsBoolean());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
