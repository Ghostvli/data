package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends sn1 implements ln1, f30, u40 {
    public final g40 h;

    public w(g40 g40Var, boolean z, boolean z2) {
        super(z2);
        if (z) {
            j0((ln1) g40Var.a(ln1.e));
        }
        this.h = g40Var.N(this);
    }

    @Override // defpackage.sn1
    public String C() {
        return ua0.a(this) + " was cancelled";
    }

    public void O0(Object obj) {
        q(obj);
    }

    public void P0(Throwable th, boolean z) {
    }

    public void Q0(Object obj) {
    }

    public final void R0(y40 y40Var, Object obj, Function2 function2) {
        y40Var.b(function2, obj, this);
    }

    @Override // defpackage.sn1, defpackage.ln1
    public boolean c() {
        return super.c();
    }

    @Override // defpackage.u40
    public g40 g() {
        return this.h;
    }

    @Override // defpackage.f30
    public final g40 getContext() {
        return this.h;
    }

    @Override // defpackage.sn1
    public final void i0(Throwable th) {
        r40.a(this.h, th);
    }

    @Override // defpackage.f30
    public final void resumeWith(Object obj) {
        Object objS0 = s0(cy.b(obj));
        if (objS0 == tn1.b) {
            return;
        }
        O0(objS0);
    }

    @Override // defpackage.sn1
    public String t0() {
        String strE = k40.e(this.h);
        if (strE == null) {
            return super.t0();
        }
        return "\"" + strE + "\":" + super.t0();
    }

    @Override // defpackage.sn1
    public final void y0(Object obj) {
        if (!(obj instanceof zx)) {
            Q0(obj);
        } else {
            zx zxVar = (zx) obj;
            P0(zxVar.a, zxVar.a());
        }
    }
}
