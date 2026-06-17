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

        public a(f30 f30Var) {
            super(f30Var);
        }

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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function2 function2, qf3 qf3Var, f30 f30Var) {
            super(2, f30Var);
            this.g = function2;
            this.h = qf3Var;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new b(this.g, this.h, f30Var);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((b) create(u40Var, f30Var)).invokeSuspend(fw4.a);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Function2 function2, mp3 mp3Var, f30 f30Var) {
            super(2, f30Var);
            this.g = function2;
            this.h = mp3Var;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new c(this.g, this.h, f30Var);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((c) create(u40Var, f30Var)).invokeSuspend(fw4.a);
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
            Function2 function2 = this.g;
            Object obj2 = this.h.f;
            this.f = 1;
            Object objInvoke = function2.invoke(obj2, this);
            return objInvoke == objE ? objE : objInvoke;
        }
    }

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
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return s00.c(nw3Var, str);
            }
        }, i3);
        this.h = new kf3(i2, new Function0() { // from class: p00
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return s00.h(nw3Var, str);
            }
        }, i3);
    }

    public static fw4 a(s00 s00Var, boolean z) {
        s00Var.t(z);
        return fw4.a;
    }

    public static lw3 c(nw3 nw3Var, String str) throws Exception {
        lw3 lw3VarA = nw3Var.a(str);
        kw3.a(lw3VarA, "PRAGMA query_only = 1");
        return lw3VarA;
    }

    public static lw3 h(nw3 nw3Var, String str) {
        return nw3Var.a(str);
    }

    public static lw3 i(nw3 nw3Var, String str) {
        return nw3Var.a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0138 A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #0 {all -> 0x0172, blocks: (B:64:0x011d, B:69:0x012d, B:71:0x0138, B:81:0x0176, B:82:0x017d), top: B:97:0x011d }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0176 A[Catch: all -> 0x0172, TRY_ENTER, TryCatch #0 {all -> 0x0172, blocks: (B:64:0x011d, B:69:0x012d, B:71:0x0138, B:81:0x0176, B:82:0x017d), top: B:97:0x011d }] */
    @Override // defpackage.n00
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object X(boolean r18, kotlin.jvm.functions.Function2 r19, defpackage.f30 r20) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s00.X(boolean, kotlin.jvm.functions.Function2, f30):java.lang.Object");
    }

    @Override // defpackage.n00, java.lang.AutoCloseable
    public void close() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.g.c();
        this.h.c();
    }

    public final g40 l(qf3 qf3Var) {
        return new l00(this.i, qf3Var).N(qn4.a(this.j, qf3Var));
    }

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
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return s00.i(nw3Var, str);
            }
        }, i);
        this.g = kf3Var;
        this.h = kf3Var;
    }
}
