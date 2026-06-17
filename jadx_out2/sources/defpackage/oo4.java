package defpackage;

import defpackage.fg2;
import defpackage.no4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class oo4 extends i51 {
    public final fg2 f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public oo4(no4 no4Var, fg2 fg2Var) {
        super(no4Var);
        this.f = fg2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static oo4 z(no4 no4Var, fg2 fg2Var) {
        return no4Var instanceof oo4 ? new oo4(((oo4) no4Var).e, fg2Var) : new oo4(no4Var, fg2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.i51, defpackage.no4
    public no4.d u(int i, no4.d dVar, long j) {
        super.u(i, dVar, j);
        fg2 fg2Var = this.f;
        dVar.c = fg2Var;
        fg2.h hVar = fg2Var.b;
        dVar.b = hVar != null ? hVar.i : null;
        return dVar;
    }
}
