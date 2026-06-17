package defpackage;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import defpackage.qx3;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yo3 implements i {
    public static final a g = new a(null);
    public final vx3 f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements qx3.b {
        public final Set a;

        public b(qx3 qx3Var) {
            qx3Var.getClass();
            this.a = new LinkedHashSet();
            qx3Var.c("androidx.savedstate.Restarter", this);
        }

        @Override // qx3.b
        public Bundle a() {
            i73[] i73VarArr;
            Map mapH = y42.h();
            if (mapH.isEmpty()) {
                i73VarArr = new i73[0];
            } else {
                ArrayList arrayList = new ArrayList(mapH.size());
                for (Map.Entry entry : mapH.entrySet()) {
                    arrayList.add(fu4.a((String) entry.getKey(), entry.getValue()));
                }
                i73VarArr = (i73[]) arrayList.toArray(new i73[0]);
            }
            Bundle bundleA = jm.a((i73[]) Arrays.copyOf(i73VarArr, i73VarArr.length));
            xx3.d(xx3.a(bundleA), "classes_to_restore", ww.a0(this.a));
            return bundleA;
        }

        public final void b(String str) {
            str.getClass();
            this.a.add(str);
        }
    }

    public yo3(vx3 vx3Var) {
        vx3Var.getClass();
        this.f = vx3Var;
    }

    public final void a(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, yo3.class.getClassLoader()).asSubclass(qx3.a.class);
            clsAsSubclass.getClass();
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    objNewInstance.getClass();
                    ((qx3.a) objNewInstance).a(this.f);
                } catch (Exception e) {
                    wo3.a("Failed to instantiate ", str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            xo3.a("Class ", str, " wasn't found", e3);
        }
    }

    @Override // androidx.lifecycle.i
    public void c(bt1 bt1Var, g.a aVar) {
        bt1Var.getClass();
        aVar.getClass();
        if (aVar != g.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        bt1Var.getLifecycle().c(this);
        Bundle bundleA = this.f.l0().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        List listE = nx3.e(nx3.a(bundleA), "classes_to_restore");
        if (listE == null) {
            e04.a("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            return;
        }
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            a((String) it.next());
        }
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
