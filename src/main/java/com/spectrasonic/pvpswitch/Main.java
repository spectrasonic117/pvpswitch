package com.spectrasonic.pvpswitch;

import com.spectrasonic.pvpswitch.Commands.PvPCommand;
import com.spectrasonic.pvpswitch.Managers.PvPManager;
import com.spectrasonic.pvpswitch.Utils.MessageUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    private PvPManager pvpManager;

    @Override
    public void onEnable() {
        pvpManager = new PvPManager(this);

        registerCommands();

        MessageUtils.sendStartupMessage(this);
    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("pvp")).setExecutor(new PvPCommand(pvpManager));
        Objects.requireNonNull(getCommand("pvp")).setTabCompleter(new PvPCommand(pvpManager));
    }

}