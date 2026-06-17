package defpackage;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends c0 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final a c;
        public static final a d;
        public final boolean a;
        public final Throwable b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            if (c0.k) {
                d = null;
                c = null;
            } else {
                d = new a(false, null);
                c = new a(true, null);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements Runnable {
        public final b0 f;
        public final lu1 g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(b0 b0Var, lu1 lu1Var) {
            this.f = b0Var;
            this.g = lu1Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f.t() != this) {
                return;
            }
            if (c0.j(this.f, this, b0.G(this.g))) {
                b0.D(this.f, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public static final c b = new c(new a("Failure occurred while trying to finish a future."));
        public final Throwable a;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends Throwable {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(String str) {
                super(str);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                return this;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Throwable th) {
            this.a = (Throwable) gg3.q(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e extends lu1 {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static CancellationException B(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void D(b0 b0Var, boolean z) {
        d dVar = null;
        while (true) {
            b0Var.r();
            if (z) {
                b0Var.I();
                z = false;
            }
            b0Var.y();
            d dVarC = b0Var.C(dVar);
            while (dVarC != null) {
                dVar = dVarC.c;
                Runnable runnable = dVarC.a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof b) {
                    b bVar = (b) runnable2;
                    b0Var = bVar.f;
                    if (b0Var.t() != bVar || !c0.j(b0Var, bVar, G(bVar.g))) {
                    }
                } else {
                    Executor executor = dVarC.b;
                    Objects.requireNonNull(executor);
                    E(runnable2, executor);
                }
                dVarC = dVar;
            }
            return;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void E(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            c0.j.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object F(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            throw B("Task was cancelled.", ((a) obj).b);
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).a);
        }
        return obj == c0.i ? o43.b() : obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: lu1 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object G(lu1 lu1Var) {
        Throwable thA;
        if (lu1Var instanceof e) {
            Object objT = ((b0) lu1Var).t();
            if (objT instanceof a) {
                a aVar = (a) objT;
                if (aVar.a) {
                    objT = aVar.b != null ? new a(false, aVar.b) : a.d;
                }
            }
            Objects.requireNonNull(objT);
            return objT;
        }
        if ((lu1Var instanceof el1) && (thA = fl1.a((el1) lu1Var)) != null) {
            return new c(thA);
        }
        boolean zIsCancelled = lu1Var.isCancelled();
        if ((!c0.k) && zIsCancelled) {
            a aVar2 = a.d;
            Objects.requireNonNull(aVar2);
            return aVar2;
        }
        try {
            Object objH = H(lu1Var);
            if (!zIsCancelled) {
                return objH == null ? c0.i : objH;
            }
            return new a(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + lu1Var));
        } catch (Error | Exception e2) {
            return new c(e2);
        } catch (CancellationException e3) {
            if (zIsCancelled) {
                return new a(false, e3);
            }
            return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + lu1Var, e3));
        } catch (ExecutionException e4) {
            if (!zIsCancelled) {
                return new c(e4.getCause());
            }
            return new a(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + lu1Var, e4));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object H(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    ob3.c();
                }
                throw th;
            }
        }
        if (z) {
            ob3.c();
        }
        return obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean K(Object obj) {
        return !(obj instanceof b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Throwable th) {
            ob3.f(th);
            sb.append("Exception thrown from implementation: ");
            sb.append(th.getClass());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final d C(d dVar) {
        d dVarL = l(d.d);
        d dVar2 = dVar;
        while (dVarL != null) {
            d dVar3 = dVarL.c;
            dVarL.c = dVar2;
            dVar2 = dVarL;
            dVarL = dVar3;
        }
        return dVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(P());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: b0 */
    /* JADX WARN: Multi-variable type inference failed */
    public String L() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean M(Object obj) {
        if (obj == null) {
            obj = c0.i;
        }
        if (!c0.j(this, null, obj)) {
            return false;
        }
        D(this, false);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean N(Throwable th) {
        if (!c0.j(this, null, new c((Throwable) gg3.q(th)))) {
            return false;
        }
        D(this, false);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean O(lu1 lu1Var) {
        c cVar;
        gg3.q(lu1Var);
        Object objT = t();
        if (objT == null) {
            if (lu1Var.isDone()) {
                if (!c0.j(this, null, G(lu1Var))) {
                    return false;
                }
                D(this, false);
                return true;
            }
            b bVar = new b(this, lu1Var);
            if (c0.j(this, null, bVar)) {
                try {
                    lu1Var.g(bVar, tl0.INSTANCE);
                } catch (Throwable th) {
                    try {
                        cVar = new c(th);
                    } catch (Error | Exception unused) {
                        cVar = c.b;
                    }
                    c0.j(this, bVar, cVar);
                }
                return true;
            }
            objT = t();
        }
        if (objT instanceof a) {
            lu1Var.cancel(((a) objT).a);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean P() {
        Object objT = t();
        return (objT instanceof a) && ((a) objT).a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.el1
    public final Throwable c() {
        if (!(this instanceof e)) {
            return null;
        }
        Object objT = t();
        if (objT instanceof c) {
            return ((c) objT).a;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean cancel(boolean z) {
        a aVar;
        Object objT = t();
        if (!(objT == null) && !(objT instanceof b)) {
            return false;
        }
        if (c0.k) {
            aVar = new a(z, new CancellationException("Future.cancel() was called."));
        } else {
            aVar = z ? a.c : a.d;
            Objects.requireNonNull(aVar);
        }
        boolean z2 = false;
        while (true) {
            if (c0.j(this, objT, aVar)) {
                D(this, z);
                if (!(objT instanceof b)) {
                    break;
                }
                lu1 lu1Var = ((b) objT).g;
                if (!(lu1Var instanceof e)) {
                    lu1Var.cancel(z);
                    break;
                }
                this = (b0) lu1Var;
                objT = this.t();
                if (!(objT == null) && !(objT instanceof b)) {
                    break;
                }
                z2 = true;
            } else {
                objT = this.t();
                if (K(objT)) {
                    return z2;
                }
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(Runnable runnable, Executor executor) {
        d dVarN;
        gg3.r(runnable, "Runnable was null.");
        gg3.r(executor, "Executor was null.");
        if (!isDone() && (dVarN = n()) != d.d) {
            d dVar = new d(runnable, executor);
            do {
                dVar.c = dVarN;
                if (i(dVarN, dVar)) {
                    return;
                } else {
                    dVarN = n();
                }
            } while (dVarN != d.d);
        }
        E(runnable, executor);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object get(long j, TimeUnit timeUnit) {
        return ob3.b(this, j, timeUnit);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isCancelled() {
        return t() instanceof a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isDone() {
        Object objT = t();
        return K(objT) & (objT != null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            w(sb);
        } else {
            x(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w(StringBuilder sb) {
        try {
            Object objH = H(this);
            sb.append("SUCCESS, result=[");
            z(sb, objH);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (Exception e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x(StringBuilder sb) {
        String strA;
        int length = sb.length();
        sb.append("PENDING");
        Object objT = t();
        if (objT instanceof b) {
            sb.append(", setFuture=[");
            A(sb, ((b) objT).g);
            sb.append("]");
        } else {
            try {
                strA = gg4.a(L());
            } catch (Throwable th) {
                ob3.f(th);
                strA = "Exception thrown from implementation: " + th.getClass();
            }
            if (strA != null) {
                sb.append(", info=[");
                sb.append(strA);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            w(sb);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class f extends b0 implements e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.b0, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return super.cancel(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.b0, defpackage.lu1
        public void g(Runnable runnable, Executor executor) {
            super.g(runnable, executor);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.b0, java.util.concurrent.Future
        public Object get() {
            return super.get();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.b0, java.util.concurrent.Future
        public boolean isCancelled() {
            return super.isCancelled();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.b0, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // defpackage.b0, java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) {
            return super.get(j, timeUnit);
        }
    }

    public Object get() {
        return ob3.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public static final d d = new d();
        public final Runnable a;
        public final Executor b;
        public d c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
            this.a = null;
            this.b = null;
        }

        public d(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }
}
