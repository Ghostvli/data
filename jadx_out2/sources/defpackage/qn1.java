package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qn1 extends sz1 implements qm0, gj1 {
    public sn1 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gj1
    public o33 b() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gj1
    public boolean c() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qm0
    public void e() {
        v().C0(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.sz1
    public String toString() {
        return ua0.a(this) + '@' + ua0.b(this) + "[job@" + ua0.b(v()) + ']';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sn1 v() {
        sn1 sn1Var = this.i;
        if (sn1Var != null) {
            return sn1Var;
        }
        il1.j("job");
        return null;
    }

    public abstract boolean w();

    public abstract void x(Throwable th);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y(sn1 sn1Var) {
        this.i = sn1Var;
    }
}
