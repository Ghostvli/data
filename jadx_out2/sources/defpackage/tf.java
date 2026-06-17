package defpackage;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class tf implements Runnable, ag3 {
    public final ka3 f = new ka3();
    public final uu0 g;
    public volatile boolean h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tf(uu0 uu0Var) {
        this.g = uu0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ag3
    public void a(sh4 sh4Var, Object obj) {
        ja3 ja3VarA = ja3.a(sh4Var, obj);
        synchronized (this) {
            try {
                this.f.a(ja3VarA);
                if (!this.h) {
                    this.h = true;
                    this.g.e().execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public void run() {
        ja3 ja3VarC;
        while (true) {
            try {
                try {
                    ja3VarC = this.f.c(1000);
                } catch (InterruptedException e) {
                    this.g.f().b(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.h = false;
                    return;
                }
            } catch (Throwable th) {
                this.h = false;
                throw th;
            }
            if (ja3VarC == null) {
                synchronized (this) {
                    ja3VarC = this.f.b();
                    if (ja3VarC == null) {
                        this.h = false;
                        this.h = false;
                        return;
                    }
                    this.h = false;
                    throw th;
                }
            }
            this.g.h(ja3VarC);
        }
    }
}
