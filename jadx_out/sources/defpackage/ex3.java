package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.ex3;
import defpackage.gr4;
import defpackage.po0;
import defpackage.wo0;
import defpackage.xo0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ex3 implements gr4 {
    public boolean B;
    public t41 C;
    public t41 D;
    public long E;
    public boolean G;
    public long H;
    public boolean I;
    public final cx3 a;
    public final xo0 d;
    public final wo0.a e;
    public d f;
    public t41 g;
    public po0 h;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean y;
    public final b b = new b();
    public int i = 1000;
    public long[] j = new long[1000];
    public long[] k = new long[1000];
    public long[] n = new long[1000];
    public int[] m = new int[1000];
    public int[] l = new int[1000];
    public gr4.a[] o = new gr4.a[1000];
    public final jb4 c = new jb4(new g20() { // from class: dx3
        @Override // defpackage.g20
        public final void accept(Object obj) {
            ((ex3.c) obj).b.release();
        }
    });
    public long t = Long.MIN_VALUE;
    public long v = Long.MIN_VALUE;
    public long w = Long.MIN_VALUE;
    public boolean A = true;
    public boolean z = true;
    public boolean F = true;
    public long u = Long.MIN_VALUE;
    public int x = -1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public int a;
        public long b;
        public gr4.a c;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final t41 a;
        public final xo0.b b;

        public c(t41 t41Var, xo0.b bVar) {
            this.a = t41Var;
            this.b = bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void w(t41 t41Var);
    }

    public ex3(j5 j5Var, xo0 xo0Var, wo0.a aVar) {
        this.d = xo0Var;
        this.e = aVar;
        this.a = new cx3(j5Var);
    }

    public static boolean j(String str, String str2) {
        return nt2.k(str) == 1 && nt2.a(str, str2);
    }

    public static ex3 m(j5 j5Var, xo0 xo0Var, wo0.a aVar) {
        return new ex3(j5Var, (xo0) gg3.q(xo0Var), (wo0.a) gg3.q(aVar));
    }

    public static ex3 n(j5 j5Var) {
        return new ex3(j5Var, null, null);
    }

    public t41 A(t41 t41Var) {
        return (this.H == 0 || t41Var.u == Long.MAX_VALUE) ? t41Var : t41Var.b().E0(t41Var.u + this.H).Q();
    }

    public final int B() {
        return this.q;
    }

    public final synchronized long C() {
        return this.p == 0 ? Long.MIN_VALUE : this.n[this.r];
    }

    public final synchronized long D() {
        return this.w;
    }

    public final synchronized long E() {
        return Math.max(this.v, F(this.s));
    }

    public final long F(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iH = H(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.n[iH]);
            if ((this.m[iH] & 1) != 0) {
                return jMax;
            }
            iH--;
            if (iH == -1) {
                iH = this.i - 1;
            }
        }
        return jMax;
    }

    public final int G() {
        return this.q + this.s;
    }

    public final int H(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized int I(long j, boolean z) throws Throwable {
        Throwable th;
        ex3 ex3Var;
        try {
            try {
                int iH = H(this.s);
                if (!L() || j < this.n[iH]) {
                    return 0;
                }
                if (j <= this.w || !z) {
                    int iZ = z(iH, this.p - this.s, j, true);
                    if (iZ == -1) {
                        return 0;
                    }
                    return iZ;
                }
                try {
                    return this.p - this.s;
                } catch (Throwable th2) {
                    th = th2;
                    ex3Var = this;
                }
            } catch (Throwable th3) {
                th = th3;
                ex3Var = this;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        throw th;
    }

    public final synchronized t41 J() {
        return this.A ? null : this.D;
    }

    public final int K() {
        return this.q + this.p;
    }

    public final boolean L() {
        return this.s != this.p;
    }

    public final synchronized boolean M() {
        return this.x != -1;
    }

    public final void N() {
        this.B = true;
    }

    public final synchronized boolean O() {
        return this.y;
    }

    public synchronized boolean P(boolean z) {
        t41 t41Var;
        int iG = G();
        int i = this.x;
        boolean z2 = true;
        if (i != -1 && iG >= i) {
            return true;
        }
        if (L()) {
            if (((c) this.c.e(iG)).a != this.g) {
                return true;
            }
            return Q(H(this.s));
        }
        if (!z && !this.y && ((t41Var = this.D) == null || t41Var == this.g)) {
            z2 = false;
        }
        return z2;
    }

    public final boolean Q(int i) {
        po0 po0Var = this.h;
        if (po0Var == null || po0Var.getState() == 4) {
            return true;
        }
        return (this.m[i] & Buffer.MAX_SIZE) == 0 && this.h.c();
    }

    public void R() throws po0.a {
        po0 po0Var = this.h;
        if (po0Var != null && po0Var.getState() == 1) {
            throw ((po0.a) gg3.q(this.h.getError()));
        }
    }

    public final void S(t41 t41Var, u41 u41Var) {
        t41 t41Var2 = this.g;
        boolean z = t41Var2 == null;
        oo0 oo0Var = t41Var2 == null ? null : t41Var2.t;
        this.g = t41Var;
        oo0 oo0Var2 = t41Var.t;
        xo0 xo0Var = this.d;
        u41Var.b = xo0Var != null ? t41Var.c(xo0Var.d(t41Var)) : t41Var;
        u41Var.a = this.h;
        if (this.d == null) {
            return;
        }
        if (z || !Objects.equals(oo0Var, oo0Var2)) {
            po0 po0Var = this.h;
            po0 po0VarA = this.d.a(this.e, t41Var);
            this.h = po0VarA;
            u41Var.a = po0VarA;
            if (po0Var != null) {
                po0Var.d(this.e);
            }
        }
    }

    public final synchronized int T(u41 u41Var, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, b bVar) {
        boolean z3 = false;
        decoderInputBuffer.waitingForKeys = false;
        int iG = G();
        int i = this.x;
        if (i != -1 && iG >= i) {
            z3 = true;
        }
        if (L() && !z3) {
            t41 t41Var = ((c) this.c.e(iG)).a;
            if (!z && t41Var == this.g) {
                int iH = H(this.s);
                if (!Q(iH)) {
                    decoderInputBuffer.waitingForKeys = true;
                    return -3;
                }
                decoderInputBuffer.setFlags(this.m[iH]);
                if (this.s == this.p - 1 && (z2 || this.y)) {
                    decoderInputBuffer.addFlag(536870912);
                }
                decoderInputBuffer.timeUs = this.n[iH];
                bVar.a = this.l[iH];
                bVar.b = this.k[iH];
                bVar.c = this.o[iH];
                return -4;
            }
            S(t41Var, u41Var);
            return -5;
        }
        if (!z2 && !this.y && !z3) {
            t41 t41Var2 = this.D;
            if (t41Var2 == null || (!z && t41Var2 == this.g)) {
                return -3;
            }
            S((t41) gg3.q(t41Var2), u41Var);
            return -5;
        }
        decoderInputBuffer.setFlags(4);
        decoderInputBuffer.timeUs = Long.MIN_VALUE;
        return -4;
    }

    public final synchronized long U() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return L() ? this.j[H(this.s)] : this.E;
    }

    public void V() {
        t();
        Y();
    }

    public int W(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i, boolean z) {
        int iT = T(u41Var, decoderInputBuffer, (i & 2) != 0, z, this.b);
        if (iT == -4 && !decoderInputBuffer.isEndOfStream()) {
            boolean z2 = (i & 1) != 0;
            if ((i & 4) == 0) {
                cx3 cx3Var = this.a;
                if (z2) {
                    cx3Var.f(decoderInputBuffer, this.b);
                } else {
                    cx3Var.m(decoderInputBuffer, this.b);
                }
            }
            if (!z2) {
                this.s++;
            }
        }
        return iT;
    }

    public void X() {
        a0(true);
        Y();
    }

    public final void Y() {
        po0 po0Var = this.h;
        if (po0Var != null) {
            po0Var.d(this.e);
            this.h = null;
            this.g = null;
        }
    }

    public final void Z() {
        a0(false);
    }

    public void a0(boolean z) {
        this.a.n();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = -1;
        this.z = true;
        this.t = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = Long.MIN_VALUE;
        this.y = false;
        this.c.b();
        if (z) {
            this.C = null;
            this.D = null;
            this.A = true;
            this.F = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    @Override // defpackage.gr4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(long r12, int r14, int r15, int r16, gr4.a r17) {
        /*
            r11 = this;
            boolean r1 = r11.B
            if (r1 == 0) goto Lf
            t41 r1 = r11.C
            java.lang.Object r1 = defpackage.gg3.q(r1)
            t41 r1 = (defpackage.t41) r1
            r11.g(r1)
        Lf:
            r1 = r14 & 1
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L17
            r4 = r3
            goto L18
        L17:
            r4 = r2
        L18:
            boolean r5 = r11.z
            if (r5 == 0) goto L21
            if (r4 != 0) goto L1f
            goto L61
        L1f:
            r11.z = r2
        L21:
            long r5 = r11.H
            long r5 = r5 + r12
            boolean r7 = r11.F
            if (r7 == 0) goto L50
            long r7 = r11.t
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 >= 0) goto L2f
            goto L61
        L2f:
            if (r1 != 0) goto L50
            boolean r1 = r11.G
            if (r1 != 0) goto L4c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r7 = "Overriding unexpected non-sync sample for format: "
            r1.<init>(r7)
            t41 r7 = r11.D
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String r7 = "SampleQueue"
            defpackage.xz1.i(r7, r1)
            r11.G = r3
        L4c:
            r1 = r14 | 1
            r3 = r1
            goto L51
        L50:
            r3 = r14
        L51:
            boolean r1 = r11.I
            if (r1 == 0) goto L62
            if (r4 == 0) goto L61
            boolean r1 = r11.i(r5)
            if (r1 != 0) goto L5e
            goto L61
        L5e:
            r11.I = r2
            goto L62
        L61:
            return
        L62:
            cx3 r1 = r11.a
            long r1 = r1.e()
            long r7 = (long) r15
            long r1 = r1 - r7
            r7 = r16
            long r7 = (long) r7
            long r1 = r1 - r7
            r9 = r5
            r4 = r1
            r1 = r9
            r0 = r11
            r6 = r15
            r7 = r17
            r0.k(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ex3.b(long, int, int, int, gr4$a):void");
    }

    public final synchronized void b0() {
        this.s = 0;
        this.a.o();
    }

    @Override // defpackage.gr4
    public final void c(r73 r73Var, int i, int i2) {
        this.a.q(r73Var, i);
    }

    public final synchronized boolean c0(int i) {
        b0();
        int i2 = this.q;
        if (i >= i2 && i <= this.p + i2) {
            int i3 = this.x;
            if (i3 != -1 && i >= i3) {
                return false;
            }
            this.t = Long.MIN_VALUE;
            this.s = i - i2;
            return true;
        }
        return false;
    }

    public final synchronized boolean d0(long j, boolean z) throws Throwable {
        Throwable th;
        ex3 ex3Var;
        int iH;
        long j2;
        long jMin;
        Throwable th2;
        long j3;
        int iY;
        ex3 ex3Var2;
        try {
            try {
                b0();
                iH = H(this.s);
                j2 = this.u;
                jMin = this.w;
            } catch (Throwable th3) {
                th = th3;
                ex3Var = this;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        if (j2 != Long.MIN_VALUE) {
            try {
                jMin = Math.min(jMin, j2);
                if (!L() && j >= this.n[iH] && (j <= jMin || z)) {
                    boolean z2 = this.F;
                    int i = this.p;
                    if (z2) {
                        try {
                            int i2 = i - this.s;
                            ex3Var = this;
                            j3 = j;
                            try {
                                iY = ex3Var.y(iH, i2, j3, z);
                                ex3Var2 = ex3Var;
                            } catch (Throwable th5) {
                                th2 = th5;
                                th = th2;
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                            ex3Var = this;
                        }
                    } else {
                        j3 = j;
                        try {
                            int i3 = i - this.s;
                            ex3Var2 = this;
                            iY = ex3Var2.z(iH, i3, j3, true);
                        } catch (Throwable th7) {
                            th = th7;
                            ex3Var = this;
                        }
                    }
                    if (iY == -1) {
                        return false;
                    }
                    ex3Var2.t = j3;
                    ex3Var2.s += iY;
                    return true;
                }
            } catch (Throwable th8) {
                th = th8;
                ex3Var = this;
            }
            th = th;
        } else if (!L()) {
        }
        throw th;
        return false;
    }

    public final synchronized void e0(long j) throws Throwable {
        ex3 ex3Var;
        Throwable th;
        ex3 ex3Var2;
        long j2;
        int iY;
        try {
            try {
                if (j == this.u) {
                    return;
                }
                int i = -1;
                if (j != Long.MIN_VALUE) {
                    if (j <= this.w) {
                        ex3Var2 = this;
                        j2 = j;
                        iY = ex3Var2.y(this.r, this.p, j2, false);
                    } else {
                        ex3Var2 = this;
                        j2 = j;
                        iY = -1;
                    }
                    if (iY != -1) {
                        i = ex3Var2.q + iY;
                    }
                    ex3Var2.x = i;
                    ex3Var2.u = j2;
                    return;
                }
                try {
                    this.x = -1;
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    ex3Var = this;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            ex3Var = this;
        }
        th = th;
        throw th;
    }

    @Override // defpackage.gr4
    public final int f(x90 x90Var, int i, boolean z, int i2) {
        return this.a.p(x90Var, i, z);
    }

    public final void f0(long j) {
        if (this.H != j) {
            this.H = j;
            N();
        }
    }

    @Override // defpackage.gr4
    public final void g(t41 t41Var) {
        t41 t41VarA = A(t41Var);
        this.B = false;
        this.C = t41Var;
        boolean zH0 = h0(t41VarA);
        d dVar = this.f;
        if (dVar == null || !zH0) {
            return;
        }
        dVar.w(t41VarA);
    }

    public final void g0(long j) {
        this.t = j;
    }

    public final synchronized boolean h0(t41 t41Var) {
        try {
            this.A = false;
            if (Objects.equals(t41Var, this.D)) {
                return false;
            }
            if (this.c.g() || !((c) this.c.f()).a.equals(t41Var)) {
                this.D = t41Var;
            } else {
                this.D = ((c) this.c.f()).a;
            }
            boolean z = this.F;
            t41 t41Var2 = this.D;
            this.F = z & j(t41Var2.p, t41Var2.k);
            this.G = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean i(long j) {
        if (this.p == 0) {
            return j > this.v;
        }
        if (E() >= j) {
            return false;
        }
        w(this.q + l(j));
        return true;
    }

    public final void i0(d dVar) {
        this.f = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void j0(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Le
            int r0 = r2.s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.p     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            defpackage.gg3.d(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.s = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ex3.j0(int):void");
    }

    public final synchronized void k(long j, int i, long j2, int i2, gr4.a aVar) {
        try {
            int i3 = this.p;
            if (i3 > 0) {
                int iH = H(i3 - 1);
                gg3.d(this.k[iH] + ((long) this.l[iH]) <= j2);
            }
            this.y = (536870912 & i) != 0;
            this.w = Math.max(this.w, j);
            long j3 = this.u;
            if (j3 != Long.MIN_VALUE && this.x == -1 && j >= j3) {
                this.x = this.q + this.p;
            }
            int iH2 = H(this.p);
            this.n[iH2] = j;
            this.k[iH2] = j2;
            this.l[iH2] = i2;
            this.m[iH2] = i;
            this.o[iH2] = aVar;
            this.j[iH2] = this.E;
            if (this.c.g() || !((c) this.c.f()).a.equals(this.D)) {
                t41 t41Var = (t41) gg3.q(this.D);
                xo0 xo0Var = this.d;
                this.c.a(K(), new c(t41Var, xo0Var != null ? xo0Var.b(this.e, t41Var) : xo0.b.a));
            }
            int i4 = this.p + 1;
            this.p = i4;
            int i5 = this.i;
            if (i4 == i5) {
                int i6 = i5 + 1000;
                long[] jArr = new long[i6];
                long[] jArr2 = new long[i6];
                long[] jArr3 = new long[i6];
                int[] iArr = new int[i6];
                int[] iArr2 = new int[i6];
                gr4.a[] aVarArr = new gr4.a[i6];
                int i7 = this.r;
                int i8 = i5 - i7;
                System.arraycopy(this.k, i7, jArr2, 0, i8);
                System.arraycopy(this.n, this.r, jArr3, 0, i8);
                System.arraycopy(this.m, this.r, iArr, 0, i8);
                System.arraycopy(this.l, this.r, iArr2, 0, i8);
                System.arraycopy(this.o, this.r, aVarArr, 0, i8);
                System.arraycopy(this.j, this.r, jArr, 0, i8);
                int i9 = this.r;
                System.arraycopy(this.k, 0, jArr2, i8, i9);
                System.arraycopy(this.n, 0, jArr3, i8, i9);
                System.arraycopy(this.m, 0, iArr, i8, i9);
                System.arraycopy(this.l, 0, iArr2, i8, i9);
                System.arraycopy(this.o, 0, aVarArr, i8, i9);
                System.arraycopy(this.j, 0, jArr, i8, i9);
                this.k = jArr2;
                this.n = jArr3;
                this.m = iArr;
                this.l = iArr2;
                this.o = aVarArr;
                this.j = jArr;
                this.r = 0;
                this.i = i6;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void k0(long j) {
        this.E = j;
    }

    public final int l(long j) {
        int i = this.p;
        int iH = H(i - 1);
        while (i > this.s && this.n[iH] >= j) {
            i--;
            iH--;
            if (iH == -1) {
                iH = this.i - 1;
            }
        }
        return i;
    }

    public final void l0() {
        this.I = true;
    }

    public final synchronized long o(long j, boolean z, boolean z2) throws Throwable {
        ex3 ex3Var;
        Throwable th;
        try {
            try {
                int i = this.p;
                if (i != 0) {
                    long[] jArr = this.n;
                    int i2 = this.r;
                    if (j >= jArr[i2]) {
                        if (z2) {
                            try {
                                int i3 = this.s;
                                if (i3 != i) {
                                    i = i3 + 1;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                ex3Var = this;
                                throw th;
                            }
                        }
                        int iZ = z(i2, i, j, z);
                        if (iZ == -1) {
                            return -1L;
                        }
                        return r(iZ);
                    }
                }
                return -1L;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            ex3Var = this;
            th = th;
            throw th;
        }
    }

    public final synchronized long p() {
        int i = this.p;
        if (i == 0) {
            return -1L;
        }
        return r(i);
    }

    public synchronized long q() {
        int i = this.s;
        if (i == 0) {
            return -1L;
        }
        return r(i);
    }

    public final long r(int i) {
        this.v = Math.max(this.v, F(i));
        this.p -= i;
        int i2 = this.q + i;
        this.q = i2;
        int i3 = this.r + i;
        this.r = i3;
        int i4 = this.i;
        if (i3 >= i4) {
            this.r = i3 - i4;
        }
        int i5 = this.s - i;
        this.s = i5;
        if (i5 < 0) {
            this.s = 0;
        }
        this.c.d(i2);
        if (this.p != 0) {
            return this.k[this.r];
        }
        int i6 = this.r;
        if (i6 == 0) {
            i6 = this.i;
        }
        int i7 = i6 - 1;
        return this.k[i7] + ((long) this.l[i7]);
    }

    public final void s(long j, boolean z, boolean z2) {
        this.a.b(o(j, z, z2));
    }

    public final void t() {
        this.a.b(p());
    }

    public final void u() {
        this.a.b(q());
    }

    public final void v(long j) {
        if (this.p == 0) {
            return;
        }
        gg3.d(j > E());
        x(this.q + l(j));
    }

    public final long w(int i) {
        int iK = K() - i;
        boolean z = false;
        gg3.d(iK >= 0 && iK <= this.p - this.s);
        int i2 = this.p - iK;
        this.p = i2;
        this.w = Math.max(this.v, F(i2));
        if (iK == 0 && this.y) {
            z = true;
        }
        this.y = z;
        int i3 = this.x;
        if (i3 != -1 && i < i3) {
            this.x = -1;
        }
        this.c.c(i);
        int i4 = this.p;
        if (i4 == 0) {
            return 0L;
        }
        int iH = H(i4 - 1);
        return this.k[iH] + ((long) this.l[iH]);
    }

    public final void x(int i) {
        this.a.c(w(i));
    }

    public final int y(int i, int i2, long j, boolean z) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.n[i] >= j) {
                return i3;
            }
            i++;
            if (i == this.i) {
                i = 0;
            }
        }
        if (z) {
            return i2;
        }
        return -1;
    }

    public final int z(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.n[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.m[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.i) {
                i = 0;
            }
        }
        return i3;
    }
}
