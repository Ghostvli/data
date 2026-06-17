package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.lz4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static RemoteActionCompat read(lz4 lz4Var) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.a = (IconCompat) lz4Var.v(remoteActionCompat.a, 1);
        remoteActionCompat.b = lz4Var.l(remoteActionCompat.b, 2);
        remoteActionCompat.c = lz4Var.l(remoteActionCompat.c, 3);
        remoteActionCompat.d = (PendingIntent) lz4Var.r(remoteActionCompat.d, 4);
        remoteActionCompat.e = lz4Var.h(remoteActionCompat.e, 5);
        remoteActionCompat.f = lz4Var.h(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void write(RemoteActionCompat remoteActionCompat, lz4 lz4Var) {
        lz4Var.x(false, false);
        lz4Var.M(remoteActionCompat.a, 1);
        lz4Var.D(remoteActionCompat.b, 2);
        lz4Var.D(remoteActionCompat.c, 3);
        lz4Var.H(remoteActionCompat.d, 4);
        lz4Var.z(remoteActionCompat.e, 5);
        lz4Var.z(remoteActionCompat.f, 6);
    }
}
