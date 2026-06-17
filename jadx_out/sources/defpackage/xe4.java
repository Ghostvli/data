package defpackage;

import defpackage.ue4;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class xe4 extends qj1 {
    public static final String X = "xe4";
    public String A;
    public String B;
    public List C;
    public List D;
    public List E;
    public List F;
    public String G;
    public String H;
    public List I;
    public long J;
    public List K;
    public String L;
    public ue4.a M;
    public String N;
    public String O;
    public String P;
    public Locale Q;
    public List R;
    public List S;
    public List T;
    public boolean U;
    public l20 V;
    public List W;
    public gf4 l;
    public List m;
    public String n;
    public qa0 o;
    public long p;
    public int q;
    public qj0 r;
    public long s;
    public long t;
    public long u;
    public String v;
    public String w;
    public List x;
    public boolean y;
    public long z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends fz0 {
        public a(String str) {
            super(str);
        }
    }

    public xe4(int i, String str, String str2, gf4 gf4Var, String str3, String str4, int i2) {
        super(i, str3, str, str2, str4);
        List list = Collections.EMPTY_LIST;
        this.m = list;
        this.p = -1L;
        this.s = -1L;
        this.t = -1L;
        this.u = -1L;
        this.v = "";
        this.w = "";
        this.x = list;
        this.y = false;
        this.z = -1L;
        this.A = "";
        this.B = "";
        this.C = list;
        this.D = list;
        this.E = list;
        this.F = list;
        this.G = "";
        this.H = "";
        this.I = list;
        this.J = 0L;
        this.K = list;
        this.L = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = null;
        this.R = list;
        this.S = list;
        this.T = list;
        this.U = false;
        this.V = l20.AVAILABLE;
        this.W = list;
        this.l = gf4Var;
        this.q = i2;
        kz0.b(X, "Created {}", this);
    }

    public static xe4 h(ue4 ue4Var) throws fz0 {
        String strO = ue4Var.o();
        gf4 gf4VarJ = ue4Var.J();
        String strH = ue4Var.h();
        String strJ = ue4Var.j();
        int iQ = ue4Var.q();
        if (gf4VarJ == gf4.NONE || yy4.n(strO) || yy4.n(strH) || strJ == null || iQ == -1) {
            throw new fz0("Some important stream information was not given.");
        }
        return new xe4(ue4Var.m(), strO, ue4Var.k(), gf4VarJ, strH, strJ, iQ);
    }

    public static void i(xe4 xe4Var, ue4 ue4Var) {
        try {
            xe4Var.W(ue4Var.R());
        } catch (Exception e) {
            xe4Var.b(e);
        }
        try {
            xe4Var.C(ue4Var.C());
        } catch (Exception e2) {
            xe4Var.b(e2);
        }
        try {
            xe4Var.Z(ue4Var.W());
        } catch (Exception e3) {
            xe4Var.b(e3);
        }
        try {
            xe4Var.b0(ue4Var.Y());
        } catch (Exception e4) {
            xe4Var.b(e4);
        }
        try {
            xe4Var.Y(ue4Var.V());
        } catch (Exception e5) {
            xe4Var.b(e5);
        }
        try {
            xe4Var.c0(ue4Var.d0());
        } catch (Exception e6) {
            xe4Var.b(e6);
        }
        try {
            xe4Var.a0(ue4Var.X());
        } catch (Exception e7) {
            xe4Var.b(e7);
        }
        try {
            xe4Var.Q(ue4Var.L());
        } catch (Exception e8) {
            xe4Var.b(e8);
        }
        try {
            xe4Var.R(ue4Var.M());
        } catch (Exception e9) {
            xe4Var.b(e9);
        }
        try {
            xe4Var.P(ue4Var.K());
        } catch (Exception e10) {
            xe4Var.b(e10);
        }
        try {
            xe4Var.A(ue4Var.v());
        } catch (Exception e11) {
            xe4Var.b(e11);
        }
        try {
            xe4Var.f0(ue4Var.b0());
        } catch (Exception e12) {
            xe4Var.b(e12);
        }
        try {
            xe4Var.V(ue4Var.Q());
        } catch (Exception e13) {
            xe4Var.b(e13);
        }
        try {
            xe4Var.X(ue4Var.U());
        } catch (Exception e14) {
            xe4Var.b(e14);
        }
        try {
            xe4Var.N(ue4Var.S());
        } catch (Exception e15) {
            xe4Var.b(e15);
        }
        try {
            xe4Var.H(ue4Var.E());
        } catch (Exception e16) {
            xe4Var.b(e16);
        }
        try {
            xe4Var.B(ue4Var.w());
        } catch (Exception e17) {
            xe4Var.b(e17);
        }
        try {
            xe4Var.S(ue4Var.N());
        } catch (Exception e18) {
            xe4Var.b(e18);
        }
        try {
            xe4Var.E(ue4Var.A());
        } catch (Exception e19) {
            xe4Var.b(e19);
        }
        try {
            xe4Var.K(ue4Var.G());
        } catch (Exception e20) {
            xe4Var.b(e20);
        }
        try {
            xe4Var.x(ue4Var.s());
        } catch (Exception e21) {
            xe4Var.b(e21);
        }
        try {
            xe4Var.G(ue4Var.D());
        } catch (Exception e22) {
            xe4Var.b(e22);
        }
        try {
            xe4Var.F(ue4Var.B());
        } catch (Exception e23) {
            xe4Var.b(e23);
        }
        try {
            xe4Var.U(ue4Var.P());
        } catch (Exception e24) {
            xe4Var.b(e24);
        }
        try {
            xe4Var.T(ue4Var.O());
        } catch (Exception e25) {
            xe4Var.b(e25);
        }
        try {
            xe4Var.O(ue4Var.I());
        } catch (Exception e26) {
            xe4Var.b(e26);
        }
        try {
            xe4Var.I(ue4Var.F());
        } catch (Exception e27) {
            xe4Var.b(e27);
        }
        try {
            xe4Var.J(ue4Var.y());
        } catch (Exception e28) {
            xe4Var.b(e28);
        }
        try {
            xe4Var.M(ue4Var.c0());
        } catch (Exception e29) {
            xe4Var.b(e29);
        }
        try {
            xe4Var.y(ue4Var.t());
        } catch (Exception e30) {
            xe4Var.b(e30);
        }
        xe4Var.L(iz0.a(xe4Var, ue4Var));
    }

    public static void j(xe4 xe4Var, ue4 ue4Var) throws y20, a {
        try {
            xe4Var.z(ue4Var.u());
        } catch (Exception e) {
            xe4Var.b(new fz0("Couldn't get DASH manifest", e));
        }
        try {
            xe4Var.D(ue4Var.z());
        } catch (Exception e2) {
            xe4Var.b(new fz0("Couldn't get HLS manifest", e2));
        }
        try {
            xe4Var.w(ue4Var.r());
        } catch (y20 e3) {
            throw e3;
        } catch (Exception e4) {
            xe4Var.b(new fz0("Couldn't get audio streams", e4));
        }
        try {
            xe4Var.e0(ue4Var.a0());
        } catch (Exception e5) {
            xe4Var.b(new fz0("Couldn't get video streams", e5));
        }
        try {
            xe4Var.d0(ue4Var.Z());
        } catch (Exception e6) {
            xe4Var.b(new fz0("Couldn't get video only streams", e6));
        }
        if (xe4Var.D.isEmpty() && xe4Var.E.isEmpty()) {
            throw new a("Could not get any stream. See error variable to get further details.");
        }
    }

    public static xe4 p(ue4 ue4Var) throws fz0 {
        kz0.b(X, "getInfo({extractor})", ue4Var);
        ue4Var.b();
        try {
            xe4 xe4VarH = h(ue4Var);
            j(xe4VarH, ue4Var);
            i(xe4VarH, ue4Var);
            return xe4VarH;
        } catch (fz0 e) {
            String strX = ue4Var.x();
            if (yy4.n(strX)) {
                throw e;
            }
            throw new x20(strX, e);
        }
    }

    public static xe4 q(wf4 wf4Var, String str) {
        kz0.b(X, "getInfo({service},{url})", wf4Var, str);
        return p(wf4Var.h(str));
    }

    public static xe4 r(String str) {
        kz0.b(X, "getInfo({url})", str);
        return q(a33.d(str), str);
    }

    public void A(qj0 qj0Var) {
        this.r = qj0Var;
    }

    public void B(long j) {
        this.u = j;
    }

    public void C(long j) {
        this.p = j;
    }

    public void D(String str) {
        this.H = str;
    }

    public void E(String str) {
        this.L = str;
    }

    public void F(Locale locale) {
        this.Q = locale;
    }

    public void G(String str) {
        this.O = str;
    }

    public void H(long j) {
        this.t = j;
    }

    public void I(List list) {
        this.T = list;
    }

    public void J(List list) {
        this.W = list;
    }

    public void K(ue4.a aVar) {
        this.M = aVar;
    }

    public void L(List list) {
        this.I = list;
    }

    public void M(boolean z) {
        this.U = z;
    }

    public void N(long j) {
        this.J = j;
    }

    public void O(List list) {
        this.S = list;
    }

    public void P(List list) {
        this.C = list;
    }

    public void Q(String str) {
        this.A = str;
    }

    public void R(String str) {
        this.B = str;
    }

    public void S(List list) {
        this.K = list;
    }

    public void T(String str) {
        this.P = str;
    }

    public void U(List list) {
        this.R = list;
    }

    public void V(String str) {
        this.n = str;
    }

    public void W(List list) {
        this.m = list;
    }

    public void X(qa0 qa0Var) {
        this.o = qa0Var;
    }

    public void Y(List list) {
        this.x = list;
    }

    public void Z(String str) {
        this.v = str;
    }

    public void a0(long j) {
        this.z = j;
    }

    public void b0(String str) {
        this.w = str;
    }

    public void c0(boolean z) {
        this.y = z;
    }

    public void d0(List list) {
        this.F = list;
    }

    public void e0(List list) {
        this.D = list;
    }

    public void f0(long j) {
        this.s = j;
    }

    public List k() {
        return this.E;
    }

    public String l() {
        return this.G;
    }

    public qj0 m() {
        return this.r;
    }

    public long n() {
        return this.p;
    }

    public String o() {
        return this.H;
    }

    public gf4 s() {
        return this.l;
    }

    public List t() {
        return this.m;
    }

    public String toString() {
        return X + "[serviceId=" + f() + ", url='" + g() + "', originalUrl='" + e() + "', id='" + c() + "', name='" + d() + "', streamType=" + this.l + ", ageLimit=" + this.q + "]";
    }

    public String u() {
        return this.v;
    }

    public List v() {
        return this.F;
    }

    public void w(List list) {
        this.E = list;
    }

    public void x(String str) {
        this.N = str;
    }

    public void y(l20 l20Var) {
        this.V = l20Var;
    }

    public void z(String str) {
        this.G = str;
    }
}
