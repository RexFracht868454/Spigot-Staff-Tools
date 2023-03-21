package rexfracht868454.staffmode.untils;

import org.bukkit.entity.Player;
import rexfracht868454.staffmode.Staffmode;
import java.util.ArrayList;
import java.util.List;

public class FreezeManager {
    private final Staffmode plugin;
    private final List<Player> freezed;

    public FreezeManager(Staffmode plugin) {
        this.plugin = plugin;
        this.freezed = new ArrayList<>();
    }
    public void setFreeze(Player player, boolean bool) {
        if (bool) {
            freezed.add(player);
        } else {
            freezed.remove(player);
        }
    }

    public boolean isFreeze(Player player) {
        return freezed.contains(player);
    }
    public List<Player> getFreezed() {
        return freezed;
    }
}
