package defpackage;

import defpackage.tj;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class st4 extends tj {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements tj.f {
        public final yo4 a;
        public final r73 b = new r73();
        public final int c;
        public final int d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, yo4 yo4Var, int i2) {
            this.c = i;
            this.a = yo4Var;
            this.d = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // tj.f
        public tj.e a(jz0 jz0Var, long j) {
            long position = jz0Var.getPosition();
            int iMin = (int) Math.min(this.d, jz0Var.getLength() - position);
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
            int iA;
            int iA2;
            int iJ = r73Var.j();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (r73Var.a() >= 188 && (iA2 = (iA = yt4.a(r73Var.f(), r73Var.g(), iJ)) + 188) <= iJ) {
                long jC = yt4.c(r73Var, iA, this.c);
                if (jC != -9223372036854775807L) {
                    long jB = this.a.b(jC);
                    if (jB > j) {
                        return j5 == -9223372036854775807L ? tj.e.d(jB, j2) : tj.e.e(j2 + j4);
                    }
                    if (100000 + jB > j) {
                        return tj.e.e(((long) iA) + j2);
                    }
                    j4 = iA;
                    j5 = jB;
                }
                r73Var.f0(iA2);
                j3 = iA2;
            }
            return j5 != -9223372036854775807L ? tj.e.f(j5, j2 + j3) : tj.e.d;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public st4(yo4 yo4Var, long j, long j2, int i, int i2) {
        super(new tj.b(), new a(i, yo4Var, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
