package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class pt4 implements Serializable {
    public final Object f;
    public final Object g;
    public final Object h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public pt4(Object obj, Object obj2, Object obj3) {
        this.f = obj;
        this.g = obj2;
        this.h = obj3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pt4)) {
            return false;
        }
        pt4 pt4Var = (pt4) obj;
        return il1.a(this.f, pt4Var.f) && il1.a(this.g, pt4Var.g) && il1.a(this.h, pt4Var.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        Object obj = this.f;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.g;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.h;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + this.f + ", " + this.g + ", " + this.h + ')';
    }
}
