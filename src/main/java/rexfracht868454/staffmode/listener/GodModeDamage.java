package rexfracht868454.staffmode.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import rexfracht868454.staffmode.Staffmode;

public class GodModeDamage implements Listener {

    private Staffmode plugin;

    public GodModeDamage(Staffmode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = ((Player) event.getEntity()).getPlayer();
            event.setCancelled(plugin.getGodManager().isGod(player));
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getEntity();
        if (plugin.getGodManager().isGod(event.getEntity().getPlayer())) {
            event.getEntity().setHealth(event.getEntity().getMaxHealth());
        }
    }

    @EventHandler
    public void onPlayerFoodLevel(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(plugin.getGodManager().isGod(((Player) event.getEntity()).getPlayer()));
        }
    }
}
