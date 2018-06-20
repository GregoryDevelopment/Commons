package gg.kisruimc;

import gg.kisruimc.utils.C;

import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Commons extends JavaPlugin implements Listener {

    @Getter
    public static Commons instance;
    @Getter
    public static CommonsManager commonsManager;

    public static FileConfiguration messages;
    public static File mconf;

    @Override
    public void onEnable() {
        instance = this;

        this.commonsManager = new CommonsManager(this);

        Bukkit.getConsoleSender().sendMessage(C.c("Commons has been enabled! This is a network wide core"));

        messages = this.getConfig();
        messages.options().copyDefaults(true);
        mconf = new File(this.getDataFolder(), "config.yml");
        saveConfig();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        instance = this;

    }
}
