package defpackage;

import defpackage.t83;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class k11 implements cf1 {
    public final cf1 a;
    public final List b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k11(cf1 cf1Var, List list) {
        this.a = cf1Var;
        this.b = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cf1
    public t83.a a(ze1 ze1Var, we1 we1Var) {
        return new l11(this.a.a(ze1Var, we1Var), this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.cf1
    public t83.a b() {
        return new l11(this.a.b(), this.b);
    }
}
