package defpackage;

import defpackage.bx;
import defpackage.dx2;
import defpackage.t41;
import defpackage.wt4;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wb1 implements cr0 {
    public final k04 a;
    public final String b;
    public String c;
    public gr4 d;
    public a e;
    public boolean f;
    public long m;
    public final boolean[] g = new boolean[3];
    public final cx2 h = new cx2(32, 128);
    public final cx2 i = new cx2(33, 128);
    public final cx2 j = new cx2(34, 128);
    public final cx2 k = new cx2(39, 128);
    public final cx2 l = new cx2(40, 128);
    public long n = -9223372036854775807L;
    public final r73 o = new r73();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final gr4 a;
        public long b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(gr4 gr4Var) {
            this.a = gr4Var;
        }

        public static boolean b(int i) {
            return (32 <= i && i <= 35) || i == 39;
        }

        public static boolean c(int i) {
            return i < 32 || i == 40;
        }

        public void a(long j, int i, boolean z) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            } else if (this.h || this.g) {
                if (z && this.i) {
                    d(i + ((int) (j - this.b)));
                }
                this.k = this.b;
                this.l = this.e;
                this.m = this.c;
                this.i = true;
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void d(int i) {
            long j = this.l;
            if (j != -9223372036854775807L) {
                long j2 = this.b;
                long j3 = this.k;
                if (j2 == j3) {
                    return;
                }
                int i2 = (int) (j2 - j3);
                this.a.b(j, this.m ? 1 : 0, i2, i, null);
            }
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                } else {
                    this.g = (bArr[i4] & 128) != 0;
                    this.f = false;
                }
            }
        }

        public void f() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void g(long j, int i, int i2, long j2, boolean z) {
            this.g = false;
            this.h = false;
            this.e = j2;
            this.d = 0;
            this.b = j;
            if (!c(i2)) {
                if (this.i && !this.j) {
                    if (z) {
                        d(i);
                    }
                    this.i = false;
                }
                if (b(i2)) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            boolean z2 = i2 >= 16 && i2 <= 21;
            this.c = z2;
            this.f = z2 || i2 <= 9;
        }
    }

    public wb1(k04 k04Var, String str) {
        this.a = k04Var;
        this.b = str;
    }

    private void b() {
        gg3.q(this.d);
        fy4.l(this.e);
    }

    private void g(long j, int i, int i2, long j2) {
        this.e.a(j, i, this.f);
        if (!this.f) {
            this.h.b(i2);
            this.i.b(i2);
            this.j.b(i2);
            if (this.h.c() && this.i.c() && this.j.c()) {
                t41 t41VarI = i(this.c, this.h, this.i, this.j, this.b);
                this.d.g(t41VarI);
                gg3.v(t41VarI.r != -1);
                this.a.f(t41VarI.r);
                this.f = true;
            }
        }
        if (this.k.b(i2)) {
            cx2 cx2Var = this.k;
            this.o.d0(this.k.d, dx2.M(cx2Var.d, cx2Var.e));
            this.o.g0(5);
            this.a.c(j2, this.o);
        }
        if (this.l.b(i2)) {
            cx2 cx2Var2 = this.l;
            this.o.d0(this.l.d, dx2.M(cx2Var2.d, cx2Var2.e));
            this.o.g0(5);
            this.a.c(j2, this.o);
        }
    }

    private void h(byte[] bArr, int i, int i2) {
        this.e.e(bArr, i, i2);
        if (!this.f) {
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
            this.j.a(bArr, i, i2);
        }
        this.k.a(bArr, i, i2);
        this.l.a(bArr, i, i2);
    }

    public static t41 i(String str, cx2 cx2Var, cx2 cx2Var2, cx2 cx2Var3, String str2) {
        int i = cx2Var.e;
        byte[] bArr = new byte[cx2Var2.e + i + cx2Var3.e];
        System.arraycopy(cx2Var.d, 0, bArr, 0, i);
        System.arraycopy(cx2Var2.d, 0, bArr, cx2Var.e, cx2Var2.e);
        System.arraycopy(cx2Var3.d, 0, bArr, cx2Var.e + cx2Var2.e, cx2Var3.e);
        dx2.h hVarV = dx2.v(cx2Var2.d, 3, cx2Var2.e, null);
        dx2.c cVar = hVarV.c;
        return new t41.b().k0(str).X(str2).A0("video/hevc").V(cVar != null ? gv.i(cVar.a, cVar.b, cVar.c, cVar.d, cVar.e, cVar.f) : null).H0(hVarV.h).i0(hVarV.i).c0(hVarV.j).b0(hVarV.k).W(new bx.b().d(hVarV.n).c(hVarV.o).e(hVarV.p).g(hVarV.e + 8).b(hVarV.f + 8).a()).v0(hVarV.l).q0(hVarV.m).r0(hVarV.b + 1).l0(Collections.singletonList(bArr)).Q();
    }

    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        int i;
        b();
        while (r73Var.a() > 0) {
            int iG = r73Var.g();
            int iJ = r73Var.j();
            byte[] bArrF = r73Var.f();
            this.m += (long) r73Var.a();
            this.d.a(r73Var, r73Var.a());
            while (iG < iJ) {
                int iE = dx2.e(bArrF, iG, iJ, this.g);
                if (iE == iJ) {
                    h(bArrF, iG, iJ);
                    return;
                }
                int i2 = dx2.i(bArrF, iE);
                if (iE <= 0 || bArrF[iE - 1] != 0) {
                    i = 3;
                } else {
                    iE--;
                    i = 4;
                }
                int i3 = iE;
                int i4 = i;
                int i5 = i3 - iG;
                if (i5 > 0) {
                    h(bArrF, iG, i3);
                }
                int i6 = iJ - i3;
                long j = this.m - ((long) i6);
                g(j, i6, i5 < 0 ? -i5 : 0, this.n);
                j(j, i6, i2, this.n);
                iG = i3 + i4;
            }
        }
    }

    @Override // defpackage.cr0
    public void c() {
        this.m = 0L;
        this.n = -9223372036854775807L;
        dx2.c(this.g);
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        this.l.d();
        this.a.b();
        a aVar = this.e;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // defpackage.cr0
    public void d(boolean z) {
        b();
        if (z) {
            this.a.e();
            g(this.m, 0, 0, this.n);
            j(this.m, 0, 48, this.n);
        }
    }

    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.n = j;
    }

    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.c = dVar.b();
        gr4 gr4VarE = mz0Var.e(dVar.c(), 2);
        this.d = gr4VarE;
        this.e = new a(gr4VarE);
        this.a.d(mz0Var, dVar);
    }

    public final void j(long j, int i, int i2, long j2) {
        this.e.g(j, i, i2, j2, this.f);
        if (!this.f) {
            this.h.e(i2);
            this.i.e(i2);
            this.j.e(i2);
        }
        this.k.e(i2);
        this.l.e(i2);
    }
}
