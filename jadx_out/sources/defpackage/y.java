package defpackage;

import defpackage.g40;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y implements g40.c {
    public final Function1 f;
    public final g40.c g;

    public y(g40.c cVar, Function1 function1) {
        cVar.getClass();
        function1.getClass();
        this.f = function1;
        this.g = cVar instanceof y ? ((y) cVar).g : cVar;
    }

    public final boolean a(g40.c cVar) {
        cVar.getClass();
        return cVar == this || this.g == cVar;
    }

    public final g40.b b(g40.b bVar) {
        bVar.getClass();
        return (g40.b) this.f.invoke(bVar);
    }
}
