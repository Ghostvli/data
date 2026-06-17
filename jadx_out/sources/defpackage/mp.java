package defpackage;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class mp implements np {
    public final Future a;

    public mp(Future future) {
        this.a = future;
    }

    @Override // defpackage.np
    public void a(Throwable th) {
        this.a.cancel(false);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }
}
