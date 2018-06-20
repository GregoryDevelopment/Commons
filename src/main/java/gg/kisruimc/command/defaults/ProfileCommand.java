package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;

import gg.kisurimc.spigot.utils.ColorUtil;
import org.bukkit.Statistic;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProfileCommand implements CommandListener {

    @CommandHandler(name = "profile", description = "shows the players profile")
    public void onProfileCommand(CommandSender commandSender, String currentAlias, String[] args) {
        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            player.sendMessage(ColorUtil.c("&7&m---------------------------------"));
            player.sendMessage(ColorUtil.c("&6" + player.getName() + "'s Profile"));
            player.sendMessage(ColorUtil.c("&6Kills:&F " + player.getStatistic(Statistic.PLAYER_KILLS)));
            player.sendMessage(ColorUtil.c("&6Deaths:&F " + player.getStatistic(Statistic.DEATHS)));
            player.sendMessage(ColorUtil.c("&6Credits:&CComing Soon! "));
            player.sendMessage(ColorUtil.c("&7&m---------------------------------"));
        }
    }
}
