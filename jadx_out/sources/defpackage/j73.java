package defpackage;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class j73 implements Serializable {
    public Serializable f;
    public Serializable g;

    public j73(Serializable serializable, Serializable serializable2) {
        this.f = serializable;
        this.g = serializable2;
    }

    public Serializable a() {
        return this.f;
    }

    public Serializable b() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            j73 j73Var = (j73) obj;
            if (Objects.equals(this.f, j73Var.f) && Objects.equals(this.g, j73Var.g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f, this.g);
    }

    public String toString() {
        return "{" + this.f + ", " + this.g + "}";
    }
}
