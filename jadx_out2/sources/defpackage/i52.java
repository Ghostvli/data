package defpackage;

import android.util.Pair;
import defpackage.jq2;
import defpackage.no4;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class i52 extends fa5 {
    public final boolean r;
    public final no4.d s;
    public final no4.b t;
    public a u;
    public h52 v;
    public boolean w;
    public boolean x;
    public boolean y;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends i51 {
        public static final Object h = new Object();
        public final Object f;
        public final Object g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(no4 no4Var, Object obj, Object obj2) {
            super(no4Var);
            this.f = obj;
            this.g = obj2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a B(fg2 fg2Var) {
            return new a(new b(fg2Var), no4.d.q, h);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a C(no4 no4Var, Object obj, Object obj2) {
            return new a(no4Var, obj, obj2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a A(no4 no4Var) {
            return new a(no4Var, this.f, this.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i51, defpackage.no4
        public int h(Object obj) {
            Object obj2;
            no4 no4Var = this.e;
            if (h.equals(obj) && (obj2 = this.g) != null) {
                obj = obj2;
            }
            return no4Var.h(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i51, defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            this.e.m(i, bVar, z);
            if (Objects.equals(bVar.b, this.g) && z) {
                bVar.b = h;
            }
            return bVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i51, defpackage.no4
        public Object s(int i) {
            Object objS = this.e.s(i);
            return Objects.equals(objS, this.g) ? h : objS;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.i51, defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            this.e.u(i, dVar, j);
            if (Objects.equals(dVar.a, this.f)) {
                dVar.a = no4.d.q;
            }
            return dVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends no4 {
        public final fg2 e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(fg2 fg2Var) {
            this.e = fg2Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.no4
        public int h(Object obj) {
            return obj == a.h ? 0 : -1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            bVar.v(z ? 0 : null, z ? a.h : null, 0, -9223372036854775807L, 0L, x3.g, true);
            return bVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.no4
        public int o() {
            return 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.no4
        public Object s(int i) {
            return a.h;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            dVar.h(no4.d.q, this.e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.k = true;
            return dVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.no4
        public int v() {
            return 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i52(jq2 jq2Var, boolean z) {
        super(jq2Var);
        this.r = z && jq2Var.n();
        this.s = new no4.d();
        this.t = new no4.b();
        no4 no4VarO = jq2Var.o();
        if (no4VarO == null) {
            this.u = a.B(jq2Var.i());
        } else {
            this.u = a.C(no4VarO, null, null);
            this.y = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oy, defpackage.ji
    public void G() {
        this.x = false;
        this.w = false;
        super.G();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fa5
    public jq2.b P(jq2.b bVar) {
        return bVar.a(a0(bVar.a));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.fa5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V(no4 no4Var) {
        jq2.b bVarA;
        if (this.x) {
            this.u = this.u.A(no4Var);
            h52 h52Var = this.v;
            if (h52Var != null) {
                d0(h52Var.o());
            }
        } else {
            if (!no4Var.w()) {
                no4Var.t(0, this.s);
                long jD = this.s.d();
                Object obj = this.s.a;
                h52 h52Var2 = this.v;
                if (h52Var2 != null) {
                    long jP = h52Var2.p();
                    this.u.n(this.v.f.a, this.t);
                    long jP2 = this.t.p() + jP;
                    long j = jP2 != this.u.t(0, this.s).d() ? jP2 : jD;
                    Pair pairP = no4Var.p(this.s, this.t, 0, j);
                    Object obj2 = pairP.first;
                    long jLongValue = ((Long) pairP.second).longValue();
                    this.u = this.y ? this.u.A(no4Var) : a.C(no4Var, obj, obj2);
                    h52 h52Var3 = this.v;
                    if (h52Var3 != null && d0(jLongValue)) {
                        jq2.b bVar = h52Var3.f;
                        bVarA = bVar.a(b0(bVar.a));
                    }
                }
                this.y = true;
                this.x = true;
                F(this.u);
                if (bVarA == null) {
                    ((h52) gg3.q(this.v)).a(bVarA);
                    return;
                }
                return;
            }
            this.u = this.y ? this.u.A(no4Var) : a.C(no4Var, no4.d.q, a.h);
        }
        bVarA = null;
        this.y = true;
        this.x = true;
        F(this.u);
        if (bVarA == null) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fa5
    public void Y() {
        if (this.r) {
            return;
        }
        this.w = true;
        X();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d(Ljq2$b;Lj5;J)Lmi2; */
    @Override // defpackage.jq2
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public h52 d(jq2.b bVar, j5 j5Var, long j) {
        h52 h52Var = new h52(bVar, j5Var, j);
        h52Var.y(this.p);
        if (this.x) {
            h52Var.a(bVar.a(b0(bVar.a)));
            return h52Var;
        }
        this.v = h52Var;
        if (!this.w) {
            this.w = true;
            X();
        }
        return h52Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        return this.p.a(fg2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object a0(Object obj) {
        return (this.u.g == null || !this.u.g.equals(obj)) ? obj : a.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object b0(Object obj) {
        return (this.u.g == null || !obj.equals(a.h)) ? obj : this.u.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public no4 c0() {
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean d0(long j) {
        h52 h52Var = this.v;
        int iH = this.u.h(h52Var.f.a);
        if (iH == -1) {
            return false;
        }
        long j2 = this.u.l(iH, this.t).d;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        h52Var.w(j);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.fa5, defpackage.jq2
    public void q(fg2 fg2Var) {
        if (this.y) {
            a aVar = this.u;
            this.u = aVar.A(oo4.z(aVar.e, fg2Var));
        } else {
            this.u = a.B(fg2Var);
        }
        this.p.q(fg2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((h52) mi2Var).x();
        if (mi2Var == this.v) {
            this.v = null;
        }
    }
}
