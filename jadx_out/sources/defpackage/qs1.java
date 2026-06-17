package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qs1 {
    public static int a(yh4 yh4Var, long j) {
        if (j == -9223372036854775807L) {
            return 0;
        }
        int iA = yh4Var.a(j);
        if (iA == -1) {
            iA = yh4Var.f();
        }
        return (iA <= 0 || yh4Var.b(iA + (-1)) != j) ? iA : iA - 1;
    }

    public static void b(yh4 yh4Var, int i, g20 g20Var) {
        long jB = yh4Var.b(i);
        List listE = yh4Var.e(jB);
        if (listE.isEmpty()) {
            return;
        }
        if (i == yh4Var.f() - 1) {
            z20.a();
            return;
        }
        long jB2 = yh4Var.b(i + 1) - yh4Var.b(i);
        if (jB2 > 0) {
            g20Var.accept(new y50(listE, jB, jB2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(defpackage.yh4 r11, ki4.b r12, defpackage.g20 r13) {
        /*
            long r0 = r12.a
            int r0 = a(r11, r0)
            long r1 = r12.a
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L3a
            int r1 = r11.f()
            if (r0 >= r1) goto L3a
            long r3 = r12.a
            java.util.List r6 = r11.e(r3)
            long r3 = r11.b(r0)
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L3a
            long r7 = r12.a
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 >= 0) goto L3a
            y50 r5 = new y50
            long r9 = r3 - r7
            r5.<init>(r6, r7, r9)
            r13.accept(r5)
            r1 = 1
            goto L3b
        L3a:
            r1 = r2
        L3b:
            r3 = r0
        L3c:
            int r4 = r11.f()
            if (r3 >= r4) goto L48
            b(r11, r3, r13)
            int r3 = r3 + 1
            goto L3c
        L48:
            boolean r3 = r12.b
            if (r3 == 0) goto L74
            if (r1 == 0) goto L50
            int r0 = r0 + (-1)
        L50:
            if (r2 >= r0) goto L58
            b(r11, r2, r13)
            int r2 = r2 + 1
            goto L50
        L58:
            if (r1 == 0) goto L74
            y50 r3 = new y50
            long r1 = r12.a
            java.util.List r4 = r11.e(r1)
            long r5 = r11.b(r0)
            long r1 = r12.a
            long r11 = r11.b(r0)
            long r7 = r1 - r11
            r3.<init>(r4, r5, r7)
            r13.accept(r3)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qs1.c(yh4, ki4$b, g20):void");
    }
}
