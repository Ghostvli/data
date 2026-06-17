package defpackage;

import android.os.Handler;
import defpackage.jq2;
import defpackage.rq2;
import defpackage.wo0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class oy extends ji {
    public final HashMap m = new HashMap();
    public Handler n;
    public hs4 o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements rq2, wo0 {
        public final Object f;
        public rq2.a g;
        public wo0.a h;

        public a(Object obj) {
            this.g = oy.this.z(null);
            this.h = oy.this.x(null);
            this.f = obj;
        }

        public final boolean A(int i, jq2.b bVar) {
            jq2.b bVarK;
            if (bVar != null) {
                bVarK = oy.this.K(this.f, bVar);
                if (bVarK == null) {
                    return false;
                }
            } else {
                bVarK = null;
            }
            int iM = oy.this.M(this.f, i);
            rq2.a aVar = this.g;
            if (aVar.a != iM || !Objects.equals(aVar.b, bVarK)) {
                this.g = oy.this.y(iM, bVarK);
            }
            wo0.a aVar2 = this.h;
            if (aVar2.a == iM && Objects.equals(aVar2.b, bVarK)) {
                return true;
            }
            this.h = oy.this.w(iM, bVarK);
            return true;
        }

        @Override // defpackage.rq2
        public void B(int i, jq2.b bVar, ty1 ty1Var, oh2 oh2Var, IOException iOException, boolean z) {
            if (A(i, bVar)) {
                this.g.t(ty1Var, I(oh2Var, bVar), iOException, z);
            }
        }

        @Override // defpackage.wo0
        public void C(int i, jq2.b bVar) {
            if (A(i, bVar)) {
                this.h.j();
            }
        }

        @Override // defpackage.wo0
        public void D(int i, jq2.b bVar) {
            if (A(i, bVar)) {
                this.h.i();
            }
        }

        @Override // defpackage.wo0
        public void F(int i, jq2.b bVar) {
            if (A(i, bVar)) {
                this.h.m();
            }
        }

        @Override // defpackage.wo0
        public void G(int i, jq2.b bVar, cr1 cr1Var) {
            if (A(i, bVar)) {
                this.h.h(cr1Var);
            }
        }

        @Override // defpackage.rq2
        public void H(int i, jq2.b bVar, ty1 ty1Var, oh2 oh2Var, int i2) {
            if (A(i, bVar)) {
                this.g.w(ty1Var, I(oh2Var, bVar), i2);
            }
        }

        public final oh2 I(oh2 oh2Var, jq2.b bVar) {
            long jL = oy.this.L(this.f, oh2Var.f, bVar);
            long jL2 = oy.this.L(this.f, oh2Var.g, bVar);
            return (jL == oh2Var.f && jL2 == oh2Var.g) ? oh2Var : new oh2(oh2Var.a, oh2Var.b, oh2Var.c, oh2Var.d, oh2Var.e, jL, jL2);
        }

        @Override // defpackage.wo0
        public void a(int i, jq2.b bVar, Exception exc) {
            if (A(i, bVar)) {
                this.h.l(exc);
            }
        }

        @Override // defpackage.rq2
        public void s(int i, jq2.b bVar, oh2 oh2Var) {
            if (A(i, bVar)) {
                this.g.k(I(oh2Var, bVar));
            }
        }

        @Override // defpackage.rq2
        public void v(int i, jq2.b bVar, oh2 oh2Var) {
            if (A(i, bVar)) {
                this.g.z(I(oh2Var, bVar));
            }
        }

        @Override // defpackage.wo0
        public void x(int i, jq2.b bVar, int i2) {
            if (A(i, bVar)) {
                this.h.k(i2);
            }
        }

        @Override // defpackage.rq2
        public void y(int i, jq2.b bVar, ty1 ty1Var, oh2 oh2Var) {
            if (A(i, bVar)) {
                this.g.n(ty1Var, I(oh2Var, bVar));
            }
        }

        @Override // defpackage.rq2
        public void z(int i, jq2.b bVar, ty1 ty1Var, oh2 oh2Var) {
            if (A(i, bVar)) {
                this.g.q(ty1Var, I(oh2Var, bVar));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final jq2 a;
        public final jq2.c b;
        public final a c;

        public b(jq2 jq2Var, jq2.c cVar, a aVar) {
            this.a = jq2Var;
            this.b = cVar;
            this.c = aVar;
        }
    }

    @Override // defpackage.ji
    public void A() {
        for (b bVar : this.m.values()) {
            bVar.a.h(bVar.b);
        }
    }

    @Override // defpackage.ji
    public void B() {
        for (b bVar : this.m.values()) {
            bVar.a.u(bVar.b);
        }
    }

    @Override // defpackage.ji
    public void E(hs4 hs4Var) {
        this.o = hs4Var;
        this.n = fy4.E();
    }

    @Override // defpackage.ji
    public void G() {
        for (b bVar : this.m.values()) {
            bVar.a.k(bVar.b);
            bVar.a.c(bVar.c);
            bVar.a.g(bVar.c);
        }
        this.m.clear();
    }

    public final void I(Object obj) {
        b bVar = (b) gg3.q((b) this.m.get(obj));
        bVar.a.h(bVar.b);
    }

    public final void J(Object obj) {
        b bVar = (b) gg3.q((b) this.m.get(obj));
        bVar.a.u(bVar.b);
    }

    public abstract jq2.b K(Object obj, jq2.b bVar);

    public long L(Object obj, long j, jq2.b bVar) {
        return j;
    }

    public int M(Object obj, int i) {
        return i;
    }

    public abstract void N(Object obj, jq2 jq2Var, no4 no4Var);

    public final void O(final Object obj, jq2 jq2Var) {
        gg3.d(!this.m.containsKey(obj));
        jq2.c cVar = new jq2.c() { // from class: ny
            @Override // jq2.c
            public final void a(jq2 jq2Var2, no4 no4Var) {
                this.a.N(obj, jq2Var2, no4Var);
            }
        };
        a aVar = new a(obj);
        this.m.put(obj, new b(jq2Var, cVar, aVar));
        jq2Var.b((Handler) gg3.q(this.n), aVar);
        jq2Var.e((Handler) gg3.q(this.n), aVar);
        jq2Var.f(cVar, this.o, C());
        if (D()) {
            return;
        }
        jq2Var.h(cVar);
    }

    @Override // defpackage.jq2
    public void m() {
        Iterator it = this.m.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).a.m();
        }
    }
}
