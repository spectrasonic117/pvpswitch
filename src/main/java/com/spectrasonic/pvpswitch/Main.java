package com.spectrasonic.pvpswitch;

import com.spectrasonic.pvpswitch.Commands.PvPCommand;
import com.spectrasonic.pvpswitch.Managers.PvPManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    private PvPManager pvpManager;

    @Override
    public void onEnable() {
        pvpManager = new PvPManager(this);

        registerCommands();

        getLogger().info("PvPSwitch habilitado.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PvPSwitch deshabilitado.");
    }

    public void registerCommands() {
        Objects.requireNonNull(getCommand("pvp")).setExecutor(new PvPCommand(pvpManager));
        Objects.requireNonNull(getCommand("pvp")).setTabCompleter(new PvPCommand(pvpManager));
    }

}