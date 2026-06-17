package defpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class or3 extends zi {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public or3(oa3 oa3Var) {
        super(oa3Var);
        oa3Var.getClass();
    }

    @Override // defpackage.kr
    public void a(List list) {
        list.getClass();
        HashSet hashSet = new HashSet(this.a.l);
        hashSet.addAll(list);
        if (hashSet.isEmpty()) {
            b();
        } else {
            this.a.n(hashSet, this);
        }
    }

    @Override // defpackage.kr
    public void request() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.a.g) {
            if (ua3.d(this.a.b(), str)) {
                this.a.l.add(str);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            b();
            return;
        }
        oa3 oa3Var = this.a;
        if (oa3Var.i) {
            oa3Var.getClass();
            this.a.getClass();
        }
        oa3 oa3Var2 = this.a;
        oa3Var2.n(oa3Var2.g, this);
    }
}
