package defpackage;

import android.os.SystemClock;
import defpackage.ln1;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pe {
    public static final a l = new a(null);
    public final b a;
    public jj4 b;
    public u40 c;
    public Function0 d;
    public final Object e;
    public final long f;
    public final AtomicInteger g;
    public AtomicLong h;
    public hj4 i;
    public boolean j;
    public ln1 k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        long a();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends oj4 implements Function2 {
        public int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(f30 f30Var) {
            super(2, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return pe.this.new c(f30Var);
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
            if (i == 0) {
                lt3.b(obj);
                long j = pe.this.f;
                this.f = 1;
                if (hj0.a(j, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            pe.this.d();
            return fw4.a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pe(long j, TimeUnit timeUnit, b bVar) {
        timeUnit.getClass();
        bVar.getClass();
        this.a = bVar;
        this.e = new Object();
        this.f = timeUnit.toMillis(j);
        this.g = new AtomicInteger(0);
        this.h = new AtomicLong(bVar.a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long a() {
        return SystemClock.uptimeMillis();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d() {
        synchronized (this.e) {
            try {
                if (this.a.a() - this.h.get() < this.f) {
                    return;
                }
                if (this.g.get() != 0) {
                    return;
                }
                Function0 function0 = this.d;
                if (function0 == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should  have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                function0.invoke();
                hj4 hj4Var = this.i;
                if (hj4Var != null && hj4Var.isOpen()) {
                    hj4Var.close();
                }
                this.i = null;
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e() {
        synchronized (this.e) {
            try {
                this.j = true;
                ln1 ln1Var = this.k;
                if (ln1Var != null) {
                    ln1.a.a(ln1Var, null, 1, null);
                }
                this.k = null;
                hj4 hj4Var = this.i;
                if (hj4Var != null) {
                    hj4Var.close();
                }
                this.i = null;
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        u40 u40Var;
        int iDecrementAndGet = this.g.decrementAndGet();
        if (iDecrementAndGet < 0) {
            e04.a("Unbalanced reference count.");
            return;
        }
        this.h.set(this.a.a());
        if (iDecrementAndGet == 0) {
            u40 u40Var2 = this.c;
            if (u40Var2 == null) {
                il1.j("coroutineScope");
                u40Var = null;
            } else {
                u40Var = u40Var2;
            }
            this.k = dm.b(u40Var, null, null, new c(null), 3, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object g(Function1 function1) {
        function1.getClass();
        try {
            return function1.invoke(i());
        } finally {
            f();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final hj4 h() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final hj4 i() {
        ln1 ln1Var = this.k;
        jj4 jj4Var = null;
        if (ln1Var != null) {
            ln1.a.a(ln1Var, null, 1, null);
        }
        this.k = null;
        this.g.incrementAndGet();
        if (this.j) {
            e04.a("Attempting to open already closed database.");
            return null;
        }
        synchronized (this.e) {
            hj4 hj4Var = this.i;
            if (hj4Var != null && hj4Var.isOpen()) {
                return hj4Var;
            }
            jj4 jj4Var2 = this.b;
            if (jj4Var2 == null) {
                il1.j("delegateOpenHelper");
            } else {
                jj4Var = jj4Var2;
            }
            hj4 writableDatabase = jj4Var.getWritableDatabase();
            this.i = writableDatabase;
            return writableDatabase;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(u40 u40Var) {
        u40Var.getClass();
        this.c = u40Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(jj4 jj4Var) {
        jj4Var.getClass();
        if (jj4Var instanceof se) {
            jl.a("Failed requirement.");
        } else {
            this.b = jj4Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean l() {
        return !this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(Function0 function0) {
        function0.getClass();
        this.d = function0;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: pe.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0009: CONSTRUCTOR 
      (r1v0 long)
      (r3v0 java.util.concurrent.TimeUnit)
      (wrap:pe$b:?: TERNARY null = ((wrap:int:0x0000: ARITH (r5v0 int) & (4 int) A[WRAPPED]) != (0 int)) ? (wrap:pe$b:0x0006: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:45) call: oe.<init>():void type: CONSTRUCTOR) : (r4v0 pe$b))
     A[MD:(long, java.util.concurrent.TimeUnit, pe$b):void (m)] (LINE:46) call: pe.<init>(long, java.util.concurrent.TimeUnit, pe$b):void type: THIS */
    public /* synthetic */ pe(long j, TimeUnit timeUnit, b bVar, int i, we0 we0Var) {
        this(j, timeUnit, (i & 4) != 0 ? new b() { // from class: oe
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pe.b
            public final long a() {
                return pe.a();
            }
        } : bVar);
    }
}
