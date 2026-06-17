package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface vt2 {
    boolean a(Object obj);

    a b(Object obj, int i, int i2, u63 u63Var);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final wq1 a;
        public final List b;
        public final t90 c;

        public a(wq1 wq1Var, List list, t90 t90Var) {
            this.a = (wq1) fg3.e(wq1Var);
            this.b = (List) fg3.e(list);
            this.c = (t90) fg3.e(t90Var);
        }

        public a(wq1 wq1Var, t90 t90Var) {
            this(wq1Var, Collections.EMPTY_LIST, t90Var);
        }
    }
}
