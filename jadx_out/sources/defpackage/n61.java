package defpackage;

import android.util.Log;
import androidx.lifecycle.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n61 extends c45 {
    public static final x.c i = new a();
    public final boolean e;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements x.c {
        @Override // androidx.lifecycle.x.c
        public c45 a(Class cls) {
            return new n61(true);
        }
    }

    public n61(boolean z) {
        this.e = z;
    }

    public static n61 k(k45 k45Var) {
        return (n61) new x(k45Var, i).b(n61.class);
    }

    @Override // defpackage.c45
    public void d() {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    public void e(p51 p51Var) {
        if (this.h) {
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.containsKey(p51Var.k)) {
                return;
            }
            this.b.put(p51Var.k, p51Var);
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + p51Var);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n61.class == obj.getClass()) {
            n61 n61Var = (n61) obj;
            if (this.b.equals(n61Var.b) && this.c.equals(n61Var.c) && this.d.equals(n61Var.d)) {
                return true;
            }
        }
        return false;
    }

    public void f(p51 p51Var) {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + p51Var);
        }
        h(p51Var.k);
    }

    public void g(String str) {
        if (k61.K0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        h(str);
    }

    public final void h(String str) {
        n61 n61Var = (n61) this.c.get(str);
        if (n61Var != null) {
            n61Var.d();
            this.c.remove(str);
        }
        k45 k45Var = (k45) this.d.get(str);
        if (k45Var != null) {
            k45Var.a();
            this.d.remove(str);
        }
    }

    public int hashCode() {
        return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public p51 i(String str) {
        return (p51) this.b.get(str);
    }

    public n61 j(p51 p51Var) {
        n61 n61Var = (n61) this.c.get(p51Var.k);
        if (n61Var != null) {
            return n61Var;
        }
        n61 n61Var2 = new n61(this.e);
        this.c.put(p51Var.k, n61Var2);
        return n61Var2;
    }

    public Collection l() {
        return new ArrayList(this.b.values());
    }

    public k45 m(p51 p51Var) {
        k45 k45Var = (k45) this.d.get(p51Var.k);
        if (k45Var != null) {
            return k45Var;
        }
        k45 k45Var2 = new k45();
        this.d.put(p51Var.k, k45Var2);
        return k45Var2;
    }

    public boolean n() {
        return this.f;
    }

    public void o(p51 p51Var) {
        if (this.h) {
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.remove(p51Var.k) == null || !k61.K0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + p51Var);
        }
    }

    public void p(boolean z) {
        this.h = z;
    }

    public boolean q(p51 p51Var) {
        if (this.b.containsKey(p51Var.k)) {
            return this.e ? this.f : !this.g;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
