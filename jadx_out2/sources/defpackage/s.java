package defpackage;

import defpackage.p31;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s extends p31.a implements Runnable {
    public lu1 m;
    public Class n;
    public Object o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends s {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(lu1 lu1Var, Class cls, p81 p81Var) {
            super(lu1Var, cls, p81Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.s
        public void V(Object obj) {
            M(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: U(Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object; */
        @Override // defpackage.s
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public Object U(p81 p81Var, Throwable th) {
            return p81Var.apply(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s(lu1 lu1Var, Class cls, Object obj) {
        this.m = (lu1) gg3.q(lu1Var);
        this.n = (Class) gg3.q(cls);
        this.o = gg3.q(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lu1 T(lu1 lu1Var, Class cls, p81 p81Var, Executor executor) {
        a aVar = new a(lu1Var, cls, p81Var);
        lu1Var.g(aVar, du2.d(executor, aVar));
        return aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b0
    public String L() {
        String str;
        lu1 lu1Var = this.m;
        Class cls = this.n;
        Object obj = this.o;
        String strL = super.L();
        if (lu1Var != null) {
            str = "inputFuture=[" + lu1Var + "], ";
        } else {
            str = "";
        }
        if (cls == null || obj == null) {
            if (strL != null) {
                return str.concat(strL);
            }
            return null;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + obj + "]";
    }

    public abstract Object U(Object obj, Throwable th);

    public abstract void V(Object obj);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: lu1 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        lu1 lu1Var = this.m;
        Class cls = this.n;
        Object obj = this.o;
        if (((obj == null) || ((lu1Var == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.m = null;
        try {
            th = lu1Var instanceof el1 ? fl1.a((el1) lu1Var) : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + lu1Var.getClass() + " threw " + e.getClass() + " without a cause");
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        Object objC = th == null ? x81.c(lu1Var) : null;
        if (th == null) {
            M(o43.a(objC));
            return;
        }
        if (!ob3.d(th, cls)) {
            O(lu1Var);
            return;
        }
        try {
            Object objU = U(obj, th);
            this.n = null;
            this.o = null;
            V(objU);
        } catch (Throwable th2) {
            try {
                ob3.e(th2);
                N(th2);
            } finally {
                this.n = null;
                this.o = null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b0
    public final void y() {
        J(this.m);
        this.m = null;
        this.n = null;
        this.o = null;
    }
}
