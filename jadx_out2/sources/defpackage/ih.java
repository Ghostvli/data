package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ih {
    public String B;
    public boolean C;
    public b90 D;
    public long a;
    public long b;
    public CharSequence c;
    public String[] d;
    public Object e;
    public int f;
    public float g;
    public float h;
    public int i;
    public up0 q;
    public int r;
    public int s;
    public hh1 x;
    public boolean y;
    public boolean z;
    public int j = 0;
    public float k = -1.0f;
    public int l = 0;
    public int m = 0;
    public byte n = 0;
    public float o = -1.0f;
    public float p = -1.0f;
    public int t = 0;
    public int u = 0;
    public int v = 0;
    public int w = -1;
    public int A = 0;
    public int E = k5.a;
    public int F = 0;
    public int G = -1;
    public ta1 H = null;
    public int I = 0;
    public int J = -1;
    public SparseArray K = new SparseArray();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(fh1 fh1Var, boolean z) {
        fh1Var.d(this, z);
        this.w = this.H.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B(long j) {
        this.a = j;
        this.b = 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C(long j) {
        this.b = j;
        this.v = this.H.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D(b90 b90Var) {
        this.D = b90Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E(boolean z) {
        if (!z) {
            this.s = 0;
        } else {
            this.t = this.H.b;
            this.s = 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int a(fh1 fh1Var) {
        return fh1Var.r(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long b() {
        ta1 ta1Var = this.H;
        if (ta1Var != null && ta1Var.e == this.v) {
            return this.a + this.b;
        }
        this.b = 0L;
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c() {
        return this.E;
    }

    public abstract float d();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hh1 e() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long f() {
        return this.q.h;
    }

    public abstract float g();

    public abstract float[] h(fh1 fh1Var, long j);

    public abstract float i();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long j() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b90 k() {
        return this.D;
    }

    public abstract float l();

    public abstract int m();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean n() {
        if (this.G == this.H.c) {
            return true;
        }
        this.F = 0;
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean o() {
        return this.G == this.H.c && this.F != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p() {
        b90 b90Var = this.D;
        return b90Var == null || b90Var.a < b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q() {
        return this.o > -1.0f && this.p > -1.0f && this.u == this.H.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r() {
        ta1 ta1Var = this.H;
        if (ta1Var != null && ta1Var.e == this.v) {
            return this.b != 0;
        }
        this.b = 0L;
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s() {
        b90 b90Var = this.D;
        return b90Var == null || t(b90Var.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean t(long j) {
        long jB = j - b();
        return jB <= 0 || jB >= this.q.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean u() {
        return this.w == this.H.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean v() {
        return this.s == 1 && this.t == this.H.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean w() {
        b90 b90Var = this.D;
        return b90Var == null || x(b90Var.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean x(long j) {
        return j - b() >= this.q.h;
    }

    public abstract void y(fh1 fh1Var, float f, float f2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z(fh1 fh1Var, boolean z) {
        fh1Var.q(this, z);
        this.u = this.H.a;
    }
}
