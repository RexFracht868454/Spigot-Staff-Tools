package rexfracht868454.staffmode.untils;

import org.bukkit.entity.Player;
import rexfracht868454.staffmode.Staffmode;
import java.util.ArrayList;
import java.util.List;

public class GodManager {

    private final Staffmode plugin;
    private final List<Player> god;

    public GodManager(Staffmode plugin) {
        this.plugin = plugin;
        this.god = new ArrayList<>();
    }
    public void setGod(Player player, boolean bool) {
        if (bool) {
            god.add(player);
        } else {
            god.remove(player);
        }
    }

    public boolean isGod(Player player) {
        return god.contains(player);
    }
    public List<Player> getGod() {
        return god;
    }
}
