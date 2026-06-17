package defpackage;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.hp4;
import defpackage.sn3;
import defpackage.wm0;
import java.util.ArrayList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wf1 {
    public static final wf1 f = new k("Initial", 0);
    public static final wf1 g = new wf1("BeforeHtml", 1) { // from class: wf1.r
        {
            k kVar = null;
        }

        private boolean k(hp4 hp4Var, vf1 vf1Var) {
            vf1Var.u("html");
            vf1Var.j1(wf1.h);
            return vf1Var.s(hp4Var);
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.k()) {
                vf1Var.N(this);
                return false;
            }
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
                return true;
            }
            if (wf1.h(hp4Var)) {
                vf1Var.k0(hp4Var.a());
                return true;
            }
            if (hp4Var.n() && hp4Var.e().I().equals("html")) {
                vf1Var.o0(hp4Var.e());
                vf1Var.j1(wf1.h);
                return true;
            }
            if (hp4Var.m() && fg4.g(hp4Var.d().I(), z.e)) {
                return k(hp4Var, vf1Var);
            }
            if (!hp4Var.m()) {
                return k(hp4Var, vf1Var);
            }
            vf1Var.N(this);
            return false;
        }
    };
    public static final wf1 h = new wf1("BeforeHead", 2) { // from class: wf1.s
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (wf1.h(hp4Var)) {
                vf1Var.k0(hp4Var.a());
                return true;
            }
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
                return true;
            }
            if (hp4Var.k()) {
                vf1Var.N(this);
                return false;
            }
            if (hp4Var.n() && hp4Var.e().I().equals("html")) {
                return wf1.l.j(hp4Var, vf1Var);
            }
            if (hp4Var.n() && hp4Var.e().I().equals("head")) {
                vf1Var.g1(vf1Var.o0(hp4Var.e()));
                vf1Var.j1(wf1.i);
                return true;
            }
            if (hp4Var.m() && fg4.g(hp4Var.d().I(), z.e)) {
                vf1Var.u("head");
                return vf1Var.s(hp4Var);
            }
            if (hp4Var.m()) {
                vf1Var.N(this);
                return false;
            }
            vf1Var.u("head");
            return vf1Var.s(hp4Var);
        }
    };
    public static final wf1 i = new wf1("InHead", 3) { // from class: wf1.t
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (wf1.h(hp4Var)) {
                vf1Var.k0(hp4Var.a());
                return true;
            }
            int i2 = q.a[hp4Var.a.ordinal()];
            if (i2 == 1) {
                vf1Var.n0(hp4Var.b());
            } else {
                if (i2 == 2) {
                    vf1Var.N(this);
                    return false;
                }
                if (i2 == 3) {
                    hp4.h hVarE = hp4Var.e();
                    String strI = hVarE.I();
                    if (strI.equals("html")) {
                        return wf1.l.j(hp4Var, vf1Var);
                    }
                    if (fg4.g(strI, z.a)) {
                        br0 br0VarP0 = vf1Var.p0(hVarE);
                        if (strI.equals("base") && br0VarP0.w("href")) {
                            vf1Var.E0(br0VarP0);
                        }
                    } else if (strI.equals("meta")) {
                        vf1Var.p0(hVarE);
                    } else if (strI.equals("title") || fg4.g(strI, z.b)) {
                        wf1.b(hVarE, vf1Var, vf1Var.y(hVarE).n());
                    } else if (strI.equals("noscript")) {
                        vf1Var.o0(hVarE);
                        vf1Var.j1(wf1.j);
                    } else if (strI.equals("script")) {
                        vf1Var.c.x(op4.k);
                        vf1Var.D0();
                        vf1Var.j1(wf1.m);
                        vf1Var.o0(hVarE);
                    } else {
                        if (strI.equals("head")) {
                            vf1Var.N(this);
                            return false;
                        }
                        if (!strI.equals("template")) {
                            return k(hp4Var, vf1Var);
                        }
                        vf1Var.o0(hVarE);
                        vf1Var.t0();
                        vf1Var.O(false);
                        wf1 wf1Var = wf1.w;
                        vf1Var.j1(wf1Var);
                        vf1Var.S0(wf1Var);
                    }
                } else {
                    if (i2 != 4) {
                        return k(hp4Var, vf1Var);
                    }
                    String strI2 = hp4Var.d().I();
                    if (strI2.equals("head")) {
                        vf1Var.r();
                        vf1Var.j1(wf1.k);
                    } else {
                        if (fg4.g(strI2, z.c)) {
                            return k(hp4Var, vf1Var);
                        }
                        if (!strI2.equals("template")) {
                            vf1Var.N(this);
                            return false;
                        }
                        if (vf1Var.H0(strI2)) {
                            vf1Var.S(true);
                            if (!vf1Var.c(strI2)) {
                                vf1Var.N(this);
                            }
                            vf1Var.L0(strI2);
                            vf1Var.E();
                            vf1Var.O0();
                            vf1Var.c1();
                        } else {
                            vf1Var.N(this);
                        }
                    }
                }
            }
            return true;
        }

        public final boolean k(hp4 hp4Var, it4 it4Var) {
            it4Var.t("head");
            return it4Var.s(hp4Var);
        }
    };
    public static final wf1 j = new wf1("InHeadNoscript", 4) { // from class: wf1.u
        {
            k kVar = null;
        }

        private boolean k(hp4 hp4Var, vf1 vf1Var) {
            vf1Var.N(this);
            vf1Var.k0(new hp4.c().t(hp4Var.toString()));
            return true;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.k()) {
                vf1Var.N(this);
                return true;
            }
            if (hp4Var.n() && hp4Var.e().I().equals("html")) {
                return vf1Var.Q0(hp4Var, wf1.l);
            }
            if (hp4Var.m() && hp4Var.d().I().equals("noscript")) {
                vf1Var.r();
                vf1Var.j1(wf1.i);
                return true;
            }
            if (wf1.h(hp4Var) || hp4Var.j() || (hp4Var.n() && fg4.g(hp4Var.e().I(), z.f))) {
                return vf1Var.Q0(hp4Var, wf1.i);
            }
            if (hp4Var.m() && hp4Var.d().I().equals("br")) {
                return k(hp4Var, vf1Var);
            }
            if ((!hp4Var.n() || !fg4.g(hp4Var.e().I(), z.I)) && !hp4Var.m()) {
                return k(hp4Var, vf1Var);
            }
            vf1Var.N(this);
            return false;
        }
    };
    public static final wf1 k = new wf1("AfterHead", 5) { // from class: wf1.v
        {
            k kVar = null;
        }

        private boolean k(hp4 hp4Var, vf1 vf1Var) {
            vf1Var.u("body");
            vf1Var.O(true);
            return vf1Var.s(hp4Var);
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (wf1.h(hp4Var)) {
                vf1Var.k0(hp4Var.a());
                return true;
            }
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
                return true;
            }
            if (hp4Var.k()) {
                vf1Var.N(this);
                return true;
            }
            if (!hp4Var.n()) {
                if (!hp4Var.m()) {
                    k(hp4Var, vf1Var);
                    return true;
                }
                String strI = hp4Var.d().I();
                if (fg4.g(strI, z.d)) {
                    k(hp4Var, vf1Var);
                    return true;
                }
                if (strI.equals("template")) {
                    vf1Var.Q0(hp4Var, wf1.i);
                    return true;
                }
                vf1Var.N(this);
                return false;
            }
            hp4.h hVarE = hp4Var.e();
            String strI2 = hVarE.I();
            if (strI2.equals("html")) {
                return vf1Var.Q0(hp4Var, wf1.l);
            }
            if (strI2.equals("body")) {
                vf1Var.o0(hVarE);
                vf1Var.O(false);
                vf1Var.j1(wf1.l);
                return true;
            }
            if (strI2.equals("frameset")) {
                vf1Var.o0(hVarE);
                vf1Var.j1(wf1.y);
                return true;
            }
            if (!fg4.g(strI2, z.g)) {
                if (strI2.equals("head")) {
                    vf1Var.N(this);
                    return false;
                }
                k(hp4Var, vf1Var);
                return true;
            }
            vf1Var.N(this);
            br0 br0VarY = vf1Var.Y();
            vf1Var.v(br0VarY);
            vf1Var.Q0(hp4Var, wf1.i);
            vf1Var.W0(br0VarY);
            return true;
        }
    };
    public static final wf1 l = new wf1("InBody", 6) { // from class: wf1.w
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            switch (q.a[hp4Var.a.ordinal()]) {
                case 1:
                    vf1Var.n0(hp4Var.b());
                    return true;
                case 2:
                    vf1Var.N(this);
                    return false;
                case 3:
                    return n(hp4Var, vf1Var);
                case 4:
                    return l(hp4Var, vf1Var);
                case 5:
                    hp4.c cVarA = hp4Var.a();
                    if (vf1Var.P() && wf1.h(cVarA)) {
                        vf1Var.U0();
                        vf1Var.k0(cVarA);
                        return true;
                    }
                    vf1Var.U0();
                    vf1Var.k0(cVarA);
                    vf1Var.O(false);
                    return true;
                case 6:
                    if (vf1Var.i1() > 0) {
                        return vf1Var.Q0(hp4Var, wf1.w);
                    }
                    if (!vf1Var.J0(z.q)) {
                        return true;
                    }
                    vf1Var.N(this);
                    return true;
                default:
                    zy4.m("Unexpected state: " + hp4Var.a);
                    return true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean k(defpackage.hp4 r7, defpackage.vf1 r8) {
            /*
                r6 = this;
                hp4$g r7 = r7.d()
                java.lang.String r7 = r7.e
                java.util.ArrayList r0 = r8.a0()
                br0 r1 = r8.X(r7)
                r2 = 0
                if (r1 != 0) goto L15
                r8.N(r6)
                return r2
            L15:
                int r1 = r0.size()
                r3 = 1
                int r1 = r1 - r3
            L1b:
                if (r1 < 0) goto L46
                java.lang.Object r4 = r0.get(r1)
                br0 r4 = (defpackage.br0) r4
                boolean r5 = r4.z(r7)
                if (r5 == 0) goto L39
                r8.R(r7)
                boolean r0 = r8.c(r7)
                if (r0 != 0) goto L35
                r8.N(r6)
            L35:
                r8.L0(r7)
                goto L46
            L39:
                boolean r4 = defpackage.vf1.B0(r4)
                if (r4 == 0) goto L43
                r8.N(r6)
                return r2
            L43:
                int r1 = r1 + (-1)
                goto L1b
            L46:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: wf1.w.k(hp4, vf1):boolean");
        }

        public final boolean l(hp4 hp4Var, vf1 vf1Var) {
            hp4.g gVarD;
            String strI;
            gVarD = hp4Var.d();
            strI = gVarD.I();
            strI.getClass();
            switch (strI) {
                case "template":
                    vf1Var.Q0(hp4Var, wf1.i);
                    return true;
                case "p":
                    if (!vf1Var.b0(strI)) {
                        vf1Var.N(this);
                        vf1Var.u(strI);
                        return vf1Var.s(gVarD);
                    }
                    vf1Var.R(strI);
                    if (!vf1Var.c(strI)) {
                        vf1Var.N(this);
                    }
                    vf1Var.L0(strI);
                    return true;
                case "br":
                    vf1Var.N(this);
                    vf1Var.u("br");
                    return false;
                case "dd":
                case "dt":
                    if (!vf1Var.d0(strI)) {
                        vf1Var.N(this);
                        return false;
                    }
                    vf1Var.R(strI);
                    if (!vf1Var.c(strI)) {
                        vf1Var.N(this);
                    }
                    vf1Var.L0(strI);
                    return true;
                case "h1":
                case "h2":
                case "h3":
                case "h4":
                case "h5":
                case "h6":
                    String[] strArr = z.i;
                    if (!vf1Var.f0(strArr)) {
                        vf1Var.N(this);
                        return false;
                    }
                    vf1Var.R(strI);
                    if (!vf1Var.c(strI)) {
                        vf1Var.N(this);
                    }
                    vf1Var.M0(strArr);
                    return true;
                case "li":
                    if (!vf1Var.c0(strI)) {
                        vf1Var.N(this);
                        return false;
                    }
                    vf1Var.R(strI);
                    if (!vf1Var.c(strI)) {
                        vf1Var.N(this);
                    }
                    vf1Var.L0(strI);
                    return true;
                case "body":
                    if (!vf1Var.d0("body")) {
                        vf1Var.N(this);
                        return false;
                    }
                    if (vf1Var.J0(z.q)) {
                        vf1Var.N(this);
                    }
                    vf1Var.A(vf1Var.X("body"), false);
                    vf1Var.j1(wf1.x);
                    return true;
                case "form":
                    if (!vf1Var.H0("template")) {
                        p41 p41VarW = vf1Var.W();
                        vf1Var.e1(null);
                        if (p41VarW == null || !vf1Var.d0(strI)) {
                            vf1Var.N(this);
                            return false;
                        }
                        vf1Var.Q();
                        if (!vf1Var.c(strI)) {
                            vf1Var.N(this);
                        }
                        vf1Var.W0(p41VarW);
                    } else {
                        if (!vf1Var.d0(strI)) {
                            vf1Var.N(this);
                            return false;
                        }
                        vf1Var.Q();
                        if (!vf1Var.c(strI)) {
                            vf1Var.N(this);
                        }
                        vf1Var.L0(strI);
                    }
                    return true;
                case "html":
                    if (!vf1Var.H0("body")) {
                        vf1Var.N(this);
                        return false;
                    }
                    if (vf1Var.J0(z.q)) {
                        vf1Var.N(this);
                    }
                    vf1Var.j1(wf1.x);
                    return vf1Var.s(hp4Var);
                case "span":
                case "sarcasm":
                    return k(hp4Var, vf1Var);
                default:
                    if (fg4.g(strI, z.r)) {
                        return m(hp4Var, vf1Var);
                    }
                    if (fg4.g(strI, z.p)) {
                        if (!vf1Var.d0(strI)) {
                            vf1Var.N(this);
                            return false;
                        }
                        vf1Var.Q();
                        if (!vf1Var.c(strI)) {
                            vf1Var.N(this);
                        }
                        vf1Var.L0(strI);
                    } else {
                        if (!fg4.g(strI, z.l)) {
                            return k(hp4Var, vf1Var);
                        }
                        if (!vf1Var.d0("name")) {
                            if (!vf1Var.d0(strI)) {
                                vf1Var.N(this);
                                return false;
                            }
                            vf1Var.Q();
                            if (!vf1Var.c(strI)) {
                                vf1Var.N(this);
                            }
                            vf1Var.L0(strI);
                            vf1Var.E();
                        }
                    }
                    return true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x00dd, code lost:
        
            r16 = r4 == true ? 1 : 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x013e, code lost:
        
            r19.N(r17);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v2, types: [int] */
        /* JADX WARN: Type inference failed for: r10v3, types: [int] */
        /* JADX WARN: Type inference failed for: r16v0 */
        /* JADX WARN: Type inference failed for: r16v1 */
        /* JADX WARN: Type inference failed for: r16v2 */
        /* JADX WARN: Type inference failed for: r16v3 */
        /* JADX WARN: Type inference failed for: r16v4 */
        /* JADX WARN: Type inference failed for: r19v0, types: [it4, vf1] */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v14 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r6v10, types: [br0] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean m(defpackage.hp4 r18, defpackage.vf1 r19) {
            /*
                Method dump skipped, instruction units count: 392
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: wf1.w.m(hp4, vf1):boolean");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:4:0x002a  */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r3v5 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean n(defpackage.hp4 r20, defpackage.vf1 r21) {
            /*
                Method dump skipped, instruction units count: 2148
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: wf1.w.n(hp4, vf1):boolean");
        }
    };
    public static final wf1 m = new wf1("Text", 7) { // from class: wf1.x
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.i()) {
                vf1Var.k0(hp4Var.a());
                return true;
            }
            if (!hp4Var.l()) {
                if (!hp4Var.m()) {
                    return true;
                }
                vf1Var.r();
                vf1Var.j1(vf1Var.K0());
                return true;
            }
            vf1Var.N(this);
            vf1Var.r();
            vf1Var.j1(vf1Var.K0());
            if (vf1Var.h1() == wf1.m) {
                vf1Var.j1(wf1.l);
            }
            return vf1Var.s(hp4Var);
        }
    };
    public static final wf1 n = new wf1("InTable", 8) { // from class: wf1.y
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.i() && fg4.g(vf1Var.b().G(), z.A)) {
                vf1Var.d1();
                vf1Var.D0();
                vf1Var.j1(wf1.o);
                return vf1Var.s(hp4Var);
            }
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
                return true;
            }
            if (hp4Var.k()) {
                vf1Var.N(this);
                return false;
            }
            if (!hp4Var.n()) {
                if (!hp4Var.m()) {
                    if (!hp4Var.l()) {
                        return k(hp4Var, vf1Var);
                    }
                    if (vf1Var.c("html")) {
                        vf1Var.N(this);
                    }
                    return true;
                }
                String strI = hp4Var.d().I();
                if (strI.equals("table")) {
                    if (!vf1Var.j0(strI)) {
                        vf1Var.N(this);
                        return false;
                    }
                    vf1Var.L0("table");
                    vf1Var.c1();
                } else {
                    if (fg4.g(strI, z.z)) {
                        vf1Var.N(this);
                        return false;
                    }
                    if (!strI.equals("template")) {
                        return k(hp4Var, vf1Var);
                    }
                    vf1Var.Q0(hp4Var, wf1.i);
                }
                return true;
            }
            hp4.h hVarE = hp4Var.e();
            String strI2 = hVarE.I();
            if (strI2.equals("caption")) {
                vf1Var.H();
                vf1Var.t0();
                vf1Var.o0(hVarE);
                vf1Var.j1(wf1.p);
            } else if (strI2.equals("colgroup")) {
                vf1Var.H();
                vf1Var.o0(hVarE);
                vf1Var.j1(wf1.q);
            } else {
                if (strI2.equals("col")) {
                    vf1Var.H();
                    vf1Var.u("colgroup");
                    return vf1Var.s(hp4Var);
                }
                if (fg4.g(strI2, z.s)) {
                    vf1Var.H();
                    vf1Var.o0(hVarE);
                    vf1Var.j1(wf1.r);
                } else {
                    if (fg4.g(strI2, z.t)) {
                        vf1Var.H();
                        vf1Var.u("tbody");
                        return vf1Var.s(hp4Var);
                    }
                    if (strI2.equals("table")) {
                        vf1Var.N(this);
                        if (!vf1Var.j0(strI2)) {
                            return false;
                        }
                        vf1Var.L0(strI2);
                        if (vf1Var.c1()) {
                            return vf1Var.s(hp4Var);
                        }
                        vf1Var.o0(hVarE);
                        return true;
                    }
                    if (fg4.g(strI2, z.u)) {
                        return vf1Var.Q0(hp4Var, wf1.i);
                    }
                    if (strI2.equals("input")) {
                        if (!hVarE.D() || !hVarE.g.m("type").equalsIgnoreCase("hidden")) {
                            return k(hp4Var, vf1Var);
                        }
                        vf1Var.p0(hVarE);
                    } else {
                        if (!strI2.equals("form")) {
                            return k(hp4Var, vf1Var);
                        }
                        vf1Var.N(this);
                        if (vf1Var.W() != null || vf1Var.H0("template")) {
                            return false;
                        }
                        vf1Var.r0(hVarE, false, false);
                    }
                }
            }
            return true;
        }

        public boolean k(hp4 hp4Var, vf1 vf1Var) {
            vf1Var.N(this);
            vf1Var.f1(true);
            vf1Var.Q0(hp4Var, wf1.l);
            vf1Var.f1(false);
            return true;
        }
    };
    public static final wf1 o = new wf1("InTableText", 9) { // from class: wf1.a
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.a == hp4.j.Character) {
                vf1Var.C(hp4Var.a());
                return true;
            }
            if (vf1Var.Z().size() > 0) {
                hp4 hp4Var2 = vf1Var.g;
                for (hp4.c cVar : vf1Var.Z()) {
                    vf1Var.g = cVar;
                    if (wf1.h(cVar)) {
                        vf1Var.k0(cVar);
                    } else {
                        vf1Var.N(this);
                        if (fg4.g(vf1Var.b().G(), z.A)) {
                            vf1Var.f1(true);
                            vf1Var.Q0(cVar, wf1.l);
                            vf1Var.f1(false);
                        } else {
                            vf1Var.Q0(cVar, wf1.l);
                        }
                    }
                }
                vf1Var.g = hp4Var2;
                vf1Var.d1();
            }
            vf1Var.j1(vf1Var.K0());
            return vf1Var.s(hp4Var);
        }
    };
    public static final wf1 p = new wf1("InCaption", 10) { // from class: wf1.b
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.m() && hp4Var.d().I().equals("caption")) {
                if (!vf1Var.j0("caption")) {
                    vf1Var.N(this);
                    return false;
                }
                vf1Var.Q();
                if (!vf1Var.c("caption")) {
                    vf1Var.N(this);
                }
                vf1Var.L0("caption");
                vf1Var.E();
                vf1Var.j1(wf1.n);
                return true;
            }
            if ((!hp4Var.n() || !fg4.g(hp4Var.e().I(), z.y)) && (!hp4Var.m() || !hp4Var.d().I().equals("table"))) {
                if (!hp4Var.m() || !fg4.g(hp4Var.d().I(), z.J)) {
                    return vf1Var.Q0(hp4Var, wf1.l);
                }
                vf1Var.N(this);
                return false;
            }
            if (!vf1Var.j0("caption")) {
                vf1Var.N(this);
                return false;
            }
            vf1Var.S(false);
            if (!vf1Var.c("caption")) {
                vf1Var.N(this);
            }
            vf1Var.L0("caption");
            vf1Var.E();
            wf1 wf1Var = wf1.n;
            vf1Var.j1(wf1Var);
            wf1Var.j(hp4Var, vf1Var);
            return true;
        }
    };
    public static final wf1 q = new wf1("InColumnGroup", 11) { // from class: wf1.c
        {
            k kVar = null;
        }

        private boolean k(hp4 hp4Var, vf1 vf1Var) {
            if (!vf1Var.c("colgroup")) {
                vf1Var.N(this);
                return false;
            }
            vf1Var.r();
            vf1Var.j1(wf1.n);
            vf1Var.s(hp4Var);
            return true;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            hp4.h hVarE;
            if (wf1.h(hp4Var)) {
                vf1Var.k0(hp4Var.a());
                return true;
            }
            int i2 = q.a[hp4Var.a.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    vf1Var.N(this);
                } else if (i2 == 3) {
                    hVarE = hp4Var.e();
                    String strI = hVarE.I();
                    strI.getClass();
                    switch (strI) {
                        case "template":
                            vf1Var.Q0(hp4Var, wf1.i);
                            break;
                        case "col":
                            vf1Var.p0(hVarE);
                            break;
                        case "html":
                            return vf1Var.Q0(hp4Var, wf1.l);
                        default:
                            return k(hp4Var, vf1Var);
                    }
                } else {
                    if (i2 != 4) {
                        if (i2 != 6) {
                            return k(hp4Var, vf1Var);
                        }
                        if (vf1Var.c("html")) {
                            return true;
                        }
                        return k(hp4Var, vf1Var);
                    }
                    String strI2 = hp4Var.d().I();
                    strI2.getClass();
                    if (strI2.equals("template")) {
                        vf1Var.Q0(hp4Var, wf1.i);
                    } else {
                        if (!strI2.equals("colgroup")) {
                            return k(hp4Var, vf1Var);
                        }
                        if (!vf1Var.c(strI2)) {
                            vf1Var.N(this);
                            return false;
                        }
                        vf1Var.r();
                        vf1Var.j1(wf1.n);
                    }
                }
            } else {
                vf1Var.n0(hp4Var.b());
            }
            return true;
        }
    };
    public static final wf1 r = new wf1("InTableBody", 12) { // from class: wf1.d
        {
            k kVar = null;
        }

        private boolean k(hp4 hp4Var, vf1 vf1Var) {
            return vf1Var.Q0(hp4Var, wf1.n);
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            int i2 = q.a[hp4Var.a.ordinal()];
            if (i2 == 3) {
                hp4.h hVarE = hp4Var.e();
                String strI = hVarE.I();
                if (strI.equals("tr")) {
                    vf1Var.G();
                    vf1Var.o0(hVarE);
                    vf1Var.j1(wf1.s);
                    return true;
                }
                if (!fg4.g(strI, z.v)) {
                    return fg4.g(strI, z.B) ? l(hp4Var, vf1Var) : k(hp4Var, vf1Var);
                }
                vf1Var.N(this);
                vf1Var.u("tr");
                return vf1Var.s(hVarE);
            }
            if (i2 != 4) {
                return k(hp4Var, vf1Var);
            }
            String strI2 = hp4Var.d().I();
            if (!fg4.g(strI2, z.H)) {
                if (strI2.equals("table")) {
                    return l(hp4Var, vf1Var);
                }
                if (!fg4.g(strI2, z.C)) {
                    return k(hp4Var, vf1Var);
                }
                vf1Var.N(this);
                return false;
            }
            if (!vf1Var.j0(strI2)) {
                vf1Var.N(this);
                return false;
            }
            vf1Var.G();
            vf1Var.r();
            vf1Var.j1(wf1.n);
            return true;
        }

        public final boolean l(hp4 hp4Var, vf1 vf1Var) {
            if (!vf1Var.j0("tbody") && !vf1Var.j0("thead") && !vf1Var.d0("tfoot")) {
                vf1Var.N(this);
                return false;
            }
            vf1Var.G();
            vf1Var.t(vf1Var.b().G());
            return vf1Var.s(hp4Var);
        }
    };
    public static final wf1 s = new wf1("InRow", 13) { // from class: wf1.e
        {
            k kVar = null;
        }

        private boolean k(hp4 hp4Var, vf1 vf1Var) {
            return vf1Var.Q0(hp4Var, wf1.n);
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.n()) {
                hp4.h hVarE = hp4Var.e();
                String strI = hVarE.I();
                if (fg4.g(strI, z.v)) {
                    vf1Var.I();
                    vf1Var.o0(hVarE);
                    vf1Var.j1(wf1.t);
                    vf1Var.t0();
                    return true;
                }
                if (!fg4.g(strI, z.D)) {
                    return k(hp4Var, vf1Var);
                }
                if (!vf1Var.j0("tr")) {
                    vf1Var.N(this);
                    return false;
                }
                vf1Var.I();
                vf1Var.r();
                vf1Var.j1(wf1.r);
                return vf1Var.s(hp4Var);
            }
            if (!hp4Var.m()) {
                return k(hp4Var, vf1Var);
            }
            String strI2 = hp4Var.d().I();
            if (strI2.equals("tr")) {
                if (!vf1Var.j0(strI2)) {
                    vf1Var.N(this);
                    return false;
                }
                vf1Var.I();
                vf1Var.r();
                vf1Var.j1(wf1.r);
                return true;
            }
            if (strI2.equals("table")) {
                if (!vf1Var.j0("tr")) {
                    vf1Var.N(this);
                    return false;
                }
                vf1Var.I();
                vf1Var.r();
                vf1Var.j1(wf1.r);
                return vf1Var.s(hp4Var);
            }
            if (!fg4.g(strI2, z.s)) {
                if (!fg4.g(strI2, z.E)) {
                    return k(hp4Var, vf1Var);
                }
                vf1Var.N(this);
                return false;
            }
            if (!vf1Var.j0(strI2)) {
                vf1Var.N(this);
                return false;
            }
            if (!vf1Var.j0("tr")) {
                return false;
            }
            vf1Var.I();
            vf1Var.r();
            vf1Var.j1(wf1.r);
            return vf1Var.s(hp4Var);
        }
    };
    public static final wf1 t = new wf1("InCell", 14) { // from class: wf1.f
        {
            k kVar = null;
        }

        private boolean k(hp4 hp4Var, vf1 vf1Var) {
            return vf1Var.Q0(hp4Var, wf1.l);
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (!hp4Var.m()) {
                if (!hp4Var.n() || !fg4.g(hp4Var.e().I(), z.y)) {
                    return k(hp4Var, vf1Var);
                }
                if (vf1Var.j0("td") || vf1Var.j0("th")) {
                    l(vf1Var);
                    return vf1Var.s(hp4Var);
                }
                vf1Var.N(this);
                return false;
            }
            String strI = hp4Var.d().I();
            if (!fg4.g(strI, z.v)) {
                if (fg4.g(strI, z.w)) {
                    vf1Var.N(this);
                    return false;
                }
                if (!fg4.g(strI, z.x)) {
                    return k(hp4Var, vf1Var);
                }
                if (vf1Var.j0(strI)) {
                    l(vf1Var);
                    return vf1Var.s(hp4Var);
                }
                vf1Var.N(this);
                return false;
            }
            if (!vf1Var.j0(strI)) {
                vf1Var.N(this);
                vf1Var.j1(wf1.s);
                return false;
            }
            vf1Var.Q();
            if (!vf1Var.c(strI)) {
                vf1Var.N(this);
            }
            vf1Var.L0(strI);
            vf1Var.E();
            vf1Var.j1(wf1.s);
            return true;
        }

        public final void l(vf1 vf1Var) {
            if (vf1Var.j0("td")) {
                vf1Var.t("td");
            } else {
                vf1Var.t("th");
            }
        }
    };
    public static final wf1 u = new wf1("InSelect", 15) { // from class: wf1.g
        {
            k kVar = null;
        }

        private boolean k(hp4 hp4Var, vf1 vf1Var) {
            vf1Var.N(this);
            return false;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            String strI;
            switch (q.a[hp4Var.a.ordinal()]) {
                case 1:
                    vf1Var.n0(hp4Var.b());
                    return true;
                case 2:
                    vf1Var.N(this);
                    return false;
                case 3:
                    hp4.h hVarE = hp4Var.e();
                    String strI2 = hVarE.I();
                    if (strI2.equals("html")) {
                        return vf1Var.Q0(hVarE, wf1.l);
                    }
                    if (strI2.equals("option")) {
                        if (vf1Var.c("option")) {
                            vf1Var.t("option");
                        }
                        vf1Var.o0(hVarE);
                    } else {
                        if (!strI2.equals("optgroup")) {
                            if (strI2.equals("select")) {
                                vf1Var.N(this);
                                return vf1Var.t("select");
                            }
                            if (!fg4.g(strI2, z.F)) {
                                return (strI2.equals("script") || strI2.equals("template")) ? vf1Var.Q0(hp4Var, wf1.i) : k(hp4Var, vf1Var);
                            }
                            vf1Var.N(this);
                            if (!vf1Var.g0("select")) {
                                return false;
                            }
                            do {
                                vf1Var.L0("select");
                                vf1Var.c1();
                            } while (vf1Var.g0("select"));
                            return vf1Var.s(hVarE);
                        }
                        if (vf1Var.c("option")) {
                            vf1Var.t("option");
                        }
                        if (vf1Var.c("optgroup")) {
                            vf1Var.t("optgroup");
                        }
                        vf1Var.o0(hVarE);
                    }
                    return true;
                case 4:
                    strI = hp4Var.d().I();
                    strI.getClass();
                    switch (strI) {
                        case "template":
                            return vf1Var.Q0(hp4Var, wf1.i);
                        case "option":
                            if (vf1Var.c("option")) {
                                vf1Var.r();
                            } else {
                                vf1Var.N(this);
                            }
                            return true;
                        case "select":
                            if (!vf1Var.g0(strI)) {
                                vf1Var.N(this);
                                return false;
                            }
                            vf1Var.L0(strI);
                            vf1Var.c1();
                            return true;
                        case "optgroup":
                            if (vf1Var.c("option") && vf1Var.B(vf1Var.b()) != null && vf1Var.B(vf1Var.b()).z("optgroup")) {
                                vf1Var.t("option");
                            }
                            if (vf1Var.c("optgroup")) {
                                vf1Var.r();
                            } else {
                                vf1Var.N(this);
                            }
                            return true;
                        default:
                            return k(hp4Var, vf1Var);
                    }
                case 5:
                    vf1Var.k0(hp4Var.a());
                    return true;
                case 6:
                    if (!vf1Var.c("html")) {
                        vf1Var.N(this);
                    }
                    return true;
                default:
                    return k(hp4Var, vf1Var);
            }
        }
    };
    public static final wf1 v = new wf1("InSelectInTable", 16) { // from class: wf1.h
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.n() && fg4.g(hp4Var.e().I(), z.G)) {
                vf1Var.N(this);
                vf1Var.L0("select");
                vf1Var.c1();
                return vf1Var.s(hp4Var);
            }
            if (!hp4Var.m() || !fg4.g(hp4Var.d().I(), z.G)) {
                return vf1Var.Q0(hp4Var, wf1.u);
            }
            vf1Var.N(this);
            if (!vf1Var.j0(hp4Var.d().I())) {
                return false;
            }
            vf1Var.L0("select");
            vf1Var.c1();
            return vf1Var.s(hp4Var);
        }
    };
    public static final wf1 w = new wf1("InTemplate", 17) { // from class: wf1.i
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            switch (q.a[hp4Var.a.ordinal()]) {
                case 1:
                case 2:
                case 5:
                    vf1Var.Q0(hp4Var, wf1.l);
                    return true;
                case 3:
                    String strI = hp4Var.e().I();
                    if (fg4.g(strI, z.K)) {
                        vf1Var.Q0(hp4Var, wf1.i);
                        return true;
                    }
                    if (fg4.g(strI, z.L)) {
                        vf1Var.O0();
                        wf1 wf1Var = wf1.n;
                        vf1Var.S0(wf1Var);
                        vf1Var.j1(wf1Var);
                        return vf1Var.s(hp4Var);
                    }
                    if (strI.equals("col")) {
                        vf1Var.O0();
                        wf1 wf1Var2 = wf1.q;
                        vf1Var.S0(wf1Var2);
                        vf1Var.j1(wf1Var2);
                        return vf1Var.s(hp4Var);
                    }
                    if (strI.equals("tr")) {
                        vf1Var.O0();
                        wf1 wf1Var3 = wf1.r;
                        vf1Var.S0(wf1Var3);
                        vf1Var.j1(wf1Var3);
                        return vf1Var.s(hp4Var);
                    }
                    if (strI.equals("td") || strI.equals("th")) {
                        vf1Var.O0();
                        wf1 wf1Var4 = wf1.s;
                        vf1Var.S0(wf1Var4);
                        vf1Var.j1(wf1Var4);
                        return vf1Var.s(hp4Var);
                    }
                    vf1Var.O0();
                    wf1 wf1Var5 = wf1.l;
                    vf1Var.S0(wf1Var5);
                    vf1Var.j1(wf1Var5);
                    return vf1Var.s(hp4Var);
                case 4:
                    if (hp4Var.d().I().equals("template")) {
                        vf1Var.Q0(hp4Var, wf1.i);
                        return true;
                    }
                    vf1Var.N(this);
                    return false;
                case 6:
                    if (!vf1Var.H0("template")) {
                        return true;
                    }
                    vf1Var.N(this);
                    vf1Var.L0("template");
                    vf1Var.E();
                    vf1Var.O0();
                    vf1Var.c1();
                    if (vf1Var.h1() == wf1.w || vf1Var.i1() >= 12) {
                        return true;
                    }
                    return vf1Var.s(hp4Var);
                default:
                    zy4.m("Unexpected state: " + hp4Var.a);
                    return true;
            }
        }
    };
    public static final wf1 x = new wf1("AfterBody", 18) { // from class: wf1.j
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            br0 br0VarX = vf1Var.X("html");
            if (wf1.h(hp4Var)) {
                if (br0VarX != null) {
                    vf1Var.m0(hp4Var.a(), br0VarX);
                    return true;
                }
                vf1Var.Q0(hp4Var, wf1.l);
                return true;
            }
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
                return true;
            }
            if (hp4Var.k()) {
                vf1Var.N(this);
                return false;
            }
            if (hp4Var.n() && hp4Var.e().I().equals("html")) {
                return vf1Var.Q0(hp4Var, wf1.l);
            }
            if (!hp4Var.m() || !hp4Var.d().I().equals("html")) {
                if (hp4Var.l()) {
                    return true;
                }
                vf1Var.N(this);
                vf1Var.b1();
                return vf1Var.s(hp4Var);
            }
            if (vf1Var.w0()) {
                vf1Var.N(this);
                return false;
            }
            if (br0VarX != null) {
                vf1Var.A(br0VarX, false);
            }
            vf1Var.j1(wf1.A);
            return true;
        }
    };
    public static final wf1 y = new wf1("InFrameset", 19) { // from class: wf1.l
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            hp4.h hVarE;
            if (wf1.h(hp4Var)) {
                vf1Var.k0(hp4Var.a());
            } else if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
            } else {
                if (hp4Var.k()) {
                    vf1Var.N(this);
                    return false;
                }
                if (hp4Var.n()) {
                    hVarE = hp4Var.e();
                    String strI = hVarE.I();
                    strI.getClass();
                    switch (strI) {
                        case "frameset":
                            vf1Var.o0(hVarE);
                            break;
                        case "html":
                            return vf1Var.Q0(hVarE, wf1.l);
                        case "frame":
                            vf1Var.p0(hVarE);
                            break;
                        case "noframes":
                            return vf1Var.Q0(hVarE, wf1.i);
                        default:
                            vf1Var.N(this);
                            return false;
                    }
                } else if (hp4Var.m() && hp4Var.d().I().equals("frameset")) {
                    if (!vf1Var.c("frameset")) {
                        vf1Var.N(this);
                        return false;
                    }
                    vf1Var.r();
                    if (!vf1Var.w0() && !vf1Var.c("frameset")) {
                        vf1Var.j1(wf1.z);
                    }
                } else {
                    if (!hp4Var.l()) {
                        vf1Var.N(this);
                        return false;
                    }
                    if (!vf1Var.c("html")) {
                        vf1Var.N(this);
                    }
                }
            }
            return true;
        }
    };
    public static final wf1 z = new wf1("AfterFrameset", 20) { // from class: wf1.m
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (wf1.h(hp4Var)) {
                vf1Var.k0(hp4Var.a());
                return true;
            }
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
                return true;
            }
            if (hp4Var.k()) {
                vf1Var.N(this);
                return false;
            }
            if (hp4Var.n() && hp4Var.e().I().equals("html")) {
                return vf1Var.Q0(hp4Var, wf1.l);
            }
            if (hp4Var.m() && hp4Var.d().I().equals("html")) {
                vf1Var.j1(wf1.B);
                return true;
            }
            if (hp4Var.n() && hp4Var.e().I().equals("noframes")) {
                return vf1Var.Q0(hp4Var, wf1.i);
            }
            if (hp4Var.l()) {
                return true;
            }
            vf1Var.N(this);
            return false;
        }
    };
    public static final wf1 A = new wf1("AfterAfterBody", 21) { // from class: wf1.n
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
                return true;
            }
            if (hp4Var.k() || (hp4Var.n() && hp4Var.e().I().equals("html"))) {
                return vf1Var.Q0(hp4Var, wf1.l);
            }
            if (wf1.h(hp4Var)) {
                vf1Var.m0(hp4Var.a(), vf1Var.V());
                return true;
            }
            if (hp4Var.l()) {
                return true;
            }
            vf1Var.N(this);
            vf1Var.b1();
            return vf1Var.s(hp4Var);
        }
    };
    public static final wf1 B = new wf1("AfterAfterFrameset", 22) { // from class: wf1.o
        {
            k kVar = null;
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
                return true;
            }
            if (hp4Var.k() || wf1.h(hp4Var) || (hp4Var.n() && hp4Var.e().I().equals("html"))) {
                return vf1Var.Q0(hp4Var, wf1.l);
            }
            if (hp4Var.l()) {
                return true;
            }
            if (hp4Var.n() && hp4Var.e().I().equals("noframes")) {
                return vf1Var.Q0(hp4Var, wf1.i);
            }
            vf1Var.N(this);
            return false;
        }
    };
    public static final wf1 C = new wf1("ForeignContent", 23) { // from class: wf1.p
        {
            k kVar = null;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            switch (q.a[hp4Var.a.ordinal()]) {
                case 1:
                    vf1Var.n0(hp4Var.b());
                    return true;
                case 2:
                    vf1Var.N(this);
                    return true;
                case 3:
                    hp4.h hVarE = hp4Var.e();
                    if (fg4.f(hVarE.e, z.M)) {
                        return k(hp4Var, vf1Var);
                    }
                    if (hVarE.e.equals("font") && (hVarE.C("color") || hVarE.C("face") || hVarE.C("size"))) {
                        return k(hp4Var, vf1Var);
                    }
                    String strI = vf1Var.b().U0().i();
                    vf1Var.q0(hVarE, strI);
                    op4 op4VarN = vf1Var.z(hVarE.d.h(), hVarE.e, strI, vf1Var.h).n();
                    if (op4VarN != null) {
                        boolean zEquals = hVarE.e.equals("script");
                        np4 np4Var = vf1Var.c;
                        if (zEquals) {
                            np4Var.x(op4.k);
                        } else {
                            np4Var.x(op4VarN);
                        }
                    }
                    return true;
                case 4:
                    hp4.g gVarD = hp4Var.d();
                    if (gVarD.e.equals("br") || gVarD.e.equals("p")) {
                        return k(hp4Var, vf1Var);
                    }
                    if (gVarD.e.equals("script") && vf1Var.d("script", "http://www.w3.org/2000/svg")) {
                        vf1Var.r();
                        return true;
                    }
                    ArrayList arrayListA0 = vf1Var.a0();
                    if (arrayListA0.isEmpty()) {
                        zy4.m("Stack unexpectedly empty");
                    }
                    int size = arrayListA0.size() - 1;
                    br0 br0Var = (br0) arrayListA0.get(size);
                    if (!br0Var.z(gVarD.e)) {
                        vf1Var.N(this);
                    }
                    while (size != 0) {
                        if (br0Var.z(gVarD.e)) {
                            vf1Var.N0(br0Var.G());
                            return true;
                        }
                        size--;
                        br0Var = (br0) arrayListA0.get(size);
                        if (br0Var.U0().i().equals("http://www.w3.org/1999/xhtml")) {
                            return k(hp4Var, vf1Var);
                        }
                    }
                    return true;
                case 5:
                    hp4.c cVarA = hp4Var.a();
                    if (wf1.h(cVarA)) {
                        vf1Var.k0(cVarA);
                    } else {
                        vf1Var.l0(cVarA, true);
                        vf1Var.O(false);
                    }
                    return true;
                case 6:
                    return true;
                default:
                    zy4.m("Unexpected state: " + hp4Var.a);
                    return true;
            }
        }

        public boolean k(hp4 hp4Var, vf1 vf1Var) {
            return vf1Var.h1().j(hp4Var, vf1Var);
        }
    };
    public static final /* synthetic */ wf1[] E = a();
    public static final String D = String.valueOf((char) 0);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum k extends wf1 {
        public k(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.wf1
        public boolean j(hp4 hp4Var, vf1 vf1Var) {
            if (wf1.h(hp4Var)) {
                return true;
            }
            if (hp4Var.j()) {
                vf1Var.n0(hp4Var.b());
            } else {
                if (!hp4Var.k()) {
                    vf1Var.V().j1(wm0.b.quirks);
                    vf1Var.j1(wf1.g);
                    return vf1Var.s(hp4Var);
                }
                hp4.e eVarC = hp4Var.c();
                zm0 zm0Var = new zm0(vf1Var.h.d(eVarC.s()), eVarC.u(), eVarC.v());
                zm0Var.h0(eVarC.t());
                vf1Var.V().d0(zm0Var);
                vf1Var.o(zm0Var);
                if (eVarC.w() || !zm0Var.f0().equals("html") || zm0Var.g0().equalsIgnoreCase("HTML")) {
                    vf1Var.V().j1(wm0.b.quirks);
                }
                vf1Var.j1(wf1.g);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class q {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[hp4.j.values().length];
            a = iArr;
            try {
                iArr[hp4.j.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[hp4.j.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[hp4.j.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[hp4.j.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[hp4.j.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[hp4.j.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class z {
        public static final String[] a = {"base", "basefont", "bgsound", "command", "link"};
        public static final String[] b = {"noframes", "style"};
        public static final String[] c = {"body", "br", "html"};
        public static final String[] d = {"body", "br", "html"};
        public static final String[] e = {"body", "br", "head", "html"};
        public static final String[] f = {"basefont", "bgsound", "link", "meta", "noframes", "style"};
        public static final String[] g = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "template", "title"};
        public static final String[] h = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
        public static final String[] i = {"h1", "h2", "h3", "h4", "h5", "h6"};
        public static final String[] j = {"address", "div", "p"};
        public static final String[] k = {"dd", "dt"};
        public static final String[] l = {"applet", "marquee", "object"};
        public static final String[] m = {"param", "source", "track"};
        public static final String[] n = {"action", "name", "prompt"};
        public static final String[] o = {"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] p = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        public static final String[] q = {"body", "dd", "dt", "html", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] r = {"a", "b", "big", "code", "em", "font", "i", "nobr", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "small", "strike", "strong", "tt", "u"};
        public static final String[] s = {"tbody", "tfoot", "thead"};
        public static final String[] t = {"td", "th", "tr"};
        public static final String[] u = {"script", "style", "template"};
        public static final String[] v = {"td", "th"};
        public static final String[] w = {"body", "caption", "col", "colgroup", "html"};
        public static final String[] x = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] y = {"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] z = {"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] A = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] B = {"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
        public static final String[] C = {"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};
        public static final String[] D = {"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
        public static final String[] E = {"body", "caption", "col", "colgroup", "html", "td", "th"};
        public static final String[] F = {"input", "keygen", "textarea"};
        public static final String[] G = {"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] H = {"tbody", "tfoot", "thead"};
        public static final String[] I = {"head", "noscript"};
        public static final String[] J = {"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] K = {"base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "template", "title"};
        public static final String[] L = {"caption", "colgroup", "tbody", "tfoot", "thead"};
        public static final String[] M = {"b", "big", "blockquote", "body", "br", "center", "code", "dd", "div", "dl", "dt", "em", "embed", "h1", "h2", "h3", "h4", "h5", "h6", "head", "hr", "i", "img", "li", "listing", "menu", "meta", "nobr", "ol", "p", "pre", "ruby", SardineUtil.CUSTOM_NAMESPACE_PREFIX, "small", "span", "strike", "strong", "sub", "sup", "table", "tt", "u", "ul", "var"};
    }

    public wf1(String str, int i2) {
    }

    public static /* synthetic */ wf1[] a() {
        return new wf1[]{f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C};
    }

    public static void b(hp4.h hVar, vf1 vf1Var, op4 op4Var) {
        if (op4Var != null) {
            vf1Var.c.x(op4Var);
        }
        vf1Var.D0();
        vf1Var.j1(m);
        vf1Var.o0(hVar);
    }

    public static boolean h(hp4 hp4Var) {
        if (hp4Var.i()) {
            return fg4.j(hp4Var.a().u());
        }
        return false;
    }

    public static void i(hp4.h hVar, br0 br0Var) {
        if (hVar.D()) {
            for (wb wbVar : hVar.g) {
                xb xbVarF = br0Var.f();
                if (!xbVarF.p(wbVar.getKey())) {
                    sn3.a aVarN = wbVar.n();
                    xbVarF.B(wbVar);
                    if (hVar.l) {
                        xbVarF.F(wbVar.getKey(), aVarN);
                    }
                }
            }
        }
    }

    public static wf1 valueOf(String str) {
        return (wf1) Enum.valueOf(wf1.class, str);
    }

    public static wf1[] values() {
        return (wf1[]) E.clone();
    }

    public abstract boolean j(hp4 hp4Var, vf1 vf1Var);

    public /* synthetic */ wf1(String str, int i2, k kVar) {
        this(str, i2);
    }
}
