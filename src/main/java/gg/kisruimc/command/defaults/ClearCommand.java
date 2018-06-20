package gg.kisruimc.command.defaults;

import gg.kisruimc.Commons;
import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;
import gg.kisurimc.spigot.utils.ColorUtil;
import gg.kisurimc.spigot.utils.Methods;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearCommand implements CommandListener {

    @CommandHandler(name = "clear", description = "clears items", permission = "commons.clear")
    public void onProfileCommand(CommandSender commandSender, String currentAlias, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            Methods.reset(player);

            String name = "%player_name%";

            player.sendMessage(ColorUtil.c(Commons.messages.getString("COMMAND.CLEAR.MESSAGE").replaceAll(name, player.getName())));
        }
    }
}
