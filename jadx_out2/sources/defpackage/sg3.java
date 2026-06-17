package defpackage;

import defpackage.wm0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sg3 implements r33 {
    public final l33 a;
    public final uj3 b;
    public final wm0.a c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(l33 l33Var, uj3 uj3Var, wm0.a aVar) {
            super(l33Var, uj3Var, aVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // sg3.b
        public boolean m(l33 l33Var) {
            return l33Var != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // sg3.b
        public boolean p(l33 l33Var) {
            if (l33Var == null || l33Var == this.a || this.d || b.l(l33Var)) {
                return false;
            }
            return ((l33Var instanceof sm4) && l33Var.P() == null && l33Var.B() == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends sg3 {
        public boolean d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(l33 l33Var, uj3 uj3Var, wm0.a aVar) {
            super(l33Var, uj3Var, aVar);
            this.d = false;
            while (l33Var != null) {
                if (q(al4.p, l33Var)) {
                    this.d = true;
                    return;
                }
                l33Var = l33Var.N();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean j(br0 br0Var) {
            br0 br0VarU0 = br0Var.u0();
            for (int i = 0; i < 5 && br0VarU0 != null; i++) {
                if (br0VarU0.H0() || !br0VarU0.i.g()) {
                    return true;
                }
                br0VarU0 = br0VarU0.A();
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean k(br0 br0Var) {
            l33 l33VarS = br0Var.s();
            for (int i = 0; i < 5 && l33VarS != null; i++) {
                if (!(l33VarS instanceof sm4)) {
                    return true;
                }
                l33VarS = l33VarS.B();
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean l(l33 l33Var) {
            return (l33Var instanceof sm4) && ((sm4) l33Var).g0();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static l33 n(l33 l33Var) {
            while (l(l33Var)) {
                l33Var = l33Var.B();
            }
            return l33Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static l33 o(l33 l33Var) {
            l33 l33VarP = l33Var.P();
            while (l(l33VarP)) {
                l33VarP = l33VarP.P();
            }
            return l33VarP;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean q(int i, l33 l33Var) {
            return (l33Var instanceof br0) && ((br0) l33Var).i.c(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.sg3
        public void d(br0 br0Var, int i) {
            if (p(br0Var)) {
                h(i);
            }
            super.d(br0Var, i);
            if (q(al4.p, br0Var)) {
                this.d = true;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.sg3
        public void e(ms1 ms1Var, int i) {
            if (p(ms1Var)) {
                h(i);
            }
            super.e(ms1Var, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.sg3
        public void f(br0 br0Var, int i) {
            if (p(n(br0Var.s()))) {
                h(i);
            }
            super.f(br0Var, i);
            if (this.d && br0Var.i.c(al4.p)) {
                do {
                    br0Var = br0Var.L();
                    if (br0Var == null) {
                        this.d = false;
                        return;
                    }
                } while (!br0Var.U0().k());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.sg3
        public void g(sm4 sm4Var, int i, int i2) {
            if (!this.d) {
                i = r(sm4Var, i | 4);
                if (!sm4Var.g0() && m(sm4Var.f) && p(sm4Var)) {
                    h(i2);
                }
            }
            super.g(sm4Var, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean m(l33 l33Var) {
            if (l33Var == null || !(l33Var instanceof br0)) {
                return false;
            }
            br0 br0Var = (br0) l33Var;
            return br0Var.z("br") || br0Var.H0() || (!br0Var.i.g() && ((br0Var.f instanceof wm0) || j(br0Var)));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean p(l33 l33Var) {
            if (l33Var != null && l33Var != this.a && !this.d && !l(l33Var)) {
                if (m(l33Var)) {
                    return true;
                }
                l33 l33VarO = o(l33Var);
                if (m(l33VarO)) {
                    return true;
                }
                br0 br0Var = l33Var.f;
                if (m(br0Var) && !br0Var.U0().c(al4.m) && k(br0Var)) {
                    return l33VarO == null || (!(l33VarO instanceof sm4) && (m(l33VarO) || !(l33VarO instanceof br0)));
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int r(sm4 sm4Var, int i) {
            if (!m(sm4Var.f)) {
                return i;
            }
            l33 l33VarP = sm4Var.P();
            l33 l33VarB = sm4Var.B();
            if ((!(l33VarP instanceof br0) || m(l33VarP)) && (l33VarP == null || (!(l33VarP instanceof sm4) && p(l33VarP)))) {
                i |= 8;
            }
            if (l33VarB == null || (!(l33VarB instanceof sm4) && p(l33VarB))) {
                return i | 16;
            }
            l33 l33VarN = n(l33VarB);
            return ((l33VarN instanceof sm4) && fg4.o(l33VarN.F().codePointAt(0))) ? i | 16 : i;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sg3(l33 l33Var, uj3 uj3Var, wm0.a aVar) {
        this.a = l33Var;
        this.b = uj3Var;
        this.c = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static sg3 i(l33 l33Var, uj3 uj3Var) {
        wm0.a aVarA = q33.a(l33Var);
        return aVarA.h() ? new a(l33Var, uj3Var, aVarA) : aVarA.i() ? new b(l33Var, uj3Var, aVarA) : new sg3(l33Var, uj3Var, aVarA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r33
    public void a(l33 l33Var, int i) {
        if (l33Var.getClass() == sm4.class) {
            g((sm4) l33Var, 0, i);
        } else if (l33Var instanceof br0) {
            d((br0) l33Var, i);
        } else {
            e((ms1) l33Var, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r33
    public void b(l33 l33Var, int i) {
        if (l33Var instanceof br0) {
            f((br0) l33Var, i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(br0 br0Var, int i) {
        br0Var.J(this.b, this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(ms1 ms1Var, int i) {
        ms1Var.J(this.b, this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(br0 br0Var, int i) {
        br0Var.J0(this.b, this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(sm4 sm4Var, int i, int i2) {
        bt0.m(this.b, sm4Var.a0(), this.c, i | 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(int i) {
        this.b.a('\n').b(fg4.u(i * this.c.f(), this.c.g()));
    }
}
