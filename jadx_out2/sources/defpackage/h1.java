package defpackage;

import defpackage.p31;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h1 extends p31.a implements Runnable {
    public lu1 m;
    public Object n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends h1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(lu1 lu1Var, p81 p81Var) {
            super(lu1Var, p81Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h1
        public void V(Object obj) {
            M(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: U(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // defpackage.h1
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public Object U(p81 p81Var, Object obj) {
            return p81Var.apply(obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h1(lu1 lu1Var, Object obj) {
        this.m = (lu1) gg3.q(lu1Var);
        this.n = gg3.q(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lu1 T(lu1 lu1Var, p81 p81Var, Executor executor) {
        a aVar = new a(lu1Var, p81Var);
        lu1Var.g(aVar, du2.d(executor, aVar));
        return aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b0
    public String L() {
        String str;
        lu1 lu1Var = this.m;
        Object obj = this.n;
        String strL = super.L();
        if (lu1Var != null) {
            str = "inputFuture=[" + lu1Var + "], ";
        } else {
            str = "";
        }
        if (obj == null) {
            if (strL != null) {
                return str.concat(strL);
            }
            return null;
        }
        return str + "function=[" + obj + "]";
    }

    public abstract Object U(Object obj, Object obj2);

    public abstract void V(Object obj);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public final void run() {
        lu1 lu1Var = this.m;
        Object obj = this.n;
        if ((isCancelled() | (lu1Var == null)) || (obj == null)) {
            return;
        }
        this.m = null;
        if (lu1Var.isCancelled()) {
            O(lu1Var);
            return;
        }
        try {
            try {
                Object objU = U(obj, x81.c(lu1Var));
                this.n = null;
                V(objU);
            } catch (Throwable th) {
                try {
                    ob3.e(th);
                    N(th);
                } finally {
                    this.n = null;
                }
            }
        } catch (Error e) {
            N(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e2) {
            N(e2.getCause());
        } catch (Exception e3) {
            N(e3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b0
    public final void y() {
        J(this.m);
        this.m = null;
        this.n = null;
    }
}
