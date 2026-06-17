package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tt4 {
    public final int a;
    public boolean d;
    public boolean e;
    public boolean f;
    public final yo4 b = new yo4(0);
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public long i = -9223372036854775807L;
    public final r73 c = new r73();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tt4(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int a(jz0 jz0Var) {
        this.c.c0(fy4.f);
        this.d = true;
        jz0Var.p();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long b() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yo4 c() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e(jz0 jz0Var, yf3 yf3Var, int i) {
        if (i <= 0) {
            return a(jz0Var);
        }
        if (!this.f) {
            return h(jz0Var, yf3Var, i);
        }
        if (this.h == -9223372036854775807L) {
            return a(jz0Var);
        }
        if (!this.e) {
            return f(jz0Var, yf3Var, i);
        }
        long j = this.g;
        if (j == -9223372036854775807L) {
            return a(jz0Var);
        }
        this.i = this.b.c(this.h) - this.b.b(j);
        return a(jz0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int f(jz0 jz0Var, yf3 yf3Var, int i) {
        int iMin = (int) Math.min(this.a, jz0Var.getLength());
        if (jz0Var.getPosition() != 0) {
            yf3Var.a = 0L;
            return 1;
        }
        this.c.b0(iMin);
        jz0Var.p();
        jz0Var.s(this.c.f(), 0, iMin);
        this.g = g(this.c, i);
        this.e = true;
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long g(r73 r73Var, int i) {
        int iJ = r73Var.j();
        for (int iG = r73Var.g(); iG < iJ; iG++) {
            if (r73Var.f()[iG] == 71) {
                long jC = yt4.c(r73Var, iG, i);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int h(jz0 jz0Var, yf3 yf3Var, int i) {
        long length = jz0Var.getLength();
        int iMin = (int) Math.min(this.a, length);
        long j = length - ((long) iMin);
        if (jz0Var.getPosition() != j) {
            yf3Var.a = j;
            return 1;
        }
        this.c.b0(iMin);
        jz0Var.p();
        jz0Var.s(this.c.f(), 0, iMin);
        this.h = i(this.c, i);
        this.f = true;
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long i(r73 r73Var, int i) {
        int iG = r73Var.g();
        int iJ = r73Var.j();
        for (int i2 = iJ - 188; i2 >= iG; i2--) {
            if (yt4.b(r73Var.f(), iG, iJ, i2)) {
                long jC = yt4.c(r73Var, i2, i);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }
}
