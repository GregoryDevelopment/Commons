package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;

import gg.kisurimc.spigot.utils.ColorUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandListener {

    @CommandHandler(name = "heal", description = "heals player", permission = "commons.heal")
    public void onProfileCommand(CommandSender commandSender, String currentAlias, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            player.setHealth(20);
            player.sendMessage(ColorUtil.c("&eYou have been healed by &6CONSOLE"));
        }
    }
}
