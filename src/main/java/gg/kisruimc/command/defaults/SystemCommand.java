package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;

import gg.kisruimc.utils.SystemUtilitys;
import gg.kisurimc.spigot.utils.ColorUtil;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SystemCommand implements CommandListener {

    @CommandHandler(name = "system", permission = "commons.system", description = "views system usages!")
    public void onSystemCommand(CommandSender commandSender, String aliases, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            player.sendMessage(ColorUtil.c("&eMax Memory: &6" + SystemUtilitys.getMaxMemory()));
            player.sendMessage(ColorUtil.c("&EFree Memory: &6" + SystemUtilitys.getFreeMemory()));
            player.sendMessage(ColorUtil.c("&EProcesses: &6" + SystemUtilitys.getTotalPrcessCount()));
            player.sendMessage(ColorUtil.c("&eTotal Memory: &6" + SystemUtilitys.getTotalMemory()));
        }
    }
}
