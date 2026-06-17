package defpackage;

import defpackage.wf4;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ua4 extends wf4 {
    public ua4(int i) {
        super(i, "SoundCloud", EnumSet.of(wf4.b.a.AUDIO, wf4.b.a.COMMENTS));
    }

    @Override // defpackage.wf4
    public gu1 a() {
        return pa4.n();
    }

    @Override // defpackage.wf4
    public gu1 e() {
        return ta4.n();
    }

    @Override // defpackage.wf4
    public ue4 g(vt1 vt1Var) {
        return new wa4(this, vt1Var);
    }

    @Override // defpackage.wf4
    public wt1 i() {
        return ya4.i();
    }

    @Override // defpackage.wf4
    public List j() {
        return m20.b("AU", "CA", "DE", "FR", "GB", "IE", "NL", "NZ", "US");
    }
}
