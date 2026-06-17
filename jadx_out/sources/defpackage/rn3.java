package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rn3 implements ig3, Serializable {
    public static final rn3 h = new rn3(g70.b(), g70.a());
    public final g70 f;
    public final g70 g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends x63 implements Serializable {
        public static final x63 f = new a();

        @Override // defpackage.x63, java.util.Comparator
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compare(rn3 rn3Var, rn3 rn3Var2) {
            return rx.k().f(rn3Var.f, rn3Var2.f).f(rn3Var.g, rn3Var2.g).j();
        }
    }

    public rn3(g70 g70Var, g70 g70Var2) {
        this.f = (g70) gg3.q(g70Var);
        this.g = (g70) gg3.q(g70Var2);
        if (g70Var.compareTo(g70Var2) > 0 || g70Var == g70.a() || g70Var2 == g70.b()) {
            nl.a("Invalid range: ", j(g70Var, g70Var2));
            throw null;
        }
    }

    public static rn3 a() {
        return h;
    }

    public static rn3 d(g70 g70Var, g70 g70Var2) {
        return new rn3(g70Var, g70Var2);
    }

    public static x63 h() {
        return a.f;
    }

    public static String j(g70 g70Var, g70 g70Var2) {
        StringBuilder sb = new StringBuilder(16);
        g70Var.f(sb);
        sb.append("..");
        g70Var2.g(sb);
        return sb.toString();
    }

    @Override // defpackage.ig3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean apply(Comparable comparable) {
        return c(comparable);
    }

    public boolean c(Comparable comparable) {
        gg3.q(comparable);
        return this.f.h(comparable) && !this.g.h(comparable);
    }

    public rn3 e(rn3 rn3Var) {
        int iCompareTo = this.f.compareTo(rn3Var.f);
        int iCompareTo2 = this.g.compareTo(rn3Var.g);
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return this;
        }
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return rn3Var;
        }
        g70 g70Var = iCompareTo >= 0 ? this.f : rn3Var.f;
        g70 g70Var2 = iCompareTo2 <= 0 ? this.g : rn3Var.g;
        gg3.m(g70Var.compareTo(g70Var2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, rn3Var);
        return d(g70Var, g70Var2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof rn3) {
            rn3 rn3Var = (rn3) obj;
            if (this.f.equals(rn3Var.f) && this.g.equals(rn3Var.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(rn3 rn3Var) {
        return this.f.compareTo(rn3Var.g) <= 0 && rn3Var.f.compareTo(this.g) <= 0;
    }

    public boolean g() {
        return this.f.equals(this.g);
    }

    public int hashCode() {
        return (this.f.hashCode() * 31) + this.g.hashCode();
    }

    public rn3 i(rn3 rn3Var) {
        int iCompareTo = this.f.compareTo(rn3Var.f);
        int iCompareTo2 = this.g.compareTo(rn3Var.g);
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return this;
        }
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return rn3Var;
        }
        g70 g70Var = iCompareTo <= 0 ? this.f : rn3Var.f;
        if (iCompareTo2 < 0) {
            this = rn3Var;
        }
        return d(g70Var, this.g);
    }

    public String toString() {
        return j(this.f, this.g);
    }
}
