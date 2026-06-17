package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import defpackage.ds4;
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a a(it2... it2VarArr) {
            it2VarArr.getClass();
            for (it2 it2Var : it2VarArr) {
                this.q.add(Integer.valueOf(it2Var.a));
                this.q.add(Integer.valueOf(it2Var.b));
            }
            this.o.b((it2[]) Arrays.copyOf(it2VarArr, it2VarArr.length));
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a b() {
            this.j = true;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final a d(boolean z) {
            this.s = false;
            this.t = true;
            this.u = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(lw3 lw3Var) {
            lw3Var.getClass();
            if (lw3Var instanceof gj4) {
                b(((gj4) lw3Var).a());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(hj4 hj4Var) {
            hj4Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(lw3 lw3Var) {
            lw3Var.getClass();
            if (lw3Var instanceof gj4) {
                d(((gj4) lw3Var).a());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(hj4 hj4Var) {
            hj4Var.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            d[] dVarArrA = a();
            i = dVarArrA;
            j = ht0.a(dVarArrA);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(String str, int i2) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static final /* synthetic */ d[] a() {
            return new d[]{f, g, h};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static d[] values() {
            return (d[]) i.clone();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(it2... it2VarArr) {
            it2VarArr.getClass();
            for (it2 it2Var : it2VarArr) {
                a(it2Var);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean c(int i, int i2) {
            return jt2.a(this, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List d(int i, int i2) {
            return jt2.b(this, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Map e() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final i73 f(int i) {
            TreeMap treeMap = (TreeMap) this.a.get(Integer.valueOf(i));
            if (treeMap == null) {
                return null;
            }
            return fu4.a(treeMap, treeMap.descendingKeySet());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(Object obj) {
            super(0, obj, bu3.class, "onClosed", "onClosed()V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void e() {
            ((bu3) this.receiver).G();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            e();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class h extends t81 implements Function2 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(Object obj) {
            super(2, obj, eu3.class, "compatTransactionCoroutineExecute", "compatTransactionCoroutineExecute(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Function1 function1, f30 f30Var) {
            return cu3.a((bu3) this.receiver, function1, f30Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class i extends t81 implements Function2 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(Object obj) {
            super(2, obj, eu3.class, "compatTransactionCoroutineExecute", "compatTransactionCoroutineExecute(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
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

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0049a(boolean z, String[] strArr, f30 f30Var) {
                    super(2, f30Var);
                    this.k = z;
                    this.l = strArr;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.hh
                public final f30 create(Object obj, f30 f30Var) {
                    C0049a c0049a = new C0049a(this.k, this.l, f30Var);
                    c0049a.j = obj;
                    return c0049a;
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(cs4 cs4Var, f30 f30Var) {
                    return ((C0049a) create(cs4Var, f30Var)).invokeSuspend(fw4.a);
                }

                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
                */
                public final Object invokeSuspend(Object obj) throws Throwable {
                    cs4 cs4Var;
                    cs4 cs4Var2;
                    int length;
                    int i;
                    String[] strArr;
                    Object objE = kl1.e();
                    int i2 = this.i;
                    if (i2 == 0) {
                        lt3.b(obj);
                        cs4Var = (cs4) this.j;
                        if (this.k) {
                            this.j = cs4Var;
                            this.i = 1;
                        }
                    } else if (i2 == 1) {
                        cs4Var = (cs4) this.j;
                        lt3.b(obj);
                    } else {
                        if (i2 != 2) {
                            e04.a("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        length = this.h;
                        i = this.g;
                        strArr = (String[]) this.f;
                        cs4Var2 = (cs4) this.j;
                        lt3.b(obj);
                        i++;
                        if (i < length) {
                            return fw4.a;
                        }
                        String str = "DELETE FROM `" + strArr[i] + '`';
                        this.j = cs4Var2;
                        this.f = strArr;
                        this.g = i;
                        this.h = length;
                        this.i = 2;
                    }
                    String[] strArr2 = this.l;
                    cs4Var2 = cs4Var;
                    length = strArr2.length;
                    i = 0;
                    strArr = strArr2;
                    if (i < length) {
                    }
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(bu3 bu3Var, boolean z, String[] strArr, f30 f30Var) {
                super(2, f30Var);
                this.h = bu3Var;
                this.i = z;
                this.j = strArr;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                a aVar = new a(this.h, this.i, this.j, f30Var);
                aVar.g = obj;
                return aVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ds4 ds4Var, f30 f30Var) {
                return ((a) create(ds4Var, f30Var)).invokeSuspend(fw4.a);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
            */
            public final Object invokeSuspend(Object obj) throws Throwable {
                ds4 ds4Var;
                ds4.a aVar;
                C0049a c0049a;
                Object objE = kl1.e();
                switch (this.f) {
                    case 0:
                        lt3.b(obj);
                        ds4 ds4Var2 = (ds4) this.g;
                        this.g = ds4Var2;
                        this.f = 1;
                        Object objC = ds4Var2.c(this);
                        if (objC != objE) {
                            ds4Var = ds4Var2;
                            obj = objC;
                            if (((Boolean) obj).booleanValue()) {
                                androidx.room.c cVarP = this.h.p();
                                this.g = ds4Var;
                                this.f = 2;
                                if (cVarP.v(this) != objE) {
                                    aVar = ds4.a.g;
                                    c0049a = new C0049a(this.i, this.j, null);
                                    this.g = ds4Var;
                                    this.f = 3;
                                    if (ds4Var.b(aVar, c0049a, this) != objE) {
                                        this.g = ds4Var;
                                        this.f = 4;
                                        obj = ds4Var.c(this);
                                        if (obj != objE) {
                                            if (!((Boolean) obj).booleanValue()) {
                                                this.g = ds4Var;
                                                this.f = 5;
                                                if (fs4.b(ds4Var, "PRAGMA wal_checkpoint(FULL)", this) != objE) {
                                                    this.g = null;
                                                    this.f = 6;
                                                }
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            return fw4.a;
                        }
                        return objE;
                    case 1:
                        ds4Var = (ds4) this.g;
                        lt3.b(obj);
                        if (((Boolean) obj).booleanValue()) {
                        }
                        return fw4.a;
                    case 2:
                        ds4Var = (ds4) this.g;
                        lt3.b(obj);
                        aVar = ds4.a.g;
                        c0049a = new C0049a(this.i, this.j, null);
                        this.g = ds4Var;
                        this.f = 3;
                        if (ds4Var.b(aVar, c0049a, this) != objE) {
                        }
                        return objE;
                    case 3:
                        ds4Var = (ds4) this.g;
                        lt3.b(obj);
                        this.g = ds4Var;
                        this.f = 4;
                        obj = ds4Var.c(this);
                        if (obj != objE) {
                        }
                        return objE;
                    case 4:
                        ds4Var = (ds4) this.g;
                        lt3.b(obj);
                        if (!((Boolean) obj).booleanValue()) {
                        }
                        return fw4.a;
                    case 5:
                        ds4Var = (ds4) this.g;
                        lt3.b(obj);
                        this.g = null;
                        this.f = 6;
                        break;
                    case 6:
                        lt3.b(obj);
                        this.h.p().q();
                        return fw4.a;
                    default:
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(boolean z, String[] strArr, f30 f30Var) {
            super(2, f30Var);
            this.h = z;
            this.i = strArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return bu3.this.new j(this.h, this.i, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((j) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jj4 a(bu3 bu3Var, ma0 ma0Var) {
        ma0Var.getClass();
        return bu3Var.l(ma0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean A() {
        return E() && q().getWritableDatabase().f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(lw3 lw3Var) {
        lw3Var.getClass();
        p().m(lw3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean D() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean F() {
        g40 g40Var = (g40) this.k.get();
        return (g40Var != null ? (zr4) g40Var.a(zr4.g) : null) != null;
    }

    /* JADX DEBUG: Class process forced to load method for inline: v40.c(u40, java.util.concurrent.CancellationException, int, java.lang.Object):void */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(boolean z, String... strArr) {
        strArr.getClass();
        e();
        f();
        cw3.a(new j(z, strArr, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object I(boolean z, Function2 function2, f30 f30Var) {
        zt3 zt3Var = this.f;
        if (zt3Var == null) {
            il1.j("connectionManager");
            zt3Var = null;
        }
        return zt3Var.J(z, function2, f30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(hp1 hp1Var, Object obj) {
        hp1Var.getClass();
        obj.getClass();
        this.l.put(hp1Var, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e() {
        if (!this.i && D()) {
            e04.a("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f() {
        if (z() && !A() && F()) {
            e04.a("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public abstract void g();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List h(Map map) {
        map.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(x42.e(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(dp1.a((hp1) entry.getKey()), entry.getValue());
        }
        return m(linkedHashMap);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return bu3.a(this.f, (ma0) obj);
            }
        }, new h(this)) : new zt3(ma0Var, hu3Var, new i(this));
    }

    public abstract androidx.room.c j();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iu3 k() {
        throw new b43(null, 1, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jj4 l(ma0 ma0Var) {
        ma0Var.getClass();
        throw new b43(null, 1, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List m(Map map) {
        map.getClass();
        return ow.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final av n() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final u40 o() {
        u40 u40Var = this.b;
        if (u40Var != null) {
            return u40Var;
        }
        il1.j("coroutineScope");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public androidx.room.c p() {
        androidx.room.c cVar = this.g;
        if (cVar != null) {
            return cVar;
        }
        il1.j("internalTracker");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set r() {
        Set setS = s();
        ArrayList arrayList = new ArrayList(pw.t(setS, 10));
        Iterator it = setS.iterator();
        while (it.hasNext()) {
            arrayList.add(dp1.c((Class) it.next()));
        }
        return ww.e0(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set s() {
        return o24.d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map u() {
        return t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map v() {
        return y42.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ThreadLocal w() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Executor x() {
        Executor executor = this.e;
        if (executor != null) {
            return executor;
        }
        il1.j("internalTransactionExecutor");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean y() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: bu3.c.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ c(we0 we0Var) {
            this();
        }

        public c() {
        }
    }
}
