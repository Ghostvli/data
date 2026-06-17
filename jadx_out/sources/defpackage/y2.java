package defpackage;

import android.os.Process;
import defpackage.zs0;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class y2 {
    public final boolean a;
    public final Executor b;
    public final Map c;
    public final ReferenceQueue d;
    public zs0.a e;
    public volatile boolean f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: y2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class RunnableC0136a implements Runnable {
            public final /* synthetic */ Runnable f;

            public RunnableC0136a(Runnable runnable) {
                this.f = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0136a(runnable), "glide-active-resources");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y2.this.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends WeakReference {
        public final wq1 a;
        public final boolean b;
        public yr3 c;

        public c(wq1 wq1Var, zs0 zs0Var, ReferenceQueue referenceQueue, boolean z) {
            super(zs0Var, referenceQueue);
            this.a = (wq1) fg3.e(wq1Var);
            this.c = (zs0Var.f() && z) ? (yr3) fg3.e(zs0Var.e()) : null;
            this.b = zs0Var.f();
        }

        public void a() {
            this.c = null;
            clear();
        }
    }

    public y2(boolean z, Executor executor) {
        this.c = new HashMap();
        this.d = new ReferenceQueue();
        this.a = z;
        this.b = executor;
        executor.execute(new b());
    }

    public synchronized void a(wq1 wq1Var, zs0 zs0Var) {
        c cVar = (c) this.c.put(wq1Var, new c(wq1Var, zs0Var, this.d, this.a));
        if (cVar != null) {
            cVar.a();
        }
    }

    public void b() {
        while (!this.f) {
            try {
                c((c) this.d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(c cVar) {
        yr3 yr3Var;
        synchronized (this) {
            this.c.remove(cVar.a);
            if (cVar.b && (yr3Var = cVar.c) != null) {
                this.e.a(cVar.a, new zs0(yr3Var, true, false, cVar.a, this.e));
            }
        }
    }

    public synchronized void d(wq1 wq1Var) {
        c cVar = (c) this.c.remove(wq1Var);
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized zs0 e(wq1 wq1Var) {
        c cVar = (c) this.c.get(wq1Var);
        if (cVar == null) {
            return null;
        }
        zs0 zs0Var = (zs0) cVar.get();
        if (zs0Var == null) {
            c(cVar);
        }
        return zs0Var;
    }

    public void f(zs0.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.e = aVar;
            }
        }
    }

    public y2(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new a()));
    }
}
