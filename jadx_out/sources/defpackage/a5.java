package defpackage;

import com.hierynomus.msdtyp.FileTime;
import defpackage.jy0;
import defpackage.xi1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a5 extends bj {
    public final qg i;
    public final long j;
    public final long k;
    public final long l;
    public final int m;
    public final int n;
    public final float o;
    public final float p;
    public final xi1 q;
    public final zu r;
    public float s;
    public int t;
    public int u;
    public long v;
    public v72 w;
    public long x;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public int hashCode() {
            return (((int) this.a) * 31) + ((int) this.b);
        }
    }

    public a5(br4 br4Var, int[] iArr, int i, qg qgVar, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zu zuVar) {
        long j4;
        super(br4Var, iArr, i);
        if (j3 < j) {
            xz1.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j4 = j;
        } else {
            j4 = j3;
        }
        this.i = qgVar;
        this.j = j * 1000;
        this.k = j2 * 1000;
        this.l = j4 * 1000;
        this.m = i2;
        this.n = i3;
        this.o = f;
        this.p = f2;
        this.q = xi1.p(list);
        this.r = zuVar;
        this.s = 1.0f;
        this.u = 0;
        this.v = -9223372036854775807L;
        this.x = -2147483647L;
    }

    public static long[][] D(jy0.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i = 0; i < aVarArr.length; i++) {
            jy0.a aVar = aVarArr[i];
            if (aVar == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[aVar.b.length];
                int i2 = 0;
                while (true) {
                    int[] iArr = aVar.b;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    long j = aVar.a.c(iArr[i2]).j;
                    long[] jArr2 = jArr[i];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i2] = j;
                    i2++;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    public static xi1 E(long[][] jArr) {
        hu1 hu1VarE = ew2.c().a().e();
        for (int i = 0; i < jArr.length; i++) {
            long[] jArr2 = jArr[i];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    long[] jArr3 = jArr[i];
                    double dLog = 0.0d;
                    if (i2 >= jArr3.length) {
                        break;
                    }
                    long j = jArr3[i2];
                    if (j != -1) {
                        dLog = Math.log(j);
                    }
                    dArr[i2] = dLog;
                    i2++;
                }
                int i3 = length - 1;
                double d = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d2 = dArr[i4];
                    i4++;
                    hu1VarE.put(Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i4]) * 0.5d) - dArr[0]) / d), Integer.valueOf(i));
                }
            }
        }
        return xi1.p(hu1VarE.values());
    }

    public static void v(List list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            xi1.a aVar = (xi1.a) list.get(i);
            if (aVar != null) {
                aVar.a(new a(j, jArr[i]));
            }
        }
    }

    public static xi1 y(jy0.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (jy0.a aVar : aVarArr) {
            if (aVar == null || aVar.b.length <= 1) {
                arrayList.add(null);
            } else {
                xi1.a aVarM = xi1.m();
                aVarM.a(new a(0L, 0L));
                arrayList.add(aVarM);
            }
        }
        long[][] jArrD = D(aVarArr);
        int[] iArr = new int[jArrD.length];
        long[] jArr = new long[jArrD.length];
        for (int i = 0; i < jArrD.length; i++) {
            long[] jArr2 = jArrD[i];
            jArr[i] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        v(arrayList, jArr);
        xi1 xi1VarE = E(jArrD);
        for (int i2 = 0; i2 < xi1VarE.size(); i2++) {
            int iIntValue = ((Integer) xi1VarE.get(i2)).intValue();
            int i3 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i3;
            jArr[iIntValue] = jArrD[iIntValue][i3];
            v(arrayList, jArr);
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            if (arrayList.get(i4) != null) {
                jArr[i4] = jArr[i4] * 2;
            }
        }
        v(arrayList, jArr);
        xi1.a aVarM2 = xi1.m();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            xi1.a aVar2 = (xi1.a) arrayList.get(i5);
            aVarM2.a(aVar2 == null ? xi1.u() : aVar2.k());
        }
        return aVarM2.k();
    }

    public final long A(List list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        v72 v72Var = (v72) km1.d(list);
        long j = v72Var.g;
        if (j != -9223372036854775807L) {
            long j2 = v72Var.h;
            if (j2 != -9223372036854775807L) {
                return j2 - j;
            }
        }
        return -9223372036854775807L;
    }

    public long B() {
        return this.l;
    }

    public final long C(w72[] w72VarArr, List list) {
        int i = this.t;
        if (i < w72VarArr.length && w72VarArr[i].next()) {
            w72 w72Var = w72VarArr[this.t];
            return w72Var.b() - w72Var.a();
        }
        for (w72 w72Var2 : w72VarArr) {
            if (w72Var2.next()) {
                return w72Var2.b() - w72Var2.a();
            }
        }
        return A(list);
    }

    public final long F(long j) {
        long jG = this.i.g();
        this.x = jG;
        long j2 = (long) (jG * this.o);
        long jA = this.i.a();
        if (jA == -9223372036854775807L || j == -9223372036854775807L) {
            return (long) (j2 / this.s);
        }
        float f = j;
        return (long) ((j2 * Math.max((f / this.s) - jA, 0.0f)) / f);
    }

    public final long G(long j, long j2) {
        if (j == -9223372036854775807L) {
            return this.j;
        }
        if (j2 != -9223372036854775807L) {
            j -= j2;
        }
        return Math.min((long) (j * this.p), this.j);
    }

    public boolean H(long j, List list) {
        long j2 = this.v;
        if (j2 == -9223372036854775807L || j - j2 >= 1000) {
            return true;
        }
        return (list.isEmpty() || ((v72) km1.d(list)).equals(this.w)) ? false : true;
    }

    @Override // defpackage.jy0
    public void b(long j, long j2, long j3, List list, w72[] w72VarArr) {
        long jE = this.r.e();
        long jC = C(w72VarArr, list);
        int i = this.u;
        if (i == 0) {
            this.u = 1;
            this.t = x(jE, jC);
            return;
        }
        int i2 = this.t;
        int iE = list.isEmpty() ? -1 : e(((v72) km1.d(list)).d);
        if (iE != -1) {
            i = ((v72) km1.d(list)).e;
            i2 = iE;
        }
        int iX = x(jE, jC);
        if (iX != i2 && !a(i2, jE)) {
            t41 t41VarH = h(i2);
            t41 t41VarH2 = h(iX);
            long jG = G(j3, jC);
            int i3 = t41VarH2.j;
            int i4 = t41VarH.j;
            if ((i3 > i4 && j2 < jG) || (i3 < i4 && j2 >= this.k)) {
                iX = i2;
            }
        }
        if (iX != i2) {
            i = 3;
        }
        this.u = i;
        this.t = iX;
    }

    @Override // defpackage.jy0
    public int d() {
        return this.t;
    }

    @Override // defpackage.bj, defpackage.jy0
    public void disable() {
        this.w = null;
    }

    @Override // defpackage.bj, defpackage.jy0
    public void enable() {
        this.v = -9223372036854775807L;
        this.w = null;
    }

    @Override // defpackage.bj, defpackage.jy0
    public int j(long j, List list) {
        int i;
        int i2;
        long jE = this.r.e();
        if (!H(jE, list)) {
            return list.size();
        }
        this.v = jE;
        this.w = list.isEmpty() ? null : (v72) km1.d(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jV0 = fy4.v0(((v72) list.get(size - 1)).g - j, this.s);
        long jB = B();
        if (jV0 >= jB) {
            t41 t41VarH = h(x(jE, A(list)));
            for (int i3 = 0; i3 < size; i3++) {
                v72 v72Var = (v72) list.get(i3);
                t41 t41Var = v72Var.d;
                if (fy4.v0(v72Var.g - j, this.s) >= jB && t41Var.j < t41VarH.j && (i = t41Var.x) != -1 && i <= this.n && (i2 = t41Var.w) != -1 && i2 <= this.m && i < t41VarH.x) {
                    return i3;
                }
            }
        }
        return size;
    }

    @Override // defpackage.jy0
    public int m() {
        return this.u;
    }

    @Override // defpackage.bj, defpackage.jy0
    public void o(float f) {
        this.s = f;
    }

    @Override // defpackage.jy0
    public Object p() {
        return null;
    }

    public boolean w(t41 t41Var, int i, long j) {
        return ((long) i) <= j;
    }

    public final int x(long j, long j2) {
        long jZ = z(j2);
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            if (j == Long.MIN_VALUE || !a(i2, j)) {
                t41 t41VarH = h(i2);
                if (w(t41VarH, t41VarH.j, jZ)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    public final long z(long j) {
        long jF = F(j);
        if (this.q.isEmpty()) {
            return jF;
        }
        int i = 1;
        while (i < this.q.size() - 1 && ((a) this.q.get(i)).a < jF) {
            i++;
        }
        a aVar = (a) this.q.get(i - 1);
        a aVar2 = (a) this.q.get(i);
        long j2 = aVar.a;
        float f = (jF - j2) / (aVar2.a - j2);
        return aVar.b + ((long) (f * (aVar2.b - r0)));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements jy0.b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final float f;
        public final float g;
        public final zu h;

        public b(int i, int i2, int i3, int i4, int i5, float f, float f2, zu zuVar) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = f;
            this.g = f2;
            this.h = zuVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
        @Override // jy0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final defpackage.jy0[] a(jy0.a[] r10, defpackage.qg r11, jq2.b r12, defpackage.no4 r13) {
            /*
                r9 = this;
                xi1 r12 = defpackage.a5.u(r10)
                int r13 = r10.length
                jy0[] r13 = new defpackage.jy0[r13]
                r0 = 0
                r1 = r0
            L9:
                int r2 = r10.length
                if (r1 >= r2) goto L42
                r2 = r10[r1]
                if (r2 == 0) goto L15
                int[] r5 = r2.b
                int r3 = r5.length
                if (r3 != 0) goto L18
            L15:
                r3 = r9
                r7 = r11
                goto L3d
            L18:
                int r3 = r5.length
                br4 r4 = r2.a
                r6 = 1
                if (r3 != r6) goto L2c
                w11 r3 = new w11
                r5 = r5[r0]
                int r2 = r2.c
                r3.<init>(r4, r5, r2)
                r7 = r3
                r3 = r9
                r9 = r7
                r7 = r11
                goto L3b
            L2c:
                int r6 = r2.c
                java.lang.Object r2 = r12.get(r1)
                r8 = r2
                xi1 r8 = (defpackage.xi1) r8
                r3 = r9
                r7 = r11
                a5 r9 = r3.b(r4, r5, r6, r7, r8)
            L3b:
                r13[r1] = r9
            L3d:
                int r1 = r1 + 1
                r9 = r3
                r11 = r7
                goto L9
            L42:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: a5.b.a(jy0$a[], qg, jq2$b, no4):jy0[]");
        }

        public a5 b(br4 br4Var, int[] iArr, int i, qg qgVar, xi1 xi1Var) {
            return new a5(br4Var, iArr, i, qgVar, this.a, this.b, this.c, this.d, this.e, this.f, this.g, xi1Var, this.h);
        }

        public b(int i, int i2, int i3, float f) {
            this(i, i2, i3, 1279, 719, f, 0.75f, zu.a);
        }

        public b() {
            this(FileTime.NANO100_TO_MILLI, 25000, 25000, 0.7f);
        }
    }
}
