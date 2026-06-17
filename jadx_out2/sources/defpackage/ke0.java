package defpackage;

import android.os.Looper;
import android.util.SparseArray;
import defpackage.hd3;
import defpackage.jq2;
import defpackage.no4;
import defpackage.p5;
import defpackage.pd;
import defpackage.pu1;
import defpackage.zi1;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ke0 implements o5 {
    public final zu f;
    public final no4.b g;
    public final no4.d h;
    public final a i;
    public final SparseArray j;
    public pu1 k = new pu1(fy4.f0());
    public hd3 l;
    public mc1 m;
    public boolean n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final no4.b a;
        public xi1 b = xi1.u();
        public zi1 c = zi1.j();
        public jq2.b d;
        public jq2.b e;
        public jq2.b f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(no4.b bVar) {
            this.a = bVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static jq2.b c(hd3 hd3Var, xi1 xi1Var, jq2.b bVar, no4.b bVar2) {
            no4 currentTimeline = hd3Var.getCurrentTimeline();
            int currentPeriodIndex = hd3Var.getCurrentPeriodIndex();
            Object objS = currentTimeline.w() ? null : currentTimeline.s(currentPeriodIndex);
            int iE = (hd3Var.isPlayingAd() || currentTimeline.w()) ? -1 : currentTimeline.l(currentPeriodIndex, bVar2).e(fy4.c1(hd3Var.getCurrentPosition()) - bVar2.p());
            for (int i = 0; i < xi1Var.size(); i++) {
                jq2.b bVar3 = (jq2.b) xi1Var.get(i);
                if (i(bVar3, objS, hd3Var.isPlayingAd(), hd3Var.getCurrentAdGroupIndex(), hd3Var.getCurrentAdIndexInAdGroup(), iE)) {
                    return bVar3;
                }
            }
            if (xi1Var.isEmpty() && bVar != null && i(bVar, objS, hd3Var.isPlayingAd(), hd3Var.getCurrentAdGroupIndex(), hd3Var.getCurrentAdIndexInAdGroup(), iE)) {
                return bVar;
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean i(jq2.b bVar, Object obj, boolean z, int i, int i2, int i3) {
            if (!bVar.a.equals(obj)) {
                return false;
            }
            if (z && bVar.b == i && bVar.c == i2) {
                return true;
            }
            return !z && bVar.b == -1 && bVar.e == i3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b(zi1.a aVar, jq2.b bVar, no4 no4Var) {
            if (bVar == null) {
                return;
            }
            if (no4Var.h(bVar.a) != -1) {
                aVar.g(bVar, no4Var);
                return;
            }
            no4 no4Var2 = (no4) this.c.get(bVar);
            if (no4Var2 != null) {
                aVar.g(bVar, no4Var2);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public jq2.b d() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public jq2.b e() {
            if (this.b.isEmpty()) {
                return null;
            }
            return (jq2.b) km1.d(this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public no4 f(jq2.b bVar) {
            return (no4) this.c.get(bVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public jq2.b g() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public jq2.b h() {
            return this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void j(hd3 hd3Var) {
            this.d = c(hd3Var, this.b, this.e, this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k(List list, jq2.b bVar, hd3 hd3Var) {
            this.b = xi1.p(list);
            if (!list.isEmpty()) {
                this.e = (jq2.b) list.get(0);
                this.f = (jq2.b) gg3.q(bVar);
            }
            if (this.d == null) {
                this.d = c(hd3Var, this.b, this.e, this.a);
            }
            m(hd3Var.getCurrentTimeline());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void l(hd3 hd3Var) {
            this.d = c(hd3Var, this.b, this.e, this.a);
            m(hd3Var.getCurrentTimeline());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void m(no4 no4Var) {
            xi1 xi1Var;
            zi1.a aVarA = zi1.a();
            if (this.b.isEmpty()) {
                b(aVarA, this.e, no4Var);
                if (!Objects.equals(this.f, this.e)) {
                    b(aVarA, this.f, no4Var);
                }
                if (!Objects.equals(this.d, this.e) && !Objects.equals(this.d, this.f)) {
                    b(aVarA, this.d, no4Var);
                }
            } else {
                int i = 0;
                while (true) {
                    int size = this.b.size();
                    xi1Var = this.b;
                    if (i >= size) {
                        break;
                    }
                    b(aVarA, (jq2.b) xi1Var.get(i), no4Var);
                    i++;
                }
                if (!xi1Var.contains(this.d)) {
                    b(aVarA, this.d, no4Var);
                }
            }
            this.c = aVarA.d();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ke0(zu zuVar) {
        this.f = (zu) gg3.q(zuVar);
        no4.b bVar = new no4.b();
        this.g = bVar;
        this.h = new no4.d();
        this.i = new a(bVar);
        this.j = new SparseArray();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void A0(p5.a aVar, int i, hd3.e eVar, hd3.e eVar2, p5 p5Var) {
        p5Var.w0(aVar, i);
        p5Var.l(aVar, eVar, eVar2, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void L(p5.a aVar, String str, long j, long j2, p5 p5Var) {
        p5Var.A0(aVar, str, j);
        p5Var.M(aVar, str, j2, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void M(p5.a aVar, int i, p5 p5Var) {
        p5Var.u(aVar);
        p5Var.b0(aVar, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void O0(p5.a aVar, String str, long j, long j2, p5 p5Var) {
        p5Var.W(aVar, str, j);
        p5Var.C(aVar, str, j2, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void S0(p5.a aVar, cr1 cr1Var, p5 p5Var) {
        p5Var.b(aVar);
        p5Var.S(aVar, cr1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void Y(p5.a aVar, e35 e35Var, p5 p5Var) {
        p5Var.J(aVar, e35Var);
        p5Var.P(aVar, e35Var.a, e35Var.b, 0, e35Var.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void Z(p5.a aVar, ty1 ty1Var, oh2 oh2Var, int i, p5 p5Var) {
        p5Var.x(aVar, ty1Var, oh2Var);
        p5Var.z(aVar, ty1Var, oh2Var, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void r0(p5.a aVar, boolean z, p5 p5Var) {
        p5Var.z0(aVar, z);
        p5Var.s0(aVar, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // qg.a
    public final void A(final int i, final long j, final long j2) {
        final p5.a aVarL1 = l1();
        r1(aVarL1, 1006, new pu1.a() { // from class: vd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).i0(aVarL1, i, j, j2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rq2
    public final void B(int i, jq2.b bVar, final ty1 ty1Var, final oh2 oh2Var, final IOException iOException, final boolean z) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1003, new pu1.a() { // from class: ad0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).q(aVarM1, ty1Var, oh2Var, iOException, z);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wo0
    public final void C(int i, jq2.b bVar) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1025, new pu1.a() { // from class: be0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).C0(aVarM1);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wo0
    public final void D(int i, jq2.b bVar) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1026, new pu1.a() { // from class: ae0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).i(aVarM1);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wo0
    public final void F(int i, jq2.b bVar) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1027, new pu1.a() { // from class: sd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).o0(aVarM1);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wo0
    public void G(int i, jq2.b bVar, final cr1 cr1Var) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1023, new pu1.a() { // from class: zd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ke0.S0(aVarM1, cr1Var, (p5) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public void G0(final int i) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 1034, new pu1.a() { // from class: gc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).L(aVarI1, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rq2
    public final void H(int i, jq2.b bVar, final ty1 ty1Var, final oh2 oh2Var, final int i2) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1000, new pu1.a() { // from class: wc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ke0.Z(aVarM1, ty1Var, oh2Var, i2, (p5) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void N0(List list, jq2.b bVar) {
        this.i.k(list, bVar, (hd3) gg3.q(this.l));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void U() {
        if (this.n) {
            return;
        }
        final p5.a aVarI1 = i1();
        this.n = true;
        r1(aVarI1, -1, new pu1.a() { // from class: lc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).w(aVarI1);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wo0
    public final void a(int i, jq2.b bVar, final Exception exc) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1024, new pu1.a() { // from class: jd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).y0(aVarM1, exc);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public void b(final pd.a aVar) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1032, new pu1.a() { // from class: ge0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).Y(aVarO1, aVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public void c(final pd.a aVar) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1031, new pu1.a() { // from class: md0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).G(aVarO1, aVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public void c0(final int i, final int i2, final boolean z) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1033, new pu1.a() { // from class: ec0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).Z(aVarO1, i, i2, z);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void d(final Exception exc) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1014, new pu1.a() { // from class: ud0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).g(aVarO1, exc);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void e(final String str) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1019, new pu1.a() { // from class: ac0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).V(aVarO1, str);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void f(final String str, final long j, final long j2) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1016, new pu1.a() { // from class: rc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ke0.L(aVarO1, str, j2, j, (p5) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void g(final gb0 gb0Var) {
        final p5.a aVarN1 = n1();
        r1(aVarN1, 1020, new pu1.a() { // from class: vc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).j0(aVarN1, gb0Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public void g0(final hd3 hd3Var, Looper looper) {
        gg3.v(this.l == null || this.i.b.isEmpty());
        this.l = (hd3) gg3.q(hd3Var);
        this.m = this.f.c(looper, null);
        this.k = this.k.d(looper, this.f, new pu1.b() { // from class: tb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.b
            public final void a(Object obj, o21 o21Var) {
                p5 p5Var = (p5) obj;
                p5Var.E0(hd3Var, new p5.b(o21Var, this.a.j));
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void h(final gb0 gb0Var) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1015, new pu1.a() { // from class: pd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).a0(aVarO1, gb0Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void i(final gb0 gb0Var) {
        final p5.a aVarN1 = n1();
        r1(aVarN1, 1013, new pu1.a() { // from class: fd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).v0(aVarN1, gb0Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p5.a i1() {
        return j1(this.i.d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void j(final String str) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1012, new pu1.a() { // from class: ee0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).j(aVarO1, str);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public void j0(p5 p5Var) {
        gg3.q(p5Var);
        this.k.c(p5Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p5.a j1(jq2.b bVar) {
        gg3.q(this.l);
        no4 no4VarF = bVar == null ? null : this.i.f(bVar);
        if (bVar != null && no4VarF != null) {
            return k1(no4VarF, no4VarF.n(bVar.a, this.g).c, bVar);
        }
        int currentMediaItemIndex = this.l.getCurrentMediaItemIndex();
        no4 currentTimeline = this.l.getCurrentTimeline();
        if (currentMediaItemIndex >= currentTimeline.v()) {
            currentTimeline = no4.a;
        }
        return k1(currentTimeline, currentMediaItemIndex, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void k(final String str, final long j, final long j2) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1008, new pu1.a() { // from class: yb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ke0.O0(aVarO1, str, j2, j, (p5) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p5.a k1(no4 no4Var, int i, jq2.b bVar) {
        jq2.b bVar2 = no4Var.w() ? null : bVar;
        long jE = this.f.e();
        boolean z = no4Var.equals(this.l.getCurrentTimeline()) && i == this.l.getCurrentMediaItemIndex();
        long jC = 0;
        if (bVar2 == null || !bVar2.c()) {
            if (z) {
                jC = this.l.getContentPosition();
            } else if (!no4Var.w()) {
                jC = no4Var.t(i, this.h).c();
            }
        } else if (z && this.l.getCurrentAdGroupIndex() == bVar2.b && this.l.getCurrentAdIndexInAdGroup() == bVar2.c) {
            jC = this.l.getCurrentPosition();
        }
        return new p5.a(jE, no4Var, i, bVar2, jC, this.l.getCurrentTimeline(), this.l.getCurrentMediaItemIndex(), this.i.d(), this.l.getCurrentPosition(), this.l.getTotalBufferedDuration());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void l(final int i, final long j) {
        final p5.a aVarN1 = n1();
        r1(aVarN1, 1018, new pu1.a() { // from class: bd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).q0(aVarN1, i, j);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p5.a l1() {
        return j1(this.i.e());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void m(final t41 t41Var, final lb0 lb0Var) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1009, new pu1.a() { // from class: od0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).T(aVarO1, t41Var, lb0Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p5.a m1(int i, jq2.b bVar) {
        gg3.q(this.l);
        if (bVar != null) {
            return this.i.f(bVar) != null ? j1(bVar) : k1(no4.a, i, bVar);
        }
        no4 currentTimeline = this.l.getCurrentTimeline();
        if (i >= currentTimeline.v()) {
            currentTimeline = no4.a;
        }
        return k1(currentTimeline, i, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void n(final Object obj, final long j) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 26, new pu1.a() { // from class: qd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj2) {
                ((p5) obj2).U(aVarO1, obj, j);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p5.a n1() {
        return j1(this.i.g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void o(final long j) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1010, new pu1.a() { // from class: yd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).v(aVarO1, j);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p5.a o1() {
        return j1(this.i.h());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onAudioAttributesChanged(final yb ybVar) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 20, new pu1.a() { // from class: vb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).E(aVarO1, ybVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onAudioSessionIdChanged(final int i) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 21, new pu1.a() { // from class: nd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).c0(aVarO1, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onAvailableCommandsChanged(final hd3.b bVar) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 13, new pu1.a() { // from class: he0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).n0(aVarI1, bVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onCues(final List list) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 27, new pu1.a() { // from class: fc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).h(aVarI1, list);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onDeviceInfoChanged(final kk0 kk0Var) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 29, new pu1.a() { // from class: hd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).I(aVarI1, kk0Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onDeviceVolumeChanged(final int i, final boolean z) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 30, new pu1.a() { // from class: cd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).m0(aVarI1, i, z);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onEvents(hd3 hd3Var, hd3.c cVar) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onIsLoadingChanged(final boolean z) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 3, new pu1.a() { // from class: td0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ke0.r0(aVarI1, z, (p5) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onIsPlayingChanged(final boolean z) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 7, new pu1.a() { // from class: xb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).d(aVarI1, z);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onLoadingChanged(boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onMaxSeekToPreviousPositionChanged(final long j) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 18, new pu1.a() { // from class: de0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).e0(aVarI1, j);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onMediaItemTransition(final fg2 fg2Var, final int i) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 1, new pu1.a() { // from class: je0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).N(aVarI1, fg2Var, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onMediaMetadataChanged(final ph2 ph2Var) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 14, new pu1.a() { // from class: xc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).u0(aVarI1, ph2Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onMetadata(final xs2 xs2Var) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 28, new pu1.a() { // from class: wb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).s(aVarI1, xs2Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onPlayWhenReadyChanged(final boolean z, final int i) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 5, new pu1.a() { // from class: dc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).t0(aVarI1, z, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onPlaybackParametersChanged(final dc3 dc3Var) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 12, new pu1.a() { // from class: qb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).n(aVarI1, dc3Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onPlaybackStateChanged(final int i) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 4, new pu1.a() { // from class: ic0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).t(aVarI1, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onPlaybackSuppressionReasonChanged(final int i) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 6, new pu1.a() { // from class: zb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).B0(aVarI1, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onPlayerError(final ac3 ac3Var) {
        final p5.a aVarP1 = p1(ac3Var);
        r1(aVarP1, 10, new pu1.a() { // from class: hc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).D0(aVarP1, ac3Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onPlayerErrorChanged(final ac3 ac3Var) {
        final p5.a aVarP1 = p1(ac3Var);
        r1(aVarP1, 10, new pu1.a() { // from class: cc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).c(aVarP1, ac3Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onPlayerStateChanged(final boolean z, final int i) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, -1, new pu1.a() { // from class: ub0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).R(aVarI1, z, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onPlaylistMetadataChanged(final ph2 ph2Var) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 15, new pu1.a() { // from class: jc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).O(aVarI1, ph2Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onPositionDiscontinuity(final hd3.e eVar, final hd3.e eVar2, final int i) {
        if (i == 1) {
            this.n = false;
        }
        this.i.j((hd3) gg3.q(this.l));
        final p5.a aVarI1 = i1();
        r1(aVarI1, 11, new pu1.a() { // from class: nc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ke0.A0(aVarI1, i, eVar, eVar2, (p5) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onRenderedFirstFrame() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onRepeatModeChanged(final int i) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 8, new pu1.a() { // from class: pc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).D(aVarI1, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onSeekBackIncrementChanged(final long j) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 16, new pu1.a() { // from class: ce0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).o(aVarI1, j);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onSeekForwardIncrementChanged(final long j) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 17, new pu1.a() { // from class: fe0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).m(aVarI1, j);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onShuffleModeEnabledChanged(final boolean z) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 9, new pu1.a() { // from class: sc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).a(aVarI1, z);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onSkipSilenceEnabledChanged(final boolean z) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 23, new pu1.a() { // from class: wd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).k(aVarO1, z);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onSurfaceSizeChanged(final int i, final int i2) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 24, new pu1.a() { // from class: tc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).B(aVarO1, i, i2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onTimelineChanged(no4 no4Var, final int i) {
        this.i.l((hd3) gg3.q(this.l));
        final p5.a aVarI1 = i1();
        r1(aVarI1, 0, new pu1.a() { // from class: ie0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).K(aVarI1, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onTrackSelectionParametersChanged(final lr4 lr4Var) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 19, new pu1.a() { // from class: id0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).d0(aVarI1, lr4Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public void onTracksChanged(final xr4 xr4Var) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 2, new pu1.a() { // from class: bc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).x0(aVarI1, xr4Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onVideoSizeChanged(final e35 e35Var) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 25, new pu1.a() { // from class: kc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ke0.Y(aVarO1, e35Var, (p5) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // hd3.d
    public final void onVolumeChanged(final float f) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 22, new pu1.a() { // from class: rb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).g0(aVarO1, f);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void p(final t41 t41Var, final lb0 lb0Var) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1017, new pu1.a() { // from class: ld0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).l0(aVarO1, t41Var, lb0Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final p5.a p1(ac3 ac3Var) {
        jq2.b bVar;
        return (!(ac3Var instanceof zv0) || (bVar = ((zv0) ac3Var).t) == null) ? i1() : j1(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void q(final Exception exc) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1029, new pu1.a() { // from class: qc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).e(aVarO1, exc);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q1() {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 1028, new pu1.a() { // from class: yc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).y(aVarI1);
            }
        });
        this.k.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void r(final Exception exc) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1030, new pu1.a() { // from class: sb0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).H(aVarO1, exc);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r1(p5.a aVar, int i, pu1.a aVar2) {
        this.j.put(i, aVar);
        this.k.k(i, aVar2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public void release() {
        ((mc1) gg3.q(this.m)).d(new Runnable() { // from class: oc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.q1();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rq2
    public final void s(int i, jq2.b bVar, final oh2 oh2Var) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1004, new pu1.a() { // from class: uc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).k0(aVarM1, oh2Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void t(final int i, final long j, final long j2) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1011, new pu1.a() { // from class: xd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).h0(aVarO1, i, j, j2);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void u(final gb0 gb0Var) {
        final p5.a aVarO1 = o1();
        r1(aVarO1, 1007, new pu1.a() { // from class: zc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).Q(aVarO1, gb0Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rq2
    public final void v(int i, jq2.b bVar, final oh2 oh2Var) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, WebSocketProtocol.CLOSE_NO_STATUS_CODE, new pu1.a() { // from class: rd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).A(aVarM1, oh2Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.o5
    public final void w(final long j, final int i) {
        final p5.a aVarN1 = n1();
        r1(aVarN1, 1021, new pu1.a() { // from class: dd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).r(aVarN1, j, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.wo0
    public final void x(int i, jq2.b bVar, final int i2) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1022, new pu1.a() { // from class: gd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ke0.M(aVarM1, i2, (p5) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rq2
    public final void y(int i, jq2.b bVar, final ty1 ty1Var, final oh2 oh2Var) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, 1002, new pu1.a() { // from class: ed0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).r0(aVarM1, ty1Var, oh2Var);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.rq2
    public final void z(int i, jq2.b bVar, final ty1 ty1Var, final oh2 oh2Var) {
        final p5.a aVarM1 = m1(i, bVar);
        r1(aVarM1, WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, new pu1.a() { // from class: kd0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).f0(aVarM1, ty1Var, oh2Var);
            }
        });
    }

    @Override // hd3.d
    public void onCues(final w50 w50Var) {
        final p5.a aVarI1 = i1();
        r1(aVarI1, 27, new pu1.a() { // from class: mc0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // pu1.a
            public final void invoke(Object obj) {
                ((p5) obj).p0(aVarI1, w50Var);
            }
        });
    }

    @Override // hd3.d
    public void onPositionDiscontinuity(int i) {
    }
}
