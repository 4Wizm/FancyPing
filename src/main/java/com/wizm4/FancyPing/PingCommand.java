package com.wizm4.FancyPing;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PingCommand implements CommandExecutor {

    private final FancyPing plugin;

    public PingCommand(FancyPing plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("\u00A7cSolo in gioco.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("fancyping.use.ping")) {
            player.sendMessage(FancyPing.color("&cNon hai il permesso."));
            return true;
        }

        int ping = getPing(player);

        String rawMessage = plugin.getConfig().getString("ping-message",
                "&aIl tuo ping e di &e%ping%ms&a.");

        String finalMessage = rawMessage
                .replace("%ping%", String.valueOf(ping))
                .replace("%player%", player.getName());

        player.sendMessage(FancyPing.color(finalMessage));

        return true;
    }

    private int getPing(Player player) {
        try {
            Method getPing = player.getClass().getMethod("getPing");
            return (int) getPing.invoke(player);
        } catch (NoSuchMethodException ignored) {
            try {
                Method getHandle = player.getClass().getMethod("getHandle");
                Object nmsPlayer = getHandle.invoke(player);

                Class<?> clazz = nmsPlayer.getClass();
                while (clazz != null) {
                    try {
                        Field pingField = clazz.getDeclaredField("ping");
                        pingField.setAccessible(true);
                        return pingField.getInt(nmsPlayer);
                    } catch (NoSuchFieldException e) {
                        clazz = clazz.getSuperclass();
                    }
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ping non disponibile per " + player.getName());
            }
        } catch (Exception e) {
            plugin.getLogger().warning("Errore ping: " + e.getMessage());
        }
        return 0;
    }
}
