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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(v54 v54Var, long j, Object obj, f30 f30Var) {
            this.f = v54Var;
            this.g = j;
            this.h = obj;
            this.i = f30Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.qm0
        public void e() {
            this.f.y(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= Integer.MIN_VALUE;
            return v54.A(v54.this, null, this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v54(int i, int i2, tl tlVar) {
        this.j = i;
        this.k = i2;
        this.l = tlVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0042 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0022 */
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
    */
    public static /* synthetic */ Object A(v54 v54Var, a31 a31Var, f30 f30Var) throws Throwable {
        c cVar;
        ?? r5;
        ?? r10;
        v54 v54Var2;
        ln1 ln1Var;
        ln1 ln1Var2;
        ?? r2;
        Object objU;
        ?? r102;
        ?? r9;
        ?? r8;
        if (f30Var instanceof c) {
            cVar = (c) f30Var;
            int i = cVar.l;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.l = i - Integer.MIN_VALUE;
            } else {
                cVar = v54Var.new c(f30Var);
            }
        }
        Object obj = cVar.j;
        Object objE = kl1.e();
        int i2 = cVar.l;
        try {
            try {
                if (i2 == 0) {
                    lt3.b(obj);
                    r10 = a31Var;
                    a31Var = (x54) v54Var.h();
                    v54Var2 = v54Var;
                } else {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            ln1Var2 = (ln1) cVar.i;
                            x54 x54Var = (x54) cVar.h;
                            a31 a31Var2 = (a31) cVar.g;
                            v54 v54Var3 = (v54) cVar.f;
                            lt3.b(obj);
                            r2 = a31Var2;
                            r5 = v54Var3;
                            a31Var = x54Var;
                            while (true) {
                                objU = r5.U(a31Var);
                                if (objU != w54.a) {
                                }
                            }
                            return objE;
                        }
                        if (i2 != 3) {
                            e04.a("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ln1Var2 = (ln1) cVar.i;
                        x54 x54Var2 = (x54) cVar.h;
                        a31 a31Var3 = (a31) cVar.g;
                        v54 v54Var4 = (v54) cVar.f;
                        lt3.b(obj);
                        ?? r22 = a31Var3;
                        ?? r52 = v54Var4;
                        ?? r92 = x54Var2;
                        r102 = r22;
                        ln1Var = ln1Var2;
                        r8 = r52;
                        r9 = r92;
                        r5 = r8;
                        ln1Var2 = ln1Var;
                        r2 = r102;
                        a31Var = r9;
                        while (true) {
                            objU = r5.U(a31Var);
                            if (objU != w54.a) {
                                break;
                            }
                            cVar.f = r5;
                            cVar.g = r2;
                            cVar.h = a31Var;
                            cVar.i = ln1Var2;
                            cVar.l = 2;
                            if (r5.x(a31Var, cVar) == objE) {
                                break;
                            }
                        }
                        return objE;
                    }
                    a31Var = (x54) cVar.h;
                    a31 a31Var4 = (a31) cVar.g;
                    v54 v54Var5 = (v54) cVar.f;
                    try {
                        lt3.b(obj);
                        r10 = a31Var4;
                        v54Var2 = v54Var5;
                        a31Var = a31Var;
                    } catch (Throwable th) {
                        th = th;
                        r5 = v54Var5;
                        r5.k(a31Var);
                        throw th;
                    }
                }
                ln1Var = (ln1) cVar.getContext().a(ln1.e);
                r8 = v54Var2;
                r9 = a31Var;
                r102 = r10;
                r5 = r8;
                ln1Var2 = ln1Var;
                r2 = r102;
                a31Var = r9;
                while (true) {
                    objU = r5.U(a31Var);
                    if (objU != w54.a) {
                    }
                }
                return objE;
            } catch (Throwable th2) {
                r5 = v54Var2;
                th = th2;
                r5.k(a31Var);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object F(v54 v54Var, Object obj, f30 f30Var) throws Throwable {
        if (v54Var.d(obj)) {
            return fw4.a;
        }
        Object objG = v54Var.G(obj, f30Var);
        return objG == kl1.e() ? objG : fw4.a;
    }

    /* JADX DEBUG: Class process forced to load method for inline: b1.e(b1):int */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i()Ld1; */
    @Override // defpackage.b1
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public x54 i() {
        return new x54();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(I)[Ld1; */
    @Override // defpackage.b1
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public x54[] j(int i) {
        return new x54[i];
    }

    /* JADX DEBUG: Class process forced to load method for inline: w54.d(java.lang.Object[], long, java.lang.Object):void */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0042 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x003f */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long J() {
        return K() + ((long) this.p);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long K() {
        return Math.min(this.o, this.n);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object L() {
        Object[] objArr = this.m;
        objArr.getClass();
        return w54.f(objArr, (this.n + ((long) O())) - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object M(long j) {
        Object[] objArr = this.m;
        objArr.getClass();
        Object objF = w54.f(objArr, j);
        return objF instanceof a ? ((a) objF).h : objF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long N() {
        return K() + ((long) this.p) + ((long) this.q);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int O() {
        return (int) ((K() + ((long) this.p)) - this.n);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int P() {
        return this.p + this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long T(x54 x54Var) {
        long j = x54Var.a;
        if (j >= J() && (this.k > 0 || j > K() || this.q == 0)) {
            return -1L;
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f30[] W(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        f30[] f30VarArr;
        long jMax;
        Object[] objArr;
        d1[] d1VarArr;
        if (j > this.o) {
            return c1.a;
        }
        long jK = K();
        long j6 = ((long) this.p) + jK;
        if (this.k == 0 && this.q > 0) {
            j6++;
        }
        int i = 0;
        if (this.g != 0 && (d1VarArr = this.f) != null) {
            for (d1 d1Var : d1VarArr) {
                if (d1Var != null) {
                    long j7 = ((x54) d1Var).a;
                    if (j7 >= 0 && j7 < j6) {
                        j6 = j7;
                    }
                }
            }
        }
        if (j6 <= this.o) {
            return c1.a;
        }
        long J = J();
        int iL = l();
        int iMin = this.q;
        if (iL > 0) {
            iMin = Math.min(iMin, this.k - ((int) (J - j6)));
        }
        f30[] f30VarArr2 = c1.a;
        long j8 = ((long) this.q) + J;
        if (iMin > 0) {
            f30VarArr2 = new f30[iMin];
            Object[] objArr2 = this.m;
            objArr2.getClass();
            j4 = 1;
            long j9 = J;
            while (J < j8) {
                Object objF = w54.f(objArr2, J);
                j2 = jK;
                qj4 qj4Var = w54.a;
                if (objF != qj4Var) {
                    objF.getClass();
                    a aVar = (a) objF;
                    int i2 = i + 1;
                    j3 = j6;
                    f30VarArr2[i] = aVar.i;
                    w54.g(objArr2, J, qj4Var);
                    w54.g(objArr2, j9, aVar.h);
                    j5 = j9 + 1;
                    if (i2 < iMin) {
                        i = i2;
                        j9 = j5;
                    }
                } else {
                    j3 = j6;
                }
                J++;
                jK = j2;
                j6 = j3;
            }
            j2 = jK;
            j3 = j6;
            f30VarArr = f30VarArr2;
            j5 = j9;
            int i3 = (int) (j5 - j2);
            if (l() == 0) {
                j3 = j5;
            }
            jMax = Math.max(this.n, j5 - ((long) Math.min(this.j, i3)));
            if (this.k == 0 && jMax < j8) {
                objArr = this.m;
                objArr.getClass();
                if (il1.a(w54.f(objArr, jMax), w54.a)) {
                    j5 += j4;
                    jMax += j4;
                }
            }
            V(jMax, j3, j5, j8);
            z();
            return f30VarArr.length != 0 ? f30VarArr : I(f30VarArr);
        }
        j2 = jK;
        j3 = j6;
        j4 = 1;
        j5 = J;
        f30VarArr = f30VarArr2;
        int i32 = (int) (j5 - j2);
        if (l() == 0) {
        }
        jMax = Math.max(this.n, j5 - ((long) Math.min(this.j, i32)));
        if (this.k == 0) {
            objArr = this.m;
            objArr.getClass();
            if (il1.a(w54.f(objArr, jMax), w54.a)) {
            }
        }
        V(jMax, j3, j5, j8);
        z();
        if (f30VarArr.length != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long X() {
        long j = this.n;
        if (j < this.o) {
            this.o = j;
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u81
    public z21 b(g40 g40Var, int i, tl tlVar) {
        return w54.e(this, g40Var, i, tlVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u54, defpackage.z21
    public Object collect(a31 a31Var, f30 f30Var) {
        return A(this, a31Var, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pw2, defpackage.a31
    public Object emit(Object obj, f30 f30Var) {
        return F(this, obj, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
