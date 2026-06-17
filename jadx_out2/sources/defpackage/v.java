package defpackage;

import android.util.Pair;
import defpackage.no4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v extends no4 {
    public final int e;
    public final o64 f;
    public final boolean g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v(boolean z, o64 o64Var) {
        this.g = z;
        this.f = o64Var;
        this.e = o64Var.getLength();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object C(Object obj) {
        return ((Pair) obj).second;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object D(Object obj) {
        return ((Pair) obj).first;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object F(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public abstract int A(int i);

    public abstract int B(int i);

    public abstract Object E(int i);

    public abstract int G(int i);

    public abstract int H(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int I(int i, boolean z) {
        if (z) {
            return this.f.e(i);
        }
        if (i < this.e - 1) {
            return i + 1;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int J(int i, boolean z) {
        if (z) {
            return this.f.d(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    public abstract no4 K(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public int g(boolean z) {
        if (this.e == 0) {
            return -1;
        }
        if (this.g) {
            z = false;
        }
        int iC = z ? this.f.c() : 0;
        while (K(iC).w()) {
            iC = I(iC, z);
            if (iC == -1) {
                return -1;
            }
        }
        return H(iC) + K(iC).g(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public final int h(Object obj) {
        int iH;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objD = D(obj);
        Object objC = C(obj);
        int iZ = z(objD);
        if (iZ == -1 || (iH = K(iZ).h(objC)) == -1) {
            return -1;
        }
        return G(iZ) + iH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public int i(boolean z) {
        int i = this.e;
        if (i == 0) {
            return -1;
        }
        if (this.g) {
            z = false;
        }
        int iH = z ? this.f.h() : i - 1;
        while (K(iH).w()) {
            iH = J(iH, z);
            if (iH == -1) {
                return -1;
            }
        }
        return H(iH) + K(iH).i(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public int k(int i, int i2, boolean z) {
        if (this.g) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int iB = B(i);
        int iH = H(iB);
        int iK = K(iB).k(i - iH, i2 != 2 ? i2 : 0, z);
        if (iK != -1) {
            return iH + iK;
        }
        int I = I(iB, z);
        while (I != -1 && K(I).w()) {
            I = I(I, z);
        }
        if (I != -1) {
            return H(I) + K(I).g(z);
        }
        if (i2 == 2) {
            return g(z);
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public final no4.b m(int i, no4.b bVar, boolean z) {
        int iA = A(i);
        int iH = H(iA);
        K(iA).m(i - G(iA), bVar, z);
        bVar.c += iH;
        if (z) {
            bVar.b = F(E(iA), gg3.q(bVar.b));
        }
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public final no4.b n(Object obj, no4.b bVar) {
        Object objD = D(obj);
        Object objC = C(obj);
        int iZ = z(objD);
        int iH = H(iZ);
        K(iZ).n(objC, bVar);
        bVar.c += iH;
        bVar.b = obj;
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public int r(int i, int i2, boolean z) {
        if (this.g) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int iB = B(i);
        int iH = H(iB);
        int iR = K(iB).r(i - iH, i2 != 2 ? i2 : 0, z);
        if (iR != -1) {
            return iH + iR;
        }
        int iJ = J(iB, z);
        while (iJ != -1 && K(iJ).w()) {
            iJ = J(iJ, z);
        }
        if (iJ != -1) {
            return H(iJ) + K(iJ).i(z);
        }
        if (i2 == 2) {
            return i(z);
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public final Object s(int i) {
        int iA = A(i);
        return F(E(iA), K(iA).s(i - G(iA)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.no4
    public final no4.d u(int i, no4.d dVar, long j) {
        int iB = B(i);
        int iH = H(iB);
        int iG = G(iB);
        K(iB).u(i - iH, dVar, j);
        Object objE = E(iB);
        if (!no4.d.q.equals(dVar.a)) {
            objE = F(objE, dVar.a);
        }
        dVar.a = objE;
        dVar.n += iG;
        dVar.o += iG;
        return dVar;
    }

    public abstract int z(Object obj);
}
