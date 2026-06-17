package defpackage;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface wt4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final String a;
        public final int b;
        public final byte[] c;

        public a(String str, int i, byte[] bArr) {
            this.a = str;
            this.b = i;
            this.c = bArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final String b;
        public final int c;
        public final List d;
        public final byte[] e;

        public b(int i, String str, int i2, List list, byte[] bArr) {
            this.a = i;
            this.b = str;
            this.c = i2;
            this.d = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
            this.e = bArr;
        }

        public int a() {
            int i = this.c;
            if (i != 2) {
                return i != 3 ? 0 : 512;
            }
            return 2048;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        SparseArray a();

        wt4 b(int i, b bVar);
    }

    void a(r73 r73Var, int i);

    void b(yo4 yo4Var, mz0 mz0Var, d dVar);

    void c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final String a;
        public final int b;
        public final int c;
        public int d;
        public String e;

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + ServiceReference.DELIMITER;
            } else {
                str = "";
            }
            this.a = str;
            this.b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
            this.e = "";
        }

        public void a() {
            int i = this.d;
            this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
            this.e = this.a + this.d;
        }

        public String b() {
            d();
            return this.e;
        }

        public int c() {
            d();
            return this.d;
        }

        public final void d() {
            if (this.d != Integer.MIN_VALUE) {
                return;
            }
            e04.a("generateNewId() must be called before retrieving ids.");
        }

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }
    }
}
