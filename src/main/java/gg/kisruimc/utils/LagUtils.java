package gg.kisruimc.utils;

import gg.kisruimc.Commons;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LagUtils {

    private static double tps;

    public LagUtils() {
        new BukkitRunnable() {
            long sec;
            long currentSec;
            int ticks;

            public void run() {
                this.sec = System.currentTimeMillis() / 1000L;
                if (this.currentSec == this.sec) {
                    ++this.ticks;
                }
                else {
                    this.currentSec = this.sec;
                    LagUtils.tps = ((LagUtils.tps == 0.0) ? this.ticks : ((LagUtils.tps + this.ticks) / 2.0));
                    this.ticks = 0;
                }
            }
        }.runTaskTimer(Commons.getInstance(), 0L, 1L);
    }

    public static double getTPS() {
        return (LagUtils.tps + 1.0 > 20.0) ? 20.0 : (LagUtils.tps + 1.0);
    }

    public static int getPing(final Player player) {
        final CraftPlayer cp = (CraftPlayer)player;
        final EntityPlayer ep = cp.getHandle();
        return ep.ping;
    }
}
