package com.spectrasonic.pvpswitch.Commands;

import com.spectrasonic.pvpswitch.Managers.PvPManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class PvPCommand implements CommandExecutor, TabCompleter {
    private final PvPManager pvpManager;

    public PvPCommand(PvPManager pvpManager) {
        this.pvpManager = pvpManager;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("pvpswitch.command.pvp")) {
            sender.sendMessage("No tienes permiso para usar este comando.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("Uso: /pvp <on|off>");
            return false;
        }

        switch (args[0].toLowerCase()) {
            case "on", "true":
                pvpManager.setPvP(true);
                sender.sendMessage("§aPvP activado.");
                break;
            case "off", "false":
                pvpManager.setPvP(false);
                sender.sendMessage("§cPvP desactivado.");
                break;
            default:
                sender.sendMessage("§eUso: /pvp <on|off>");
                return false;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.add("true");
            completions.add("false");
        }

        return completions;
    }
}