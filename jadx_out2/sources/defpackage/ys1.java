package defpackage;

import androidx.lifecycle.g;
import androidx.lifecycle.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ys1 implements xs1, at1 {
    public final Set f = new HashSet();
    public final g g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ys1(g gVar) {
        this.g = gVar;
        gVar.a(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xs1
    public void a(zs1 zs1Var) {
        this.f.remove(zs1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xs1
    public void b(zs1 zs1Var) {
        this.f.add(zs1Var);
        if (this.g.b() == g.b.f) {
            zs1Var.h();
        } else if (this.g.b().b(g.b.i)) {
            zs1Var.b();
        } else {
            zs1Var.onStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @m(g.a.ON_DESTROY)
    public void onDestroy(bt1 bt1Var) {
        Iterator it = iy4.k(this.f).iterator();
        while (it.hasNext()) {
            ((zs1) it.next()).h();
        }
        bt1Var.getLifecycle().c(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @m(g.a.ON_START)
    public void onStart(bt1 bt1Var) {
        Iterator it = iy4.k(this.f).iterator();
        while (it.hasNext()) {
            ((zs1) it.next()).b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @m(g.a.ON_STOP)
    public void onStop(bt1 bt1Var) {
        Iterator it = iy4.k(this.f).iterator();
        while (it.hasNext()) {
            ((zs1) it.next()).onStop();
        }
    }
}
