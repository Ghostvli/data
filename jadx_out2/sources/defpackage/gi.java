package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gi extends v72 {
    public final long k;
    public final long l;
    public ii m;
    public int[] n;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gi(aa0 aa0Var, ja0 ja0Var, t41 t41Var, int i, Object obj, long j, long j2, long j3, long j4, long j5) {
        super(aa0Var, ja0Var, t41Var, i, obj, j, j2, j5);
        this.k = j3;
        this.l = j4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int i(int i) {
        return ((int[]) gg3.q(this.n))[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ii j() {
        return (ii) gg3.q(this.m);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(ii iiVar) {
        this.m = iiVar;
        this.n = iiVar.a();
    }
}
