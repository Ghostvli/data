package defpackage;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bj implements jy0 {
    public final br4 a;
    public final int b;
    public final int[] c;
    public final int d;
    public final t41[] e;
    public final long[] f;
    public int g;
    public boolean h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bj(br4 br4Var, int[] iArr, int i) {
        t41[] t41VarArr;
        gg3.v(iArr.length > 0);
        this.d = i;
        this.a = (br4) gg3.q(br4Var);
        int length = iArr.length;
        this.b = length;
        this.e = new t41[length];
        int i2 = 0;
        while (true) {
            int length2 = iArr.length;
            t41VarArr = this.e;
            if (i2 >= length2) {
                break;
            }
            t41VarArr[i2] = br4Var.c(iArr[i2]);
            i2++;
        }
        Arrays.sort(t41VarArr, new Comparator() { // from class: aj
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return bj.t((t41) obj, (t41) obj2);
            }
        });
        this.c = new int[this.b];
        int i3 = 0;
        while (true) {
            int i4 = this.b;
            if (i3 >= i4) {
                this.f = new long[i4];
                this.h = false;
                return;
            } else {
                this.c[i3] = br4Var.d(this.e[i3]);
                i3++;
            }
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0004: ARITH (wrap:int:0x0000: IGET (r1v0 t41) A[WRAPPED] (LINE:1) t41.j int) - (wrap:int:0x0002: IGET (r0v0 t41) A[WRAPPED] (LINE:3) t41.j int) (LINE:5) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int t(t41 t41Var, t41 t41Var2) {
        return t41Var2.j - t41Var.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public boolean a(int i, long j) {
        return this.f[i] > j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ir4
    public final br4 c() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public void disable() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ir4
    public final int e(t41 t41Var) {
        for (int i = 0; i < this.b; i++) {
            if (this.e[i] == t41Var) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public void enable() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            bj bjVar = (bj) obj;
            if (this.a.equals(bjVar.a) && Arrays.equals(this.c, bjVar.c)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public void g(boolean z) {
        this.h = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ir4
    public final t41 h(int i) {
        return this.e[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        if (this.g == 0) {
            this.g = (System.identityHashCode(this.a) * 31) + Arrays.hashCode(this.c);
        }
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ir4
    public final int i(int i) {
        return this.c[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public int j(long j, List list) {
        return list.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public final int k() {
        return this.c[d()];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public final t41 l() {
        return this.e[d()];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ir4
    public final int length() {
        return this.c.length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public boolean n(int i, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zA = a(i, jElapsedRealtime);
        int i2 = 0;
        while (i2 < this.b && !zA) {
            zA = (i2 == i || a(i2, jElapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zA) {
            return false;
        }
        long[] jArr = this.f;
        jArr[i] = Math.max(jArr[i], fy4.f(jElapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jy0
    public void o(float f) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ir4
    public final int s(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public bj(br4 br4Var, int... iArr) {
        this(br4Var, iArr, 0);
    }
}
