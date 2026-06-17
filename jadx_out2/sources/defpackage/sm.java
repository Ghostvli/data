package defpackage;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class sm extends x63 implements Serializable {
    public final p81 f;
    public final x63 g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sm(p81 p81Var, x63 x63Var) {
        this.f = (p81) gg3.q(p81Var);
        this.g = (x63) gg3.q(x63Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x63, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.g.compare(this.f.apply(obj), this.f.apply(obj2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof sm) {
            sm smVar = (sm) obj;
            if (this.f.equals(smVar.f) && this.g.equals(smVar.g)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(this.f, this.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return this.g + ".onResultOf(" + this.f + ")";
    }
}
