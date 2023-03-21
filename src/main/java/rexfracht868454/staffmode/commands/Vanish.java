package rexfracht868454.staffmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rexfracht868454.staffmode.Staffmode;

public class Vanish implements CommandExecutor {

    private Staffmode plugin;

    public Vanish(Staffmode plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("staff.vanish.cmd")) {
            if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(plugin.getPrefix() + "§4player not found");
                    return true;
                }
                if (plugin.getVanishManager().isVanished(player)) {
                    plugin.getVanishManager().setVanish(player, false);
                    sender.sendMessage(plugin.getPrefix() + "§4vanish for §e" + player.getName() + "§4 disabled");
                    player.sendMessage(plugin.getPrefix() + "§4vanish disabled");
                } else {
                    plugin.getVanishManager().setVanish(player, true);
                    sender.sendMessage(plugin.getPrefix() + "§2vanish for §e" + player.getName() + "§2 enabled");
                    player.sendMessage(plugin.getPrefix() + "§2vanish enabled");
                }
                return true;
            } else if (sender instanceof Player) {
                Player player = (Player) sender;

                if (plugin.getVanishManager().isVanished(player)) {
                    plugin.getVanishManager().setVanish(player, false);
                    sender.sendMessage(plugin.getPrefix() + "§4vanish disabled");
                } else {
                    plugin.getVanishManager().setVanish(player, true);
                    sender.sendMessage(plugin.getPrefix() + "§2vanish enabled");
                }
                return true;
            }
        }
        return false;
    }
}
