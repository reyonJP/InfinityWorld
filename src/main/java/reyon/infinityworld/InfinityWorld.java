package reyon.infinityworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class InfinityWorld extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("sv").setExecutor(new CommandManager());
        Bukkit.getPluginManager().registerEvents(new GameManager(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}