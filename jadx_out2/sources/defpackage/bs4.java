package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bs4 implements Executor {
    public final Executor f;
    public final ArrayDeque g;
    public Runnable h;
    public final Object i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bs4(Executor executor) {
        executor.getClass();
        this.f = executor;
        this.g = new ArrayDeque();
        this.i = new Object();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(Runnable runnable, bs4 bs4Var) {
        try {
            runnable.run();
        } finally {
            bs4Var.b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b() {
        synchronized (this.i) {
            try {
                Object objPoll = this.g.poll();
                Runnable runnable = (Runnable) objPoll;
                this.h = runnable;
                if (objPoll != null) {
                    this.f.execute(runnable);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        runnable.getClass();
        synchronized (this.i) {
            try {
                this.g.offer(new Runnable() { // from class: as4
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        bs4.a(runnable, this);
                    }
                });
                if (this.h == null) {
                    b();
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
