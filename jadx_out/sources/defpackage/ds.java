package defpackage;

import defpackage.yc;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ds extends zg {
    public int[] i;
    public int[] j;

    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    @Override // defpackage.yc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.nio.ByteBuffer r10) {
        /*
            r9 = this;
            int[] r0 = r9.j
            java.lang.Object r0 = defpackage.gg3.q(r0)
            int[] r0 = (int[]) r0
            int r1 = r10.position()
            int r2 = r10.limit()
            int r3 = r2 - r1
            yc$a r4 = r9.b
            int r4 = r4.d
            int r3 = r3 / r4
            yc$a r4 = r9.c
            int r4 = r4.d
            int r3 = r3 * r4
            java.nio.ByteBuffer r3 = r9.o(r3)
        L20:
            if (r1 >= r2) goto L99
            int r4 = r0.length
            r5 = 0
        L24:
            if (r5 >= r4) goto L93
            r6 = r0[r5]
            yc$a r7 = r9.b
            int r7 = r7.c
            int r7 = defpackage.fy4.W(r7)
            int r7 = r7 * r6
            int r7 = r7 + r1
            yc$a r6 = r9.b
            int r6 = r6.c
            r8 = 2
            if (r6 == r8) goto L89
            r8 = 3
            if (r6 == r8) goto L81
            r8 = 4
            if (r6 == r8) goto L79
            r8 = 21
            if (r6 == r8) goto L71
            r8 = 22
            if (r6 == r8) goto L69
            r8 = 268435456(0x10000000, float:2.524355E-29)
            if (r6 == r8) goto L89
            r8 = 1342177280(0x50000000, float:8.589935E9)
            if (r6 == r8) goto L71
            r8 = 1610612736(0x60000000, float:3.689349E19)
            if (r6 == r8) goto L69
            r8 = 1879048192(0x70000000, float:1.5845633E29)
            if (r6 != r8) goto L5f
            double r6 = r10.getDouble(r7)
            r3.putDouble(r6)
            goto L90
        L5f:
            yc$a r9 = r9.b
            int r9 = r9.c
            java.lang.String r10 = "Unexpected encoding: "
            defpackage.jr1.a(r10, r9)
            return
        L69:
            int r6 = r10.getInt(r7)
            r3.putInt(r6)
            goto L90
        L71:
            int r6 = defpackage.fy4.m0(r10, r7)
            defpackage.fy4.q1(r3, r6)
            goto L90
        L79:
            float r6 = r10.getFloat(r7)
            r3.putFloat(r6)
            goto L90
        L81:
            byte r6 = r10.get(r7)
            r3.put(r6)
            goto L90
        L89:
            short r6 = r10.getShort(r7)
            r3.putShort(r6)
        L90:
            int r5 = r5 + 1
            goto L24
        L93:
            yc$a r4 = r9.b
            int r4 = r4.d
            int r1 = r1 + r4
            goto L20
        L99:
            r10.position(r2)
            r3.flip()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ds.f(java.nio.ByteBuffer):void");
    }

    @Override // defpackage.zg
    public yc.a j(yc.a aVar) throws yc.c {
        int[] iArr = this.i;
        if (iArr == null) {
            return yc.a.e;
        }
        if (!fy4.R0(aVar.c)) {
            throw new yc.c(aVar);
        }
        boolean z = aVar.b != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= aVar.b) {
                throw new yc.c("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", aVar);
            }
            z |= i2 != i;
            i++;
        }
        return z ? new yc.a(aVar.a, iArr.length, aVar.c) : yc.a.e;
    }

    @Override // defpackage.zg
    public void l(yc.b bVar) {
        this.j = this.i;
    }

    @Override // defpackage.zg
    public void n() {
        this.j = null;
        this.i = null;
    }

    public void p(int[] iArr) {
        this.i = iArr;
    }
}
