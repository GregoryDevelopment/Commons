package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandListener{

    @CommandHandler(name = "teleport", usage = "<player>", description = "Teleport to a player", aliases = "tp", permission = "commons.teleport")
    public void onTeleportCommand(CommandSender commandSender, String currentAlias, String[] args) {
        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            Player target = Bukkit.getServer().getPlayer(args[0]);


            if (target == null) {
                player.sendMessage(ChatColor.RED + "The player " + args[0] + " is not online");
                return;
            }

            player.teleport(target.getLocation());
            player.sendMessage(ChatColor.YELLOW + "You have teleported to " + target.getName());
            return;
        }

        commandSender.sendMessage(ChatColor.RED + "This command can only be executed by a player");
    }

    @CommandHandler(name = "teleporthere", usage = "<player>", description = "Teleport to a player", aliases = "tphere", permission = "commons.teleporthere")
    public void onTeleportHere(CommandSender commandSender, String currentAlias, String[] args) {
        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            Player target = Bukkit.getServer().getPlayer(args[0]);


            if (target == null) {
                player.sendMessage(ChatColor.RED + "The player " + args[0] + " is not online");
                return;
            }

            final Location loc = new Location(Bukkit.getWorld(player.getWorld().getName()),
                    player.getLocation().getX(),
                    player.getLocation().getY(),
                    player.getLocation().getZ(),
                    player.getLocation().getYaw(),
                    player.getLocation().getPitch());

            target.teleport(loc);
            player.sendMessage(ChatColor.BLUE + target.getName() + " has been teleported to you.");

            return;
        }

        commandSender.sendMessage(ChatColor.RED + "This command can only be executed by a player");
    }
}
