package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.hierynomus.protocol.commons.buffer.Buffer;
import java.util.Map;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pi implements Cloneable {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean E;
    public int f;
    public Drawable j;
    public int k;
    public Drawable l;
    public int m;
    public boolean r;
    public Drawable t;
    public int u;
    public boolean y;
    public Resources.Theme z;
    public float g = 1.0f;
    public zl0 h = zl0.e;
    public ug3 i = ug3.NORMAL;
    public boolean n = true;
    public int o = -1;
    public int p = -1;
    public wq1 q = ls0.c();
    public boolean s = true;
    public u63 v = new u63();
    public Map w = new qo();
    public Class x = Object.class;
    public boolean D = true;

    public static boolean K(int i, int i2) {
        return (i & i2) != 0;
    }

    public final Resources.Theme A() {
        return this.z;
    }

    public final Map B() {
        return this.w;
    }

    public final boolean C() {
        return this.E;
    }

    public final boolean D() {
        return this.B;
    }

    public final boolean E() {
        return this.A;
    }

    public final boolean F(pi piVar) {
        return Float.compare(piVar.g, this.g) == 0 && this.k == piVar.k && iy4.e(this.j, piVar.j) && this.m == piVar.m && iy4.e(this.l, piVar.l) && this.u == piVar.u && iy4.e(this.t, piVar.t) && this.n == piVar.n && this.o == piVar.o && this.p == piVar.p && this.r == piVar.r && this.s == piVar.s && this.B == piVar.B && this.C == piVar.C && this.h.equals(piVar.h) && this.i == piVar.i && this.v.equals(piVar.v) && this.w.equals(piVar.w) && this.x.equals(piVar.x) && iy4.e(this.q, piVar.q) && iy4.e(this.z, piVar.z);
    }

    public final boolean G() {
        return this.n;
    }

    public final boolean H() {
        return J(8);
    }

    public boolean I() {
        return this.D;
    }

    public final boolean J(int i) {
        return K(this.f, i);
    }

    public final boolean L() {
        return this.s;
    }

    public final boolean M() {
        return this.r;
    }

    public final boolean N() {
        return J(2048);
    }

    public final boolean O() {
        return iy4.u(this.p, this.o);
    }

    public pi P() {
        this.y = true;
        return Z();
    }

    public pi Q() {
        return U(hn0.e, new gr());
    }

    public pi R() {
        return T(hn0.d, new ir());
    }

    public pi S() {
        return T(hn0.c, new q11());
    }

    public final pi T(hn0 hn0Var, ns4 ns4Var) {
        return Y(hn0Var, ns4Var, false);
    }

    public final pi U(hn0 hn0Var, ns4 ns4Var) {
        if (this.A) {
            return clone().U(hn0Var, ns4Var);
        }
        h(hn0Var);
        return h0(ns4Var, false);
    }

    public pi V(int i, int i2) {
        if (this.A) {
            return clone().V(i, i2);
        }
        this.p = i;
        this.o = i2;
        this.f |= 512;
        return a0();
    }

    public pi W(ug3 ug3Var) {
        if (this.A) {
            return clone().W(ug3Var);
        }
        this.i = (ug3) fg3.e(ug3Var);
        this.f |= 8;
        return a0();
    }

    public final pi X(hn0 hn0Var, ns4 ns4Var) {
        return Y(hn0Var, ns4Var, true);
    }

    public final pi Y(hn0 hn0Var, ns4 ns4Var, boolean z) {
        pi piVarF0 = z ? f0(hn0Var, ns4Var) : U(hn0Var, ns4Var);
        piVarF0.D = true;
        return piVarF0;
    }

    public final pi Z() {
        return this;
    }

    public pi a(pi piVar) {
        if (this.A) {
            return clone().a(piVar);
        }
        if (K(piVar.f, 2)) {
            this.g = piVar.g;
        }
        if (K(piVar.f, 262144)) {
            this.B = piVar.B;
        }
        if (K(piVar.f, 1048576)) {
            this.E = piVar.E;
        }
        if (K(piVar.f, 4)) {
            this.h = piVar.h;
        }
        if (K(piVar.f, 8)) {
            this.i = piVar.i;
        }
        if (K(piVar.f, 16)) {
            this.j = piVar.j;
            this.k = 0;
            this.f &= -33;
        }
        if (K(piVar.f, 32)) {
            this.k = piVar.k;
            this.j = null;
            this.f &= -17;
        }
        if (K(piVar.f, 64)) {
            this.l = piVar.l;
            this.m = 0;
            this.f &= -129;
        }
        if (K(piVar.f, 128)) {
            this.m = piVar.m;
            this.l = null;
            this.f &= -65;
        }
        if (K(piVar.f, Buffer.DEFAULT_SIZE)) {
            this.n = piVar.n;
        }
        if (K(piVar.f, 512)) {
            this.p = piVar.p;
            this.o = piVar.o;
        }
        if (K(piVar.f, 1024)) {
            this.q = piVar.q;
        }
        if (K(piVar.f, okio.internal.Buffer.SEGMENTING_THRESHOLD)) {
            this.x = piVar.x;
        }
        if (K(piVar.f, 8192)) {
            this.t = piVar.t;
            this.u = 0;
            this.f &= -16385;
        }
        if (K(piVar.f, Http2.INITIAL_MAX_FRAME_SIZE)) {
            this.u = piVar.u;
            this.t = null;
            this.f &= -8193;
        }
        if (K(piVar.f, 32768)) {
            this.z = piVar.z;
        }
        if (K(piVar.f, 65536)) {
            this.s = piVar.s;
        }
        if (K(piVar.f, 131072)) {
            this.r = piVar.r;
        }
        if (K(piVar.f, 2048)) {
            this.w.putAll(piVar.w);
            this.D = piVar.D;
        }
        if (K(piVar.f, 524288)) {
            this.C = piVar.C;
        }
        if (!this.s) {
            this.w.clear();
            int i = this.f;
            this.r = false;
            this.f = i & (-133121);
            this.D = true;
        }
        this.f |= piVar.f;
        this.v.d(piVar.v);
        return a0();
    }

    public final pi a0() {
        if (!this.y) {
            return Z();
        }
        e04.a("You cannot modify locked T, consider clone()");
        return null;
    }

    public pi b() {
        if (!this.y || this.A) {
            this.A = true;
            return P();
        }
        e04.a("You cannot auto lock an already locked options object, try clone() first");
        return null;
    }

    public pi b0(s63 s63Var, Object obj) {
        if (this.A) {
            return clone().b0(s63Var, obj);
        }
        fg3.e(s63Var);
        fg3.e(obj);
        this.v.e(s63Var, obj);
        return a0();
    }

    public pi c() {
        return f0(hn0.e, new gr());
    }

    public pi c0(wq1 wq1Var) {
        if (this.A) {
            return clone().c0(wq1Var);
        }
        this.q = (wq1) fg3.e(wq1Var);
        this.f |= 1024;
        return a0();
    }

    public pi d() {
        return f0(hn0.d, new au());
    }

    public pi d0(float f) {
        if (this.A) {
            return clone().d0(f);
        }
        if (f < 0.0f || f > 1.0f) {
            jl.a("sizeMultiplier must be between 0 and 1");
            return null;
        }
        this.g = f;
        this.f |= 2;
        return a0();
    }

    @Override // 
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public pi clone() {
        try {
            pi piVar = (pi) super.clone();
            u63 u63Var = new u63();
            piVar.v = u63Var;
            u63Var.d(this.v);
            qo qoVar = new qo();
            piVar.w = qoVar;
            qoVar.putAll(this.w);
            piVar.y = false;
            piVar.A = false;
            return piVar;
        } catch (CloneNotSupportedException e) {
            wg1.a(e);
            return null;
        }
    }

    public pi e0(boolean z) {
        if (this.A) {
            return clone().e0(true);
        }
        this.n = !z;
        this.f |= Buffer.DEFAULT_SIZE;
        return a0();
    }

    public boolean equals(Object obj) {
        if (obj instanceof pi) {
            return F((pi) obj);
        }
        return false;
    }

    public pi f(Class cls) {
        if (this.A) {
            return clone().f(cls);
        }
        this.x = (Class) fg3.e(cls);
        this.f |= okio.internal.Buffer.SEGMENTING_THRESHOLD;
        return a0();
    }

    public final pi f0(hn0 hn0Var, ns4 ns4Var) {
        if (this.A) {
            return clone().f0(hn0Var, ns4Var);
        }
        h(hn0Var);
        return g0(ns4Var);
    }

    public pi g(zl0 zl0Var) {
        if (this.A) {
            return clone().g(zl0Var);
        }
        this.h = (zl0) fg3.e(zl0Var);
        this.f |= 4;
        return a0();
    }

    public pi g0(ns4 ns4Var) {
        return h0(ns4Var, true);
    }

    public pi h(hn0 hn0Var) {
        return b0(hn0.h, (hn0) fg3.e(hn0Var));
    }

    public pi h0(ns4 ns4Var, boolean z) {
        if (this.A) {
            return clone().h0(ns4Var, z);
        }
        yn0 yn0Var = new yn0(ns4Var, z);
        i0(Bitmap.class, ns4Var, z);
        i0(Drawable.class, yn0Var, z);
        i0(BitmapDrawable.class, yn0Var.c(), z);
        i0(r91.class, new v91(ns4Var), z);
        return a0();
    }

    public int hashCode() {
        return iy4.p(this.z, iy4.p(this.q, iy4.p(this.x, iy4.p(this.w, iy4.p(this.v, iy4.p(this.i, iy4.p(this.h, iy4.q(this.C, iy4.q(this.B, iy4.q(this.s, iy4.q(this.r, iy4.o(this.p, iy4.o(this.o, iy4.q(this.n, iy4.p(this.t, iy4.o(this.u, iy4.p(this.l, iy4.o(this.m, iy4.p(this.j, iy4.o(this.k, iy4.m(this.g)))))))))))))))))))));
    }

    public pi i(int i) {
        if (this.A) {
            return clone().i(i);
        }
        this.k = i;
        int i2 = this.f | 32;
        this.j = null;
        this.f = i2 & (-17);
        return a0();
    }

    public pi i0(Class cls, ns4 ns4Var, boolean z) {
        if (this.A) {
            return clone().i0(cls, ns4Var, z);
        }
        fg3.e(cls);
        fg3.e(ns4Var);
        this.w.put(cls, ns4Var);
        int i = this.f;
        this.s = true;
        this.f = 67584 | i;
        this.D = false;
        if (z) {
            this.f = i | 198656;
            this.r = true;
        }
        return a0();
    }

    public pi j() {
        return X(hn0.c, new q11());
    }

    public pi j0(boolean z) {
        if (this.A) {
            return clone().j0(z);
        }
        this.E = z;
        this.f |= 1048576;
        return a0();
    }

    public pi k(long j) {
        return b0(g25.d, Long.valueOf(j));
    }

    public final zl0 l() {
        return this.h;
    }

    public final int m() {
        return this.k;
    }

    public final Drawable n() {
        return this.j;
    }

    public final Drawable o() {
        return this.t;
    }

    public final int p() {
        return this.u;
    }

    public final boolean q() {
        return this.C;
    }

    public final u63 r() {
        return this.v;
    }

    public final int s() {
        return this.o;
    }

    public final int t() {
        return this.p;
    }

    public final Drawable u() {
        return this.l;
    }

    public final int v() {
        return this.m;
    }

    public final ug3 w() {
        return this.i;
    }

    public final Class x() {
        return this.x;
    }

    public final wq1 y() {
        return this.q;
    }

    public final float z() {
        return this.g;
    }
}
