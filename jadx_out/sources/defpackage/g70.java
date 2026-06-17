package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g70 implements Comparable, Serializable {
    public final Comparable f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends g70 {
        public static final a g = new a();

        public a() {
            super("");
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(g70 g70Var) {
            return g70Var == this ? 0 : 1;
        }

        @Override // defpackage.g70
        public void f(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // defpackage.g70
        public void g(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // defpackage.g70
        public boolean h(Comparable comparable) {
            return false;
        }

        @Override // defpackage.g70
        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "+∞";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends g70 {
        public static final b g = new b();

        public b() {
            super("");
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: e */
        public int compareTo(g70 g70Var) {
            return g70Var == this ? 0 : -1;
        }

        @Override // defpackage.g70
        public void f(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // defpackage.g70
        public void g(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // defpackage.g70
        public boolean h(Comparable comparable) {
            return true;
        }

        @Override // defpackage.g70
        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "-∞";
        }
    }

    public g70(Comparable comparable) {
        this.f = comparable;
    }

    public static g70 a() {
        return a.g;
    }

    public static g70 b() {
        return b.g;
    }

    /* JADX INFO: renamed from: e */
    public abstract int compareTo(g70 g70Var);

    public boolean equals(Object obj) {
        if (obj instanceof g70) {
            try {
                if (compareTo((g70) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract void f(StringBuilder sb);

    public abstract void g(StringBuilder sb);

    public abstract boolean h(Comparable comparable);

    public abstract int hashCode();
}
