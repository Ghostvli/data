package defpackage;

import defpackage.ds4;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qf3 implements ds4, ao3 {
    public final m00 a;
    public final c10 b;
    public final boolean c;
    public final ia d;
    public volatile boolean e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements ow3 {
        public final ow3 f;
        public final long g;
        public final /* synthetic */ qf3 h;

        public a(qf3 qf3Var, ow3 ow3Var) {
            ow3Var.getClass();
            this.h = qf3Var;
            this.f = ow3Var;
            this.g = qn4.b();
        }

        @Override // defpackage.ow3
        public String I(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return null;
            }
            if (this.g == qn4.b()) {
                return this.f.I(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return null;
        }

        @Override // defpackage.ow3
        public boolean Y() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return false;
            }
            if (this.g == qn4.b()) {
                return this.f.Y();
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return false;
        }

        @Override // defpackage.ow3
        public void b(int i, double d) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.b(i, d);
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        @Override // defpackage.ow3, java.lang.AutoCloseable
        public void close() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.close();
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        @Override // defpackage.ow3
        public void d(int i, long j) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.d(i, j);
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        @Override // defpackage.ow3
        public void e(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.e(i);
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        @Override // defpackage.ow3
        public void g() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.g();
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        @Override // defpackage.ow3
        public int getColumnCount() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return 0;
            }
            if (this.g == qn4.b()) {
                return this.f.getColumnCount();
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return 0;
        }

        @Override // defpackage.ow3
        public String getColumnName(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return null;
            }
            if (this.g == qn4.b()) {
                return this.f.getColumnName(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return null;
        }

        @Override // defpackage.ow3
        public double getDouble(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return 0.0d;
            }
            if (this.g == qn4.b()) {
                return this.f.getDouble(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return 0.0d;
        }

        @Override // defpackage.ow3
        public long getLong(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return 0L;
            }
            if (this.g == qn4.b()) {
                return this.f.getLong(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return 0L;
        }

        @Override // defpackage.ow3
        public boolean isNull(int i) {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
                return false;
            }
            if (this.g == qn4.b()) {
                return this.f.isNull(i);
            }
            kw3.b(21, "Attempted to use statement on a different thread");
            mx3.a();
            return false;
        }

        @Override // defpackage.ow3
        public void reset() {
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.reset();
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }

        @Override // defpackage.ow3
        public void w(int i, String str) {
            str.getClass();
            if (this.h.e) {
                kw3.b(21, "Statement is recycled");
                mx3.a();
            } else if (this.g == qn4.b()) {
                this.f.w(i, str);
            } else {
                kw3.b(21, "Attempted to use statement on a different thread");
                mx3.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements cs4, ao3 {
        public b() {
        }

        @Override // defpackage.pf3
        public Object a(String str, Function1 function1, f30 f30Var) {
            return qf3.this.a(str, function1, f30Var);
        }

        @Override // defpackage.ao3
        public lw3 d() {
            return qf3.this.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public boolean b;

        public c(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public final int a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ds4.a.values().length];
            try {
                iArr[ds4.a.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ds4.a.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ds4.a.h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends g30 {
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public int j;

        public e(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return qf3.this.i(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends g30 {
        public boolean f;
        public Object g;
        public /* synthetic */ Object h;
        public int j;

        public f(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return qf3.this.j(false, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends g30 {
        public Object f;
        public Object g;
        public int h;
        public /* synthetic */ Object i;
        public int k;

        public g(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return qf3.this.o(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int k;

        public h(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return qf3.this.a(null, null, this);
        }
    }

    public qf3(m00 m00Var, c10 c10Var, boolean z) {
        m00Var.getClass();
        c10Var.getClass();
        this.a = m00Var;
        this.b = c10Var;
        this.c = z;
        this.d = new ia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(ds4.a r11, kotlin.jvm.functions.Function2 r12, defpackage.f30 r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof qf3.g
            if (r0 == 0) goto L13
            r0 = r13
            qf3$g r0 = (qf3.g) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            qf3$g r0 = new qf3$g
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.i
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.k
            r3 = 0
            r4 = 0
            r5 = 5
            r6 = 3
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L60
            if (r2 == r8) goto L57
            if (r2 == r7) goto L4f
            if (r2 == r6) goto L49
            r10 = 4
            if (r2 == r10) goto L49
            if (r2 == r5) goto L39
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r10)
            return r3
        L39:
            java.lang.Object r10 = r0.g
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.Object r11 = r0.f
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            defpackage.lt3.b(r13)     // Catch: android.database.SQLException -> L46
            goto Lae
        L46:
            r12 = move-exception
            goto La9
        L49:
            java.lang.Object r10 = r0.f
            defpackage.lt3.b(r13)
            return r10
        L4f:
            int r11 = r0.h
            defpackage.lt3.b(r13)     // Catch: java.lang.Throwable -> L55
            goto L85
        L55:
            r11 = move-exception
            goto L94
        L57:
            java.lang.Object r11 = r0.f
            r12 = r11
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            defpackage.lt3.b(r13)
            goto L72
        L60:
            defpackage.lt3.b(r13)
            if (r11 != 0) goto L67
            ds4$a r11 = ds4.a.f
        L67:
            r0.f = r12
            r0.k = r8
            java.lang.Object r11 = r10.i(r11, r0)
            if (r11 != r1) goto L72
            goto La2
        L72:
            qf3$b r11 = new qf3$b     // Catch: java.lang.Throwable -> L55
            r11.<init>()     // Catch: java.lang.Throwable -> L55
            r0.f = r3     // Catch: java.lang.Throwable -> L55
            r0.h = r8     // Catch: java.lang.Throwable -> L55
            r0.k = r7     // Catch: java.lang.Throwable -> L55
            java.lang.Object r13 = r12.invoke(r11, r0)     // Catch: java.lang.Throwable -> L55
            if (r13 != r1) goto L84
            goto La2
        L84:
            r11 = r8
        L85:
            if (r11 == 0) goto L88
            r4 = r8
        L88:
            r0.f = r13
            r0.k = r6
            java.lang.Object r10 = r10.j(r4, r0)
            if (r10 != r1) goto L93
            goto La2
        L93:
            return r13
        L94:
            throw r11     // Catch: java.lang.Throwable -> L95
        L95:
            r12 = move-exception
            r0.f = r11     // Catch: android.database.SQLException -> La5
            r0.g = r12     // Catch: android.database.SQLException -> La5
            r0.k = r5     // Catch: android.database.SQLException -> La5
            java.lang.Object r10 = r10.j(r4, r0)     // Catch: android.database.SQLException -> La5
            if (r10 != r1) goto La3
        La2:
            return r1
        La3:
            r10 = r12
            goto Lae
        La5:
            r10 = move-exception
            r9 = r12
            r12 = r10
            r10 = r9
        La9:
            if (r11 == 0) goto Laf
            defpackage.mv0.a(r11, r12)
        Lae:
            throw r10
        Laf:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qf3.o(ds4$a, kotlin.jvm.functions.Function2, f30):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.pf3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r7, kotlin.jvm.functions.Function1 r8, defpackage.f30 r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof qf3.h
            if (r0 == 0) goto L13
            r0 = r9
            qf3$h r0 = (qf3.h) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            qf3$h r0 = new qf3$h
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.i
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.h
            rw2 r7 = (defpackage.rw2) r7
            java.lang.Object r8 = r0.g
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r0 = r0.f
            java.lang.String r0 = (java.lang.String) r0
            defpackage.lt3.b(r9)
            r9 = r7
            r7 = r0
            goto L70
        L38:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r6)
            return r4
        L3e:
            defpackage.lt3.b(r9)
            boolean r9 = g(r6)
            r2 = 21
            if (r9 != 0) goto L9c
            g40 r9 = r0.getContext()
            m00 r5 = r6.k()
            g40$b r9 = r9.a(r5)
            l00 r9 = (defpackage.l00) r9
            if (r9 == 0) goto L93
            qf3 r9 = r9.b()
            if (r9 != r6) goto L93
            c10 r9 = r6.b
            r0.f = r7
            r0.g = r8
            r0.h = r9
            r0.k = r3
            java.lang.Object r0 = r9.h(r4, r0)
            if (r0 != r1) goto L70
            return r1
        L70:
            qf3$a r0 = new qf3$a     // Catch: java.lang.Throwable -> L86
            c10 r1 = r6.b     // Catch: java.lang.Throwable -> L86
            ow3 r7 = r1.a0(r7)     // Catch: java.lang.Throwable -> L86
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L86
            java.lang.Object r6 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L88
            defpackage.ne.a(r0, r4)     // Catch: java.lang.Throwable -> L86
            r9.c(r4)
            return r6
        L86:
            r6 = move-exception
            goto L8f
        L88:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L8a
        L8a:
            r7 = move-exception
            defpackage.ne.a(r0, r6)     // Catch: java.lang.Throwable -> L86
            throw r7     // Catch: java.lang.Throwable -> L86
        L8f:
            r9.c(r4)
            throw r6
        L93:
            java.lang.String r6 = "Attempted to use connection on a different coroutine"
            defpackage.kw3.b(r2, r6)
            defpackage.mx3.a()
            return r4
        L9c:
            java.lang.String r6 = "Connection is recycled"
            defpackage.kw3.b(r2, r6)
            defpackage.mx3.a()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qf3.a(java.lang.String, kotlin.jvm.functions.Function1, f30):java.lang.Object");
    }

    @Override // defpackage.ds4
    public Object b(ds4.a aVar, Function2 function2, f30 f30Var) {
        if (this.e) {
            kw3.b(21, "Connection is recycled");
            mx3.a();
            return null;
        }
        l00 l00Var = (l00) f30Var.getContext().a(k());
        if (l00Var != null && l00Var.b() == this) {
            return o(aVar, function2, f30Var);
        }
        kw3.b(21, "Attempted to use connection on a different coroutine");
        mx3.a();
        return null;
    }

    @Override // defpackage.ds4
    public Object c(f30 f30Var) {
        if (this.e) {
            kw3.b(21, "Connection is recycled");
            mx3.a();
            return null;
        }
        l00 l00Var = (l00) f30Var.getContext().a(k());
        if (l00Var != null && l00Var.b() == this) {
            return hl.a(!this.d.isEmpty() || this.b.f());
        }
        kw3.b(21, "Attempted to use connection on a different coroutine");
        mx3.a();
        return null;
    }

    @Override // defpackage.ao3
    public lw3 d() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(ds4.a r7, defpackage.f30 r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "SAVEPOINT '"
            boolean r1 = r8 instanceof qf3.e
            if (r1 == 0) goto L15
            r1 = r8
            qf3$e r1 = (qf3.e) r1
            int r2 = r1.j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.j = r2
            goto L1a
        L15:
            qf3$e r1 = new qf3$e
            r1.<init>(r8)
        L1a:
            java.lang.Object r8 = r1.h
            java.lang.Object r2 = defpackage.kl1.e()
            int r3 = r1.j
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3c
            if (r3 != r4) goto L36
            java.lang.Object r7 = r1.g
            rw2 r7 = (defpackage.rw2) r7
            java.lang.Object r1 = r1.f
            ds4$a r1 = (ds4.a) r1
            defpackage.lt3.b(r8)
            r8 = r7
            r7 = r1
            goto L4e
        L36:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r6)
            return r5
        L3c:
            defpackage.lt3.b(r8)
            c10 r8 = r6.b
            r1.f = r7
            r1.g = r8
            r1.j = r4
            java.lang.Object r1 = r8.h(r5, r1)
            if (r1 != r2) goto L4e
            return r2
        L4e:
            ia r1 = r6.d     // Catch: java.lang.Throwable -> L74
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L74
            ia r2 = r6.d     // Catch: java.lang.Throwable -> L74
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L8c
            int[] r0 = qf3.d.a     // Catch: java.lang.Throwable -> L74
            int r7 = r7.ordinal()     // Catch: java.lang.Throwable -> L74
            r7 = r0[r7]     // Catch: java.lang.Throwable -> L74
            if (r7 == r4) goto L84
            r0 = 2
            if (r7 == r0) goto L7c
            r0 = 3
            if (r7 != r0) goto L76
            c10 r7 = r6.b     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "BEGIN EXCLUSIVE TRANSACTION"
            defpackage.kw3.a(r7, r0)     // Catch: java.lang.Throwable -> L74
            goto La2
        L74:
            r6 = move-exception
            goto Lb3
        L76:
            j33 r6 = new j33     // Catch: java.lang.Throwable -> L74
            r6.<init>()     // Catch: java.lang.Throwable -> L74
            throw r6     // Catch: java.lang.Throwable -> L74
        L7c:
            c10 r7 = r6.b     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "BEGIN IMMEDIATE TRANSACTION"
            defpackage.kw3.a(r7, r0)     // Catch: java.lang.Throwable -> L74
            goto La2
        L84:
            c10 r7 = r6.b     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = "BEGIN DEFERRED TRANSACTION"
            defpackage.kw3.a(r7, r0)     // Catch: java.lang.Throwable -> L74
            goto La2
        L8c:
            c10 r7 = r6.b     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L74
            r2.append(r1)     // Catch: java.lang.Throwable -> L74
            r0 = 39
            r2.append(r0)     // Catch: java.lang.Throwable -> L74
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L74
            defpackage.kw3.a(r7, r0)     // Catch: java.lang.Throwable -> L74
        La2:
            ia r6 = r6.d     // Catch: java.lang.Throwable -> L74
            qf3$c r7 = new qf3$c     // Catch: java.lang.Throwable -> L74
            r0 = 0
            r7.<init>(r1, r0)     // Catch: java.lang.Throwable -> L74
            r6.addLast(r7)     // Catch: java.lang.Throwable -> L74
            fw4 r6 = defpackage.fw4.a     // Catch: java.lang.Throwable -> L74
            r8.c(r5)
            return r6
        Lb3:
            r8.c(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qf3.i(ds4$a, f30):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(boolean r8, defpackage.f30 r9) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            java.lang.String r1 = "RELEASE SAVEPOINT '"
            boolean r2 = r9 instanceof qf3.f
            if (r2 == 0) goto L17
            r2 = r9
            qf3$f r2 = (qf3.f) r2
            int r3 = r2.j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.j = r3
            goto L1c
        L17:
            qf3$f r2 = new qf3$f
            r2.<init>(r9)
        L1c:
            java.lang.Object r9 = r2.h
            java.lang.Object r3 = defpackage.kl1.e()
            int r4 = r2.j
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L34
            boolean r8 = r2.f
            java.lang.Object r2 = r2.g
            rw2 r2 = (defpackage.rw2) r2
            defpackage.lt3.b(r9)
            goto L4d
        L34:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r7)
            return r6
        L3a:
            defpackage.lt3.b(r9)
            c10 r9 = r7.b
            r2.g = r9
            r2.f = r8
            r2.j = r5
            java.lang.Object r2 = r9.h(r6, r2)
            if (r2 != r3) goto L4c
            return r3
        L4c:
            r2 = r9
        L4d:
            ia r9 = r7.d     // Catch: java.lang.Throwable -> L77
            boolean r9 = r9.isEmpty()     // Catch: java.lang.Throwable -> L77
            if (r9 != 0) goto Lbc
            ia r9 = r7.d     // Catch: java.lang.Throwable -> L77
            java.lang.Object r9 = defpackage.tw.z(r9)     // Catch: java.lang.Throwable -> L77
            qf3$c r9 = (qf3.c) r9     // Catch: java.lang.Throwable -> L77
            r3 = 39
            if (r8 == 0) goto L90
            boolean r8 = r9.b()     // Catch: java.lang.Throwable -> L77
            if (r8 != 0) goto L90
            ia r8 = r7.d     // Catch: java.lang.Throwable -> L77
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Throwable -> L77
            c10 r7 = r7.b
            if (r8 == 0) goto L79
            java.lang.String r8 = "END TRANSACTION"
            defpackage.kw3.a(r7, r8)     // Catch: java.lang.Throwable -> L77
            goto Lb6
        L77:
            r7 = move-exception
            goto Lc4
        L79:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L77
            int r9 = r9.a()     // Catch: java.lang.Throwable -> L77
            r8.append(r9)     // Catch: java.lang.Throwable -> L77
            r8.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L77
            defpackage.kw3.a(r7, r8)     // Catch: java.lang.Throwable -> L77
            goto Lb6
        L90:
            ia r8 = r7.d     // Catch: java.lang.Throwable -> L77
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Throwable -> L77
            c10 r7 = r7.b
            if (r8 == 0) goto La0
            java.lang.String r8 = "ROLLBACK TRANSACTION"
            defpackage.kw3.a(r7, r8)     // Catch: java.lang.Throwable -> L77
            goto Lb6
        La0:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L77
            int r9 = r9.a()     // Catch: java.lang.Throwable -> L77
            r8.append(r9)     // Catch: java.lang.Throwable -> L77
            r8.append(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L77
            defpackage.kw3.a(r7, r8)     // Catch: java.lang.Throwable -> L77
        Lb6:
            fw4 r7 = defpackage.fw4.a     // Catch: java.lang.Throwable -> L77
            r2.c(r6)
            return r7
        Lbc:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L77
            java.lang.String r8 = "Not in a transaction"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L77
            throw r7     // Catch: java.lang.Throwable -> L77
        Lc4:
            r2.c(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qf3.j(boolean, f30):java.lang.Object");
    }

    public final m00 k() {
        return this.a;
    }

    public final c10 l() {
        return this.b;
    }

    public final boolean m() {
        return this.c;
    }

    public final void n() throws Exception {
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.b.f()) {
            kw3.a(this.b, "ROLLBACK TRANSACTION");
        }
    }
}
