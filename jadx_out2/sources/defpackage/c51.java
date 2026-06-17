package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c51 extends b51 implements lu1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a extends c51 {
        public final lu1 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(lu1 lu1Var) {
            this.f = (lu1) gg3.q(lu1Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a()Ljava/lang/Object; */
        /* JADX DEBUG: Method merged with bridge method: b()Ljava/util/concurrent/Future; */
        @Override // defpackage.b51
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final lu1 b() {
            return this.f;
        }
    }

    /* JADX INFO: renamed from: e */
    public abstract lu1 a();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.lu1
    public void g(Runnable runnable, Executor executor) {
        a().g(runnable, executor);
    }
}
