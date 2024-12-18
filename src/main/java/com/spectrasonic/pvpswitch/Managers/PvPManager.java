package com.spectrasonic.pvpswitch.Managers;

import com.spectrasonic.pvpswitch.Main;
import com.spectrasonic.pvpswitch.States.PvPState;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class PvPManager {

    private final Main plugin;
    private final PvPState pvpState;

    public PvPManager(Main main) {
        this.plugin = main;
        this.pvpState = new PvPState();
    }

    public void setPvP(boolean enabled) {
        pvpState.setPvP(enabled);
        for (World world : Bukkit.getWorlds()) {
            world.setPVP(enabled);
        }
        plugin.getLogger().info("PvP " + (enabled ? "activado" : "desactivado") + " en todos los mundos.");
    }

}