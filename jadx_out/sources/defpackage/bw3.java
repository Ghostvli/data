package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bw3 {
    public List a;
    public List b;
    public boolean c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile bw3 a = new bw3();
    }

    public bw3() {
        List list = Collections.EMPTY_LIST;
        this.a = list;
        this.b = list;
    }

    public static bw3 a() {
        return a.a;
    }

    public List b() {
        if (this.c) {
            e();
        }
        return this.a;
    }

    public List c() {
        if (this.c) {
            e();
        }
        return this.b;
    }

    public void d() {
        this.c = true;
    }

    public final void e() {
        ArrayList arrayList = new ArrayList(b75.I().J());
        arrayList.addAll(lx1.J().K());
        this.a = arrayList;
        ArrayList arrayList2 = new ArrayList(b75.I().V());
        arrayList2.addAll(lx1.J().R());
        this.b = arrayList2;
        this.c = false;
    }
}
