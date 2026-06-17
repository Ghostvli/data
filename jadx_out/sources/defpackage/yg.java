package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yg implements z6 {
    public final List a;

    public yg(List list) {
        this.a = list;
    }

    @Override // defpackage.z6
    public List b() {
        return this.a;
    }

    @Override // defpackage.z6
    public boolean c() {
        return this.a.isEmpty() || (this.a.size() == 1 && ((dr1) this.a.get(0)).i());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }
}
