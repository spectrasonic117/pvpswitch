package com.spectrasonic.pvpswitch.Commands;

import com.spectrasonic.pvpswitch.Managers.PvPManager;
import com.spectrasonic.pvpswitch.Utils.MessageUtils;
import com.spectrasonic.pvpswitch.Utils.SoundUtils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

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
            SoundUtils.playerSound((Player) sender, Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);

            MessageUtils.sendMessage(sender, "&eUso: /pvp <on|off>");
            return false;
        }

        switch (args[0].toLowerCase()) {
            case "on", "true":
                pvpManager.setPvP(true);
                SoundUtils.broadcastPlayerSound(Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 1.0f, 1.0f);
                MessageUtils.sendMessage(sender, "&aPvP activado.");
                break;
            case "off", "false":
                pvpManager.setPvP(false);
                SoundUtils.broadcastPlayerSound(Sound.BLOCK_RESPAWN_ANCHOR_SET_SPAWN, 1.0f, 1.0f);
                MessageUtils.sendMessage(sender, "&cPvP desactivado.");
                break;
            default:
                SoundUtils.playerSound((Player) sender, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);
                MessageUtils.sendMessage(sender, "&cEl comando no es valido.");
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