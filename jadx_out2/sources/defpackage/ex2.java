package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ex2 extends n40 implements gj0 {
    public final /* synthetic */ gj0 h;
    public final n40 i;
    public final String j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: n40 */
    /* JADX WARN: Multi-variable type inference failed */
    public ex2(n40 n40Var, String str) {
        gj0 gj0Var = n40Var instanceof gj0 ? (gj0) n40Var : null;
        this.h = gj0Var == null ? rf0.a() : gj0Var;
        this.i = n40Var;
        this.j = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gj0
    public void F(long j, qp qpVar) {
        this.h.F(j, qpVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n40
    public void c0(g40 g40Var, Runnable runnable) {
        this.i.c0(g40Var, runnable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n40
    public boolean d0(g40 g40Var) {
        return this.i.d0(g40Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.n40
    public String toString() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gj0
    public qm0 y(long j, Runnable runnable, g40 g40Var) {
        return this.h.y(j, runnable, g40Var);
    }
}
