package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class t22 {
    public static Executor e;
    public final Set a;
    public final Set b;
    public final Handler c;
    public volatile r22 d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends FutureTask {
        public t22 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(t22 t22Var, Callable callable) {
            super(callable);
            this.f = t22Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                if (isCancelled()) {
                    return;
                }
                try {
                    this.f.l((r22) get());
                } catch (InterruptedException | ExecutionException e) {
                    this.f.l(new r22(e));
                }
            } finally {
                this.f = null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        if ("true".equals(System.getProperty("lottie.testing.directExecutor"))) {
            e = new gh3();
        } else {
            e = Executors.newCachedThreadPool(new u22());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t22(Callable callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (!z) {
            e.execute(new a(this, callable));
            return;
        }
        try {
            l((r22) callable.call());
        } catch (Throwable th) {
            l(new r22(th));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized t22 c(m22 m22Var) {
        try {
            r22 r22Var = this.d;
            if (r22Var != null && r22Var.a() != null) {
                m22Var.onResult(r22Var.a());
            }
            this.b.add(m22Var);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized t22 d(m22 m22Var) {
        try {
            r22 r22Var = this.d;
            if (r22Var != null && r22Var.b() != null) {
                m22Var.onResult(r22Var.b());
            }
            this.a.add(m22Var);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r22 e() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            k02.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((m22) it.next()).onResult(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h();
        } else {
            this.c.post(new Runnable() { // from class: s22
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.h();
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        r22 r22Var = this.d;
        if (r22Var == null) {
            return;
        }
        if (r22Var.b() != null) {
            i(r22Var.b());
        } else {
            f(r22Var.a());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized void i(Object obj) {
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((m22) it.next()).onResult(obj);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized t22 j(m22 m22Var) {
        this.b.remove(m22Var);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized t22 k(m22 m22Var) {
        this.a.remove(m22Var);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(r22 r22Var) {
        if (this.d != null) {
            e04.a("A task may only be set once.");
        } else {
            this.d = r22Var;
            g();
        }
    }

    public t22(Object obj) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        l(new r22(obj));
    }

    public t22(Callable callable) {
        this(callable, false);
    }
}
