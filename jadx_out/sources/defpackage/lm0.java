package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class lm0 implements Executor {
    public final n40 f;

    public lm0(n40 n40Var) {
        this.f = n40Var;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        n40 n40Var = this.f;
        bs0 bs0Var = bs0.f;
        if (n40Var.d0(bs0Var)) {
            this.f.c0(bs0Var, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f.toString();
    }
}
