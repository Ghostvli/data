package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class l00 implements g40.b {
    public final g40.c f;
    public final qf3 g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l00(g40.c cVar, qf3 qf3Var) {
        cVar.getClass();
        qf3Var.getClass();
        this.f = cVar;
        this.g = qf3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g40
    public g40 B(g40.c cVar) {
        return g40.b.a.c(this, cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g40
    public g40 N(g40 g40Var) {
        return g40.b.a.d(this, g40Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g40
    public Object T(Object obj, Function2 function2) {
        return g40.b.a.a(this, obj, function2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // g40.b, defpackage.g40
    public g40.b a(g40.c cVar) {
        return g40.b.a.b(this, cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final qf3 b() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // g40.b
    public g40.c getKey() {
        return this.f;
    }
}
