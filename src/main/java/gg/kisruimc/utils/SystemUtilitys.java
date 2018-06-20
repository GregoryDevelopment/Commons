package gg.kisruimc.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class SystemUtilitys {

    private static final Runtime runtime = Runtime.getRuntime();

    public static long getFreeMemory() {
        return calculateMB(runtime.freeMemory());
    }

    public static long getMaxMemory() {
        return calculateMB(runtime.maxMemory());
    }

    public static long getTotalMemory() {
        return calculateMB(runtime.totalMemory());
    }

    public static int getTotalPrcessCount() {
        return ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class).getAvailableProcessors();
    }

    private static long calculateMB(long time) {
        return  time / 1024 / 1024;
    }
}
