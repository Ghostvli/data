package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class iz0 {
    public static List a(xe4 xe4Var, ue4 ue4Var) {
        try {
            xj1 xj1VarH = ue4Var.H();
            if (xj1VarH == null) {
                return Collections.EMPTY_LIST;
            }
            xe4Var.a(xj1VarH.e());
            return xj1VarH.f();
        } catch (Exception e) {
            xe4Var.b(e);
            return Collections.EMPTY_LIST;
        }
    }
}
