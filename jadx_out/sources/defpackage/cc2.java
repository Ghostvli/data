package defpackage;

import androidx.media3.session.l;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cc2 implements Runnable {
    public final /* synthetic */ l f;

    public /* synthetic */ cc2(l lVar) {
        this.f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f.release();
    }
}
