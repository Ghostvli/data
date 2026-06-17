package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tt3 extends x63 implements Serializable {
    public final x63 f;

    public tt3(x63 x63Var) {
        this.f = (x63) gg3.q(x63Var);
    }

    @Override // defpackage.x63, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof tt3) {
            return this.f.equals(((tt3) obj).f);
        }
        return false;
    }

    @Override // defpackage.x63
    public x63 g() {
        return this.f;
    }

    public int hashCode() {
        return -this.f.hashCode();
    }

    public String toString() {
        return this.f + ".reverse()";
    }
}
