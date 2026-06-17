package defpackage;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g04 {
    public final vn3 a;
    public final long b;
    public final long c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a extends g04 {
        public final long d;
        public final long e;
        public final List f;
        public final long g;
        public final long h;
        public final long i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(vn3 vn3Var, long j, long j2, long j3, long j4, List list, long j5, long j6, long j7) {
            super(vn3Var, j, j2);
            this.d = j3;
            this.e = j4;
            this.f = list;
            this.i = j5;
            this.g = j6;
            this.h = j7;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long c(long j, long j2) {
            long jG = g(j);
            return jG != -1 ? jG : (int) (i((j2 - this.h) + this.i, j) - d(j, j2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long d(long j, long j2) {
            if (g(j) == -1) {
                long j3 = this.g;
                if (j3 != -9223372036854775807L) {
                    return Math.max(e(), i((j2 - this.h) - j3, j));
                }
            }
            return e();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long e() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long f(long j, long j2) {
            if (this.f != null) {
                return -9223372036854775807L;
            }
            long jD = d(j, j2) + c(j, j2);
            return (j(jD) + h(jD, j)) - this.i;
        }

        public abstract long g(long j);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final long h(long j, long j2) {
            List list = this.f;
            if (list != null) {
                return (((d) list.get((int) (j - this.d))).b * 1000000) / this.b;
            }
            long jG = g(j2);
            return (jG == -1 || j != (e() + jG) - 1) ? (this.e * 1000000) / this.b : j2 - j(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public long i(long j, long j2) {
            long jE = e();
            long jG = g(j2);
            if (jG != 0) {
                if (this.f != null) {
                    long j3 = (jG + jE) - 1;
                    long j4 = jE;
                    while (j4 <= j3) {
                        long j5 = ((j3 - j4) / 2) + j4;
                        long j6 = j(j5);
                        if (j6 < j) {
                            j4 = j5 + 1;
                        } else {
                            if (j6 <= j) {
                                return j5;
                            }
                            j3 = j5 - 1;
                        }
                    }
                    return j4 == jE ? j4 : j3;
                }
                long j7 = this.d + (j / ((this.e * 1000000) / this.b));
                if (j7 >= jE) {
                    return jG == -1 ? j7 : Math.min(j7, (jE + jG) - 1);
                }
            }
            return jE;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final long j(long j) {
            List list = this.f;
            long j2 = this.d;
            return fy4.u1(list != null ? ((d) list.get((int) (j - j2))).a - this.c : (j - j2) * this.e, 1000000L, this.b);
        }

        public abstract vn3 k(tq3 tq3Var, long j);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean l() {
            return this.f != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends a {
        public final List j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(vn3 vn3Var, long j, long j2, long j3, long j4, List list, long j5, List list2, long j6, long j7) {
            super(vn3Var, j, j2, j3, j4, list, j5, j6, j7);
            this.j = list2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // g04.a
        public long g(long j) {
            return this.j.size();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // g04.a
        public vn3 k(tq3 tq3Var, long j) {
            return (vn3) this.j.get((int) (j - this.d));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // g04.a
        public boolean l() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends a {
        public final ox4 j;
        public final ox4 k;
        public final long l;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(vn3 vn3Var, long j, long j2, long j3, long j4, long j5, List list, long j6, ox4 ox4Var, ox4 ox4Var2, long j7, long j8) {
            super(vn3Var, j, j2, j3, j5, list, j6, j7, j8);
            this.j = ox4Var;
            this.k = ox4Var2;
            this.l = j4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.g04
        public vn3 a(tq3 tq3Var) {
            ox4 ox4Var = this.j;
            if (ox4Var == null) {
                return super.a(tq3Var);
            }
            t41 t41Var = tq3Var.b;
            return new vn3(ox4Var.a(t41Var.a, 0L, t41Var.j, 0L), 0L, -1L);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // g04.a
        public long g(long j) {
            if (this.f != null) {
                return r0.size();
            }
            long j2 = this.l;
            if (j2 != -1) {
                return (j2 - this.d) + 1;
            }
            if (j != -9223372036854775807L) {
                return rj.a(BigInteger.valueOf(j).multiply(BigInteger.valueOf(this.b)), BigInteger.valueOf(this.e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // g04.a
        public vn3 k(tq3 tq3Var, long j) {
            List list = this.f;
            long j2 = this.d;
            long j3 = list != null ? ((d) list.get((int) (j - j2))).a : (j - j2) * this.e;
            ox4 ox4Var = this.k;
            t41 t41Var = tq3Var.b;
            return new vn3(ox4Var.a(t41Var.a, j, t41Var.j, j3), 0L, -1L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final long a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                if (this.a == dVar.a && this.b == dVar.b) {
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g04(vn3 vn3Var, long j, long j2) {
        this.a = vn3Var;
        this.b = j;
        this.c = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vn3 a(tq3 tq3Var) {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long b() {
        return fy4.u1(this.c, 1000000L, this.b);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends g04 {
        public final long d;
        public final long e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public vn3 c() {
            long j = this.e;
            if (j <= 0) {
                return null;
            }
            return new vn3(null, this.d, j);
        }

        public e(vn3 vn3Var, long j, long j2, long j3, long j4) {
            super(vn3Var, j, j2);
            this.d = j3;
            this.e = j4;
        }
    }
}
