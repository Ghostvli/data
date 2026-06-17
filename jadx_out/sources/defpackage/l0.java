package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l0 implements j02, Serializable {
    @Override // defpackage.j02
    public void A(String str, Object obj, Object obj2) {
        if (l()) {
            B(rs1.INFO, null, str, obj, obj2);
        }
    }

    public final void B(rs1 rs1Var, b52 b52Var, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            D(rs1Var, b52Var, str, new Object[]{obj}, (Throwable) obj2);
        } else {
            D(rs1Var, b52Var, str, new Object[]{obj, obj2}, null);
        }
    }

    public final void C(rs1 rs1Var, b52 b52Var, String str, Object[] objArr) {
        Throwable thA = os2.a(objArr);
        if (thA != null) {
            D(rs1Var, b52Var, str, os2.b(objArr), thA);
        } else {
            D(rs1Var, b52Var, str, objArr, null);
        }
    }

    public abstract void D(rs1 rs1Var, b52 b52Var, String str, Object[] objArr, Throwable th);

    public final void E(rs1 rs1Var, b52 b52Var, String str, Throwable th) {
        D(rs1Var, b52Var, str, null, th);
    }

    public final void F(rs1 rs1Var, b52 b52Var, String str, Object obj) {
        D(rs1Var, b52Var, str, new Object[]{obj}, null);
    }

    @Override // defpackage.j02
    public void a(String str, Throwable th) {
        if (j()) {
            E(rs1.ERROR, null, str, th);
        }
    }

    @Override // defpackage.j02
    public void b(String str) {
        if (g()) {
            E(rs1.DEBUG, null, str, null);
        }
    }

    @Override // defpackage.j02
    public void c(String str, Object obj) {
        if (l()) {
            F(rs1.INFO, null, str, obj);
        }
    }

    @Override // defpackage.j02
    public void d(String str, Object obj) {
        if (e()) {
            F(rs1.WARN, null, str, obj);
        }
    }

    @Override // defpackage.j02
    public void error(String str) {
        if (j()) {
            E(rs1.ERROR, null, str, null);
        }
    }

    @Override // defpackage.j02
    public void f(String str, Object obj, Object obj2) {
        if (g()) {
            B(rs1.DEBUG, null, str, obj, obj2);
        }
    }

    @Override // defpackage.j02
    public void h(String str, Object obj) {
        if (n()) {
            F(rs1.TRACE, null, str, obj);
        }
    }

    @Override // defpackage.j02
    public void i(String str, Object obj, Object obj2) {
        if (n()) {
            B(rs1.TRACE, null, str, obj, obj2);
        }
    }

    @Override // defpackage.j02
    public void info(String str) {
        if (l()) {
            E(rs1.INFO, null, str, null);
        }
    }

    @Override // defpackage.j02
    public void k(String str, Object... objArr) {
        if (e()) {
            C(rs1.WARN, null, str, objArr);
        }
    }

    @Override // defpackage.j02
    public void m(String str, Object obj, Object obj2) {
        if (e()) {
            B(rs1.WARN, null, str, obj, obj2);
        }
    }

    @Override // defpackage.j02
    public void o(String str, Object obj, Object obj2) {
        if (j()) {
            B(rs1.ERROR, null, str, obj, obj2);
        }
    }

    @Override // defpackage.j02
    public void p(String str, Object... objArr) {
        if (j()) {
            C(rs1.ERROR, null, str, objArr);
        }
    }

    @Override // defpackage.j02
    public void q(String str, Object obj) {
        if (g()) {
            F(rs1.DEBUG, null, str, obj);
        }
    }

    @Override // defpackage.j02
    public void r(String str, Object obj) {
        if (j()) {
            F(rs1.ERROR, null, str, obj);
        }
    }

    @Override // defpackage.j02
    public void s(String str, Object... objArr) {
        if (g()) {
            C(rs1.DEBUG, null, str, objArr);
        }
    }

    @Override // defpackage.j02
    public void t(String str, Throwable th) {
        if (l()) {
            E(rs1.INFO, null, str, th);
        }
    }

    @Override // defpackage.j02
    public void u(String str, Throwable th) {
        if (e()) {
            E(rs1.WARN, null, str, th);
        }
    }

    @Override // defpackage.j02
    public void v(String str, Throwable th) {
        if (n()) {
            E(rs1.TRACE, null, str, th);
        }
    }

    @Override // defpackage.j02
    public void w(String str, Throwable th) {
        if (g()) {
            E(rs1.DEBUG, null, str, th);
        }
    }

    @Override // defpackage.j02
    public void warn(String str) {
        if (e()) {
            E(rs1.WARN, null, str, null);
        }
    }

    @Override // defpackage.j02
    public void y(String str) {
        if (n()) {
            E(rs1.TRACE, null, str, null);
        }
    }

    @Override // defpackage.j02
    public void z(String str, Object... objArr) {
        if (l()) {
            C(rs1.INFO, null, str, objArr);
        }
    }
}
