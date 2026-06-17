package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zl4 {
    public static final String a = pk4.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
    public static final long b = rk4.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
    public static final int c = rk4.e("kotlinx.coroutines.scheduler.core.pool.size", xn3.b(pk4.a(), 2), 1, 0, 8, null);
    public static final int d = rk4.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
    public static final long e = TimeUnit.SECONDS.toNanos(rk4.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
    public static oy3 f = hx2.a;

    public static final vl4 b(Runnable runnable, long j, boolean z) {
        return new xl4(runnable, j, z);
    }

    public static final String c(boolean z) {
        return z ? "Blocking" : "Non-blocking";
    }
}
