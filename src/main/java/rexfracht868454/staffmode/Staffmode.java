package rexfracht868454.staffmode;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rexfracht868454.staffmode.commands.*;
import rexfracht868454.staffmode.listener.FreezeMovement;
import rexfracht868454.staffmode.listener.GodModeDamage;
import rexfracht868454.staffmode.listener.PlayerJoin;
import rexfracht868454.staffmode.untils.FreezeManager;
import rexfracht868454.staffmode.untils.GodManager;
import rexfracht868454.staffmode.untils.VanishManager;

public final class Staffmode extends JavaPlugin {

    private VanishManager vanishManager = new VanishManager(this);
    private GodManager godManager = new GodManager(this);

    private FreezeManager freezeManager = new FreezeManager(this);
    private String prefix = "§7[§aStaffmode§7] » ";
    @Override
    public void onEnable() {
        registerListener();
        getCommand("vanish").setExecutor(new Vanish(this));
        getCommand("god").setExecutor(new God(this));
        getCommand("freeze").setExecutor(new Freeze(this));
        getCommand("goto").setExecutor(new GoTo(this));
        getCommand("bringto").setExecutor(new BringTo(this));
        this.getLogger().info("Staffmode plugin enabled");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Staffmode plugin disabled");
    }

    private void registerListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new GodModeDamage(this), this);
        pluginManager.registerEvents(new PlayerJoin(this), this);
        pluginManager.registerEvents(new FreezeMovement(this), this);
    }

    public GodManager getGodManager() {
        return godManager;
    }

    public VanishManager getVanishManager() {
        return vanishManager;
    }

    public FreezeManager getFreezeManager() {
        return freezeManager;
    }
    public String getPrefix() {
        return prefix;
    }
}
