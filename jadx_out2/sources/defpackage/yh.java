package defpackage;

import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yh {
    public final Queue a = iy4.g(20);

    public abstract nf3 a();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nf3 b() {
        nf3 nf3Var = (nf3) this.a.poll();
        return nf3Var == null ? a() : nf3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(nf3 nf3Var) {
        if (this.a.size() < 20) {
            this.a.offer(nf3Var);
        }
    }
}
