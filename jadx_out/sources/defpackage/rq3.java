package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rq3 implements x50 {
    public final ArrayList a = new ArrayList();

    @Override // defpackage.x50
    public long a(long j) {
        if (this.a.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j < ((y50) this.a.get(0)).b) {
            return ((y50) this.a.get(0)).b;
        }
        int i = 1;
        while (true) {
            int size = this.a.size();
            ArrayList arrayList = this.a;
            if (i >= size) {
                long j2 = ((y50) km1.d(arrayList)).d;
                if (j2 == -9223372036854775807L || j >= j2) {
                    return Long.MIN_VALUE;
                }
                return j2;
            }
            y50 y50Var = (y50) arrayList.get(i);
            if (j < y50Var.b) {
                long j3 = ((y50) this.a.get(i - 1)).d;
                return (j3 == -9223372036854775807L || j3 <= j || j3 >= y50Var.b) ? y50Var.b : j3;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // defpackage.x50
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(defpackage.y50 r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.b
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r4 = 1
            if (r0 == 0) goto Lf
            r0 = r4
            goto L10
        Lf:
            r0 = r1
        L10:
            defpackage.gg3.d(r0)
            long r5 = r10.b
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 > 0) goto L25
            long r5 = r10.d
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 == 0) goto L23
            int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r0 >= 0) goto L25
        L23:
            r0 = r4
            goto L26
        L25:
            r0 = r1
        L26:
            java.util.ArrayList r2 = r9.a
            int r2 = r2.size()
            int r2 = r2 - r4
        L2d:
            if (r2 < 0) goto L56
            long r5 = r10.b
            java.util.ArrayList r3 = r9.a
            java.lang.Object r3 = r3.get(r2)
            y50 r3 = (defpackage.y50) r3
            long r7 = r3.b
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            java.util.ArrayList r5 = r9.a
            if (r3 < 0) goto L46
            int r2 = r2 + r4
            r5.add(r2, r10)
            return r0
        L46:
            java.lang.Object r3 = r5.get(r2)
            y50 r3 = (defpackage.y50) r3
            long r5 = r3.b
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 > 0) goto L53
            r0 = r1
        L53:
            int r2 = r2 + (-1)
            goto L2d
        L56:
            java.util.ArrayList r9 = r9.a
            r9.add(r1, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rq3.b(y50, long):boolean");
    }

    @Override // defpackage.x50
    public xi1 c(long j) {
        int iF = f(j);
        if (iF == 0) {
            return xi1.u();
        }
        y50 y50Var = (y50) this.a.get(iF - 1);
        long j2 = y50Var.d;
        return (j2 == -9223372036854775807L || j < j2) ? y50Var.a : xi1.u();
    }

    @Override // defpackage.x50
    public void clear() {
        this.a.clear();
    }

    @Override // defpackage.x50
    public long d(long j) {
        if (this.a.isEmpty() || j < ((y50) this.a.get(0)).b) {
            return -9223372036854775807L;
        }
        int i = 1;
        while (true) {
            int size = this.a.size();
            ArrayList arrayList = this.a;
            if (i >= size) {
                y50 y50Var = (y50) km1.d(arrayList);
                long j2 = y50Var.d;
                return (j2 == -9223372036854775807L || j < j2) ? y50Var.b : j2;
            }
            long j3 = ((y50) arrayList.get(i)).b;
            if (j == j3) {
                return j3;
            }
            if (j < j3) {
                y50 y50Var2 = (y50) this.a.get(i - 1);
                long j4 = y50Var2.d;
                return (j4 == -9223372036854775807L || j4 > j) ? y50Var2.b : j4;
            }
            i++;
        }
    }

    @Override // defpackage.x50
    public void e(long j) {
        int iF = f(j);
        if (iF == 0) {
            return;
        }
        long j2 = ((y50) this.a.get(iF - 1)).d;
        if (j2 == -9223372036854775807L || j2 >= j) {
            iF--;
        }
        this.a.subList(0, iF).clear();
    }

    public final int f(long j) {
        int i = 0;
        while (true) {
            int size = this.a.size();
            ArrayList arrayList = this.a;
            if (i >= size) {
                return arrayList.size();
            }
            if (j < ((y50) arrayList.get(i)).b) {
                return i;
            }
            i++;
        }
    }
}
