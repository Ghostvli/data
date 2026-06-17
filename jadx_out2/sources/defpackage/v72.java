package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v72 extends pt {
    public final long j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v72(aa0 aa0Var, ja0 ja0Var, t41 t41Var, int i, Object obj, long j, long j2, long j3) {
        super(aa0Var, ja0Var, 1, t41Var, i, obj, j, j2);
        gg3.q(t41Var);
        this.j = j3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long g() {
        long j = this.j;
        if (j != -1) {
            return j + 1;
        }
        return -1L;
    }

    public abstract boolean h();
}
