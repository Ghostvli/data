package androidx.lifecycle;

import android.app.Application;
import defpackage.c45;
import defpackage.d50;
import defpackage.dp1;
import defpackage.fn;
import defpackage.fp1;
import defpackage.g6;
import defpackage.h45;
import defpackage.hp1;
import defpackage.j45;
import defpackage.jl;
import defpackage.k45;
import defpackage.l45;
import defpackage.we0;
import defpackage.wo3;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class x {
    public static final b b = new b(null);
    public static final d50.c c;
    public final h45 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        public static final a a = a.a;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public static final /* synthetic */ a a = new a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default c45 a(Class cls) {
            cls.getClass();
            return j45.a.d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default c45 b(Class cls, d50 d50Var) {
            cls.getClass();
            d50Var.getClass();
            return a(cls);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default c45 c(hp1 hp1Var, d50 d50Var) {
            hp1Var.getClass();
            d50Var.getClass();
            return b(dp1.a(hp1Var), d50Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public abstract void d(c45 c45Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f implements d50.c {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        d50.a aVar = d50.b;
        c = new f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Illegal instructions before constructor call */
    public x(l45 l45Var) {
        l45Var.getClass();
        k45 k45VarD0 = l45Var.d0();
        j45 j45Var = j45.a;
        this(k45VarD0, j45Var.b(l45Var), j45Var.a(l45Var));
    }

    /* JADX DEBUG: Class process forced to load method for inline: h45.e(h45, hp1, java.lang.String, int, java.lang.Object):c45 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c45 a(hp1 hp1Var) {
        hp1Var.getClass();
        return h45.e(this.a, hp1Var, null, 2, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c45 b(Class cls) {
        cls.getClass();
        return a(dp1.c(cls));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c45 c(String str, hp1 hp1Var) {
        str.getClass();
        hp1Var.getClass();
        return this.a.d(hp1Var, str);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends d {
        public static final C0014a f = new C0014a(null);
        public static a g;
        public static final d50.c h;
        public final Application e;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class b implements d50.c {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            d50.a aVar = d50.b;
            h = new b();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            application.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.x.d, androidx.lifecycle.x.c
        public c45 a(Class cls) {
            cls.getClass();
            Application application = this.e;
            if (application != null) {
                return h(cls, application);
            }
            fn.a("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.x.d, androidx.lifecycle.x.c
        public c45 b(Class cls, d50 d50Var) {
            cls.getClass();
            d50Var.getClass();
            if (this.e != null) {
                return a(cls);
            }
            Application application = (Application) d50Var.a(h);
            if (application != null) {
                return h(cls, application);
            }
            if (!g6.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            jl.a("CreationExtras must have an application by `APPLICATION_KEY`");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final c45 h(Class cls, Application application) {
            if (!g6.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                c45 c45Var = (c45) cls.getConstructor(Application.class).newInstance(application);
                c45Var.getClass();
                return c45Var;
            } catch (IllegalAccessException e) {
                wo3.a("Cannot create an instance of ", cls, e);
                return null;
            } catch (InstantiationException e2) {
                wo3.a("Cannot create an instance of ", cls, e2);
                return null;
            } catch (NoSuchMethodException e3) {
                wo3.a("Cannot create an instance of ", cls, e3);
                return null;
            } catch (InvocationTargetException e4) {
                wo3.a("Cannot create an instance of ", cls, e4);
                return null;
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.x$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0014a {
            /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: androidx.lifecycle.x.a.a.<init>():void type: THIS */
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public /* synthetic */ C0014a(we0 we0Var) {
                this();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final a a(Application application) {
                application.getClass();
                if (a.g == null) {
                    a.g = new a(application);
                }
                a aVar = a.g;
                aVar.getClass();
                return aVar;
            }

            public C0014a() {
            }
        }

        public a() {
            this(null, 0);
        }

        public a(Application application, int i) {
            this.e = application;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements c {
        public static d c;
        public static final a b = new a(null);
        public static final d50.c d = x.c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.x.c
        public c45 a(Class cls) {
            cls.getClass();
            return fp1.a.a(cls);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.x.c
        public c45 b(Class cls, d50 d50Var) {
            cls.getClass();
            d50Var.getClass();
            return a(cls);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.x.c
        public c45 c(hp1 hp1Var, d50 d50Var) {
            hp1Var.getClass();
            d50Var.getClass();
            return b(dp1.a(hp1Var), d50Var);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: androidx.lifecycle.x.d.a.<init>():void type: THIS */
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public /* synthetic */ a(we0 we0Var) {
                this();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public final d a() {
                if (d.c == null) {
                    d.c = new d();
                }
                d dVar = d.c;
                dVar.getClass();
                return dVar;
            }

            public a() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: androidx.lifecycle.x.b.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ b(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ x b(b bVar, l45 l45Var, c cVar, d50 d50Var, int i, Object obj) {
            if ((i & 2) != 0) {
                cVar = j45.a.b(l45Var);
            }
            if ((i & 4) != 0) {
                d50Var = j45.a.a(l45Var);
            }
            return bVar.a(l45Var, cVar, d50Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final x a(l45 l45Var, c cVar, d50 d50Var) {
            l45Var.getClass();
            cVar.getClass();
            d50Var.getClass();
            return new x(l45Var.d0(), cVar, d50Var);
        }

        public b() {
        }
    }

    public x(h45 h45Var) {
        this.a = h45Var;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: CONSTRUCTOR 
      (r1v0 k45)
      (r2v0 androidx.lifecycle.x$c)
      (wrap:d50:?: TERNARY null = ((wrap:int:0x0000: ARITH (r4v0 int) & (4 int) A[WRAPPED]) != (0 int)) ? (wrap:d50:0x0004: SGET  A[WRAPPED] (LINE:24) d50.b.c d50$b) : (r3v0 d50))
     A[MD:(k45, androidx.lifecycle.x$c, d50):void (m)] (LINE:25) call: androidx.lifecycle.x.<init>(k45, androidx.lifecycle.x$c, d50):void type: THIS */
    public /* synthetic */ x(k45 k45Var, c cVar, d50 d50Var, int i, we0 we0Var) {
        this(k45Var, cVar, (i & 4) != 0 ? d50.b.c : d50Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(k45 k45Var, c cVar, d50 d50Var) {
        this(new h45(k45Var, cVar, d50Var));
        k45Var.getClass();
        cVar.getClass();
        d50Var.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(k45 k45Var, c cVar) {
        this(k45Var, cVar, null, 4, null);
        k45Var.getClass();
        cVar.getClass();
    }
}
