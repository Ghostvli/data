package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xk4 {
    public static final b e = new b(null);
    public final String a;
    public final Map b;
    public final Set c;
    public final Set d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final List d;
        public final List e;

        public c(String str, String str2, String str3, List list, List list2) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            list.getClass();
            list2.getClass();
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = list;
            this.e = list2;
        }

        public boolean equals(Object obj) {
            return yk4.d(this, obj);
        }

        public int hashCode() {
            return yk4.i(this);
        }

        public String toString() {
            return yk4.o(this);
        }
    }

    public xk4(String str, Map map, Set set, Set set2) {
        str.getClass();
        map.getClass();
        set.getClass();
        this.a = str;
        this.b = map;
        this.c = set;
        this.d = set2;
    }

    public static final xk4 a(lw3 lw3Var, String str) {
        return e.a(lw3Var, str);
    }

    public boolean equals(Object obj) {
        return yk4.f(this, obj);
    }

    public int hashCode() {
        return yk4.k(this);
    }

    public String toString() {
        return yk4.q(this);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final C0130a h = new C0130a(null);
        public final String a;
        public final String b;
        public final boolean c;
        public final int d;
        public final String e;
        public final int f;
        public final int g;

        public a(String str, String str2, boolean z, int i, String str3, int i2) {
            str.getClass();
            str2.getClass();
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = i;
            this.e = str3;
            this.f = i2;
            this.g = ry3.a(str2);
        }

        public final boolean a() {
            return this.d > 0;
        }

        public boolean equals(Object obj) {
            return yk4.c(this, obj);
        }

        public int hashCode() {
            return yk4.h(this);
        }

        public String toString() {
            return yk4.n(this);
        }

        /* JADX INFO: renamed from: xk4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0130a {
            public /* synthetic */ C0130a(we0 we0Var) {
                this();
            }

            public C0130a() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public static final a e = new a(null);
        public final String a;
        public final boolean b;
        public final List c;
        public List d;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
        public d(String str, boolean z, List list, List list2) {
            str.getClass();
            list.getClass();
            list2.getClass();
            this.a = str;
            this.b = z;
            this.c = list;
            this.d = list2;
            if (list2.isEmpty()) {
                int size = list.size();
                list2 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    list2.add("ASC");
                }
            }
            this.d = list2;
        }

        public boolean equals(Object obj) {
            return yk4.e(this, obj);
        }

        public int hashCode() {
            return yk4.j(this);
        }

        public String toString() {
            return yk4.p(this);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public /* synthetic */ a(we0 we0Var) {
                this();
            }

            public a() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public /* synthetic */ b(we0 we0Var) {
            this();
        }

        public final xk4 a(lw3 lw3Var, String str) {
            lw3Var.getClass();
            str.getClass();
            return ry3.g(lw3Var, str);
        }

        public b() {
        }
    }
}
