package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;
import gg.kisurimc.spigot.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class ListCommand implements CommandListener {

    @CommandHandler(name = "list", description = "shows list of players", aliases = {"who", "whois"})
    public void onListCommand(CommandSender commandSender, String currentAlias, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;


            player.sendMessage(ColorUtil.c("&7&m---------------------------------"));
            player.sendMessage(ColorUtil.c("&ePlayers online this server is: "));
            player.sendMessage(ColorUtil.c("&7&m---------------------------------"));
        }
    }
}
