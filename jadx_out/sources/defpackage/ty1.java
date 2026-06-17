package defpackage;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ty1 {
    public static final AtomicLong h = new AtomicLong();
    public final long a;
    public final ja0 b;
    public final Uri c;
    public final Map d;
    public final long e;
    public final long f;
    public final long g;

    public ty1(long j, ja0 ja0Var, Uri uri, Map map, long j2, long j3, long j4) {
        this.a = j;
        this.b = ja0Var;
        this.c = uri;
        this.d = map;
        this.e = j2;
        this.f = j3;
        this.g = j4;
    }

    public static long b() {
        return h.getAndIncrement();
    }

    public ty1 a(long j, long j2) {
        return new ty1(j, this.b, this.c, this.d, this.e, j2, this.g);
    }

    public ty1(long j, ja0 ja0Var, long j2) {
        this(j, ja0Var, ja0Var.a, Collections.EMPTY_MAP, j2, 0L, 0L);
    }
}
