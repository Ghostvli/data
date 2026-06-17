package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x implements g40.b {
    public final g40.c f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public x(g40.c cVar) {
        cVar.getClass();
        this.f = cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g40
    public /* bridge */ g40 B(g40.c cVar) {
        return g40.b.a.c(this, cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g40
    public /* bridge */ g40 N(g40 g40Var) {
        return g40.b.a.d(this, g40Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.g40
    public /* bridge */ Object T(Object obj, Function2 function2) {
        return g40.b.a.a(this, obj, function2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // g40.b, defpackage.g40
    public /* bridge */ g40.b a(g40.c cVar) {
        return g40.b.a.b(this, cVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // g40.b
    public g40.c getKey() {
        return this.f;
    }
}
