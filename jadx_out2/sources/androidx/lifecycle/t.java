package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.x;
import defpackage.c45;
import defpackage.d50;
import defpackage.e04;
import defpackage.hp1;
import defpackage.jl;
import defpackage.kx3;
import defpackage.l45;
import defpackage.lx3;
import defpackage.np3;
import defpackage.qx3;
import defpackage.vx3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {
    public static final d50.c a;
    public static final d50.c b;
    public static final d50.c c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements x.c {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.x.c
        public c45 c(hp1 hp1Var, d50 d50Var) {
            hp1Var.getClass();
            d50Var.getClass();
            return new lx3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements d50.c {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements d50.c {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements d50.c {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        d50.a aVar = d50.b;
        a = new b();
        b = new c();
        c = new d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final q a(d50 d50Var) {
        d50Var.getClass();
        vx3 vx3Var = (vx3) d50Var.a(a);
        if (vx3Var == null) {
            jl.a("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
            return null;
        }
        l45 l45Var = (l45) d50Var.a(b);
        if (l45Var == null) {
            jl.a("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
            return null;
        }
        Bundle bundle = (Bundle) d50Var.a(c);
        String str = (String) d50Var.a(x.c);
        if (str != null) {
            return b(vx3Var, l45Var, str, bundle);
        }
        jl.a("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final q b(vx3 vx3Var, l45 l45Var, String str, Bundle bundle) {
        kx3 kx3VarD = d(vx3Var);
        lx3 lx3VarE = e(l45Var);
        q qVar = (q) lx3VarE.e().get(str);
        if (qVar != null) {
            return qVar;
        }
        q qVarA = q.c.a(kx3VarD.c(str), bundle);
        lx3VarE.e().put(str, qVarA);
        return qVarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void c(vx3 vx3Var) {
        vx3Var.getClass();
        g.b bVarB = vx3Var.getLifecycle().b();
        if (bVarB != g.b.g && bVarB != g.b.h) {
            jl.a("Failed requirement.");
        } else if (vx3Var.l0().b("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            kx3 kx3Var = new kx3(vx3Var.l0(), (l45) vx3Var);
            vx3Var.l0().c("androidx.lifecycle.internal.SavedStateHandlesProvider", kx3Var);
            vx3Var.getLifecycle().a(new r(kx3Var));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final kx3 d(vx3 vx3Var) {
        vx3Var.getClass();
        qx3.b bVarB = vx3Var.l0().b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        kx3 kx3Var = bVarB instanceof kx3 ? (kx3) bVarB : null;
        if (kx3Var != null) {
            return kx3Var;
        }
        e04.a("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final lx3 e(l45 l45Var) {
        l45Var.getClass();
        return (lx3) x.b.b(x.b, l45Var, new a(), null, 4, null).c("androidx.lifecycle.internal.SavedStateHandlesVM", np3.b(lx3.class));
    }
}
