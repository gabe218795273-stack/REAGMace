package me.reag.mace;

import org.bukkit.plugin.java.JavaPlugin;

public class REAGMace extends JavaPlugin {

    private static REAGMace instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new MaceListener(), this);
        getCommand("mace").setExecutor(new MaceCommand());

        getLogger().info("REAGMace has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("REAGMace has been disabled!");
    }

    public static REAGMace getInstance() {
        return instance;
    }
}
