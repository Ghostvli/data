package defpackage;

import defpackage.xi1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cr1 {
    public final xi1 a;
    public final xi1 b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final xi1.a a = xi1.m();
        public xi1 b;

        public b c(ty1 ty1Var) {
            this.a.a(ty1Var);
            return this;
        }

        public cr1 d() {
            return new cr1(this);
        }

        public b e(List list) {
            this.b = xi1.p(list);
            return this;
        }
    }

    public cr1(b bVar) {
        this.a = bVar.a.k();
        this.b = bVar.b;
    }
}
