package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tt {
    public final Map a = new LinkedHashMap();

    public void a(st stVar) {
        long[] jArr = stVar.e;
        if (jArr.length <= 0 || this.a.containsKey(Long.valueOf(jArr[0]))) {
            return;
        }
        this.a.put(Long.valueOf(stVar.e[0]), stVar);
    }

    public st b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (st stVar : this.a.values()) {
            arrayList.add(stVar.b);
            arrayList2.add(stVar.c);
            arrayList3.add(stVar.d);
            arrayList4.add(stVar.e);
        }
        return new st(ll1.f((int[][]) arrayList.toArray(new int[arrayList.size()][])), y02.b((long[][]) arrayList2.toArray(new long[arrayList2.size()][])), y02.b((long[][]) arrayList3.toArray(new long[arrayList3.size()][])), y02.b((long[][]) arrayList4.toArray(new long[arrayList4.size()][])));
    }

    public int c() {
        return this.a.size();
    }
}
