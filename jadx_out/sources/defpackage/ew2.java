package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ew2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends e {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // ew2.e
        public Map c() {
            return nb3.c(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends e {
        public final /* synthetic */ Comparator a;

        public b(Comparator comparator) {
            this.a = comparator;
        }

        @Override // ew2.e
        public Map c() {
            return new TreeMap(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements xi4, Serializable {
        public final int f;

        public c(int i) {
            this.f = jw.b(i, "expectedValuesPerKey");
        }

        @Override // defpackage.xi4
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new ArrayList(this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class d extends ew2 {
        public d() {
            super(null);
        }

        public abstract hu1 e();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class e {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends d {
            public final /* synthetic */ int a;
            public final /* synthetic */ e b;

            public a(e eVar, int i) {
                this.a = i;
                this.b = eVar;
            }

            @Override // ew2.d
            public hu1 e() {
                return gw2.c(this.b.c(), new c(this.a));
            }
        }

        public d a() {
            return b(2);
        }

        public d b(int i) {
            jw.b(i, "expectedValuesPerKey");
            return new a(this, i);
        }

        public abstract Map c();
    }

    public /* synthetic */ ew2(a aVar) {
        this();
    }

    public static e a() {
        return b(8);
    }

    public static e b(int i) {
        jw.b(i, "expectedKeys");
        return new a(i);
    }

    public static e c() {
        return d(x63.d());
    }

    public static e d(Comparator comparator) {
        gg3.q(comparator);
        return new b(comparator);
    }

    public ew2() {
    }
}
