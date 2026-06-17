package defpackage;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class hm1 extends qn1 {
    public final Function1 j;

    public hm1(Function1 function1) {
        this.j = function1;
    }

    @Override // defpackage.qn1
    public boolean w() {
        return false;
    }

    @Override // defpackage.qn1
    public void x(Throwable th) {
        this.j.invoke(th);
    }
}
