package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class yp extends zx {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(yp.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yp(f30 f30Var, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + f30Var + " was cancelled normally");
        }
        super(th, z);
        this._resumed$volatile = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e() {
        return c.compareAndSet(this, 0, 1);
    }
}
