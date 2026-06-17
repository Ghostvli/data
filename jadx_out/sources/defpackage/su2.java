package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class su2 {
    public final int a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends su2 {
        public final long b;
        public final List c;
        public final List d;

        public b(int i, long j) {
            super(i);
            this.b = j;
            this.c = new ArrayList();
            this.d = new ArrayList();
        }

        public void b(b bVar) {
            this.d.add(bVar);
        }

        public void c(c cVar) {
            this.c.add(cVar);
        }

        public b d(int i) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.d.get(i2);
                if (bVar.a == i) {
                    return bVar;
                }
            }
            return null;
        }

        public c e(int i) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = (c) this.c.get(i2);
                if (cVar.a == i) {
                    return cVar;
                }
            }
            return null;
        }

        @Override // defpackage.su2
        public String toString() {
            return su2.a(this.a) + " leaves: " + Arrays.toString(this.c.toArray()) + " containers: " + Arrays.toString(this.d.toArray());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends su2 {
        public final r73 b;

        public c(int i, r73 r73Var) {
            super(i);
            this.b = r73Var;
        }
    }

    public su2(int i) {
        this.a = i;
    }

    public static String a(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public String toString() {
        return a(this.a);
    }
}
