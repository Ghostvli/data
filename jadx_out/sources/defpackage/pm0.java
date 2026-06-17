package defpackage;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class pm0 implements qm0 {
    public final Future f;

    public pm0(Future future) {
        this.f = future;
    }

    @Override // defpackage.qm0
    public void e() {
        this.f.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f + ']';
    }
}
