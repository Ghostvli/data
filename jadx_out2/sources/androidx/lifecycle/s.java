package androidx.lifecycle;

import androidx.lifecycle.g;
import defpackage.bt1;
import defpackage.e04;
import defpackage.qx3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements i, AutoCloseable {
    public final String f;
    public final q g;
    public boolean h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s(String str, q qVar) {
        str.getClass();
        qVar.getClass();
        this.f = str;
        this.g = qVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(qx3 qx3Var, g gVar) {
        qx3Var.getClass();
        gVar.getClass();
        if (this.h) {
            e04.a("Already attached to lifecycleOwner");
            return;
        }
        this.h = true;
        gVar.a(this);
        qx3Var.c(this.f, this.g.a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.i
    public void c(bt1 bt1Var, g.a aVar) {
        bt1Var.getClass();
        aVar.getClass();
        if (aVar == g.a.ON_DESTROY) {
            this.h = false;
            bt1Var.getLifecycle().c(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.AutoCloseable
    public void close() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final q t() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean u() {
        return this.h;
    }
}
