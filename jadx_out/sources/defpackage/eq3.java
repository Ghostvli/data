package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface eq3 extends Executor {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements eq3 {
        public final /* synthetic */ Executor f;
        public final /* synthetic */ g20 g;

        public a(Executor executor, g20 g20Var) {
            this.f = executor;
            this.g = g20Var;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f.execute(runnable);
        }

        @Override // defpackage.eq3
        public void release() {
            this.g.accept(this.f);
        }
    }

    static eq3 L(Executor executor, g20 g20Var) {
        return new a(executor, g20Var);
    }

    void release();
}
