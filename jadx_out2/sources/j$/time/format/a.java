package j$.time.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends b0 {
    public final /* synthetic */ a0 d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a(a0 a0Var) {
        this.d = a0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.b0
    public final String b(j$.time.chrono.l lVar, j$.time.temporal.p pVar, long j, g0 g0Var, Locale locale) {
        return this.d.a(j, g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.b0
    public final String c(j$.time.temporal.p pVar, long j, g0 g0Var, Locale locale) {
        return this.d.a(j, g0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.b0
    public final Iterator d(j$.time.chrono.l lVar, j$.time.temporal.p pVar, g0 g0Var, Locale locale) {
        List list = (List) ((HashMap) this.d.b).get(g0Var);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // j$.time.format.b0
    public final Iterator e(j$.time.temporal.p pVar, g0 g0Var, Locale locale) {
        List list = (List) ((HashMap) this.d.b).get(g0Var);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
