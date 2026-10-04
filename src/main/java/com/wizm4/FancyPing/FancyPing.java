package com.wizm4.FancyPing;

import org.bukkit.plugin.java.JavaPlugin;

public class FancyPing extends JavaPlugin {

    private static FancyPing instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        if (getCommand("ping") != null) {
            getCommand("ping").setExecutor(new PingCommand(this));
        }

        if (getCommand("reload") != null) {
            getCommand("reload").setExecutor((sender, command, label, args) -> {
                reloadConfig();
                String msg = getConfig().getString("reload-message", "&aRicaricato.");
                sender.sendMessage(color(msg));
                return true;
            });
        }

        getLogger().info("FancyPing abilitato!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FancyPing disabilitato.");
    }

    public static FancyPing getInstance() {
        return instance;
    }

    public static String color(String text) {
        return text == null ? "" : text.replace('&', '\u00A7');
    }
}