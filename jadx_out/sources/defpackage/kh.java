package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kh {
    public abstract Long a(Object obj);

    public abstract List b(List list);

    public void c(Object obj) {
        if (a(obj).longValue() == -1) {
            e(obj);
        }
    }

    public void d(List list) {
        if (list.isEmpty()) {
            return;
        }
        List listB = b(list);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < listB.size(); i++) {
            if (((Long) listB.get(i)).longValue() == -1) {
                arrayList.add(list.get(i));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        f(arrayList);
    }

    public abstract void e(Object obj);

    public abstract void f(List list);
}
