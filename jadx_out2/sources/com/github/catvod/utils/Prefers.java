package com.github.catvod.utils;

import android.content.SharedPreferences;
import defpackage.lg3;
import defpackage.yj1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Prefers {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean getBoolean(String str, boolean z) {
        try {
            return getPrefers().getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float getFloat(String str, float f) {
        try {
            return getPrefers().getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int getInt(String str, int i) {
        try {
            return getPrefers().getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SharedPreferences getPrefers() {
        return lg3.a(yj1.a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getString(String str, String str2) {
        try {
            return getPrefers().getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void put(String str, Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof String) {
            getPrefers().edit().putString(str, (String) obj).apply();
            return;
        }
        if (obj instanceof Boolean) {
            getPrefers().edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
            return;
        }
        if (obj instanceof Float) {
            getPrefers().edit().putFloat(str, ((Float) obj).floatValue()).apply();
            return;
        }
        if (obj instanceof Integer) {
            getPrefers().edit().putInt(str, ((Integer) obj).intValue()).apply();
            return;
        }
        if (obj instanceof Long) {
            getPrefers().edit().putLong(str, ((Long) obj).longValue()).apply();
            return;
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number.toString().contains(".")) {
                put(str, Float.valueOf(number.floatValue()));
            } else {
                put(str, Integer.valueOf(number.intValue()));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void remove(String str) {
        getPrefers().edit().remove(str).apply();
    }

    public static boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public static float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public static int getInt(String str) {
        return getInt(str, 0);
    }

    public static String getString(String str) {
        return getString(str, "");
    }
}
