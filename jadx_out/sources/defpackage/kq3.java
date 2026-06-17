package defpackage;

import androidx.media3.exoplayer.e;
import androidx.media3.exoplayer.k;
import androidx.media3.exoplayer.o;
import defpackage.jq2;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class kq3 {
    public final o a;
    public final int b;
    public final o c;
    public int d = 0;
    public boolean e = false;
    public boolean f = false;

    public kq3(o oVar, o oVar2, int i) {
        this.a = oVar;
        this.b = i;
        this.c = oVar2;
    }

    public static t41[] i(jy0 jy0Var) {
        int length = jy0Var != null ? jy0Var.length() : 0;
        t41[] t41VarArr = new t41[length];
        for (int i = 0; i < length; i++) {
            t41VarArr[i] = ((jy0) gg3.q(jy0Var)).h(i);
        }
        return t41VarArr;
    }

    public static boolean z(o oVar) {
        return oVar.getState() != 0;
    }

    public final boolean A() {
        return this.d == 3;
    }

    public void B(gx3 gx3Var, e eVar, long j, boolean z) {
        C(this.a, gx3Var, eVar, j, z);
        o oVar = this.c;
        if (oVar != null) {
            C(oVar, gx3Var, eVar, j, z);
        }
    }

    public final void C(o oVar, gx3 gx3Var, e eVar, long j, boolean z) {
        if (z(oVar)) {
            if (gx3Var != oVar.G()) {
                d(oVar, eVar);
            } else if (z) {
                oVar.t(j, true);
            }
        }
    }

    public void D() {
        int i = this.d;
        if (i == 3 || i == 4) {
            a0(i == 4);
            this.d = this.d != 4 ? 1 : 0;
        } else if (i == 2) {
            this.d = 0;
        }
    }

    public final void E(boolean z) {
        if (z) {
            if (this.e) {
                this.a.reset();
                this.e = false;
                return;
            }
            return;
        }
        if (this.f) {
            ((o) gg3.q(this.c)).reset();
            this.f = false;
        }
    }

    public void F(pr4 pr4Var, pr4 pr4Var2, long j) {
        int i;
        boolean zC = pr4Var.c(this.b);
        boolean zC2 = pr4Var2.c(this.b);
        o oVar = (this.c == null || (i = this.d) == 3 || (i == 0 && z(this.a))) ? this.a : (o) gg3.q(this.c);
        if (!zC || oVar.L()) {
            return;
        }
        boolean z = m() == -2;
        jq3[] jq3VarArr = pr4Var.b;
        int i2 = this.b;
        jq3 jq3Var = jq3VarArr[i2];
        jq3 jq3Var2 = pr4Var2.b[i2];
        if (!zC2 || !Objects.equals(jq3Var2, jq3Var) || z || u()) {
            P(oVar, j);
        }
    }

    public void G(k kVar) {
        ((o) gg3.q(l(kVar))).H();
    }

    public void H() {
        this.a.release();
        this.e = false;
        o oVar = this.c;
        if (oVar != null) {
            oVar.release();
            this.f = false;
        }
    }

    public void I(long j, long j2) {
        if (z(this.a)) {
            this.a.c(j, j2);
        }
        o oVar = this.c;
        if (oVar == null || !z(oVar)) {
            return;
        }
        this.c.c(j, j2);
    }

    public int J(k kVar, pr4 pr4Var, e eVar) {
        int iK = K(this.a, kVar, pr4Var, eVar);
        return iK == 1 ? K(this.c, kVar, pr4Var, eVar) : iK;
    }

    public final int K(o oVar, k kVar, pr4 pr4Var, e eVar) {
        if (oVar == null || !z(oVar) || ((oVar == this.a && w()) || (oVar == this.c && A()))) {
            return 1;
        }
        gx3 gx3VarG = oVar.G();
        gx3[] gx3VarArr = kVar.c;
        int i = this.b;
        boolean z = gx3VarG != gx3VarArr[i];
        boolean zC = pr4Var.c(i);
        if (zC && !z) {
            return 1;
        }
        if (!oVar.L()) {
            oVar.o(i(pr4Var.c[this.b]), (gx3) gg3.q(kVar.c[this.b]), kVar.n(), kVar.m(), kVar.h.a);
            return 3;
        }
        if (!oVar.b()) {
            return 0;
        }
        d(oVar, eVar);
        if (!zC || u()) {
            E(oVar == this.a);
        }
        return 1;
    }

    public void L() {
        if (!z(this.a)) {
            E(true);
        }
        o oVar = this.c;
        if (oVar == null || z(oVar)) {
            return;
        }
        E(false);
    }

    public void M(k kVar, long j, boolean z) {
        o oVarL = l(kVar);
        if (oVarL != null) {
            oVarL.t(j, z);
        }
    }

    public void N(long j) {
        int i;
        if (z(this.a) && (i = this.d) != 4 && i != 2) {
            P(this.a, j);
        }
        o oVar = this.c;
        if (oVar == null || !z(oVar) || this.d == 3) {
            return;
        }
        P(this.c, j);
    }

    public void O(k kVar, long j) {
        P((o) gg3.q(l(kVar)), j);
    }

    public final void P(o oVar, long j) {
        oVar.q();
        if (oVar instanceof vm4) {
            ((vm4) oVar).G0(j);
        }
    }

    public void Q(float f, float f2) {
        this.a.z(f, f2);
        o oVar = this.c;
        if (oVar != null) {
            oVar.z(f, f2);
        }
    }

    public void R(fz3 fz3Var) {
        this.a.F(18, fz3Var);
        o oVar = this.c;
        if (oVar != null) {
            oVar.F(18, fz3Var);
        }
    }

    public void S(no4 no4Var) {
        this.a.f(no4Var);
        o oVar = this.c;
        if (oVar != null) {
            oVar.f(no4Var);
        }
    }

    public void T(j25 j25Var) {
        if (m() == 2 || m() == 4) {
            this.a.F(7, j25Var);
            o oVar = this.c;
            if (oVar != null) {
                oVar.F(7, j25Var);
            }
        }
    }

    public void U(Object obj) {
        if (m() != 2) {
            return;
        }
        int i = this.d;
        if (i == 4 || i == 1) {
            ((o) gg3.q(this.c)).F(1, obj);
        } else {
            this.a.F(1, obj);
        }
    }

    public void V(float f) {
        if (m() != 1) {
            return;
        }
        this.a.F(2, Float.valueOf(f));
        o oVar = this.c;
        if (oVar != null) {
            oVar.F(2, Float.valueOf(f));
        }
    }

    public void W() {
        if (this.a.getState() == 1 && this.d != 4) {
            this.a.start();
            return;
        }
        o oVar = this.c;
        if (oVar == null || oVar.getState() != 1 || this.d == 3) {
            return;
        }
        this.c.start();
    }

    public void X() {
        int i;
        gg3.v(!u());
        if (z(this.a)) {
            i = 3;
        } else {
            o oVar = this.c;
            i = (oVar == null || !z(oVar)) ? 2 : 4;
        }
        this.d = i;
    }

    public void Y() {
        if (z(this.a)) {
            g(this.a);
        }
        o oVar = this.c;
        if (oVar == null || !z(oVar)) {
            return;
        }
        g(this.c);
    }

    public boolean Z(k kVar, long j) {
        o oVarL = l(kVar);
        return oVarL != null && oVarL.M(j);
    }

    public boolean a(k kVar) {
        o oVarL = l(kVar);
        return oVarL == null || oVarL.j() || oVarL.isReady() || oVarL.b();
    }

    public final void a0(boolean z) {
        if (z) {
            ((o) gg3.q(this.c)).F(17, this.a);
        } else {
            this.a.F(17, gg3.q(this.c));
        }
    }

    public void b(e eVar) {
        d(this.a, eVar);
        o oVar = this.c;
        if (oVar != null) {
            boolean z = z(oVar) && this.d != 3;
            d(this.c, eVar);
            E(false);
            if (z) {
                a0(true);
            }
        }
        this.d = 0;
    }

    public void c(e eVar) {
        if (u()) {
            int i = this.d;
            boolean z = i == 4 || i == 2;
            int i2 = i != 4 ? 0 : 1;
            d(z ? this.a : (o) gg3.q(this.c), eVar);
            E(z);
            this.d = i2;
        }
    }

    public final void d(o oVar, e eVar) {
        gg3.v(this.a == oVar || this.c == oVar);
        if (z(oVar)) {
            eVar.a(oVar);
            g(oVar);
            oVar.disable();
        }
    }

    public void e(jq3 jq3Var, jy0 jy0Var, gx3 gx3Var, long j, boolean z, boolean z2, long j2, long j3, jq2.b bVar, e eVar) throws zv0 {
        t41[] t41VarArrI = i(jy0Var);
        int i = this.d;
        if (i == 0 || i == 2 || i == 4) {
            this.e = true;
            this.a.m(jq3Var, t41VarArrI, gx3Var, j, z, z2, j2, j3, bVar);
            eVar.b(this.a);
        } else {
            this.f = true;
            ((o) gg3.q(this.c)).m(jq3Var, t41VarArrI, gx3Var, j, z, z2, j2, j3, bVar);
            eVar.b(this.c);
        }
    }

    public void f() {
        if (z(this.a)) {
            this.a.p();
            return;
        }
        o oVar = this.c;
        if (oVar == null || !z(oVar)) {
            return;
        }
        this.c.p();
    }

    public final void g(o oVar) {
        if (oVar.getState() == 2) {
            oVar.stop();
        }
    }

    public int h() {
        boolean z = z(this.a);
        o oVar = this.c;
        return (z ? 1 : 0) + ((oVar == null || !z(oVar)) ? 0 : 1);
    }

    public long j(long j, long j2) {
        long jL = z(this.a) ? this.a.l(j, j2) : Long.MAX_VALUE;
        o oVar = this.c;
        return (oVar == null || !z(oVar)) ? jL : Math.min(jL, this.c.l(j, j2));
    }

    public long k(k kVar) {
        o oVarL = l(kVar);
        Objects.requireNonNull(oVarL);
        return oVarL.I();
    }

    public final o l(k kVar) {
        if (kVar != null && kVar.c[this.b] != null) {
            if (this.a.G() == kVar.c[this.b]) {
                return this.a;
            }
            o oVar = this.c;
            if (oVar != null && oVar.G() == kVar.c[this.b]) {
                return this.c;
            }
        }
        return null;
    }

    public int m() {
        return this.a.d();
    }

    public void n(int i, Object obj, k kVar) {
        ((o) gg3.q(l(kVar))).F(i, obj);
    }

    public boolean o(k kVar) {
        return p(kVar, this.a) && p(kVar, this.c);
    }

    public final boolean p(k kVar, o oVar) {
        if (oVar == null) {
            return true;
        }
        gx3 gx3Var = kVar.c[this.b];
        if (oVar.G() == null || (oVar.G() == gx3Var && (gx3Var == null || oVar.j() || q(oVar, kVar)))) {
            return true;
        }
        k kVarK = kVar.k();
        return kVarK != null && kVarK.c[this.b] == oVar.G();
    }

    public final boolean q(o oVar, k kVar) {
        k kVarK = kVar.k();
        if (kVar.h.h && kVarK != null && kVarK.f) {
            return (oVar instanceof vm4) || (oVar instanceof ft2) || oVar.I() >= kVarK.n();
        }
        return false;
    }

    public boolean r(k kVar) {
        return ((o) gg3.q(l(kVar))).j();
    }

    public boolean s() {
        return this.c != null;
    }

    public boolean t() {
        boolean zB = z(this.a) ? this.a.b() : true;
        o oVar = this.c;
        return (oVar == null || !z(oVar)) ? zB : this.c.b() & zB;
    }

    public boolean u() {
        return w() || A();
    }

    public boolean v(k kVar) {
        return (w() && l(kVar) == this.a) || (A() && l(kVar) == this.c);
    }

    public final boolean w() {
        int i = this.d;
        return i == 2 || i == 4;
    }

    public boolean x(k kVar) {
        return l(kVar) != null;
    }

    public boolean y() {
        int i = this.d;
        return (i == 0 || i == 2 || i == 4) ? z(this.a) : z((o) gg3.q(this.c));
    }
}
