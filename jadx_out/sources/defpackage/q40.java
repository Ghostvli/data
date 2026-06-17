package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q40 {
    public static final void a(g40 g40Var, Throwable th) {
        Iterator it = p40.a().iterator();
        while (it.hasNext()) {
            try {
                ((o40) it.next()).t(g40Var, th);
            } catch (Throwable th2) {
                p40.b(r40.b(th, th2));
            }
        }
        try {
            mv0.a(th, new qk0(g40Var));
        } catch (Throwable unused) {
        }
        p40.b(th);
    }
}
