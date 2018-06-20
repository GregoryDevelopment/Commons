package gg.kisruimc;

import gg.kisruimc.command.CommandManager;
import gg.kisruimc.command.defaults.*;

import gg.kisruimc.listeners.HeadInfomationListener;
import gg.kisruimc.listeners.ProfileListener;

import gg.kisruimc.listeners.VanishHandler;
import gg.kisurimc.spigot.utils.ColorUtil;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class CommonsManager {

    private CommandManager commandManager;

    public CommonsManager(Commons commons) {

        /**
         * TODO: Make a command framework
         */

        //Listeners
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new ProfileListener(), commons);
        manager.registerEvents(new VanishHandler(), commons);
        manager.registerEvents(new HeadInfomationListener(), commons);


        commandManager = new CommandManager(commons);
        commandManager.setNoPermissionMessage(ColorUtil.c("&CYou dont have permissions!"));

        commandManager.registerCommands(new FlyCommand());
        commandManager.registerCommands(new BroadcastCommand());
        commandManager.registerCommands(new RenameCommand());
        commandManager.registerCommands(new KillCommand());
        commandManager.registerCommands(new ProfileCommand());
        commandManager.registerCommands(new TeleportCommand());
        commandManager.registerCommands(new GameModeCommand());
        commandManager.registerCommands(new ClearCommand());
        commandManager.registerCommands(new HealCommand());
        commandManager.registerCommands(new SystemCommand());
        commandManager.registerCommands(new FeedCommand());
        commandManager.registerCommands(new ListCommand());

        commons.getCommand("vanish").setExecutor(new VanishCommand());
    }
}
