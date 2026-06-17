package defpackage;

import defpackage.l42;
import defpackage.ol1;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class iv implements io3 {
    public final hv a;
    public int b;
    public int c;
    public int d = 0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iv(hv hvVar) {
        hv hvVar2 = (hv) bl1.b(hvVar, "input");
        this.a = hvVar2;
        hvVar2.e = this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static iv P(hv hvVar) {
        Object obj = hvVar.e;
        return obj != null ? (iv) obj : new iv(hvVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public int A() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.G();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return aa5.a(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void B(List list) throws ol1.a {
        U(list, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void C(List list) throws ol1.a {
        U(list, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public hn D() throws ol1.a {
        W(2);
        return this.a.r();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void E(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof s21;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 2) {
                int iH = this.a.H();
                X(iH);
                int iF = this.a.f() + iH;
                do {
                    list.add(Float.valueOf(this.a.w()));
                } while (this.a.f() < iF);
                return;
            }
            if (iB != 5) {
                throw ol1.e();
            }
            do {
                list.add(Float.valueOf(this.a.w()));
                if (this.a.g()) {
                    return;
                } else {
                    iG = this.a.G();
                }
            } while (iG == this.b);
            this.d = iG;
            return;
        }
        s21 s21Var = (s21) list;
        int iB2 = aa5.b(i);
        if (iB2 == 2) {
            int iH2 = this.a.H();
            X(iH2);
            int iF2 = this.a.f() + iH2;
            do {
                s21Var.e(this.a.w());
            } while (this.a.f() < iF2);
            return;
        }
        if (iB2 != 5) {
            throw ol1.e();
        }
        do {
            s21Var.e(this.a.w());
            if (this.a.g()) {
                return;
            } else {
                iG2 = this.a.G();
            }
        } while (iG2 == this.b);
        this.d = iG2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public int F() throws ol1.a {
        W(0);
        return this.a.x();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public boolean G() {
        int i;
        if (this.a.g() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.J(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public int H() throws ol1.a {
        W(5);
        return this.a.A();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void I(List list) throws ol1.a {
        int iG;
        if (aa5.b(this.b) != 2) {
            throw ol1.e();
        }
        do {
            list.add(D());
            if (this.a.g()) {
                return;
            } else {
                iG = this.a.G();
            }
        } while (iG == this.b);
        this.d = iG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void J(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof cn0;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 1) {
                do {
                    list.add(Double.valueOf(this.a.s()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iH = this.a.H();
            Y(iH);
            int iF = this.a.f() + iH;
            do {
                list.add(Double.valueOf(this.a.s()));
            } while (this.a.f() < iF);
            return;
        }
        cn0 cn0Var = (cn0) list;
        int iB2 = aa5.b(i);
        if (iB2 == 1) {
            do {
                cn0Var.e(this.a.s());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iH2 = this.a.H();
        Y(iH2);
        int iF2 = this.a.f() + iH2;
        do {
            cn0Var.e(this.a.s());
        } while (this.a.f() < iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void K(List list, py3 py3Var, xy0 xy0Var) throws ol1.a {
        int iG;
        if (aa5.b(this.b) != 3) {
            throw ol1.e();
        }
        int i = this.b;
        do {
            list.add(S(py3Var, xy0Var));
            if (this.a.g() || this.d != 0) {
                return;
            } else {
                iG = this.a.G();
            }
        } while (iG == i);
        this.d = iG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public Object L(Class cls, xy0 xy0Var) throws ol1.a {
        W(3);
        return S(li3.a().b(cls), xy0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public long M() throws ol1.a {
        W(0);
        return this.a.y();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public String N() throws ol1.a {
        W(2);
        return this.a.F();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void O(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof s02;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.a.v()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iH = this.a.H();
            Y(iH);
            int iF = this.a.f() + iH;
            do {
                list.add(Long.valueOf(this.a.v()));
            } while (this.a.f() < iF);
            return;
        }
        s02 s02Var = (s02) list;
        int iB2 = aa5.b(i);
        if (iB2 == 1) {
            do {
                s02Var.f(this.a.v());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iH2 = this.a.H();
        Y(iH2);
        int iF2 = this.a.f() + iH2;
        do {
            s02Var.f(this.a.v());
        } while (this.a.f() < iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q(Object obj, py3 py3Var, xy0 xy0Var) {
        int i = this.c;
        this.c = aa5.c(aa5.a(this.b), 4);
        try {
            py3Var.d(obj, this, xy0Var);
            if (this.b == this.c) {
            } else {
                throw ol1.h();
            }
        } finally {
            this.c = i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R(Object obj, py3 py3Var, xy0 xy0Var) throws ol1 {
        int iH = this.a.H();
        this.a.b();
        int iP = this.a.p(iH);
        this.a.a++;
        py3Var.d(obj, this, xy0Var);
        this.a.a(0);
        r3.a--;
        this.a.o(iP);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object S(py3 py3Var, xy0 xy0Var) {
        Object objNewInstance = py3Var.newInstance();
        Q(objNewInstance, py3Var, xy0Var);
        py3Var.b(objNewInstance);
        return objNewInstance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object T(py3 py3Var, xy0 xy0Var) throws ol1 {
        Object objNewInstance = py3Var.newInstance();
        R(objNewInstance, py3Var, xy0Var);
        py3Var.b(objNewInstance);
        return objNewInstance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void U(List list, boolean z) throws ol1.a {
        int iG;
        if (aa5.b(this.b) != 2) {
            throw ol1.e();
        }
        do {
            list.add(z ? N() : readString());
            if (this.a.g()) {
                return;
            } else {
                iG = this.a.G();
            }
        } while (iG == this.b);
        this.d = iG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V(int i) throws ol1 {
        if (this.a.f() != i) {
            throw ol1.m();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W(int i) throws ol1.a {
        if (aa5.b(this.b) != i) {
            throw ol1.e();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X(int i) throws ol1 {
        if ((i & 3) != 0) {
            throw ol1.h();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y(int i) throws ol1 {
        if ((i & 7) != 0) {
            throw ol1.h();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public int a() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public Object b(Class cls, xy0 xy0Var) throws ol1.a {
        W(2);
        return T(li3.a().b(cls), xy0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void c(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof nk1;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.a.C()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iF = this.a.f() + this.a.H();
            do {
                list.add(Integer.valueOf(this.a.C()));
            } while (this.a.f() < iF);
            V(iF);
            return;
        }
        nk1 nk1Var = (nk1) list;
        int iB2 = aa5.b(i);
        if (iB2 == 0) {
            do {
                nk1Var.e(this.a.C());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iF2 = this.a.f() + this.a.H();
        do {
            nk1Var.e(this.a.C());
        } while (this.a.f() < iF2);
        V(iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public long d() throws ol1.a {
        W(0);
        return this.a.I();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public long e() throws ol1.a {
        W(1);
        return this.a.v();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void f(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof nk1;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 2) {
                int iH = this.a.H();
                X(iH);
                int iF = this.a.f() + iH;
                do {
                    list.add(Integer.valueOf(this.a.A()));
                } while (this.a.f() < iF);
                return;
            }
            if (iB != 5) {
                throw ol1.e();
            }
            do {
                list.add(Integer.valueOf(this.a.A()));
                if (this.a.g()) {
                    return;
                } else {
                    iG = this.a.G();
                }
            } while (iG == this.b);
            this.d = iG;
            return;
        }
        nk1 nk1Var = (nk1) list;
        int iB2 = aa5.b(i);
        if (iB2 == 2) {
            int iH2 = this.a.H();
            X(iH2);
            int iF2 = this.a.f() + iH2;
            do {
                nk1Var.e(this.a.A());
            } while (this.a.f() < iF2);
            return;
        }
        if (iB2 != 5) {
            throw ol1.e();
        }
        do {
            nk1Var.e(this.a.A());
            if (this.a.g()) {
                return;
            } else {
                iG2 = this.a.G();
            }
        } while (iG2 == this.b);
        this.d = iG2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void g(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof s02;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.a.D()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iF = this.a.f() + this.a.H();
            do {
                list.add(Long.valueOf(this.a.D()));
            } while (this.a.f() < iF);
            V(iF);
            return;
        }
        s02 s02Var = (s02) list;
        int iB2 = aa5.b(i);
        if (iB2 == 0) {
            do {
                s02Var.f(this.a.D());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iF2 = this.a.f() + this.a.H();
        do {
            s02Var.f(this.a.D());
        } while (this.a.f() < iF2);
        V(iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void h(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof nk1;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.a.H()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iF = this.a.f() + this.a.H();
            do {
                list.add(Integer.valueOf(this.a.H()));
            } while (this.a.f() < iF);
            V(iF);
            return;
        }
        nk1 nk1Var = (nk1) list;
        int iB2 = aa5.b(i);
        if (iB2 == 0) {
            do {
                nk1Var.e(this.a.H());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iF2 = this.a.f() + this.a.H();
        do {
            nk1Var.e(this.a.H());
        } while (this.a.f() < iF2);
        V(iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public int i() throws ol1.a {
        W(5);
        return this.a.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public boolean j() throws ol1.a {
        W(0);
        return this.a.q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void k(List list, py3 py3Var, xy0 xy0Var) throws ol1.a {
        int iG;
        if (aa5.b(this.b) != 2) {
            throw ol1.e();
        }
        int i = this.b;
        do {
            list.add(T(py3Var, xy0Var));
            if (this.a.g() || this.d != 0) {
                return;
            } else {
                iG = this.a.G();
            }
        } while (iG == i);
        this.d = iG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void l(Object obj, py3 py3Var, xy0 xy0Var) throws ol1 {
        W(2);
        R(obj, py3Var, xy0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void m(Object obj, py3 py3Var, xy0 xy0Var) throws ol1.a {
        W(3);
        Q(obj, py3Var, xy0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public long n() throws ol1.a {
        W(1);
        return this.a.B();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void o(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof s02;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.a.I()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iF = this.a.f() + this.a.H();
            do {
                list.add(Long.valueOf(this.a.I()));
            } while (this.a.f() < iF);
            V(iF);
            return;
        }
        s02 s02Var = (s02) list;
        int iB2 = aa5.b(i);
        if (iB2 == 0) {
            do {
                s02Var.f(this.a.I());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iF2 = this.a.f() + this.a.H();
        do {
            s02Var.f(this.a.I());
        } while (this.a.f() < iF2);
        V(iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public int p() throws ol1.a {
        W(0);
        return this.a.H();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void q(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof s02;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.a.y()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iF = this.a.f() + this.a.H();
            do {
                list.add(Long.valueOf(this.a.y()));
            } while (this.a.f() < iF);
            V(iF);
            return;
        }
        s02 s02Var = (s02) list;
        int iB2 = aa5.b(i);
        if (iB2 == 0) {
            do {
                s02Var.f(this.a.y());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iF2 = this.a.f() + this.a.H();
        do {
            s02Var.f(this.a.y());
        } while (this.a.f() < iF2);
        V(iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void r(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof s02;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.a.B()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iH = this.a.H();
            Y(iH);
            int iF = this.a.f() + iH;
            do {
                list.add(Long.valueOf(this.a.B()));
            } while (this.a.f() < iF);
            return;
        }
        s02 s02Var = (s02) list;
        int iB2 = aa5.b(i);
        if (iB2 == 1) {
            do {
                s02Var.f(this.a.B());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iH2 = this.a.H();
        Y(iH2);
        int iF2 = this.a.f() + iH2;
        do {
            s02Var.f(this.a.B());
        } while (this.a.f() < iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public double readDouble() throws ol1.a {
        W(1);
        return this.a.s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public float readFloat() throws ol1.a {
        W(5);
        return this.a.w();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public String readString() throws ol1.a {
        W(2);
        return this.a.E();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void s(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof nk1;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.a.x()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iF = this.a.f() + this.a.H();
            do {
                list.add(Integer.valueOf(this.a.x()));
            } while (this.a.f() < iF);
            V(iF);
            return;
        }
        nk1 nk1Var = (nk1) list;
        int iB2 = aa5.b(i);
        if (iB2 == 0) {
            do {
                nk1Var.e(this.a.x());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iF2 = this.a.f() + this.a.H();
        do {
            nk1Var.e(this.a.x());
        } while (this.a.f() < iF2);
        V(iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void t(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof nk1;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.a.t()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iF = this.a.f() + this.a.H();
            do {
                list.add(Integer.valueOf(this.a.t()));
            } while (this.a.f() < iF);
            V(iF);
            return;
        }
        nk1 nk1Var = (nk1) list;
        int iB2 = aa5.b(i);
        if (iB2 == 0) {
            do {
                nk1Var.e(this.a.t());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iF2 = this.a.f() + this.a.H();
        do {
            nk1Var.e(this.a.t());
        } while (this.a.f() < iF2);
        V(iF2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public int u() throws ol1.a {
        W(0);
        return this.a.t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void v(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof nk1;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 2) {
                int iH = this.a.H();
                X(iH);
                int iF = this.a.f() + iH;
                do {
                    list.add(Integer.valueOf(this.a.u()));
                } while (this.a.f() < iF);
                return;
            }
            if (iB != 5) {
                throw ol1.e();
            }
            do {
                list.add(Integer.valueOf(this.a.u()));
                if (this.a.g()) {
                    return;
                } else {
                    iG = this.a.G();
                }
            } while (iG == this.b);
            this.d = iG;
            return;
        }
        nk1 nk1Var = (nk1) list;
        int iB2 = aa5.b(i);
        if (iB2 == 2) {
            int iH2 = this.a.H();
            X(iH2);
            int iF2 = this.a.f() + iH2;
            do {
                nk1Var.e(this.a.u());
            } while (this.a.f() < iF2);
            return;
        }
        if (iB2 != 5) {
            throw ol1.e();
        }
        do {
            nk1Var.e(this.a.u());
            if (this.a.g()) {
                return;
            } else {
                iG2 = this.a.G();
            }
        } while (iG2 == this.b);
        this.d = iG2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void w(Map map, l42.a aVar, xy0 xy0Var) throws ol1.a {
        W(2);
        this.a.p(this.a.H());
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public int x() throws ol1.a {
        W(0);
        return this.a.C();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public long y() throws ol1.a {
        W(0);
        return this.a.D();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.io3
    public void z(List list) throws ol1 {
        int iG;
        int iG2;
        boolean z = list instanceof al;
        int i = this.b;
        if (!z) {
            int iB = aa5.b(i);
            if (iB == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.q()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iG = this.a.G();
                    }
                } while (iG == this.b);
                this.d = iG;
                return;
            }
            if (iB != 2) {
                throw ol1.e();
            }
            int iF = this.a.f() + this.a.H();
            do {
                list.add(Boolean.valueOf(this.a.q()));
            } while (this.a.f() < iF);
            V(iF);
            return;
        }
        al alVar = (al) list;
        int iB2 = aa5.b(i);
        if (iB2 == 0) {
            do {
                alVar.f(this.a.q());
                if (this.a.g()) {
                    return;
                } else {
                    iG2 = this.a.G();
                }
            } while (iG2 == this.b);
            this.d = iG2;
            return;
        }
        if (iB2 != 2) {
            throw ol1.e();
        }
        int iF2 = this.a.f() + this.a.H();
        do {
            alVar.f(this.a.q());
        } while (this.a.f() < iF2);
        V(iF2);
    }
}
