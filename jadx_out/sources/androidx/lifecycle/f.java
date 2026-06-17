package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.g;
import defpackage.bt1;
import defpackage.c45;
import defpackage.k45;
import defpackage.l45;
import defpackage.qx3;
import defpackage.r53;
import defpackage.vx3;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f a = new f();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements qx3.a {
        @Override // qx3.a
        public void a(vx3 vx3Var) {
            vx3Var.getClass();
            if (!(vx3Var instanceof l45)) {
                r53.a("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: ", vx3Var);
                return;
            }
            k45 k45VarD0 = ((l45) vx3Var).d0();
            qx3 qx3VarL0 = vx3Var.l0();
            Iterator it = k45VarD0.c().iterator();
            while (it.hasNext()) {
                c45 c45VarB = k45VarD0.b((String) it.next());
                if (c45VarB != null) {
                    f.a(c45VarB, qx3VarL0, vx3Var.getLifecycle());
                }
            }
            if (k45VarD0.c().isEmpty()) {
                return;
            }
            qx3VarL0.d(a.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements i {
        public final /* synthetic */ g f;
        public final /* synthetic */ qx3 g;

        public b(g gVar, qx3 qx3Var) {
            this.f = gVar;
            this.g = qx3Var;
        }

        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            bt1Var.getClass();
            aVar.getClass();
            if (aVar == g.a.ON_START) {
                this.f.c(this);
                this.g.d(a.class);
            }
        }
    }

    public static final void a(c45 c45Var, qx3 qx3Var, g gVar) {
        c45Var.getClass();
        qx3Var.getClass();
        gVar.getClass();
        s sVar = (s) c45Var.c("androidx.lifecycle.savedstate.vm.tag");
        if (sVar == null || sVar.u()) {
            return;
        }
        sVar.a(qx3Var, gVar);
        a.c(qx3Var, gVar);
    }

    public static final s b(qx3 qx3Var, g gVar, String str, Bundle bundle) {
        qx3Var.getClass();
        gVar.getClass();
        str.getClass();
        s sVar = new s(str, q.c.a(qx3Var.a(str), bundle));
        sVar.a(qx3Var, gVar);
        a.c(qx3Var, gVar);
        return sVar;
    }

    public final void c(qx3 qx3Var, g gVar) {
        g.b bVarB = gVar.b();
        if (bVarB == g.b.g || bVarB.b(g.b.i)) {
            qx3Var.d(a.class);
        } else {
            gVar.a(new b(gVar, qx3Var));
        }
    }
}
