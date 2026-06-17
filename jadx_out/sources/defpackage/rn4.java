package defpackage;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class rn4 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(rn4.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;
    public sn4[] a;

    public final void a(sn4 sn4Var) {
        sn4Var.f(this);
        sn4[] sn4VarArrG = g();
        int iC = c();
        k(iC + 1);
        sn4VarArrG[iC] = sn4Var;
        sn4Var.setIndex(iC);
        m(iC);
    }

    public final sn4 b() {
        sn4[] sn4VarArr = this.a;
        if (sn4VarArr != null) {
            return sn4VarArr[0];
        }
        return null;
    }

    public final int c() {
        return b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final sn4 f() {
        sn4 sn4VarB;
        synchronized (this) {
            sn4VarB = b();
        }
        return sn4VarB;
    }

    public final sn4[] g() {
        sn4[] sn4VarArr = this.a;
        if (sn4VarArr == null) {
            sn4[] sn4VarArr2 = new sn4[4];
            this.a = sn4VarArr2;
            return sn4VarArr2;
        }
        if (c() < sn4VarArr.length) {
            return sn4VarArr;
        }
        sn4[] sn4VarArr3 = (sn4[]) Arrays.copyOf(sn4VarArr, c() * 2);
        this.a = sn4VarArr3;
        return sn4VarArr3;
    }

    public final boolean h(sn4 sn4Var) {
        boolean z;
        synchronized (this) {
            if (sn4Var.b() == null) {
                z = false;
            } else {
                i(sn4Var.getIndex());
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.sn4 i(int r6) {
        /*
            r5 = this;
            sn4[] r0 = r5.a
            r0.getClass()
            int r1 = r5.c()
            r2 = -1
            int r1 = r1 + r2
            r5.k(r1)
            int r1 = r5.c()
            if (r6 >= r1) goto L3d
            int r1 = r5.c()
            r5.n(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            r3.getClass()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            r4.getClass()
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.n(r6, r1)
            r5.m(r1)
            goto L3d
        L3a:
            r5.l(r6)
        L3d:
            int r6 = r5.c()
            r6 = r0[r6]
            r6.getClass()
            r1 = 0
            r6.f(r1)
            r6.setIndex(r2)
            int r5 = r5.c()
            r0[r5] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rn4.i(int):sn4");
    }

    public final sn4 j() {
        sn4 sn4VarI;
        synchronized (this) {
            sn4VarI = c() > 0 ? i(0) : null;
        }
        return sn4VarI;
    }

    public final void k(int i) {
        b.set(this, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            goto L3e
        Lb:
            sn4[] r2 = r5.a
            r2.getClass()
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            r3.getClass()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            r4.getClass()
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            r1.getClass()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            r2.getClass()
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
        L3e:
            return
        L3f:
            r5.n(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rn4.l(int):void");
    }

    public final void m(int i) {
        while (i > 0) {
            sn4[] sn4VarArr = this.a;
            sn4VarArr.getClass();
            int i2 = (i - 1) / 2;
            sn4 sn4Var = sn4VarArr[i2];
            sn4Var.getClass();
            sn4 sn4Var2 = sn4VarArr[i];
            sn4Var2.getClass();
            if (((Comparable) sn4Var).compareTo(sn4Var2) <= 0) {
                return;
            }
            n(i, i2);
            i = i2;
        }
    }

    public final void n(int i, int i2) {
        sn4[] sn4VarArr = this.a;
        sn4VarArr.getClass();
        sn4 sn4Var = sn4VarArr[i2];
        sn4Var.getClass();
        sn4 sn4Var2 = sn4VarArr[i];
        sn4Var2.getClass();
        sn4VarArr[i] = sn4Var;
        sn4VarArr[i2] = sn4Var2;
        sn4Var.setIndex(i);
        sn4Var2.setIndex(i2);
    }
}
