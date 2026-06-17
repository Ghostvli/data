package defpackage;

import defpackage.wf4;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ig extends wf4 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ig(int i) {
        super(i, "Bandcamp", EnumSet.of(wf4.b.a.AUDIO, wf4.b.a.COMMENTS));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public gu1 a() {
        return bg.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public gu1 e() {
        return eg.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public ue4 g(vt1 vt1Var) {
        return dg.h(vt1Var.d()) ? new gg(this, vt1Var) : new ng(this, vt1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public wt1 i() {
        return og.i();
    }
}
