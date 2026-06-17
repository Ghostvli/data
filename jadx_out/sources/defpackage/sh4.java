package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class sh4 {
    public final Object a;
    public final ph4 b;
    public volatile boolean c = true;

    public sh4(Object obj, ph4 ph4Var) {
        this.a = obj;
        this.b = ph4Var;
    }

    public boolean equals(Object obj) {
        if (obj instanceof sh4) {
            sh4 sh4Var = (sh4) obj;
            if (this.a == sh4Var.a && this.b.equals(sh4Var.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f.hashCode();
    }
}
