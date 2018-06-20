package gg.kisruimc.listeners;

import gg.kisruimc.Commons;
import gg.kisruimc.profile.Profile;
import gg.kisruimc.utils.C;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ProfileListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        new Profile(player.getUniqueId(), player.getName());

        player.sendMessage(C.c(Commons.messages.getString("PROFILE.MESSAGE")));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        Profile profile = Profile.getByUuid(player.getUniqueId());

        profile.getProfiles().remove(player.getUniqueId());
    }
}
