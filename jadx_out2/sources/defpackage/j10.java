package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class j10 implements f14 {
    public final AtomicReference a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public j10(f14 f14Var) {
        f14Var.getClass();
        this.a = new AtomicReference(f14Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f14
    public Iterator iterator() {
        f14 f14Var = (f14) this.a.getAndSet(null);
        if (f14Var != null) {
            return f14Var.iterator();
        }
        e04.a("This sequence can be consumed only once.");
        return null;
    }
}
