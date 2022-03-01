package com.example.weatherapplication.utils;

import android.content.Context;
import android.provider.Settings;

public class DeviceUtils {
    public static boolean isDeviceRooted(Context context) {
        final String su = "su";
        final String[] locations = {
                "/sbin/", "/system/bin/", "/system/xbin/", "/system/sd/xbin/", "/system/bin/failsafe/",
                "/data/local/xbin/", "/data/local/bin/", "/data/local/"
        };
        for (final String location : locations) {
            if (new java.io.File(location + su).exists()) {
                return true;
            }
        }
        return false;
    }
    public static boolean isDebuggingEnabled(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ADB_ENABLED, 0) == 1;
    }
}
