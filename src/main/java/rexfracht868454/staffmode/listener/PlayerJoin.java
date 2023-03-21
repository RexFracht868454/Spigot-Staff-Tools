package rexfracht868454.staffmode.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import rexfracht868454.staffmode.Staffmode;

public class PlayerJoin implements Listener {

    private Staffmode plugin;

    public PlayerJoin(Staffmode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getVanishManager().hideAll(event.getPlayer());
    }
}
