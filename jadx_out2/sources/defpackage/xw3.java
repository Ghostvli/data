package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class xw3 extends a0 {
    public final Function2 f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xw3(Function2 function2) {
        this.f = function2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.a0
    public Object e(a31 a31Var, f30 f30Var) {
        Object objInvoke = this.f.invoke(a31Var, f30Var);
        return objInvoke == kl1.e() ? objInvoke : fw4.a;
    }
}
