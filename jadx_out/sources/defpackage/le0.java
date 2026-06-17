package defpackage;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class le0 implements d42 {
    @Override // defpackage.d42
    public ag3 a(uu0 uu0Var) {
        return new lc1(uu0Var, Looper.getMainLooper(), 10);
    }

    @Override // defpackage.d42
    public boolean b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
