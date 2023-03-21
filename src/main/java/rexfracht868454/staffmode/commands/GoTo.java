package rexfracht868454.staffmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rexfracht868454.staffmode.Staffmode;

public class GoTo implements CommandExecutor {

    private Staffmode plugin;

    public GoTo(Staffmode plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("staff.goto.cmd")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        sender.sendMessage(plugin.getPrefix() + "§4player not found");
                        return true;
                    } else {
                        player.teleport(target);
                        player.sendMessage(plugin.getPrefix() + "§2you got teleported to §e" + target.getName());
                    }
                } else {
                    player.sendMessage("§4You must select a player");
                }
            } else {
                sender.sendMessage("You must be an online player to use this command!");
            }
        }
        return false;
    }
}
