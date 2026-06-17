package androidx.lifecycle;

import androidx.lifecycle.g;
import defpackage.bt1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void a(bt1 bt1Var, g.b bVar, g.b bVar2) {
        bVar.getClass();
        bVar2.getClass();
        if (bVar == g.b.g && bVar2 == g.b.f) {
            throw new IllegalStateException(("State must be at least '" + g.b.h + "' to be moved to '" + bVar2 + "' in component " + bt1Var).toString());
        }
        g.b bVar3 = g.b.f;
        if (bVar != bVar3 || bVar == bVar2) {
            return;
        }
        throw new IllegalStateException(("State is '" + bVar3 + "' and cannot be moved to `" + bVar2 + "` in component " + bt1Var).toString());
    }
}
