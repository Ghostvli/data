package defpackage;

import defpackage.dv2;
import defpackage.yz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ez4 implements b04 {
    public final long[] a;
    public final long[] b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ez4(long[] jArr, long[] jArr2, long j, long j2, long j3, int i) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ez4 b(long j, long j2, dv2.a aVar, r73 r73Var) {
        int iQ;
        r73Var.g0(6);
        int iZ = r73Var.z();
        long j3 = j2 + ((long) aVar.c);
        long jMax = ((long) iZ) + j3;
        int iZ2 = r73Var.z();
        if (iZ2 <= 0) {
            return null;
        }
        long jT1 = fy4.t1((((long) iZ2) * ((long) aVar.g)) - 1, aVar.d);
        int iY = r73Var.Y();
        int iY2 = r73Var.Y();
        int iY3 = r73Var.Y();
        r73Var.g0(2);
        int i = iY2;
        long[] jArr = new long[iY];
        long[] jArr2 = new long[iY];
        int i2 = 0;
        long j4 = j2 + ((long) aVar.c);
        while (i2 < iY) {
            long[] jArr3 = jArr2;
            long[] jArr4 = jArr;
            jArr4[i2] = (((long) i2) * jT1) / ((long) iY);
            jArr3[i2] = j4;
            if (iY3 == 1) {
                iQ = r73Var.Q();
            } else if (iY3 == 2) {
                iQ = r73Var.Y();
            } else if (iY3 == 3) {
                iQ = r73Var.T();
            } else {
                if (iY3 != 4) {
                    return null;
                }
                iQ = r73Var.U();
            }
            int i3 = i2;
            int i4 = i;
            j4 += ((long) iQ) * ((long) i4);
            i = i4;
            i2 = i3 + 1;
            iY = iY;
            jArr = jArr4;
            jArr2 = jArr3;
        }
        long[] jArr5 = jArr2;
        long[] jArr6 = jArr;
        if (j != -1 && j != jMax) {
            xz1.i("VbriSeeker", "VBRI data size mismatch: " + j + ", " + jMax);
        }
        if (jMax != j4) {
            xz1.i("VbriSeeker", "VBRI bytes and ToC mismatch (using max): " + jMax + ", " + j4 + "\nSeeking will be inaccurate.");
            jMax = Math.max(jMax, j4);
        }
        return new ez4(jArr6, jArr5, jT1, j3, jMax, aVar.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long a(long j) {
        return this.a[fy4.k(this.b, j, true, true)];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long c() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public long d() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public boolean e() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public yz3.a g(long j) {
        int iK = fy4.k(this.a, j, true, true);
        a04 a04Var = new a04(this.a[iK], this.b[iK]);
        if (a04Var.a >= j || iK == this.a.length - 1) {
            return new yz3.a(a04Var);
        }
        int i = iK + 1;
        return new yz3.a(a04Var, new a04(this.a[i], this.b[i]));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.b04
    public int h() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yz3
    public long i() {
        return this.c;
    }
}
