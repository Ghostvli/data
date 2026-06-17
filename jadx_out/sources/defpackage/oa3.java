package defpackage;

import android.app.Dialog;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class oa3 {
    public static final a s = new a(null);
    public u51 a;
    public p51 b;
    public int c;
    public int d;
    public int e;
    public Dialog f;
    public Set g;
    public Set h;
    public boolean i;
    public boolean j;
    public Set k;
    public Set l;
    public Set m;
    public Set n;
    public Set o;
    public Set p;
    public Set q;
    public cr3 r;

    public oa3(u51 u51Var, p51 p51Var, Set set, Set set2) {
        set.getClass();
        set2.getClass();
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.k = new LinkedHashSet();
        this.l = new LinkedHashSet();
        this.m = new LinkedHashSet();
        this.n = new LinkedHashSet();
        this.o = new LinkedHashSet();
        this.p = new LinkedHashSet();
        this.q = new LinkedHashSet();
        if (u51Var != null) {
            r(u51Var);
        }
        if (u51Var == null && p51Var != null) {
            u51 u51VarX1 = p51Var.X1();
            u51VarX1.getClass();
            r(u51VarX1);
        }
        this.b = p51Var;
        this.g = set;
        this.h = set2;
    }

    public final void a() {
        g();
        q();
    }

    public final u51 b() {
        u51 u51Var = this.a;
        if (u51Var != null) {
            return u51Var;
        }
        il1.j("activity");
        return null;
    }

    public final k61 c() {
        p51 p51Var = this.b;
        k61 k61VarT = p51Var != null ? p51Var.T() : null;
        if (k61VarT != null) {
            return k61VarT;
        }
        k61 k61VarN1 = b().n1();
        k61VarN1.getClass();
        return k61VarN1;
    }

    public final fm1 d() {
        p51 p51VarJ0 = c().j0("InvisibleFragment");
        if (p51VarJ0 != null) {
            return (fm1) p51VarJ0;
        }
        fm1 fm1Var = new fm1();
        c().o().d(fm1Var, "InvisibleFragment").k();
        return fm1Var;
    }

    public final int e() {
        return b().getApplicationInfo().targetSdkVersion;
    }

    public final void f() {
        if (Build.VERSION.SDK_INT != 26) {
            this.e = b().getRequestedOrientation();
            int i = b().getResources().getConfiguration().orientation;
            if (i == 1) {
                b().setRequestedOrientation(7);
            } else {
                if (i != 2) {
                    return;
                }
                b().setRequestedOrientation(6);
            }
        }
    }

    public final void g() {
        p51 p51VarJ0 = c().j0("InvisibleFragment");
        if (p51VarJ0 != null) {
            c().o().p(p51VarJ0).k();
        }
    }

    public final void h(cr3 cr3Var) {
        this.r = cr3Var;
        z();
    }

    public final void i(kr krVar) {
        krVar.getClass();
        d().X2(this, krVar);
    }

    public final void j(kr krVar) {
        krVar.getClass();
        d().Y2(this, krVar);
    }

    public final void k(kr krVar) {
        krVar.getClass();
        d().Z2(this, krVar);
    }

    public final void l(kr krVar) {
        krVar.getClass();
        d().a3(this, krVar);
    }

    public final void m(kr krVar) {
        krVar.getClass();
        d().b3(this, krVar);
    }

    public final void n(Set set, kr krVar) {
        set.getClass();
        krVar.getClass();
        d().c3(this, set, krVar);
    }

    public final void o(kr krVar) {
        krVar.getClass();
        d().d3(this, krVar);
    }

    public final void p(kr krVar) {
        krVar.getClass();
        d().e3(this, krVar);
    }

    public final void q() {
        if (Build.VERSION.SDK_INT != 26) {
            b().setRequestedOrientation(this.e);
        }
    }

    public final void r(u51 u51Var) {
        u51Var.getClass();
        this.a = u51Var;
    }

    public final boolean s() {
        return this.h.contains("android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public final boolean t() {
        return this.h.contains("android.permission.BODY_SENSORS_BACKGROUND");
    }

    public final boolean u() {
        return this.h.contains("android.permission.REQUEST_INSTALL_PACKAGES");
    }

    public final boolean v() {
        return this.h.contains("android.permission.MANAGE_EXTERNAL_STORAGE");
    }

    public final boolean w() {
        return this.h.contains("android.permission.POST_NOTIFICATIONS");
    }

    public final boolean x() {
        return this.h.contains("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public final boolean y() {
        return this.h.contains("android.permission.WRITE_SETTINGS");
    }

    public final void z() {
        f();
        dr3 dr3Var = new dr3();
        dr3Var.a(new or3(this));
        dr3Var.a(new zq3(this));
        dr3Var.a(new rr3(this));
        dr3Var.a(new tr3(this));
        dr3Var.a(new kr3(this));
        dr3Var.a(new hr3(this));
        dr3Var.a(new pr3(this));
        dr3Var.a(new ar3(this));
        dr3Var.b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
