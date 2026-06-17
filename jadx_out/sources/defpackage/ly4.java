package defpackage;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ly4 {
    public static void a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        e04.a("Must be called from the main thread.");
    }
}
