package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zz3 {
    public static final zz3 c;
    public static final zz3 d;
    public static final zz3 e;
    public static final zz3 f;
    public static final zz3 g;
    public final long a;
    public final long b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        zz3 zz3Var = new zz3(0L, 0L);
        c = zz3Var;
        d = new zz3(Long.MAX_VALUE, Long.MAX_VALUE);
        e = new zz3(Long.MAX_VALUE, 0L);
        f = new zz3(0L, Long.MAX_VALUE);
        g = zz3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zz3(long j, long j2) {
        gg3.d(j >= 0);
        gg3.d(j2 >= 0);
        this.a = j;
        this.b = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(long j, long j2, long j3) {
        long j4 = this.a;
        if (j4 == 0 && this.b == 0) {
            return j;
        }
        long jK1 = fy4.K1(j, j4, Long.MIN_VALUE);
        long jF = fy4.f(j, this.b, Long.MAX_VALUE);
        boolean z = false;
        boolean z2 = jK1 <= j2 && j2 <= jF;
        if (jK1 <= j3 && j3 <= jF) {
            z = true;
        }
        if (!z2 || !z) {
            if (!z2) {
                return z ? j3 : jK1;
            }
            return j2;
        }
        if (Math.abs(j2 - j) <= Math.abs(j3 - j)) {
            return j2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zz3.class == obj.getClass()) {
            zz3 zz3Var = (zz3) obj;
            if (this.a == zz3Var.a && this.b == zz3Var.b) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return (((int) this.a) * 31) + ((int) this.b);
    }
}
