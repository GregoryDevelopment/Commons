package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;

import gg.kisurimc.spigot.utils.ColorUtil;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandListener {

    @CommandHandler(name = "fly", description = "player fly mode", permission = "commons.fly")
    public void onFlyCommand(CommandSender commandSender, String alis, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (!player.getAllowFlight()) {
                player.setAllowFlight(true);
                player.sendMessage(ColorUtil.c("&eYour fly mode has been set to &6True"));
            } else {
                player.setAllowFlight(false);
                player.sendMessage(ColorUtil.c("&eYour fly mode has been set to &6False"));
            }
        }
    }
}
