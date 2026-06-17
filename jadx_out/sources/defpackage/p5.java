package defpackage;

import android.util.SparseArray;
import defpackage.hd3;
import defpackage.jq2;
import defpackage.pd;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface p5 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final long a;
        public final no4 b;
        public final int c;
        public final jq2.b d;
        public final long e;
        public final no4 f;
        public final int g;
        public final jq2.b h;
        public final long i;
        public final long j;

        public a(long j, no4 no4Var, int i, jq2.b bVar, long j2, no4 no4Var2, int i2, jq2.b bVar2, long j3, long j4) {
            this.a = j;
            this.b = no4Var;
            this.c = i;
            this.d = bVar;
            this.e = j2;
            this.f = no4Var2;
            this.g = i2;
            this.h = bVar2;
            this.i = j3;
            this.j = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.a == aVar.a && this.c == aVar.c && this.e == aVar.e && this.g == aVar.g && this.i == aVar.i && this.j == aVar.j && Objects.equals(this.b, aVar.b) && Objects.equals(this.d, aVar.d) && Objects.equals(this.f, aVar.f) && Objects.equals(this.h, aVar.h)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final o21 a;
        public final SparseArray b;

        public b(o21 o21Var, SparseArray sparseArray) {
            this.a = o21Var;
            SparseArray sparseArray2 = new SparseArray(o21Var.d());
            for (int i = 0; i < o21Var.d(); i++) {
                int iC = o21Var.c(i);
                sparseArray2.append(iC, (a) gg3.q((a) sparseArray.get(iC)));
            }
            this.b = sparseArray2;
        }

        public boolean a(int i) {
            return this.a.a(i);
        }

        public int b(int i) {
            return this.a.c(i);
        }

        public a c(int i) {
            return (a) gg3.q((a) this.b.get(i));
        }

        public int d() {
            return this.a.d();
        }
    }

    default void A(a aVar, oh2 oh2Var) {
    }

    default void A0(a aVar, String str, long j) {
    }

    default void B(a aVar, int i, int i2) {
    }

    default void B0(a aVar, int i) {
    }

    default void C(a aVar, String str, long j, long j2) {
    }

    default void C0(a aVar) {
    }

    default void D(a aVar, int i) {
    }

    void D0(a aVar, ac3 ac3Var);

    default void E(a aVar, yb ybVar) {
    }

    void E0(hd3 hd3Var, b bVar);

    default void G(a aVar, pd.a aVar2) {
    }

    default void H(a aVar, Exception exc) {
    }

    default void I(a aVar, kk0 kk0Var) {
    }

    void J(a aVar, e35 e35Var);

    default void K(a aVar, int i) {
    }

    default void L(a aVar, int i) {
    }

    default void M(a aVar, String str, long j, long j2) {
    }

    default void N(a aVar, fg2 fg2Var, int i) {
    }

    default void O(a aVar, ph2 ph2Var) {
    }

    default void P(a aVar, int i, int i2, int i3, float f) {
    }

    default void Q(a aVar, gb0 gb0Var) {
    }

    default void R(a aVar, boolean z, int i) {
    }

    default void S(a aVar, cr1 cr1Var) {
    }

    default void T(a aVar, t41 t41Var, lb0 lb0Var) {
    }

    default void U(a aVar, Object obj, long j) {
    }

    default void V(a aVar, String str) {
    }

    default void W(a aVar, String str, long j) {
    }

    default void Y(a aVar, pd.a aVar2) {
    }

    default void Z(a aVar, int i, int i2, boolean z) {
    }

    default void a(a aVar, boolean z) {
    }

    default void a0(a aVar, gb0 gb0Var) {
    }

    default void b(a aVar) {
    }

    default void b0(a aVar, int i) {
    }

    default void c(a aVar, ac3 ac3Var) {
    }

    default void c0(a aVar, int i) {
    }

    default void d(a aVar, boolean z) {
    }

    default void d0(a aVar, lr4 lr4Var) {
    }

    default void e(a aVar, Exception exc) {
    }

    default void e0(a aVar, long j) {
    }

    default void f0(a aVar, ty1 ty1Var, oh2 oh2Var) {
    }

    default void g(a aVar, Exception exc) {
    }

    default void g0(a aVar, float f) {
    }

    default void h(a aVar, List list) {
    }

    default void h0(a aVar, int i, long j, long j2) {
    }

    default void i(a aVar) {
    }

    void i0(a aVar, int i, long j, long j2);

    default void j(a aVar, String str) {
    }

    void j0(a aVar, gb0 gb0Var);

    default void k(a aVar, boolean z) {
    }

    void k0(a aVar, oh2 oh2Var);

    void l(a aVar, hd3.e eVar, hd3.e eVar2, int i);

    default void l0(a aVar, t41 t41Var, lb0 lb0Var) {
    }

    default void m(a aVar, long j) {
    }

    default void m0(a aVar, int i, boolean z) {
    }

    default void n(a aVar, dc3 dc3Var) {
    }

    default void n0(a aVar, hd3.b bVar) {
    }

    default void o(a aVar, long j) {
    }

    default void o0(a aVar) {
    }

    default void p0(a aVar, w50 w50Var) {
    }

    void q(a aVar, ty1 ty1Var, oh2 oh2Var, IOException iOException, boolean z);

    default void q0(a aVar, int i, long j) {
    }

    default void r(a aVar, long j, int i) {
    }

    default void r0(a aVar, ty1 ty1Var, oh2 oh2Var) {
    }

    default void s(a aVar, xs2 xs2Var) {
    }

    default void s0(a aVar, boolean z) {
    }

    default void t(a aVar, int i) {
    }

    default void t0(a aVar, boolean z, int i) {
    }

    default void u(a aVar) {
    }

    default void u0(a aVar, ph2 ph2Var) {
    }

    default void v(a aVar, long j) {
    }

    default void v0(a aVar, gb0 gb0Var) {
    }

    default void w(a aVar) {
    }

    default void w0(a aVar, int i) {
    }

    default void x(a aVar, ty1 ty1Var, oh2 oh2Var) {
    }

    default void x0(a aVar, xr4 xr4Var) {
    }

    default void y(a aVar) {
    }

    default void y0(a aVar, Exception exc) {
    }

    default void z(a aVar, ty1 ty1Var, oh2 oh2Var, int i) {
    }

    default void z0(a aVar, boolean z) {
    }
}
