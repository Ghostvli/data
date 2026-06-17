package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class zv2 extends xj1 {
    public final af4 e;
    public final as f;
    public final ze3 g;

    public zv2(int i) {
        super(i);
        this.e = new af4(i);
        this.f = new as(i);
        this.g = new ze3(i);
    }

    @Override // defpackage.xj1
    public List e() {
        ArrayList arrayList = new ArrayList(super.e());
        arrayList.addAll(this.e.e());
        arrayList.addAll(this.f.e());
        arrayList.addAll(this.g.e());
        return Collections.unmodifiableList(arrayList);
    }

    @Override // defpackage.yw
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public vj1 a(wj1 wj1Var) {
        if (wj1Var instanceof ze4) {
            return this.e.a((ze4) wj1Var);
        }
        if (wj1Var instanceof ye3) {
            return this.g.a((ye3) wj1Var);
        }
        c.a("Invalid extractor type: ", wj1Var);
        return null;
    }
}
