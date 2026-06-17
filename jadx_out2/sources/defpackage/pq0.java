package defpackage;

import android.os.Build;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pq0 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(Window window) {
        if (Build.VERSION.SDK_INT < 35) {
            return window.getNavigationBarColor();
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(Window window, boolean z) {
        p95.a(window, window.getDecorView()).d(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c(Window window, int i) {
        if (Build.VERSION.SDK_INT < 35) {
            window.setStatusBarColor(i);
        }
    }
}
