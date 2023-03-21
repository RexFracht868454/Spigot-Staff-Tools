package rexfracht868454.staffmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rexfracht868454.staffmode.Staffmode;

public class God implements CommandExecutor {

    private Staffmode plugin;

    public God(Staffmode plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("staff.god.cmd")) {
            if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(plugin.getPrefix() + "§4player not found");
                    return true;
                }
                if (plugin.getGodManager().isGod(player)) {
                    plugin.getGodManager().setGod(player, false);
                    sender.sendMessage(plugin.getPrefix() + "§4godmode for §e" + player.getName() + "§4 disabled");
                    player.sendMessage(plugin.getPrefix() + "§4godmode disabled");
                } else {
                    plugin.getGodManager().setGod(player, true);
                    sender.sendMessage(plugin.getPrefix() + "§2godmode for §e" + player.getName() + "§2 enabled");
                    player.sendMessage(plugin.getPrefix() + "§2godmode enabled");
                }
                return true;
            } else if (sender instanceof Player) {
                Player player = (Player) sender;

                if (plugin.getGodManager().isGod(player)) {
                    plugin.getGodManager().setGod(player, false);
                    sender.sendMessage(plugin.getPrefix() + "§4godmode disabled");
                } else {
                    plugin.getGodManager().setGod(player, true);
                    sender.sendMessage(plugin.getPrefix() + "§2godmode enabled");
                }
                return true;
            }
        }
        return false;
    }
}
