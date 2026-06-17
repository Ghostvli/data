package defpackage;

import defpackage.wf4;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class r72 extends wf4 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r72(int i) {
        super(i, "media.ccc.de", EnumSet.of(wf4.b.a.AUDIO, wf4.b.a.VIDEO));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public gu1 a() {
        return d72.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public gu1 e() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public ue4 g(vt1 vt1Var) {
        return q72.f(vt1Var.b()) ? new p72(this, vt1Var) : new t72(this, vt1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public wt1 i() {
        return u72.i();
    }
}
