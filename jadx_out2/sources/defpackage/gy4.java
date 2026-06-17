package defpackage;

import android.app.NotificationChannel;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class gy4 {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR (r1v0 java.lang.String), (r2v0 java.lang.CharSequence), (r3v0 int) A[MD:(java.lang.String, java.lang.CharSequence, int):void (c)] (LINE:3) call: android.app.NotificationChannel.<init>(java.lang.String, java.lang.CharSequence, int):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ NotificationChannel a(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }
}
