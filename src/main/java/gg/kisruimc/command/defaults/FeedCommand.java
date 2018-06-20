package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;
import gg.kisurimc.spigot.utils.ColorUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandListener {

    @CommandHandler(name = "feed", description = "feed players", permission = "commons.feed")
    public void onFeedCommand(CommandSender commandSender, String currentAlias, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            player.setFoodLevel(20);
            player.sendMessage(ColorUtil.c("&eYou have been fed by &6CONSOLE!"));
        }
    }
}
