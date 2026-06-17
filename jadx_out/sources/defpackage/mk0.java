package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mk0 {
    public static boolean a(int i) {
        if (i == 8 || i == 7) {
            return true;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 31 || !(i == 26 || i == 27)) {
            return i2 >= 33 && i == 30;
        }
        return true;
    }

    public static boolean b(int i) {
        return i == 1;
    }

    public static boolean c(int i) {
        return i == 2;
    }

    public static boolean d(int i) {
        return i == 10;
    }

    public static boolean e(int i) {
        return Build.VERSION.SDK_INT >= 31 && i == 29;
    }

    public static boolean f(int i) {
        if (i == 11 || i == 12) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 31 && i == 22;
    }
}
