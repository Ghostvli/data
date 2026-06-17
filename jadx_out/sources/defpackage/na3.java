package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class na3 {
    public final String a;
    public final long b;
    public final List c;
    public final List d;
    public final rj0 e;

    public na3(String str, long j, List list, List list2, rj0 rj0Var) {
        this.a = str;
        this.b = j;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = rj0Var;
    }

    public int a(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((y3) this.c.get(i2)).b == i) {
                return i2;
            }
        }
        return -1;
    }

    public na3(String str, long j, List list, List list2) {
        this(str, j, list, list2, null);
    }
}
