package defpackage;

import defpackage.r42;
import defpackage.xi1;
import defpackage.xr4;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nr4 {
    public static xr4 a(r42.a aVar, ir4[] ir4VarArr) {
        List[] listArr = new List[ir4VarArr.length];
        for (int i = 0; i < ir4VarArr.length; i++) {
            ir4 ir4Var = ir4VarArr[i];
            listArr[i] = ir4Var != null ? xi1.w(ir4Var) : xi1.u();
        }
        return b(aVar, listArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
    public static xr4 b(r42.a aVar, List[] listArr) {
        r42.a aVar2 = aVar;
        List[] listArr2 = listArr;
        xi1.a aVar3 = new xi1.a();
        boolean z = false;
        int i = 0;
        while (i < aVar2.d()) {
            er4 er4VarF = aVar2.f(i);
            int i2 = z ? 1 : 0;
            r42.a aVar4 = aVar2;
            List[] listArr3 = listArr2;
            boolean z2 = z;
            while (i2 < er4VarF.a) {
                br4 br4VarB = er4VarF.b(i2);
                boolean z3 = aVar4.a(i, i2, z2) != 0 ? true : z2 ? 1 : 0;
                int i3 = br4VarB.a;
                int[] iArr = new int[i3];
                boolean[] zArr = new boolean[i3];
                int i4 = z2 ? 1 : 0;
                r42.a aVar5 = aVar4;
                List[] listArr4 = listArr3;
                boolean z4 = z2;
                while (i4 < br4VarB.a) {
                    iArr[i4] = aVar5.g(i, i2, i4);
                    int length = listArr4.length;
                    int i5 = z4 ? 1 : 0;
                    boolean z5 = i5;
                    ?? r1 = listArr4;
                    boolean z6 = z4;
                    while (i5 < length) {
                        ?? r9 = r1[i5];
                        ?? r3 = z6;
                        while (true) {
                            if (r3 < r9.size()) {
                                ir4 ir4Var = (ir4) r9.get(r3);
                                if (ir4Var.c().equals(br4VarB) && ir4Var.s(i4) != -1) {
                                    z5 = true;
                                    break;
                                }
                                r3++;
                            }
                        }
                        i5++;
                        r1 = listArr;
                        z6 = false;
                        z5 = z5;
                    }
                    zArr[i4] = z5;
                    i4++;
                    aVar5 = aVar;
                    listArr4 = listArr;
                    z4 = false;
                }
                aVar3.a(new xr4.a(br4VarB, z3, iArr, zArr));
                i2++;
                aVar4 = aVar;
                listArr3 = listArr;
                z2 = false;
            }
            i++;
            aVar2 = aVar;
            listArr2 = listArr;
            z = false;
        }
        er4 er4VarH = aVar.h();
        for (int i6 = 0; i6 < er4VarH.a; i6++) {
            br4 br4VarB2 = er4VarH.b(i6);
            int[] iArr2 = new int[br4VarB2.a];
            Arrays.fill(iArr2, 0);
            aVar3.a(new xr4.a(br4VarB2, false, iArr2, new boolean[br4VarB2.a]));
        }
        return new xr4(aVar3.k());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Point c(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto Lf
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L8
            r1 = r0
            goto L9
        L8:
            r1 = r3
        L9:
            if (r4 <= r5) goto Lc
            r3 = r0
        Lc:
            if (r1 == r3) goto Lf
            goto L12
        Lf:
            r2 = r5
            r5 = r4
            r4 = r2
        L12:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L22
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = defpackage.fy4.n(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = defpackage.fy4.n(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nr4.c(boolean, int, int, int, int):android.graphics.Point");
    }
}
