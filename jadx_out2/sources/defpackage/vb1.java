package defpackage;

import android.util.SparseArray;
import defpackage.bx;
import defpackage.dx2;
import defpackage.t41;
import defpackage.wt4;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vb1 implements cr0 {
    public final k04 a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public long h;
    public String j;
    public gr4 k;
    public b l;
    public boolean m;
    public boolean o;
    public final boolean[] i = new boolean[3];
    public final cx2 e = new cx2(7, 128);
    public final cx2 f = new cx2(8, 128);
    public final cx2 g = new cx2(6, 128);
    public long n = -9223372036854775807L;
    public final r73 p = new r73();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final gr4 a;
        public final boolean b;
        public final boolean c;
        public final SparseArray d = new SparseArray();
        public final SparseArray e = new SparseArray();
        public final s73 f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public boolean k;
        public long l;
        public a m;
        public a n;
        public boolean o;
        public long p;
        public long q;
        public boolean r;
        public boolean s;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public boolean a;
            public boolean b;
            public dx2.m c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void b() {
                this.b = false;
                this.a = false;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final boolean c(a aVar) {
                int i;
                int i2;
                int i3;
                boolean z;
                if (!this.a) {
                    return false;
                }
                if (!aVar.a) {
                    return true;
                }
                dx2.m mVar = (dx2.m) gg3.q(this.c);
                dx2.m mVar2 = (dx2.m) gg3.q(aVar.c);
                return (this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && (!this.i || !aVar.i || this.j == aVar.j) && (((i = this.d) == (i2 = aVar.d) || (i != 0 && i2 != 0)) && (((i3 = mVar.n) != 0 || mVar2.n != 0 || (this.m == aVar.m && this.n == aVar.n)) && ((i3 != 1 || mVar2.n != 1 || (this.o == aVar.o && this.p == aVar.p)) && (z = this.k) == aVar.k && (!z || this.l == aVar.l))))) ? false : true;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public boolean d() {
                if (!this.b) {
                    return false;
                }
                int i = this.e;
                return i == 7 || i == 2;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void e(dx2.m mVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.c = mVar;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.a = true;
                this.b = true;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void f(int i) {
                this.e = i;
                this.b = true;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(gr4 gr4Var, boolean z, boolean z2) {
            this.a = gr4Var;
            this.b = z;
            this.c = z2;
            this.m = new a();
            this.n = new a();
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new s73(bArr, 0, 0);
            g();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0161  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean zE;
            boolean z3;
            int i3;
            int i4;
            int i5;
            int iH;
            int i6;
            int iH2;
            if (this.k) {
                int i7 = i2 - i;
                byte[] bArr2 = this.g;
                int length = bArr2.length;
                int i8 = this.h;
                if (length < i8 + i7) {
                    this.g = Arrays.copyOf(bArr2, (i8 + i7) * 2);
                }
                System.arraycopy(bArr, i, this.g, this.h, i7);
                int i9 = this.h + i7;
                this.h = i9;
                this.f.j(this.g, 0, i9);
                if (this.f.c(8)) {
                    this.f.l();
                    int iF = this.f.f(2);
                    this.f.m(5);
                    if (this.f.d()) {
                        this.f.i();
                        if (this.f.d()) {
                            int i10 = this.f.i();
                            if (!this.c) {
                                this.k = false;
                                this.n.f(i10);
                                return;
                            }
                            if (this.f.d()) {
                                int i11 = this.f.i();
                                if (this.e.indexOfKey(i11) < 0) {
                                    this.k = false;
                                    return;
                                }
                                dx2.l lVar = (dx2.l) this.e.get(i11);
                                dx2.m mVar = (dx2.m) this.d.get(lVar.b);
                                if (mVar.k) {
                                    if (!this.f.c(2)) {
                                        return;
                                    } else {
                                        this.f.m(2);
                                    }
                                }
                                if (this.f.c(mVar.m)) {
                                    int iF2 = this.f.f(mVar.m);
                                    if (mVar.l) {
                                        z = false;
                                        z2 = false;
                                    } else {
                                        if (!this.f.c(1)) {
                                            return;
                                        }
                                        boolean zE2 = this.f.e();
                                        if (zE2) {
                                            if (this.f.c(1)) {
                                                z = zE2;
                                                z2 = true;
                                                zE = this.f.e();
                                                z3 = this.i != 5;
                                                if (z3) {
                                                    i3 = 0;
                                                } else if (!this.f.d()) {
                                                    return;
                                                } else {
                                                    i3 = this.f.i();
                                                }
                                                i4 = mVar.n;
                                                if (i4 != 0) {
                                                    if (!this.f.c(mVar.o)) {
                                                        return;
                                                    }
                                                    int iF3 = this.f.f(mVar.o);
                                                    if (lVar.c && !z) {
                                                        if (this.f.d()) {
                                                            iH = this.f.h();
                                                            i5 = iF3;
                                                            i6 = 0;
                                                            iH2 = i6;
                                                            this.n.e(mVar, iF, i10, iF2, i11, z, z2, zE, z3, i3, i5, iH, i6, iH2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i5 = iF3;
                                                    iH = 0;
                                                } else {
                                                    if (i4 == 1 && !mVar.p) {
                                                        if (this.f.d()) {
                                                            int iH3 = this.f.h();
                                                            if (!lVar.c || z) {
                                                                i6 = iH3;
                                                                i5 = 0;
                                                                iH = 0;
                                                                iH2 = 0;
                                                            } else {
                                                                if (!this.f.d()) {
                                                                    return;
                                                                }
                                                                iH2 = this.f.h();
                                                                i6 = iH3;
                                                                i5 = 0;
                                                                iH = 0;
                                                            }
                                                            this.n.e(mVar, iF, i10, iF2, i11, z, z2, zE, z3, i3, i5, iH, i6, iH2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i5 = 0;
                                                    iH = 0;
                                                }
                                                i6 = iH;
                                                iH2 = i6;
                                                this.n.e(mVar, iF, i10, iF2, i11, z, z2, zE, z3, i3, i5, iH, i6, iH2);
                                                this.k = false;
                                            }
                                            return;
                                        }
                                        z = zE2;
                                        z2 = false;
                                    }
                                    zE = z2;
                                    if (this.i != 5) {
                                    }
                                    if (z3) {
                                    }
                                    i4 = mVar.n;
                                    if (i4 != 0) {
                                    }
                                    i6 = iH;
                                    iH2 = i6;
                                    this.n.e(mVar, iF, i10, iF2, i11, z, z2, zE, z3, i3, i5, iH, i6, iH2);
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b(long j, int i, boolean z) {
            if (this.i == 9 || (this.c && this.n.c(this.m))) {
                if (z && this.o) {
                    d(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            h();
            this.i = 24;
            return this.r;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
            long j = this.q;
            if (j != -9223372036854775807L) {
                long j2 = this.j;
                long j3 = this.p;
                if (j2 == j3) {
                    return;
                }
                int i2 = (int) (j2 - j3);
                this.a.b(j, this.r ? 1 : 0, i2, i, null);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(dx2.l lVar) {
            this.e.append(lVar.a, lVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(dx2.m mVar) {
            this.d.append(mVar.d, mVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g() {
            this.k = false;
            this.o = false;
            this.n.b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h() {
            boolean zD = this.b ? this.n.d() : this.s;
            boolean z = this.r;
            int i = this.i;
            boolean z2 = true;
            if (i != 5 && (!zD || i != 1)) {
                z2 = false;
            }
            this.r = z | z2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(long j, int i, long j2, boolean z) {
            this.i = i;
            this.l = j2;
            this.j = j;
            this.s = z;
            if (!this.b || i != 1) {
                if (!this.c) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.b();
            this.h = 0;
            this.k = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vb1(k04 k04Var, boolean z, boolean z2, String str) {
        this.a = k04Var;
        this.b = z;
        this.c = z2;
        this.d = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void b() {
        gg3.q(this.k);
        fy4.l(this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        int i;
        b();
        int iG = r73Var.g();
        int iJ = r73Var.j();
        byte[] bArrF = r73Var.f();
        this.h += (long) r73Var.a();
        this.k.a(r73Var, r73Var.a());
        while (true) {
            int iE = dx2.e(bArrF, iG, iJ, this.i);
            if (iE == iJ) {
                h(bArrF, iG, iJ);
                return;
            }
            int iK = dx2.k(bArrF, iE);
            if (iE <= 0 || bArrF[iE - 1] != 0) {
                i = 3;
            } else {
                iE--;
                i = 4;
            }
            int i2 = iE;
            int i3 = i;
            int i4 = i2 - iG;
            if (i4 > 0) {
                h(bArrF, iG, i2);
            }
            int i5 = iJ - i2;
            long j = this.h - ((long) i5);
            g(j, i5, i4 < 0 ? -i4 : 0, this.n);
            i(j, iK, this.n);
            iG = i2 + i3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void c() {
        this.h = 0L;
        this.o = false;
        this.n = -9223372036854775807L;
        dx2.c(this.i);
        this.e.d();
        this.f.d();
        this.g.d();
        this.a.b();
        b bVar = this.l;
        if (bVar != null) {
            bVar.g();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void d(boolean z) {
        b();
        if (z) {
            this.a.e();
            g(this.h, 0, 0, this.n);
            i(this.h, 9, this.n);
            g(this.h, 0, 0, this.n);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void e(long j, int i) {
        this.n = j;
        this.o |= (i & 2) != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        dVar.a();
        this.j = dVar.b();
        gr4 gr4VarE = mz0Var.e(dVar.c(), 2);
        this.k = gr4VarE;
        this.l = new b(gr4VarE, this.b, this.c);
        this.a.d(mz0Var, dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(long j, int i, int i2, long j2) {
        if (!this.m || this.l.c()) {
            this.e.b(i2);
            this.f.b(i2);
            boolean z = this.m;
            cx2 cx2Var = this.e;
            if (z) {
                if (cx2Var.c()) {
                    cx2 cx2Var2 = this.e;
                    dx2.m mVarD = dx2.D(cx2Var2.d, 3, cx2Var2.e);
                    this.a.f(mVarD.t);
                    this.l.f(mVarD);
                    this.e.d();
                } else if (this.f.c()) {
                    cx2 cx2Var3 = this.f;
                    this.l.e(dx2.B(cx2Var3.d, 3, cx2Var3.e));
                    this.f.d();
                }
            } else if (cx2Var.c() && this.f.c()) {
                ArrayList arrayList = new ArrayList();
                cx2 cx2Var4 = this.e;
                arrayList.add(Arrays.copyOf(cx2Var4.d, cx2Var4.e));
                cx2 cx2Var5 = this.f;
                arrayList.add(Arrays.copyOf(cx2Var5.d, cx2Var5.e));
                cx2 cx2Var6 = this.e;
                dx2.m mVarD2 = dx2.D(cx2Var6.d, 3, cx2Var6.e);
                cx2 cx2Var7 = this.f;
                dx2.l lVarB = dx2.B(cx2Var7.d, 3, cx2Var7.e);
                this.k.g(new t41.b().k0(this.j).X(this.d).A0("video/avc").V(gv.g(mVarD2.a, mVarD2.b, mVarD2.c)).H0(mVarD2.f).i0(mVarD2.g).W(new bx.b().d(mVarD2.q).c(mVarD2.r).e(mVarD2.s).g(mVarD2.i + 8).b(mVarD2.j + 8).a()).v0(mVarD2.h).l0(arrayList).q0(mVarD2.t).Q());
                this.m = true;
                this.a.f(mVarD2.t);
                this.l.f(mVarD2);
                this.l.e(lVarB);
                this.e.d();
                this.f.d();
            }
        }
        if (this.g.b(i2)) {
            cx2 cx2Var8 = this.g;
            this.p.d0(this.g.d, dx2.M(cx2Var8.d, cx2Var8.e));
            this.p.f0(4);
            this.a.c(j2, this.p);
        }
        if (this.l.b(j, i, this.m)) {
            this.o = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(byte[] bArr, int i, int i2) {
        if (!this.m || this.l.c()) {
            this.e.a(bArr, i, i2);
            this.f.a(bArr, i, i2);
        }
        this.g.a(bArr, i, i2);
        this.l.a(bArr, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(long j, int i, long j2) {
        if (!this.m || this.l.c()) {
            this.e.e(i);
            this.f.e(i);
        }
        this.g.e(i);
        this.l.i(j, i, j2, this.o);
    }
}
