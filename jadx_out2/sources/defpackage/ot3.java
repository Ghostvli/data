package defpackage;

import defpackage.kt3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ot3 extends qn1 {
    public final f30 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ot3(f30 f30Var) {
        this.j = f30Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qn1
    public boolean w() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qn1
    public void x(Throwable th) {
        f30 f30Var = this.j;
        kt3.a aVar = kt3.g;
        f30Var.resumeWith(kt3.b(fw4.a));
    }
}
