package defpackage;

import defpackage.zu0;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class av0 extends yu0 {
    public abstract Thread t0();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u0(long j, zu0.c cVar) {
        qf0.n.I0(j, cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v0() {
        Thread threadT0 = t0();
        if (Thread.currentThread() != threadT0) {
            g1.a();
            LockSupport.unpark(threadT0);
        }
    }
}
