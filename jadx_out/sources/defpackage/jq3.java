package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class jq3 {
    public static final jq3 c = new jq3(0, false);
    public final int a;
    public final boolean b;

    public jq3(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && jq3.class == obj.getClass()) {
            jq3 jq3Var = (jq3) obj;
            if (this.a == jq3Var.a && this.b == jq3Var.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.a << 1) + (this.b ? 1 : 0);
    }
}
