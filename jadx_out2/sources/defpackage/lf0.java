package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lf0 implements hq0 {
    public final byte[] a = new byte[8];
    public final ArrayDeque b = new ArrayDeque();
    public final dz4 c = new dz4();
    public gq0 d;
    public int e;
    public int f;
    public long g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final long b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String f(jz0 jz0Var, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        jz0Var.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hq0
    public boolean a(jz0 jz0Var) throws r83 {
        gg3.q(this.d);
        while (true) {
            b bVar = (b) this.b.peek();
            if (bVar != null && jz0Var.getPosition() >= bVar.b) {
                this.d.a(((b) this.b.pop()).a);
                return true;
            }
            if (this.e == 0) {
                long jD = this.c.d(jz0Var, true, false, 4);
                if (jD == -2) {
                    jD = c(jz0Var);
                }
                if (jD == -1) {
                    return false;
                }
                this.f = (int) jD;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.d(jz0Var, false, true, 8);
                this.e = 2;
            }
            int iB = this.d.b(this.f);
            if (iB != 0) {
                if (iB == 1) {
                    long position = jz0Var.getPosition();
                    this.b.push(new b(this.f, this.g + position));
                    this.d.g(this.f, position, this.g);
                    this.e = 0;
                    return true;
                }
                if (iB == 2) {
                    long j = this.g;
                    if (j <= 8) {
                        this.d.h(this.f, e(jz0Var, (int) j));
                        this.e = 0;
                        return true;
                    }
                    throw r83.a("Invalid integer size: " + this.g, null);
                }
                if (iB == 3) {
                    long j2 = this.g;
                    if (j2 <= 2147483647L) {
                        this.d.d(this.f, f(jz0Var, (int) j2));
                        this.e = 0;
                        return true;
                    }
                    throw r83.a("String element size: " + this.g, null);
                }
                if (iB == 4) {
                    this.d.f(this.f, (int) this.g, jz0Var);
                    this.e = 0;
                    return true;
                }
                if (iB != 5) {
                    throw r83.a("Invalid element type " + iB, null);
                }
                long j3 = this.g;
                if (j3 == 4 || j3 == 8) {
                    this.d.e(this.f, d(jz0Var, (int) j3));
                    this.e = 0;
                    return true;
                }
                throw r83.a("Invalid float size: " + this.g, null);
            }
            jz0Var.q((int) this.g);
            this.e = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hq0
    public void b(gq0 gq0Var) {
        this.d = gq0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long c(jz0 jz0Var) {
        jz0Var.p();
        while (true) {
            jz0Var.s(this.a, 0, 4);
            int iC = dz4.c(this.a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) dz4.a(this.a, iC, false);
                if (this.d.c(iA)) {
                    jz0Var.q(iC);
                    return iA;
                }
            }
            jz0Var.q(1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final double d(jz0 jz0Var, int i) {
        return i == 4 ? Float.intBitsToFloat((int) r1) : Double.longBitsToDouble(e(jz0Var, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long e(jz0 jz0Var, int i) {
        jz0Var.readFully(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.a[i2] & 255));
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.hq0
    public void reset() {
        this.e = 0;
        this.b.clear();
        this.c.e();
    }
}
