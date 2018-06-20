package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;

import gg.kisurimc.spigot.utils.ColorUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandListener {

    @CommandHandler
    public void onKillCommand(CommandSender commandSender, String alises, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            player.setHealth(0);
            player.sendMessage(ColorUtil.c("&cYou have taken your life"));
        }
    }
}
