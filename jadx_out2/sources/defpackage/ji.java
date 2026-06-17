package defpackage;

import android.os.Handler;
import android.os.Looper;
import defpackage.jq2;
import defpackage.rq2;
import defpackage.wo0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ji implements jq2 {
    public final ArrayList f = new ArrayList(1);
    public final HashSet g = new HashSet(1);
    public final rq2.a h = new rq2.a();
    public final wo0.a i = new wo0.a();
    public Looper j;
    public no4 k;
    public ie3 l;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ie3 C() {
        return (ie3) gg3.q(this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean D() {
        return !this.g.isEmpty();
    }

    public abstract void E(hs4 hs4Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(no4 no4Var) {
        this.k = no4Var;
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((jq2.c) it.next()).a(this, no4Var);
        }
    }

    public abstract void G();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public final void b(Handler handler, rq2 rq2Var) {
        gg3.q(handler);
        gg3.q(rq2Var);
        this.h.h(handler, rq2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public final void c(rq2 rq2Var) {
        this.h.x(rq2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public final void e(Handler handler, wo0 wo0Var) {
        gg3.q(handler);
        gg3.q(wo0Var);
        this.i.g(handler, wo0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public final void f(jq2.c cVar, hs4 hs4Var, ie3 ie3Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.j;
        gg3.d(looper == null || looper == looperMyLooper);
        this.l = ie3Var;
        no4 no4Var = this.k;
        this.f.add(cVar);
        if (this.j == null) {
            this.j = looperMyLooper;
            this.g.add(cVar);
            E(hs4Var);
        } else if (no4Var != null) {
            u(cVar);
            cVar.a(this, no4Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public final void g(wo0 wo0Var) {
        this.i.n(wo0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public final void h(jq2.c cVar) {
        boolean zIsEmpty = this.g.isEmpty();
        this.g.remove(cVar);
        if (zIsEmpty || !this.g.isEmpty()) {
            return;
        }
        A();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public final void k(jq2.c cVar) {
        this.f.remove(cVar);
        if (!this.f.isEmpty()) {
            h(cVar);
            return;
        }
        this.j = null;
        this.k = null;
        this.l = null;
        this.g.clear();
        G();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public final void u(jq2.c cVar) {
        gg3.q(this.j);
        boolean zIsEmpty = this.g.isEmpty();
        this.g.add(cVar);
        if (zIsEmpty) {
            B();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final wo0.a w(int i, jq2.b bVar) {
        return this.i.o(i, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final wo0.a x(jq2.b bVar) {
        return this.i.o(0, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final rq2.a y(int i, jq2.b bVar) {
        return this.h.A(i, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final rq2.a z(jq2.b bVar) {
        return this.h.A(0, bVar);
    }
}
