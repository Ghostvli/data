package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class zx {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(zx.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;
    public final Throwable a;

    public /* synthetic */ zx(Throwable th, boolean z, int i, we0 we0Var) {
        this(th, (i & 2) != 0 ? false : z);
    }

    public final boolean a() {
        return b.get(this) != 0;
    }

    public final boolean c() {
        return b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return ua0.a(this) + '[' + this.a + ']';
    }

    public zx(Throwable th, boolean z) {
        this.a = th;
        this._handled$volatile = z ? 1 : 0;
    }
}
