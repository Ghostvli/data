package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ti3 {
    public boolean c;
    public boolean d;
    public boolean e;
    public final yo4 a = new yo4(0);
    public long f = -9223372036854775807L;
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public final r73 b = new r73();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(r73 r73Var) {
        int iG = r73Var.g();
        if (r73Var.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        r73Var.u(bArr, 0, 9);
        r73Var.f0(iG);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    public static long m(byte[] bArr) {
        byte b = bArr[0];
        long j = (((((long) b) & 56) >> 3) << 30) | ((((long) b) & 3) << 28) | ((((long) bArr[1]) & 255) << 20);
        byte b2 = bArr[2];
        return j | (((((long) b2) & 248) >> 3) << 15) | ((((long) b2) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public final int b(jz0 jz0Var) {
        this.b.c0(fy4.f);
        this.c = true;
        jz0Var.p();
        return 0;
    }

    public long c() {
        return this.h;
    }

    public yo4 d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }

    public final int f(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    public int g(jz0 jz0Var, yf3 yf3Var) {
        if (!this.e) {
            return j(jz0Var, yf3Var);
        }
        if (this.g == -9223372036854775807L) {
            return b(jz0Var);
        }
        if (!this.d) {
            return h(jz0Var, yf3Var);
        }
        long j = this.f;
        if (j == -9223372036854775807L) {
            return b(jz0Var);
        }
        this.h = this.a.c(this.g) - this.a.b(j);
        return b(jz0Var);
    }

    public final int h(jz0 jz0Var, yf3 yf3Var) {
        int iMin = (int) Math.min(20000L, jz0Var.getLength());
        if (jz0Var.getPosition() != 0) {
            yf3Var.a = 0L;
            return 1;
        }
        this.b.b0(iMin);
        jz0Var.p();
        jz0Var.s(this.b.f(), 0, iMin);
        this.f = i(this.b);
        this.d = true;
        return 0;
    }

    public final long i(r73 r73Var) {
        int iJ = r73Var.j();
        for (int iG = r73Var.g(); iG < iJ - 3; iG++) {
            if (f(r73Var.f(), iG) == 442) {
                r73Var.f0(iG + 4);
                long jL = l(r73Var);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int j(jz0 jz0Var, yf3 yf3Var) {
        long length = jz0Var.getLength();
        int iMin = (int) Math.min(20000L, length);
        long j = length - ((long) iMin);
        if (jz0Var.getPosition() != j) {
            yf3Var.a = j;
            return 1;
        }
        this.b.b0(iMin);
        jz0Var.p();
        jz0Var.s(this.b.f(), 0, iMin);
        this.g = k(this.b);
        this.e = true;
        return 0;
    }

    public final long k(r73 r73Var) {
        int iG = r73Var.g();
        for (int iJ = r73Var.j() - 4; iJ >= iG; iJ--) {
            if (f(r73Var.f(), iJ) == 442) {
                r73Var.f0(iJ + 4);
                long jL = l(r73Var);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }
}
