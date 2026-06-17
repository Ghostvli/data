package defpackage;

import defpackage.dh1;
import defpackage.f90;
import defpackage.nh1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class a90 extends iq3 {
    public b90 a;
    public final t80 b;
    public f90.g c;
    public final f90 e;
    public ah1 f;
    public nh1.a g;
    public final f90.g d = new a();
    public b h = new b(this, null);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements f90.g {
        public a() {
        }

        @Override // f90.g
        public boolean a(ih ihVar, float f, int i, boolean z) {
            if (ihVar.n != 0 || !a90.this.b.D.c(ihVar, i, 0, a90.this.a, z, a90.this.b)) {
                return false;
            }
            ihVar.E(false);
            return true;
        }
    }

    public a90(t80 t80Var) {
        this.b = t80Var;
        this.e = new f90(t80Var.c());
    }

    @Override // defpackage.nh1
    public void a(boolean z) {
        this.c = z ? this.d : null;
    }

    @Override // defpackage.nh1
    public void b(nh1.a aVar) {
        this.g = aVar;
    }

    @Override // defpackage.nh1
    public void c() {
        this.e.b();
    }

    @Override // defpackage.nh1
    public void clear() {
        c();
        this.b.D.a();
    }

    @Override // defpackage.nh1
    public void d(ah1 ah1Var) {
        this.f = ah1Var;
    }

    @Override // defpackage.nh1
    public void e(fh1 fh1Var, dh1 dh1Var, long j, nh1.b bVar) {
        this.a = bVar.b;
        b bVar2 = this.h;
        bVar2.b = fh1Var;
        bVar2.c = bVar;
        bVar2.d = j;
        dh1Var.g(bVar2);
    }

    @Override // defpackage.nh1
    public void f(boolean z) {
        f90 f90Var = this.e;
        if (f90Var != null) {
            f90Var.a(z);
        }
    }

    @Override // defpackage.nh1
    public void release() {
        this.e.d();
        this.b.D.a();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends dh1.c {
        public ih a;
        public fh1 b;
        public nh1.b c;
        public long d;

        public b() {
        }

        @Override // dh1.b
        public void b() {
            this.c.e = this.a;
            super.b();
        }

        @Override // dh1.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(ih ihVar) {
            ih ihVar2;
            this.a = ihVar;
            if (ihVar.w()) {
                this.b.s(ihVar);
                return this.c.a ? 2 : 0;
            }
            if (!this.c.a && ihVar.r()) {
                return 0;
            }
            if (ihVar.n()) {
                ihVar2 = ihVar;
            } else {
                z80 z80Var = a90.this.b.D;
                nh1.b bVar = this.c;
                ihVar2 = ihVar;
                z80Var.b(ihVar2, bVar.c, bVar.d, bVar.b, false, a90.this.b);
            }
            if (ihVar2.b() >= this.d && (ihVar2.n != 0 || !ihVar2.o())) {
                if (ihVar2.p()) {
                    hh1 hh1VarE = ihVar2.e();
                    if (a90.this.f != null && (hh1VarE == null || hh1VarE.get() == null)) {
                        a90.this.f.a(ihVar2);
                    }
                    return 1;
                }
                if (ihVar2.m() == 1) {
                    this.c.c++;
                }
                if (!ihVar2.q()) {
                    ihVar2.z(this.b, false);
                }
                if (!ihVar2.u()) {
                    ihVar2.A(this.b, false);
                }
                a90.this.e.c(ihVar2, this.b, a90.this.c);
                if (!ihVar2.v() || (ihVar2.d == null && ihVar2.d() > this.b.a())) {
                    return 0;
                }
                int iA = ihVar2.a(this.b);
                if (iA == 1) {
                    this.c.r++;
                } else if (iA == 2) {
                    this.c.s++;
                    if (a90.this.f != null) {
                        a90.this.f.a(ihVar2);
                    }
                }
                this.c.a(ihVar2.m(), 1);
                this.c.b(1);
                this.c.c(ihVar2);
                if (a90.this.g != null && ihVar2.J != a90.this.b.C.d) {
                    ihVar2.J = a90.this.b.C.d;
                    a90.this.g.a(ihVar2);
                }
            }
            return 0;
        }

        public /* synthetic */ b(a90 a90Var, a aVar) {
            this();
        }
    }
}
