package defpackage;

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

        public a(no4 no4Var, Object obj, Object obj2) {
            super(no4Var);
            this.f = obj;
            this.g = obj2;
        }

        public static a B(fg2 fg2Var) {
            return new a(new b(fg2Var), no4.d.q, h);
        }

        public static a C(no4 no4Var, Object obj, Object obj2) {
            return new a(no4Var, obj, obj2);
        }

        public a A(no4 no4Var) {
            return new a(no4Var, this.f, this.g);
        }

        @Override // defpackage.i51, defpackage.no4
        public int h(Object obj) {
            Object obj2;
            no4 no4Var = this.e;
            if (h.equals(obj) && (obj2 = this.g) != null) {
                obj = obj2;
            }
            return no4Var.h(obj);
        }

        @Override // defpackage.i51, defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            this.e.m(i, bVar, z);
            if (Objects.equals(bVar.b, this.g) && z) {
                bVar.b = h;
            }
            return bVar;
        }

        @Override // defpackage.i51, defpackage.no4
        public Object s(int i) {
            Object objS = this.e.s(i);
            return Objects.equals(objS, this.g) ? h : objS;
        }

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

        public b(fg2 fg2Var) {
            this.e = fg2Var;
        }

        @Override // defpackage.no4
        public int h(Object obj) {
            return obj == a.h ? 0 : -1;
        }

        @Override // defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            bVar.v(z ? 0 : null, z ? a.h : null, 0, -9223372036854775807L, 0L, x3.g, true);
            return bVar;
        }

        @Override // defpackage.no4
        public int o() {
            return 1;
        }

        @Override // defpackage.no4
        public Object s(int i) {
            return a.h;
        }

        @Override // defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            dVar.h(no4.d.q, this.e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.k = true;
            return dVar;
        }

        @Override // defpackage.no4
        public int v() {
            return 1;
        }
    }

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

    @Override // defpackage.oy, defpackage.ji
    public void G() {
        this.x = false;
        this.w = false;
        super.G();
    }

    @Override // defpackage.fa5
    public jq2.b P(jq2.b bVar) {
        return bVar.a(a0(bVar.a));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.fa5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void V(defpackage.no4 r15) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i52.V(no4):void");
    }

    @Override // defpackage.fa5
    public void Y() {
        if (this.r) {
            return;
        }
        this.w = true;
        X();
    }

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

    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        return this.p.a(fg2Var);
    }

    public final Object a0(Object obj) {
        return (this.u.g == null || !this.u.g.equals(obj)) ? obj : a.h;
    }

    public final Object b0(Object obj) {
        return (this.u.g == null || !obj.equals(a.h)) ? obj : this.u.g;
    }

    public no4 c0() {
        return this.u;
    }

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

    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((h52) mi2Var).x();
        if (mi2Var == this.v) {
            this.v = null;
        }
    }
}
