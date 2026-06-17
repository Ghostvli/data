package defpackage;

import defpackage.tj;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class si3 extends tj {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements tj.f {
        public final yo4 a;
        public final r73 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(yo4 yo4Var) {
            this.a = yo4Var;
            this.b = new r73();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void d(r73 r73Var) {
            int iK;
            int iJ = r73Var.j();
            if (r73Var.a() < 10) {
                r73Var.f0(iJ);
                return;
            }
            r73Var.g0(9);
            int iQ = r73Var.Q() & 7;
            if (r73Var.a() < iQ) {
                r73Var.f0(iJ);
                return;
            }
            r73Var.g0(iQ);
            if (r73Var.a() < 4) {
                r73Var.f0(iJ);
                return;
            }
            if (si3.k(r73Var.f(), r73Var.g()) == 443) {
                r73Var.g0(4);
                int iY = r73Var.Y();
                if (r73Var.a() < iY) {
                    r73Var.f0(iJ);
                    return;
                }
                r73Var.g0(iY);
            }
            while (r73Var.a() >= 4 && (iK = si3.k(r73Var.f(), r73Var.g())) != 442 && iK != 441 && (iK >>> 8) == 1) {
                r73Var.g0(4);
                if (r73Var.a() < 2) {
                    r73Var.f0(iJ);
                    return;
                }
                r73Var.f0(Math.min(r73Var.j(), r73Var.g() + r73Var.Y()));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // tj.f
        public tj.e a(jz0 jz0Var, long j) {
            long position = jz0Var.getPosition();
            int iMin = (int) Math.min(20000L, jz0Var.getLength() - position);
            this.b.b0(iMin);
            jz0Var.s(this.b.f(), 0, iMin);
            return c(this.b, j, position);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // tj.f
        public void b() {
            this.b.c0(fy4.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final tj.e c(r73 r73Var, long j, long j2) {
            int iG = -1;
            int iG2 = -1;
            long j3 = -9223372036854775807L;
            while (r73Var.a() >= 4) {
                if (si3.k(r73Var.f(), r73Var.g()) != 442) {
                    r73Var.g0(1);
                } else {
                    r73Var.g0(4);
                    long jL = ti3.l(r73Var);
                    if (jL != -9223372036854775807L) {
                        long jB = this.a.b(jL);
                        if (jB > j) {
                            return j3 == -9223372036854775807L ? tj.e.d(jB, j2) : tj.e.e(j2 + ((long) iG2));
                        }
                        if (100000 + jB > j) {
                            return tj.e.e(j2 + ((long) r73Var.g()));
                        }
                        iG2 = r73Var.g();
                        j3 = jB;
                    }
                    d(r73Var);
                    iG = r73Var.g();
                }
            }
            return j3 != -9223372036854775807L ? tj.e.f(j3, j2 + ((long) iG)) : tj.e.d;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public si3(yo4 yo4Var, long j, long j2) {
        super(new tj.b(), new b(yo4Var), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
