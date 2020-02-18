package com.gojek.trendingrepos.data.utils;

import android.util.Log;

/**
 * Logging class, used in debug mode
 */
public abstract class AppLogger {

    private static volatile boolean isDebugEnabled = true;

    /**
     * Used to enable or disable logging, and other debug features. Defaults to BuildConfig.DEBUG.
     *
     * @param enabled Debug features (like logging) are enabled if true, disabled if false.
     */
    public static void setIsDebugEnabled(boolean enabled) {
        isDebugEnabled = enabled;
    }

    /**
     * Indicates if we are in debug mode.
     */
    private static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static void logD(String tag, String msg) {
        if (isDebugEnabled() && tag != null && msg != null) {
            Log.d(tag, msg);
        }
    }

    public static void logI(String tag, String msg) {
        if (isDebugEnabled() && tag != null && msg != null) {
            Log.i(tag, msg);
        }
    }

    public static void logE(String tag, String e) {
        if (isDebugEnabled() && tag != null && e != null) {
            Log.e(tag, e);
        }
    }


}