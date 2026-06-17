package defpackage;

import android.net.Uri;
import android.os.Looper;
import defpackage.aa0;
import defpackage.fg2;
import defpackage.jq2;
import defpackage.no4;
import defpackage.rh3;
import defpackage.rq2;
import defpackage.wh3;
import defpackage.wo0;
import defpackage.xh3;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xh3 extends ji implements wh3.d {
    public hs4 A;
    public fg2 B;
    public final aa0.a m;
    public final rh3.a n;
    public final xo0 o;
    public final sy1 p;
    public final int q;
    public final boolean r;
    public final int s;
    public final t41 t;
    public final xi4 u;
    public boolean v;
    public long w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends i51 {
        public a(no4 no4Var) {
            super(no4Var);
        }

        @Override // defpackage.i51, defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            super.m(i, bVar, z);
            bVar.f = true;
            return bVar;
        }

        @Override // defpackage.i51, defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            super.u(i, dVar, j);
            dVar.k = true;
            return dVar;
        }
    }

    public xh3(fg2 fg2Var, aa0.a aVar, rh3.a aVar2, xo0 xo0Var, sy1 sy1Var, int i, boolean z, int i2, t41 t41Var, xi4 xi4Var) {
        this.B = fg2Var;
        this.m = aVar;
        this.n = aVar2;
        this.o = xo0Var;
        this.p = sy1Var;
        this.q = i;
        this.r = z;
        this.t = t41Var;
        this.s = i2;
        this.v = true;
        this.w = -9223372036854775807L;
        this.u = xi4Var;
    }

    private void I() {
        no4 h74Var = new h74(this.w, this.x, false, this.y, null, i());
        if (this.v) {
            h74Var = new a(h74Var);
        }
        F(h74Var);
    }

    @Override // defpackage.ji
    public void E(hs4 hs4Var) {
        this.A = hs4Var;
        this.o.c((Looper) gg3.q(Looper.myLooper()), C());
        this.o.prepare();
        I();
    }

    @Override // defpackage.ji
    public void G() {
        this.o.release();
    }

    public final fg2.h H() {
        return (fg2.h) gg3.q(i().b);
    }

    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        fg2.h hVarH = H();
        fg2.h hVar = fg2Var.b;
        return hVar != null && hVar.a.equals(hVarH.a) && hVar.j == hVarH.j && Objects.equals(hVar.f, hVarH.f);
    }

    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        aa0 aa0VarB = this.m.b();
        hs4 hs4Var = this.A;
        if (hs4Var != null) {
            aa0VarB.f(hs4Var);
        }
        fg2.h hVarH = H();
        Uri uri = hVarH.a;
        rh3 rh3VarA = this.n.a(C());
        xo0 xo0Var = this.o;
        wo0.a aVarX = x(bVar);
        sy1 sy1Var = this.p;
        rq2.a aVarZ = z(bVar);
        String str = hVarH.f;
        int i = this.q;
        boolean z = this.r;
        int i2 = this.s;
        t41 t41Var = this.t;
        long jC1 = fy4.c1(hVarH.j);
        xi4 xi4Var = this.u;
        return new wh3(uri, aa0VarB, rh3VarA, xo0Var, aVarX, sy1Var, aVarZ, this, j5Var, str, i, z, i2, t41Var, jC1, xi4Var != null ? (eq3) xi4Var.get() : null);
    }

    @Override // defpackage.jq2
    public synchronized fg2 i() {
        return this.B;
    }

    @Override // defpackage.jq2
    public void m() {
    }

    @Override // defpackage.jq2
    public synchronized void q(fg2 fg2Var) {
        this.B = fg2Var;
    }

    @Override // wh3.d
    public void r(long j, yz3 yz3Var, boolean z) {
        if (this.z && yz3Var.f()) {
            return;
        }
        this.z = !yz3Var.f();
        if (j == -9223372036854775807L) {
            j = this.w;
        }
        boolean zE = yz3Var.e();
        if (!this.v && this.w == j && this.x == zE && this.y == z) {
            return;
        }
        this.w = j;
        this.x = zE;
        this.y = z;
        this.v = false;
        I();
    }

    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((wh3) mi2Var).h0();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements sq2 {
        public final aa0.a c;
        public rh3.a d;
        public zo0 e;
        public sy1 f;
        public int g;
        public xi4 h;
        public int i;
        public t41 j;
        public boolean k;

        public b(aa0.a aVar, rh3.a aVar2) {
            this(aVar, aVar2, new kf0(), new ig0(), 1048576);
        }

        public static /* synthetic */ rh3 h(pz0 pz0Var, ie3 ie3Var) {
            return new qm(pz0Var);
        }

        @Override // jq2.a
        public jq2.a d(xi4 xi4Var) {
            this.h = xi4Var;
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public xh3 e(fg2 fg2Var) {
            gg3.q(fg2Var.b);
            return new xh3(fg2Var, this.c, this.d, this.e.a(fg2Var), this.f, this.g, this.k, this.i, this.j, this.h, null);
        }

        public b j(int i, t41 t41Var) {
            this.i = i;
            this.j = (t41) gg3.q(t41Var);
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public b f(zo0 zo0Var) {
            this.e = (zo0) gg3.r(zo0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public b g(sy1 sy1Var) {
            this.f = (sy1) gg3.r(sy1Var, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public b m(boolean z) {
            this.k = z;
            return this;
        }

        public b(aa0.a aVar, final pz0 pz0Var) {
            this(aVar, new rh3.a() { // from class: yh3
                @Override // rh3.a
                public final rh3 a(ie3 ie3Var) {
                    return xh3.b.h(pz0Var, ie3Var);
                }
            });
        }

        public b(aa0.a aVar, rh3.a aVar2, zo0 zo0Var, sy1 sy1Var, int i) {
            this.c = aVar;
            this.d = aVar2;
            this.e = zo0Var;
            this.f = sy1Var;
            this.g = i;
        }
    }

    public /* synthetic */ xh3(fg2 fg2Var, aa0.a aVar, rh3.a aVar2, xo0 xo0Var, sy1 sy1Var, int i, boolean z, int i2, t41 t41Var, xi4 xi4Var, a aVar3) {
        this(fg2Var, aVar, aVar2, xo0Var, sy1Var, i, z, i2, t41Var, xi4Var);
    }
}
