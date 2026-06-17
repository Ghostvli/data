package defpackage;

import android.net.Uri;
import defpackage.aa0;
import defpackage.fg2;
import defpackage.ja0;
import defpackage.jq2;
import defpackage.rq2;
import defpackage.t41;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class m74 extends ji {
    public final ja0 m;
    public final aa0.a n;
    public final t41 o;
    public final long p;
    public final sy1 q;
    public final boolean r;
    public final no4 s;
    public final fg2 t;
    public final xi4 u;
    public hs4 v;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final aa0.a a;
        public sy1 b = new ig0();
        public boolean c = true;
        public Object d;
        public String e;
        public xi4 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(aa0.a aVar) {
            this.a = (aa0.a) gg3.q(aVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public m74 a(fg2.k kVar, long j) {
            return new m74(this.e, kVar, this.a, j, this.b, this.c, this.d, this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(sy1 sy1Var) {
            if (sy1Var == null) {
                sy1Var = new ig0();
            }
            this.b = sy1Var;
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public m74(String str, fg2.k kVar, aa0.a aVar, long j, sy1 sy1Var, boolean z, Object obj, xi4 xi4Var) {
        this.n = aVar;
        this.p = j;
        this.q = sy1Var;
        this.r = z;
        fg2 fg2VarA = new fg2.c().k(Uri.EMPTY).e(kVar.a.toString()).i(xi1.w(kVar)).j(obj).a();
        this.t = fg2VarA;
        t41.b bVarM0 = new t41.b().A0((String) eu2.a(kVar.b, "text/x-unknown")).o0(kVar.c).C0(kVar.d).y0(kVar.e).m0(kVar.f);
        String str2 = kVar.g;
        this.o = bVarM0.k0(str2 != null ? str2 : str).Q();
        this.m = new ja0.b().i(kVar.a).b(1).a();
        this.s = new h74(j, true, false, false, null, fg2VarA);
        this.u = xi4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ji
    public void E(hs4 hs4Var) {
        this.v = hs4Var;
        F(this.s);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ji
    public void G() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        ja0 ja0Var = this.m;
        aa0.a aVar = this.n;
        hs4 hs4Var = this.v;
        t41 t41Var = this.o;
        long j2 = this.p;
        sy1 sy1Var = this.q;
        rq2.a aVarZ = z(bVar);
        boolean z = this.r;
        xi4 xi4Var = this.u;
        return new l74(ja0Var, aVar, hs4Var, t41Var, j2, sy1Var, aVarZ, z, xi4Var != null ? (eq3) xi4Var.get() : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public fg2 i() {
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public void m() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((l74) mi2Var).w();
    }
}
