package defpackage;

import defpackage.ds4;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class x83 implements ds4, ao3 {
    public final Function2 a;
    public final lw3 b;
    public AtomicInteger c;
    public ds4.a d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements cs4, ao3 {
        public a() {
        }

        @Override // defpackage.pf3
        public Object a(String str, Function1 function1, f30 f30Var) {
            return x83.this.a(str, function1, f30Var);
        }

        @Override // defpackage.ao3
        public lw3 d() {
            return x83.this.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class b {
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
    public static final class c extends g30 {
        public int f;
        public /* synthetic */ Object g;
        public int i;

        public c(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return x83.this.g(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends g30 {
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public int j;

        public d(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return x83.this.a(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends oj4 implements Function1 {
        public int f;
        public final /* synthetic */ String h;
        public final /* synthetic */ Function1 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Function1 function1, f30 f30Var) {
            super(1, f30Var);
            this.h = str;
            this.i = function1;
        }

        @Override // defpackage.hh
        public final f30 create(f30 f30Var) {
            return x83.this.new e(this.h, this.i, f30Var);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f30 f30Var) {
            return ((e) create(f30Var)).invokeSuspend(fw4.a);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Exception {
            kl1.e();
            if (this.f != 0) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
            ow3 ow3VarA0 = x83.this.f().a0(this.h);
            try {
                Object objInvoke = this.i.invoke(ow3VarA0);
                ne.a(ow3VarA0, null);
                return objInvoke;
            } finally {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends oj4 implements Function1 {
        public int f;
        public final /* synthetic */ ds4.a h;
        public final /* synthetic */ Function2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ds4.a aVar, Function2 function2, f30 f30Var) {
            super(1, f30Var);
            this.h = aVar;
            this.i = function2;
        }

        @Override // defpackage.hh
        public final f30 create(f30 f30Var) {
            return x83.this.new f(this.h, this.i, f30Var);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f30 f30Var) {
            return ((f) create(f30Var)).invokeSuspend(fw4.a);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Exception {
            Object objE = kl1.e();
            int i = this.f;
            if (i != 0) {
                if (i == 1) {
                    lt3.b(obj);
                    return obj;
                }
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
            x83 x83Var = x83.this;
            ds4.a aVar = this.h;
            Function2 function2 = this.i;
            this.f = 1;
            Object objG = x83Var.g(aVar, function2, this);
            return objG == objE ? objE : objG;
        }
    }

    public x83(Function2 function2, lw3 lw3Var) {
        lw3Var.getClass();
        this.a = function2;
        this.b = lw3Var;
        this.c = new AtomicInteger(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.pf3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r7, kotlin.jvm.functions.Function1 r8, defpackage.f30 r9) throws java.lang.Exception {
        /*
            r6 = this;
            boolean r0 = r9 instanceof x83.d
            if (r0 == 0) goto L13
            r0 = r9
            x83$d r0 = (x83.d) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            x83$d r0 = new x83$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.h
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.j
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L40
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2d
            defpackage.lt3.b(r9)
            return r9
        L2d:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r6)
            return r5
        L33:
            java.lang.Object r7 = r0.g
            r8 = r7
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r7 = r0.f
            java.lang.String r7 = (java.lang.String) r7
            defpackage.lt3.b(r9)
            goto L50
        L40:
            defpackage.lt3.b(r9)
            r0.f = r7
            r0.g = r8
            r0.j = r4
            java.lang.Object r9 = r6.c(r0)
            if (r9 != r1) goto L50
            goto L6d
        L50:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L6f
            kotlin.jvm.functions.Function2 r9 = r6.a
            if (r9 == 0) goto L6f
            x83$e r2 = new x83$e
            r2.<init>(r7, r8, r5)
            r0.f = r5
            r0.g = r5
            r0.j = r3
            java.lang.Object r6 = r9.invoke(r2, r0)
            if (r6 != r1) goto L6e
        L6d:
            return r1
        L6e:
            return r6
        L6f:
            lw3 r6 = r6.b
            ow3 r6 = r6.a0(r7)
            java.lang.Object r7 = r8.invoke(r6)     // Catch: java.lang.Throwable -> L7d
            defpackage.ne.a(r6, r5)
            return r7
        L7d:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L7f
        L7f:
            r8 = move-exception
            defpackage.ne.a(r6, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x83.a(java.lang.String, kotlin.jvm.functions.Function1, f30):java.lang.Object");
    }

    @Override // defpackage.ds4
    public Object b(ds4.a aVar, Function2 function2, f30 f30Var) {
        Function2 function22 = this.a;
        if (function22 == null) {
            return g(aVar, function2, f30Var);
        }
        Object objInvoke = function22.invoke(new f(aVar, function2, null), f30Var);
        kl1.e();
        return objInvoke;
    }

    @Override // defpackage.ds4
    public Object c(f30 f30Var) {
        return hl.a(this.d != null || this.b.f());
    }

    @Override // defpackage.ao3
    public lw3 d() {
        return this.b;
    }

    public final lw3 f() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ds4.a r7, kotlin.jvm.functions.Function2 r8, defpackage.f30 r9) throws java.lang.Exception {
        /*
            r6 = this;
            boolean r0 = r9 instanceof x83.c
            if (r0 == 0) goto L13
            r0 = r9
            x83$c r0 = (x83.c) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            x83$c r0 = new x83$c
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.g
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.i
            java.lang.String r3 = "ROLLBACK TRANSACTION"
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L36
            if (r2 != r5) goto L30
            int r5 = r0.f
            defpackage.lt3.b(r9)     // Catch: java.lang.Throwable -> L2e
            goto L80
        L2e:
            r7 = move-exception
            goto L98
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r6)
            return r4
        L36:
            defpackage.lt3.b(r9)
            int[] r9 = x83.b.a
            int r2 = r7.ordinal()
            r9 = r9[r2]
            if (r9 == r5) goto L5f
            r2 = 2
            if (r9 == r2) goto L57
            r2 = 3
            if (r9 != r2) goto L51
            lw3 r9 = r6.b
            java.lang.String r2 = "BEGIN EXCLUSIVE TRANSACTION"
            defpackage.kw3.a(r9, r2)
            goto L66
        L51:
            j33 r6 = new j33
            r6.<init>()
            throw r6
        L57:
            lw3 r9 = r6.b
            java.lang.String r2 = "BEGIN IMMEDIATE TRANSACTION"
            defpackage.kw3.a(r9, r2)
            goto L66
        L5f:
            lw3 r9 = r6.b
            java.lang.String r2 = "BEGIN DEFERRED TRANSACTION"
            defpackage.kw3.a(r9, r2)
        L66:
            java.util.concurrent.atomic.AtomicInteger r9 = r6.c
            int r9 = r9.incrementAndGet()
            if (r9 <= 0) goto L70
            r6.d = r7
        L70:
            x83$a r7 = new x83$a     // Catch: java.lang.Throwable -> L2e
            r7.<init>()     // Catch: java.lang.Throwable -> L2e
            r0.f = r5     // Catch: java.lang.Throwable -> L2e
            r0.i = r5     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r9 = r8.invoke(r7, r0)     // Catch: java.lang.Throwable -> L2e
            if (r9 != r1) goto L80
            return r1
        L80:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.c
            int r7 = r7.decrementAndGet()
            if (r7 != 0) goto L8a
            r6.d = r4
        L8a:
            lw3 r6 = r6.b
            if (r5 == 0) goto L94
            java.lang.String r7 = "END TRANSACTION"
            defpackage.kw3.a(r6, r7)
            return r9
        L94:
            defpackage.kw3.a(r6, r3)
            return r9
        L98:
            throw r7     // Catch: java.lang.Throwable -> L99
        L99:
            r8 = move-exception
            java.util.concurrent.atomic.AtomicInteger r9 = r6.c     // Catch: android.database.SQLException -> La5
            int r9 = r9.decrementAndGet()     // Catch: android.database.SQLException -> La5
            if (r9 != 0) goto La7
            r6.d = r4     // Catch: android.database.SQLException -> La5
            goto La7
        La5:
            r6 = move-exception
            goto Lad
        La7:
            lw3 r6 = r6.b     // Catch: android.database.SQLException -> La5
            defpackage.kw3.a(r6, r3)     // Catch: android.database.SQLException -> La5
            goto Lb0
        Lad:
            defpackage.mv0.a(r7, r6)
        Lb0:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x83.g(ds4$a, kotlin.jvm.functions.Function2, f30):java.lang.Object");
    }
}
