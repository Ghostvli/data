package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import defpackage.g40;
import defpackage.jj4;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bu3 {
    public static final c n = new c(null);
    public ma0 a;
    public u40 b;
    public g40 c;
    public Executor d;
    public Executor e;
    public zt3 f;
    public androidx.room.c g;
    public boolean i;
    public pe j;
    public final av h = new av(new g(this));
    public final ThreadLocal k = new ThreadLocal();
    public final Map l = new LinkedHashMap();
    public boolean m = true;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public boolean A;
        public final hp1 a;
        public final Context b;
        public final String c;
        public final Function0 d;
        public final List e;
        public final List f;
        public Executor g;
        public Executor h;
        public jj4.c i;
        public boolean j;
        public d k;
        public Intent l;
        public long m;
        public TimeUnit n;
        public final e o;
        public Set p;
        public final Set q;
        public final List r;
        public boolean s;
        public boolean t;
        public boolean u;
        public String v;
        public File w;
        public Callable x;
        public nw3 y;
        public g40 z;

        public a(Context context, Class cls, String str) {
            context.getClass();
            cls.getClass();
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.k = d.f;
            this.m = -1L;
            this.o = new e();
            this.p = new LinkedHashSet();
            this.q = new LinkedHashSet();
            this.r = new ArrayList();
            this.s = true;
            this.A = true;
            this.a = dp1.c(cls);
            this.b = context;
            this.c = str;
            this.d = null;
        }

        public a a(it2... it2VarArr) {
            it2VarArr.getClass();
            for (it2 it2Var : it2VarArr) {
                this.q.add(Integer.valueOf(it2Var.a));
                this.q.add(Integer.valueOf(it2Var.b));
            }
            this.o.b((it2[]) Arrays.copyOf(it2VarArr, it2VarArr.length));
            return this;
        }

        public a b() {
            this.j = true;
            return this;
        }

        public bu3 c() {
            jj4.c cg3Var;
            jj4.c cVar;
            bu3 bu3Var;
            Executor executor = this.g;
            if (executor == null && this.h == null) {
                Executor executorF = ca.f();
                this.h = executorF;
                this.g = executorF;
            } else if (executor != null && this.h == null) {
                this.h = executor;
            } else if (executor == null) {
                this.g = this.h;
            }
            cu3.c(this.q, this.p);
            nw3 nw3Var = this.y;
            if (nw3Var == null && this.i == null) {
                cg3Var = new i81();
            } else {
                jj4.c cVar2 = this.i;
                if (nw3Var == null) {
                    cg3Var = cVar2;
                } else {
                    if (cVar2 != null) {
                        jl.a("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
                        return null;
                    }
                    cg3Var = null;
                }
            }
            boolean z = this.m > 0;
            boolean z2 = (this.v == null && this.w == null && this.x == null) ? false : true;
            if (cg3Var != null) {
                if (z) {
                    if (this.c == null) {
                        jl.a("Cannot create auto-closing database for an in-memory database.");
                        return null;
                    }
                    long j = this.m;
                    TimeUnit timeUnit = this.n;
                    if (timeUnit == null) {
                        jl.a("Required value was null.");
                        return null;
                    }
                    cg3Var = new ve(cg3Var, new pe(j, timeUnit, null, 4, null));
                }
                if (z2) {
                    if (this.c == null) {
                        jl.a("Cannot create from asset or file for an in-memory database.");
                        return null;
                    }
                    String str = this.v;
                    int i = str == null ? 0 : 1;
                    File file = this.w;
                    int i2 = file == null ? 0 : 1;
                    Callable callable = this.x;
                    if (i + i2 + (callable != null ? 1 : 0) != 1) {
                        jl.a("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        return null;
                    }
                    cg3Var = new cg3(str, file, callable, cg3Var);
                }
                cVar = cg3Var;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                if (z) {
                    jl.a("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                    return null;
                }
                if (z2) {
                    jl.a("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                    return null;
                }
            }
            Context context = this.b;
            String str2 = this.c;
            e eVar = this.o;
            List list = this.e;
            boolean z3 = this.j;
            d dVarB = this.k.b(context);
            Executor executor2 = this.g;
            if (executor2 == null) {
                jl.a("Required value was null.");
                return null;
            }
            Executor executor3 = this.h;
            if (executor3 == null) {
                jl.a("Required value was null.");
                return null;
            }
            ma0 ma0Var = new ma0(context, str2, cVar, eVar, list, z3, dVarB, executor2, executor3, this.l, this.s, this.t, this.p, this.v, this.w, this.x, null, this.f, this.r, this.u, this.y, this.z);
            ma0Var.g(this.A);
            Function0 function0 = this.d;
            if (function0 == null || (bu3Var = (bu3) function0.invoke()) == null) {
                bu3Var = (bu3) ip1.b(dp1.a(this.a), null, 2, null);
            }
            bu3Var.B(ma0Var);
            return bu3Var;
        }

        public final a d(boolean z) {
            this.s = false;
            this.t = true;
            this.u = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public void a(lw3 lw3Var) {
            lw3Var.getClass();
            if (lw3Var instanceof gj4) {
                b(((gj4) lw3Var).a());
            }
        }

        public void b(hj4 hj4Var) {
            hj4Var.getClass();
        }

        public void c(lw3 lw3Var) {
            lw3Var.getClass();
            if (lw3Var instanceof gj4) {
                d(((gj4) lw3Var).a());
            }
        }

        public void d(hj4 hj4Var) {
            hj4Var.getClass();
        }

        public void e(lw3 lw3Var) {
            lw3Var.getClass();
            if (lw3Var instanceof gj4) {
                f(((gj4) lw3Var).a());
            }
        }

        public abstract void f(hj4 hj4Var);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public static final d f = new d("AUTOMATIC", 0);
        public static final d g = new d("TRUNCATE", 1);
        public static final d h = new d("WRITE_AHEAD_LOGGING", 2);
        public static final /* synthetic */ d[] i;
        public static final /* synthetic */ gt0 j;

        static {
            d[] dVarArrA = a();
            i = dVarArrA;
            j = ht0.a(dVarArrA);
        }

        public d(String str, int i2) {
        }

        public static final /* synthetic */ d[] a() {
            return new d[]{f, g, h};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) i.clone();
        }

        public final d b(Context context) {
            context.getClass();
            if (this != f) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || activityManager.isLowRamDevice()) ? g : h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public final Map a = new LinkedHashMap();

        public final void a(it2 it2Var) {
            it2Var.getClass();
            int i = it2Var.a;
            int i2 = it2Var.b;
            Map map = this.a;
            Integer numValueOf = Integer.valueOf(i);
            Object treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                map.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i2))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i2)) + " with " + it2Var);
            }
            treeMap2.put(Integer.valueOf(i2), it2Var);
        }

        public void b(it2... it2VarArr) {
            it2VarArr.getClass();
            for (it2 it2Var : it2VarArr) {
                a(it2Var);
            }
        }

        public final boolean c(int i, int i2) {
            return jt2.a(this, i, i2);
        }

        public List d(int i, int i2) {
            return jt2.b(this, i, i2);
        }

        public Map e() {
            return this.a;
        }

        public final i73 f(int i) {
            TreeMap treeMap = (TreeMap) this.a.get(Integer.valueOf(i));
            if (treeMap == null) {
                return null;
            }
            return fu4.a(treeMap, treeMap.descendingKeySet());
        }

        public final i73 g(int i) {
            TreeMap treeMap = (TreeMap) this.a.get(Integer.valueOf(i));
            if (treeMap == null) {
                return null;
            }
            return fu4.a(treeMap, treeMap.keySet());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class f {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class g extends t81 implements Function0 {
        public g(Object obj) {
            super(0, obj, bu3.class, "onClosed", "onClosed()V", 0);
        }

        public final void e() {
            ((bu3) this.receiver).G();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            e();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class h extends t81 implements Function2 {
        public h(Object obj) {
            super(2, obj, eu3.class, "compatTransactionCoroutineExecute", "compatTransactionCoroutineExecute(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Function1 function1, f30 f30Var) {
            return cu3.a((bu3) this.receiver, function1, f30Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class i extends t81 implements Function2 {
        public i(Object obj) {
            super(2, obj, eu3.class, "compatTransactionCoroutineExecute", "compatTransactionCoroutineExecute(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Function1 function1, f30 f30Var) {
            return cu3.a((bu3) this.receiver, function1, f30Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j extends oj4 implements Function2 {
        public int f;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ String[] i;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends oj4 implements Function2 {
            public int f;
            public /* synthetic */ Object g;
            public final /* synthetic */ bu3 h;
            public final /* synthetic */ boolean i;
            public final /* synthetic */ String[] j;

            /* JADX INFO: renamed from: bu3$j$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public static final class C0049a extends oj4 implements Function2 {
                public Object f;
                public int g;
                public int h;
                public int i;
                public /* synthetic */ Object j;
                public final /* synthetic */ boolean k;
                public final /* synthetic */ String[] l;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0049a(boolean z, String[] strArr, f30 f30Var) {
                    super(2, f30Var);
                    this.k = z;
                    this.l = strArr;
                }

                @Override // defpackage.hh
                public final f30 create(Object obj, f30 f30Var) {
                    C0049a c0049a = new C0049a(this.k, this.l, f30Var);
                    c0049a.j = obj;
                    return c0049a;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(cs4 cs4Var, f30 f30Var) {
                    return ((C0049a) create(cs4Var, f30Var)).invokeSuspend(fw4.a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
                
                    if (defpackage.fs4.b(r1, "PRAGMA defer_foreign_keys = TRUE", r9) == r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
                
                    if (defpackage.fs4.b(r6, r10, r9) == r0) goto L19;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0073 -> B:20:0x0076). Please report as a decompilation issue!!! */
                @Override // defpackage.hh
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
                    /*
                        r9 = this;
                        java.lang.Object r0 = defpackage.kl1.e()
                        int r1 = r9.i
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L2d
                        if (r1 == r3) goto L25
                        if (r1 != r2) goto L1e
                        int r1 = r9.h
                        int r4 = r9.g
                        java.lang.Object r5 = r9.f
                        java.lang.String[] r5 = (java.lang.String[]) r5
                        java.lang.Object r6 = r9.j
                        cs4 r6 = (defpackage.cs4) r6
                        defpackage.lt3.b(r10)
                        goto L76
                    L1e:
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        defpackage.e04.a(r9)
                        r9 = 0
                        return r9
                    L25:
                        java.lang.Object r1 = r9.j
                        cs4 r1 = (defpackage.cs4) r1
                        defpackage.lt3.b(r10)
                        goto L46
                    L2d:
                        defpackage.lt3.b(r10)
                        java.lang.Object r10 = r9.j
                        r1 = r10
                        cs4 r1 = (defpackage.cs4) r1
                        boolean r10 = r9.k
                        if (r10 == 0) goto L46
                        r9.j = r1
                        r9.i = r3
                        java.lang.String r10 = "PRAGMA defer_foreign_keys = TRUE"
                        java.lang.Object r10 = defpackage.fs4.b(r1, r10, r9)
                        if (r10 != r0) goto L46
                        goto L75
                    L46:
                        java.lang.String[] r10 = r9.l
                        int r4 = r10.length
                        r5 = 0
                        r6 = r1
                        r1 = r4
                        r4 = r5
                        r5 = r10
                    L4e:
                        if (r4 >= r1) goto L78
                        r10 = r5[r4]
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder
                        java.lang.String r8 = "DELETE FROM `"
                        r7.<init>(r8)
                        r7.append(r10)
                        r10 = 96
                        r7.append(r10)
                        java.lang.String r10 = r7.toString()
                        r9.j = r6
                        r9.f = r5
                        r9.g = r4
                        r9.h = r1
                        r9.i = r2
                        java.lang.Object r10 = defpackage.fs4.b(r6, r10, r9)
                        if (r10 != r0) goto L76
                    L75:
                        return r0
                    L76:
                        int r4 = r4 + r3
                        goto L4e
                    L78:
                        fw4 r9 = defpackage.fw4.a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: bu3.j.a.C0049a.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(bu3 bu3Var, boolean z, String[] strArr, f30 f30Var) {
                super(2, f30Var);
                this.h = bu3Var;
                this.i = z;
                this.j = strArr;
            }

            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                a aVar = new a(this.h, this.i, this.j, f30Var);
                aVar.g = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ds4 ds4Var, f30 f30Var) {
                return ((a) create(ds4Var, f30Var)).invokeSuspend(fw4.a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
            
                if (defpackage.fs4.b(r1, "VACUUM", r7) != r0) goto L35;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[PHI: r1
              0x006f: PHI (r1v7 ds4) = (r1v4 ds4), (r1v4 ds4), (r1v9 ds4) binds: [B:17:0x005b, B:19:0x006c, B:10:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[PHI: r1
              0x0086: PHI (r1v10 ds4) = (r1v7 ds4), (r1v12 ds4) binds: [B:22:0x0083, B:9:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0092 A[PHI: r1 r8
              0x0092: PHI (r1v13 ds4) = (r1v10 ds4), (r1v15 ds4) binds: [B:25:0x008f, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]
              0x0092: PHI (r8v14 java.lang.Object) = (r8v13 java.lang.Object), (r8v0 java.lang.Object) binds: [B:25:0x008f, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
            @Override // defpackage.hh
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 212
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: bu3.j.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(boolean z, String[] strArr, f30 f30Var) {
            super(2, f30Var);
            this.h = z;
            this.i = strArr;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return bu3.this.new j(this.h, this.i, f30Var);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((j) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            if (i == 0) {
                lt3.b(obj);
                zt3 zt3Var = bu3.this.f;
                if (zt3Var == null) {
                    il1.j("connectionManager");
                    zt3Var = null;
                }
                a aVar = new a(bu3.this, this.h, this.i, null);
                this.f = 1;
                if (zt3Var.J(false, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    public static jj4 a(bu3 bu3Var, ma0 ma0Var) {
        ma0Var.getClass();
        return bu3Var.l(ma0Var);
    }

    public boolean A() {
        return E() && q().getWritableDatabase().f();
    }

    public void B(ma0 ma0Var) {
        g40 g40VarG;
        ma0Var.getClass();
        this.a = ma0Var;
        this.m = ma0Var.e();
        this.f = i(ma0Var);
        this.g = j();
        cu3.b(this, ma0Var);
        cu3.d(this, ma0Var);
        g40 g40Var = ma0Var.u;
        u40 u40Var = null;
        if (g40Var != null) {
            g40.b bVarA = g40Var.a(h30.b);
            bVarA.getClass();
            n40 n40Var = (n40) bVarA;
            Executor executorA = tv0.a(n40Var);
            this.d = executorA;
            if (executorA == null) {
                il1.j("internalQueryExecutor");
                executorA = null;
            }
            this.e = new bs4(executorA);
            this.b = v40.a(ma0Var.u.N(wi4.a((ln1) ma0Var.u.a(ln1.e))));
            boolean z = z();
            u40 u40Var2 = this.b;
            if (z) {
                if (u40Var2 == null) {
                    il1.j("coroutineScope");
                    u40Var2 = null;
                }
                g40VarG = u40Var2.g().N(n40Var.e0(1));
            } else {
                if (u40Var2 == null) {
                    il1.j("coroutineScope");
                    u40Var2 = null;
                }
                g40VarG = u40Var2.g();
            }
            this.c = g40VarG;
        } else {
            this.d = ma0Var.h;
            this.e = new bs4(ma0Var.i);
            Executor executor = this.d;
            if (executor == null) {
                il1.j("internalQueryExecutor");
                executor = null;
            }
            u40 u40VarA = v40.a(tv0.b(executor).N(wi4.b(null, 1, null)));
            this.b = u40VarA;
            if (u40VarA == null) {
                il1.j("coroutineScope");
                u40VarA = null;
            }
            g40 g40VarG2 = u40VarA.g();
            Executor executor2 = this.e;
            if (executor2 == null) {
                il1.j("internalTransactionExecutor");
                executor2 = null;
            }
            this.c = g40VarG2.N(tv0.b(executor2));
        }
        this.i = ma0Var.f;
        zt3 zt3Var = this.f;
        if (zt3Var == null) {
            il1.j("connectionManager");
            zt3Var = null;
        }
        jj4 jj4VarF = zt3Var.F();
        if (jj4VarF != null) {
            while (!(jj4VarF instanceof bg3)) {
                if (!(jj4VarF instanceof ij0)) {
                    jj4VarF = null;
                    break;
                }
                jj4VarF = ((ij0) jj4VarF).a();
            }
        } else {
            jj4VarF = null;
            break;
        }
        bg3 bg3Var = (bg3) jj4VarF;
        if (bg3Var != null) {
            bg3Var.i(ma0Var);
        }
        zt3 zt3Var2 = this.f;
        if (zt3Var2 == null) {
            il1.j("connectionManager");
            zt3Var2 = null;
        }
        jj4 jj4VarF2 = zt3Var2.F();
        if (jj4VarF2 != null) {
            while (!(jj4VarF2 instanceof se)) {
                if (!(jj4VarF2 instanceof ij0)) {
                    jj4VarF2 = null;
                    break;
                }
                jj4VarF2 = ((ij0) jj4VarF2).a();
            }
        } else {
            jj4VarF2 = null;
            break;
        }
        se seVar = (se) jj4VarF2;
        if (seVar != null) {
            this.j = seVar.c();
            pe peVarC = seVar.c();
            u40 u40Var3 = this.b;
            if (u40Var3 == null) {
                il1.j("coroutineScope");
            } else {
                u40Var = u40Var3;
            }
            peVarC.j(u40Var);
            p().t(seVar.c());
        }
        if (ma0Var.j != null) {
            if (ma0Var.b != null) {
                p().l(ma0Var.a, ma0Var.b, ma0Var.j);
            } else {
                jl.a("Required value was null.");
            }
        }
    }

    public final void C(lw3 lw3Var) {
        lw3Var.getClass();
        p().m(lw3Var);
    }

    public final boolean D() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final boolean E() {
        pe peVar = this.j;
        if (peVar != null) {
            hj4 hj4VarH = peVar.h();
            if (hj4VarH != null) {
                return hj4VarH.isOpen();
            }
            return false;
        }
        zt3 zt3Var = this.f;
        if (zt3Var == null) {
            il1.j("connectionManager");
            zt3Var = null;
        }
        return zt3Var.I();
    }

    public final boolean F() {
        g40 g40Var = (g40) this.k.get();
        return (g40Var != null ? (zr4) g40Var.a(zr4.g) : null) != null;
    }

    public final void G() {
        u40 u40Var = this.b;
        zt3 zt3Var = null;
        if (u40Var == null) {
            il1.j("coroutineScope");
            u40Var = null;
        }
        v40.c(u40Var, null, 1, null);
        p().u();
        zt3 zt3Var2 = this.f;
        if (zt3Var2 == null) {
            il1.j("connectionManager");
        } else {
            zt3Var = zt3Var2;
        }
        zt3Var.E();
    }

    public final void H(boolean z, String... strArr) {
        strArr.getClass();
        e();
        f();
        cw3.a(new j(z, strArr, null));
    }

    public final Object I(boolean z, Function2 function2, f30 f30Var) {
        zt3 zt3Var = this.f;
        if (zt3Var == null) {
            il1.j("connectionManager");
            zt3Var = null;
        }
        return zt3Var.J(z, function2, f30Var);
    }

    public final void d(hp1 hp1Var, Object obj) {
        hp1Var.getClass();
        obj.getClass();
        this.l.put(hp1Var, obj);
    }

    public void e() {
        if (!this.i && D()) {
            e04.a("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void f() {
        if (z() && !A() && F()) {
            e04.a("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public abstract void g();

    public List h(Map map) {
        map.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(x42.e(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(dp1.a((hp1) entry.getKey()), entry.getValue());
        }
        return m(linkedHashMap);
    }

    public final zt3 i(ma0 ma0Var) {
        hu3 hu3Var;
        ma0Var.getClass();
        try {
            iu3 iu3VarK = k();
            iu3VarK.getClass();
            hu3Var = (hu3) iu3VarK;
        } catch (b43 unused) {
            hu3Var = null;
        }
        return hu3Var == null ? new zt3(ma0Var, new Function1() { // from class: au3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return bu3.a(this.f, (ma0) obj);
            }
        }, new h(this)) : new zt3(ma0Var, hu3Var, new i(this));
    }

    public abstract androidx.room.c j();

    public iu3 k() {
        throw new b43(null, 1, null);
    }

    public jj4 l(ma0 ma0Var) {
        ma0Var.getClass();
        throw new b43(null, 1, null);
    }

    public List m(Map map) {
        map.getClass();
        return ow.j();
    }

    public final av n() {
        return this.h;
    }

    public final u40 o() {
        u40 u40Var = this.b;
        if (u40Var != null) {
            return u40Var;
        }
        il1.j("coroutineScope");
        return null;
    }

    public androidx.room.c p() {
        androidx.room.c cVar = this.g;
        if (cVar != null) {
            return cVar;
        }
        il1.j("internalTracker");
        return null;
    }

    public jj4 q() {
        zt3 zt3Var = this.f;
        if (zt3Var == null) {
            il1.j("connectionManager");
            zt3Var = null;
        }
        jj4 jj4VarF = zt3Var.F();
        if (jj4VarF != null) {
            return jj4VarF;
        }
        e04.a("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
        return null;
    }

    public Set r() {
        Set setS = s();
        ArrayList arrayList = new ArrayList(pw.t(setS, 10));
        Iterator it = setS.iterator();
        while (it.hasNext()) {
            arrayList.add(dp1.c((Class) it.next()));
        }
        return ww.e0(arrayList);
    }

    public Set s() {
        return o24.d();
    }

    public Map t() {
        Set<Map.Entry> setEntrySet = v().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(xn3.b(x42.e(pw.t(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            hp1 hp1VarC = dp1.c(cls);
            ArrayList arrayList = new ArrayList(pw.t(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(dp1.c((Class) it.next()));
            }
            i73 i73VarA = fu4.a(hp1VarC, arrayList);
            linkedHashMap.put(i73VarA.c(), i73VarA.d());
        }
        return linkedHashMap;
    }

    public final Map u() {
        return t();
    }

    public Map v() {
        return y42.h();
    }

    public final ThreadLocal w() {
        return this.k;
    }

    public Executor x() {
        Executor executor = this.e;
        if (executor != null) {
            return executor;
        }
        il1.j("internalTransactionExecutor");
        return null;
    }

    public final boolean y() {
        return this.m;
    }

    public final boolean z() {
        zt3 zt3Var = this.f;
        if (zt3Var == null) {
            il1.j("connectionManager");
            zt3Var = null;
        }
        return zt3Var.F() != null;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public /* synthetic */ c(we0 we0Var) {
            this();
        }

        public c() {
        }
    }
}
