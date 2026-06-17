package defpackage;

import androidx.media3.session.x;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f10 {
    public static final long a = 10000;
    public static final long b = 5000;
    public static final long c = 30000;
    public static final long d = 30000;
    public static final long e = 5000;
    public static final long f = 15000;
    public static final long g = 15000;
    public static final long h = 2000;
    public static final long i = 30000;
    public static final long j = 15000;
    public static final long k = 15000;
    public static final long l = 10000;
    public static final long m = 5184000000L;

    public static long a(long j2) {
        if (j2 < 900000) {
            return 180000L;
        }
        if (j2 < 1800000) {
            return 360000L;
        }
        return x.DEFAULT_FOREGROUND_SERVICE_TIMEOUT_MS;
    }
}
