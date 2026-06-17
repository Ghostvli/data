package defpackage;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class rn4 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(rn4.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;
    public sn4[] a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(sn4 sn4Var) {
        sn4Var.f(this);
        sn4[] sn4VarArrG = g();
        int iC = c();
        k(iC + 1);
        sn4VarArrG[iC] = sn4Var;
        sn4Var.setIndex(iC);
        m(iC);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sn4 b() {
        sn4[] sn4VarArr = this.a;
        if (sn4VarArr != null) {
            return sn4VarArr[0];
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int c() {
        return b.get(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e() {
        return c() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sn4 f() {
        sn4 sn4VarB;
        synchronized (this) {
            sn4VarB = b();
        }
        return sn4VarB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final sn4 i(int i) {
        sn4[] sn4VarArr = this.a;
        sn4VarArr.getClass();
        k(c() - 1);
        if (i < c()) {
            n(i, c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                sn4 sn4Var = sn4VarArr[i];
                sn4Var.getClass();
                sn4 sn4Var2 = sn4VarArr[i2];
                sn4Var2.getClass();
                if (((Comparable) sn4Var).compareTo(sn4Var2) < 0) {
                    n(i, i2);
                    m(i2);
                } else {
                    l(i);
                }
            }
        }
        sn4 sn4Var3 = sn4VarArr[c()];
        sn4Var3.getClass();
        sn4Var3.f(null);
        sn4Var3.setIndex(-1);
        sn4VarArr[c()] = null;
        return sn4Var3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final sn4 j() {
        sn4 sn4VarI;
        synchronized (this) {
            sn4VarI = c() > 0 ? i(0) : null;
        }
        return sn4VarI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(int i) {
        b.set(this, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(int i) {
        while (true) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (i3 >= c()) {
                return;
            }
            sn4[] sn4VarArr = this.a;
            sn4VarArr.getClass();
            int i4 = i2 + 2;
            if (i4 < c()) {
                sn4 sn4Var = sn4VarArr[i4];
                sn4Var.getClass();
                sn4 sn4Var2 = sn4VarArr[i3];
                sn4Var2.getClass();
                if (((Comparable) sn4Var).compareTo(sn4Var2) >= 0) {
                    i4 = i3;
                }
            }
            sn4 sn4Var3 = sn4VarArr[i];
            sn4Var3.getClass();
            sn4 sn4Var4 = sn4VarArr[i4];
            sn4Var4.getClass();
            if (((Comparable) sn4Var3).compareTo(sn4Var4) <= 0) {
                return;
            }
            n(i, i4);
            i = i4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
