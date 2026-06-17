package defpackage;

import defpackage.wf4;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class da3 extends wf4 {
    public y93 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public da3(int i, y93 y93Var) {
        super(i, "PeerTube", EnumSet.of(wf4.b.a.VIDEO, wf4.b.a.COMMENTS));
        this.c = y93Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public gu1 a() {
        return x93.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public gu1 e() {
        return ca3.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public ue4 g(vt1 vt1Var) {
        return new ga3(this, vt1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wf4
    public wt1 i() {
        return ia3.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String m() {
        return this.c.a();
    }

    public da3(int i) {
        this(i, y93.c);
    }
}
