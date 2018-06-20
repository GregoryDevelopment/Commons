package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;

import gg.kisurimc.spigot.utils.ColorUtil;
import gg.kisurimc.spigot.utils.Methods;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandListener {

    @CommandHandler(name = "gamemode", description = "sets player gamemode", permission = "commons.gamemode", aliases = "gm", usage = "<gamemode>")
    public void onGameModeCommand(CommandSender commandSender, String currentAlias, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            String gamemode = args[0];

            if(gamemode.equalsIgnoreCase("1")) {
                Methods.reset(player);
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ColorUtil.c("&eYour GameMode has been set to &6CREATIVE&e."));
            } else if(gamemode.equalsIgnoreCase("0")) {
                Methods.reset(player);
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ColorUtil.c("&eYour GameMode has been set to &6SURVIVAL&e."));
            }
        }
    }
}
