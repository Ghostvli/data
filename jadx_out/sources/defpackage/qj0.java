package defpackage;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class qj0 implements Serializable {
    public static final qj0 h = new qj0("", 3);
    public final String f;
    public final int g;

    public qj0(String str, int i) {
        this.g = i;
        this.f = (String) aa4.a(str, "");
    }

    public String a() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            qj0 qj0Var = (qj0) obj;
            if (this.g == qj0Var.g && Objects.equals(this.f, qj0Var.f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f, Integer.valueOf(this.g));
    }
}
