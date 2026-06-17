package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tp0 implements Comparable {
    public static final a f = new a(null);
    public static final long g = b(0);
    public static final long h = wp0.g(4611686018427387903L);
    public static final long i = wp0.g(-4611686018427387903L);

    public static final long a(long j, long j2, long j3) {
        long jL = wp0.l(j3);
        long j4 = j2 + jL;
        if (-4611686018426L > j4 || j4 >= 4611686018427L) {
            return wp0.g(xn3.g(j4, -4611686018427387903L, 4611686018427387903L));
        }
        return wp0.i(wp0.k(j4) + (j3 - wp0.k(jL)));
    }

    public static long b(long j) {
        if (!vp0.a()) {
            return j;
        }
        if (l(j)) {
            long jI = i(j);
            if (-4611686018426999999L <= jI && jI < 4611686018427000000L) {
                return j;
            }
            throw new AssertionError(i(j) + " ns is out of nanoseconds range");
        }
        long jI2 = i(j);
        if (-4611686018427387903L > jI2 || jI2 >= 4611686018427387904L) {
            throw new AssertionError(i(j) + " ms is out of milliseconds range");
        }
        long jI3 = i(j);
        if (-4611686018426L > jI3 || jI3 >= 4611686018427L) {
            return j;
        }
        throw new AssertionError(i(j) + " ms is denormalized");
    }

    public static final long e(long j) {
        return (k(j) && j(j)) ? i(j) : q(j, xp0.i);
    }

    public static final long f(long j) {
        long jI = i(j);
        if (l(j)) {
            return jI;
        }
        if (jI > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (jI < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return wp0.k(jI);
    }

    public static final long g(long j) {
        return q(j, xp0.j);
    }

    public static final xp0 h(long j) {
        return l(j) ? xp0.g : xp0.i;
    }

    public static final long i(long j) {
        return j >> 1;
    }

    public static final boolean j(long j) {
        return !m(j);
    }

    public static final boolean k(long j) {
        return (((int) j) & 1) == 1;
    }

    public static final boolean l(long j) {
        return (((int) j) & 1) == 0;
    }

    public static final boolean m(long j) {
        return j == h || j == i;
    }

    public static final boolean n(long j) {
        return j < 0;
    }

    public static final boolean o(long j) {
        return j > 0;
    }

    public static final long p(long j, long j2) {
        if (m(j)) {
            if (j(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            jl.a("Summing infinite durations of different signs yields an undefined result.");
            return 0L;
        }
        if (m(j2)) {
            return j2;
        }
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return k(j) ? a(j, i(j), i(j2)) : a(j, i(j2), i(j));
        }
        long jI = i(j) + i(j2);
        return l(j) ? wp0.j(jI) : wp0.h(jI);
    }

    public static final long q(long j, xp0 xp0Var) {
        xp0Var.getClass();
        if (j == h) {
            return Long.MAX_VALUE;
        }
        if (j == i) {
            return Long.MIN_VALUE;
        }
        return yp0.a(i(j), h(j), xp0Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
