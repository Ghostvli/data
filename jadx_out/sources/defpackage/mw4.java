package defpackage;

import defpackage.ha5;
import defpackage.ol1;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mw4 {
    public static final mw4 f = new mw4(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d;
    public boolean e;

    public mw4(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static mw4 c() {
        return f;
    }

    public static int f(int[] iArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    public static int g(Object[] objArr, int i) {
        int iHashCode = 17;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode = (iHashCode * 31) + objArr[i2].hashCode();
        }
        return iHashCode;
    }

    public static mw4 n(mw4 mw4Var, mw4 mw4Var2) {
        int i = mw4Var.a + mw4Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(mw4Var.b, i);
        System.arraycopy(mw4Var2.b, 0, iArrCopyOf, mw4Var.a, mw4Var2.a);
        Object[] objArrCopyOf = Arrays.copyOf(mw4Var.c, i);
        System.arraycopy(mw4Var2.c, 0, objArrCopyOf, mw4Var.a, mw4Var2.a);
        return new mw4(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static mw4 o() {
        return new mw4();
    }

    public static boolean p(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static void u(int i, Object obj, ha5 ha5Var) {
        int iA = aa5.a(i);
        int iB = aa5.b(i);
        if (iB == 0) {
            ha5Var.q(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            ha5Var.j(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            ha5Var.e(iA, (hn) obj);
            return;
        }
        if (iB != 3) {
            if (iB == 5) {
                ha5Var.f(iA, ((Integer) obj).intValue());
                return;
            } else {
                wg1.a(ol1.e());
                return;
            }
        }
        if (ha5Var.k() == ha5.a.ASCENDING) {
            ha5Var.u(iA);
            ((mw4) obj).v(ha5Var);
            ha5Var.H(iA);
        } else {
            ha5Var.H(iA);
            ((mw4) obj).v(ha5Var);
            ha5Var.u(iA);
        }
    }

    public void a() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i2 = this.a;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public int d() {
        int iL;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = this.b[i3];
            int iA = aa5.a(i4);
            int iB = aa5.b(i4);
            if (iB == 0) {
                iL = jv.L(iA, ((Long) this.c[i3]).longValue());
            } else if (iB == 1) {
                iL = jv.n(iA, ((Long) this.c[i3]).longValue());
            } else if (iB == 2) {
                iL = jv.f(iA, (hn) this.c[i3]);
            } else if (iB == 3) {
                iL = (jv.I(iA) * 2) + ((mw4) this.c[i3]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(ol1.e());
                }
                iL = jv.l(iA, ((Integer) this.c[i3]).intValue());
            }
            i2 += iL;
        }
        this.d = i2;
        return i2;
    }

    public int e() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iX = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            iX += jv.x(aa5.a(this.b[i2]), (hn) this.c[i2]);
        }
        this.d = iX;
        return iX;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof mw4)) {
            return false;
        }
        mw4 mw4Var = (mw4) obj;
        int i = this.a;
        return i == mw4Var.a && s(this.b, mw4Var.b, i) && p(this.c, mw4Var.c, this.a);
    }

    public void h() {
        if (this.e) {
            this.e = false;
        }
    }

    public int hashCode() {
        int i = this.a;
        return ((((527 + i) * 31) + f(this.b, i)) * 31) + g(this.c, this.a);
    }

    public boolean i(int i, hv hvVar) throws ol1.a {
        a();
        int iA = aa5.a(i);
        int iB = aa5.b(i);
        if (iB == 0) {
            r(i, Long.valueOf(hvVar.y()));
            return true;
        }
        if (iB == 1) {
            r(i, Long.valueOf(hvVar.v()));
            return true;
        }
        if (iB == 2) {
            r(i, hvVar.r());
            return true;
        }
        if (iB == 3) {
            mw4 mw4Var = new mw4();
            mw4Var.j(hvVar);
            hvVar.a(aa5.c(iA, 4));
            r(i, mw4Var);
            return true;
        }
        if (iB == 4) {
            hvVar.c();
            return false;
        }
        if (iB != 5) {
            throw ol1.e();
        }
        r(i, Integer.valueOf(hvVar.u()));
        return true;
    }

    public final mw4 j(hv hvVar) {
        int iG;
        do {
            iG = hvVar.G();
            if (iG == 0) {
                break;
            }
        } while (i(iG, hvVar));
        return this;
    }

    public mw4 k(mw4 mw4Var) {
        if (mw4Var.equals(c())) {
            return this;
        }
        a();
        int i = this.a + mw4Var.a;
        b(i);
        System.arraycopy(mw4Var.b, 0, this.b, this.a, mw4Var.a);
        System.arraycopy(mw4Var.c, 0, this.c, this.a, mw4Var.a);
        this.a = i;
        return this;
    }

    public mw4 l(int i, hn hnVar) {
        a();
        if (i != 0) {
            r(aa5.c(i, 2), hnVar);
            return this;
        }
        jl.a("Zero is not a valid field number.");
        return null;
    }

    public mw4 m(int i, int i2) {
        a();
        if (i != 0) {
            r(aa5.c(i, 0), Long.valueOf(i2));
            return this;
        }
        jl.a("Zero is not a valid field number.");
        return null;
    }

    public final void q(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            ts2.d(sb, i, String.valueOf(aa5.a(this.b[i2])), this.c[i2]);
        }
    }

    public void r(int i, Object obj) {
        a();
        b(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public void t(ha5 ha5Var) {
        if (ha5Var.k() == ha5.a.DESCENDING) {
            for (int i = this.a - 1; i >= 0; i--) {
                ha5Var.d(aa5.a(this.b[i]), this.c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            ha5Var.d(aa5.a(this.b[i2]), this.c[i2]);
        }
    }

    public void v(ha5 ha5Var) {
        if (this.a == 0) {
            return;
        }
        if (ha5Var.k() == ha5.a.ASCENDING) {
            for (int i = 0; i < this.a; i++) {
                u(this.b[i], this.c[i], ha5Var);
            }
            return;
        }
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            u(this.b[i2], this.c[i2], ha5Var);
        }
    }

    public mw4() {
        this(0, new int[8], new Object[8], true);
    }
}
