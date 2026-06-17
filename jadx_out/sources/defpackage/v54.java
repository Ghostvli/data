package defpackage;

import defpackage.kt3;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class v54 extends b1 implements pw2, z21, u81 {
    public final int j;
    public final int k;
    public final tl l;
    public Object[] m;
    public long n;
    public long o;
    public int p;
    public int q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements qm0 {
        public final v54 f;
        public long g;
        public final Object h;
        public final f30 i;

        public a(v54 v54Var, long j, Object obj, f30 f30Var) {
            this.f = v54Var;
            this.g = j;
            this.h = obj;
            this.i = f30Var;
        }

        @Override // defpackage.qm0
        public void e() {
            this.f.y(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[tl.values().length];
            try {
                iArr[tl.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[tl.h.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[tl.g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public /* synthetic */ Object j;
        public int l;

        public c(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= Integer.MIN_VALUE;
            return v54.A(v54.this, null, this);
        }
    }

    public v54(int i, int i2, tl tlVar) {
        this.j = i;
        this.k = i2;
        this.l = tlVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
    
        if (r8 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
    
        defpackage.on1.f(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00af, code lost:
    
        r0.f = r5;
        r0.g = r2;
        r0.h = r9;
        r0.i = r8;
        r0.l = 3;
        r10 = r2.emit(r10, r0);
        r2 = r2;
        r5 = r5;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bd, code lost:
    
        if (r10 != r1) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099 A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:15:0x003b, B:32:0x0091, B:34:0x0099, B:38:0x00ac, B:39:0x00af, B:22:0x005c), top: B:48:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa A[EDGE_INSN: B:52:0x00aa->B:37:0x00aa BREAK  A[LOOP:0: B:32:0x0091->B:55:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4, types: [a31, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [b1] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, v54] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [a31] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [d1] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, x54] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9, types: [x54] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00bd -> B:16:0x003e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object A(defpackage.v54 r8, defpackage.a31 r9, defpackage.f30 r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof v54.c
            if (r0 == 0) goto L13
            r0 = r10
            v54$c r0 = (v54.c) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            v54$c r0 = new v54$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.j
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.l
            r3 = 3
            r4 = 2
            if (r2 == 0) goto L76
            r8 = 1
            if (r2 == r8) goto L60
            if (r2 == r4) goto L4c
            if (r2 != r3) goto L45
            java.lang.Object r8 = r0.i
            ln1 r8 = (defpackage.ln1) r8
            java.lang.Object r9 = r0.h
            x54 r9 = (defpackage.x54) r9
            java.lang.Object r2 = r0.g
            a31 r2 = (defpackage.a31) r2
            java.lang.Object r5 = r0.f
            v54 r5 = (defpackage.v54) r5
            defpackage.lt3.b(r10)     // Catch: java.lang.Throwable -> L42
        L3e:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L8e
        L42:
            r8 = move-exception
            goto Lc3
        L45:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r8)
            r8 = 0
            return r8
        L4c:
            java.lang.Object r8 = r0.i
            ln1 r8 = (defpackage.ln1) r8
            java.lang.Object r9 = r0.h
            x54 r9 = (defpackage.x54) r9
            java.lang.Object r2 = r0.g
            a31 r2 = (defpackage.a31) r2
            java.lang.Object r5 = r0.f
            v54 r5 = (defpackage.v54) r5
            defpackage.lt3.b(r10)     // Catch: java.lang.Throwable -> L42
            goto L91
        L60:
            java.lang.Object r8 = r0.h
            r9 = r8
            x54 r9 = (defpackage.x54) r9
            java.lang.Object r8 = r0.g
            a31 r8 = (defpackage.a31) r8
            java.lang.Object r2 = r0.f
            v54 r2 = (defpackage.v54) r2
            defpackage.lt3.b(r10)     // Catch: java.lang.Throwable -> L73
            r10 = r8
            r8 = r2
            goto L82
        L73:
            r8 = move-exception
            r5 = r2
            goto Lc3
        L76:
            defpackage.lt3.b(r10)
            d1 r10 = r8.h()
            x54 r10 = (defpackage.x54) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L82:
            g40 r2 = r0.getContext()     // Catch: java.lang.Throwable -> Lc0
            ln1$b r5 = defpackage.ln1.e     // Catch: java.lang.Throwable -> Lc0
            g40$b r2 = r2.a(r5)     // Catch: java.lang.Throwable -> Lc0
            ln1 r2 = (defpackage.ln1) r2     // Catch: java.lang.Throwable -> Lc0
        L8e:
            r5 = r8
            r8 = r2
            r2 = r10
        L91:
            java.lang.Object r10 = r5.U(r9)     // Catch: java.lang.Throwable -> L42
            qj4 r6 = defpackage.w54.a     // Catch: java.lang.Throwable -> L42
            if (r10 != r6) goto Laa
            r0.f = r5     // Catch: java.lang.Throwable -> L42
            r0.g = r2     // Catch: java.lang.Throwable -> L42
            r0.h = r9     // Catch: java.lang.Throwable -> L42
            r0.i = r8     // Catch: java.lang.Throwable -> L42
            r0.l = r4     // Catch: java.lang.Throwable -> L42
            java.lang.Object r10 = r5.x(r9, r0)     // Catch: java.lang.Throwable -> L42
            if (r10 != r1) goto L91
            goto Lbf
        Laa:
            if (r8 == 0) goto Laf
            defpackage.on1.f(r8)     // Catch: java.lang.Throwable -> L42
        Laf:
            r0.f = r5     // Catch: java.lang.Throwable -> L42
            r0.g = r2     // Catch: java.lang.Throwable -> L42
            r0.h = r9     // Catch: java.lang.Throwable -> L42
            r0.i = r8     // Catch: java.lang.Throwable -> L42
            r0.l = r3     // Catch: java.lang.Throwable -> L42
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L42
            if (r10 != r1) goto L3e
        Lbf:
            return r1
        Lc0:
            r10 = move-exception
            r5 = r8
            r8 = r10
        Lc3:
            r5.k(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v54.A(v54, a31, f30):java.lang.Object");
    }

    public static /* synthetic */ Object F(v54 v54Var, Object obj, f30 f30Var) throws Throwable {
        if (v54Var.d(obj)) {
            return fw4.a;
        }
        Object objG = v54Var.G(obj, f30Var);
        return objG == kl1.e() ? objG : fw4.a;
    }

    public final void B(long j) {
        d1[] d1VarArr;
        if (this.g != 0 && (d1VarArr = this.f) != null) {
            for (d1 d1Var : d1VarArr) {
                if (d1Var != null) {
                    x54 x54Var = (x54) d1Var;
                    long j2 = x54Var.a;
                    if (j2 >= 0 && j2 < j) {
                        x54Var.a = j;
                    }
                }
            }
        }
        this.o = j;
    }

    @Override // defpackage.b1
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public x54 i() {
        return new x54();
    }

    @Override // defpackage.b1
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public x54[] j(int i) {
        return new x54[i];
    }

    public final void E() {
        Object[] objArr = this.m;
        objArr.getClass();
        w54.g(objArr, K(), null);
        this.p--;
        long jK = K() + 1;
        if (this.n < jK) {
            this.n = jK;
        }
        if (this.o < jK) {
            B(jK);
        }
    }

    public final Object G(Object obj, f30 f30Var) throws Throwable {
        v54 v54Var;
        Throwable th;
        f30[] f30VarArrI;
        a aVar;
        sp spVar = new sp(jl1.c(f30Var), 1);
        spVar.E();
        f30[] f30VarArrI2 = c1.a;
        synchronized (this) {
            try {
                if (R(obj)) {
                    try {
                        kt3.a aVar2 = kt3.g;
                        spVar.resumeWith(kt3.b(fw4.a));
                        f30VarArrI = I(f30VarArrI2);
                        aVar = null;
                        v54Var = this;
                    } catch (Throwable th2) {
                        th = th2;
                        v54Var = this;
                        throw th;
                    }
                } else {
                    v54Var = this;
                    try {
                        aVar = new a(v54Var, K() + ((long) P()), obj, spVar);
                        v54Var.H(aVar);
                        v54Var.q++;
                        if (v54Var.k == 0) {
                            f30VarArrI2 = v54Var.I(f30VarArrI2);
                        }
                        f30VarArrI = f30VarArrI2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (aVar != null) {
                    up.a(spVar, aVar);
                }
                for (f30 f30Var2 : f30VarArrI) {
                    if (f30Var2 != null) {
                        kt3.a aVar3 = kt3.g;
                        f30Var2.resumeWith(kt3.b(fw4.a));
                    }
                }
                Object objY = spVar.y();
                if (objY == kl1.e()) {
                    ta0.c(f30Var);
                }
                return objY == kl1.e() ? objY : fw4.a;
            } catch (Throwable th4) {
                th = th4;
                v54Var = this;
            }
        }
    }

    public final void H(Object obj) {
        int iP = P();
        Object[] objArrQ = this.m;
        if (objArrQ == null) {
            objArrQ = Q(null, 0, 2);
        } else if (iP >= objArrQ.length) {
            objArrQ = Q(objArrQ, iP, objArrQ.length * 2);
        }
        w54.g(objArrQ, K() + ((long) iP), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [f30[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final f30[] I(f30[] f30VarArr) {
        d1[] d1VarArr;
        x54 x54Var;
        f30 f30Var;
        int length = f30VarArr.length;
        if (this.g != 0 && (d1VarArr = this.f) != null) {
            int length2 = d1VarArr.length;
            int i = 0;
            f30VarArr = f30VarArr;
            while (i < length2) {
                d1 d1Var = d1VarArr[i];
                if (d1Var != null && (f30Var = (x54Var = (x54) d1Var).b) != null && T(x54Var) >= 0) {
                    int length3 = f30VarArr.length;
                    f30VarArr = f30VarArr;
                    if (length >= length3) {
                        f30VarArr = Arrays.copyOf((Object[]) f30VarArr, Math.max(2, f30VarArr.length * 2));
                    }
                    ((f30[]) f30VarArr)[length] = f30Var;
                    x54Var.b = null;
                    length++;
                }
                i++;
                f30VarArr = f30VarArr;
            }
        }
        return (f30[]) f30VarArr;
    }

    public final long J() {
        return K() + ((long) this.p);
    }

    public final long K() {
        return Math.min(this.o, this.n);
    }

    public final Object L() {
        Object[] objArr = this.m;
        objArr.getClass();
        return w54.f(objArr, (this.n + ((long) O())) - 1);
    }

    public final Object M(long j) {
        Object[] objArr = this.m;
        objArr.getClass();
        Object objF = w54.f(objArr, j);
        return objF instanceof a ? ((a) objF).h : objF;
    }

    public final long N() {
        return K() + ((long) this.p) + ((long) this.q);
    }

    public final int O() {
        return (int) ((K() + ((long) this.p)) - this.n);
    }

    public final int P() {
        return this.p + this.q;
    }

    public final Object[] Q(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            e04.a("Buffer size overflow");
            return null;
        }
        Object[] objArr2 = new Object[i2];
        this.m = objArr2;
        if (objArr != null) {
            long jK = K();
            for (int i3 = 0; i3 < i; i3++) {
                long j = ((long) i3) + jK;
                w54.g(objArr2, j, w54.f(objArr, j));
            }
        }
        return objArr2;
    }

    public final boolean R(Object obj) {
        if (l() == 0) {
            return S(obj);
        }
        if (this.p >= this.k && this.o <= this.n) {
            int i = b.a[this.l.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
            if (i != 3) {
                throw new j33();
            }
        }
        H(obj);
        int i2 = this.p + 1;
        this.p = i2;
        if (i2 > this.k) {
            E();
        }
        if (O() > this.j) {
            V(this.n + 1, this.o, J(), N());
        }
        return true;
    }

    public final boolean S(Object obj) {
        if (this.j == 0) {
            return true;
        }
        H(obj);
        int i = this.p + 1;
        this.p = i;
        if (i > this.j) {
            E();
        }
        this.o = K() + ((long) this.p);
        return true;
    }

    public final long T(x54 x54Var) {
        long j = x54Var.a;
        if (j >= J() && (this.k > 0 || j > K() || this.q == 0)) {
            return -1L;
        }
        return j;
    }

    public final Object U(x54 x54Var) {
        Object obj;
        f30[] f30VarArrW = c1.a;
        synchronized (this) {
            try {
                long jT = T(x54Var);
                if (jT < 0) {
                    obj = w54.a;
                } else {
                    long j = x54Var.a;
                    Object objM = M(jT);
                    x54Var.a = jT + 1;
                    f30VarArrW = W(j);
                    obj = objM;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (f30 f30Var : f30VarArrW) {
            if (f30Var != null) {
                kt3.a aVar = kt3.g;
                f30Var.resumeWith(kt3.b(fw4.a));
            }
        }
        return obj;
    }

    public final void V(long j, long j2, long j3, long j4) {
        long jMin = Math.min(j2, j);
        for (long jK = K(); jK < jMin; jK++) {
            Object[] objArr = this.m;
            objArr.getClass();
            w54.g(objArr, jK, null);
        }
        this.n = j;
        this.o = j2;
        this.p = (int) (j3 - jMin);
        this.q = (int) (j4 - j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.f30[] W(long r21) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v54.W(long):f30[]");
    }

    public final long X() {
        long j = this.n;
        if (j < this.o) {
            this.o = j;
        }
        return j;
    }

    @Override // defpackage.u81
    public z21 b(g40 g40Var, int i, tl tlVar) {
        return w54.e(this, g40Var, i, tlVar);
    }

    @Override // defpackage.pw2
    public void c() throws Throwable {
        v54 v54Var;
        synchronized (this) {
            try {
                v54Var = this;
                try {
                    v54Var.V(J(), this.o, J(), N());
                    fw4 fw4Var = fw4.a;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                v54Var = this;
            }
        }
    }

    @Override // defpackage.u54, defpackage.z21
    public Object collect(a31 a31Var, f30 f30Var) {
        return A(this, a31Var, f30Var);
    }

    @Override // defpackage.pw2
    public boolean d(Object obj) {
        int i;
        boolean z;
        f30[] f30VarArrI = c1.a;
        synchronized (this) {
            if (R(obj)) {
                f30VarArrI = I(f30VarArrI);
                z = true;
            } else {
                z = false;
            }
        }
        for (f30 f30Var : f30VarArrI) {
            if (f30Var != null) {
                kt3.a aVar = kt3.g;
                f30Var.resumeWith(kt3.b(fw4.a));
            }
        }
        return z;
    }

    @Override // defpackage.pw2, defpackage.a31
    public Object emit(Object obj, f30 f30Var) {
        return F(this, obj, f30Var);
    }

    public final Object x(x54 x54Var, f30 f30Var) {
        sp spVar = new sp(jl1.c(f30Var), 1);
        spVar.E();
        synchronized (this) {
            try {
                if (T(x54Var) < 0) {
                    x54Var.b = spVar;
                } else {
                    kt3.a aVar = kt3.g;
                    spVar.resumeWith(kt3.b(fw4.a));
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objY = spVar.y();
        if (objY == kl1.e()) {
            ta0.c(f30Var);
        }
        return objY == kl1.e() ? objY : fw4.a;
    }

    public final void y(a aVar) {
        synchronized (this) {
            if (aVar.g < K()) {
                return;
            }
            Object[] objArr = this.m;
            objArr.getClass();
            if (w54.f(objArr, aVar.g) != aVar) {
                return;
            }
            w54.g(objArr, aVar.g, w54.a);
            z();
            fw4 fw4Var = fw4.a;
        }
    }

    public final void z() {
        if (this.k != 0 || this.q > 1) {
            Object[] objArr = this.m;
            objArr.getClass();
            while (this.q > 0 && w54.f(objArr, (K() + ((long) P())) - 1) == w54.a) {
                this.q--;
                w54.g(objArr, K() + ((long) P()), null);
            }
        }
    }
}
