package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class gm1 extends qn1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(gm1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;
    public final Function1 j;

    public gm1(Function1 function1) {
        this.j = function1;
    }

    @Override // defpackage.qn1
    public boolean w() {
        return true;
    }

    @Override // defpackage.qn1
    public void x(Throwable th) {
        if (k.compareAndSet(this, 0, 1)) {
            this.j.invoke(th);
        }
    }
}
