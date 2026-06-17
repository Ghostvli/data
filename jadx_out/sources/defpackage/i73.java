package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class i73 implements Serializable {
    public final Object f;
    public final Object g;

    public i73(Object obj, Object obj2) {
        this.f = obj;
        this.g = obj2;
    }

    public final Object a() {
        return this.f;
    }

    public final Object b() {
        return this.g;
    }

    public final Object c() {
        return this.f;
    }

    public final Object d() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i73)) {
            return false;
        }
        i73 i73Var = (i73) obj;
        return il1.a(this.f, i73Var.f) && il1.a(this.g, i73Var.g);
    }

    public int hashCode() {
        Object obj = this.f;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.g;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "(" + this.f + ", " + this.g + ')';
    }
}
