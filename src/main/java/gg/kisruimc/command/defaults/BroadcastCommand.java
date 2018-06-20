package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;

import gg.kisurimc.spigot.utils.ColorUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandListener {

    @CommandHandler(name = "broadcast", usage = "<message>" ,permission = "commons.broadcast", aliases = "bc", description = "global bc")
    public void onBroadcastCommand(CommandSender commandSender, String alis, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            final String message = StringUtils.join(args, " ");
            Bukkit.broadcastMessage(ColorUtil.c("&e[&6BC&e]&e " + message));
        }
    }
}
