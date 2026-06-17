package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.x;
import defpackage.c45;
import defpackage.d50;
import defpackage.dp1;
import defpackage.e04;
import defpackage.fn;
import defpackage.g6;
import defpackage.hp1;
import defpackage.jl;
import defpackage.qx3;
import defpackage.vx3;
import defpackage.wx3;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends x.e implements x.c {
    public Application b;
    public final x.c c;
    public Bundle d;
    public g e;
    public qx3 f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public u(Application application, vx3 vx3Var, Bundle bundle) {
        vx3Var.getClass();
        this.f = vx3Var.l0();
        this.e = vx3Var.getLifecycle();
        this.d = bundle;
        this.b = application;
        this.c = application != null ? x.a.f.a(application) : new x.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.x.c
    public c45 a(Class cls) {
        cls.getClass();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return e(canonicalName, cls);
        }
        jl.a("Local and anonymous classes can not be ViewModels");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.x.c
    public c45 b(Class cls, d50 d50Var) {
        cls.getClass();
        d50Var.getClass();
        String str = (String) d50Var.a(x.c);
        if (str == null) {
            e04.a("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
            return null;
        }
        if (d50Var.a(t.a) == null || d50Var.a(t.b) == null) {
            if (this.e != null) {
                return e(str, cls);
            }
            e04.a("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            return null;
        }
        Application application = (Application) d50Var.a(x.a.h);
        boolean zIsAssignableFrom = g6.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? wx3.c(cls, wx3.b) : wx3.c(cls, wx3.a);
        return constructorC == null ? this.c.b(cls, d50Var) : (!zIsAssignableFrom || application == null) ? wx3.d(cls, constructorC, t.a(d50Var)) : wx3.d(cls, constructorC, application, t.a(d50Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.x.c
    public c45 c(hp1 hp1Var, d50 d50Var) {
        hp1Var.getClass();
        d50Var.getClass();
        return b(dp1.a(hp1Var), d50Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.x.e
    public void d(c45 c45Var) {
        c45Var.getClass();
        if (this.e != null) {
            qx3 qx3Var = this.f;
            qx3Var.getClass();
            g gVar = this.e;
            gVar.getClass();
            f.a(c45Var, qx3Var, gVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c45 e(String str, Class cls) {
        c45 c45VarD;
        Application application;
        str.getClass();
        cls.getClass();
        g gVar = this.e;
        if (gVar == null) {
            fn.a("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }
        boolean zIsAssignableFrom = g6.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || this.b == null) ? wx3.c(cls, wx3.b) : wx3.c(cls, wx3.a);
        if (constructorC == null) {
            return this.b != null ? this.c.a(cls) : x.d.b.a().a(cls);
        }
        qx3 qx3Var = this.f;
        qx3Var.getClass();
        s sVarB = f.b(qx3Var, gVar, str, this.d);
        if (!zIsAssignableFrom || (application = this.b) == null) {
            c45VarD = wx3.d(cls, constructorC, sVarB.t());
        } else {
            application.getClass();
            c45VarD = wx3.d(cls, constructorC, application, sVarB.t());
        }
        c45VarD.a("androidx.lifecycle.savedstate.vm.tag", sVarB);
        return c45VarD;
    }
}
