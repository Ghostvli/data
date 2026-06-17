package defpackage;

import android.database.SQLException;
import defpackage.tp0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s00 implements n00 {
    public final nw3 f;
    public final kf3 g;
    public final kf3 h;
    public final m00 i;
    public final ThreadLocal j;
    public volatile boolean k;
    public long l;
    public int m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends g30 {
        public boolean f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;
        public /* synthetic */ Object m;
        public int o;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.m = obj;
            this.o |= Integer.MIN_VALUE;
            return s00.this.X(false, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends oj4 implements Function2 {
        public int f;
        public final /* synthetic */ Function2 g;
        public final /* synthetic */ qf3 h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function2 function2, qf3 qf3Var, f30 f30Var) {
            super(2, f30Var);
            this.g = function2;
            this.h = qf3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new b(this.g, this.h, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((b) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
            Function2 function2 = this.g;
            qf3 qf3Var = this.h;
            this.f = 1;
            Object objInvoke = function2.invoke(qf3Var, this);
            return objInvoke == objE ? objE : objInvoke;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends oj4 implements Function2 {
        public int f;
        public final /* synthetic */ Function2 g;
        public final /* synthetic */ mp3 h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Function2 function2, mp3 mp3Var, f30 f30Var) {
            super(2, f30Var);
            this.g = function2;
            this.h = mp3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new c(this.g, this.h, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((c) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
            Function2 function2 = this.g;
            Object obj2 = this.h.f;
            this.f = 1;
            Object objInvoke = function2.invoke(obj2, this);
            return objInvoke == objE ? objE : objInvoke;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s00(final nw3 nw3Var, final String str, int i, int i2, int i3) {
        nw3Var.getClass();
        str.getClass();
        this.i = new m00();
        this.j = new ThreadLocal();
        tp0.a aVar = tp0.f;
        this.l = wp0.m(30, xp0.j);
        this.m = 2;
        if (i <= 0) {
            jl.a("Maximum number of readers must be greater than 0");
            throw null;
        }
        if (i2 <= 0) {
            jl.a("Maximum number of writers must be greater than 0");
            throw null;
        }
        this.f = nw3Var;
        this.g = new kf3(i, new Function0() { // from class: o00
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return s00.c(nw3Var, str);
            }
        }, i3);
        this.h = new kf3(i2, new Function0() { // from class: p00
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return s00.h(nw3Var, str);
            }
        }, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 a(s00 s00Var, boolean z) {
        s00Var.t(z);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lw3 c(nw3 nw3Var, String str) throws Exception {
        lw3 lw3VarA = nw3Var.a(str);
        kw3.a(lw3VarA, "PRAGMA query_only = 1");
        return lw3VarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lw3 h(nw3 nw3Var, String str) {
        return nw3Var.a(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lw3 i(nw3 nw3Var, String str) {
        return nw3Var.a(str);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, THROW, IF, IGET, CHECK_CAST, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0138 A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #0 {all -> 0x0172, blocks: (B:64:0x011d, B:69:0x012d, B:71:0x0138, B:81:0x0176, B:82:0x017d), top: B:97:0x011d }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0176 A[Catch: all -> 0x0172, TRY_ENTER, TryCatch #0 {all -> 0x0172, blocks: (B:64:0x011d, B:69:0x012d, B:71:0x0138, B:81:0x0176, B:82:0x017d), top: B:97:0x011d }] */
    @Override // defpackage.n00
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object X(boolean z, Function2 function2, f30 f30Var) throws Exception {
        a aVar;
        mp3 mp3Var;
        Throwable th;
        kf3 kf3Var;
        g40 context;
        Function2 function22;
        m00 m00Var;
        kf3 kf3Var2;
        mp3 mp3Var2;
        Object obj;
        mp3 mp3Var3;
        qf3 qf3Var;
        final boolean z2 = z;
        if (f30Var instanceof a) {
            aVar = (a) f30Var;
            int i = aVar.o;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.o = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(f30Var);
            }
        }
        Object objE = aVar.m;
        Object objE2 = kl1.e();
        int i2 = aVar.o;
        boolean z3 = true;
        if (i2 == 0) {
            lt3.b(objE);
            if (this.k) {
                kw3.b(21, "Connection pool is closed");
                mx3.a();
                return null;
            }
            qf3 qf3VarB = (qf3) this.j.get();
            if (qf3VarB == null) {
                l00 l00Var = (l00) aVar.getContext().a(this.i);
                qf3VarB = l00Var != null ? l00Var.b() : null;
            }
            if (qf3VarB == null) {
                kf3 kf3Var3 = z2 ? this.g : this.h;
                mp3Var = new mp3();
                try {
                    context = aVar.getContext();
                    m00 m00Var2 = this.i;
                    long j = this.l;
                    Function0 function0 = new Function0() { // from class: q00
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return s00.a(this.f, z2);
                        }
                    };
                    aVar.g = function2;
                    aVar.h = kf3Var3;
                    aVar.i = mp3Var;
                    aVar.j = context;
                    aVar.k = mp3Var;
                    aVar.l = m00Var2;
                    aVar.f = z2;
                    aVar.o = 3;
                    Object objB = kf3Var3.b(j, function0, aVar);
                    if (objB != objE2) {
                        function22 = function2;
                        m00Var = m00Var2;
                        kf3Var2 = kf3Var3;
                        objE = objB;
                        mp3Var2 = mp3Var;
                        c10 c10VarL = ((c10) objE).l(context);
                        if (this.g != this.h) {
                        }
                        z3 = false;
                        mp3Var2.f = new qf3(m00Var, c10VarL, z3);
                        obj = mp3Var.f;
                        if (obj != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    kf3Var = kf3Var3;
                }
            } else {
                if (!z2 && qf3VarB.m()) {
                    kw3.b(1, "Cannot upgrade connection from reader to writer");
                    mx3.a();
                    return null;
                }
                if (aVar.getContext().a(this.i) == null) {
                    g40 g40VarL = l(qf3VarB);
                    b bVar = new b(function2, qf3VarB, null);
                    aVar.o = 1;
                    Object objE3 = bm.e(g40VarL, bVar, aVar);
                    if (objE3 != objE2) {
                        return objE3;
                    }
                } else {
                    aVar.o = 2;
                    Object objInvoke = function2.invoke(qf3VarB, aVar);
                    if (objInvoke != objE2) {
                        return objInvoke;
                    }
                }
            }
            return objE2;
        }
        if (i2 == 1) {
            lt3.b(objE);
            return objE;
        }
        if (i2 == 2) {
            lt3.b(objE);
            return objE;
        }
        if (i2 == 3) {
            z2 = aVar.f;
            m00Var = (m00) aVar.l;
            mp3 mp3Var4 = (mp3) aVar.k;
            g40 g40Var = (g40) aVar.j;
            mp3 mp3Var5 = (mp3) aVar.i;
            kf3Var2 = (kf3) aVar.h;
            function22 = (Function2) aVar.g;
            try {
                lt3.b(objE);
                mp3Var2 = mp3Var4;
                mp3Var = mp3Var5;
                context = g40Var;
                try {
                    c10 c10VarL2 = ((c10) objE).l(context);
                    if (this.g != this.h || !z2) {
                        z3 = false;
                    }
                    mp3Var2.f = new qf3(m00Var, c10VarL2, z3);
                    obj = mp3Var.f;
                    if (obj != null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    g40 g40VarL2 = l((qf3) obj);
                    c cVar = new c(function22, mp3Var, null);
                    aVar.g = kf3Var2;
                    aVar.h = mp3Var;
                    aVar.i = null;
                    aVar.j = null;
                    aVar.k = null;
                    aVar.l = null;
                    aVar.o = 4;
                    objE = bm.e(g40VarL2, cVar, aVar);
                    if (objE != objE2) {
                        mp3Var3 = mp3Var;
                        kf3Var = kf3Var2;
                        qf3Var = (qf3) mp3Var3.f;
                        if (qf3Var != null) {
                        }
                        return objE;
                    }
                    return objE2;
                } catch (Throwable th3) {
                    th = th3;
                    kf3Var = kf3Var2;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                mp3Var = mp3Var5;
                kf3Var = kf3Var2;
                throw th;
            }
        }
        if (i2 != 4) {
            e04.a("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        mp3Var3 = (mp3) aVar.h;
        kf3Var = (kf3) aVar.g;
        try {
            lt3.b(objE);
            qf3Var = (qf3) mp3Var3.f;
            if (qf3Var != null) {
                qf3Var.n();
                qf3Var.l().t();
                kf3Var.e(qf3Var.l());
            }
            return objE;
        } catch (Throwable th5) {
            mp3Var = mp3Var3;
            th = th5;
        }
        try {
            throw th;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n00, java.lang.AutoCloseable
    public void close() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.g.c();
        this.h.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final g40 l(qf3 qf3Var) {
        return new l00(this.i, qf3Var).N(qn4.a(this.j, qf3Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(boolean z) {
        String str = z ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append("\n\nWriter pool:\n");
        this.h.d(sb);
        sb.append("Reader pool:");
        sb.append('\n');
        this.g.d(sb);
        try {
            kw3.b(5, sb.toString());
            throw new kr1();
        } catch (SQLException e) {
            int i = this.m;
            if (i == 1) {
                throw e;
            }
            if (i != 2) {
                return;
            }
            e.printStackTrace();
        }
    }

    public s00(final nw3 nw3Var, final String str, int i) {
        nw3Var.getClass();
        str.getClass();
        this.i = new m00();
        this.j = new ThreadLocal();
        tp0.a aVar = tp0.f;
        this.l = wp0.m(30, xp0.j);
        this.m = 2;
        this.f = nw3Var;
        kf3 kf3Var = new kf3(1, new Function0() { // from class: r00
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return s00.i(nw3Var, str);
            }
        }, i);
        this.g = kf3Var;
        this.h = kf3Var;
    }
}
