package defpackage;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pu0 {
    public static String a(Context context, int i) {
        if (context == null) {
            return "";
        }
        if (i == 1) {
            return context.getString(mm3.d);
        }
        if (i != 7) {
            switch (i) {
                case 9:
                    break;
                case 10:
                    return context.getString(mm3.h);
                case 11:
                    return context.getString(mm3.g);
                case 12:
                    return context.getString(mm3.e);
                default:
                    Log.e("BiometricUtils", "Unknown error code: " + i);
                    return context.getString(mm3.b);
            }
        }
        return context.getString(mm3.f);
    }

    public static boolean b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 6:
            default:
                return false;
        }
    }

    public static boolean c(int i) {
        return i == 7 || i == 9;
    }
}
