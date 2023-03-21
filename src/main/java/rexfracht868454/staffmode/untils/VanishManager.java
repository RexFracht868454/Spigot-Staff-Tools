package rexfracht868454.staffmode.untils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import rexfracht868454.staffmode.Staffmode;

import java.util.ArrayList;
import java.util.List;

public class VanishManager {
    private final Staffmode plugin;
    private final List<Player> vanished;

    public VanishManager(Staffmode plugin) {
        this.plugin = plugin;
        this.vanished = new ArrayList<>();
    }
    public void setVanish(Player player, boolean bool) {
        if (bool) {
            vanished.add(player);
        } else {
            vanished.remove(player);
        }

        for (Player all: Bukkit.getOnlinePlayers()) {
            if (player.equals(all)) continue;
            if (bool) {
                all.hidePlayer(plugin, player);
            } else {
                all.showPlayer(plugin, player);
            }
        }
    }

    public void hideAll(Player player) {
        vanished.forEach(player1 -> player.hidePlayer(plugin, player1));
    }

    public boolean isVanished(Player player) {
        return vanished.contains(player);
    }
    public List<Player> getVanished() {
        return vanished;
    }
}
