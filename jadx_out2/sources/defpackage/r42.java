package defpackage;

import android.util.Pair;
import androidx.media3.exoplayer.p;
import defpackage.jq2;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r42 extends or4 {
    public a c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final String[] b;
        public final int[] c;
        public final er4[] d;
        public final int[] e;
        public final int[][][] f;
        public final er4 g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String[] strArr, int[] iArr, er4[] er4VarArr, int[] iArr2, int[][][] iArr3, er4 er4Var) {
            this.b = strArr;
            this.c = iArr;
            this.d = er4VarArr;
            this.f = iArr3;
            this.e = iArr2;
            this.g = er4Var;
            this.a = iArr.length;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int a(int i, int i2, boolean z) {
            int i3 = this.d[i].b(i2).a;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int iG = g(i, i2, i5);
                if (iG == 4 || (z && iG == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return b(i, i2, Arrays.copyOf(iArr, i4));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b(int i, int i2, int[] iArr) {
            int i3 = 0;
            int iMin = 16;
            String str = null;
            boolean z = false;
            int i4 = 0;
            while (i3 < iArr.length) {
                String str2 = this.d[i].b(i2).c(iArr[i3]).p;
                int i5 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !Objects.equals(str, str2);
                }
                iMin = Math.min(iMin, p.B(this.f[i][i2][i3]));
                i3++;
                i4 = i5;
            }
            return z ? Math.min(iMin, this.e[i]) : iMin;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int c(int i, int i2, int i3) {
            return this.f[i][i2][i3];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int d() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int e(int i) {
            return this.c[i];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public er4 f(int i) {
            return this.d[i];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int g(int i, int i2, int i3) {
            return p.O(c(i, i2, i3));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public er4 h() {
            return this.g;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int n(p[] pVarArr, br4 br4Var, int[] iArr, boolean z) {
        int length = pVarArr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < pVarArr.length; i2++) {
            p pVar = pVarArr[i2];
            int iMax = 0;
            for (int i3 = 0; i3 < br4Var.a; i3++) {
                iMax = Math.max(iMax, p.O(pVar.a(br4Var.c(i3))));
            }
            boolean z3 = iArr[i2] == 0;
            if (iMax > i || (iMax == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = iMax;
            }
        }
        return length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] o(p pVar, br4 br4Var) {
        int[] iArr = new int[br4Var.a];
        for (int i = 0; i < br4Var.a; i++) {
            iArr[i] = pVar.a(br4Var.c(i));
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] p(p[] pVarArr) {
        int length = pVarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = pVarArr[i].E();
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.or4
    public final void i(Object obj) {
        this.c = (a) obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.or4
    public final pr4 k(p[] pVarArr, er4 er4Var, jq2.b bVar, no4 no4Var) {
        int[] iArr = new int[pVarArr.length + 1];
        int length = pVarArr.length + 1;
        br4[][] br4VarArr = new br4[length][];
        int[][][] iArr2 = new int[pVarArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = er4Var.a;
            br4VarArr[i] = new br4[i2];
            iArr2[i] = new int[i2][];
        }
        int[] iArrP = p(pVarArr);
        for (int i3 = 0; i3 < er4Var.a; i3++) {
            br4 br4VarB = er4Var.b(i3);
            int iN = n(pVarArr, br4VarB, iArr, br4VarB.c == 5);
            int[] iArrO = iN == pVarArr.length ? new int[br4VarB.a] : o(pVarArr[iN], br4VarB);
            int i4 = iArr[iN];
            br4VarArr[iN][i4] = br4VarB;
            iArr2[iN][i4] = iArrO;
            iArr[iN] = i4 + 1;
        }
        er4[] er4VarArr = new er4[pVarArr.length];
        String[] strArr = new String[pVarArr.length];
        int[] iArr3 = new int[pVarArr.length];
        for (int i5 = 0; i5 < pVarArr.length; i5++) {
            int i6 = iArr[i5];
            er4VarArr[i5] = new er4((br4[]) fy4.i1(br4VarArr[i5], i6));
            iArr2[i5] = (int[][]) fy4.i1(iArr2[i5], i6);
            strArr[i5] = pVarArr[i5].getName();
            iArr3[i5] = pVarArr[i5].d();
        }
        a aVar = new a(strArr, iArr3, er4VarArr, iArrP, iArr2, new er4((br4[]) fy4.i1(br4VarArr[pVarArr.length], iArr[pVarArr.length])));
        Pair pairQ = q(aVar, iArr2, iArrP, bVar, no4Var);
        return new pr4((jq3[]) pairQ.first, (jy0[]) pairQ.second, nr4.a(aVar, (ir4[]) pairQ.second), aVar);
    }

    public abstract Pair q(a aVar, int[][][] iArr, int[] iArr2, jq2.b bVar, no4 no4Var);
}
