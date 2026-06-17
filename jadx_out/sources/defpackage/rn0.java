package defpackage;

import defpackage.dh1;
import defpackage.gh1;
import defpackage.jh;
import defpackage.nh1;
import defpackage.t80;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class rn0 implements gh1 {
    public final t80 a;
    public final o b;
    public dh1 c;
    public jh d;
    public gh1.a e;
    public final nh1 f;
    public b90 g;
    public boolean i;
    public boolean l;
    public long m;
    public long n;
    public int o;
    public boolean p;
    public ih q;
    public dh1 s;
    public boolean t;
    public dh1 h = new e90(4);
    public long j = 0;
    public final nh1.b k = new nh1.b();
    public e90 r = new e90(4);
    public t80.a u = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements t80.a {
        public a() {
        }

        @Override // t80.a
        public boolean a(t80 t80Var, t80.b bVar, Object... objArr) {
            return rn0.this.s(t80Var, bVar, objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements nh1.a {
        public b() {
        }

        @Override // nh1.a
        public void a(ih ihVar) {
            gh1.a aVar = rn0.this.e;
            if (aVar != null) {
                aVar.a(ihVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends dh1.c {
        public final /* synthetic */ dh1 a;

        public c(dh1 dh1Var) {
            this.a = dh1Var;
        }

        @Override // dh1.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(ih ihVar) {
            if (!ihVar.v() || ihVar.s()) {
                return 0;
            }
            this.a.c(ihVar);
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements jh.a {
        public d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends dh1.c {
        public final /* synthetic */ long a;

        public e(long j) {
            this.a = j;
        }

        @Override // dh1.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(ih ihVar) {
            if (ihVar.s()) {
                return 2;
            }
            ihVar.C(this.a + ihVar.b);
            return ihVar.b == 0 ? 2 : 0;
        }
    }

    public rn0(b90 b90Var, t80 t80Var, gh1.a aVar) {
        if (t80Var == null) {
            jl.a("context is null");
            throw null;
        }
        this.a = t80Var;
        this.b = t80Var.b();
        this.e = aVar;
        a90 a90Var = new a90(t80Var);
        this.f = a90Var;
        a90Var.b(new b());
        a90Var.a(t80Var.f() || t80Var.e());
        q(b90Var);
        boolean zD = t80Var.d();
        z80 z80Var = t80Var.D;
        if (zD) {
            z80Var.e("1017_Filter");
        } else {
            z80Var.h("1017_Filter");
        }
    }

    @Override // defpackage.gh1
    public void a(int i) {
        this.o = i;
    }

    @Override // defpackage.gh1
    public synchronized nh1.b b(o oVar) {
        return n(oVar, this.g);
    }

    @Override // defpackage.gh1
    public void c(long j) {
        ih ihVarLast;
        t();
        this.a.C.g();
        this.a.C.c();
        this.a.C.f();
        this.a.C.e();
        this.s = new e90(4);
        if (j < 1000) {
            j = 0;
        }
        this.j = j;
        this.k.e();
        this.k.o = this.j;
        this.n = 0L;
        this.m = 0L;
        dh1 dh1Var = this.c;
        if (dh1Var == null || (ihVarLast = dh1Var.last()) == null || ihVarLast.w()) {
            return;
        }
        this.q = ihVarLast;
    }

    @Override // defpackage.gh1
    public void d() {
        this.t = true;
    }

    @Override // defpackage.gh1
    public void e() {
        this.i = true;
    }

    @Override // defpackage.gh1
    public void f(jh jhVar) {
        this.d = jhVar;
        this.l = false;
    }

    @Override // defpackage.gh1
    public void g() {
        this.a.q();
        nh1 nh1Var = this.f;
        if (nh1Var != null) {
            nh1Var.release();
        }
    }

    @Override // defpackage.gh1
    public void h(long j) {
        t();
        this.a.C.g();
        this.a.C.c();
        this.j = j;
    }

    @Override // defpackage.gh1
    public dh1 i(long j) {
        dh1 dh1VarA;
        long j2 = this.a.E.f;
        long j3 = (j - j2) - 100;
        long j4 = j + j2;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 3) {
                dh1VarA = null;
                break;
            }
            try {
                dh1VarA = this.c.a(j3, j4);
                break;
            } catch (Exception unused) {
                i = i2;
            }
        }
        e90 e90Var = new e90();
        if (dh1VarA != null && !dh1VarA.isEmpty()) {
            dh1VarA.g(new c(e90Var));
        }
        return e90Var;
    }

    @Override // defpackage.gh1
    public void j() {
        this.p = true;
    }

    @Override // defpackage.gh1
    public void k(long j, long j2, long j3) {
        dh1 dh1VarD = this.k.d();
        this.s = dh1VarD;
        dh1VarD.g(new e(j3));
        this.j = j2;
    }

    @Override // defpackage.gh1
    public void l() {
        this.n = 0L;
        this.m = 0L;
        this.p = false;
    }

    public final void m(nh1.b bVar, dh1 dh1Var, dh1 dh1Var2) {
        bVar.e();
        bVar.b.c(lk4.b());
        bVar.c = 0;
        bVar.d = (dh1Var != null ? dh1Var.size() : 0) + (dh1Var2 != null ? dh1Var2.size() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public nh1.b n(defpackage.o r23, defpackage.b90 r24) {
        /*
            r22 = this;
            r0 = r22
            boolean r1 = r0.i
            r2 = 0
            if (r1 == 0) goto Le
            nh1 r1 = r0.f
            r1.c()
            r0.i = r2
        Le:
            dh1 r1 = r0.c
            r3 = 0
            if (r1 == 0) goto Lc7
            java.lang.Object r1 = r23.x()
            android.graphics.Canvas r1 = (android.graphics.Canvas) r1
            defpackage.qn0.a(r1)
            boolean r1 = r0.p
            if (r1 == 0) goto L27
            boolean r1 = r0.t
            if (r1 != 0) goto L27
            nh1$b r0 = r0.k
            return r0
        L27:
            r0.t = r2
            nh1$b r9 = r0.k
            r1 = r24
            long r4 = r1.a
            t80 r1 = r0.a
            y80 r1 = r1.E
            long r6 = r1.f
            long r10 = r4 - r6
            r12 = 100
            long r10 = r10 - r12
            long r6 = r6 + r4
            dh1 r1 = r0.h
            long r12 = r0.m
            int r8 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r8 > 0) goto L4d
            long r14 = r0.n
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 <= 0) goto L4a
            goto L4d
        L4a:
            r10 = r12
        L4b:
            r6 = r1
            goto L5d
        L4d:
            dh1 r1 = r0.c
            dh1 r1 = r1.d(r10, r6)
            if (r1 == 0) goto L57
            r0.h = r1
        L57:
            r0.m = r10
            r0.n = r6
            r14 = r6
            goto L4b
        L5d:
            dh1 r1 = r0.s
            r0.m(r9, r1, r6)
            r4 = 1
            if (r1 == 0) goto L7e
            boolean r5 = r1.isEmpty()
            if (r5 != 0) goto L7e
            nh1$b r5 = r0.k
            r5.a = r4
            nh1 r7 = r0.f
            r19 = 0
            r17 = r23
            r18 = r1
            r21 = r5
            r16 = r7
            r16.e(r17, r18, r19, r21)
        L7e:
            nh1$b r1 = r0.k
            r1.a = r2
            if (r6 == 0) goto Lc0
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto Lc0
            nh1 r4 = r0.f
            o r5 = r0.b
            long r7 = r0.j
            r4.e(r5, r6, r7, r9)
            r0.o(r9)
            boolean r1 = r9.p
            if (r1 == 0) goto Lbf
            ih r1 = r0.q
            if (r1 == 0) goto Lad
            boolean r1 = r1.w()
            if (r1 == 0) goto Lad
            r0.q = r3
            gh1$a r0 = r0.e
            if (r0 == 0) goto Lad
            r0.c()
        Lad:
            long r0 = r9.n
            r2 = -1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto Lb7
            r9.n = r10
        Lb7:
            long r0 = r9.o
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto Lbf
            r9.o = r14
        Lbf:
            return r9
        Lc0:
            r9.p = r4
            r9.n = r10
            r9.o = r14
            return r9
        Lc7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rn0.n(o, b90):nh1$b");
    }

    public final void o(nh1.b bVar) {
        boolean z = bVar.k == 0;
        bVar.p = z;
        if (z) {
            bVar.n = -1L;
        }
        ih ihVar = bVar.e;
        bVar.e = null;
        bVar.o = ihVar != null ? ihVar.b() : -1L;
        bVar.m = bVar.b.c(lk4.b());
    }

    public boolean p(t80 t80Var, t80.b bVar, Object[] objArr) {
        Boolean bool;
        if (bVar == null || t80.b.MAXIMUM_NUMS_IN_SCREEN.equals(bVar)) {
            return true;
        }
        if (t80.b.DUPLICATE_MERGING_ENABLED.equals(bVar)) {
            Boolean bool2 = (Boolean) objArr[0];
            if (bool2 != null) {
                boolean zBooleanValue = bool2.booleanValue();
                t80 t80Var2 = this.a;
                if (zBooleanValue) {
                    t80Var2.D.e("1017_Filter");
                } else {
                    t80Var2.D.h("1017_Filter");
                }
                return true;
            }
        } else {
            if (t80.b.SCALE_TEXTSIZE.equals(bVar) || t80.b.SCROLL_SPEED_FACTOR.equals(bVar) || t80.b.DANMAKU_MARGIN.equals(bVar)) {
                e();
                return false;
            }
            if (t80.b.MAXIMUN_LINES.equals(bVar) || t80.b.OVERLAPPING_ENABLE.equals(bVar)) {
                nh1 nh1Var = this.f;
                if (nh1Var != null) {
                    nh1Var.a(this.a.f() || this.a.e());
                }
                return true;
            }
            if (t80.b.ALIGN_BOTTOM.equals(bVar) && (bool = (Boolean) objArr[0]) != null) {
                nh1 nh1Var2 = this.f;
                if (nh1Var2 != null) {
                    nh1Var2.f(bool.booleanValue());
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.gh1
    public void prepare() {
        jh jhVar = this.d;
        if (jhVar == null) {
            return;
        }
        r(jhVar);
        this.n = 0L;
        this.m = 0L;
        gh1.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
            this.l = true;
        }
    }

    public void q(b90 b90Var) {
        this.g = b90Var;
    }

    public void r(jh jhVar) {
        this.c = jhVar.h(this.a).i(this.b).k(this.g).j(new d()).a();
        this.a.C.a();
        dh1 dh1Var = this.c;
        if (dh1Var != null) {
            this.q = dh1Var.last();
        }
    }

    public boolean s(t80 t80Var, t80.b bVar, Object... objArr) {
        boolean zP = p(t80Var, bVar, objArr);
        gh1.a aVar = this.e;
        if (aVar != null) {
            aVar.d();
        }
        return zP;
    }

    @Override // defpackage.gh1
    public void start() {
        this.a.h(this.u);
    }

    public void t() {
        if (this.h != null) {
            this.h = new e90();
        }
        nh1 nh1Var = this.f;
        if (nh1Var != null) {
            nh1Var.clear();
        }
    }
}
