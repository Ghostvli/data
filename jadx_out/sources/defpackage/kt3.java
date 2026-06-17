package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class kt3 implements Serializable {
    public static final a g = new a(null);
    public final Object f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements Serializable {
        public final Throwable f;

        public b(Throwable th) {
            th.getClass();
            this.f = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && il1.a(this.f, ((b) obj).f);
        }

        public int hashCode() {
            return this.f.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f + ')';
        }
    }

    public /* synthetic */ kt3(Object obj) {
        this.f = obj;
    }

    public static final /* synthetic */ kt3 a(Object obj) {
        return new kt3(obj);
    }

    public static Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof kt3) && il1.a(obj, ((kt3) obj2).i());
    }

    public static final Throwable d(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f;
        }
        return null;
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean f(Object obj) {
        return obj instanceof b;
    }

    public static final boolean g(Object obj) {
        return !(obj instanceof b);
    }

    public static String h(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f, obj);
    }

    public int hashCode() {
        return e(this.f);
    }

    public final /* synthetic */ Object i() {
        return this.f;
    }

    public String toString() {
        return h(this.f);
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
