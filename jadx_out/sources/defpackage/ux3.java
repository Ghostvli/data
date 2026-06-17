package defpackage;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import defpackage.qx3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ux3 {
    public static final a i = new a(null);
    public final vx3 a;
    public final Function0 b;
    public final ck4 c;
    public final Map d;
    public boolean e;
    public Bundle f;
    public boolean g;
    public boolean h;

    public ux3(vx3 vx3Var, Function0 function0) {
        vx3Var.getClass();
        function0.getClass();
        this.a = vx3Var;
        this.b = function0;
        this.c = new ck4();
        this.d = new LinkedHashMap();
        this.h = true;
    }

    public static void a(ux3 ux3Var, bt1 bt1Var, g.a aVar) {
        bt1Var.getClass();
        aVar.getClass();
        if (aVar == g.a.ON_START) {
            ux3Var.h = true;
        } else if (aVar == g.a.ON_STOP) {
            ux3Var.h = false;
        }
    }

    public final Bundle c(String str) {
        str.getClass();
        if (!this.g) {
            e04.a("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
            return null;
        }
        Bundle bundle = this.f;
        if (bundle == null) {
            return null;
        }
        Bundle bundleA = nx3.a(bundle);
        Bundle bundleC = nx3.b(bundleA, str) ? nx3.c(bundleA, str) : null;
        xx3.e(xx3.a(bundle), str);
        if (nx3.f(nx3.a(bundle))) {
            this.f = null;
        }
        return bundleC;
    }

    public final qx3.b d(String str) {
        qx3.b bVar;
        str.getClass();
        synchronized (this.c) {
            Iterator it = this.d.entrySet().iterator();
            do {
                bVar = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str2 = (String) entry.getKey();
                qx3.b bVar2 = (qx3.b) entry.getValue();
                if (il1.a(str2, str)) {
                    bVar = bVar2;
                }
            } while (bVar == null);
        }
        return bVar;
    }

    public final boolean e() {
        return this.h;
    }

    public final void f() {
        if (this.a.getLifecycle().b() != g.b.g) {
            e04.a("Restarter must be created only during owner's initialization stage");
        } else {
            if (this.e) {
                e04.a("SavedStateRegistry was already attached.");
                return;
            }
            this.b.invoke();
            this.a.getLifecycle().a(new i() { // from class: tx3
                @Override // androidx.lifecycle.i
                public final void c(bt1 bt1Var, g.a aVar) {
                    ux3.a(this.f, bt1Var, aVar);
                }
            });
            this.e = true;
        }
    }

    public final void g(Bundle bundle) {
        if (!this.e) {
            f();
        }
        if (this.a.getLifecycle().b().b(g.b.i)) {
            r53.a("performRestore cannot be called when owner is ", this.a.getLifecycle().b());
            return;
        }
        if (this.g) {
            e04.a("SavedStateRegistry was already restored.");
            return;
        }
        Bundle bundleC = null;
        if (bundle != null) {
            Bundle bundleA = nx3.a(bundle);
            if (nx3.b(bundleA, "androidx.lifecycle.BundlableSavedStateRegistry.key")) {
                bundleC = nx3.c(bundleA, "androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
        }
        this.f = bundleC;
        this.g = true;
    }

    public final void h(Bundle bundle) {
        i73[] i73VarArr;
        bundle.getClass();
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
        Bundle bundleA2 = xx3.a(bundleA);
        Bundle bundle2 = this.f;
        if (bundle2 != null) {
            xx3.b(bundleA2, bundle2);
        }
        synchronized (this.c) {
            try {
                for (Map.Entry entry2 : this.d.entrySet()) {
                    xx3.c(bundleA2, (String) entry2.getKey(), ((qx3.b) entry2.getValue()).a());
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (nx3.f(nx3.a(bundleA))) {
            return;
        }
        xx3.c(xx3.a(bundle), "androidx.lifecycle.BundlableSavedStateRegistry.key", bundleA);
    }

    public final void i(String str, qx3.b bVar) {
        str.getClass();
        bVar.getClass();
        synchronized (this.c) {
            if (this.d.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            this.d.put(str, bVar);
            fw4 fw4Var = fw4.a;
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
