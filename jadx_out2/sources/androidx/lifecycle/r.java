package androidx.lifecycle;

import androidx.lifecycle.g;
import defpackage.bt1;
import defpackage.kx3;
import defpackage.r53;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements i {
    public final kx3 f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r(kx3 kx3Var) {
        kx3Var.getClass();
        this.f = kx3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.i
    public void c(bt1 bt1Var, g.a aVar) {
        bt1Var.getClass();
        aVar.getClass();
        if (aVar != g.a.ON_CREATE) {
            r53.a("Next event must be ON_CREATE, it was ", aVar);
        } else {
            bt1Var.getLifecycle().c(this);
            this.f.e();
        }
    }
}
