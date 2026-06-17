package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ty3 extends w implements x40 {
    public final f30 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ty3(g40 g40Var, f30 f30Var) {
        super(g40Var, true, true);
        this.i = f30Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.w
    public void O0(Object obj) {
        f30 f30Var = this.i;
        f30Var.resumeWith(cy.a(obj, f30Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x40
    public final x40 getCallerFrame() {
        f30 f30Var = this.i;
        if (f30Var instanceof x40) {
            return (x40) f30Var;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sn1
    public final boolean n0() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sn1
    public void q(Object obj) {
        hm0.b(jl1.c(this.i), cy.a(obj, this.i));
    }
}
