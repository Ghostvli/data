package defpackage;

import android.graphics.Canvas;
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // t80.a
        public boolean a(t80 t80Var, t80.b bVar, Object... objArr) {
            return rn0.this.s(t80Var, bVar, objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements nh1.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(dh1 dh1Var) {
            this.a = dh1Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends dh1.c {
        public final /* synthetic */ long a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(long j) {
            this.a = j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)I */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void a(int i) {
        this.o = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public synchronized nh1.b b(o oVar) {
        return n(oVar, this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void d() {
        this.t = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void e() {
        this.i = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void f(jh jhVar) {
        this.d = jhVar;
        this.l = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void g() {
        this.a.q();
        nh1 nh1Var = this.f;
        if (nh1Var != null) {
            nh1Var.release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void h(long j) {
        t();
        this.a.C.g();
        this.a.C.c();
        this.j = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void j() {
        this.p = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void k(long j, long j2, long j3) {
        dh1 dh1VarD = this.k.d();
        this.s = dh1VarD;
        dh1VarD.g(new e(j3));
        this.j = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void l() {
        this.n = 0L;
        this.m = 0L;
        this.p = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(nh1.b bVar, dh1 dh1Var, dh1 dh1Var2) {
        bVar.e();
        bVar.b.c(lk4.b());
        bVar.c = 0;
        bVar.d = (dh1Var != null ? dh1Var.size() : 0) + (dh1Var2 != null ? dh1Var2.size() : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public nh1.b n(o oVar, b90 b90Var) {
        long j;
        if (this.i) {
            this.f.c();
            this.i = false;
        }
        if (this.c == null) {
            return null;
        }
        qn0.a((Canvas) oVar.x());
        if (this.p && !this.t) {
            return this.k;
        }
        this.t = false;
        nh1.b bVar = this.k;
        long j2 = b90Var.a;
        long j3 = this.a.E.f;
        long j4 = (j2 - j3) - 100;
        long j5 = j3 + j2;
        dh1 dh1VarD = this.h;
        long j6 = this.m;
        if (j6 <= j4) {
            j = this.n;
            if (j2 > j) {
                dh1VarD = this.c.d(j4, j5);
                if (dh1VarD != null) {
                    this.h = dh1VarD;
                }
                this.m = j4;
                this.n = j5;
                j = j5;
            } else {
                j4 = j6;
            }
        }
        dh1 dh1Var = dh1VarD;
        dh1 dh1Var2 = this.s;
        m(bVar, dh1Var2, dh1Var);
        if (dh1Var2 != null && !dh1Var2.isEmpty()) {
            nh1.b bVar2 = this.k;
            bVar2.a = true;
            this.f.e(oVar, dh1Var2, 0L, bVar2);
        }
        this.k.a = false;
        if (dh1Var == null || dh1Var.isEmpty()) {
            bVar.p = true;
            bVar.n = j4;
            bVar.o = j;
            return bVar;
        }
        this.f.e(this.b, dh1Var, this.j, bVar);
        o(bVar);
        if (bVar.p) {
            ih ihVar = this.q;
            if (ihVar != null && ihVar.w()) {
                this.q = null;
                gh1.a aVar = this.e;
                if (aVar != null) {
                    aVar.c();
                }
            }
            if (bVar.n == -1) {
                bVar.n = j4;
            }
            if (bVar.o == -1) {
                bVar.o = j;
            }
        }
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(b90 b90Var) {
        this.g = b90Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(jh jhVar) {
        this.c = jhVar.h(this.a).i(this.b).k(this.g).j(new d()).a();
        this.a.C.a();
        dh1 dh1Var = this.c;
        if (dh1Var != null) {
            this.q = dh1Var.last();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s(t80 t80Var, t80.b bVar, Object... objArr) {
        boolean zP = p(t80Var, bVar, objArr);
        gh1.a aVar = this.e;
        if (aVar != null) {
            aVar.d();
        }
        return zP;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gh1
    public void start() {
        this.a.h(this.u);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
