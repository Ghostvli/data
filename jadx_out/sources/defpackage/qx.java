package defpackage;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qx extends x63 implements Serializable {
    public final Comparator f;

    public qx(Comparator comparator) {
        this.f = (Comparator) gg3.q(comparator);
    }

    @Override // defpackage.x63, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof qx) {
            return this.f.equals(((qx) obj).f);
        }
        return false;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String toString() {
        return this.f.toString();
    }
}
