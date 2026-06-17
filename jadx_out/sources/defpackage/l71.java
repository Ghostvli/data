package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.j;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.x;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class l71 implements e, vx3, l45 {
    public final p51 f;
    public final k45 g;
    public final Runnable h;
    public x.c i;
    public j j = null;
    public sx3 k = null;

    public l71(p51 p51Var, k45 k45Var, Runnable runnable) {
        this.f = p51Var;
        this.g = k45Var;
        this.h = runnable;
    }

    @Override // androidx.lifecycle.e
    public x.c L() {
        Application application;
        x.c cVarL = this.f.L();
        if (!cVarL.equals(this.f.b0)) {
            this.i = cVarL;
            return cVarL;
        }
        if (this.i == null) {
            Context applicationContext = this.f.Y1().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            p51 p51Var = this.f;
            this.i = new u(application, p51Var, p51Var.S());
        }
        return this.i;
    }

    @Override // androidx.lifecycle.e
    public d50 M() {
        Application application;
        Context applicationContext = this.f.Y1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        mw2 mw2Var = new mw2();
        if (application != null) {
            mw2Var.c(x.a.h, application);
        }
        mw2Var.c(t.a, this.f);
        mw2Var.c(t.b, this);
        if (this.f.S() != null) {
            mw2Var.c(t.c, this.f.S());
        }
        return mw2Var;
    }

    public void a(g.a aVar) {
        this.j.h(aVar);
    }

    public void b() {
        if (this.j == null) {
            this.j = new j(this);
            sx3 sx3VarA = sx3.a(this);
            this.k = sx3VarA;
            sx3VarA.c();
            this.h.run();
        }
    }

    public boolean c() {
        return this.j != null;
    }

    public void d(Bundle bundle) {
        this.k.d(bundle);
    }

    @Override // defpackage.l45
    public k45 d0() {
        b();
        return this.g;
    }

    public void e(Bundle bundle) {
        this.k.e(bundle);
    }

    public void f(g.b bVar) {
        this.j.m(bVar);
    }

    @Override // defpackage.bt1
    public g getLifecycle() {
        b();
        return this.j;
    }

    @Override // defpackage.vx3
    public qx3 l0() {
        b();
        return this.k.b();
    }
}
