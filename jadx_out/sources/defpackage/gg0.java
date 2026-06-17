package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class gg0 extends qv0 implements Executor {
    public static final gg0 i = new gg0();
    public static final n40 j = n40.g0(ow4.h, rk4.e("kotlinx.coroutines.io.parallelism", xn3.b(64, pk4.a()), 0, 0, 12, null), null, 2, null);

    @Override // defpackage.n40
    public void c0(g40 g40Var, Runnable runnable) {
        j.c0(g40Var, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c0(bs0.f, runnable);
    }

    @Override // defpackage.n40
    public n40 f0(int i2, String str) {
        return ow4.h.f0(i2, str);
    }

    @Override // defpackage.qv0
    public Executor h0() {
        return this;
    }

    @Override // defpackage.n40
    public String toString() {
        return "Dispatchers.IO";
    }
}
