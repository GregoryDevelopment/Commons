package gg.kisruimc.command.defaults;

import gg.kisruimc.command.CommandHandler;
import gg.kisruimc.command.CommandListener;
import gg.kisurimc.spigot.utils.ColorUtil;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandListener {

    @CommandHandler(name = "rename", permission = "commons.rename", usage = "<name>", description = "renames an item")
    public void onRenameCommand(CommandSender commandSender, String aliases, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            String rename = args[0];

            if(player.getItemInHand() == null || player.getItemInHand() == new ItemStack(Material.AIR)) {
                player.sendMessage(ColorUtil.c("&CPlease hold an item!"));
            } else {
                ItemMeta meta = player.getItemInHand().getItemMeta();
                meta.setDisplayName(ColorUtil.c(args[0].replace("_", " ")));
                player.getItemInHand().setItemMeta(meta);
                player.sendMessage(ColorUtil.c("&AYour item has been renamed!"));
            }
        }
    }
}
