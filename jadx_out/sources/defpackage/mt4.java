package defpackage;

import defpackage.v43;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mt4 {
    public static final a l = new a(null);
    public static final String[] m = {"INSERT", "UPDATE", "DELETE"};
    public final bu3 a;
    public final Map b;
    public final Map c;
    public final boolean d;
    public final Function1 e;
    public final Map f;
    public final String[] g;
    public final v43 h;
    public final w43 i;
    public final AtomicBoolean j;
    public Function0 k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends g30 {
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        public b(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return mt4.this.h(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends g30 {
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        public c(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return mt4.this.j(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends oj4 implements Function2 {
            public int f;
            public /* synthetic */ Object g;
            public final /* synthetic */ mt4 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(mt4 mt4Var, f30 f30Var) {
                super(2, f30Var);
                this.h = mt4Var;
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                a aVar = new a(this.h, f30Var);
                aVar.g = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(cs4 cs4Var, f30 f30Var) {
                return ((a) create(cs4Var, f30Var)).invokeSuspend(fw4.a);
            }

            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) throws Throwable {
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
                cs4 cs4Var = (cs4) this.g;
                mt4 mt4Var = this.h;
                this.f = 1;
                Object objH = mt4Var.h(cs4Var, this);
                return objH == objE ? objE : objH;
            }
        }

        public d(f30 f30Var) {
            super(2, f30Var);
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            d dVar = mt4.this.new d(f30Var);
            dVar.g = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ds4 ds4Var, f30 f30Var) {
            return ((d) create(ds4Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        
            if (r7 == r0) goto L20;
         */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = defpackage.kl1.e()
                int r1 = r6.f
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L21
                if (r1 == r4) goto L19
                if (r1 != r3) goto L13
                defpackage.lt3.b(r7)     // Catch: android.database.SQLException -> L58
                goto L55
            L13:
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                defpackage.e04.a(r6)
                return r2
            L19:
                java.lang.Object r1 = r6.g
                ds4 r1 = (defpackage.ds4) r1
                defpackage.lt3.b(r7)
                goto L34
            L21:
                defpackage.lt3.b(r7)
                java.lang.Object r7 = r6.g
                r1 = r7
                ds4 r1 = (defpackage.ds4) r1
                r6.g = r1
                r6.f = r4
                java.lang.Object r7 = r1.c(r6)
                if (r7 != r0) goto L34
                goto L54
            L34:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L41
                java.util.Set r6 = defpackage.o24.d()
                return r6
            L41:
                ds4$a r7 = ds4.a.g     // Catch: android.database.SQLException -> L58
                mt4$d$a r4 = new mt4$d$a     // Catch: android.database.SQLException -> L58
                mt4 r5 = defpackage.mt4.this     // Catch: android.database.SQLException -> L58
                r4.<init>(r5, r2)     // Catch: android.database.SQLException -> L58
                r6.g = r2     // Catch: android.database.SQLException -> L58
                r6.f = r3     // Catch: android.database.SQLException -> L58
                java.lang.Object r7 = r1.b(r7, r4, r6)     // Catch: android.database.SQLException -> L58
                if (r7 != r0) goto L55
            L54:
                return r0
            L55:
                java.util.Set r7 = (java.util.Set) r7     // Catch: android.database.SQLException -> L58
                return r7
            L58:
                java.util.Set r6 = defpackage.o24.d()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: mt4.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends oj4 implements Function2 {
        public int f;
        public final /* synthetic */ Function0 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Function0 function0, f30 f30Var) {
            super(2, f30Var);
            this.h = function0;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return mt4.this.new e(this.h, f30Var);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((e) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            try {
                if (i == 0) {
                    lt3.b(obj);
                    mt4 mt4Var = mt4.this;
                    this.f = 1;
                    obj = mt4Var.j(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    lt3.b(obj);
                }
                this.h.invoke();
                return fw4.a;
            } catch (Throwable th) {
                this.h.invoke();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public int i;
        public int j;
        public int k;
        public /* synthetic */ Object l;
        public int n;

        public f(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.l = obj;
            this.n |= Integer.MIN_VALUE;
            return mt4.this.q(null, 0, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public int i;
        public int j;
        public /* synthetic */ Object k;
        public int m;

        public g(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.m |= Integer.MIN_VALUE;
            return mt4.this.r(null, 0, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends g30 {
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        public h(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return mt4.this.s(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class i extends oj4 implements Function2 {
        public Object f;
        public int g;
        public /* synthetic */ Object h;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends oj4 implements Function2 {
            public Object f;
            public Object g;
            public Object h;
            public int i;
            public int j;
            public int k;
            public int l;
            public final /* synthetic */ v43.a[] m;
            public final /* synthetic */ mt4 n;
            public final /* synthetic */ ds4 o;

            /* JADX INFO: renamed from: mt4$i$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final /* synthetic */ class C0102a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[v43.a.values().length];
                    try {
                        iArr[v43.a.f.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[v43.a.g.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[v43.a.h.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(v43.a[] aVarArr, mt4 mt4Var, ds4 ds4Var, f30 f30Var) {
                super(2, f30Var);
                this.m = aVarArr;
                this.n = mt4Var;
                this.o = ds4Var;
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                return new a(this.m, this.n, this.o, f30Var);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(cs4 cs4Var, f30 f30Var) {
                return ((a) create(cs4Var, f30Var)).invokeSuspend(fw4.a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
            
                if (r7.q(r12, r6, r11) == r0) goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
            
                r6 = r12;
                r5 = r9;
             */
            /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0085 -> B:27:0x0086). Please report as a decompilation issue!!! */
            @Override // defpackage.hh
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
                /*
                    r11 = this;
                    java.lang.Object r0 = defpackage.kl1.e()
                    int r1 = r11.l
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L2b
                    if (r1 == r3) goto Le
                    if (r1 != r2) goto L24
                Le:
                    int r1 = r11.k
                    int r4 = r11.j
                    int r5 = r11.i
                    java.lang.Object r6 = r11.h
                    ds4 r6 = (defpackage.ds4) r6
                    java.lang.Object r7 = r11.g
                    mt4 r7 = (defpackage.mt4) r7
                    java.lang.Object r8 = r11.f
                    v43$a[] r8 = (v43.a[]) r8
                    defpackage.lt3.b(r12)
                    goto L67
                L24:
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    defpackage.e04.a(r11)
                    r11 = 0
                    return r11
                L2b:
                    defpackage.lt3.b(r12)
                    v43$a[] r12 = r11.m
                    mt4 r1 = r11.n
                    ds4 r4 = r11.o
                    int r5 = r12.length
                    r6 = 0
                    r8 = r12
                    r7 = r1
                    r12 = r4
                    r1 = r5
                    r4 = r6
                L3b:
                    if (r4 >= r1) goto L88
                    r5 = r8[r4]
                    int r9 = r6 + 1
                    int[] r10 = mt4.i.a.C0102a.a
                    int r5 = r5.ordinal()
                    r5 = r10[r5]
                    if (r5 == r3) goto L85
                    if (r5 == r2) goto L70
                    r10 = 3
                    if (r5 != r10) goto L6a
                    r11.f = r8
                    r11.g = r7
                    r11.h = r12
                    r11.i = r9
                    r11.j = r4
                    r11.k = r1
                    r11.l = r2
                    java.lang.Object r5 = defpackage.mt4.g(r7, r12, r6, r11)
                    if (r5 != r0) goto L65
                    goto L84
                L65:
                    r6 = r12
                    r5 = r9
                L67:
                    r12 = r6
                    r6 = r5
                    goto L86
                L6a:
                    j33 r11 = new j33
                    r11.<init>()
                    throw r11
                L70:
                    r11.f = r8
                    r11.g = r7
                    r11.h = r12
                    r11.i = r9
                    r11.j = r4
                    r11.k = r1
                    r11.l = r3
                    java.lang.Object r5 = defpackage.mt4.f(r7, r12, r6, r11)
                    if (r5 != r0) goto L65
                L84:
                    return r0
                L85:
                    r6 = r9
                L86:
                    int r4 = r4 + r3
                    goto L3b
                L88:
                    fw4 r11 = defpackage.fw4.a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: mt4.i.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public i(f30 f30Var) {
            super(2, f30Var);
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            i iVar = mt4.this.new i(f30Var);
            iVar.h = obj;
            return iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ds4 ds4Var, f30 f30Var) {
            return ((i) create(ds4Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 243
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: mt4.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public mt4(bu3 bu3Var, Map map, Map map2, String[] strArr, boolean z, Function1 function1) {
        String lowerCase;
        bu3Var.getClass();
        map.getClass();
        map2.getClass();
        strArr.getClass();
        function1.getClass();
        this.a = bu3Var;
        this.b = map;
        this.c = map2;
        this.d = z;
        this.e = function1;
        this.j = new AtomicBoolean(false);
        this.k = new Function0() { // from class: lt4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(mt4.b());
            }
        };
        this.f = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            this.f.put(lowerCase2, Integer.valueOf(i2));
            String str2 = (String) this.b.get(strArr[i2]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i2] = lowerCase2;
        }
        this.g = strArr2;
        for (Map.Entry entry : this.b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            lowerCase3.getClass();
            if (this.f.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                lowerCase4.getClass();
                Map map3 = this.f;
                map3.put(lowerCase4, y42.i(map3, lowerCase3));
            }
        }
        this.h = new v43(this.g.length);
        this.i = new w43(this.g.length);
    }

    public static Set a(ow3 ow3Var) {
        ow3Var.getClass();
        Set setB = n24.b();
        while (ow3Var.Y()) {
            setB.add(Integer.valueOf((int) ow3Var.getLong(0)));
        }
        return n24.a(setB);
    }

    public static boolean b() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(defpackage.pf3 r5, defpackage.f30 r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof mt4.b
            if (r0 == 0) goto L13
            r0 = r6
            mt4$b r0 = (mt4.b) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            mt4$b r0 = new mt4$b
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.g
            java.lang.Object r6 = defpackage.kl1.e()
            int r1 = r0.i
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3f
            if (r1 == r3) goto L37
            if (r1 != r2) goto L30
            java.lang.Object r5 = r0.f
            java.util.Set r5 = (java.util.Set) r5
            defpackage.lt3.b(r4)
            return r5
        L30:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r4)
            r4 = 0
            return r4
        L37:
            java.lang.Object r5 = r0.f
            pf3 r5 = (defpackage.pf3) r5
            defpackage.lt3.b(r4)
            goto L54
        L3f:
            defpackage.lt3.b(r4)
            kt4 r4 = new kt4
            r4.<init>()
            r0.f = r5
            r0.i = r3
            java.lang.String r1 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r4 = r5.a(r1, r4, r0)
            if (r4 != r6) goto L54
            goto L68
        L54:
            java.util.Set r4 = (java.util.Set) r4
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L69
            r0.f = r4
            r0.i = r2
            java.lang.String r1 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r5 = defpackage.fs4.b(r5, r1, r0)
            if (r5 != r6) goto L69
        L68:
            return r6
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt4.h(pf3, f30):java.lang.Object");
    }

    public final void i(lw3 lw3Var) throws Exception {
        lw3Var.getClass();
        ow3 ow3VarA0 = lw3Var.a0("PRAGMA query_only");
        try {
            ow3VarA0.Y();
            boolean zS = ow3VarA0.s(0);
            ne.a(ow3VarA0, null);
            if (zS) {
                return;
            }
            kw3.a(lw3Var, "PRAGMA temp_store = MEMORY");
            kw3.a(lw3Var, "PRAGMA recursive_triggers = 1");
            kw3.a(lw3Var, "DROP TABLE IF EXISTS room_table_modification_log");
            if (this.d) {
                kw3.a(lw3Var, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            } else {
                kw3.a(lw3Var, sg4.G("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", "", false, 4, null));
            }
            this.h.h();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ne.a(ow3VarA0, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(defpackage.f30 r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof mt4.c
            if (r0 == 0) goto L13
            r0 = r9
            mt4$c r0 = (mt4.c) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            mt4$c r0 = new mt4$c
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.g
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L30
            java.lang.Object r0 = r0.f
            av r0 = (defpackage.av) r0
            defpackage.lt3.b(r9)     // Catch: java.lang.Throwable -> L2e
            goto L84
        L2e:
            r8 = move-exception
            goto L9a
        L30:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r8)
            return r3
        L36:
            defpackage.lt3.b(r9)
            bu3 r9 = r8.a
            av r9 = r9.n()
            boolean r2 = r9.a()
            if (r2 == 0) goto L9e
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.j     // Catch: java.lang.Throwable -> L56
            r5 = 0
            boolean r2 = r2.compareAndSet(r4, r5)     // Catch: java.lang.Throwable -> L56
            if (r2 != 0) goto L59
            java.util.Set r8 = defpackage.o24.d()     // Catch: java.lang.Throwable -> L56
            r9.c()
            return r8
        L56:
            r8 = move-exception
            r0 = r9
            goto L9a
        L59:
            kotlin.jvm.functions.Function0 r2 = r8.k     // Catch: java.lang.Throwable -> L56
            java.lang.Object r2 = r2.invoke()     // Catch: java.lang.Throwable -> L56
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L56
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L56
            if (r2 != 0) goto L6f
            java.util.Set r8 = defpackage.o24.d()     // Catch: java.lang.Throwable -> L56
            r9.c()
            return r8
        L6f:
            bu3 r2 = r8.a     // Catch: java.lang.Throwable -> L56
            mt4$d r6 = new mt4$d     // Catch: java.lang.Throwable -> L56
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L56
            r0.f = r9     // Catch: java.lang.Throwable -> L56
            r0.i = r4     // Catch: java.lang.Throwable -> L56
            java.lang.Object r0 = r2.I(r5, r6, r0)     // Catch: java.lang.Throwable -> L56
            if (r0 != r1) goto L81
            return r1
        L81:
            r7 = r0
            r0 = r9
            r9 = r7
        L84:
            java.util.Set r9 = (java.util.Set) r9     // Catch: java.lang.Throwable -> L2e
            boolean r1 = r9.isEmpty()     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L96
            w43 r1 = r8.i     // Catch: java.lang.Throwable -> L2e
            r1.a(r9)     // Catch: java.lang.Throwable -> L2e
            kotlin.jvm.functions.Function1 r8 = r8.e     // Catch: java.lang.Throwable -> L2e
            r8.invoke(r9)     // Catch: java.lang.Throwable -> L2e
        L96:
            r0.c()
            return r9
        L9a:
            r0.c()
            throw r8
        L9e:
            java.util.Set r8 = defpackage.o24.d()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt4.j(f30):java.lang.Object");
    }

    public final boolean k(int[] iArr) {
        iArr.getClass();
        return this.h.i(iArr);
    }

    public final boolean l(int[] iArr) {
        iArr.getClass();
        return this.h.j(iArr);
    }

    public final void m(Function0 function0, Function0 function02) {
        function0.getClass();
        function02.getClass();
        if (this.j.compareAndSet(false, true)) {
            function0.invoke();
            dm.b(this.a.o(), new s40("Room Invalidation Tracker Refresh"), null, new e(function02, null), 2, null);
        }
    }

    public final void n() {
        this.h.k();
    }

    public final String[] o(String[] strArr) {
        Set setB = n24.b();
        for (String str : strArr) {
            Map map = this.c;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Set set = (Set) map.get(lowerCase);
            if (set != null) {
                setB.addAll(set);
            } else {
                setB.add(str);
            }
        }
        return (String[]) n24.a(setB).toArray(new String[0]);
    }

    public final void p(Function0 function0) {
        function0.getClass();
        this.k = function0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (defpackage.fs4.b(r13, r15, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d9, code lost:
    
        if (defpackage.fs4.b(r7, r15, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00db, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d9 -> B:28:0x00dc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(defpackage.pf3 r13, int r14, defpackage.f30 r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt4.q(pf3, int, f30):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0080 -> B:19:0x0083). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(defpackage.pf3 r9, int r10, defpackage.f30 r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof mt4.g
            if (r0 == 0) goto L13
            r0 = r11
            mt4$g r0 = (mt4.g) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            mt4$g r0 = new mt4$g
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.k
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3b
            int r8 = r0.j
            int r9 = r0.i
            java.lang.Object r10 = r0.h
            java.lang.String[] r10 = (java.lang.String[]) r10
            java.lang.Object r2 = r0.g
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.f
            pf3 r4 = (defpackage.pf3) r4
            defpackage.lt3.b(r11)
            r11 = r10
            r10 = r4
            goto L83
        L3b:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r8)
            r8 = 0
            return r8
        L42:
            defpackage.lt3.b(r11)
            java.lang.String[] r8 = r8.g
            r8 = r8[r10]
            java.lang.String[] r10 = defpackage.mt4.m
            int r11 = r10.length
            r2 = 0
            r7 = r2
            r2 = r8
            r8 = r11
            r11 = r10
            r10 = r9
            r9 = r7
        L53:
            if (r9 >= r8) goto L85
            r4 = r11[r9]
            mt4$a r5 = defpackage.mt4.l
            java.lang.String r4 = mt4.a.a(r5, r2, r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "DROP TRIGGER IF EXISTS `"
            r5.<init>(r6)
            r5.append(r4)
            r4 = 96
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r0.f = r10
            r0.g = r2
            r0.h = r11
            r0.i = r9
            r0.j = r8
            r0.m = r3
            java.lang.Object r4 = defpackage.fs4.b(r10, r4, r0)
            if (r4 != r1) goto L83
            return r1
        L83:
            int r9 = r9 + r3
            goto L53
        L85:
            fw4 r8 = defpackage.fw4.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt4.r(pf3, int, f30):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(defpackage.f30 r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof mt4.h
            if (r0 == 0) goto L13
            r0 = r8
            mt4$h r0 = (mt4.h) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            mt4$h r0 = new mt4$h
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.g
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L30
            java.lang.Object r7 = r0.f
            av r7 = (defpackage.av) r7
            defpackage.lt3.b(r8)     // Catch: java.lang.Throwable -> L2e
            goto L59
        L2e:
            r8 = move-exception
            goto L61
        L30:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r7)
            return r3
        L36:
            defpackage.lt3.b(r8)
            bu3 r8 = r7.a
            av r8 = r8.n()
            boolean r2 = r8.a()
            if (r2 == 0) goto L65
            bu3 r2 = r7.a     // Catch: java.lang.Throwable -> L5d
            mt4$i r5 = new mt4$i     // Catch: java.lang.Throwable -> L5d
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L5d
            r0.f = r8     // Catch: java.lang.Throwable -> L5d
            r0.i = r4     // Catch: java.lang.Throwable -> L5d
            r7 = 0
            java.lang.Object r7 = r2.I(r7, r5, r0)     // Catch: java.lang.Throwable -> L5d
            if (r7 != r1) goto L58
            return r1
        L58:
            r7 = r8
        L59:
            r7.c()
            goto L65
        L5d:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L61:
            r7.c()
            throw r8
        L65:
            fw4 r7 = defpackage.fw4.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt4.s(f30):java.lang.Object");
    }

    public final i73 t(String[] strArr) {
        strArr.getClass();
        String[] strArrO = o(strArr);
        int length = strArrO.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArrO[i2];
            Map map = this.f;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Integer num = (Integer) map.get(lowerCase);
            if (num == null) {
                jl.a("There is no table with name ".concat(str));
                return null;
            }
            iArr[i2] = num.intValue();
        }
        return fu4.a(strArrO, iArr);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final String b(String str, String str2) {
            return "room_table_modification_trigger_" + str + '_' + str2;
        }

        public a() {
        }
    }
}
