package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ca extends wl4 {
    public static volatile ca c;
    public static final Executor d = new Executor() { // from class: aa
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ca.g().c(runnable);
        }
    };
    public static final Executor e = new Executor() { // from class: ba
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ca.g().a(runnable);
        }
    };
    public wl4 a;
    public final wl4 b;

    public ca() {
        ci0 ci0Var = new ci0();
        this.b = ci0Var;
        this.a = ci0Var;
    }

    public static Executor f() {
        return e;
    }

    public static ca g() {
        if (c != null) {
            return c;
        }
        synchronized (ca.class) {
            try {
                if (c == null) {
                    c = new ca();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c;
    }

    @Override // defpackage.wl4
    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    @Override // defpackage.wl4
    public boolean b() {
        return this.a.b();
    }

    @Override // defpackage.wl4
    public void c(Runnable runnable) {
        this.a.c(runnable);
    }
}
