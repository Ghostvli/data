package defpackage;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class da1 extends ScheduledThreadPoolExecutor implements AutoCloseable {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final da1 a = new da1();
    }

    public da1() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static da1 a() {
        return b.a;
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        e45.a(this);
    }
}
